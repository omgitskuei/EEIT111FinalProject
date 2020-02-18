<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="command" class="model.product.ProductBean" scope="request"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>庫存資料內容修改</title>
</head>
<body>
<!-- NAVBAR -->
	<%@include file="/WEB-INF/pages/AdminNavbar.jsp"%>

	<h1>庫存資料內容修改</h1>

	<form:form method="POST" action="saveProduct" modelAttribute="product">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="productID" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="productPrice" /></td>
			</tr>
			<tr>
				<td>Stock :</td>
				<td><form:input path="productStock" /></td>
			</tr>
			
			<tr>
				<td>Img :</td>
				<td><form:input path="productImg" /></td>
			</tr>
			<tr>
				<td>Timestamp :</td>
				<td><form:input path="productTimestamp" /></td>
			</tr>
			<tr>
				<td>Category :</td>
				<td><form:input path="productCategory" /></td>
			</tr>
<tr>
				<td>Description :</td>
				<td>
				<form:textarea type="text" path="productDescription" name="description" cols="22" rows="5" ></form:textarea> </td>
				
			</tr>
			<tr>
				<td></td>
				
				<td><form:button cssClass="btn btn-info" type="submit" value="儲存">儲存</form:button></td>
			</tr>
		</table>
	</form:form>


