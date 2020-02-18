package model.wallet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.profile.ProfileBean;

@Repository
public class WalletBeanDAO implements WalletBeanDAOInterface {

	private SessionFactory sessionFactory;

	@Autowired
	public WalletBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean insertWallet(WalletBean insertThisWallet) {
		// Create new Session
		System.out.println("BEGIN: WalletBeanDAO.insertWallet(WalletBean insertThisWallet)");
		Session session = sessionFactory.getCurrentSession();
		// Test if passed WalletBean is not empty
		if (insertThisWallet != null) {
			System.out.println("insertThisWallet != null");
			// Insert the passed WalletBean
			session.save(insertThisWallet);
			System.out.println("WalletBean Inserted:");
			System.out.println("	walletID: "+ insertThisWallet.getWalletID());
			System.out.println("	wserID: "+ insertThisWallet.getUserID());
			System.out.println("	walletAmount: " + insertThisWallet.getWalletAmount());
			System.out.println("FINISH: WalletBeanDAO.insertWallet(WalletBean insertThisWallet)");
			// Return True, for SUCCESSFUL INSERT
			return true;
		}
		System.out.println("ERROR: Insert WalletBean FAILED; WalletBean insertThisWallet == null.");
		System.out.println("FINISH: WalletBeanDAO.insertThisWallet(WalletBean insertThisWallet)");
		// Return False, for FAILED INSERT
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public WalletBean selectWallet(WalletBean selectThisWallet) {
		// Get current Session
		System.out.println("BEGIN: WalletBeanDAO.selectWallet(WalletBean selectThisWallet)");

		// Check if selectThisWallet is null
		if (selectThisWallet != null) {
			// Try to find selectThisWallet
			System.out.println("Looking for this Wallet:");

			Session session = sessionFactory.getCurrentSession();

			String hqlString = "from WalletBean where userID=:thisUserID";
			Query q = session.createQuery(hqlString);
			q.setParameter("thisUserID", selectThisWallet.getUserID());

			WalletBean existingWallet = (WalletBean) q.uniqueResult();

			if (existingWallet != null) {
				// If found, return the result WalletBean existingWallet
				System.out.println("Wallet Selected: ID" + existingWallet.getUserID() + " Amount"
						+ existingWallet.getWalletAmount());
				System.out.println("FINISH: WalletBeanDAO.selectWallet(WalletBean selectThisWallet)");
				return existingWallet;
			}
			System.out.println("ERROR: Select WalletBean FAILED; WalletBean existingWallet == null.");
		}
		// existingWallet returned null meaning selectThisWallet was not found
		System.out.println("ERROR: Select WalletBean FAILED; WalletBean selectThisWallet == null.");
		System.out.println("FINISH: WalletBeanDAO.selectWallet(WalletBean selectThisWallet)");
		return null;
	}

	public WalletBean selectWallet(int userID) {
		// Get current Session
		System.out.println("BEGIN: WalletBeanDAO.selectWallet(int userID)");

		// Try to find selectThisWallet
		System.out.println("Looking for Wallet with userID: "+userID);

		Session session = sessionFactory.getCurrentSession();

		WalletBean theWallet = session.get(WalletBean.class, userID);
		return theWallet;
	}

	@Override
	public boolean updateWalletAmount(WalletBean updateThisWallet, float newwalletAmount) {
		// Get current Session
		System.out.println("BEGIN: WalletBeanDAO.updateWallet(WalletBean updateThisWallet)");
		Session session = sessionFactory.getCurrentSession();
		// Check if updateThisWallet is null
		if (updateThisWallet != null) {
			// Try to find updateThisWallet
			WalletBean existingWallet = session.get(WalletBean.class, updateThisWallet.getUserID());
			if (existingWallet != null) {
				// If found, update Wallets and return True
				float oldWalletAmount = existingWallet.getWalletAmount();
				existingWallet.setWalletAmount(newwalletAmount);
				session.update(existingWallet);
				System.out.println("Wallet Amount updated: ID" + existingWallet.getUserID());
				System.out.println(" Old Amount" + oldWalletAmount + " New Amount" + existingWallet.getWalletAmount());
				System.out.println("FINISH: WalletBeanDAO.updateWallet(WalletBean updateThisWallet)");
				return true;
			}
			System.out.println("ERROR: Update WalletBean FAILED; WalletBean existingWallet == null.");
		}
		// Return False because 1) updateThisWallet was null OR 2) existingWallet was
		// null
		System.out.println("FINISH: WalletBeanDAO.updateWallet(WalletBean updateThisWallet)");
		return false;
	}

	@Override
	public boolean deleteWallet(WalletBean deleteThisWallet) {
		// Get current Session
		System.out.println("BEGIN: WalletBeanDAO.deletetWallet(WalletBean deleteThisWallet)");
		Session session = sessionFactory.getCurrentSession();
		// Check if deleteThisWallet is null
		if (deleteThisWallet != null) {
			// Try to find deleteThisWallet
			WalletBean existingWallet = session.get(WalletBean.class, deleteThisWallet.getUserID());
			if (existingWallet != null) {
				// If found, delete, return True
				float deletedWalletAmount = existingWallet.getWalletAmount();
				session.delete(existingWallet);
				System.out.println("Wallet Deleted: Previously had amount " + deletedWalletAmount + " in wallet");
				System.out.println("FINISH: WalletBeanDAO.deletetWallet(WalletBean deleteThisWallet)");
				return true;
			}
			System.out.println("ERROR: Delete WalletBean FAILED; WalletBean existingWallet == null.");
		}
		// Return False because 1) updateThisWallet was null OR 2) existingWallet was
		// null
		System.out.println("FINISH: WalletBeanDAO.deletetWallet(WalletBean deleteThisWallet)");
		return false;
	}
}
