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

	String msg = (String)session.getAttribute("LOGIN_FAIL");
	session.removeAttribute("LOGIN_FAIL");
	
	/*
	String msg = null;
	Cookie[] cookies = request.getCookies();
	
	if(cookies !=null){
		for(Cookie cookie : cookies){
			if("loginMsg".equals(cookie.getName())){
				msg=URLDecoder.decode(cookie.getValue());
				
				Cookie cookie2 = new Cookie("loginMsg","");
				cookie2.setPath("/");
				cookie2.setMaxAge(-1);
				response.addCookie(cookie2);
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
	<div id="msg"><%=msg %></div>
<%}%>

	<form name="form "action="todos/list" onsubmit="return validate()" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="Password" name="password"></td>
		</tr>
	</table>
	
	<input type="submit" value="로그인">
	
	</form>
	
<script language="javascript">

	function validate(){
		
		if(form.id.value==""){
			alert("ID를 적어주세요.");
			return false;
		}
		if(form.password.value==""){
			alert("Password를 적어주세요.");
			return false;
		}
	}

</script>
	
</body>
</html>