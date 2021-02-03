<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To do List</title>
</head>
<body>

<h1>To do List</h1>
<button onclick="location.href='/Todo/todos/logout'">로그아웃</button><br><br>

<form name="form" action="add" onsubmit="return validate()" method="post">

<table>

	<tr>
		<td><input type="hidden" name="status" value = "0"></td>
	</tr>

	<tr>
		<td>할 일 </td>
		<td><input type="text" name="content"></td>
		<td><input type="submit" value="등록"></td>
	</tr>

</table>
</form><br>

<table>

	<tr>
	<th>할 일 </th>
	<th>진행 상황 </th>
	<th></th>
	<tr>
	
	<c:forEach var="todo" items="${TODOLIST}">
		<tr>
			<td>${todo.content}</td>
			<td>
				<c:if test="${todo.status eq true}">
					<button onclick="location.href='/Todo/todos/update?id=${todo.id}&status=${todo.status}'">완료</button>
				</c:if>
				<c:if test="${todo.status eq false}">
					<button onclick="location.href='/Todo/todos/update?id=${todo.id}&status=${todo.status}'">진행중</button>
				</c:if>
			</td>
			<td><button onclick="location.href='/Todo/todos/delete?id=${todo.id}'">삭제</button></td>
		</tr>
	</c:forEach>

</table>

<script language="javascript">

	function validate(){
		
		if(form.content.value==""){
			alert("할 일을 적어주세요.");
			return false;
		}
		if(form.content.value.length>=30){
			alert("입력 가능한 문자 수를 초과했습니다.");
			return false;
		}
	}

</script>

</body>
</html>