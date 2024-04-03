package dataroom;

import java.sql.Date;

public class DataRoom {
	private int num;
	private String writer;
	private Date wdate;
	private String title;
	private String content;
	private String fname;
	private int cnt;
	private int fcnt; // >>좋아요 집계하여 넣어둘 변수, 댓글처럼, 댓글목록처럼 집계한 것을 넣을 줄 예정

	public DataRoom() {

	}

	public DataRoom(int num, String writer, Date wdate, String title, String content, String fname, int cnt) {
		super();
		this.num = num;
		this.writer = writer;
		this.wdate = wdate;
		this.title = title;
		this.content = content;
		this.fname = fname;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "DataRoom [num=" + num + ", writer=" + writer + ", wdate=" + wdate + ", title=" + title + ", content="
				+ content + ", fname=" + fname + ", cnt=" + cnt + ", fcnt=" + fcnt + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getFcnt() {
		return fcnt;
	}

	public void setFcnt(int fcnt) {
		this.fcnt = fcnt;
	}

}
