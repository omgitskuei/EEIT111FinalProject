package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.product.ProductBean;
import model.product.ProductBeanDAO;
//1)利用商品種類名稱或是商品名稱進行搜尋
//2)已完成
//3)Chris, Alex
@Controller
@SessionAttributes(names = { "searchSpecificValue" ,"searchCategoryValue"})
public class FindUniqueProductController {
	// Local fields
	ProductBeanDAO pDAO;

	// Constructors
	@Autowired
	public FindUniqueProductController(ProductBeanDAO pDAO) {
		this.pDAO = pDAO;
	}

	// Methods
	@RequestMapping(path = "/controller.FindProductByName", method = RequestMethod.POST)
	public String processAction(@RequestParam(name = "searchSpecificValue") String input, Model nextPage) {
		System.out.println("BEGIN: /controller.FindProductByName");
		// New object declarations
		ProductBeanDAO thisDAO = new ProductBeanDAO();
		ProductBean thisBean = new ProductBean();
		// Convert user input from last page into object
		// Give object to DAO, DAO give me result
		thisBean = thisDAO.getProduct(input);
		// result returned, get values from object
		// img
		System.out.println("thisBean"+thisBean);
		System.out.println("input"+input);
		
		byte[] productImage=thisBean.getProductImg();
		nextPage.addAttribute("resultImg", productImage);
		// name
		nextPage.addAttribute("resultName", thisBean.getProductName());
		System.out.println("productName: "+thisBean.getProductName());
		// price
		nextPage.addAttribute("resultPrice", thisBean.getProductPrice());
		// description
		nextPage.addAttribute("resultDescription", thisBean.getProductDescription());

		System.out.println("Directing to Product");
		return "AdminInventory";
	}

	@RequestMapping(path = "/controller.FindProductByCategory", method = RequestMethod.GET)
	public String processAction(@RequestParam(name = "searchCategoryValue") Model nextPage, String input) {
		// New object declarations
		ProductBeanDAO thisDAO = new ProductBeanDAO();
		ProductBean thisBean = new ProductBean();
		// Convert user input from last page into object
		// Give object to DAO, DAO give me result
		thisBean.setProductCategory(input);
		List<ProductBean> categoryList = thisDAO.selectAllByCategory(thisBean);
		// result returned, get values from object
		// img
		nextPage.addAttribute("resultImg", thisBean.getProductImg());
		// name
		nextPage.addAttribute("resultName", thisBean.getProductName());
		// price
		nextPage.addAttribute("resultPrice", thisBean.getProductPrice());
		// 在下一頁顯示所找到的該類別
		nextPage.addAttribute(categoryList);

		System.out.println("Directing to Product");
		return "ProductCategory";
	}
}
