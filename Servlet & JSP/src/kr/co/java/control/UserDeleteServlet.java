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

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean resultFlag = false;
		String id = request.getParameter("ID");
		
		UserDAO dao = new UserDAO();
		UserService userService = new UserServiceImpl(dao);
		
		resultFlag = userService.deleteUser(id);
		
		// 삭제에 성공하였다면
		if(resultFlag) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_RESULT_MSG", "성공적으로 회원탈퇴 되었습니다.");
			
			response.sendRedirect("Login.jsp");
		}
		// 삭제에 실패하였다면
		else {
			response.sendRedirect("UserListServlet");
		}
	}

}
