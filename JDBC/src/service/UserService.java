package service;

import java.util.List;

import vo.UserVO;

public interface UserService {
	
	public int signUp(UserVO user);
	public int checkUserId(String id);
	public int signIn(UserVO user);
	public int signOut(UserVO user);
	public int deleteUser(UserVO user);
	public List<UserVO> queryUserList();

}
