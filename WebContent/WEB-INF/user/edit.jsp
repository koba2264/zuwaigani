<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="enu.Section" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者情報編集</title>
<link rel="stylesheet" href="/zuwaigani/css/add.css">
</head>
<body>
<h1>利用者情報更新</h1>
<form action="Usereditcheck.action" method="post">
	<div>
		<label for="id">ID</label>
		<p>${ user.id }</p>
		<input type="hidden" name="id" value="${ user.id }">
	</div>
	<div>
		<label for="name">名前</label>
		<p>${ user.name }</p>
		<input type="hidden" name="name" value="${ user.name }">
	</div>
	<div>
		<label for="namef">フリガナ</label>
		<p>${ user.namef }</p>
		<input type="hidden" name="namef" value="${ user.namef }">
	</div>
	<div>
		<label>性別</label>
		<p>${ user.gender.getName() }</p>
		<input type="hidden" name="gender" value="${ user.gender.name() }">
	</div>
	<div>
		<label>血液型</label>
		<p>${ user.bloodType }型</p>
	</div>
	<div>
		<label for="birthday">生年月日</label>
		<p>${ user.birthDay }</p>
		<input type="hidden" name="birthday" value="${ user.birthDay }">
	</div>
	<div>
		<label for="telnum">電話番号</label>
		<span>変更可能</span>
		<input id="telnum" type="tel" name="telnum" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}" value="${ user.number }" required>
	</div>
	<div>
		<label for="address">住所</label>
		<span>変更可能</span>
		<input id="address" type="text" name="address" value="${ user.address }" required>
	</div>
	<div>
		<label for="sos1">非常時連絡先１</label>
		<span>変更可能</span>
		<input id="sos1" type="tel" name="sos1" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}" value="${ user.sos1 }" required>
	</div>
	<div>
		<label for="sos2">非常時連絡先２</label>
		<span>変更可能</span>
		<input id="sos2" type="tel" name="sos2" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4} "value="${ user.sos2 }">
	</div>
	<div>
		<label>配偶者の有無</label>
		<span>変更可能</span>
		<c:choose>
			<c:when test="${ user.spouse }">
				<input id="yes" type="radio" name="spouse" value="yes" required checked>
				<label for="yes">有</label>
				<input id="no" type="radio" name="spouse" value="no">
				<label for="no">無</label>
			</c:when>
			<c:otherwise>
				<input id="yes" type="radio" name="spouse" value="yes" required>
				<label for="yes">有</label>
				<input id="no" type="radio" name="spouse" value="no" checked>
				<label for="no">無</label>
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<label>在籍情報</label>
		<span>変更可能</span>
		<c:choose>
			<c:when test="${ user.enrollment }">
				<input id="ent" type="radio" name="enrollment" value="ent" required checked>
				<label for="ent">在籍</label>
				<input id="exit" type="radio" name="enrollment" value="exit">
				<label for="exit">除籍</label>
			</c:when>
			<c:otherwise>
				<input id="ent" type="radio" name="enrollment" value="ent" required >
				<label for="ent">在籍</label>
				<input id="exit" type="radio" name="enrollment" value="exit" checked>
				<label for="exit">除籍</label>
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<label>区分</label>
		<span>変更可能</span>
		<c:forEach var="section" items="${ Section.values() }">
			<c:choose>
				<c:when test="${ user.section == section }">
					<input id="${ section.name() }" type="radio" name="section" value="${ section.name() }" checked required>
					<label for="${ section.name() }">${ section.getName() }</label>
				</c:when>
				<c:otherwise>
					<input id="${ section.name() }" type="radio" name="section" value="${ section.name() }" required>
					<label for="${ section.name() }">${ section.getName() }</label>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
	<div>
		<input type="submit" value="確定">
	</div>
</form>

</body>
</html>