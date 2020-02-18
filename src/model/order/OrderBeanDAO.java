package model.order;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class OrderBeanDAO implements OrderBeanDAOInterface {

	// Local Fields
	private SessionFactory sessionFactory;

	// Constructors
	@Autowired
	public OrderBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// CRUD Methods
	@Override
	public boolean insertOrder(OrderBean insertThisOrder) {
		// Create new Session
		System.out.println("BEGIN: OrderBeanDAO.insertOrder(OrderBean insertOrderBean)");
		Session session = sessionFactory.getCurrentSession();

		if (insertThisOrder != null) {
			System.out.println("insertThisOrder!=null");

			session.saveOrUpdate(insertThisOrder);
			System.out.println("OrderBean inserted:");
			System.out.println("orderTotal:" + insertThisOrder.getTotal());
			System.out.println("orderMailingAddress:" + insertThisOrder.getMailingAddress());
			System.out.println("orderMailingPhone:" + insertThisOrder.getMailingPhone());
			System.out.println("orderOrderTime:" + insertThisOrder.getOrderTime());

			return true;
		}
		System.out.println("ERROR: insert OrderBean FAILED; OrderBean insertThisOrder==null");
		System.out.println("FINISH: OrderBeanDAO.insertOrder(OrderBean insertThisOrder)");
		return false;
	}

	@Override
	public OrderBean selectOrder(OrderBean selectThisOrder) {
		System.out.println("BEGIN: OrderBeanDAO.selectOrder(OrderBean selectThisOrder)");

		try {
			if (selectThisOrder != null) {
				System.out.println("Looking for this order: ");
				System.out.println("OrderID:" + selectThisOrder.getOrderID());
				System.out.println("orderUserID:" + selectThisOrder.getUserID());
				System.out.println("orderTotal:" + selectThisOrder.getTotal());
				System.out.println("orderMailingAddress:" + selectThisOrder.getMailingAddress());
				System.out.println("orderMailingPhone:" + selectThisOrder.getMailingPhone());
				System.out.println("OrderTime:" + selectThisOrder.getOrderTime());
				
				Session session = sessionFactory.getCurrentSession();
				// Hibernate Query Language 
				String hqlString = "FROM OrderBean WHERE UserID=:thisID AND Total=thisTotal";
				Query q = session.createQuery(hqlString);
				q.setParameter("thisID", selectThisOrder.getUserID());
				q.setParameter("thisTotal", selectThisOrder.getTotal());
				OrderBean existingOrder = (OrderBean) q.uniqueResult();

				if (existingOrder != null) {
					System.out.println("Order found: OrderID " + existingOrder.getOrderID() + ", Total "
							+ existingOrder.getTotal());
					System.out.println("FINISH: OrderBeanDAO.selectOrder(OrderBean selectThisOrder)");
					return existingOrder;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("FINISH: OrderBeanDAO.selectOrder(OrderBean selectThisOrder)");
		return null;
	}

	public List<OrderBean> selectAll() {
		System.out.println("BEGIN: OrderBeanDAO.selectAll()");
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("From OrderBean");

		List<OrderBean> results = (List<OrderBean>) query.list();

		System.out.println("selectAll:" + results.get(0).getClass());
		for (int index = 0; index < results.size(); index++) {
			System.out.println(results.get(index).getOrderID());
			System.out.println(results.get(index).getUserID());
			System.out.println(results.get(index).getTotal());
			System.out.println(results.get(index).getMailingAddress());
			System.out.println(results.get(index).getMailingPhone());
			System.out.println(results.get(index).getOrderTime());
		}
		System.out.println("FINISH: OrderBeanDAO.selectAll()");
		return results;
	}
	
	public List<OrderBean> selectOrdersByUserID(int userID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From OrderBean where UserID=:thisUserID");
		query.setParameter("thisUserID", userID);
		List<OrderBean> results = (List<OrderBean>) query.list();
		return results;
	}
	
	public List<OrderBean> selectByOrderID(int orderID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From OrderBean where OrderID=:thisOrderID");
		query.setParameter("thisOrderID", orderID);
		List<OrderBean> results = (List<OrderBean>) query.list();
		return results;
	}
	
	@Override
	public boolean updateTotal(OrderBean updateThisOrder, int newTotal) {
		System.out.println("BEGIN: OrderBeanDAO.updateTotal(OrderBean updateThisOrder, int newTotal)");
		Session session = sessionFactory.getCurrentSession();
		if (updateThisOrder != null) {
			OrderBean existingOrder = session.get(OrderBean.class, updateThisOrder.getOrderID());
			if (existingOrder != null) {
				int oldTotal = existingOrder.getTotal();
				existingOrder.setTotal(newTotal);
				System.out.println("Order Total updated from " + oldTotal + " to " + existingOrder.getTotal());
				System.out.println("FINISH: OrderBeanDAO.updateTotal(OrderBean updateThisOrder, int newTotal)");
				return true;
			}
		}
		System.out.println("FINISH: OrderBeanDAO.updateTotal(OrderBean updateThisOrder, int newTotal)");
		return false;
	}

	@Override
	public boolean updateMailingAddress(OrderBean updateThisOrder, String newMailingAddress) {
		System.out.println(
				"BEGIN: OrderBeanDAO.updateMailingAddress(OrderBean updateThisOrder, String newMailingAddress)");
		Session session = sessionFactory.getCurrentSession();
		if (updateThisOrder != null) {
			OrderBean existingOrder = session.get(OrderBean.class, updateThisOrder.getMailingAddress());
			if (existingOrder != null) {
				String oldMailingAddress = existingOrder.getMailingAddress();
				existingOrder.setMailingAddress(newMailingAddress);
				System.out.println("Order Mailing Address updated from " + oldMailingAddress + " to "
						+ existingOrder.getMailingAddress());
				System.out.println(
						"FINISH: OrderBeanDAO.updateMailingAddress(OrderBean updateThisOrder, String newMailingAddress)");
				return true;
			}
		}
		System.out.println(
				"FINISH: OrderBeanDAO.updateMailingAddress(OrderBean updateThisOrder, String newMailingAddress)");
		return false;
	}

	@Override
	public boolean updateMailingPhone(OrderBean updateThisOrder, String newMailingPhone) {
		System.out.println("BEGIN: OrderBeanDAO.updateMailingPhone(OrderBean updateThisOrder, String newMailingPhone)");
		Session session = sessionFactory.getCurrentSession();
		if (updateThisOrder != null) {
			OrderBean existingOrder = session.get(OrderBean.class, updateThisOrder.getMailingPhone());
			if (existingOrder != null) {
				String oldMailingPhone = existingOrder.getMailingPhone();
				existingOrder.setMailingPhone(newMailingPhone);
				System.out.println("Order Mailing Phone number Updated to " + oldMailingPhone + " to "
						+ existingOrder.getMailingPhone());
				System.out.println(
						"FINISH: OrderBeanDAO.updateMailingPhone(OrderBean updateThisOrder, String newMailingPhone)");
				return true;
			}
		}
		System.out
				.println("FINISH: OrderBeanDAO.updateMailingPhone(OrderBean updateThisOrder, String newMailingPhone)");
		return false;
	}

	@Override
	public boolean deleteOrder(OrderBean deleteThisOrder) {
		System.out.println("BEGIN: OrderBeanDAO.deleteOrder(OrderBean deleteThisOrder)");
		Session session = sessionFactory.getCurrentSession();
		if (deleteThisOrder != null) {
			OrderBean existingOrder = session.get(OrderBean.class, deleteThisOrder.getClass());
			if (existingOrder != null) {
				int deleteOrderID = existingOrder.getOrderID();
				int deleteUserID = existingOrder.getUserID();
				int deleteTotal = existingOrder.getTotal();
				String deleteMailingAddress = existingOrder.getMailingAddress();
				String deleteMailingPhone = existingOrder.getMailingPhone();
				Date deleteOrderTime = existingOrder.getOrderTime();

				session.delete(existingOrder);
				System.out.println("Order DELETED:");
				System.out.println("OrderID" + deleteOrderID);
				System.out.println("UserID: " + deleteUserID);
				System.out.println("Total: " + deleteTotal);
				System.out.println("MailingAddress: " + deleteMailingAddress);
				System.out.println("MailingPhone: " + deleteMailingPhone);
				System.out.println("DeleteOrderTime: " + deleteOrderTime);
				System.out.println("FINISH: OrderBeanDAO.deleteOrder(OrderBean deleteThisOrder)");
				return true;
			}
		}
		System.out.println("FINISH: OrderBeanDAO.deleteOrder(OrderBean deleteThisOrder)");
		return false;
	}
	@Override
	public OrderBean getOrder(int orderID) {
		Session currentSession = sessionFactory.getCurrentSession();
		OrderBean theOrder = currentSession.get(OrderBean.class, orderID);
		return theOrder;
	}
	
	public OrderBean getOrder(OrderBean beanWithID) {
		Session currentSession = sessionFactory.getCurrentSession();
		int orderID = beanWithID.getOrderID();
		OrderBean theOrder = currentSession.get(OrderBean.class, orderID);
		return theOrder;
	}

}
