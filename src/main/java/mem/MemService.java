package mem;

import java.util.ArrayList;
import java.util.Scanner;

public class MemService {
	private MemDao dao;
	public static String loginId;

	public MemService() {
		dao = new MemDao();
	}

	public void addMem(Mem m) {
		dao.insert(m);
	}

	public Mem getMem(String id) {
		return dao.select(id);
	}

	public void editMem(Mem m) {
		dao.update(m);
	}

	public void delMem(String id) {
		dao.delete(id);
	}

	public ArrayList<Mem> getAll() {
		return dao.selectAll();
	}
}
