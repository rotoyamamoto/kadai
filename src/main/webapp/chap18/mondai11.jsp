<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%
	Integer count = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie: cookies) {
			if (cookie.getName().equals("count")) {
				count = Integer.valueOf(cookie.getValue());
				break;
			}
		}
	}
	
	if (count == null) count = 0;
	count++;
	
	Cookie cookie = new Cookie("count", count.toString());
	cookie.setMaxAge(60 * 60 * 24 * 7);
	response.addCookie(cookie);
%>

<p>あなたは<%=count %>回目の訪問ですね。</p>

<%@include file="../footer.html" %>