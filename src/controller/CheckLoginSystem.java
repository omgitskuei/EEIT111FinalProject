package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Account;
import model.AccountService;

@Controller
@SessionAttributes(names = {"user", "pwd", "errors"})
public class CheckLoginSystem {

	private AccountService service;

	@Autowired
	public CheckLoginSystem(AccountService service) {
		this.service = service;
	}
	
	@RequestMapping(path="/checkLogin.controller", method = RequestMethod.POST)
	public String processAction(@RequestParam(name = "username") String username, 
			                    @RequestParam(name = "userpwd") String userpwd,
			                    Model m) {
		
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(username==null || username.length()==0) {
			errors.put("emailError", "Email is required");
		}
		
		if(userpwd==null || userpwd.length()==0) {
			errors.put("pwdError", "Password is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "loginSystem";
		}
		
		m.addAttribute("user", username);
		m.addAttribute("pwd", userpwd);
		
		boolean accountStatus = service.checkLogin(new Account(username, userpwd));
		
		if(accountStatus) {
			return "loginSuccess";
		}		
		
		//m.addAttribute("checkUser" + accountStatus);
		
		errors.put("msgErrors", "username or password is not correct");
		return "loginSystem";
	}

}







