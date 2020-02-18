package model.orderDetails;

public interface OrderDetailsBeanDAOInterface {
	// An abstract list of all must-have methods for UserBeanDAO; CRUD
	// C.reate
	public boolean insertOrderDetails(OrderDetailsBean insertThisOrderDetails);
	// R.ead
	public OrderDetailsBean selectOrderDetails(int orderID);
	public OrderDetailsBean selectOrderDetails(OrderDetailsBean thisBean);
	// U.pdate
	public boolean updateProductID(OrderDetailsBean updateThisOrderDetail, int newProductID);
	public boolean updateProductCount(OrderDetailsBean updateThisOrderDetail, int newProductCount);
	// D.elete
	public boolean deleteOrderDetails(OrderDetailsBean deteleThisOrderDetails);
}
