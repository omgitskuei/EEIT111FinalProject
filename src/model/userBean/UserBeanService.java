package model.userBean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.CheckSubstring;

@Service
public class UserBeanService {

	// Variables: Local Fields
	private UserBeanDAO uDAO;
	
	// Constructors
	@Autowired
	public UserBeanService(UserBeanDAO uDAO) {
		this.uDAO = uDAO;
	}
	
	// Test Validity* of newUser before doing UserBeanDAO.insertUser(UserBean)
	// Validity means checking all user inputs (specifically userEmail, userPwd)
	public boolean insert(UserBean newUser) {
		System.out.println("BEGIN: UserBeanService.insert(UserBean insertThisUser)");
		// Get values from newUser for validation
		String email = newUser.getUserEmail();
		String pwd = newUser.getUserPwd();
		boolean success = false;
		// Validate values
		if (validatePwd(email) && validateEmail(pwd)) {
			System.out.println("Email & Pwd valid");
			success = uDAO.insertUser(newUser); //Returns true
		} else {
			System.out.println("Email && Pwd invalid");
		}
		
		System.out.println("FINISH: UserBeanService.insert(UserBean insertThisUser)");
		return success;
	}
	
	public UserBean select(UserBean selectThisUser) {
		System.out.println("BEGIN: UserBeanService.select(UserBean insertThisUser)");
		// Get values for validation
		String email = selectThisUser.getUserEmail();
		String pwd = selectThisUser.getUserPwd();
		// Validate values, if not valid email & password, don't bother selecting
		if (validateEmail(email) && validateEmail(pwd)) {
			System.out.println("Email && Pwd valid");
			return uDAO.selectUser(selectThisUser);
		} else {
			System.out.println("Email && Pwd invalid");
		}
		System.out.println("FINISH: UserBeanService.select(UserBean insertThisUser)");
		return null;
	}
	
	public boolean updateEmail(UserBean updateThisUser, String newEmail) {
		System.out.println("BEGIN: UserBeanService.updateEmail(UserBean insertThisUser)");
		// Validate values, if not valid, don't bother with update
		if (validateEmail(newEmail)) {
			System.out.println("New Email valid");
			return uDAO.updateEmail(updateThisUser, newEmail);
		} else {
			System.out.println("New Email valid");
		}
		System.out.println("FINISH: UserBeanService.updateEmail(UserBean insertThisUser)");
		return false;
	}
	
	public boolean updatePwd(UserBean updateThisUser, String newPwd) {
		System.out.println("BEGIN: UserBeanService.updatePwd(UserBean insertThisUser)");
		// Validate values, if not valid, don't bother with update
		if (validatePwd(newPwd)) {
			System.out.println("New Password valid");
			return uDAO.updatePwd(updateThisUser, newPwd);
		} else {
			System.out.println("New Password valid");
		}
		System.out.println("FINISH: UserBeanService.updatePwd(UserBean insertThisUser)");
		return false;
	}
	
	public boolean delete(UserBean deleteThisUser) {
		System.out.println("BEGIN: UserBeanService.delete(UserBean insertThisUser)");
		// Check if the deleted user exists before trying to delete it
		if (uDAO.selectUser(deleteThisUser)!=null) {
			return uDAO.deleteUser(deleteThisUser);
		}
		System.out.println("FINISH: UserBeanService.delete(UserBean insertThisUser)");
		return false;
	}
	
	private static boolean validateEmail(String email) {
		// Partition email string based on email syntax; localpart@domain
		String localpart = email.substring(0, email.indexOf("@"));
		String domain = email.substring(email.indexOf("@") + 1, email.length());
		
		// Localpart and Domain must not exceed 64 characters
		if (localpart.length() <= 64 && domain.length() <= 63) {
			// Create empty ArrayList for storing where "." appear in email String
			ArrayList<Integer> dotIndexes = new ArrayList<Integer>();
			// Create counter for "@"
			int countAt = 0;
			boolean noSpaces = true;
			// Take apart the email String
			for (int index = 0; index < email.length(); index++) {
				// Split email into substrings
				String substring = email.substring(index, index + 1);
				// Count how many "@"
				if (substring.equals("@")) {
					countAt++;
				}
				// Check if there are any spaces in the email
				if (substring.equals(" ")) {
					noSpaces = false;
				}
				// Note where "." dots appear in the email, store into ArrayList
				if (substring.equals(".")) {
					dotIndexes.add(index);
				}
			}
			System.out.println(dotIndexes);
			// A valid email must have "@" and can only have one "@"
			if (countAt == 1) {
				// A valid email must have no spaces
				if (noSpaces) {
					// A valid email cannot begin or end on "."
					if (!(dotIndexes.contains(0) || dotIndexes.contains(email.length()-1))) {
						// Domain must comply with LDH rule (letters, digits, hyphen)
						// AKA, Domain must NOT contain Special Characters, not including "."
						CheckSubstring util = new CheckSubstring();
						if ( util.countSpecialCharacters(domain)==0 ) {
							// Domain must contain one "."
							if (domain.contains(".")) {
								boolean noConsecutiveDotsFlag = true;
								// Domain cannot have any consecutive dots
								for (int index=0;index<dotIndexes.size()-1;index++) {
									if ((dotIndexes.get(index+1)-dotIndexes.get(index))==1) {
										noConsecutiveDotsFlag = false;
									}
								}
								if(noConsecutiveDotsFlag) {
									System.out.println("Yay, good email");
									return true;
								}
							} else {
								System.out.println("Invalid Input: Email domain missing . character");
							}
						} else {
							System.out.println("Invalid Input: Email may only use letters, digits, hyphen");
						}
					} else {
						System.out.println("Invalid Input: Email may not end on a . character");
					}
				} else {
					System.out.println("Invalid Input: Email may not use any Spaces");
				}
			} else {
				System.out.println("Invalid Input: Email may only have one @ character");
			}
		} else {
			System.out.println("Invalid Input: Email localpart and domain must be under 64 characters");
		}
		return false;
	}
	
	public static boolean validatePwd(String pwd) {
		System.out.println("Begin: validatePwd(String)");
		// A valid password must have >=8 characters
		if (pwd.length()>=8) {
			// Partition pwd into substrings of each character
			ArrayList<String> pwdEachChar = new ArrayList<String>();
			for (int index = 0; index < pwd.length(); index++) {
				pwdEachChar.add(pwd.substring(index, index+1));
				
			}
			// A valid password must NOT contain spaces
			if (!(pwdEachChar.contains(" "))) {
				// A valid password must contain >=1 special characters
				// A valid password must contain >=1 Capitalized letters
				// A valid password must contain >=1 Lower-case letters
				CheckSubstring util = new CheckSubstring();
				if (util.countCapLetters(pwd)>=1 && util.countLowLetters(pwd)>=1 && util.countSpecialCharacters(pwd)>=1) {
					// A valid password must contain >=1 numbers
					if (util.countNums(pwd)>=1) {
						System.out.println("Valid Input: Pwd");
						return true;
					} else {
						System.out.println("Invalid Input: Pwd must contain at least one number");
					}
				} else {
					System.out.println("Invalid Input: Pwd must contain at least one Special character, Capital letter, and Lower-case letter");
				}
			} else {
				System.out.println("Invalid Input: Pwd must not contain spaces");
			}
		} else {
			System.out.println("Invalid Input: Pwd must be longer than 8 characters");
		}
		System.out.println("Finish: validatePwd(String)");
		return false;
	}
}
