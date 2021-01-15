<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>

<h1>회원 정보 수정</h1>

<%
	String msg = (String)session.getAttribute("UPDATE_RESULT_MSG");
	session.removeAttribute("UPDATE_RESULT_MSG");

	if(msg != null){
%>
<div id="msg"><%=msg%></div>
<%}%>

<form action="UserUpdateServlet" method="post">

	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="NAME" value=<%=request.getParameter("NAME") %>></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="ID" value=<%=request.getParameter("ID") %> readonly></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="PW" value=<%=request.getParameter("PW") %>></td>
		</tr>
	</table>
	
	<input type="submit" value="정보수정">
</form>

</body>
</html>