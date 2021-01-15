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

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		boolean resultFlag = false;
		HttpSession session = request.getSession();
		
		String name = request.getParameter("NAME");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		
		UserVO user = new UserVO(id,pw,name);
		UserDAO dao = new UserDAO();
		UserService userService = new UserServiceImpl(dao);

		resultFlag = userService.updateUser(user);
		
		// 정보 수정이 성공했다면
		if(resultFlag) {
			session.setAttribute("LOGIN_RESULT_MSG", "회원 정보가 수정되었습니다.<br>다시 로그인 해주세요");
			
			response.sendRedirect("Login.jsp");
		}
		// 정보 수정이 실패했다면
		else {
			session.setAttribute("UPDATE_RESULT_MSG", "회원 정보가 수정에 실패하였습니다.");
			
			response.sendRedirect("Update.jsp");
		}
	}
}
