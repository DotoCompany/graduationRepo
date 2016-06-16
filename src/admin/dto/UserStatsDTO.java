package admin.dto;

public class UserStatsDTO {
	
	private String quarter;
	private String userCnt;
	
	public UserStatsDTO() {
		// TODO Auto-generated constructor stub
	}
	public UserStatsDTO(String quarter, String userCnt) {
		super();
		this.quarter = quarter;
		this.userCnt = userCnt;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getUserCnt() {
		return userCnt;
	}
	public void setUserCnt(String userCnt) {
		this.userCnt = userCnt;
	}
	@Override
	public String toString() {
		return "UserStatsDTO [quarter=" + quarter + ", userCnt=" + userCnt
				+ "]";
	}
}
