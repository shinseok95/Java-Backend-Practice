package spring.todo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import spring.todo.dto.Todo;

@Mapper
public interface TodoMapper {
	
	public List<Todo> getTodoList();
	public void addTodo(Todo todo);
	public void updateStatus(Todo todo);
	public void deleteTodo(Todo todo);
}
