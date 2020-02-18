package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.order.OrderBean;
import model.order.OrderBeanService;
import model.user.UserBeanService;
import model.wallet.WalletBean;
import model.wallet.WalletBeanService;

@Controller
@SessionAttributes(names= {"userEmail"})
public class CheckoutController {
	private UserBeanService uService;
	private OrderBeanService oService;
	private WalletBeanService wService;
	
	@Autowired
	public CheckoutController(UserBeanService uService, OrderBeanService oService, WalletBeanService wService) {
		this.uService = uService;
		this.oService = oService;
		this.wService = wService;
	}
	
	@RequestMapping(value="/selectSetting",method = RequestMethod.POST)    
	public String processActionPost(@SessionAttribute("userEmail") String email, Model nextPage) {
		int userID= uService.selectUserIDByEmail(email);
		
		WalletBean thisWallet = new WalletBean();
		
		thisWallet.setUserID(userID);
		wService.select(thisWallet);
		
		OrderBean insertThisBean = new OrderBean();
		
		insertThisBean.setUserID(userID);
		oService.insert(insertThisBean);
		//nextPage.addAllAttributes(ArrayList<String> s);
		return "redirect:/checkout";
	}
}