<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Form</h3>
<h1>ADMIN LOGIN</h1>
<form action="<c:url value="/checkLogin.controller" />" method="post">
	<table>
		<!-- Email text field -->
		<tr>
			<td>Email:</td>
			<td><input type="text" name="userEmail"></td>
			<td>${errors.emailError}</td>
		</tr>
		<!-- Password text field -->
		<tr>
			<td>Password:</td>
			<td><input type="password" name="userPwd"></td>
			<td>${errors.pwdError}</td>
		</tr>
		<!-- Password text field -->
		<tr>
			<td>Remember Me:</td>
			<td><input type="checkbox" name="rememberMe"></td>
		</tr>
		<!-- Reset Button -->
		<tr>
			<td><input type="reset"></td>
		</tr>
		<!-- Submit Button -->
		<tr>
			<td><input type="submit"></td>
			<td>${errors.msgError}</td>
		</tr>
	</table>
</form>