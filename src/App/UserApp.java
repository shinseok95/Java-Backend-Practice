package App;

import java.util.List;
import java.util.Scanner;

import dao.UserDAO;
import service.UserService;
import service.UserServiceImpl;
import vo.UserVO;

public class UserApp {
	
	private static final int USER_ID_ALREADY_EXIST = 1000;
	private static final int USER_ID_NOT_EXIST = 1001;
	private static final int USER_ID_ALREADY_SIGN_IN = 1002;
	private static final int USER_ID_ALREADY_SIGN_OUT = 1003;
	private static final int USER_ID_SIGN_UP_SUCCESS = 1004;
	private static final int USER_ID_SIGN_UP_FAIL = 1005;
	private static final int USER_ID_SIGN_IN_SUCCESS = 1006;
	private static final int USER_ID_SIGN_IN_FAIL = 1007;	
	private static final int USER_ID_SIGN_OUT_SUCCESS = 1008;
	private static final int USER_ID_SIGN_OUT_FAIL = 1009;
	private static final int USER_ID_DELETE_SUCCESS = 1010;
	private static final int USER_ID_DELETE_FAIL = 1011;
	private static final int USER_PWD_NOT_CORRESPOND = 1012;

	public static void main(String[] args) {
		
		UserDAO dao = new UserDAO();
		UserService userService = new UserServiceImpl(dao);
		
		int ans=0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("1.SignUp");
			System.out.println("2.SignIn");
			System.out.println("3.SignOut");
			System.out.println("4.Delete ID");
			System.out.println("5.Print All User");	
			System.out.println("9.Quit");
			System.out.print("\n==> ");
			
			ans=Integer.parseInt(sc.nextLine());
			System.out.println("");

			if(ans == 9)
				break;
			
			switch(ans) {
			
			case 1:
				signUp(userService);
				break;
			case 2:
				signIn(userService);
				break;
			case 3:
				signOut(userService);
				break;
			case 4:
				deleteUser(userService);
				break;
			case 5:
				printUserList(userService);
				break;
			default:
				System.out.println("올바른 숫자를 입력해주세요.");
			}
			
			System.out.println("\n=====================\n\n");
		}
	}
		
	public static void signUp(UserService userService) {
		
		int resultCode=0;
		UserVO user=null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		String id = sc.nextLine();
		if(userService.checkUserId(id)==USER_ID_ALREADY_EXIST) {
			printResult(USER_ID_ALREADY_EXIST);
			return;
		}
		
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		System.out.print("NAME : ");
		String name = sc.nextLine();
		System.out.print("BIRTHDAY(ex:19950807) : ");
		String birthday = sc.nextLine();
		
		user = new UserVO(id,pwd,name,birthday,0);
		
		resultCode = userService.signUp(user);
		
		printResult(resultCode);
	}
	
	public static void signIn(UserService userService) {
		
		int resultCode=0;
		UserVO user=null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		user = new UserVO(id,pwd);
		
		resultCode = userService.signIn(user);

		printResult(resultCode);		
	}
	
	public static void signOut(UserService userService) {
		
		int resultCode=0;
		UserVO user=null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		user = new UserVO(id,pwd);
		
		resultCode = userService.signOut(user);
		
		printResult(resultCode);
	}
	
	public static void deleteUser(UserService userService) {
		
		int resultCode=0;
		UserVO user=null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		user = new UserVO(id,pwd);
		
		resultCode = userService.deleteUser(user);
		

		printResult(resultCode);
	}
	
	public static void printUserList(UserService userService) {
		
		List<UserVO> userList = userService.queryUserList();
		
		if(userList.size()==0)
			System.out.println("등록된 회원이 존재하지 않습니다.");
		else
			userList.forEach(user->System.out.println(user));
	}
	
	public static void printResult(int resultCode) {
		
		switch(resultCode) {
		
		case USER_ID_ALREADY_EXIST:
			System.out.println("\n=> 이미 존재하는 계정입니다. <=");
			break;
			
		case USER_ID_NOT_EXIST:
			System.out.println("\n=> 존재하지 않는 계정입니다. <=");
			break;
			
		case USER_ID_ALREADY_SIGN_IN:
			System.out.println("\n=> 이미 로그인 중입니다. <=");
			break;
			
		case USER_ID_ALREADY_SIGN_OUT:
			System.out.println("\n=> 로그인되지 않았습니다. <=");
			break;
			
		case USER_ID_SIGN_UP_SUCCESS:
			System.out.println("\n=> 회원가입에 성공하였습니다. <=");
			break;
			
		case USER_ID_SIGN_UP_FAIL:
			System.out.println("\n=> 회원가입에 실패하였습니다. <=");
			break;
			
		case USER_ID_SIGN_IN_SUCCESS:
			System.out.println("\n=> 로그인에 성공하였습니다. <=");
			break;
			
		case USER_ID_SIGN_IN_FAIL:
			System.out.println("\n=> 로그인에 실패하였습니다. <=");
			break;
			
		case USER_ID_SIGN_OUT_SUCCESS:
			System.out.println("\n=> 로그아웃에 성공하였습니다. <=");
			break;
			
		case USER_ID_SIGN_OUT_FAIL:
			System.out.println("\n=> 로그아웃에 실패하였습니다. <=");
			break;
			
		case USER_ID_DELETE_SUCCESS:
			System.out.println("\n=> 회원탈퇴에 성공하였습니다. <=");
			break;
			
		case USER_ID_DELETE_FAIL:
			System.out.println("\n=> 회원탈퇴에 실패하였습니다. <=");
			break;
			
		case USER_PWD_NOT_CORRESPOND:
			System.out.println("\n=> 비밀번호가 일치하지 않습니다. <=");
			break;
		}
		
	}
}
