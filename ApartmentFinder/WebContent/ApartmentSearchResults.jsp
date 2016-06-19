<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:useBean id="user" scope="session" type="model.User" />
	<h1>Hello <jsp:getProperty name="user" property="username" />!</h1>
	<div class="panel panel-default">
		<div class="panel-heading">
			Apartment Search Results
		</div>
		<jsp:useBean id="searchResults" scope="session" type="model.ApartmentList" />
		<form action=ViewApartment>
			<input type="hidden" name="id" value="1" />
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
				<tbody>
				    <tr>
				        <td>John Doe</td>
				        <td>1600 Penn</td>
				        <td>Studio</td>
				        <td>1600 sq. ft.</td>
				        <td>4/5</td>
				        <td>1000</td>
				        <td>AC, Cable, Fireplace</td>
				        <td>
				        	<input type="submit" class="btn btn-primary pull-right" value="View/Apply" />
				        </td>
				    </tr>
				</tbody>
		   </table>
		</form>
	</div>
</t:layout>