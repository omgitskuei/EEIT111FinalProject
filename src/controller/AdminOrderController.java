package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"userEmail"})
public class AdminOrderController {

	@Autowired
	public AdminOrderController() {
	}

	// URL address for this controller, method POST/GET, what data fields
	@RequestMapping(path = "/controller.AdminOrderController", method = RequestMethod.POST)
	public String processAction(@SessionAttribute("userEmail") String uEmail, Model nextPage) {
		System.out.println("Directing to AdminOrder");
//		nextPage.addAttribute("userEmail", uEmail);
		return "AdminOrder";
	}



}