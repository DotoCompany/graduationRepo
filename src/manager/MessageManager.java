package manager;

import java.util.ArrayList;

import DAO.MessageDAO;
import DTO.MessageDTO;

public class MessageManager {
	private static final MessageManager messageManager;
	static {
		messageManager = new MessageManager();
	}
	public static MessageManager getInstance() {
		return messageManager;
	}
	public MessageManager() {}
	public ArrayList<MessageDTO> getMessage(String userCode,String friendCode) {
		return MessageDAO.getInstance().getMessage(userCode, friendCode);
	}
}
