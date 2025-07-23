<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>個人チャット</title>
<link rel="stylesheet" href="/zuwaigani/css/chat.css">
</head>
<body>
	<h1 class="name">${ name }</h1>
	<div class="chat">
		<c:forEach var="message" items="${ messages }">
			<c:choose>
				<c:when test="${ message.mine }">
					<div class="left">
				</c:when>
				<c:otherwise>
					<div class="right">
				</c:otherwise>
			</c:choose>
				<p>${ message.sendingTime }</p>
				<p>${ message.text }</p>
			</div>
		</c:forEach>
		<div id="myId" data-name="${ sendId }"></div>
		<div id="sendId" data-name="${ myId }"></div>
	</div>
	<button id="test">btn</button>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/zuwaigani/js/chat.js"></script>
</body>
</html>