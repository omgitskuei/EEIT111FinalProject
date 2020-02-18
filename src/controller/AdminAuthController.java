package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import model.profile.ProfileBeanService;
import model.setting.SettingBeanService;
import model.user.UserBean;
import model.user.UserBeanService;
import model.wallet.WalletBeanService;
import util.EmailUsers;
import util.EncodeHexString;
import util.EncryptString;
import util.GetCode;

// 1)登入
// 2)製造Cookie
// 3)登出
// 4)回首頁
// 5)註冊1
// 6)註冊2
@Controller
@SessionAttributes(names = { "userEmail", "userPwd", "rememberMe", "nEmail", "nPwd", "rPwd" })
public class AdminAuthController {

	private UserBeanService service;
	private HttpServletResponse response;
	private SettingBeanService sService;
	private WalletBeanService wService;
	private ProfileBeanService pService;
	private String verificationCode = "";

	@Autowired
	public AdminAuthController(UserBeanService service, HttpServletResponse response, SettingBeanService sService, 
			WalletBeanService wService, ProfileBeanService pService) {
		this.service = service;
		this.response = response;
		this.sService = sService;
		this.wService = wService;
		this.pService = pService;
		this.response = response;
	}

	// 1)登入功能，並製造Cookie
	// 2)還沒處理回來解碼Cookie的到Input資料欄位裡面
	// 3)Chris, Thomas
	// URL address for this controller, method POST/GET, what data fields
	@RequestMapping(path = "/controller.AdminLoginController", method = RequestMethod.POST)
	public String login(@RequestParam(name = "userEmail") String uEmail,
			@RequestParam(name = "userPwd") String uPwd,
			@RequestParam(name = "rememberMe", required = false, defaultValue = "false") boolean remMe,
			@CookieValue(value = "Email", required = false, defaultValue = "user@domain.com") String cEmail,
			@CookieValue(value = "Password", required = false, defaultValue = "Testing123!") String cPwd,
			Model nextPage) {

		System.out.println("BEGIN /controller.AdminLoginController");
		System.out.println("User input: ");
		System.out.println("Email = " + uEmail);
		System.out.println("Password = " + uPwd);
		System.out.println("Remember Me = " + remMe);
		System.out.println("");

		// Check for empty input
		if ((uEmail != null) && (uPwd.length() >= 8 && uPwd != null)) {
			UserBean bean = new UserBean();
			// readLoginCookie(cEmail);
			if (cEmail != null && cPwd != null) {
				bean.setUserEmail(uEmail);
				bean.setUserPwd(uPwd);
				bean.setAdmin(1);
				System.out.println("有抓到Cookie");
				System.out.println(cEmail);
				System.out.println(cPwd);
			} else {

				// Turn user input into a persistence bean
				bean.setUserEmail(uEmail);
				bean.setUserPwd(uPwd);
				bean.setAdmin(1);
			}
			// Write a Cookie storing email so user don't need to enter email next time
			// *CURRENTLY INCOMPLETE*
			if (remMe == true) {
				System.out.println("MAKING COOKIE");
				writeLoginCookie(bean, bean, nextPage, response);
			}

			// Use bean to use UserBeanService service
			UserBean results = service.checkLogin(bean);
			System.out.println("Service.select(bean) RESULTS: ");
			if (results == null || results.getUserID() == 0) {
				// Match not found
				// If match NOT found, return to previous page AdminLogin
				System.out.println("USER NOT FOUND: Returning to AdminLogin");
				Map<String, String> errors = new HashMap<String, String>();
				errors.put("notFoundError", "Incorrect Email or Password");
				nextPage.addAttribute("errors", errors);
				return "AdminLogin";
			} else {
				// If match found, return
				// EEIT111FinalProject/WebContent/WEB-INF/pages/AdminDashboard
				System.out.println("Class = " + results.getClass());
				System.out.println("User ID = " + results.getUserID());
				System.out.println("Email = " + results.getUserEmail());
				System.out.println("Password = " + results.getUserPwd());
				System.out.println("Admin = " + results.getAdmin());
				System.out.println("");

				System.out.println("AUTHENTICATED: Directing to AdminIndex");
				nextPage.addAttribute("userEmail", uEmail);
				nextPage.addAttribute("loggedInUserEmail", uEmail);
				nextPage.addAttribute("loggedInUserPwd", uPwd);
				return "AdminIndex";
			}
		}
		// One of the User's input is empty, return to previous page with error messages
		else {
			System.out.println("USER INPUT INVALID: Returning to AdminLogin");
			Map<String, String> errors = new HashMap<String, String>();
			if (uEmail == null || uEmail.length() == 0) {
				errors.put("emailError", "Email is required");
			}

			if (uPwd == null || uPwd.length() < 8) {
				errors.put("pwdError", "Password is too short");
				if (uPwd == null || uPwd.length() == 0) {
					errors.put("pwdError", "Password is required");
				}
			}

			nextPage.addAttribute("errors", errors);
			return "AdminLogin";
		}
	}

