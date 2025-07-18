<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メッセージ</title>
<link rel="stylesheet" href="/zuwaigani/css/list.css">
</head>
<body>
        <h1>利用者一覧 メッセージ</h1>
            <div class="user-list">
				<span>従業員ID</span>
				<span>従業員名</span>
				<span>性別</span>
				<span>区分</span>
				<span>新着</span>
			</div>
			<c:forEach var="employee" items="${ employeeList }">
	            <div class="user-list">
					<span>${ employee.id }</span>
					<span>${ employee.name }</span>
					<span>${ employee.gender.getName() }</span>
					<span>${ employee.role.getName() }</span>
					<span>${ employee.messageNum }</span>
					<input class="id" type="hidden" name="id" value="${ employee.id }">
					<input class="name" type="hidden" name="name" value="${ employee.name }">
				</div>
			</c:forEach>


</body>
<script>
	document.querySelectorAll('.user-list').forEach((element) => {
		element.addEventListener('click', () => {
			const id = element.getElementsByClassName("id")[0].value;
			const name = element.getElementsByClassName("name")[0].value;
		    const form = document.createElement('form');
		    const request = document.createElement('input');
		    const request2 = document.createElement('input');

		    form.method = 'POST';
		    form.action = 'Message.action';

		    request.type = 'hidden';
		    request.name = 'id';
		    request.value = id;
		    request2.type = 'hidden';
		    request2.name = 'name';
		    request2.value = name;

		    form.appendChild(request);
		    form.appendChild(request2);
		    document.body.appendChild(form);

		    form.submit();
		})
	})
</script>
</html>