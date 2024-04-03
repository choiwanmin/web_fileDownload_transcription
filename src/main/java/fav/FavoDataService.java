package fav;

import java.util.ArrayList;

public class FavoDataService {
	private FavoDataDao dao;

	public FavoDataService() {
		dao = new FavoDataDao();
	}

	public void addFavo(FavoData f) {
		dao.insert(f);
	}

	public void delFavo(FavoData f) {
		dao.delete(f);
	}

	public int getFcnt(int datanum) {
		return dao.selectFcnt(datanum);
	}

	public ArrayList<String> getIds(int datanum) {
		return dao.selectIds(datanum);
	}

	public FavoData getFavoData(int datanum, String id) {
		return dao.select(datanum, id);
	}
}
