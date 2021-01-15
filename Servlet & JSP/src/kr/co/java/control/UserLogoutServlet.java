package kr.co.java.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserLogoutServlet")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		if(session.getAttribute("LOGIN_SUCCESS_USER") !=null) {
			session.removeAttribute("LOGIN_SUCCESS_USER");
			
			session.setAttribute("LOGIN_RESULT_MSG", "성공적으로 로그아웃 되었습니다.");
		}
		
		response.sendRedirect("Login.jsp");
	}

}
