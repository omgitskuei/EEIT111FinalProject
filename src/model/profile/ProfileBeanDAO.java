package model.profile;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileBeanDAO implements ProfileBeanDAOInterface {

	// Local fields
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveProfile(ProfileBean theProfile) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theProfile);
		System.out.println("ProfileBean Inserted:");
		System.out.println("	address"+theProfile.getProfileAddress());
		System.out.println("	bday"+theProfile.getProfileBirthdate());
		System.out.println("	fullname"+theProfile.getProfileFullName());
		System.out.println("	joinDate"+theProfile.getProfileJoinDate());
		System.out.println("	phone"+theProfile.getProfilePhone());
		System.out.println("	sex"+theProfile.getProfileSex());
		System.out.println("	vip"+theProfile.getProfileVIP());
		//System.out.println("	userBean"+theProfile.getUserBean());
		System.out.println("	userID"+theProfile.getUserID());
	}
	
	@Override
	public void updateProfile(ProfileBean theProfile) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(theProfile);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ProfileBean> getProfiles() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From ProfileBean");
		List<ProfileBean> results = (List<ProfileBean>) query.list();
		return results;
	}
	
	@Override
	public ProfileBean getProfile(int userID) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProfileBean theProfile = currentSession.get(ProfileBean.class, userID);
		return theProfile;
	}
	
	public ProfileBean getProfile(ProfileBean thisP) {
		Session currentSession = sessionFactory.getCurrentSession();
		int userID = thisP.getUserID();
		ProfileBean theProfile = currentSession.get(ProfileBean.class, userID);
		return theProfile;
	}

	@Override
	public void deleteProfile(int userID) {
		Session session = sessionFactory.getCurrentSession();
		ProfileBean theProfile = session.byId(ProfileBean.class).load(userID);
		session.delete(theProfile);

	}

}
