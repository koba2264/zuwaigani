<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者一覧</title>
<link rel="stylesheet" href="/zuwaigani/css/list.css">
</head>
<body>
<!-- 利用者等々 
        <h1>利用者一覧</h1>
            <div class="user-list">
				<span>利用者ID</span>
				<span>利用者名</span>
				<span>利用者性別</span>
				<span>利用者区分</span>
			</div>
			<c:forEach var="user" items="${ users }">
	            <div class="user-list">
					<span>${ user.id }</span>
					<span>${ user.name }</span>
					<span>${ user.gender.getName() }</span>
					<span>${ user.section.getName() }</span>
					<input class="id" type="hidden" name="id" value="${ user.id }">
				</div>
			</c:forEach>
-->


<div class="container">

    <h1>利用者一覧</h1>
    <div class="user-list-container">
        <div class="user-list">
            <span>利用者ID</span>
            <span>利用者名</span>
            <span>利用者性別</span>
            <span>利用者区分</span>
        </div>
        
        <c:forEach var="user" items="${ users }">
	            <div class="user-list">
					<span>${ user.id }</span>
					<span>${ user.name }</span>
					<span>${ user.gender.getName() }</span>
					<span>${ user.section.getName() }</span>
					<input class="id" type="hidden" name="id" value="${ user.id }">
				</div>
			</c:forEach>
        
        <!-- サンプルデータ -->
        <div class="user-list">
            <span>U001</span>
            <span>田中 花子</span>
            <span>女性</span>
            <span>要介護1</span>
            <input class="id" type="hidden" name="id" value="U001">
        </div>
        
        <div class="user-list">
            <span>U002</span>
            <span>佐藤 太郎</span>
            <span>男性</span>
            <span>要介護2</span>
            <input class="id" type="hidden" name="id" value="U002">
        </div>
        
        <div class="user-list">
            <span>U003</span>
            <span>鈴木 美智子</span>
            <span>女性</span>
            <span>要支援1</span>
            <input class="id" type="hidden" name="id" value="U003">
        </div>
        
        <div class="user-list">
            <span>U004</span>
            <span>高橋 次郎</span>
            <span>男性</span>
            <span>要介護3</span>
            <input class="id" type="hidden" name="id" value="U004">
        </div>
        
        <div class="user-list">
            <span>U005</span>
            <span>山田 良子</span>
            <span>女性</span>
            <span>要支援2</span>
            <input class="id" type="hidden" name="id" value="U005">
        </div>
    </div>
</div>
</body>
<script>
	document.querySelectorAll('.user-list').forEach((element) => {
		element.addEventListener('click', () => {
			const id = element.getElementsByClassName("id")[0].value;
		    const form = document.createElement('form');
		    const request = document.createElement('input');

		    form.method = 'POST';
		    form.action = 'Useredit.action';

		    request.type = 'hidden';
		    request.name = 'id';
		    request.value = id;

		    form.appendChild(request);
		    document.body.appendChild(form);

		    form.submit();
		})
	})
</script>
</html>