package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

// SessionAttributes應該還要抓資料庫的庫存欄位名稱導到JSP當標題
@Controller
@SessionAttributes(names = {"userEmail"})
public class AdminDetailController {

	@Autowired
	public AdminDetailController() {
		
	}
	

	// 1)導到詳細修改庫存資料，但目前被拿掉，無用處跟其他人確認後可刪
	// 2)寫完了
	// 3)Thomas
	@RequestMapping(path = "/controller.AdminInventoryDetailController", method = RequestMethod.POST)
	public String proccessActionInventoryDetail(@SessionAttribute("userEmail") String uEmail) {
		System.out.println("Directing to InventoryDetail");
		return "AdminInventoryDetail";
	}
	// 1)導到詳細修改訂單資料，但目前被拿掉，無用處跟其他人確認後可刪
	// 2)寫完了
	// 3)Thomas
	@RequestMapping(path = "/controller.AdminOrderDetailController", method = RequestMethod.POST)
	public String proccessActionOrderDetail(@SessionAttribute("userEmail") String uEmail) {
		System.out.println("Directing to OrderDetail");
		return "AdminOrderDetail";
	}
	
}
