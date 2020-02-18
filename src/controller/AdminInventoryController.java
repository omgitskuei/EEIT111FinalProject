package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.product.ProductBean;
import model.product.ProductBeanDAO;
import model.product.ProductBeanService;

@Controller
@RequestMapping(value = "/AdminProduct", method = RequestMethod.GET)
@SessionAttributes(names = {"userEmail"})
public class AdminInventoryController {

	@Autowired
	ProductBeanService productService;
	
	public AdminInventoryController() {
	}
	
	// 1)導到AdminInventory頁面，並傳庫存資料產生表格
	// 2)已完成
	// 3)Thomas
	@RequestMapping(value = "/inventories", method = RequestMethod.GET)
	public String showForm(@SessionAttribute("userEmail") String uEmail, Model model) {
		System.out.println("Directing to AdminInventory");
		List<ProductBean> Inventorylist=productService.selectAll();
		model.addAttribute("InventoryList", Inventorylist);
		return "AdminInventory";
	}

//	// URL address for this controller, method POST/GET, what data fields
//	@RequestMapping(path = "/controller.AdminInventoryController", method = RequestMethod.POST)
//	public String processAction(@SessionAttribute("userEmail") String uEmail, Model nextPage) {
//		
//		List<ProductBean> list= dao.selectAll();
//		nextPage.addAttribute("list",list);
//		System.out.println("Directing to AdminInventory");
////		nextPage.addAttribute("userEmail", uEmail);
//		return "AdminInventory";
//	}



}
