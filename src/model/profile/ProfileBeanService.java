package model.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileBeanService implements ProfileBeanServiceInterface {
	
	@Autowired
	private ProfileBeanDAO profileDAO;
	
	@Override
	public List<ProfileBean> getProfiles() {
		return profileDAO.getProfiles();
	}

	@Override
	public void saveProfile(ProfileBean theProfile) {
		profileDAO.saveProfile(theProfile);
	}
	
	@Override
	public void updateProfile(ProfileBean theProfile) {
		profileDAO.updateProfile(theProfile);
	}

	@Override
	public ProfileBean getProfile(int userID) {
		return profileDAO.getProfile(userID);
	}

	@Override
	public void deleteProfile(int userID) {
		profileDAO.deleteProfile(userID);
	}

}
