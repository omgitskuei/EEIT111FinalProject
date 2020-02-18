package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Members;
import model.order.OrderBean;
import model.order.OrderBeanDAO;

@Controller
@SessionAttributes(names = {"userEmail"})
public class AdminOrderController {

	@Autowired
	OrderBeanDAO dao;
	
	public AdminOrderController() {
	}

	// 1)導到訂單並產生資料
	// 2)已完成
	// 3)Thomas
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String showForm(@SessionAttribute("userEmail") String uEmail, Model model) {
		System.out.println("Directing to AdminOrder");
//		nextPage.addAttribute("userEmail", uEmail);
		List<OrderBean> orderList=dao.selectAll();
		model.addAttribute("orderList", orderList);
		return "AdminOrder";
	}

}
