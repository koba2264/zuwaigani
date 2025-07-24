<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>スケジュール編集画面</title>
</head>
<body>
<form action=".action" method="post">
	<div>
		<label for="time">日時:</label>
		<input type="time" id="time" name="time" required />
	</div>
	<div>
		<label for="process-select">内容:</label>
		<select id="process-select" name="process" required>
			<option value="reha">リハビリ</option>
			<option value="toilet">排泄介助</option>
			<option value="meal">食事介助</option>
		</select>
	</div>
	<div>
		<input type="submit" value="更新">
	</div>
</form>
<div>
	<input type="submit" value="戻る">
</div>

</body>
</html>