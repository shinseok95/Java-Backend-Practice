package kr.co.java.service;

import java.util.List;

import kr.co.java.dao.UserDAO;
import kr.co.java.vo.UserVO;

public class UserServiceImpl implements UserService{

	private UserDAO dao = null;
	
	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public boolean insertUser(UserVO user) {
		return dao.insertUser(user);
	}

	@Override
	public boolean deleteUser(String id) {
		return dao.deleteUser(id);
	}

	@Override
	public UserVO queryUser(String id) {
		return dao.queryUser(id);
	}

	@Override
	public List<UserVO> queryUserList() {
		return dao.queryUserList();
	}
	
	@Override
	public boolean updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@Override
	public String toString() {
		return "UserServiceImpl [dao=" + dao + "]";
	}

}
