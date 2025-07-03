<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者情報追加画面</title>
</head>
<body>
<h1>利用者情報追加</h1>
<form action=".action" method="post">
	<div>
		<label for="name">名前</label>
		<span>必須</span>
		<input id="name" type="text" name="name" placeholder="大原　太郎" pattern="[\s\S]*" required>
	</div>
	<div>
		<label for="namef">フリガナ</label>
		<span>必須</span>
		<input id="namef" type="text" name="namef" placeholder="オオハラ　タロウ" pattern="[\u30A1-\u30F6 | \s\S]*" required>
	</div>
	<div>
		<span>性別</span>
		<span>必須</span>
		<input id="man" type="radio" name="gender" value="man" required>
		<label for="man">男</label>
		<input id="weman" type="radio" name="gender" value="weman">
		<label for="weman">女</label>
	</div>
	<div>
		<span>血液型</span>
		<span>必須</span>
		<input id="man" type="radio" name="gender" value="man" required>
		<label for="man">男</label>
		<input id="weman" type="radio" name="gender" value="weman">
		<label for="weman">女</label>
	</div>
	<div>
		<label for="birthday">生年月日</label>
		<span>必須</span>
		<input id="birthday" type="date" name="birthday" required>
	</div>
	<div>
		<label for="telnum">電話番号</label>
		<span>必須</span>
		<input id="telnum" type="tel" name="telnum" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}" required>
	</div>
	<div>
		<label for="address">住所</label>
		<span>必須</span>
		<input id="address" type="text" name="address" required>
	</div>
	<div>
		<label for="sos1">非常時連絡先１</label>
		<span>必須</span>
		<input id="sos1" type="tel" name="sos1" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}" required>
	</div>
	<div>
		<label for="sos2">非常時連絡先２</label>
		<input id="sos2" type="tel" name="sos2" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}">
	</div>
	<div>
		<sapn>配偶者の有無</sapn>
		<span>必須</span>
		<input id="yes" type="radio" name="spouse" value="yes" required>
		<label for="yes">有</label>
		<input id="no" type="radio" name="spouse" value="no">
		<label for="no">無</label>
	</div>
	<div>
		<span>区分</span>
		<span>必須</span>
		<input id="home" type="radio" name="section" value="home" required>
		<label for="home">入居</label>
		<input id="day" type="radio" name="section" value="day">
		<label for="day">デイサービス</label>
	</div>
	<div>
		<input type="submit" value="確定">
	</div>
</form>

</body>
</html>