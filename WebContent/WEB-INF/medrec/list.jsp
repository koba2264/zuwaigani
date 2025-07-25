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


</body>
<script>
	document.querySelectorAll('.user-list').forEach((element) => {
		element.addEventListener('click', () => {
			const id = element.getElementsByClassName("id")[0].value;
		    const form = document.createElement('form');
		    const request = document.createElement('input');

		    form.method = 'POST';
		    form.action = 'Medrec.action';

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