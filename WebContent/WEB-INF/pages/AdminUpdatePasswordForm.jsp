<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者更新密碼</title>
</head>
<body>
<!-- NAVBAR -->
<%@include file="/WEB-INF/pages/AdminNavbar.jsp"%>

	<div class="container">
	
	<h1>管理者更新密碼</h1>
	
	
	
	<div>
	<c:url var="updateLink" value="/AdminProfile/updateForm">
		<c:param name="userID" value="${user.userID}" />
	</c:url>
	<c:url var="updatePasswordLink" value="/AdminProfile/updatePasswordForm">
		<c:param name="userID" value="${user.userID}" />
	</c:url>
	<c:url var="updateWalletLink" value="/AdminProfile/updateWalletForm">
		<c:param name="userID" value="${user.userID}" />
	</c:url>
	<a href="${updateLink}">更新使用者基本資料</a>
	<a href="${updatePasswordLink}">更改密碼</a>
	<a href="${updateWalletLink}">更改電子錢包</a>


	</div>

<form method="POST" action="<c:url value="/AdminProfile/savePassword" />" >
		
		<div class="form-group">
		<input class="form-control" type="hidden" name="userID" value="${user.userID}" />
		</div>
		
		<div class="form-group">
		<label>帳號</label>
		<p>${user.userEmail}</p>
		</div>
		
		<div class="form-group">
		<label>密碼</label>
		<input class="form-control" name="newPwd" value="${user.userPwd}" />
		</div>
		
		<button class="btn btn-info" type="submit"
						>儲存</button>
		
		</form>
		</div>
</body>
</html>