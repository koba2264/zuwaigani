<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員情報重複エラー</title>
<link rel="stylesheet" href="/zuwaigani/css/error.css">
</head>
<body>
<div class="container">
    <div class="main-card">
        <div class="error-icon"></div>
        <h1>従業員情報追加</h1>
        <p class="error-message">入力された従業員情報は既に登録されています</p>
        <div class="button-container">
            <button onclick="history.back();" class="btn">戻る</button>
            <button onclick="location.href='employee-list.jsp'" class="btn secondary-btn">従業員一覧を確認</button>
        </div>
    </div>
    
    <div class="error-details">
        <h3>エラーの詳細</h3>
        <p>同じ従業員IDまたは従業員情報が既にシステムに登録されているため、追加できませんでした。</p>
    </div>
    
    <div class="suggestions">
        <h3>解決方法</h3>
        <ul>
            <li>従業員一覧で既存の情報を確認してください</li>
            <li>異なる従業員IDを使用して再度登録してください</li>
            <li>既存の従業員情報を更新する場合は編集機能をご利用ください</li>
            <li>不明な点がある場合は管理者にお問い合わせください</li>
        </ul>
    </div>
</div>
</body>
</html>