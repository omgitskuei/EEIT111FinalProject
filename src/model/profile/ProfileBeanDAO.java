package model.profile;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileBeanDAO implements ProfileBeanDAOInterface {

	// Local fields
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ProfileBean> getProfiles() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ProfileBean> cq = cb.createQuery(ProfileBean.class);
		Root<ProfileBean> root = cq.from(ProfileBean.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveProfile(ProfileBean theProfile) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theProfile);
	}

	@Override
	public ProfileBean getProfile(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProfileBean theProfile = currentSession.get(ProfileBean.class, userId);
		return theProfile;
	}

	@Override
	public void deleteProfile(int userId) {
		Session session = sessionFactory.getCurrentSession();
		ProfileBean book = session.byId(ProfileBean.class).load(userId);
		session.delete(book);

	}

}
