<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.wrap{
		width:903px;
		height:608px;
		margin:0 auto;
	}
	.top{
		width: 903px;
		height: 128px;
	}
	.left{
		width:240px;
		height:480px;
		float:left;
		text-align:center;
		background:url(images/bg_left.png) repeat;
	}
	.right{
		width:661px;
		height:478px;
		float:left;
		border:1px solid black;
	}
	.right p{
		text-align: center;
	}
	.left p{
		margin-top:40px;
	}
	.left a{
		font-family: "微软雅黑";
		font-size: 17px;
		color:orange;
		text-decoration: none;
	}
	.left a:hover{
		color:pink;
		text-decoration: underline;
	}
	h3{
		font-size:30px;
		text-align: center;
		margin-top:100px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<div class="top">
			<img alt="" src="images/banner.png">
		</div>
		<div class="left">
			<p>
				<img alt="" src="images/icon_listlia.gif">
				<a href="index.html">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a><br>
			</p>
			<p>
				<img alt="" src="images/icon_listlia.gif">
				<a href="BookRegister.jsp">入库登记</a><br>
			</p>
			<p>
				<img alt="" src="images/icon_listlia.gif">
				<a href="listBookAction">库存列表</a><br>
			</p>
			<p>
				<img alt="" src="images/icon_listlia.gif">
				<a href="listBookPageAction">列表分页</a><br>
			</p>
		</div>
		<div class="right">
			<h3>注册${book.bookName}成功</h3>
			<p>
				<a href="index.html">回到首页面</a>
			</p>
		</div>
	</div>
</body>
</html>