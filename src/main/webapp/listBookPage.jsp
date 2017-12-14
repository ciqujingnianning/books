<%@page import="com.book.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function changeCurrentNum(value){
		location.href="listBookPageAction?currentNum="+value;
	}
</script>
<style type="text/css">
.wrap {
	width: 903px;
	height: 608px;
	margin: 0 auto;
}

.top {
	width: 903px;
	height: 128px;
}

.left {
	width: 240px;
	height: 480px;
	float: left;
	text-align: center;
	background: url(images/bg_left.png) repeat;
}

.right {
	width: 661px;
	height: 478px;
	float: left;
	border: 1px solid black;
}

p {
	margin-top: 40px;
}

.left a {
	font-family: "微软雅黑";
	font-size: 17px;
	color: orange;
	text-decoration: none;
}

.left a:hover {
	color: pink;
	text-decoration: underline;
}

h3 {
	font-size: 30px;
	text-align: center;
	margin-top: 100px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息表</title>
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
			<center>
			<c:set var="num" value="4,5,6,8,10,15"></c:set>
			<select name="currentNum" onchange="changeCurrentNum(this.value)">
				<option>--请选择每页条数--</option>
				<c:forEach items="${num }" var="n">
					<option value="${n }"
					 <c:if test="${param.currentNum eq n }">selected</c:if>
					>${n }</option>
				</c:forEach>
			</select>
			<table width="600px" cellpadding="1px" cellspacing="0px" border="1px">
				<caption>书籍信息表</caption>
				<tr>
					<th>编号</th>
					<th>书名</th>
					<th>作者</th>
					<th>折扣</th>
					<th>价格</th>
					<th>数量</th>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				</tr>
				<c:forEach items="${pb.list }" var="book">
					<tr>
						<td>${book.bookId }</td>
						<td>${book.bookName }</td>
						<td>${book.author }</td>
						<td>${book.discount }</td>
						<td>${book.price }</td>
						<td>${book.booknum }</td>
						<td><a href="bookDetailsAction?id=${book.bookId }">详情</a></td>
						<td><a href="BookUpdate.jsp?id=${book.bookId }&name=${book.bookName}&type=${book.bookType}&author=${book.author}&discount=${book.discount}&price=${book.price}&booknum=${book.booknum}&desc=${book.bookDesc}">更新</a></td>
						<td><a href="bookDelAction?id=${book.bookId}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="listBookPageAction?currentPage=1&currentNum=${pb.currentNum }">首页</a>
			<c:if test="${pb.currentPage == 1 }">上一页</c:if>
			<c:if test="${pb.currentPage != 1 }">
				<a href="listBookPageAction?currentPage=${pb.currentPage-1 }&currentNum=${pb.currentNum }">上一页</a>
			</c:if>
			<c:if test="${pb.currentPage == pb.totalPage }">下一页</c:if>
			<c:if test="${pb.currentPage != pb.totalPage }">
				<a href="listBookPageAction?currentPage=${pb.currentPage+1 }&currentNum=${pb.currentNum }">下一页</a>
			</c:if>
			<a href="listBookPageAction?currentPage=${pb.totalPage }&currentNum=${pb.currentNum }">尾页</a>
			</center>
			
		</div>
	</div>
</body>
</html>
