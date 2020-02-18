package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.order.OrderBean;
import model.order.OrderBeanDAO;
import model.orderDetails.OrderDetailsBean;
import model.orderDetails.OrderDetailsBeanDAO;
import model.user.UserBeanDAO;

//1)控制訂單管理明細顯示
//2)寫完了
//3)忠城寫的
@Controller
@SessionAttributes(names = {"userEmail"})
public class OrderDetailsListController {

	@Autowired
	OrderDetailsBeanDAO odDAO;
	
	@Autowired
	OrderBeanDAO oDAO;
	
	@Autowired
	UserBeanDAO uDAO;
	
	public OrderDetailsListController() {
	}
	
	@RequestMapping(value = "/orderDetails", method = RequestMethod.GET)
	public String showForm(@SessionAttribute("userEmail") String uEmail, Model model, @RequestParam("orderID")int OrderID ) {
		
		//user
		int userID = uDAO.selectUserIDByEmail(uEmail);
		List<OrderBean> detailsList2=oDAO.selectOrdersByUserID(userID);
		model.addAttribute("detailsList2", detailsList2);
		//顯示Order部分
		List<OrderBean> orderToDetailsList=oDAO.selectByOrderID(OrderID);
		model.addAttribute("orderToDetailsList", orderToDetailsList);
		//顯示OrderDetails部分
		List<OrderDetailsBean> detailsList=odDAO.selectAllByOrderID(OrderID);
		model.addAttribute("detailsList", detailsList);

		return "OrderDetailsList";
	}
}
