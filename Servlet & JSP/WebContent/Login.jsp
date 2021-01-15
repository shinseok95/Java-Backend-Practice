<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<%

	// 세션으로 Message 저장
	String msg = (String)session.getAttribute("LOGIN_RESULT_MSG");
	session.removeAttribute("LOGIN_RESULT_MSG");
	
	// 쿠키로 Message 저장
	/*
	String msg = null;
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie c : cookies){
			if(c.getName().equals("LOGIN_RESULT_MSG")){
				msg = URLDecoder.decode(c.getValue());
				
				Cookie tmpCookie = new Cookie("LOGIN_RESULT_MSG","");
				tmpCookie.setPath("/");
				tmpCookie.setMaxAge(-1);
				
				response.addCookie(tmpCookie);
				break;
			}
		}
	}
	*/
%>

<h1>로그인</h1>

<%
	if(msg != null){
%>
	<div id="LOGIN_RESULT_MSG"><%=msg%></div><br>
<%}%>

<form action="LoginServlet" method="post">

	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="ID">
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="PW">
		</tr>
	</table><br>
	
	<input type="submit" name="Login" value="로그인">
</form>
	<button onclick="location.href='SignIn.jsp'">회원가입</button>
</body>
</html>