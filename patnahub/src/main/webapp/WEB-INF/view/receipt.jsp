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
<div>
<table class="table table-borderd center" style="width:50%" >
<tr class="danger">
  <td colspan="">payment receipt</td>
</tr> 
<tr class="ingo">
<td>ORDER ID</td>
<td>ORD000${orderDetails.orderId }</td>
<td>Date</td>
<td colspan="2">Date${orderDetails.date }</td>
  <td colspan="">payment receipt</td>
</tr> 
<tr class="danger">
  <td colspan="3"><h3>ORDER ITEMS</h3></td>
</tr>
<tr>
<td>product id</td>
<td>product name</td>
<td>product quantity</td>
<td>product price</td>
<td>total</td>
</tr>
<c:forEach items="${cartitemlist}" var="cartitem">
<tr class="info">
<td>${cartitem.productId}</td>

<td>${cartitem.productName}</td>

<td>${cartitem.quqntity }</td>

<td>${cartitem.price }</td>
<td>${cartitem.quqntity *${cartitem.price }</td>
</tr>

<tr class="warning">
  <td colspan="4">total purchage amount</td>
  <td colspan="2">${grandTotal }</td>
  </tr>
  
  <tr class="warning">
  <td colspan="4">shipping address</td>
 </tr>
 <tr class="info">
  <td >total address</td>
  <td colspan="2">${address}</td>
  </tr>
</c:forEach>
</table>
</div>
</body>
</html>