package model.user;

public interface UserBeanDAOInterface {
	// An abstract list of all must-have methods for UserBeanDAO; CRUD
	// C.reate
	public boolean insertUser(UserBean insertThisUser);
	// R.ead
	public UserBean selectUser(UserBean selectThisUser);
	public UserBean selectUserByID(int userID);
	// U.pdate
	public boolean updateEmail(UserBean updateThisUser, String newEmail);
	public boolean updatePwd(UserBean updateThisUser, String newPwd);
	// D.elete
	public boolean deleteUser(UserBean deleteThisUser);
}
