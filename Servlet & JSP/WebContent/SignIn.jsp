<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<%
	String msg = (String)session.getAttribute("SIGNUP_MSG");
	session.removeAttribute("SIGNUP_MSG");
%>

<h1>회원가입</h1>

<%
	if(msg != null){
%>

	<div id="msg"><%=msg%></div><br>
<%}%>

<form action="SignInServlet" method="post">

	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="NAME"></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="ID"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="PW"></td>
		</tr>
	</table>
	
	<input type="submit" value="회원가입">
</form>

</body>
</html>