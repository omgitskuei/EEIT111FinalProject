package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsBeanService {
	// Variables: Local Fields
	private OrderDetailsBeanDAO odDAO;
	
	// Constructors
	@Autowired
	public OrderDetailsBeanService(OrderDetailsBeanDAO odDAO) {
		this.odDAO = odDAO;
	}
}
