package model.orderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Service
//@WebServlet("/orderDetails/orderDetails.do")
@Controller
@RequestMapping("/orderDetails/orderDetails.do")
public class OrderDetailsBeanService {
	// Variables: Local Fields
	private OrderDetailsBeanDAO odDAO;

	// Constructors
	@Autowired
	public OrderDetailsBeanService(OrderDetailsBeanDAO odDAO) {
		this.odDAO = odDAO;
	}

	// Test validity of OrderDetailsBean user input
	public boolean insert(OrderDetailsBean thisBean) {
		return odDAO.insertOrderDetails(thisBean);
	}

	public OrderDetailsBean select(OrderDetailsBean thisBean) {
		return odDAO.selectOrderDetails(thisBean);
	}

	public boolean delete(OrderDetailsBean thisBean) {
		return odDAO.deleteOrderDetails(thisBean);
	}
}
