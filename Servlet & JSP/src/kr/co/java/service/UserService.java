package kr.co.java.service;

import java.util.List;

import kr.co.java.vo.UserVO;

public interface UserService {
	
	boolean insertUser(UserVO user);
	boolean deleteUser(String id);
	boolean updateUser(UserVO user);
	UserVO queryUser(String id);
	List<UserVO> queryUserList();
	
}
