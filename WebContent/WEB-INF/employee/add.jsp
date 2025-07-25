<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員情報追加</title>
<link rel="stylesheet" href="/zuwaigani/css/add.css">
</head>
<body>
<h1>従業員情報追加</h1>
<form action="Employeeaddcheck.action" method="post">
	<div>
		<label for="id">ID</label>
		<span>必須</span>
		<input id="id" type="text" name="id" placeholder="英数字８桁で入力" pattern="[a-zA-Z0-9]{8}" required>
	</div>
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
		<label>性別</label>
		<span>必須</span>
		<input id="man" type="radio" name="gender" value="MALE" required>
		<label for="man">男</label>
		<input id="weman" type="radio" name="gender" value="FEMALE">
		<label for="weman">女</label>
		<input id="no" type="radio" name="gender" value="NO">
		<label for="no">無回答</label>
	</div>
	<div>
		<label for="birthday">生年月日</label>
		<span>必須</span>
		<input id="birthday" type="date" name="birthday" required>
	</div>
	<div>
		<label>区分</label>
		<span>必須</span>
		<input id="管理者" type="radio" name="blood" value="管理者" required>
		<label for="管理者">管理者</label>
		<input id="スタッフ" type="radio" name="blood" value="スタッフ">
		<label for="スタッフ">スタッフ</label>
	</div>
	<div>
		<label for="post-select">役職</label>
		<span>必須</span>
		<select name="job" id="post-select">
			<option value="DOCTOR">医者</option>
			<option value="NURSE">看護士</option>
			<option value="CARER">介護士</option>
			<option value="ASSIST">介護助手</option>
			<option value="WELFARE">介護福祉士</option>
			<option value="SUPPORT">介護支援専門員</option>
			<option value="CONSULT">生活相談員</option>
			<option value="SERVICE">サービス提供責任者</option>
			<option value="NO">なし</option>
		</select>
	</div>
	<div>
		<label>在籍情報</label>
		<span>必須</span>
		<input id="在籍" type="radio" name="section" value="在籍" required>
		<label for="在籍">在籍</label>
		<input id="退職" type="radio" name="section" value="退職">
		<label for="退職">退職</label>
	</div>
	<div>
		<input type="submit" value="確定">
	</div>
</form>

</body>
</html>