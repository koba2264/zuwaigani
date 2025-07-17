<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者情報編集確認</title>
</head>
<body>
<h1>利用者情報追加</h1>
<h3>こちらの内容でよろしいですか？</h3>
<table border="">
	<tr>
		<td>ID</td>
		<td>${ user.id }</td>
	</tr>
	<tr>
		<td>名前</td>
		<td>${ user.name }</td>
	</tr>
	<tr>
		<td>フリガナ</td>
		<td>${ user.namef }</td>
	</tr>
	<tr>
		<td>性別</td>
		<td>${ user.gender.getName() }</td>
	</tr>
	<tr>
		<td>血液型</td>
		<td>A</td>
	</tr>
	<tr>
		<td>生年月日</td>
		<td>${ user.birthDay }</td>
	</tr>
	<tr>
		<td>電話番号</td>
		<td>${ user.number }</td>
	</tr>
	<tr>
		<td>住所</td>
		<td>${ user.address }</td>
	</tr>
	<tr>
		<td>非常時連絡先１</td>
		<td>${ user.sos1 }</td>
	</tr>
	<tr>
		<td>非常時連絡先２</td>
		<td>${ user.sos2 }</td>
	</tr>
	<tr>
		<td>配偶者の有無</td>
		<c:choose>
			<c:when test="${ user.spouse }">
				<td>有</td>
			</c:when>
			<c:otherwise>
				<td>なし</td>
			</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td>在籍情報</td>
		<c:choose>
			<c:when test="${ user.enrollment }">
				<td>在籍</td>
			</c:when>
			<c:otherwise>
				<td>除籍</td>
			</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td>区分</td>
		<td>${ user.section.getName() }</td>
	</tr>
</table>

<div>
	<input type="submit" value="戻る">
	<form action="EditComp.action" method="post">
		<input type="hidden" name=id value="${ user.id }">
		<input type="hidden" name=telnum value="${ user.number }">
		<input type="hidden" name=address value="${ user.address }">
		<input type="hidden" name=sos1 value="${ user.sos1 }">
		<input type="hidden" name=sos2 value="${ user.sos2 }">
		<input type="hidden" name=spouse value="${ user.spouse }">
		<input type="hidden" name=enrollment value="${ user.enrollment }">
		<input type="hidden" name=section value="${ user.section.name() }">
		<input type="submit" value="更新">
	</form>
</div>

</body>
</html>