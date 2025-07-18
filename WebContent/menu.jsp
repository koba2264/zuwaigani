<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>メニュー - KOBA</title>
    <link rel="stylesheet" href="css/menu.css">
</head>
<body>
    <div class="container">
        <div class="left-section">
            <div class="menu-row">
                <button class="menu-button" onclick="location.href='user/Useradd.action'">
                    利用者情報登録
                </button>
                <button class="menu-button" onclick="location.href='user/Userlist.action'">
                    利用者情報更新
                </button>
            </div>

            <div class="menu-row">
                <button class="menu-button employee" onclick="location.href='employee/Employeeadd.action'">
                    従業員情報追加
                </button>
                <button class="menu-button employee" onclick="">
                    従業員情報更新
                </button>
            </div>

            <div class="menu-row">
                <button class="menu-button employee" onclick="">
                    従業員<br>パスワードリセット
                </button>
                <button class="menu-button employee" onclick="location.href='message/Messagelist.action'">
                    チャット
                </button>
            </div>
        </div>

        <div class="right-section">
            <img src="image/koba.png" alt="koba" class="logo">
            <button class="medical-record-button" onclick="handleMenuClick('medical-record')">
                診療録
            </button>
        </div>
    </div>
