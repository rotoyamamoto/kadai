<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<p>追加するコースの名前を入力してください。</p>
<form action="insert" method="get">
	<input type="text" name="courseName">
	<input type="submit" value="送信">
</form>

<%@include file="../footer.html" %>