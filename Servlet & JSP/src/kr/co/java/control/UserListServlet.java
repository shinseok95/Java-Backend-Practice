package kr.co.java.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("LOGIN_SUCCESS_USER");
		
		if(user != null) {
			UserDAO dao = new UserDAO();
			UserService userService = new UserServiceImpl(dao);
			
			List<UserVO> userList = userService.queryUserList();
			
			request.setAttribute("USER_LIST", userList);
			request.setAttribute("USER_ID", user.getId());
			
			RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
			rd.forward(request, response);
		}
		else 
			response.sendRedirect("Login.jsp");
	}
}
