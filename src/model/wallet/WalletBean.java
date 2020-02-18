package model.wallet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import model.user.UserBean;

@Entity
@Table(name = "WalletsTable")
@Component
public class WalletBean {
	// Variables
	private int walletID;	// Not NULL
	private int userID;		// Not NULL
	private float walletAmount=0;		// Not NULL
//	private UserBean userBean;

	// Constructors
	public WalletBean() {
	}
	
	public WalletBean(int userID) {
		this.userID = userID;
		this.walletAmount = 0;
	}
	
	public WalletBean(int userID, float walletAmount) {
		this.userID = userID;
		this.walletAmount = walletAmount;
	}

	// Get/Set Methods
	//@GenericGenerator(name = "generator", parameters = @Parameter(name = "property", value = "UserBean "), strategy = "foreign")
	@Id
	@Column(name = "walletID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getWalletID() {
		return walletID;
	}

	public void setWalletID(int walletID) {
		this.walletID = walletID;
	}

	@Column(name = "userID")
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Column(name = "walletAmount")
	public float getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(float walletAmount) {
		this.walletAmount = walletAmount;
	}
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	public UserBean getUserBean() {
//		return getUserBean();
//	}
//
//	public void setUserBean(UserBean userBean) {
//		this.userBean = userBean;
//	}

}
