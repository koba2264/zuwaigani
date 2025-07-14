<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="css/login.css">

</head>
<body>
<form action="Login.action" method="post">
	<div>
		<p for="userid">ユーザーID</p>
		<input id="userid" type="text" name="userid">
	</div>
	<div>
		<p for="pass">パスワード</p>
		<input id="pass" type="password" name="pass">
	</div>
	<div>
		<input type="submit" value="ログイン">
	</div>
</form>
</body>
</html>