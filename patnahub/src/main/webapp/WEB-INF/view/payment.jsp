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
<form action="<c:url value="/receipt"/>" method="post">
<table class="table table-borderd center" style="width:50%" >
<tr class="success">
  <td colspan="4">payment details</td>
</tr> 
     <tr class="success">
      <td colspan="2">
      <input type="radio" value="credit card"/>Credit card
      <input type="radio" value="cash on deleivry"/>cash on delivery
      </td>
     </tr>
     <tr class="warning">
     <td>card number</td>
     <td><input type="text" name="card number"/></td>
     </tr>
     <tr class="warning">
     <td>card number</td>
     <td>valid<input type="text" name="valid"/></td>
      <td>CVV number<input type="text" name="cvv"/></td>
     </tr>
     <tr class="warning">
     <td>card number</td>
     <td>valid<input type="text" name="name"/></td>
    </tr>
     <tr class="warning">
     <td>card number</td>
     <td>valid<input type="text" name="name"/></td>
    </tr>
     <tr class="success">
     
     <td colspan="2">valid<input type="submit" value="pay" class="btn btn-success"name="name"/></td>
    </tr>
</table>
</form>

</div>
</body>
</html>