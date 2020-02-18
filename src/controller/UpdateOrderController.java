package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.order.OrderBean;
import model.order.OrderBeanService;

//1)控制Order表單更新
//2)寫完了
//3)忠城寫的
@Controller
@SessionAttributes
@RequestMapping("/AdminOrder")
public class UpdateOrderController {

	@Autowired
	private OrderBeanService orderService;

	@GetMapping("/list")
	public String listOrders(Model m) {
		List<OrderBean> theOrder = orderService.selectAll();
		m.addAttribute("order", theOrder);
		return "AdminViewAllUser";
	}

	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("order") @Valid OrderBean theOrder) {
		orderService.saveOrder(theOrder);
		return "redirect:/orders";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("orderID") int orderID, Model m) {
		OrderBean theOrder = orderService.getOrder(orderID);
		m.addAttribute("order", theOrder);
		return "OrderAdding";
	}

//	@GetMapping("/delete")
//	public String deleteOrder(@RequestParam("orderID") int orderID) {
//		orderService.deleteOrder(orderID);
//		return "redirect:/AdminOrder/list";
//	}

}
