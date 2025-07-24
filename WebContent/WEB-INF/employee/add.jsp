<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員情報追加</title>
</head>
<body>
<h1>従業員情報追加</h1>
<form action="Employeeaddcheck.action" method="post">
	<div>
		<label for="id">ID</label>
		<span>必須</span>
		<input id="id" type="text" name="id" pattern="[a-zA-Z0-9]{8}" required>
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
		<label>血液型</label>
		<span>必須</span>
		<input id="A" type="radio" name="blood" value="A" required>
		<label for="A">A型</label>
		<input id="B" type="radio" name="blood" value="B">
		<label for="B">B型</label>
		<input id="O" type="radio" name="blood" value="O">
		<label for="O">O型</label>
		<input id="AB" type="radio" name="blood" value="AB">
		<label for="AB">AB型</label>
	</div>
	<div>
		<label for="birthday">生年月日</label>
		<span>必須</span>
		<input id="birthday" type="date" name="birthday" required>
	</div>
	<div>
		<label>区分</label>
		<span>必須</span>
		<input id="admin" type="radio" name="role" value="ADMIN" required>
		<label for="admin">管理者</label>
		<input id="worker" type="radio" name="role" value="COMMON">
		<label for="worker">従業員</label>
	</div>
	<div>
		<label>配偶者</label>
		<span>必須</span>
		<input id="true" type="radio" name="spouse" value="true" required>
		<label for="true">いる</label>
		<input id="false" type="radio" name="spouse" value="false">
		<label for="false">いない</label>
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
		<input type="submit" value="確定">
	</div>
</form>

</body>
</html>