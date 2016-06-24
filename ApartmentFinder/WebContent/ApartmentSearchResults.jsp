<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout><jsp:useBean id="user" scope="session" type="model.User" />
	<h1>Hello, ${user.username}!</h1>
	<div class="panel panel-default">
		<div class="panel-heading">
			Apartment Search Results
		</div>
		
		<!-- Include library for JSTL tags -->
		<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
		
		<!-- Table for column headings. -->
		<table class="table">
			<thead>
			    <tr>
			        <th>Landlord</th>
			        <th>Address</th>
			        <th>Apartment Type</th>
			        <th>Area of Apartment</th>
			        <th>Company rating</th>
			        <th>Price per month</th>
			        <th>Amenities</th>
			        <th></th>
			    </tr>
			</thead>
		</table>
		
		<!-- Since we can't put forms in a table, define a table for each row. It will look like one table anyway. -->
		<c:forEach var="apt" items="${searchResults}">
			<form action=ViewApartment>
				<input type="hidden" name="id" value="${apt.id}" />
				<table class="table">
					<tbody>
						<tr>
							<td>${apt.landlord}</td>
							<td>${apt.address}</td>
							<td>${apt.aptType}</td>
							<td>${apt.area}</td>
							<td>TODO</td>
							<td>${apt.pricePerMonth}</td>
							<td>TODO</td>
							<td class="clearfix">
								<input type="submit" class="btn btn-primary pull-right" value="View/Apply" />
							</td>
						</tr>
					</tbody>
			   </table>
			</form>
		</c:forEach>
	</div>
</t:layout>