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
<div class="container">
<table class="table">
  <thead>
  <tr class="danger">
  <td colspan="4">order items</td>
</tr> 
   <tr>
      <th scope="col">#product id</th>
      <th scope="col">product name</th>
      <th scope="col">product price</th>
      <th scope="col">quantity</th>
       <th scope="col">sub total</th>
        <th scope="col">operation</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${cartitemlist}" var="cartitem">
  
<tr class="info">
<td>${cartitem.productId}</td>

<td>${cartitem.productName}</td>

<td>${cartitem.quantity}</td>

<td>${cartitem.price}</td>

<td>${cartitem.price*cartitem.quantity}</td>

  </c:forEach>
  </tbody>
  <tr class="warning">
  <td colspan="4">total Purchage amount</td>
  <td colspan="1">${grandTotal}/-</td>
  </tr>
  <tr class="warning">
  <td colspan="3">Shipping address</td>
 </tr>
<tr>
<tr>
  <form action="<c:url value="/updateaddress " />" method="post">
  <tr class="info">
  <td>Address</td>
  <td colspan="3">
  <textarea rows="1" cols="30" name="address">${address}</textarea>
  </td>
  <td><input type="submit" value="update address" class=" btn btn-success" /></td>
  </tr>

  </form>

  <tr class="warning">
 <td colspan="3"></td>
 <td></td>
 </tr>
 <tr class="info">
 <td colspan="3"><a href="<c:url value="/cart"/>" class="btn btn-success">Modify cart</a></td>
 <td><td colspan="3"><a href="<c:url value="/payment"/>" class="btn btn-success">Order conform</a></td>
 </tr>
  </table>
</div>

</body>
</html>