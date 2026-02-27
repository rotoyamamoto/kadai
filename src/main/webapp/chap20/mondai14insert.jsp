<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<jsp:useBean id="course" class="bean.Course" scope="request" />

<p>登録完了しました。</p>
<p>登録した内容は以下の通りです。</p>
<table border=1>
	<tr>
		<th>コース番号</th>
		<td><jsp:getProperty name="course" property="courseId"/></td>
	</tr>
	<tr>
		<th>コース名</th>
		<td><jsp:getProperty name="course" property="courseName"/></td>
	</tr>
</table>


<%@include file="../footer.html" %>