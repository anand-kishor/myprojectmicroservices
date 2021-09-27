<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/view/header.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>insert title</title>
</head>
<body>
<div class="row g-3 align-items-center">
  <div class="col-auto ">
	<form:form  action="insert-product" method="post" modelAttribute="product" enctype="multipart/form-data">
	<table  class="table-borderd ">
	
	<tr>
	<td colspan="2">product info</td>
	
	</tr>
	<tr>
	<td >product id</td>
	<td><form:input path="productId" /></td>
	</tr>
	<tr>
	<td >product name</td>
	<td><form:input path="productName" /></td>
	</tr>
	<tr>
	<td >price</td>
	<td><form:input path="price" /></td>
	</tr>
	<tr>
	<td >Stock</td>
	<td><form:input path="stock" /></td>
	</tr>
	<tr>
	<td >category</td>
	<td>
	<form:select path="categoryId">
	<form:option value="0"  label="...select list......"/>
	<form:options items="${categoryList}" />
	</form:select>
	</td>
	</tr>
	<tr>
	<td >Supplier</td>
	<td><form:input path="supplierId" /></td>
	</tr>
	<tr>
	<td >Product Description</td>
	<td><form:input path="productDesc" /></td>
	</tr>
	<tr>
	<td >Product Image</td>
	<td><form:input type="file" path="pimage" /></td>
	</tr>
	<tr>
	<td colspan="2">product info</td>
	<td><input type="submit" value="insert product"></td>
	</tr>
	
	</table>
	</form:form>
	</div>
  </div>
  <div></div>
  <br><br>
	<table class="table">
  <thead>
	<tr>
	<td>Product Id</td>
	<td>Product name</td>
	<td>Price</td>
	<td>Stock</td>
	<td>Supplier</td>
	<td>Operations</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${productlist}" var="product">
	<tr>
	<td>${product.productId}</td>
	<td>${product.productName}</td>
	<td>${product.price}</td>
	<td>${product.stock}</td>
	<td>${product.supplierId}</td>
	<td>
	<td><a href="<c:url value="/edit-category/${category.categoryId}"/>" class="btn btn-success">EDIT</a></td>
    <td><a href="<c:url value="/delete-category/${category.categoryId}"/>" class="btn btn-danger">DELETE</a></td>
	
	</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>