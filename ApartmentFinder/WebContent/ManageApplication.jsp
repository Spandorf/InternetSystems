<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!-- Include library for JSTL tags -->
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<t:layout>
	<h1>Hello, ${user.username}!</h1>
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
		</table>
		<!-- Since we can't put forms in a table, define a table for each row. It will look like one table anyway. -->
		<c:forEach var="app" items="${applications}">
			<form action=CancelApplication>
				<input type="hidden" name="id" value="${app.id}" />
				<table class="table">
					<tbody>
						<tr>
							<td>${app.apartment.address}</td>
							<td>${app.apartment.landlord}</td>
							<td>${app.apartment.aptType}</td>
							<td>${app.apartment.area}</td>
							<td>${app.apartment.rating}</td>
							<td>${app.apartment.pricePerMonth}</td>
							<td>${apt.MoveInDate}</td>
							<td class="clearfix">
								<input type="submit" class="btn btn-primary pull-right" value="Cancel" />
							</td>
						</tr>
					</tbody>
			   </table>
			</form>
		</c:forEach>
	</div>
</t:layout>