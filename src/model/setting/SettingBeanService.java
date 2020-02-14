package model.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.CheckSubstring;

@Service
public class SettingBeanService {
	// Variables: Local Fields
	private SettingBeanDAO sDAO;

	// Constructors
	@Autowired
	public SettingBeanService(SettingBeanDAO sDAO) {
		this.sDAO = sDAO;
	}

	// Test validity of SettingBean user input
	// Validity means making sure values make sense
	public boolean insert(SettingBean insertThisBean) {
		System.out.println("BEGIN: SettingBeanService.insert(SettingBean)");
		// Local variables
		boolean success = false;
		
		String displayName = insertThisBean.getSettingDisplayName();
		// Validate input values
		if (validateDisplayName(displayName)) {
			success = true;
			sDAO.insertSetting(insertThisBean);
		}
		System.out.println("FINISH: SettingBeanService.insert(SettingBean)");
		return success;
	}
	public SettingBean select(SettingBean selectThisSetting) {
		return sDAO.selectSetting(selectThisSetting);
	}
	public boolean updateDisplayName(SettingBean updateThisBean) {
		System.out.println("BEGIN: SettingBeanService.updateDisplayName(SettingBean)");
		// Local variables
		boolean success = false;
		String newDisplayName = updateThisBean.getSettingDisplayName();
		// Validate input values
		if (validateDisplayName(newDisplayName)) {
			System.out.println("Valid Display Name");
			// See if bean exist before updating
			SettingBean result = sDAO.selectSetting(updateThisBean);
			if (result != null) {
				sDAO.updateSettingDisplayName(result, newDisplayName);
				success = true;
			}
		}
		System.out.println("FINISH: SettingBeanService.updateDisplayName(SettingBean)");
		return success;
	}
	
	public boolean updateSecuityQ(SettingBean updateThisBean) {
		System.out.println("BEGIN: SettingBeanService.updateSecuityQ(SettingBean)");
		// Local variables
		boolean success = false;
		
		String newSecurityQ = updateThisBean.getSettingSecurityQ();
		SettingBean result = sDAO.selectSetting(updateThisBean);
		if (result != null) {
			sDAO.updateSettingSecurityQ(result, newSecurityQ);
			success = true;
		}
		System.out.println("FINISH: SettingBeanService.updateSecuityQ(SettingBean)");
		return success;
	}
	
	public boolean updateSecuityA(SettingBean updateThisBean) {
		System.out.println("BEGIN: SettingBeanService.updateSecuityA(SettingBean)");
		// Local variables
		boolean success = false;
		
		String newSecurityA = updateThisBean.getSettingSecurityA();
		SettingBean result = sDAO.selectSetting(updateThisBean);
		if (result != null) {
			sDAO.updateSettingSecurityA(result, newSecurityA);
			success = true;
		}
		System.out.println("FINISH: SettingBeanService.updateSecuityA(SettingBean)");
		return success;
	}
	
	public boolean updateAllowMeta(SettingBean thisBean) {
		System.out.println("BEGIN: SettingBeanService.updateAllowMeta(SettingBean)");
		boolean success = false;
		// see if thisBean exists in DB
		SettingBean result = sDAO.selectSetting(thisBean);
		if (result != null) {
			sDAO.updateSettingAllowMetadata(result, thisBean.getSettingAllowMetadata());
		}
		System.out.println("FINISH: SettingBeanService.updateAllowMeta(SettingBean)");
		return success;
	}

	// Make sure Display Name doesn't have special Letters
	private static boolean validateDisplayName(String thisName) {
		boolean valid = false;
		try {
			// Count how many special characters, and DisplayName must be longer than 6 char
			CheckSubstring util = new CheckSubstring();
			int countSpec = util.countSpecialCharacters(thisName);
			if(countSpec==0) {
				valid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

}