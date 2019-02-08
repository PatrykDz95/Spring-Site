<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
 
<style type="text/css">
body {
	background-image: url('https://c1.staticflickr.com/3/2875/9692662186_a09b75e4aa_h.jpg');
}
</style>
 
<title>Weather</title>
<meta rel="author" href="https://crunchify.com">
</head>
 
<body>
	<div align="center">
		<br>
		<h1>Town: ${nameWeather}</h1>
		<h2>Description: ${descWeather}</h2>
		<h3>Temperature: ${tempWeather}</h3>
		<h3>Humidity: ${humidityWeather}</h3>
		<h3>Pressure: ${pressureWeather}</h3>
		<br>
		<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
	</div>
</body>
 
</html>