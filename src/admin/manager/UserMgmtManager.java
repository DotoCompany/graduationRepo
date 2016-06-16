package admin.manager;

import java.util.List;

import DAO.UserDAO;
import DTO.UserDTO;

public class UserMgmtManager {

	private static final UserMgmtManager instance = new UserMgmtManager();
	private static UserDAO userDao;
	
	private UserMgmtManager() {
		userDao = UserDAO.getInstance();
	}
	
	public static UserMgmtManager getInstance() {
		return instance;
	}
	
	public List<UserDTO> getAllUsers() {
		return userDao.getAllUsers();
	}
}
