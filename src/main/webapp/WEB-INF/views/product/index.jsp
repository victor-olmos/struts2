<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Product List</h3>
	<table>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Catidad</th>
		</tr>
		<c:forEach var="product" items="${products}">
		<tr>
		<td>${product.id}</td>
		<td>${product.nombre}</td>
		<td>${product.valor}</td>
		<td>${product.cantidad}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>