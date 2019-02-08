<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>

<link type="text/css"
	rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/style.css"/>
		
		<link type="text/css"
	rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/add-customer-style.css"/>
		
</head>
<body>

	<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
	</div>
	
	<div id="container">
			<h3>Save weather</h3>
			
			<form:form action="saveWeather" modelAttribute="weathertable" method="POST">
		
		<!-- need to associate this data with customer id 
			to inform the back-end system which customer performed the update operation-->
			<table>
			<tbody>
			<tr>
			<td><label>town:</label></td>
			<td><form:input path="town"/></td>
			</tr>
			
			<tr>
			<td><label>weather:</label></td>
			<td><form:input path="weather"/></td>
			</tr>
			
			<tr>
			<td><label>humidity:</label></td>
			<td><form:input path="humidity"/></td>
			</tr>
			
			<tr>
			<td><label></label></td>
			<td><input type="submit" value="Save" class="save"/></td>
			</tr>
			
			</tbody>
			</table>
				</form:form>
				
			<div style="clear; both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/">Back to List</a>
			</p>	
				
	</div>	
</body>
</html>