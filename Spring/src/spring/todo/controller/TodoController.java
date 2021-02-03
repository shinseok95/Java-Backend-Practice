package spring.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.method.annotation.SessionAttributesHandler;

import spring.todo.dto.Member;
import spring.todo.dto.Todo;
import spring.todo.service.MemberService;
import spring.todo.service.TodoService;

@Controller
@RequestMapping(path = "/todos")
public class TodoController {
	
	@Autowired
	TodoService todoService; 
	
	@Autowired
	MemberService memberService;
	
	@GetMapping
	public String login(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("LOGIN_OK");
		
		if(loginMember!=null) 
			return "redirect:/todos/list";
		else
			return "todo/loginform";
	}
		
	@RequestMapping("/list")
	public String getTodoList(Member member, ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("LOGIN_OK");
		
		if(loginMember==null) {
		
		if(member.getId()==null)
			return "redirect:/todos";
		
		if(!memberService.isMemberExist(member)) {
			
			session.setAttribute("LOGIN_FAIL","해당 아이디가 존재하지 않습니다.");
			
			return "redirect:/todos";
		}
		
		if(!memberService.isLoginAvailable(member)) {
			
			session.setAttribute("LOGIN_FAIL","비밀번호가 일치하지 않습니다.");
			
			return "redirect:/todos";
		}
		
		List<Todo> todoList = todoService.getTodoList();
		
		model.addAttribute("TODOLIST", todoList);
		
		session.setAttribute("LOGIN_OK",member);
		
		return "todo/list";
		}else {
			
			List<Todo> todoList = todoService.getTodoList();
			
			model.addAttribute("TODOLIST", todoList);
			
			return "todo/list";
		}

	}
	
	@PostMapping("/add")
	public String addTodo(Todo todo) {
		
		todoService.addTodo(todo);
		
		return "redirect:/todos";
	}
	
	@GetMapping("/delete")
	public String deleteTodo(Todo todo) {
		
		todoService.deleteTodo(todo);
		
		return "redirect:/todos";
	}
	
	@GetMapping("/update")
	public String updateStatus(Todo todo) {
		
		todoService.updateStatus(todo);
		
		return "redirect:/todos";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("LOGIN_OK");
		
		return "redirect:/todos";
	}
}
