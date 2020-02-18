<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding User</title>
</head>
<body>
	<h1>Edit Employee</h1>
	<form:form method="POST" action="/controller.AddUserProfile">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="userID" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="profileFullName" /></td>
			</tr>
			<tr>
				<td>Join Date :</td>
				<td><form:input path="profileJoinDate" /></td>
			</tr>
			<tr>
				<td>Birthday :</td>
				<td><form:input path="profileBirthdate" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:input path="profileSex" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><form:input path="profilePhone" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="profileAddress" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><form:input path="profilePhone" /></td>
			</tr>
			<tr>
				<td>VIP Level :</td>
				<td><form:input path="profileVIP" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>