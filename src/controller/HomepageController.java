package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes()
public class HomepageController {

	@Autowired
	public HomepageController() {
	}

	// URL address for this controller, method POST/GET, what data fields
	@RequestMapping(path = "/controller.HomepageController", method = RequestMethod.GET)
	public String processAction( ModelAndView nextPage) {
		System.out.println("Directing to Adminindex");
		return "AdminLogin";
	}



}
