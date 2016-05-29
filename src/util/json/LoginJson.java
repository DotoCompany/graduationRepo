package util.json;

import org.json.simple.JSONObject;

import DTO.UserDTO;

public class LoginJson {
	
	public static final LoginJson instance;
	static {
		instance = new LoginJson();
	}
	
	private LoginJson() {
		// TODO Auto-generated constructor stub
	}
	
	public static LoginJson getInstance() {
		return instance;
	}
	
	public JSONObject createLoginJson(UserDTO userDTO) {
		
		JSONObject json = null;
		
		/* LoginJson Code */
		
		return json;
	}

}
