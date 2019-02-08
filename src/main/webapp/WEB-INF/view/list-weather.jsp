<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>

<html>
<head>
<title>List Customers</title>

	<!-- reference our style sheet -->
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM-Customer relationship manager</h2>
		</div>
	</div>
	 
	<div id="container">
		<div id="content">
	
		<!-- add our html table here -->
			<table>
				<tr>
					<th>Weather ID</th>
					<th>Town</th>
					<th>Temperature</th>
					<th>Humidity</th>
					</tr>
					
					<c:forEach var="tempWeather" items="${weatherTable}">
					
						<tr>
							<td> ${tempWeather.weatherId}
							<td> ${tempWeather.town}
							<td> ${tempWeather.weather}
							<td> ${tempWeather.humidity}
						</tr>
					</c:forEach>				
			</table>	
		</div>
	</div>

</body>
</HTML>