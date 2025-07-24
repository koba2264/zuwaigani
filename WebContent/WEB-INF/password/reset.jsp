<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワードリセット確認画面</title>
<link rel="stylesheet" href="/zuwaigani/css/reset.css">
</head>
<body>
<div class="container">
    <h1>パスワードリセット</h1>
    <div class="message">
        <p><span class="user-name">大原 太郎</span>さんの</p>
        <p>パスワードをリセットします。</p>
    </div>
    <div class="button-container">
        <button onclick="location.href='/zuwaigani/menu.jsp'" class="btn">メニューへ</button>
        <input type="submit" value="確認" class="btn btn-confirm">
    </div>
</body>
</html>