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
	<form class="form" name="searchForm" action="<jstl:url value="searchBar" />" method="post" id="searchBar">
            <div class="form-group">
                  <label for="search">Search bar ProductName</label>
                  <input type="search" class="form-control" name="searchBar" id="searchBar">
                  <span id="searchErrorSpan">${errors.emailError}</span>
                </div>
                <input type="submit" value="Search" class="btn btn-primary btn-block">
            </form>
            
            
	
	<a href="WebContent/AdminLogin.jsp">Admin Login</a>  
	
	
	<a href="<jstl:url value = "/controller.ProfileController"/>" > Show Profile </a>
	<a href="<jstl:url value = "/controller.AdminOrdersController"/>" > Admin order </a>
</body>
</html>