	// 1)製造Cookie
	// 2)寫完了，唯一問題為這麽確保加密用的AssociatedData，但又不寫死（暫時是"OMGiloveyou"）
	// 3)Chris
	@RequestMapping("/writeAdminLoginCookie")
	private String writeLoginCookie(
			@CookieValue(name = "Email", required = false, defaultValue = "user@domain.com") UserBean user1,
			@CookieValue(name = "Password", required = false, defaultValue = "Testing123!") UserBean user2,
			Model nextPage, HttpServletResponse response) {
		// ^ name is synonymous to 'value'
		// response.addCookie(new Cookie("adminLoginCookie", email));

		// Encrypt email before writing to cookie
		String email = user1.getUserEmail();
		EncryptString util1 = new EncryptString();
		byte[] cipher = util1.encryptGoogleTinkAEAD(email, "OMGiloveyou");
		EncodeHexString hexConvert = new EncodeHexString();
		email = hexConvert.byteArrayToHexString(cipher);
		// Write encrypted email cookie
		Cookie ck = new Cookie("Email", email);
		System.out.println("email: " + user1.getUserEmail());
		System.out.println("cookie email(encrypted): " + email);

		// Encrypt pwd before writing cookie
		String pwd = user2.getUserPwd();
		cipher = util1.encryptGoogleTinkAEAD(email, "OMGiloveyou");
		email = hexConvert.byteArrayToHexString(cipher);
		// Write encrypted pwd cookie
		Cookie pw = new Cookie("Password", pwd);
		System.out.println("pwd: " + user2.getUserPwd());
		System.out.println("cookie pwd(encrpyted): " + pwd);

		// ck.setMaxAge(60*60*24);
		// ck.setPath("/");
		response.addCookie(ck);
		response.addCookie(pw);
		System.out.println("有抓Cookie");

		return "writeLoginCookie";
	}
	
	// 1)回首頁
	// 2)已完成
	// 3)Thomas
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String reload(@SessionAttribute("userEmail") String uEmail, Model nextPage) {
		System.out.println("Directing to 首頁");
		nextPage.addAttribute("userEmail", uEmail);
		return "AdminIndex";
	}
	
	// 1)停用Session，並登出
	// 2)已完成
	// 3)Thomas
	// Closes session when user logs out
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		if (session != null) {
			session.invalidate();
			System.out.println("Invalid Session!!!");
		}

		return new ModelAndView("/AdminLogin");
	}
	
	// 註冊第一段
	// Admin attempts to sign up. If credentials Don't match, prepare to create new
	// admin; must enter secret confirm code.
	@RequestMapping(path = "/controller.AdminSignUpController", method = RequestMethod.POST)
	public String signInStep1(@RequestParam(name = "nEmail") String nEmail, @RequestParam(name = "nPwd") String nPwd,
			@RequestParam(name = "rPwd") String cPwd, Model nextPage) {

		System.out.println("BEGIN /controller.AdminSignUpController");
		System.out.println("User input: ");
		System.out.println("Email = " + nEmail);
		System.out.println("Password = " + nPwd);
		System.out.println("Confirm Password = " + cPwd);
		if (cPwd.equals(nPwd)) {
			System.out.println("Confirm Password and New Password match!");
			try {
				System.out.println("User not found");

				nextPage.addAttribute("nEmail", nEmail);
				nextPage.addAttribute("nPwd", nPwd);

				System.out.println("AUTHENTICATED: Directing to AdminLoginConfirm");
				// Make code
				GetCode genCode = new GetCode(10, true, false, false);
				verificationCode = genCode.generateCode();
				// Make code available on next page
				nextPage.addAttribute("verificationCode", verificationCode);
				// Send 
				EmailUsers emailSender = new EmailUsers();
				emailSender.sendVerifyEmail(nEmail, nEmail, verificationCode);
				// 
				return "AdminLoginConfirm";
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ERROR: AdminSignUpController EXCEPTION");
				return "AdminLogin";
			}
		}
		System.out.println("Re-enter Password != New Password, return AdminLogin");
		return "AdminLogin";
	}
	
	
	

}
