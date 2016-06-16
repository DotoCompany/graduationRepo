package admin.manager;

import java.util.List;

import DAO.UserDAO;
import DTO.UserStatsDTO;

public class StatsMgmtManager {

	private static final StatsMgmtManager instance = new StatsMgmtManager();
	private static UserDAO userDao;
	
	private StatsMgmtManager() {
		userDao = UserDAO.getInstance();
	}
	
	public static StatsMgmtManager getInstance() {
		return instance;
	}
	
	public List<UserStatsDTO> getUserStats() {
		return userDao.getUserStats();
	}
	
}
