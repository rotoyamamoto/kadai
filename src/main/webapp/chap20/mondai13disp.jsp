<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<jsp:useBean id="student" class="bean.Student" scope="request" />
<jsp:useBean id="course" class="bean.Course" scope="request" />

<p>選択された学生の情報です。</p>
<table border=1>
	<tr>
		<th>学生番号</th>
		<th>学生名</th>
		<th>コース名</th>
	</tr>
	<tr>
		<td><jsp:getProperty name="student" property="studentId"/></td>
		<td><jsp:getProperty name="student" property="studentName"/></td>
		<td><jsp:getProperty name="course" property="courseName"/></td>
	</tr>
</table>


<%@include file="../footer.html" %>