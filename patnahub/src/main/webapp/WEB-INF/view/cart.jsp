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
  <form action="<c:url value="/updatecart/${cartitem.cartItemId}" />" method="get">
</form>
<tr class="info">
<td>${cartitem.productId}</td>

<td>${cartitem.productName}</td>

<td><input type="text" value="${cartitem.quqntity }" name="value" /></td>
<td>${cartitem.price }</td>
<td>${cartitem.price+cartitem.quqntity}</td>

</tr>
<input type="submit" value="update" class=" btn btn-success" />
<a href="<c:url value="/delete/${cartitem.cartItemId}"/>" class="btn btn-success" ></a>
  </c:forEach>
  </tbody>
  <tr class="warning">
  <td colspan="4">total purchage amount</td>
  <td colspan="2">${grandTotal }</td>
  </tr>
  <tr class="info">
  <td colspan="3"><a href="<c:url value="/display-product"/>" class="btn btn-success" >continue your shooping</a></td>
  </tr>
  <tr>
  <td colspan="3">
  <a href="<c:url value="/checkout"/>" class="btn btn-success">checkout</a>
  </td>
  </tr>
  </table>
</div>

</body>
</html>