<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>PersonalChat</title>
  <!-- Google Fonts (Poppins) -->
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
  <!-- Font Awesome (for icons) -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <!-- CSS stylesheet -->
  <link rel="stylesheet" href="/zuwaigani/css/personalChat.css">
</head>
<body>
  <div class="chat-app">
    <!-- 左側ナビゲーションメニュー -->
    <aside class="sidebar-menu">
      <button class="collapse-btn"><i class="fas fa-chevron-left"></i></button>
      <button class="menu-btn active"><i class="fas fa-comment-dots"></i></button>
      <button class="menu-btn"><i class="fas fa-user"></i></button>
      <button class="menu-btn"><i class="fas fa-bell"></i></button>
      <button class="menu-btn"><i class="fas fa-cog"></i></button>
    </aside>

    <div id="myId" data-name="${ id }"></div>

    <!-- 左側チャットリストパネル -->
    <aside class="left-sidebar">
      <div class="left-header">
        <h2 class="left-title">Personal Chat</h2>
        <div class="left-subheader">
          <span class="section-title">ユーザー一覧</span>
        </div>
      </div>
      <ul class="chat-list">
      <c:forEach var="employee" items="${ employeeList }">
		  <li class="chat-list-item">
          <img src="https://i.pravatar.cc/40?u=alex" alt="Alex Johnson" class="avatar">
          <div class="chat-info">
            <div class="chat-name-time">
              <span class="chat-name">${ employee.name }</span>
              <span class="chat-time">
              <c:if test="${ employee.messageNum > 0 }">
	              <span class="status-dot unread-dot"></span>
              </c:if>
              </span>
              <input type="hidden" class="name" value="${ employee.name }">
              <input type="hidden" class="id" value="${ employee.id }">
            </div>
            <c:if test="${ employee.messageList.size() > 0 }">
	            <c:choose>
	            	<c:when test="${ employee.lastMessage.isMine() }">
			            <div class="last-message"><strong>You:</strong>${ employee.lastMessage.getText() }</div>
	            	</c:when>
	            	<c:otherwise>
			            <div class="last-message"><strong>${ employee.name }:</strong>${ employee.lastMessage.getText() }</div>
	            	</c:otherwise>
	            </c:choose>
            </c:if>
          </div>
        </li>
      </c:forEach>
      </ul>
    </aside>

    <!-- 中央チャットエリア -->
    <section class="chat-area">
      <div class="chat-header">
        <div class="chat-header-user">
          <!-- <img src="https://i.pravatar.cc/32?u=jamie" alt="Jamie Lee" class="avatar"> -->
          <div class="chat-user-info">
            <div class="chat-user-name"></div>
            <div class="chat-user-status"></div>
          </div>
        </div>
        <div class="chat-header-actions">
          <button title="Search in conversation"><i class="fas fa-search"></i></button>
          <button title="Start voice call"><i class="fas fa-phone"></i></button>
          <button title="Start video call"><i class="fas fa-video"></i></button>
        </div>
      </div>
      <div class="chat-messages">
      </div>
      <div class="chat-input-area">
        <button class="attach-btn" title="Attach file"><i class="fas fa-paperclip"></i></button>
        <button class="emoji-btn" title="Emoji"><i class="fas fa-smile"></i></button>
        <input id="send-text" type="text" placeholder="Type a message...">
        <button class="send-btn" title="Send"><i class="fas fa-paper-plane"></i></button>
      </div>
    </section>
  </div>

  <!-- JavaScriptファイル -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="/zuwaigani/js/personalChat.js"></script>
</body>
</html>