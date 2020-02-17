<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員修改電子錢包</title>
</head>
<body>

<!-- NAVBAR -->
	<%@include file="/WEB-INF/pages/AdminNavbar.jsp"%>

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
	
	
<h1>管理員修改電子錢包</h1>
<p>目前: ${wallet.walletAmount}</p>

<form method="POST" action="<c:url value="/AdminProfile/saveWallet" />" >
<input hidden="true" name="userID" value="${user.userID}" />
修改成: <input name="newwalletAmount" value="${wallet.walletAmount}" />
<button type="submit">送出</button>
</form>

            

</body>
</html>