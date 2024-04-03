package mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class MemDao {
	private DBConnect db;

	public MemDao() {
		db = DBConnect.getInstance();
	}

	public void insert(Mem m) {
		Connection conn = db.conn();
		String sql = "insert into mem values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setInt(4, m.getType());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "줄 추가됨");
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

	public int update(Mem m) {
		Connection conn = db.conn();
		String sql = "update mem set pwd=? where id=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getId());

			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "줄 수정됨");
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
		return cnt;

	}

	public int delete(String id) {
		Connection conn = db.conn();
		String sql = "delete from mem where id=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "줄 삭제됨");
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
		return cnt;

	}

	public Mem select(String id) {
		Connection conn = db.conn();
		String sql = "select * from mem where id=?";
		Mem mem = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				mem = new Mem();
				mem.setId(rs.getString(1));
				mem.setPwd(rs.getString(2));
				mem.setName(rs.getString(3));
				mem.setEmail(rs.getString(4));
				mem.setType(rs.getInt(5));
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
		return mem;
		
	}

	public ArrayList<Mem> selectAll() {
		Connection conn = db.conn();
		String sql = "select * from mem order by id";
		ArrayList<Mem> list = new ArrayList<Mem>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Mem mem = new Mem();
				mem.setId(rs.getString(1));
				mem.setPwd(rs.getString(2));
				mem.setName(rs.getString(3));
				mem.setEmail(rs.getString(4));
				mem.setType(rs.getInt(5));
				list.add(mem);
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
}
