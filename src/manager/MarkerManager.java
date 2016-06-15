package manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DAO.MarkerDAO;
import DTO.Marker;
import DTO.MarkerDTO;

public class MarkerManager {

	private static final MarkerManager instance = new MarkerManager();
	private static MarkerDAO markerDao;
	
	private MarkerManager() {
		markerDao = MarkerDAO.getInstance();
	}
	
	public static MarkerManager getInstance() {
		return instance;
	}
	
	public int insertMarker(MarkerDTO markerDto) {
		return markerDao.insertMarker(markerDto);
	}
	public int insertMarker(String uId,ArrayList<Marker> arrayList ) {
		return markerDao.insertMarker(uId,arrayList);
	}
	public int deleteMarkerByUser(String uId) {
		return markerDao.deleteMarkerByUser(uId);
	}
	
	public int deleteMarkerByTimestamp(String uId, String timestamp) {
		
		/* timestamp의 범위를 지정하는 코드 등이 필요할 예정*/
		return markerDao.deleteMarkerByTimestamp(uId, new Timestamp(new java.util.Date().getTime()).toString());
	}
	
	public List<MarkerDTO> getMarkerByUser(String uId) {
		return markerDao.getMarkerByUser(uId);
	}
	
	/* 날짜범위를 지정해서 범위 내에 속하는 Marker를 가져오는 메소드 추가 */
	
}
