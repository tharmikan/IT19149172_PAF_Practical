<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="model.Payment"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/payment.js"></script>
<title>Finance Management</title>
</head>
<body>
<h1>Finance Management</h1>

<form id="formItem" name="formItem" method="post" action="details.jsp">
 Name:
<input id="name" name="name" type="text"
 class="form-control form-control-sm">
<br> Phone:
<input id="phone" name="phone" type="text"
 class="form-control form-control-sm">
<br> Card:
<input id="card" name="card" type="text"
 class="form-control form-control-sm">
<br> CVV:
<input id="cvv" name="cvv" type="text"
 class="form-control form-control-sm">

<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>


<br>
<div id="divItemsGrid">
<%
 Payment Obj = new Payment();
 out.print(Obj.readDetails());
%>
</div>
</body>
</html>