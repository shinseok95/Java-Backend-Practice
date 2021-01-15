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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserVO user = null;
		UserDAO dao = new UserDAO();
		UserService userService = new UserServiceImpl(dao);
		
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		
		if(id!=null)
			user = userService.queryUser(id);
		
		// 아이디가 존재하는 경우
		if(user != null) {
			
			// 비밀번호가 일치하는 경우 -> 회원리스트 페이지로 이동
			if(pw!=null && user.getPwd().equals(pw)) {
				
				// 로그인 성공한 계정 세션 생성
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN_SUCCESS_USER", user);
				
				response.sendRedirect("UserListServlet");
			}
			// 비밀번호가 일치하지 않는 경우 -> 로그인 페이지로 이동
			else {
				
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN_RESULT_MSG", "비밀번호가 일치하지 않습니다.");
				
				response.sendRedirect("Login.jsp");
			}
		}
		// 아이디가 존재하지 않는 경우 -> 회원가입 페이지로 이동
		else {
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_RESULT_MSG", "존재하지 않는 계정입니다.");
			
			response.sendRedirect("Login.jsp");
		}
	}
}
