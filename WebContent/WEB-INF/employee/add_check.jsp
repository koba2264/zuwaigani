<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員情報追加確認</title>
<link rel="stylesheet" href="/zuwaigani/css/addcheck.css">
</head>
<body>
<h1>従業員情報追加</h1>
<h3>こちらの内容でよろしいですか？</h3>
<table border="">
	<tr>
		<td>ID</td>
		<td>${ employee.id }</td>
	</tr>
	<tr>
		<td>名前</td>
		<td>${ employee.name }</td>
	</tr>
	<tr>
		<td>フリガナ</td>
		<td>${ employee.namef }</td>
	</tr>
	<tr>
		<td>性別</td>
		<td>${ employee.gender.getName() }</td>
	</tr>
	<tr>
		<td>血液型</td>
		<td>A</td>
	</tr>
	<tr>
		<td>生年月日</td>
		<td>${ employee.birthDay }</td>
	</tr>
	<tr>
		<td>区分</td>
		<td>${ employee.role.getName() }</td>
	</tr>
	<tr>
		<td>配偶者</td>
		<td>
		<c:choose>
			<c:when test="${ employee.spouse }">いる</c:when>
			<c:otherwise>いない</c:otherwise>
		</c:choose>
		</td>
	</tr>
	<tr>
		<td>役職</td>
		<td>${ employee.job.getName() }</td>
	</tr>

</table>

<div>
	<form action="AddComp.action" method="post">
		<input type="hidden" name="id" value="${ employee.id }">
		<input type="hidden" name="name" value="${ employee.name }">
		<input type="hidden" name="namef" value="${ employee.namef }">
		<input type="hidden" name="gender" value="${ employee.gender.name() }">
		<input type="hidden" name="birthday" value="${ employee.birthDay }">
		<input type="hidden" name="role" value="${ employee.role.name() }">
		<input type="hidden" name="spouse" value="${ employee.spouse }">
		<input type="hidden" name="job" value="${ employee.job.name() }">
		<input type="submit" value="追加">
	</form>
	<input type="submit" value="戻る">
</div>

</body>
</html>