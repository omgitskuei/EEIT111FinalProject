
package model.orderDetails;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.order.OrderBean;

@Repository
public class OrderDetailsBeanDAO implements OrderDetailsBeanDAOInterface {

	// Local Fields
	private SessionFactory sessionFactory;

	// Constructors
	@Autowired
	public OrderDetailsBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// CRUD Methods
	@Override
	public boolean insertOrderDetails(OrderDetailsBean insertThisOrderDetails) {
		// Create new Session
		System.out.println("BEGIN: OrdedrDetailsBean.insertOrderDetails(OrderDetailsBean)");
		Session session = sessionFactory.getCurrentSession();
		// Test if passed OrderDtailsBean is not empty
		if (insertThisOrderDetails != null) {
			System.out.println("insertThisOrderDatails != null");
			// Insert the passed OrderDetailsBean
			session.save(insertThisOrderDetails);
			// Console print results
			System.out.println("OrderDetailsBean Inserted: ");
			System.out.println("OrderDetailID: " + insertThisOrderDetails.getOrderDetailID());
			System.out.println("ProductID: " + insertThisOrderDetails.getProductID());
			System.out.println("ProductCount: " + insertThisOrderDetails.getProductCount());
			System.out.println("Linked OrderBean's OrderID:" + insertThisOrderDetails.getOrderBean().getOrderID());

			System.out.println("FINISH: OrderDetailsBeanDAO.insertOrderDetails(OrderDetailsBean)");
			// Return True, for SUCCESSFUL INSERT
			return true;
		} else {
			System.out.println("ERROR: Insert OrderDetailsBean FAILED; passed OrderdDetailsBean is null.");
			System.out.println("FINISH: OrderDetailsBeanDAO.insertOrderDetails(OrderDetailsBean)");
			// Return False, for FAILED INSERT
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public OrderDetailsBean selectOrderDetails(OrderBean orderID) {
		// Create new Session
		System.out.println("BEGIN: OrderDetailsBeanDAO.selectOrderDetails(OrderBean)");

		System.out.println("Looking for OrderDetail with Order ID:" + orderID);

		Session session = sessionFactory.getCurrentSession();
		String hqlString = "FROM OrderDetailsBean WHERE OrderID=thisOrderID";
		Query q = session.createQuery(hqlString);
		q.setParameter("thisOrderID", orderID);
		OrderDetailsBean existingOrderDetail = (OrderDetailsBean) q.uniqueResult();

		if (existingOrderDetail != null) {
			System.out.println("OrderDetailsBean Selected: ");
			System.out.println("OrderDetailID: " + existingOrderDetail.getOrderDetailID());
			System.out.println("ProductID: " + existingOrderDetail.getProductID());
			System.out.println("ProductCount: " + existingOrderDetail.getProductCount());
			System.out.println("Linked OrderBean's OrderID:" + existingOrderDetail.getOrderBean().getOrderID());
			System.out.println("FINISH: OrderDetailsBeanDAO.selectOrderDetails(OrderBean)");
			return existingOrderDetail;
		} else {
			System.out.println("ERROR: OrderDetails NOT FOUND, query returned NULL");
			System.out.println("FINISH: OrderDetailsBeanDAO.selectOrderDetails(OrderBean)");
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public OrderDetailsBean selectOrderDetails(OrderDetailsBean bean) {
		// Create new Session
		System.out.println("BEGIN: OrderDetailsBeanDAO.selectOrderDetails(OrderDetailsBean)");

		System.out.println("Looking for OrderDetail with Order ID:" + bean.getOrderBean().getOrderID());

		Session session = sessionFactory.getCurrentSession();
		String hqlString = "FROM OrderDetailBean WHERE OrderID=thisOrderID";
		Query q = session.createQuery(hqlString);
		q.setParameter("thisOrderID", bean.getOrderBean().getOrderID());
		OrderDetailsBean existingOrderDetail = (OrderDetailsBean) q.uniqueResult();

		if (existingOrderDetail != null) {
			System.out.println("OrderDetail found: ");
			System.out.println("OrderDetail ID: " + existingOrderDetail.getOrderDetailID());
			System.out.println("Product ID: " + existingOrderDetail.getProductID());
			System.out.println("Product Count: " + existingOrderDetail.getProductCount());
			System.out.println("Order ID: " + existingOrderDetail.getOrderBean().getOrderID());
			System.out.println("FINISH: OrderDetailsBeanDAO.selectOrderDetails(OrderDetailsBean)");
			return existingOrderDetail;
		} else {
			System.out.println("ERROR: OrderDetail NOT FOUND, query returned NULL");
			System.out.println("FINISH: OrderDetailsBeanDAO.selectOrderDetails(OrderDetailsBean)");
			return null;
		}

	}
//	select全部資料
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public List<OrderDetailsBean> selectAll() {
//		System.out.println("BEGIN: OrderDetailsBeanDAO.selectAll()");
//		Session session = sessionFactory.getCurrentSession();
//
//		Query query = session.createQuery("From OrderDetailsBean");
//
//		List<OrderDetailsBean> results = (List<OrderDetailsBean>) query.list();
//
//		System.out.println("selectAll:" + results.get(0).getClass());
//		System.out.println("Found Order Details results:");
//		for (int index = 0; index < results.size(); index++) {
//			System.out.println("#" + index);
//			System.out.println("OrderDetail ID: " + results.get(index).getOrderDetailID());
//			System.out.println("Product ID:     " + results.get(index).getProductID());
//			System.out.println("Product Count:  " + results.get(index).getProductCount());
//			System.out.println("Order ID:       " + results.get(index).getOrderBean().getOrderID());
//		}
//		System.out.println("FINISH: OrderDetailsBeanDAO.selectAll()");
//		return results;
//	}
	
//	//寫死orderID=2
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public List<OrderDetailsBean> selectAll2() {
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("From OrderDetailsBean where orderID=2");
//		List<OrderDetailsBean> results = (List<OrderDetailsBean>) query.list();
//		return results;
//	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<OrderDetailsBean> selectAllByOrderID(int orderID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From OrderDetailsBean where OrderID=:thisOrderID"); // This 'From'
																											
		query.setParameter("thisOrderID", orderID);
		List<OrderDetailsBean> results = (List<OrderDetailsBean>) query.list();
		return results;
	}

	@Override
	public boolean updateProductID(OrderDetailsBean updateThisOrderDetail, int newProductID) {
		// Get current Session
		System.out.println("BEGIN: OrderDetailsBeanDAO.updateProductID(OrderDetailsBean, int)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisOrderDetails is null
		if (updateThisOrderDetail != null) {
			// Try to find updateThisOrderDetails TODO this need to change HQL
			OrderDetailsBean existingOrderDetails = session.get(OrderDetailsBean.class,
					updateThisOrderDetail.getOrderDetailID());
			if (existingOrderDetails != null) {
				// If found, update ProductID and return
				int oldID = existingOrderDetails.getOrderDetailID();
				existingOrderDetails.setProductID(newProductID);
				System.out.println("Product ID UPDATED from " + oldID + " to " + existingOrderDetails.getProductID());
				System.out.println("FINISH: OrderDetailsBeanDAO.updateProductID(OrderDetailsBean, int)");
				return true;
			} else {
				System.out.println("ERROR: Bean NOT FOUND");
				System.out.println("FINISH: OrderDetalsBeanDAO.updateProductID(OrderDetailsBean, int)");
				return false;
			}
		} else {
			// Return False,passed bean empty
			System.out.println("ERROR: Passed OrderDetailsBean is NULL");
			System.out.println("FINISH: OrderDetailsBeanDAO.updateProductID(OrderDetailsIDBean, int)");
			return false;
		}
	}

	@Override
	public boolean updateProductCount(OrderDetailsBean updateThisOrderDetail, int newProductCount) {
		// Get current Session
		System.out.println("BEGIN: OrderDetailsBeanDAO.updateProductCount(OrderDetailsBean, int newProductCount)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisOrderDetails is null
		if (updateThisOrderDetail != null) {
			// Try to find updateThisProduct
			OrderDetailsBean existingOrderDetails = session.get(OrderDetailsBean.class,
					updateThisOrderDetail.getOrderDetailID());
			if (existingOrderDetails != null) {
				// If found, update ProductCount and return
				int oldCount = existingOrderDetails.getProductCount();
				existingOrderDetails.setProductCount(newProductCount);
				System.out.println(
						"Product Count UPDATED from " + oldCount + " to " + existingOrderDetails.getProductCount());
				System.out.println("FINISH: OrderDetailsBeanDAO.updateProductCount(OrderDetailsBean, int)");
				return true;
			} else {
				System.out.println("ERROR: Bean NOT FOUND");
				System.out.println("FINISH: OrderDetailsBeanDAO.updateProductCount(OrderDetailsBean, int)");
				return false;
			}
		} else {
			System.out.println("ERROR: Passed bean is NULL.");
			System.out.println("FINISH: OrderDetailsBeanDAO.updateProductCount(OrderDetailsBean, int)");
			return false;
		}
	}


	@Override
	public boolean deleteOrderDetails(OrderDetailsBean deteleThisOrderDetails) {
		System.out.println("BEGIN: OrderDetailsBeanDAO.deleteOrderDetails(OrderDetailsBean)");
		try {
			// GET current Session
			Session session = sessionFactory.getCurrentSession();
			// Check if deleteThisOrderDetails is null
			if (deteleThisOrderDetails != null) {
				// Try to find deleteThisOrderDetails
				OrderDetailsBean resultBean = session.get(OrderDetailsBean.class,
						deteleThisOrderDetails.getOrderDetailID());
				if (resultBean != null) {
					// If found, delete, return True
					int deletedOrderDetailID = resultBean.getOrderDetailID();
					int deletedProductID = resultBean.getProductID();
					int deletedProductCount = resultBean.getProductCount();
					int deletedOrderID = resultBean.getOrderBean().getOrderID();
					session.delete(resultBean);
					System.out.println("OrderDetails Successfully DELETED:");
					System.out.println("OrderDetail ID: " + deletedOrderDetailID);
					System.out.println("OrderDetail Product ID " + deletedProductID);
					System.out.println("OrderDetail Product count" + deletedProductCount);
					System.out.println("OrderDetail Order ID " + deletedOrderID);
					return true;
				} else {
					System.out.println("ERROR: OrderDetails NOT FOUND");
					System.out.println("FINISH: OrderDetailsBeanDAO.deleteOrderDetails(OrderDetailsBean)");
				}
			} else {
				System.out.println("ERROR: Passed OrderDetailsBean is NULL");
				System.out.println("FINISH: OrderDetailsBeanDAO.deleteOrderDetails(OrderDetailsBean)");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ERROR: Exception! See Console for details.");
		System.out.println("FINISH: OrderDetailsBeanDAO.deleteOrderDetails(OrderDetailsBean)");
		return false;
	}

	@Override
	public OrderDetailsBean selectOrderDetails(int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}

