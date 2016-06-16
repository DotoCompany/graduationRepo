package manager;

import java.util.ArrayList;

import java.util.ArrayList;

import DAO.UserDAO;
import DTO.UserDTO;

public class UserManager {

	private static final UserManager instance = new UserManager();
	private static UserDAO userDao;
	
	private UserManager() {
		userDao = UserDAO.getInstance();
	}
	
	public static UserManager getInstance() {
		return instance;
	}
	public ArrayList<UserDTO> searchUser(String searchBox) {
		return userDao.searchUser(searchBox);
	}
	
	/**
	 * User���� input method.
	 * @param userVO
	 * @return insert ������ 1 ���� ���н� 0����
	 */
	public byte insertUser(UserDTO userDTO) {
		return userDao.insertUser(userDTO);
	}
	
	public byte insertUser(String email,String name,String pwd) {
		return userDao.insertUser(email, name, pwd);
	}
	
	/**
	 * ������ EmailId �� Name�� �����ϱ� ���� �޼ҵ�
	 * @param userDTO
	 * @return 1 : update����  / 0 : update����
	 */
	public byte updateUser(UserDTO userDTO) {
		return userDao.updateUser(userDTO);
	}
	
	/**
	 * ���̵� �ִ°��� ���°��� Ȯ���ϴ� �޼���
	 * @param email ����� �̸���
	 * @return 1: ���̵� ���� / 0:���̵����
	 */
	public byte getUser(String email) {
		return userDao.getUser(email);
	}
	
	
	/**
	 * ������ �����ϱ� ���� �޼ҵ�
	 * @param emailId
	 * @param pwd
	 * @return 1 : delete����  / 0 : delete����
	 */
	public byte deleteUser(String emailId, String pwd) {
		return userDao.deleteUser(emailId, pwd);
	}
	
	/**
	 * �Ƹ���, �α��� �� ����ϰ� �� search �޼ҵ��� �� �մϴ�.
	 * @param email ����� �̸���
	 * @param pwd ����� ��й�ȣ
	 * @return ����� �̸��ϰ� ��й�ȣ�� ��Ī�Ǵ� ��
	 */
	public UserDTO getUser(String email,String pwd) {
		return userDao.getUser(email, pwd);
	}
}
