<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注意事項編集画面</title>
</head>
<body>
<p>追加する注意事項を選択し、更新ボタンを押してください</p>

<div>
	<label for="word"><img src="image/work.png" style="width:50px"></label>
	<input type="checkbox" name="careful" value="work" id="word">
	<label for="eat"><img src="image/eat.png" style="width:50px"></label>
	<input type="checkbox" name="careful" value="eat" id="eat">
	<label for="bath"><img src="image/wash.png" style="width:50px"></label>
	<input type="checkbox" name="careful" value="bath" id="bath">
	<label for="sleep"><img src="image/bed.png" style="width:50px"></label>
	<input type="checkbox" name="careful" value="sleep" id="sleep">
	<label for="drag"><img src="image/drag.png" style="width:50px"></label>
	<input type="checkbox" name="careful" value="drag" id="drag">
	<label for="toilet"><img src="image/toire.png" style="width:50px"></label>
	<input type="checkbox" name="careful" value="toilet" id="toilet">
	<label for="wcar"><img src="image/car.png" style="width:50px"></label>
	<input type="checkbox" name="careful" value="wcar" id="wcar">
</div>

<div>
	<input type="submit" value="更新">
	<input type="submit" value="戻る">
</div>
</body>
</html>