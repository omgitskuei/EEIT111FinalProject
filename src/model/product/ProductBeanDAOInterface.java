package model.product;

import java.util.List;

public interface ProductBeanDAOInterface {
	
	public List <ProductBean> selectAll();
	
	public void insertProduct(ProductBean theProduct);
	
	public ProductBean getProduct(int productID);
	
	public void deleteProduct(int productID);
}
