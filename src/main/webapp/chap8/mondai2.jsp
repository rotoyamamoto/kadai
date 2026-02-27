<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="mondai2error.jsp" %>
<%
int age = Integer.parseInt(request.getParameter("age"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap8/mondai1</title>
</head>
<body>
こんにちは、<%=request.getParameter("name") %>さん<br>
10年後には<%= age + 10 %>歳ですね！
</body>
</html>