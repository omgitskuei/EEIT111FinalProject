package model.order;

public interface OrderBeanDAOInterface {
	//Create
	public boolean insertOrder(OrderBean insertThisOrder);
	//Read
	public OrderBean selectOrder(OrderBean selectThisOrder);
	//Update
	public boolean updateTotal(OrderBean updateThisOrder, int newTotal);
	public boolean updateMailingAddress(OrderBean updateThisOrder, String newMailingAddress);
	public boolean updateMailingPhone(OrderBean updateThisOrder, String newMailingPhone);
	//Delete
	public boolean deleteOrder(OrderBean deleteThisOrder);
	public OrderBean getOrder(int orderID);
}
