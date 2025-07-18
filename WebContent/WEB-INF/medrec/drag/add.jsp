<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>処方箋追加画面</title>
</head>
<body>
<form action=".action" method="post">
	<div>
		<label for="dragname">薬名:</label>
		<input id="dragname" type="text" name="dragname" pattern="[\s\S]*" required>
	</div>
	<div>
		<label for="timing">投薬:</label>
		<input id="timing" type="text" name="timing" pattern="[\s\S]*" required>
	</div>
	<div>
		<label for="dragamount">薬量:</label>
		<input id="dragamount" type="text" name="dragamount" pattern="[\s\S]*" required>
	</div>
	<div>
		<input type="submit" value="追加">
	</div>
<form>
<div>
	<input type="submit" value="戻る">
</div>

</body>
</html>