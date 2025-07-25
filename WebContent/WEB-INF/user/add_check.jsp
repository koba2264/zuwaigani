<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者情報追加確認</title>
<link rel="stylesheet" href="/zuwaigani/css/addcheck.css">
</head>
<body>
<h1>利用者情報追加確認</h1>
<form action="Useraddcheck.action" method="post">

<h3>こちらの内容でよろしいですか？</h3>
<table border="1" class="user-addcheck">
<tr>
	<td>ID</td>
	<td>${user.id}</td>
</tr>
<tr>
	<td>名前</td>
	<td>${user.name}</td>
</tr>
<tr>
	<td>フリガナ</td>
	<td>${user.namef}</td>
</tr>
<tr>
	<td>性別</td>
	<td>${user.gender == 'MALE' ? '男' : user.gender == 'FEMALE' ? '女' : '無回答'}</td>
</tr>
<tr>
	<td>血液型</td>
	<td>${user.blood}型</td>
</tr>
<tr>
	<td>生年月日</td>
	<td>${user.birthDay}</td>
</tr>
<tr>
	<td>電話番号</td>
	<td>${user.number}</td>
</tr>
<tr>
	<td>住所</td>
	<td>${user.address}</td>
</tr>
<tr>
	<td>非常時連絡先１</td>
	<td>${user.sos1}</td>
</tr>
<tr>
	<td>非常時連絡先２</td>
	<td>${user.sos2}</td>
</tr>
<tr>
	<td>配偶者の有無</td>
	<td>${user.spouse ? '有' : '無'}</td>
</tr>
<tr>
	<td>区分</td>
	<td>${user.section == 'MOVEIN' ? '入居' : 'デイサービス'}</td>
</tr>
</table>

<div>
	<input type="submit" name="action" value="戻る">
	<input type="submit" name="action" value="追加">
</div>
</form>
</body>
</html>