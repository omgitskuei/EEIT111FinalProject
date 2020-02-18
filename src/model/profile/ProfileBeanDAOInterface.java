package model.profile;

import java.util.List;

public interface ProfileBeanDAOInterface {
	
	public List <ProfileBean> getProfiles();
	
	public void saveProfile(ProfileBean theProfile);
	
	public ProfileBean getProfile(int userID);
	
	public void deleteProfile(int userID);

	public void updateProfile(ProfileBean theProfile);
}
