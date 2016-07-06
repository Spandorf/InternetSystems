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
					<th class="appAddress">Address</th>
					<th class="appLandlord">Landlord</th>
					<th class="appType">Apartment Type</th>
					<th class="appArea">Area of Apartment</th>
					<th class="appRating">Company rating</th>
					<th class="appPrice">Price per month</th>
					<th class="appDate">Move-in Date</th>
					<th></th>
				</tr>
			</thead>
		</table>
		<!-- Since we can't put forms in a table, define a table for each row. It will look like one table anyway. -->
		<c:forEach var="app" items="${applications}">
			<form action=ViewApplication>
				<input type="hidden" name="id" value="${app.id}" />
				<table class="table">
					<tbody>
						<tr>
							<td class="appAddress">${app.apartment.address}</td>
							<td class="appLandlord">${app.apartment.landlord}</td>
							<td class="appType">${app.apartment.aptType}</td>
							<td class="appArea">${app.apartment.area}</td>
							<td class="appRating">${app.apartment.rating}</td>
							<td class="appPrice">${app.apartment.pricePerMonth}</td>
							<td class="appDate">${app.moveInDate}</td>
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