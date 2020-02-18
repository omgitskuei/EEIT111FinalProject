package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.user.UserBean;
import model.user.UserBeanService;

@Controller
@SessionAttributes(names = { "userEmail", "userPwd", "rememberMe" })
public class UserLoginController {

	// Local fields
	private UserBeanService service;
	private HttpServletResponse response;

	// Constructors
	@Autowired
	public UserLoginController(UserBeanService service, HttpServletResponse response) {
		this.service = service;
		this.response = response;
	}

	// Methods
	// Methods > User sign up account
	@RequestMapping(path = "/signUp", method = RequestMethod.POST)
	public String signUp(@RequestParam(name = "userEmail") String uEmail, @RequestParam(name = "userPwd") String uPwd,
			@RequestParam(name = "rememberMe", required = false, defaultValue = "false") boolean remMe,
			@CookieValue(value = "Email", required = false, defaultValue = "user@domain.com") String cEmail,
			@CookieValue(value = "Password", required = false, defaultValue = "Testing123!") String cPwd,
			Model nextPage) {

		System.out.println("BEGIN /controller.AdminLoginController");
		System.out.println("User input: ");
		System.out.println("Email = " + uEmail);
		System.out.println("Password = " + uPwd);
		System.out.println("Remember Me = " + remMe);

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

	// User forgot password

	// User sign in account

}
