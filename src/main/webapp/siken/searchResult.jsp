<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>

<h1>検索完了画面</h1>
<p>検索キーワード：${keyword}</p>
<table border="1">
	<tr>
		<th>学生番号</th>
		<th>学生名</th>
		<th>コース番号</th>
	</tr>
	<c:forEach var="student" items="${list}">
	<tr>
		<td>${student.studentId}</td>
		<td>${student.studentName}</td>
		<td>${student.courseId}</td>
	</tr>
	</c:forEach>
</table>

<p><a href="../menu">メニューへ</a></p>

<%@include file="../footer.html" %>
