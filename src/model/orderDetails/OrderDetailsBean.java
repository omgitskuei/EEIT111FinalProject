package model.orderDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import model.order.OrderBean;

// match table
@Entity
@Table(name = "OrderDetailsTable")
@Component
public class OrderDetailsBean {

	// variables, match the column
	private int orderDetailID; // Not NULL
	private OrderBean orderBean; // ManyToOne
	private int productID; // Not NULL
	private String ProductName;
	private int productCount; // Not NULL
	private float ProductPrice;
	private int OrderID;

	// Empty Constructor and Constructor
	public OrderDetailsBean() {
	}

	public OrderDetailsBean(int OrderID,OrderBean orderBean, int productID, String ProductName, int productCount,
			float ProductPrice) {
		this.orderBean = orderBean;
		this.productID = productID;
		this.ProductName = ProductName;
		this.productCount = productCount;
		this.ProductPrice = ProductPrice;
		this.OrderID = OrderID;
	}

	// GET/SET methods
	@Id
	@Column(name = "OrderDetailID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderID")
	public OrderBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(OrderBean thisBean) {
		this.orderBean = thisBean;
	}
//	@Column(name = "OrderID")
	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	@Column(name = "ProductID")
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@Column(name = "ProductName")
	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	@Column(name = "ProductCount")
	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	@Column(name = "ProductPrice")
	public float getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(float productPrice) {
		this.ProductPrice = productPrice;
	}

}
