<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		width:621px;
		height:478px;
		float:left;
		border:1px solid black;
		padding-left: 40px;
	}
	p{
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
	input{
		font-size:15px;
		font-family:"宋体";
		margin-top: 20px;
	}
	textarea{
		font-size:15px;
		font-family:"宋体";
		margin-top: 20px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入库登记</title>
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
			
			<form action="regBookAction" method="post">
				书名：
					<input type="text" name="name" value="${param.name }">
					<font color="red">
						<s:fielderror>
							<s:param>name</s:param>
						</s:fielderror>
					</font>
					<br>
				<c:set var="types" value="科学,教育,文学,生活,其他"></c:set>
				类别：
					<c:forEach items="${types }" var="t">
						<input type="checkbox" name="type" value="${t }"
						<c:forEach items="${paramValues.type }" var="s">
							<c:if test="${t eq s}">checked</c:if>
						</c:forEach>
						>${t }
					</c:forEach><br>
				作者：
					<input type="text" name="author" value="${param.author }">
					<font color="red">
						<s:fielderror>
							<s:param>author</s:param>
						</s:fielderror>
					</font>
					<br>
				<c:set var="fare" value="全价,九折,八折,七折,六折"></c:set>
				折扣：
					<c:forEach items="${fare }" var="d">
						<input type="radio" name="discount" value="${d }"
						<c:if test="${param.discount eq d }">checked</c:if>
						>${d }
					</c:forEach>
					<font color="red">
						<s:fielderror>
							<s:param>discount</s:param>
						</s:fielderror>
					</font>
					<br>
				价格：
					<input type="text" name="price" value="${param.price }">
					<font color="red">
						<s:fielderror>
							<s:param>price</s:param>
						</s:fielderror>
					</font>
					<br>
				数量：
					<input type="text" name="booknum" value="${param.booknum }">
					<font color="red">
						<s:fielderror>
							<s:param>booknum</s:param>
						</s:fielderror>
					</font>
					<br>
				简介：
					<textarea rows="" cols="" name="desc">${param.desc }</textarea>
					<font color="red">
						<s:fielderror>
							<s:param>desc</s:param>
						</s:fielderror>
					</font>
					<br>
				<input type="submit" value="添加">
				<input type="reset" value="取消">
			</form>
		</div>
	</div>
</body>
</html>