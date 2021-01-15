<%@page import="java.util.Iterator"%>
<%@page import="kr.co.java.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>

<h1>회원 리스트</h1>

<h2><%=request.getAttribute("USER_ID")%>님 반갑습니다.</h2>

<%
List<UserVO> userList = (List<UserVO>)request.getAttribute("USER_LIST");

if(userList != null){
	Iterator<UserVO> iter = userList.iterator();
%>

<table>

	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
<%
	while(iter.hasNext()){
		UserVO user = iter.next();
%>

	<tr>
		<td><%=user.getName()%></td>
		<td><%=user.getId()%></td>
		
<%
	if(request.getAttribute("USER_ID").equals(user.getId())){
%>
		<td><a href='Update.jsp?ID=<%=user.getId()%>&PW=<%=user.getPwd()%>&NAME=<%=user.getName()%>'>수정</a></td>
		<td><a href='UserDeleteServlet?ID=<%=user.getId()%>'>삭제</a></td>
	</tr>
<%
	}else{
%>
		<td>수정</td>
		<td>삭제</td>
	</tr>
<%}}}%>

</table>


<button onclick="location.href='UserLogoutServlet'">로그아웃</button>

</body>
</html>