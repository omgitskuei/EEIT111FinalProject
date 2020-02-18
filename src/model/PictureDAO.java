package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PictureDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public PictureDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Picture insert(Picture bean) {
		Session session = sessionFactory.getCurrentSession();
		if(bean!=null) {
			session.save(bean);
		}
		return bean;
	}

}