<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class=foundUniqueProduct>
		<table class="table table-striped">
			<tr>
				<td>商品圖片:${picture}</td>
			</tr>
			<tr>
				<td>商品名稱:${name}</td>
				<td>可訂購量</td>
			</tr>
			<tr>
				<td>商品描述:${description}</td>
			</tr>
		</table>
	</div>
</body>
</html>