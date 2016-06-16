package manager;

import java.util.ArrayList;

import DAO.FriendDAO;
import DTO.FriendDTO;

public class FriendManager {
	private static final FriendManager friendManager;
	static {
		friendManager = new FriendManager();
	}
	public static FriendManager getInstance() {
		return friendManager;
	}
	public ArrayList<FriendDTO> getFriends(String userCode) {
		return FriendDAO.getInstance().getFriends(userCode);
	}
	public int requestFriend(String uId, String toUserCode) {
		return FriendDAO.getInstance().requestFriend(uId, toUserCode);
	}
}
