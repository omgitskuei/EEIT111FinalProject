<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="command" class="model.profile.ProfileBean"
	scope="request"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者編輯使用資訊</title>
<style>
.errMsgJS {
  color: red;
}
</style>
</head>
<body>
	<!-- NAVBAR -->
	<%@include file="/WEB-INF/pages/AdminNavbar.jsp"%>
	
	<div class="container">
	<h1>管理者編輯使用資訊</h1>
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

	<form:form method="POST" action="saveProfile" modelAttribute="profile">
		<div class="form-group">
		<form:hidden path="userID" />
		</div>
		
		<div class="form-group">
		<label>姓名</label>
		<form:input cssClass="form-control" path="profileFullName" />
		</div>
		
		<div class="form-group">
		<label>加入日期</label>
		<form:input id="joinDateInput" onkeyup="joinDateCheck()" cssClass="form-control" path="profileJoinDate" />
		<small><span class="errMsgJS" id="joinDateErrMsg"></span></small>
		<form:errors class="errMsgJS" path="profileJoinDate" />
		</div>
		
		<div class="form-group">
		<label>生日</label>
		<form:input id="birthdayInput" onkeyup="birthdayCheck()" cssClass="form-control" path="profileBirthdate" />
		<small><span class="errMsgJS" id="joinDateErrMsg"></span></small>
		<form:errors class="errMsgJS" path="profileBirthdate" />
		</div>
		
		<div class="form-group">
		<label>生日</label>
		<form:input cssClass="form-control" path="profileSex" />
		</div>
		
		<div class="form-group">
		<label>電話</label>
		<form:input cssClass="form-control" path="profilePhone" />
		<form:errors class="errMsgJS" path="profilePhone" />
		<small><span class="errMsgJS" id="phoneErrMsg"></span></small>
		</div>
		
		<div class="form-group">
		<label>地址</label>
		<form:input cssClass="form-control" path="profileAddress" />
		<form:errors class="errMsgJS" path="profileAddress" />
		<small><span class="errMsgJS" id="addressErrMsg"></span></small>
		</div>
		
		<div class="form-group">
		<label>VIP Level :</label>
		<form:input cssClass="form-control" path="profileVIP" />
		<form:errors class="errMsgJS" path="profileVIP" />
		</div>
		
		<form:button class="btn btn-info" type="submit"
						value="儲存">儲存</form:button>
			
	</form:form>
	</div>



	<script>
		function joinDateCheck() {
			var dateValue = document.getElementById('joinDateInput').value;
			var dateCon = document.getElementById('joinDateErrMsg');
			var rexdate = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/;

			if (dateValue == '') {
				dateCon.innerHTML = "日期不可空白";
			} else if (!rexdate.test(dateValue)) {
				dateCon.innerHTML = "請注意格式:西元年-月-日, 例如: yyyy-MM-dd";
			} else {
				dateCon.innerHTML = "";
			}
		}

		function birthdayCheck() {
			var dateValue = document.getElementById('birthdayInput').value;
			var dateCon = document.getElementById('birthdayErrMsg');
			var rexdate = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/;

			if (dateValue == '') {
				dateCon.innerHTML = "日期不可空白";
			} else if (!rexdate.test(dateValue)) {
				dateCon.innerHTML = "請注意格式:西元年-月-日, 例如: yyyy-MM-dd";
			} else {
				dateCon.innerHTML = "";
			}
		}
	</script>
</body>
</html>

