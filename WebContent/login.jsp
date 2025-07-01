<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<img>システムアイコン</img>
<form action=".action" method="post">
	<div>
		<label for="userid">ユーザーID</label>
		<input id="userid" type="text" name="userid">
	</div>
	<div>
		<label for="pass">パスワード</label>
		<input id="pass" type="password" name="pass">
	</div>
	<div>
		<input type="submit" value="ログイン">
	</div>
</form>
</body>
</html>