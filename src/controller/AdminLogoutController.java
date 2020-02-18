//package controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttribute;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@SessionAttributes(names = {"userEmail"})
//public class AdminLogoutController {
//
//	@Autowired
//	public AdminLogoutController() {
//	
//	}
//	
//	// 1)回首頁
//	// 2)已完成
//	// 3)Thomas
//	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
//	public String processActionLogout(@SessionAttribute("userEmail") String uEmail, Model nextPage) {
//		System.out.println("Directing to 首頁");
//		nextPage.addAttribute("userEmail", uEmail);
//		return "AdminIndex";
//	}
//	
//	
//	// 1)停用Session，並登出
//	// 2)已完成
//	// 3)Thomas
//	// Closes session when user logs out
//	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
//	    public ModelAndView loadApp(HttpServletRequest request) {
//	        HttpSession session= request.getSession(false);
//	        SecurityContextHolder.clearContext();
//	        if(session != null) {
//	            session.invalidate();
//	            System.out.println("Invalid Session!!!");
//	        }
//
//	        return new ModelAndView("/AdminLogin");
//	    }
//
//
//}
