<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/view/header.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>insert title</title>
</head>
<body>
	<form action="<c:url value="/update-category" />" method="post">
	<table class="table">
     <tr>
     <td colspan="2"><h2>Category</h2></td>
     </tr>
     
     <tr>
     <td>Category Id</td>
     <td><input type="text" name="categoryId"  readonly /></td>
     </tr>
      <tr>
     <td>Category name</td>
     <td><input type="text" name="categoryName"   /></td>
     </tr>
      <tr>
     <td>Category Description</td>
     <td><input type="text" name="categoryDesc"  /></td>
     </tr>
      <tr>
     <td colspan="2"><input class="text center" type="submit" value="UPDATE CATEGORY"></td>
     </tr>
	</table>	
	</form>
	
	
	
</body>
</html>