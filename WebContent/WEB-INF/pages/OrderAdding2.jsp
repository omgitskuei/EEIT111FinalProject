<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<jsp:useBean id="command" class="model.order.OrderBean" scope="request"></jsp:useBean>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂單管理_修改</title>
</head>
<body>
	<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String now = df.format(d);
	%>
<!-- NAVBAR -->
	<%@include file="/WEB-INF/pages/AdminNavbar.jsp"%>

	<h1>編輯訂單資料</h1>

	<form:form method="POST" action="saveOrder" modelAttribute="order" >
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="orderID" /></td>
			</tr>
			<tr>
				<td>訂購時間 :</td>
				<td><form:input path="OrderTime" value="<%=now %>" readonly="true"/></td>
			</tr>
			<tr>
				<td>訂購人ID :</td>
				<td><form:input path="UserID" /></td>
			</tr>
			<tr>
				<td>總價 :</td>
				<td><form:input path="Total" readonly="true"/></td>
			</tr>
			<tr>
				<td>寄送地址 :</td>
				<td><form:input path="MailingAddress" /></td>
			</tr>
			<tr>
				<td>寄送電話 :</td>
				<td><form:input path="MailingPhone" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button cssClass="btn btn-info" type="submit" value="儲存">下一步</form:button></td>
			</tr>
		</table>
	</form:form>