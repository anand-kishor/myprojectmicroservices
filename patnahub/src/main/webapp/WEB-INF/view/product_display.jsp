<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/view/header.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display product</title>
</head>
<body>
<div class="row">
<c:forEach items="${productlist}" var="product">
<div class="col-sm-4 col-sm-3">
<a href="<c:url value="/total-display-product/${product.productId}"/>" class="thumbnail" >
<img src="/resources/images/${product.productId}.jpg"/>"  alt="generic placeholder thumbnail" />
</a>

<p align="center">${product.productId}</p>
<p align="center">${product.productName}</p>
<p align="center">price: ${product.price}</p>
<p align="center">stock: ${product.stock}</p>

</div>

</c:forEach>

</div>
</body>
</html>