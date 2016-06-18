<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:useBean id="user" scope="session" type="model.User" />
	<h1>Hello <jsp:getProperty name="user" property="userName" />!</h1>
	<div class="panel panel-default">
		<div class="panel-heading">
		Application History
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Address</th>
					<th>Landlord</th>
					<th>Apartment Type</th>
					<th>Area of Apartment</th>
					<th>Company rating</th>
					<th>Price per month</th>
					<th>Move-in Date</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1600 Penn</td>
					<td>John Doe</td>               
					<td>Studio</td>
					<td>1600 sq. ft.</td>
					<td>4/5</td>
					<td>1000</td>
					<td>11/22/1973</td>
					<td><a href="CancelApplication.jsp"> Cancel </a></td>               
				</tr>
				<tr>
					<td>111 Pine</td>
					<td>John Doe</td>               
					<td>Studio</td>
					<td>1600 sq. ft.</td>
					<td>4/5</td>
					<td>1000</td>
					<td>11/22/1973</td>
					<td><a href="CancelApplication.jsp"> Cancel </a></td>
				</tr>
			</tbody>
		</table>
	</div>
</t:layout>