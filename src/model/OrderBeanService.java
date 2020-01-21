package model;

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

	// Test validity of OrderBean user input
	// Validity means making sure values make sense
	public boolean insert(OrderBean insertThisBean) {
		System.out.println("BEGIN: OrderBeanService.insert(OrderBean oDAO)");
		// Local variables
		boolean success = false;
		String address = insertThisBean.getMailingAddress();
		String phone = insertThisBean.getMailingPhone();
		// Validate input values
		if (validateAddress(address) && validatePhone(phone)) {
			oDAO.insertOrder(insertThisBean);
		}
		System.out.println("FINISH: OrderBeanService.insert(OrderBean oDAO)");
		return success;
	}
	
	public boolean updateAddress(OrderBean thisBean) {
		boolean success = false;
		if (validateAddress(thisBean.getMailingAddress())) {
			success = true;
			oDAO.updateMailingAddress(thisBean, thisBean.getMailingAddress());
		} else {
			System.out.println("Update failed");
		}
		return success;
	}
	
	public boolean updatePhone(OrderBean thisBean) {
		boolean success = false;
		if (validatePhone(thisBean.getMailingPhone())) {
			success = true;
			oDAO.updateMailingPhone(thisBean, thisBean.getMailingPhone());
		} else {
			System.out.println("Update failed");
		}
		return success;
	}

	private static boolean validateAddress(String thisAddress) {
		boolean valid = false;
		try {
			CheckSubstring util = new CheckSubstring();
			int countSpec = util.countSpecialCharacters(thisAddress);
			if(countSpec >1) {
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