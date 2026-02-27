<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<h1>登録完了画面</h1>
<p>追加に成功しました。</p>
<p>学生番号：${student.studentId}</p>
<p>学生名：${student.studentName}</p>
<p>コース番号：${student.courseId}</p>
<p><a href="menu">メニューへ</a></p>

<%@include file="../footer.html" %>
