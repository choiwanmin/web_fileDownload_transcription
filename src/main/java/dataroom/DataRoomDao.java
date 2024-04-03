package dataroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class DataRoomDao {
	private DBConnect db;

	public DataRoomDao() {
		db = DBConnect.getInstance();
	}

	public void insert(DataRoom d) {
		Connection conn = db.conn();
		String sql = "insert into dataroom values(seq_dataroom.nextval,?,sysdate,?,?,?,0)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getWriter());
			pstmt.setString(2, d.getTitle());
			pstmt.setString(3, d.getContent());
			pstmt.setString(4, d.getFname());

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 줄 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DataRoom select(int num) {
		Connection conn = db.conn();
		String sql = "select * from dataroom where num=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new DataRoom(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<DataRoom> selectAll() {
		Connection conn = db.conn();
		String sql = "select * from dataroom order by num";
		ArrayList<DataRoom> list = new ArrayList<DataRoom>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new DataRoom(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public void update(DataRoom d) {
		Connection conn = db.conn();
		String sql = "update dataroom set title=?, content=? where num=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getTitle());
			pstmt.setString(2, d.getContent());
			pstmt.setInt(3, d.getNum());

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 줄 수정됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateCnt(int num) {
		Connection conn = db.conn();
		String sql = "update dataroom set cnt=cnt+1 where num=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 번 글의 cnt 1 증가");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete(int num) {
		Connection conn = db.conn();
		String sql = "delete dataroom where num=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			System.out.println(num + " 번 글 삭제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
