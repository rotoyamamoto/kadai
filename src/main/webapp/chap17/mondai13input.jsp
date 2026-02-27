<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<p>商品の値段と個数を入力してください。</p>
<form action="while" method="get">
	値段：<input type="text" name="price"><br>
	個数：<input type="number" name="quantity"><br>
	<input type="submit" value="追加">
</form>

<%@include file="../footer.html" %>