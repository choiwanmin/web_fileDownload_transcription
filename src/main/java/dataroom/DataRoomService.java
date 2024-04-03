package dataroom;

import java.util.ArrayList;

public class DataRoomService {
	private DataRoomDao dao;

	public static String path = "C:\\down\\";

	public DataRoomService() {
		dao = new DataRoomDao();
	}

	public void addData(DataRoom d) {
		dao.insert(d);
	}

	public DataRoom getData(int num) {
		return dao.select(num);
	}

	public ArrayList<DataRoom> getAll() {
		return dao.selectAll();
	}

	public void editData(DataRoom d) {
		dao.update(d);
	}

	public void editCnt(int num) {
		dao.updateCnt(num);
	}

	public void delData(int num) {
		dao.delete(num);
	}

}
