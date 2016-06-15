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
		
		/* timestamp�� ������ �����ϴ� �ڵ� ���� �ʿ��� ����*/
		return markerDao.deleteMarkerByTimestamp(uId, new Timestamp(new java.util.Date().getTime()).toString());
	}
	
	public List<MarkerDTO> getMarkerByUser(String uId) {
		return markerDao.getMarkerByUser(uId);
	}
	
	/* ��¥������ �����ؼ� ���� ���� ���ϴ� Marker�� �������� �޼ҵ� �߰� */
	
}
