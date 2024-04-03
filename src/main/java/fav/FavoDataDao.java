package fav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class FavoDataDao {
	private DBConnect db;

	public FavoDataDao() {
		db = DBConnect.getInstance();
	}

	public void insert(FavoData f) {
		Connection conn = db.conn();
		String sql = "insert into favodata values(seq_favodata.nextval,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, f.getDatanum());
			pstmt.setString(2, f.getId());

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 줄 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(FavoData f) {
		Connection conn = db.conn();
		String sql = "delete favodata where id=? and datanum=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, f.getId());
			pstmt.setInt(2, f.getDatanum());

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 줄 삭제됨");
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

	public int selectFcnt(int datanum) {
		Connection conn = db.conn();
		String sql = "select count(*) from favodata where datanum=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, datanum);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
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
		return 0;
	}

	public ArrayList<String> selectIds(int datanum) {
		Connection conn = db.conn();
		String sql = "select id from favodata where datanum=?";
		ArrayList<String> ids = new ArrayList<String>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, datanum);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ids.add(rs.getString(1));
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
		return ids;
	}

	public FavoData select(int datanum, String id) {
		Connection conn = db.conn();
		String sql = "select * from favodata where datanum=? and id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, datanum);
			pstmt.setString(2, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new FavoData(rs.getInt(1), rs.getInt(2), rs.getString(3));
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
}
