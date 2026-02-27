<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%@page import="bean.Course, java.util.List" %>

<% List<Course> list = (List<Course>)request.getAttribute("list"); %>

<h3>コース一覧</h3>
<table border=1>
	<tr>
		<th>コース番号</th>
		<th>コース名</th>
	</tr>
<% for (Course c: list) { %>
	<tr>
		<td><%=c.getCourseId() %></td>
		<td><%=c.getCourseName() %></td>
	</tr>
<% } %>
</table>

<%@include file="../footer.html" %>