<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者情報追加画面</title>
<link rel="stylesheet" href="/zuwaigani/css/add.css">
</head>
<body>
<h1>利用者情報追加</h1>
<form action="Useraddcheck.action" method="post">

	<div>
		<label for="id">ID</label>
		<span>必須</span>
		<input id="id" type="text" name="id" placeholder="CUST0001" pattern="[\s\S]*" required>
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
		<input id="MALE" type="radio" name="gender" value="MALE" required>
		<label for="MALE">男</label>
		<input id="FEMALE" type="radio" name="gender" value="FEMALE">
		<label for="FEMALE">女</label>
		<input id="NO" type="radio" name="gender" value="NO">
		<label for="NO">無回答</label>
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
		<label>配偶者の有無</label>
		<span>必須</span>
		<input id="yes" type="radio" name="spouse" value="yes" required>
		<label for="yes">有</label>
		<input id="no" type="radio" name="spouse" value="no">
		<label for="no">無</label>
	</div>
	<div>
		<label>区分</label>
		<span>必須</span>
		<input id="MOVEIN" type="radio" name="section" value="MOVEIN" required>
		<label for="MOVEIN">入居</label>
		<input id="DAYSERVICE" type="radio" name="section" value="DAYSERVICE">
		<label for="DAYSERVICE">デイサービス</label>
	</div>
	 <div class="button-container">
             <button onclick="location.href='/zuwaigani/menu.jsp'" class="btn">メニューへ</button>
           <input type="submit" value="確定">
        </div>
</form>

</body>
</html>