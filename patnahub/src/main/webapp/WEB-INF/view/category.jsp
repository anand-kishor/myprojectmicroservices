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
<div class="container  ">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Add CATEGORY</div>
    <div class="panel-body">

	<form action="add-category" method="get">
	<table class="table center">
		<tr>
			<td>category name</td>
			<td><input type="text" name="categoryName" /></td>
		</tr>
		<tr>
			<td>category desc</td>
			<td><input type="text" name="categoryDesc" /></td>
		</tr>
		<tr>
			<td colspan="1"></td>
			<td><input class="btn btn-success" type="submit" name="SUBMIT" /></td>
		</tr>
     
      </table>
     </form>
	</div>
   </div>
  </div>
 </div>
</div>
	<div class="container">
	<div class="panel panel-primary">
  <div class="panel-heading">
   <h3>List of CATEGORY'S</h3>
  </div>
  <div class="panel-body">
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="40%">Category Id</th>
      <th width="40%">Category Name</th>
       <th width="40%">Category Description</th>
       <th width="40%">operation</th>
      <th width="10%"></th>
     </tr>
    </thead>
    <tbody>
	
    <c:forEach items="${listcategory}" var="category">
    <tr>
    <td>${category.categoryId}</td>
    <td>${category.categoryName}</td>
    <td>${category.categoryDesc}</td>
  
    <td><a href="<c:url value="/edit-category/${category.categoryId}"/>" type="button" class="btn btn-success">EDIT</a></td>
    <td><a href="<c:url value="/delete-category/${category.categoryId}"/>" type="button" class="btn btn-warning">DELETE</a></td>
   </tr>
      </c:forEach>
  
   </tbody>
	</table>
	</div>
	</div>
	</div>
</body>
</html>