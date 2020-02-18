package model.setting;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class SettingBeanDAO implements SettingBeanDAOInterface {
	// local variable
	private SessionFactory sessionFactory;

	@Autowired
	public SettingBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean insertSetting(SettingBean insertThisSetting) {
		System.out.println("BEGIN: SettingBeanDAO.insertSetting(SettingBean insertSettingBean)");
		Session session = sessionFactory.getCurrentSession();

		if (insertThisSetting != null) {
			System.out.println("insertThisSetting!=null");

			session.save(insertThisSetting);
			System.out.println("SettingBean inserted:");
			System.out.println("settingSecurityQ:" + insertThisSetting.getSettingSecurityQ());
			System.out.println("settingSecurityA:" + insertThisSetting.getSettingSecurityA());
			System.out.println("settingDisplayName:" + insertThisSetting.getSettingDisplayName());
			System.out.println("settingAllowMetadata:" + insertThisSetting.getSettingAllowMetadata());

			return true;
		}
		System.out.println("ERROR: insert SettingBean FAILED; SettingBean insertThisSetting==null");
		System.out.println("FINISH: SettingBeanDAO.insertSetting(SettingBean insertThisSetting)");
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public SettingBean selectSetting(SettingBean selectThisSetting) {
		System.out.println("BEGIN: SettingBeanDAO.selectSetting(SettingBean selectThisSetting)");

		if (selectThisSetting != null) {
			Session session = sessionFactory.getCurrentSession();
			// HQL
			String hqlString = "from SettingBean where userID=:thisUserID";
			Query q = session.createQuery(hqlString);
			q.setParameter("thisUserID", selectThisSetting.getUserID());

			SettingBean existingSetting = (SettingBean) q.uniqueResult();

			if (existingSetting != null) {
				System.out.println("SelectSetting Found, SettingID: " + existingSetting.getSettingID());
				System.out.println("FINISH: SettingBeanDAO.selectSetting(OrderBean selectThisSetting)");
				return existingSetting;
			}
		} else {
			System.out.println("SelectSetting Result NULL");
		}
		System.out.println("FINISH: SettingBeanDAO.selectSetting(OrderBean selectThisSetting)");
		return null;
	}

	@SuppressWarnings("rawtypes")
	public SettingBean selectSetting(int userID) {
		System.out.println("BEGIN: SettingBeanDAO.selectSetting(int userID)");
		Session session = sessionFactory.getCurrentSession();
		String hqlString = "from SettingBean where userID=:thisUserID";
		Query q = session.createQuery(hqlString);
		q.setParameter("thisUserID", userID);

		SettingBean existingSetting = (SettingBean) q.uniqueResult();

		if (existingSetting != null) {
			System.out.println("Setting FOUND, SettingID: " + existingSetting.getSettingID());
			System.out.println("FINISH: SettingBeanDAO.selectSetting(int userID)");
			return existingSetting;
		}
		System.out.println("FINISH: SettingBeanDAO.selectSetting(int userID)");
		return null;
	}

	@Override
	public boolean updateSettingSecurityQ(SettingBean updateThisSetting, String newQ) {
		System.out.println("BEGIN: OrderBeanDAO.updateSettingSecurityQ(SettingBean, String)");
		Session session = sessionFactory.getCurrentSession();

		SettingBean existingSetting = session.get(SettingBean.class, updateThisSetting.getSettingID());
		if (existingSetting != null) {
			String oldQ = existingSetting.getSettingSecurityQ();
			existingSetting.setSettingSecurityQ(newQ);
			System.out.println("Setting Security Q UPDATED from " + oldQ + " to " + newQ);
			System.out.println("FINISH: SettingBean.updateSettingSecurityQ(SettingBean, String)");
			return true;
		} else {
			System.out.println("ERROR: Update failed; SettingBean NOT FOUND");
			System.out.println("FINISH: SettingBean.updateSettingSecurityQ(SettingBean , String )");
			return false;
		}
	}

	@Override
	public boolean updateSettingSecurityA(SettingBean updateThisSetting, String newA) {
		System.out.println("BEGIN: SettingBeanDAO.updateSettingSecurityA(OrderBean, String)");
		Session session = sessionFactory.getCurrentSession();
		if (updateThisSetting != null) {
			SettingBean existingSetting = session.get(SettingBean.class, updateThisSetting.getSettingID());
			if (existingSetting != null) {
				String oldA = existingSetting.getSettingSecurityA();
				existingSetting.setSettingSecurityA(newA);
				System.out.println("Setting Security Answer UPDATED from " + oldA + " to " + newA);
				System.out.println("FINISH: SettingBean.updateSettingSecurityA(SettingBean, String)");
				return true;
			} else {
				System.out.println("ERROR: SettingBean NOT FOUND");
				System.out.println("FINISH: SettingBean.updateSettingSecurityA(SettingBean, String)");
				return false;
			}
		} else {
			System.out.println("ERROR: Passed SettingBean is NULL");
			System.out.println("FINISH: SettingBean.updateSettingSecurityA(SettingBean, String)");
			return false;
		}
	}

	@Override
	public boolean updateSettingDisplayName(SettingBean updateThisSetting, String newSettingDisplayName) {
		System.out.println("BEGIN: SettingBeanDAO.updateSettingDisplayName(SettingBean, String)");
		Session session = sessionFactory.getCurrentSession();
		if (updateThisSetting != null) {
			SettingBean existingSetting = session.get(SettingBean.class, updateThisSetting.getSettingID());
			if (existingSetting != null) {
				String oldName = existingSetting.getSettingDisplayName();
				existingSetting.setSettingDisplayName(newSettingDisplayName);
				System.out.println("Setting Display name UPDATED from " + oldName + " to " + newSettingDisplayName);
				System.out.println("FINISH: SettingBean.updateSettingDisplayName(SettingBean, String)");
				return true;
			} else {
				System.out.println("ERROR: SettingBean NOT FOUND");
				System.out.println("FINISH: SettingBean.updateSettingDisplayName(SettingBean, String)");
				return false;
			}
		} else {
			System.out.println("ERROR: Passed SettingBean is NULL");
			System.out.println("FINISH: SettingBean.updateSettingDisplayName(SettingBean, String)");
			return false;
		}
	}

	@Override
	public boolean updateSettingAllowMetadata(SettingBean updateThisSetting, boolean newSettingAllowMetadata) {
		System.out.println("BEGIN: SettingBeanDAO.updateSettingAllowMetadata(SettingBean, boolean)");
		Session session = sessionFactory.getCurrentSession();
		if (updateThisSetting != null) {
			SettingBean existingSetting = session.get(SettingBean.class, updateThisSetting.getSettingID());
			if (existingSetting != null) {
				boolean oldAllow = existingSetting.getSettingAllowMetadata();
				existingSetting.setSettingAllowMetadata(newSettingAllowMetadata);
				System.out.println("Setting AllowMetadata Updated from "+oldAllow+" to "+newSettingAllowMetadata);
				System.out.println("FINISH: SettingBean.updateSettingAllowMetadata(SettingBean, boolean)");
				return true;
			} else {
				System.out.println("ERROR: SettingBean NOT FOUND");
				System.out.println("FINISH: SettingBean.updateSettingAllowMetadata(SettingBean, boolean)");
				return false;
			}
		} else {
			System.out.println("ERROR: Passed SettingBean is NULL");
			System.out.println("FINISH: SettingBean.updateSettingDisplayName(SettingBean, boolean)");
			return false;
		}
		
	}

	@Override
	public boolean deleteSetting(SettingBean deleteThisSetting) {
		System.out.println("BEGIN: SettingBeanDAO.deleteSetting(SettingBean deleteThisSetting)");
		Session session = sessionFactory.getCurrentSession();
		if (deleteThisSetting != null) {
			SettingBean existingSetting = session.get(SettingBean.class, deleteThisSetting.getClass());
			if (existingSetting != null) {

				// TO DO Fix this please: consult ProfileDAO.deleteProfile()
				int deleteSettingID = existingSetting.getSettingID();
				int deleteUserID = existingSetting.getUserID();
				String deleteSettingSecurityQ = existingSetting.getSettingSecurityQ();
				String deleteSettingSecurityA = existingSetting.getSettingSecurityA();
				String deleteSettingDisplayName = existingSetting.getSettingDisplayName();
				boolean deleteSettingAllowMetadata = existingSetting.getSettingAllowMetadata();

				session.delete(existingSetting);
				System.out.println("Deleted Setting:");
				System.out.println("Setting ID: " + deleteSettingID);
				System.out.println("User ID: " + deleteUserID);
				System.out.println("Security Q: " + deleteSettingSecurityQ);
				System.out.println("Security A: " + deleteSettingSecurityA);
				System.out.println("Display Name: " + deleteSettingDisplayName);
				System.out.println("Allow Metadata: " + deleteSettingAllowMetadata);
				System.out.println("FINISH: SettingBeanDAO.deleteSetting(SettingBean deleteThisSetting)");
				return true;
			} else {
				System.out.println("ERROR: SettingBean NOT FOUND");
				System.out.println("FINISH: SettingBeanDAO.deleteSetting(SettingBean deleteThisSetting)");
				return false;
			}
		} else {
			System.out.println("ERROR: SettingBean was NULL");
			System.out.println("FINISH: SettingBeanDAO.deleteSetting(SettingBean deleteThisSetting)");
			return false;
		}
	}

}