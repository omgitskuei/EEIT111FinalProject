package model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBeanService implements ProductBeanServiceInterface {
	
	@Autowired
	private ProductBeanDAO productDAO;
	
	@Override
	public List<ProductBean> selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public void saveProduct(ProductBean theProduct) {
		productDAO.insertProduct(theProduct);
	}
	
	public boolean updateProductName(ProductBean thisProduct, String newProductName) {
		return productDAO.updateProductName(thisProduct, newProductName);
	}

	@Override
	public ProductBean getProduct(int productID) {
		return productDAO.getProduct(productID);
	}

	@Override
	public void deleteProduct(int productID) {
		productDAO.deleteProduct(productID);
	}

}
