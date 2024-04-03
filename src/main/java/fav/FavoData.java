package fav;

public class FavoData {
	private int num; // >>각각을 구분하기 위한 줄번호
	private int datanum; // 원본글 번호
	private String id; // 좋아요 누른 사람(id)

	public FavoData() {

	}

	public FavoData(int num, int datanum, String id) {
		super();
		this.num = num;
		this.datanum = datanum;
		this.id = id;
	}

	@Override
	public String toString() {
		return "FavoData [num=" + num + ", datanum=" + datanum + ", id=" + id + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDatanum() {
		return datanum;
	}

	public void setDatanum(int datanum) {
		this.datanum = datanum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
