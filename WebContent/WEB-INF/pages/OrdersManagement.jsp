<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders Management Page</title>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

</head>

<body>
	<h2>OrdersManagement</h2>
	<table border="2" width="70%" cellpadding="2">  
		<tr>
			<th>orderID</th>
			<th>userID</th>
			<th>total</th>
			<th>mailingAddress</th>
			<th>mailingPhone</th>
			<th>orderTime</th>
		</tr>
		<c:forEach var="orderInfo" items="${orderList}">
			<tr>
				<td>${orderInfo.orderID}</td>
				<td>${orderInfo.userID}</td>
				<td>${orderInfo.total}</td>
				<td>${orderInfo.mailingAddress}</td>
				<td>${orderInfo.mailingPhone}</td>
				<td>${orderInfo.orderTime}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>