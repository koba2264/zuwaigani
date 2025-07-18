<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワード変更画面</title>
</head>
<body>
<h1>パスワード変更</h1>
<p>大原 太郎さんの</p>
<p>パスワードを変更します。</p>

<div>
	<label>ユーザーID</label>
	<p>empl0001</p>
</div>
<div>
	<label for="newpass">新しいパスワード</label>
	<p>${ user.newpass }</p>
	<input type="password" name="newpass" value="${ user.newpass }">
</div>

<div>
	<input type="submit" value="変更">
</div>

</body>
</html>