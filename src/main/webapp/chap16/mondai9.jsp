<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%@page import="bean.Student, java.util.List" %>

<% List<Student> list = (List<Student>)request.getAttribute("list"); %>

<h3>学生一覧</h3>
<table border=1>
	<tr>
		<th>学生番号</th>
		<th>学生名</th>
		<th>コース番号</th>
	</tr>
<% for (Student s: list) { %>
	<tr>
		<td><%=s.getStudentId() %></td>
		<td><%=s.getStudentName() %></td>
		<td><%=s.getCourseId() %></td>
	</tr>
<% } %>
</table>

<%@include file="../footer.html" %>