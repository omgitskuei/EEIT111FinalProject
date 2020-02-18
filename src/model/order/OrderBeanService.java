package model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.CheckSubstring;

@Service
public class OrderBeanService {
	// Variables: Local Fields
	private OrderBeanDAO oDAO;

	// Constructors
	@Autowired
	public OrderBeanService(OrderBeanDAO oDAO) {
		this.oDAO = oDAO;
	}
	
	
	public List<OrderBean> selectAll() {
		return oDAO.selectAll();
	}

	public void saveOrder(OrderBean insertThisOrder) {
		oDAO.insertOrder(insertThisOrder);
	}
	
	public OrderBean getOrder(int orderID) {
		return oDAO.getOrder(orderID);
	}

	// Test validity of OrderBean user input
	// Validity means making sure values make sense
	public boolean insert(OrderBean insertThisBean) {
		System.out.println("BEGIN: OrderBeanService.insert(OrderBean)");
		// Local variables
		boolean success = false;
		String address = insertThisBean.getMailingAddress();
		String phone = insertThisBean.getMailingPhone();
		// Validate input values
		if (validateAddress(address) && validatePhone(phone)) {
			oDAO.insertOrder(insertThisBean);
			System.out.println("Insert successful");
		} else {
			System.out.println("Insert failed");
		}
		System.out.println("FINISH: OrderBeanService.insert(OrderBean)");
		return success;
	}
	
	public boolean updateAddress(OrderBean thisBean) {
		System.out.println("BEGIN: OrderBeanService.updateAddress(OrderBean)");
		boolean success = false;
		if (validateAddress(thisBean.getMailingAddress())) {
			success = true;
			oDAO.updateMailingAddress(thisBean, thisBean.getMailingAddress());
			System.out.println("Update successful");
		} else {
			System.out.println("Update failed");
		}
		System.out.println("FINISH: OrderBeanService.updateAddress(OrderBean)");
		return success;
	}
	
	public boolean updatePhone(OrderBean thisBean) {
		System.out.println("BEGIN: OrderBeanService.updatePhone(OrderBean)");
		boolean success = false;
		if (validatePhone(thisBean.getMailingPhone())) {
			success = true;
			oDAO.updateMailingPhone(thisBean, thisBean.getMailingPhone());
			System.out.println("Update successful");
		} else {
			System.out.println("Update failed");
		}
		System.out.println("BEGIN: OrderBeanService.updatePhone(OrderBean)");
		return success;
	}

	private static boolean validateAddress(String thisAddress) {
		boolean valid = false;
		try {			
			if(thisAddress.length()>1) {
				valid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

	private static boolean validatePhone(String thisPhone) {
		boolean valid = false;
		try {
			CheckSubstring util = new CheckSubstring();
			// All letters must be numbers
			if (util.countNums(thisPhone)==thisPhone.length()) {
				valid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

}