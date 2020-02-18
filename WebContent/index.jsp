<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
</head>
<body>
	This is the WebContent/index.jsp!!
	<form class="form" name="loginForm" action=<jstl:url value="controller.searchBar" /> method="post"></form>

		<input type="search" title="Products search bar" name="SearchBar"></input>
			Search bar
		<form class="form" name="searchForm" action=<jstl:url value="controller.searchBar" /> method="post" >
        
        </form>
	
	<a href="WebContent/AdminLogin.jsp">Admin Login</a>  
	
	
	<a href="<jstl:url value = "/controller.ProfileController"/>" > Show Profile </a>
	<a href="<jstl:url value = "/controller.AdminOrdersController"/>" > Admin order </a>
</body>
</html>