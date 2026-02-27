<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%
	int price = (Integer)session.getAttribute("price");
	int quantity = (Integer)session.getAttribute("quantity");
%>
<p>単価<%=price %>円の物を<%=quantity %>個買ったら、<%=price * quantity %>円です。</p>

<%@include file="../footer.html" %>