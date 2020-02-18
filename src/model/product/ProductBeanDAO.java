package model.product;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductBeanDAO implements ProductBeanDAOInterface {

	// Local fields
	@Autowired
	private SessionFactory sessionFactory;

	// This is aka INSERT, SAVE
	@Override
	public void insertProduct(ProductBean theProduct) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theProduct);
	}

	public boolean updateProductName(ProductBean updateThisProduct, String newProductName) {
		// Get current Session
		System.out.println(
				"Begin: ProductBeanDAO.updateProductName(ProductBean updateThisProduct, String newProductName)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisProduct is null
		if (updateThisProduct != null) {
			// Try to find updateThisProduct
			ProductBean existingProduct = session.get(ProductBean.class, updateThisProduct.getProductID());
			if (existingProduct != null) {
				// If found, update ProductName and return True
				String oldProductName = existingProduct.getProductName();
				existingProduct.setProductName(newProductName);
				System.out.println(
						"Product Name updated from " + oldProductName + " to " + existingProduct.getProductName());
				System.out.println("Finish: ProductBeanDAO.updateProductName(ProductBean, String)");
				return true;
			}
		}
		// Return False because 1) updateThisProduct was null OR 2) existingProduct was
		// null
		System.out.println(
				"Finish: ProductBeanDAO.updateProductName(ProductBean updateThisProduct, String newProductName)");
		return false;
	}

	public boolean updateProductPrice(ProductBean updateThisProduct, float newProductPrice) {
		// Get current Session
		System.out.println(
				"Begin: ProductBeanDAO.updateProductPrice(ProductBean updateThisProduct, int newProductPrice)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisProduct is null
		if (updateThisProduct != null) {
			// Try to find updateThisProduct
			ProductBean existingProduct = session.get(ProductBean.class, updateThisProduct.getProductID());
			if (existingProduct != null) {
				// If found, update ProductPrice and return True
				float oldProductPrice = existingProduct.getProductPrice();
				existingProduct.setProductPrice(newProductPrice);
				System.out.println(
						"Product Price updated from " + oldProductPrice + " to " + existingProduct.getProductPrice());
				System.out.println("Finish: ProductBeanDAO.updateProductPrice(ProductBean, int)");
				return true;
			}
		}
		// Return False because 1) updateThisProduct was null OR 2) existingProduct was
		// null
		System.out.println(
				"Finish: ProductBeanDAO.updateProductPrice(ProductBean updateThisProduct, int newProductPrice)");
		return false;
	}

	public boolean updateProductStock(ProductBean updateThisProduct, int newProductStock) {
		// Get current Session
		System.out.println(
				"Begin: ProductBeanDAO.updateProductStock(ProductBean updateThisProduct, int newProductStock)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisProduct is null
		if (updateThisProduct != null) {
			// Try to find updateThisProduct
			ProductBean existingProduct = session.get(ProductBean.class, updateThisProduct.getProductID());
			if (existingProduct != null) {
				// If found, update ProductStock and return True
				int oldProductStock = existingProduct.getProductStock();
				existingProduct.setProductStock(newProductStock);
				System.out.println(
						"Product Stock updated from " + oldProductStock + " to " + existingProduct.getProductStock());
				System.out.println("Finish: ProductBeanDAO.updateProductStock(ProductBean, int)");
				return true;
			}
		}
		// Return False because 1) updateThisProduct was null OR 2) existingProduct was
		// null
		System.out.println(
				"Finish: ProductBeanDAO.updateProductStock(ProductBean updateThisProduct, int newProductStock/)");
		return false;
	}

	public boolean updateProductDescription(ProductBean updateThisProduct, String newProductDescription) {
		// Get current Session
		System.out.println(
				"Begin: ProductBeanDAO.updateProductDescription(ProductBean updateThisProduct, String newProductDescription)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisProduct is null
		if (updateThisProduct != null) {
			// Try to find updateThisProduct
			ProductBean existingProduct = session.get(ProductBean.class, updateThisProduct.getProductID());
			if (existingProduct != null) {
				// If found, update ProductDescription and return True
				String oldProductDescription = existingProduct.getProductDescription();
				existingProduct.setProductDescription(newProductDescription);
				System.out.println("Product Description updated from:");
				System.out.println(oldProductDescription);
				System.out.println("to");
				System.out.println(existingProduct.getProductDescription());
				System.out.println("Finish: ProductBeanDAO.updateProductDescription(ProductBean, String)");
				return true;
			}
		}
		// Return False because 1) updateThisProduct was null OR 2) existingProduct was
		// null
		System.out.println(
				"Finish: ProductBeanDAO.updateProductDescription(ProductBean updateThisProduct, String newProductDescription)");
		return false;
	}

	public boolean updateProductImg(ProductBean updateThisProduct, byte[] newProductImg) {
		// Get current Session
		System.out
				.println("Begin: ProductBeanDAO.updateProductImg(ProductBean updateThisProduct, byte[] newProductImg)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisProduct is null
		if (updateThisProduct != null) {
			// Try to find updateThisProduct
			ProductBean existingProduct = session.get(ProductBean.class, updateThisProduct.getProductID());
			if (existingProduct != null) {
				// If found, update ProductImg and return True
				byte[] oldProductImg = existingProduct.getProductImg();
				existingProduct.setProductImg(newProductImg);
				System.out.println("Product img updated!");
				System.out.println("Finish: ProductBeanDAO.updateProductImg(ProductBean, byte[])");
				return true;
			}
		}
		// Return False because 1) updateThisProduct was null OR 2) existingProduct was
		// null
		System.out.println(
				"Finish: ProductBeanDAO.updateProductImg(ProductBean updateThisProduct, byte[] newProductImg)");
		return false;
	}

	public boolean updateProductTimestamp(ProductBean updateThisProduct, Date newProductTimestamp) {
		// Get current Session
		System.out.println(
				"Begin: ProductBeanDAO.updateProductTimestamp(ProductBean updateThisProduct, DATE newProductTimestamp)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisProduct is null
		if (updateThisProduct != null) {
			// Try to find updateThisProduct
			ProductBean existingProduct = session.get(ProductBean.class, updateThisProduct.getProductID());
			if (existingProduct != null) {
				// If found, update ProductTimestamp and return True
				Date oldProductTimestamp = existingProduct.getProductTimestamp();
				existingProduct.setProductTimestamp(newProductTimestamp);
				System.out.println("Finish: ProductBeanDAO.updateProductTimestamp(ProductBean, DATE)");
				return true;
			}
		}
		// Return False because 1) updateThisProduct was null OR 2) existingProduct was
		// null
		System.out.println(
				"Finish: ProductBeanDAO.updateProductTimestamp(ProductBean updateThisProduct, byte[] newProductTimestamp)");
		return false;
	}

	public boolean updateProductCategory(ProductBean updateThisProduct, String newProductCategory) {
		// Get current Session
		System.out.println(
				"Begin: ProductBeanDAO.updateProductCategory(ProductBean updateThisProduct, String newProductCategory)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisProduct is null
		if (updateThisProduct != null) {
			// Try to find updateThisProduct
			ProductBean existingProduct = session.get(ProductBean.class, updateThisProduct.getProductID());
			if (existingProduct != null) {
				// If found, update ProductCategory and return True
				String oldCategory = existingProduct.getProductCategory();
				existingProduct.setProductCategory(newProductCategory);
				System.out.println("Product category updated from "+oldCategory+" to "+existingProduct.getProductCategory());
				System.out.println("Finish: ProductBeanDAO.updateProductCategory(ProductBean, String)");
				return true;
			}
		}
		// Return False because 1) updateThisProduct was null OR 2) existingProduct was
		// null
		System.out.println(
				"Finish: ProductBeanDAO.updateProductCategory(ProductBean updateThisProduct, String newProductCategory)");
		return false;
	}

	@Override
	public ProductBean getProduct(int productID) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProductBean theProduct = currentSession.get(ProductBean.class, productID);
		return theProduct;
	}

	public ProductBean getProduct(ProductBean beanWithID) {
		Session currentSession = sessionFactory.getCurrentSession();
		int productID = beanWithID.getProductID();
		ProductBean theProduct = currentSession.get(ProductBean.class, productID);
		return theProduct;
	}

	@SuppressWarnings("rawtypes")
	public ProductBean getProduct(String productName) {
		Session session = sessionFactory.getCurrentSession();
		String hqlString = "from ProductBean where ProductName=:thisProductName";
		Query q = session.createQuery(hqlString);
		q.setParameter("thisProductName", productName);
		ProductBean existingProduct = (ProductBean) q.uniqueResult();
		if (existingProduct == null) {
			System.out.println("No results found");
		}
		return existingProduct;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ProductBean> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> cq = cb.createQuery(ProductBean.class);
		Root<ProductBean> root = cq.from(ProductBean.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductBean> selectAllByCategory(ProductBean beanWithCategory) {
		System.out.println("Begin: ProductBeanDAO.selectAllByCategory()");
		Session session = sessionFactory.getCurrentSession();
		// Get all rows from ProductTable
		Query query = session.createQuery("From ProductBean where ProductCategory=:thisProductCategory"); // This 'From'
																											// references
																											// ProductBean.java
		query.setParameter("thisProductCategory", beanWithCategory.getProductCategory());
		// Store query results into List results
		List<ProductBean> results = (List<ProductBean>) query.list();
		System.out.println("# of results: " + results.size());
		// Return List results
		System.out.println("Finish: ProductBeanDAO.selectAllByCategory()");
		return results;
	}

	@Override
	public void deleteProduct(int productID) {
		Session session = sessionFactory.getCurrentSession();
		ProductBean book = session.byId(ProductBean.class).load(productID);
		session.delete(book);

	}

}
