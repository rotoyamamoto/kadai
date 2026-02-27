<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<h1>学生検索</h1>
<form action="rs" method="get">
	<label>お名前：</label>
	<input type="text" name="name">
	<input type="submit" value="送信">
</form>

<p><a href="../menu">メニューへ</a></p>

<%@include file="../footer.html" %>
