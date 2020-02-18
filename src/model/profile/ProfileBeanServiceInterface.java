package model.profile;

import java.util.List;

public interface ProfileBeanServiceInterface {
	
	public List <ProfileBean> getProfiles();

	public void saveProfile(ProfileBean theProfile);
	
	public void updateProfile(ProfileBean theProfile);
	
	public ProfileBean getProfile(int userId);
	
	public void deleteProfile(int userId);

}
