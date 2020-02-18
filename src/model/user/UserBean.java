package model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.google.crypto.tink.Aead;

import util.EncodeHexString;
import util.EncryptString;

@Entity
@Table(name = "UsersTable")
@Component
public class UserBean {

	// Variables, matches table columns
	private int userID;		// Not NULL
	private String userEmail;		// Not NULL
	private String userPwd;		// Not NULL
	private int admin;		// Not NULL
//	OneToOne關係目前用不到先關閉
//	private WalletBean walletBean;
//	private ProfileBean profileBean;
	
	// Constructors
	public UserBean() {
	}
	
	public UserBean(String newUserEmail, String newUserPwd, int newAdmin) {
		this.userEmail = newUserEmail;
		this.userPwd = newUserPwd;
		this.admin = newAdmin;
	}

	// Get/Set Methods
	@Id
	@Column(name="userID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserID() {
		return userID;
	}
	public void setUserID(int newUserID) {
		this.userID = newUserID;
	}

	@Column(name="userEmail")
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String newUserEmail) {
		this.userEmail = newUserEmail;
	}

	@Column(name="userPwd")
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String newUserPwd) {
		this.userPwd = newUserPwd;
	}

	@Column(name="admin")
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int newAdmin) {
		this.admin=newAdmin;
	}
//	OneToOne關係目前用不到先關閉
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userBean", cascade = CascadeType.ALL)
//	public WalletBean getWalletBean() {
//		return walletBean;
//	}
//
//	public void setWalletBean(WalletBean walletBean) {
//		this.walletBean = walletBean;
//	}
//
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userBean", cascade = CascadeType.ALL)
//	public ProfileBean getProfileBean() {
//		return profileBean;
//	}
//
//	public void setProfileBean(ProfileBean profileBean) {
//		this.profileBean = profileBean;
//	}
	
}
