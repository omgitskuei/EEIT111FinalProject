package model.setting;

public interface SettingBeanDAOInterface {
	// An abstract list of all must-have methods for ProductBeanDAO; CRUD
	// C.reate
	public boolean insertSetting(SettingBean insertThisSetting);
	// R.ead
	public SettingBean selectSetting(SettingBean selectThisSetting);
	// U.pdate
	public boolean updateSettingSecurityQ(SettingBean updateThisSetting, String newSettingSecurityQ);
	public boolean updateSettingSecurityA(SettingBean updateThisSetting, String newSettingSecurityA);
	public boolean updateSettingDisplayName(SettingBean updateThisSetting, String newSettingDisplayName);
	public boolean updateSettingAllowMetadata(SettingBean updateThisSetting, boolean newSettingAllowMetadata);
	// D.elete
	public boolean deleteSetting(SettingBean deleteThisSetting);
}
