<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>診療録編集（アレルギー追加）画面</title>
</head>
<body>
<h1>アレルギー追加</h1>
<form action=".action" method="post">
	<div>
		<label for="allergy">アレルギー</label>
		<input id="allergy" type="text" name="allergy" pattern="[\s\S]*" required>
	</div>
	<div>
		<input type="submit" value="追加">
	</div>
</form>
<div>
	<input type="submit" value="戻る">
</div>

</body>
</html>