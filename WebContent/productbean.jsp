<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Form</h3>
<form action="<c:url value="/productbean.controller"></c:url>" method="post" enctype="multipart/form-data">	
<!-- DIRECTS to /hello.controller via method POST -->
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" size="20"  > </td> 
		    <td>${errors.name}</td>
		</tr> 
		<tr> 
			<td>Price:</td>
			<td><input type="number" name="price" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,‘‘)" step=".01" min="0" required></td>
			<td>${errors.price}</td>
		</tr> 
		<tr>
			<td>Stock:</td>
			<td><input type="number" name="stock" onkeyup="value=this.value.replace(/\D+/g,‘‘)" min="0" required ></td>
			<td>${errors.stock}</td>
		</tr> 	
		<tr>	
			<td>Description:</td>
			<td><textarea type="text" name="description" cols="20" rows="5" ></textarea> </td>
			<td>${errors.despription}</td>
		</tr>
		<tr>	
			<td>Image:</td>
			<td>
			<input type="file" name="image">
		    <input type="submit" value="upload" /></td>
			<td>${errors.img}</td>
		</tr> 	
		<tr>	
			<td>Timestamp:</td>
			<td><input type="datetime" name="timestamp" ></td>
			<td>${errors.timestamp}</td>
		</tr> 
		<tr>	
			<td>Category:</td>
			<td>
			<select name="category" required>
			<option>蔬菜</option>
			<option>水果</option>
			</select>
			</td>
			<td>${errors.category}</td>
		</tr>
		<tr>
			<td><input type="submit" value="sumit" ></td>
			<td><input type="submit" value="delete" ></td>
			
		</tr>
	</table>
</form>