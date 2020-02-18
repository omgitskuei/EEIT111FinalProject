package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	private AccountDAO aDao;
	
	@Autowired
	public AccountService(AccountDAO aDao) {
		this.aDao = aDao;
	}
	
	public boolean checkLogin(Account users) {
		return aDao.checkLogin(users);
	}

}
