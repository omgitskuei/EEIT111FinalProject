package model.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import model.orderDetails.OrderDetailsBean;

@Entity
@Table(name = "OrdersTable")
@Component
public class OrderBean {
	// Local Variables
	private int orderID;		// Not NULL
	private int userID;		// Not NULL
	private int total;		// Not NULL
	private String mailingAddress;		// Not NULL
	private String mailingPhone;		// Not NULL
	private Date orderTime;		// Not NULL
	//OneToMany
	private Set<OrderDetailsBean> orderDetailsBeans = new HashSet<OrderDetailsBean>();
                
	// Constructors
	public OrderBean() {
	}

	public OrderBean(int newUserID, int newTotal, String newMailingAddress, String newMailingPhone, Date newOrderTime) {
		this.userID = newUserID;
		this.total = newTotal;
		this.mailingAddress = newMailingAddress;
		this.mailingPhone = newMailingPhone;
		this.orderTime = newOrderTime;
	}

	// Getter/Setters
	@Id
	@Column(name = "OrderID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int newOrderID) {
		this.orderID = newOrderID;
	}

	@Column(name = "UserID")
	public int getUserID() {
		return userID;
	}

	public void setUserID(int newUserID) {
		this.userID = newUserID;
	}

	@Column(name = "Total")
	public int getTotal() {
		return total;
	}

	public void setTotal(int newTotal) {
		this.total = newTotal;
	}

	@Column(name = "MailingAddress")
	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String newMailingAddress) {
		this.mailingAddress = newMailingAddress;
	}

	@Column(name = "MailingPhone")
	public String getMailingPhone() {
		return mailingPhone;
	}

	public void setMailingPhone(String newMailingPhone) {
		this.mailingPhone = newMailingPhone;
	}

	@Column(name = "OrderTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date newOrderTime) {
		this.orderTime = newOrderTime;
	}

	// One-To-Many
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderBean", cascade = CascadeType.ALL)
	public Set<OrderDetailsBean> getOrderDetailsBeans() {
		return orderDetailsBeans;
	}

	public void setOrderDetailsBeans(Set<OrderDetailsBean> orderDetailsBeans) {
		this.orderDetailsBeans = orderDetailsBeans;
	}
		
}