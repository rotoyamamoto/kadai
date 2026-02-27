<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<%@page import="bean.Student, java.util.List" %>

<%
	List<Student> list = (List<Student>)request.getAttribute("list");
%>

<p>学生を選択してください。</p>
<form action="disp" method="get">
	<select name="id">
		<%for (Student s: list) { %>
		<option value="<%=s.getStudentId() %>"><%=s.getStudentName() %></option>
		<%} %>
	</select>
	<input type="submit" value="送信">
</form>

<%@include file="../footer.html" %>