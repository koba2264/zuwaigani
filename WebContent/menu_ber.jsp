<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.container {
  width: 100vw;
  height: 88vh;
  display: flex;
}

.header {
  width: 100vw;
  height: 18vh;
  background-color: #f39c12;
  color: white;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
  box-sizing: border-box;
}

.header-left {
  display: flex;
  align-items: center;
}

.header-left i {
  font-size: 60px;
  margin-right: 20px;
}

.header-info p, .header-info h1 {
  margin: 0;
  line-height: 1.2;
}

.header-info p {
  font-size: 13px;
  font-weight: bold;
  margin-top: 8px;
}

.header-info h1 {
  font-size: 30px;
  font-weight: bold;
  margin-left: 20px;
}

.header-right {
  text-align: right;
  margin-top: 30px;
}
.header-right p {
	 margin-top: 10px;
}
.header-right button {
  background-color: #e67e22;
  color: white;
  border: none;
  border-radius: 6px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.1s ease;
  box-shadow: 0 2px 4px rgba(0,0,0,0.2);
}
.header-right button:hover {
  background-color: #d35400;
  transform: translateY(-1px);
}
.header-right button:active {
  transform: translateY(1px);
  box-shadow: none;
}

.sidebar {
	width: 15%;
	height: 100%;
	width:19vh;
	background-color: #f39c12;
	color: white;
}
.sideber-menu-box {
	display: flex;
  	flex-direction: column;
  	align-items: center;
  	justify-content: center;
 	height: 70px;
  	width: 100px;
  	margin-bottom: 5px;

}
.sideber-menu-box i {
	font-size: 40px;
	font-color: white;
	margin-bottom: 10px;
	margin-top: 10px;
}
.sideber-menu-box p {
	font-size: 10px;
	font-color: white;
	margin: 0;
}

.sideber-menu-box a {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	width: 100%;
	height: 100%;
	text-decoration: none;
	color: white;
}
.sideber-menu-box :hover {
  background-color: #d35400;
}
.content {
  height: 100%;
  width: 85%;

}
</style>
</head>

<body>

<div class="header">
  <div class="header-left">
    <i class="far fa-user-circle"></i>
    <div class="header-info">
      <p>介護福祉士ケアマネージャー</p>
      <h1>大原　豊子</h1>
      <p>EMPL1234　最終ログイン：2024/10/21</p>
    </div>
  </div>
  <div class="header-right">
  	<button>ログアウト</button>
    <p>事業所：安佐北区まごころ介護施設</p>
  </div>
</div>



<div class="container">
	<div class="sidebar">
		<div class="sideber-menu-box">
			<a href="">
				<i class="fas fa-home"></i>
				<p>HOME</p>
			</a>
		</div>
		<div class="sideber-menu-box">
			<a href="">
				<i class="fas fa-user"></i>
				<p>USER</p>
			</a>
		</div>
		<div class="sideber-menu-box">
			<a href="">
				<i class="fas fa-arrow-alt-circle-down"></i>
				<p>DOWNLOAD</p>
			</a>
		</div>
		<div class="sideber-menu-box">
			<a href="">
				<i class="fas fa-id-badge"></i>
				<p>EMPLOYEE</p>
			</a>
		</div>
		<div class="sideber-menu-box">
			<a href="">
				<i class="fas fa-comments"></i>
				<p>MESSAGE</p>
			</a>
		</div>
		<div class="sideber-menu-box">
			<a href="">
				<i class="fas fa-calendar-alt"></i>
				<p>CALENDAR</p>
			</a>
		</div>
	</div>

<!--<div class="content">-->