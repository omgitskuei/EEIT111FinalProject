package model.wallet;

import java.util.ArrayList;
import java.util.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.CheckSubstring;

@Service
public class WalletBeanService {
	// Variables: Local Fields
	private WalletBeanDAO wDAO;
	
	// Constructors
	@Autowired
	public WalletBeanService(WalletBeanDAO wDAO) {
		this.wDAO = wDAO;
	}
	
	public boolean insert(WalletBean thisBean) {
		return wDAO.insertWallet(thisBean);
	}
	public boolean delete(WalletBean thisBean) {
		return wDAO.deleteWallet(thisBean);
	}
	public WalletBean select(WalletBean thisBean) {
		return wDAO.selectWallet(thisBean);
	}
	public WalletBean selectUser(int userID) {
		return wDAO.selectWallet(userID);
	}
	
	// Test validity* of Wallet amount changes
	// Validity means checking user input for proper $ money values
	public boolean updateAmount(WalletBean updateThisWallet, float newwalletAmount) {
		System.out.println("BEGIN: WalletBeanService.insert(WalletBean thisWallet)");
		// Local variables
		boolean success = false;
		// Validate Money before updating amount
		if ( validateMoney( newwalletAmount) ) {
			wDAO.updateWalletAmount(updateThisWallet,  newwalletAmount);
		}
		System.out.println("FINISH: WalletBeanService.insert(WalletBean thisWallet)");
		return success;
	}
	
	// Private Validation Methods
	// Money values that make sense only come in 2 demical points
	private static boolean validateMoney(float thisMoney) {
		boolean success = false;
		try {
			System.out.println("BEGIN: WalletBeanService.validateMoney(float)");
			// Get an instance of the local Currency
			Currency localCurrency = Currency.getInstance("TWD");
			// Get how many decimals are allowed for this Currency
			int validCurrencyDecimals = localCurrency.getDefaultFractionDigits();  //equals =2 for TWD
			// Check if the user input has at most this amount of decimals
			String thisMoneyString = Float.toString(thisMoney);
			// Get the length of the substring after the "."
			CheckSubstring util = new CheckSubstring();
			ArrayList<String> delimitedThisMoney = util.delimitAtDot(thisMoneyString);
			// If user entered a number with <= the number of digits allowed, success = TRUE
			if (validCurrencyDecimals <= delimitedThisMoney.get(1).length()) {
				System.out.println("VALID WALLET AMOUNT");
				success = true;
			} else {
				System.out.println("ERROR: INVALID MONEY AMOUNT");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("FINISH: WalletBeanService.validateMoney(float)");
		return success;
	}


}
