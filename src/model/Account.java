package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "account")
@Component
public class Account {

	// Variables, matches table columns
	private String accountName;
	private int id;
	private String username;
	private String userpwd;
	
	// Constructors
	public Account() {
	}
	
	public Account(String username, String userpwd) {
		this.username = username;
		this.userpwd = userpwd;
	}

	// Get/Set Methods
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="USERPWD")
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

}
