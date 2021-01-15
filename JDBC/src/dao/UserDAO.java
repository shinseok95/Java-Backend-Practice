package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.UserVO;

public class UserDAO {
	
	public int insertUser(UserVO vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		String sql ="INSERT INTO \"USER\" VALUES(?,?,?,?,0)";
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getBirthday());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con,ps,rs);
		}
		
		return row;
	}
	
public UserVO selectUser(String id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		
		String sql ="SELECT * FROM \"USER\" WHERE id=?";
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				vo = new UserVO();
				vo.setId(id);
				vo.setPwd(rs.getString("PWD"));
				vo.setName(rs.getString("NAME"));
				vo.setBirthday(rs.getString("BIRTHDAY"));
				vo.setIsLogin(rs.getInt("LOGIN"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con,ps,rs);
		}
		
		return vo;
	}

public List<UserVO> selectUserALL() {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<UserVO> userList = new ArrayList<UserVO>();
	
	String sql ="SELECT * FROM \"USER\"";
	
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			
			UserVO vo = new UserVO();
			vo.setId(rs.getString("ID"));
			vo.setPwd(rs.getString("PWD"));
			vo.setName(rs.getString("NAME"));
			vo.setBirthday(rs.getString("BIRTHDAY"));
			vo.setIsLogin(rs.getInt("LOGIN"));
			
			userList.add(vo);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(con,ps,rs);
	}
	
	return userList;
}

public int updateUser(UserVO vo) {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int row = 0;
	
	String sql ="UPDATE \"USER\" SET pwd=? WHERE id=?";
	
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, vo.getPwd());
		ps.setString(2, vo.getId());
		
		row = ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(con,ps,rs);
	}
	
	return row;
}

public int signInUser(UserVO vo) {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int row = 0;
	
	String sql ="UPDATE \"USER\" SET LOGIN=1 WHERE id=?";
	
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, vo.getId());
		
		row = ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(con,ps,rs);
	}
	
	return row;
}

public int signOutUser(UserVO vo) {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int row = 0;
	
	String sql ="UPDATE \"USER\" SET LOGIN=0 WHERE id=?";
	
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, vo.getId());
		
		row = ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(con,ps,rs);
	}
	
	return row;
}

public int deleteUser(String id) {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int row = 0;
	
	String sql ="DELETE \"USER\" WHERE id=?";
	
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, id);
		
		row = ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(con,ps,rs);
	}
	
	return row;
}

}
