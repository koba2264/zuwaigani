<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申し送り事項追加画面</title>
</head>
<body>
<h1>申し送り事項追加</h1>

<form action=".action" method="post">
	<div>
		<label for="mang">申し送り事項</label>
		<input id="mang" type="text" name="mang" pattern="[\s\S]*" required>
	</div>
	<div>
		<input type="submit" value="追加">
		<input type="submit" value="戻る">
	</div>
</form>

</body>
</html>