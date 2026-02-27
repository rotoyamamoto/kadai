<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>

<h1>学生登録</h1>
<p>追加する学生の情報を入力してください。</p>
<form action="ok" method="get">
	<p>
		<label>学生番号：</label>
		<input type="number" name="studentId" required>
	</p>
	<p>
		<label>学生名：</label>
		<input type="text" name="studentName" required>
	</p>
	<p>
		<label>コース番号：</label>
		<select name="courseId">
			<c:forEach var="course" items="${courses}">
				<option value="${course.courseId}">${course.courseId}</option>
			</c:forEach>
		</select>
	</p>
	<input type="submit" value="送信">
</form>

<p><a href="../menu">メニューへ</a></p>

<%@include file="../footer.html" %>
