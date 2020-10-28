<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			//给 删除 绑定单事件
			$("#deleteItem").click(function () {
			 return confirm("确定删除" + $(this).parent().parent().find("td:first").text() + "吗？");
			});

			//给 清空购物车 绑定单击事件
			$("#clearCart").click(function () {
				return confirm("确定清空购物车？");
			});

			//给 输入框 change内容改变事件(省去了blur的判断)
			$(".updateCount").change(function () {
				//获取sahngp名称
				var name = $(this).parent().parent().find("td:first").text();
			 	var id = $(this).attr("bookId");
				//获取商品数量
				var count = this.value;
			 if (confirm("确定修改购物车中 " + name + " 的数量为：" + count + "吗？") ) {
				 //发起请求。给服务器保存修改
				 location.href = "http://localhost:808007_book/cartServet?action=updateCount&id=" + id + "&count=" + count;
			 }else {
				 // defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
			 	this.value = this.defaultValue;
			 }
			});
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@ include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<td colspan="5"><a href="index.jsp">空！！！！！继续购物！！</a></td>
			</c:if>

			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value}</td>
						<td>
							<input class="updateCount" bookId="${entry.book.id}" type="text" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=" + ${entry.value.id}>删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

			
		</table>
		//要判断entry
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=creatOrder">去结账</a></span>
		</div>
		</c:if>
	</div>
	
<%@ include file="/pages/common/foot.jsp"%>
</body>
</html>