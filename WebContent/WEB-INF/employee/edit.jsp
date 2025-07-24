<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員情報編集</title>
<link rel="stylesheet" href="/zuwaigani/css/add.css">
</head>
<body>
<h1>従業員情報更新</h1>
<form action=".action" method="post">
	<div>
		<label for="name">名前</label>
		<span>変更可能</span>
		<input id="name" type="text" name="name" pattern="[\s\S]*" value="" required>
	</div>
	<div>
		<label for="namef">フリガナ</label>
		<span>変更可能</span>
		<input id="namef" type="text" name="namef" pattern="[\u30A1-\u30F6 | \s\S]*" value="" required>
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
		<label>区分</label>
		<span>変更可能</span>
		<input id="admin" type="radio" name="section" value="admin" required>
		<label for="admin">管理者</label>
		<input id="worker" type="radio" name="section" value="worker">
		<label for="worker">従業員</label>
	</div>
	<div>
		<label for="post-select">役職</label>
		<span>変更可能</span>
		<select name="posts" id="post-select" value="">
			<option value="carer">介護士</option>
			<option value="assist">介護助手</option>
			<option value="welfare">介護福祉士</option>
			<option value="support">介護支援専門員</option>
			<option value="consult">生活相談員</option>
			<option value="service">サービス提供責任者</option>
		</select>
	</div>
	<div>
		<label>在籍情報</label>
		<span>変更可能</span>
		<input id="ent" type="radio" name="enrol" value="ent" required>
		<label for="ent">在籍</label>
		<input id="exit" type="radio" name="enrol" value="exit">
		<label for="exit">退職</label>
	</div>
	<div>
		<input type="submit" value="確定">
	</div>
</form>

</body>
</html>