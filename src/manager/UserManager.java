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
	 * User정보 input method.
	 * @param userVO
	 * @return insert 성공시 1 리턴 실패시 0리턴
	 */
	public byte insertUser(UserDTO userDTO) {
		return userDao.insertUser(userDTO);
	}
	
	public byte insertUser(String email,String name,String pwd) {
		return userDao.insertUser(email, name, pwd);
	}
	
	/**
	 * 유저의 EmailId 와 Name을 수정하기 위한 메소드
	 * @param userDTO
	 * @return 1 : update성공  / 0 : update실패
	 */
	public byte updateUser(UserDTO userDTO) {
		return userDao.updateUser(userDTO);
	}
	
	/**
	 * 아이디가 있는건지 없는건지 확인하는 메서드
	 * @param email 사용자 이메일
	 * @return 1: 아이디 있음 / 0:아이디없음
	 */
	public byte getUser(String email) {
		return userDao.getUser(email);
	}
	
	
	/**
	 * 유저를 삭제하기 위한 메소드
	 * @param emailId
	 * @param pwd
	 * @return 1 : delete성공  / 0 : delete실패
	 */
	public byte deleteUser(String emailId, String pwd) {
		return userDao.deleteUser(emailId, pwd);
	}
	
	/**
	 * 아마도, 로그인 시 사용하게 될 search 메소드일 듯 합니다.
	 * @param email 사용자 이메일
	 * @param pwd 사용자 비밀번호
	 * @return 사용자 이메일과 비밀번호에 매칭되는 값
	 */
	public UserDTO getUser(String email,String pwd) {
		return userDao.getUser(email, pwd);
	}
}
