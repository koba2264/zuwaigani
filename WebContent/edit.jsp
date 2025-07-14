<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者情報編集</title>
</head>
<body>
<h1>利用者情報更新</h1>
<form action=".action" method="post">
	<div>
		<label for="name">名前</label>
		<p>大原　太郎</p>
	</div>
	<div>
		<label for="namef">フリガナ</label>
		<p>オオハラ　タロウ</p>
	</div>
	<div>
		<label>性別</label>
		<p>男性</p>
	</div>
	<div>
		<label>血液型</label>
		<p>A型</p>
	</div>
	<div>
		<label for="birthday">生年月日</label>
		<p>2025/07/14</p>
	</div>
	<div>
		<label for="telnum">電話番号</label>
		<span>変更可能</span>
		<input id="telnum" type="tel" name="telnum" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}" value="" required>
	</div>
	<div>
		<label for="address">住所</label>
		<span>変更可能</span>
		<input id="address" type="text" name="address" value="" required>
	</div>
	<div>
		<label for="sos1">非常時連絡先１</label>
		<span>変更可能</span>
		<input id="sos1" type="tel" name="sos1" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}" value="" required>
	</div>
	<div>
		<label for="sos2">非常時連絡先２</label>
		<span>変更可能</span>
		<input id="sos2" type="tel" name="sos2" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4} "value="">
	</div>
	<div>
		<label>配偶者の有無</label>
		<span>変更可能</span>
		<input id="yes" type="radio" name="spouse" value="yes" required>
		<label for="yes">有</label>
		<input id="no" type="radio" name="spouse" value="no">
		<label for="no">無</label>
	</div>
	<div>
		<label>在籍情報</label>
		<span>変更可能</span>
		<input id="ent" type="radio" name="enrol" value="ent" required>
		<label for="ent">在籍</label>
		<input id="exit" type="radio" name="enrol" value="exit">
		<label for="exit">除籍</label>
	</div>
	<div>
		<label>区分</label>
		<span>変更可能</span>
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