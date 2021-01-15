package kr.co.java.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.java.dao.UserDAO;
import kr.co.java.service.UserService;
import kr.co.java.service.UserServiceImpl;
import kr.co.java.vo.UserVO;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean resultFlag = false;
		HttpSession session = request.getSession();

		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String name = request.getParameter("NAME");
		
		UserDAO dao = new UserDAO();
		UserService userService = new UserServiceImpl(dao);
		
		// 이미 존재하는 아이디라면
		if(userService.queryUser(id)!=null) {
			
			session.setAttribute("SIGNUP_MSG", "이미 존재하는 아이디입니다.");
			response.sendRedirect("SignIn.jsp");
		}
		// 중복된 아이디가 없다면
		else {
			
			UserVO user = new UserVO(id,pw,name);
			resultFlag = userService.insertUser(user);
			
			// 회원가입에 성공했다면
			if(resultFlag) {
				session.setAttribute("LOGIN_RESULT_MSG", "회원가입에 성공하였습니다.");
				response.sendRedirect("Login.jsp");
			}
			// 회원가입에 실패했다면
			else {
				session.setAttribute("SIGNUP_MSG", "회원가입에 실패하였습니다.");
				response.sendRedirect("SignIn.jsp");
			}
		}
	}
}
