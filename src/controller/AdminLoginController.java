//package controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.google.crypto.tink.Aead;
//
//import model.user.UserBean;
//import model.user.UserBeanService;
//import util.EncodeHexString;
//import util.EncryptString;
//
//@Controller
//@SessionAttributes(names = { "userEmail", "userPwd", "rememberMe" })
//public class AdminLoginController {
//
//	private UserBeanService service;
//	private HttpServletResponse response;
//
//	@Autowired
//	public AdminLoginController(UserBeanService service, HttpServletResponse response) {
//		this.service = service;
//		this.response = response;
//	}
//
//	// 1)登入功能，並製造Cookie
//	// 2)還沒處理回來解碼Cookie的到Input資料欄位裡面
//	// 3)Chris, Thomas
//	// URL address for this controller, method POST/GET, what data fields
//	@RequestMapping(path = "/controller.AdminLoginController", method = RequestMethod.POST)
//	public String processAction(@RequestParam(name = "userEmail") String uEmail,
//			@RequestParam(name = "userPwd") String uPwd,
//			@RequestParam(name = "rememberMe", required = false, defaultValue = "false") boolean remMe,
//			@CookieValue(value = "Email", required = false, defaultValue = "user@domain.com") String cEmail,
//			@CookieValue(value = "Password", required = false, defaultValue = "Testing123!" ) String cPwd,
//			Model nextPage) {
//
//		System.out.println("BEGIN /controller.AdminLoginController");
//		System.out.println("User input: ");
//		System.out.println("Email = " + uEmail);
//		System.out.println("Password = " + uPwd);
//		System.out.println("Remember Me = " + remMe);
//		System.out.println("");
//		
//		// Check for empty input
//		if ( (uEmail != null) && (uPwd.length() >= 8 && uPwd != null)) {
//			UserBean bean = new UserBean();
//			//readLoginCookie(cEmail);
//			if(cEmail != null && cPwd != null) {
//				bean.setUserEmail(uEmail);
//				bean.setUserPwd(uPwd);
//				bean.setAdmin(1);
//				System.out.println("有抓到Cookie");
//				System.out.println(cEmail);
//				System.out.println(cPwd);
//			}else {
//			
//			// Turn user input into a persistence bean
//			bean.setUserEmail(uEmail);
//			bean.setUserPwd(uPwd);
//			bean.setAdmin(1);
//			}
//			// Write a Cookie storing email so user don't need to enter email next time    *CURRENTLY INCOMPLETE*
//			if (remMe == true) {
//				System.out.println("MAKING COOKIE");
//				writeLoginCookie(bean, bean, nextPage, response);	
//			}
//			
//			
//			// Use bean to use UserBeanService service
//			UserBean results = service.checkLogin(bean);
//			System.out.println("Service.select(bean) RESULTS: ");
//			if (results == null || results.getUserID()==0) {
//				// Match not found
//				// If match NOT found, return to previous page AdminLogin
//				System.out.println("USER NOT FOUND: Returning to AdminLogin");
//				Map<String, String> errors = new HashMap<String, String>();
//				errors.put("notFoundError", "Incorrect Email or Password");
//				nextPage.addAttribute("errors", errors);
//				return "AdminLogin";
//			} else {
//				// If match found, return
//				// EEIT111FinalProject/WebContent/WEB-INF/pages/AdminDashboard
//				System.out.println("Class = " + results.getClass());
//				System.out.println("User ID = " + results.getUserID());
//				System.out.println("Email = " + results.getUserEmail());
//				System.out.println("Password = " + results.getUserPwd());
//				System.out.println("Admin = " + results.getAdmin());
//				System.out.println("");
//
//				System.out.println("AUTHENTICATED: Directing to AdminIndex");
//				nextPage.addAttribute("userEmail", uEmail);
//				nextPage.addAttribute("loggedInUserEmail", uEmail);
//				nextPage.addAttribute("loggedInUserPwd", uPwd);
//				return "AdminIndex";
//			}
//		}
//		// One of the User's input is empty, return to previous page with error messages
//		else {
//			System.out.println("USER INPUT INVALID: Returning to AdminLogin");
//			Map<String, String> errors = new HashMap<String, String>();
//			if(uEmail==null || uEmail.length()==0) {
//				errors.put("emailError", "Email is required");
//			}
//			
//			if(uPwd==null || uPwd.length()<8) {
//				errors.put("pwdError", "Password is too short");
//				if(uPwd==null || uPwd.length()==0) {
//					errors.put("pwdError", "Password is required");
//				}
//			}
//			
//			nextPage.addAttribute("errors", errors);
//			return "AdminLogin";
//		}
//	}
//
//	// 1)製造Cookie
//	// 2)寫完了，唯一問題為這麽確保加密用的AssociatedData，但又不寫死（暫時是"OMGiloveyou"）
//	// 3)Chris
//	@RequestMapping("/writeAdminLoginCookie")
//	private String writeLoginCookie(
//			@CookieValue(name = "Email", required = false, defaultValue = "user@domain.com") UserBean user1,
//			@CookieValue(name = "Password", required = false, defaultValue = "Testing123!") UserBean user2,
//			Model nextPage, HttpServletResponse response) {
//		// ^ name is synonymous to 'value'
//		// response.addCookie(new Cookie("adminLoginCookie", email));
//		
//		// Encrypt email before writing to cookie
//		String email = user1.getUserEmail();
//		EncryptString util1 = new EncryptString();
//		Aead aead = util1.newCleartextAEADKeyset();
//		byte[] cipher = util1.encryptGoogleTinkAEAD(email, "OMGiloveyou");
//		EncodeHexString hexConvert = new EncodeHexString();
//		email = hexConvert.byteArrayToHexString(cipher);
//		// Write encrypted email cookie
//		Cookie ck = new Cookie("Email", email);
//		System.out.println("email: "+user1.getUserEmail());
//		System.out.println("cookie email(encrypted): "+email);
//		
//		// Encrypt pwd before writing cookie
//		String pwd = user2.getUserPwd();
//		cipher = util1.encryptGoogleTinkAEAD(email, "OMGiloveyou");
//		email = hexConvert.byteArrayToHexString(cipher);
//		// Write encrypted pwd cookie
//		Cookie pw = new Cookie("Password", pwd);
//		System.out.println("pwd: "+user2.getUserPwd());
//		System.out.println("cookie pwd(encrpyted): "+pwd);
//		
//		// ck.setMaxAge(60*60*24);
//		// ck.setPath("/");
//		response.addCookie(ck);
//		response.addCookie(pw);
//		System.out.println("有抓Cookie");
//		
//		return "writeLoginCookie";
//	}
//
////	@RequestMapping("/readAdminLoginCookie")
////	public String readLoginCookie(
////			@CookieValue(value = "Email", required = false, defaultValue = "user@domain.com") String loginEmail,
////			@CookieValue(name = "Password", required = false, defaultValue = "Testing123!") String loginPwd) {
////
////		return "readCookie";
////	}
//	
//
//
//
//}