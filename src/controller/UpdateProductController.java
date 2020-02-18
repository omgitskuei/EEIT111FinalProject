package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.product.ProductBean;
import model.product.ProductBeanService;

//1)控制Product表單更新
//2)寫完了
//3)忠城寫的
@Controller
@SessionAttributes
@RequestMapping("/AdminProduct")
public class UpdateProductController {

	@Autowired
	private ProductBeanService productService;

	@GetMapping("/list")
	public String listProducts(Model m) {
		List<ProductBean> theProduct = productService.selectAll();
		m.addAttribute("product", theProduct);
		return "AdminInventory";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") @Valid ProductBean theProduct) {
		productService.saveProduct(theProduct);
		return "redirect:/AdminProduct/inventories";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("productID") int productID, Model m) {
		ProductBean theProduct = productService.getProduct(productID);
		m.addAttribute("product", theProduct);
		return "ProductAdding";
	}

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productID") int productID) {
		productService.deleteProduct(productID);
		return "redirect:/AdminProduct/inventories";
	}

}
