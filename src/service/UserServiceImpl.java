package service;

import java.util.List;

import dao.UserDAO;
import vo.UserVO;

public class UserServiceImpl implements UserService{
	
	
	private final int USER_ID_ALREADY_EXIST = 1000;
	private final int USER_ID_NOT_EXIST = 1001;
	private final int USER_ID_ALREADY_SIGN_IN = 1002;
	private final int USER_ID_ALREADY_SIGN_OUT = 1003;
	private final int USER_ID_SIGN_UP_SUCCESS = 1004;
	private final int USER_ID_SIGN_UP_FAIL = 1005;
	private final int USER_ID_SIGN_IN_SUCCESS = 1006;
	private final int USER_ID_SIGN_IN_FAIL = 1007;	
	private final int USER_ID_SIGN_OUT_SUCCESS = 1008;
	private final int USER_ID_SIGN_OUT_FAIL = 1009;
	private final int USER_ID_DELETE_SUCCESS = 1010;
	private final int USER_ID_DELETE_FAIL = 1011;
	private final int USER_PWD_NOT_CORRESPOND = 1012;
	
	
	UserDAO dao;
	
	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int checkUserId(String id) {
		
		if(dao.selectUser(id) != null)
			return USER_ID_ALREADY_EXIST;
		else
			return USER_ID_NOT_EXIST;
	}
	
	@Override
	public int signUp(UserVO user) {
		
		
		if(dao.insertUser(user)==0)
			return USER_ID_SIGN_UP_FAIL;
		
		return USER_ID_SIGN_UP_SUCCESS;
	}
	
	@Override
	public int signIn(UserVO user) {
		
		if(checkUserId(user.getId()) == USER_ID_NOT_EXIST)
			return USER_ID_NOT_EXIST;
		
		UserVO selectedUserVO = dao.selectUser(user.getId());
		
		if(!user.getPwd().equals(selectedUserVO.getPwd()))
			return USER_PWD_NOT_CORRESPOND;
		
		if(selectedUserVO.getIsLogin() == 1)
			return USER_ID_ALREADY_SIGN_IN;
		
		if(dao.signInUser(user)==0)
			return USER_ID_SIGN_IN_FAIL;
		
		return USER_ID_SIGN_IN_SUCCESS;
	}
	
	public int signOut(UserVO user) {
		
		if(checkUserId(user.getId())==USER_ID_NOT_EXIST)
			return USER_ID_NOT_EXIST;
		
		UserVO selectedUserVO = dao.selectUser(user.getId());
		
		if(!user.getPwd().equals(selectedUserVO.getPwd()))
			return USER_PWD_NOT_CORRESPOND;

		if(selectedUserVO.getIsLogin() == 0)
			return USER_ID_ALREADY_SIGN_OUT;
		
		if(dao.signInUser(user)==0)
			return USER_ID_SIGN_OUT_FAIL;
		
		return USER_ID_SIGN_OUT_SUCCESS;
	}
	
	@Override
	public int deleteUser(UserVO user) {
		
		if(checkUserId(user.getId())==USER_ID_NOT_EXIST)
			return USER_ID_NOT_EXIST;
		
		UserVO selectedUserVO = dao.selectUser(user.getId());
		
		if(!user.getPwd().equals(selectedUserVO.getPwd()))
			return USER_PWD_NOT_CORRESPOND;
		
		if(dao.deleteUser(user.getId())==0)
			return USER_ID_DELETE_FAIL;
		
		return USER_ID_DELETE_SUCCESS;
	}
	
	@Override
	public List<UserVO> queryUserList() {
		
		return dao.selectUserALL();
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	

}
