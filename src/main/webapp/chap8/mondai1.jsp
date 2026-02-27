<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chap8/mondai1</title>
</head>
<body>
こんにちは、<%=request.getParameter("name") %>(<%=request.getParameter("age") %>)さん
</body>
</html>