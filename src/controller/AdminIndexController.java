package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes()
public class AdminIndexController {

	@Autowired
	public AdminIndexController() {
	}

	// 1)這個應該沒用了，再請確認一下
	// 2)已完成
	// 3)Thomas
	@RequestMapping(path = "/controller.AdminIndexController", method = RequestMethod.POST)
	public String processAction( Model nextPage) {
		System.out.println("Directing to Adminindex");
		return "AdminIndex";
	}



}
