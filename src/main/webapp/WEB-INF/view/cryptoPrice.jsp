<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
 
<style type="text/css">
body {
	background-image: url('https://cdn.crunchify.com/bg.png');
}
</style>
 
<title>Price</title>
<meta rel="author" href="https://crunchify.com">
</head>
 
<body>
	<div align="center">
		<br>
		<h1>Current Bitcoin price: ${getPrice} ${getCurrency}</h1>
	  <div id="container" style='position:relative;'>
  		<!-- Other elements here -->
	  <div style='position:absolute; bottom:1000;'>
		<h3>Disclaimer: ${disclaimer}</h3>  
		 <br>
		<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
	  </div>
	  </div>
</body>
 
</html>