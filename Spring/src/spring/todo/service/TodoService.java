package spring.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.todo.dao.TodoMapper;
import spring.todo.dto.Todo;

@Service
public class TodoService {

	@Autowired
	TodoMapper todoMapper;
	
	@Transactional(readOnly = true)
	public List<Todo> getTodoList(){
		
		return todoMapper.getTodoList();
	}
	
	@Transactional(readOnly = false)
	public void addTodo(Todo todo) {
		
		todoMapper.addTodo(todo);
	}
	@Transactional(readOnly = false)
	public void updateStatus(Todo todo) {
		
		boolean isComplate = todo.getStatus();
		todo.setStatus(!isComplate);
		
		todoMapper.updateStatus(todo);
	}
	@Transactional(readOnly = false)
	public void deleteTodo(Todo todo) {
		
		todoMapper.deleteTodo(todo);
	}
}
