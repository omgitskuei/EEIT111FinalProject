package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ProductsTable")
@Component
public class ProductBean {
	// Local Variables
	private int ProductID;
	private String ProductName;
	private float ProductPrice;
	private int ProductStock;
	private String ProductDescription;
	private byte[] ProductImg;
	private Date ProductTimestamp;
	private String ProductCategory;
	
	// Constructors
	public ProductBean() {
	}

	public ProductBean(String ProductName, float ProductPrice, int ProductStock, String ProductDescription,
			byte[] ProductImg, Date ProductTimestamp, String ProductCategory) {

		this.ProductName = ProductName;
		this.ProductPrice = ProductPrice;
		this.ProductStock = ProductStock;
		this.ProductDescription = ProductDescription;
		this.ProductImg = ProductImg;
		this.ProductTimestamp = ProductTimestamp;
		this.ProductCategory = ProductCategory;

	}

	// Getters / Setters
	@Id
	@Column(name = "ProductID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		this.ProductID = productID;
	}

	@Column(name = "ProductName")
	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	@Column(name = "ProductPrice")
	public float getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(float productPrice) {
		this.ProductPrice = productPrice;
	}

	@Column(name = "ProductStock")
	public int getProductStock() {
		return ProductStock;
	}

	public void setProductStock(int productStock) {
		this.ProductStock = productStock;
	}

	@Column(name = "ProductDescription")
	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		this.ProductDescription = productDescription;
	}

	@Column(name = "ProductImg")
	public byte[] getProductImg() {
		return ProductImg;
	}

	public void setProductImg(byte[] productImg) {
		this.ProductImg = productImg;
	}

	@Column(name = "ProductTimestamp")
	public Date getProductTimestamp() {
		return ProductTimestamp;
	}

	public void setProductTimestamp(Date productTimestamp) {
		this.ProductTimestamp = productTimestamp;
	}

	@Column(name = "ProductCategory")
	public String getProductCategory() {
		return ProductCategory;
	}

	public void setProductCategory(String productCategory) {
		this.ProductCategory = productCategory;
	}

}