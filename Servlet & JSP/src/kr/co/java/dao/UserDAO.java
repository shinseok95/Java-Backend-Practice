package kr.co.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.java.util.JDBCUtil;
import kr.co.java.vo.UserVO;

public class UserDAO {
	
	public boolean insertUser(UserVO vo) {
		
		boolean resultFlag = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql ="INSERT INTO USERS VALUES(?,?,?)";
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getName());
			
			if(ps.executeUpdate()==1)
				resultFlag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con,ps,rs);
		}
		
		return resultFlag;
	}
	
	public UserVO queryUser(String id) {
		
		UserVO user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql ="SELECT * FROM USERS WHERE ID=?";
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPwd(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return user;
	}
	
	public List<UserVO> queryUserList(){
		
		List<UserVO> userList = new ArrayList<UserVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM USERS";
		
		try {
			
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPwd(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				
				userList.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return userList;
	}
	
	public boolean updateUser(UserVO user) {
		
		boolean resultFlag = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "UPDATE USERS SET PW=?, NAME=? WHERE ID=?";
		
		try {
			
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPwd());
			ps.setString(2, user.getName());
			ps.setString(3, user.getId());
			
			if(ps.executeUpdate() == 1)
				resultFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return resultFlag;
	}
	
	public boolean deleteUser(String id) {
		
		boolean resultFlag = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql ="DELETE USERS WHERE ID=?";
		
		try {
			
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			if(ps.executeUpdate()==1)
				resultFlag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return resultFlag;
	}
}
