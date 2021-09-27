<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/view/header.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>insert title</title>
</head>
<body>
<form action="<c:url value="/addcart/${product.productId}" />">

<table class="borderd">
<tr>

<td rowspan="8"><img src="/resources/images/${product.productId}.jpg"/>" style="height:300px" alt="generic placeholder thumbnail" />
</td>
<td>product id</td>
<td>${product.productId} </td>
</tr>
<tr>
<td>product name</td>
<td>${product.productName} </td>
</tr>
<tr>
<td>product price</td>
<td>${product.productPrice} </td>
</tr>
<tr>
<td>product stock</td>
<td>${product.stock} </td>
</tr>
<tr>
<td>category id</td>
<td>${product.categoryId} </td>
</tr>
<tr>
<td>supplier</td>
<td>${product.supplierId} </td>
</tr>
<tr>
<td>product description</td>
<td>${product.productDesc} </td>
</tr>
<tr>
<td>quantity
<select name="quantity">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
</td>
<td><input type="submit" name="BUY-PRODUCT" class="btn btn-success"></td>
</tr>
</table>
</form>

</body>
</html>