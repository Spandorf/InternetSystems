<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:useBean id="user" scope="session" type="model.User" />
	<h1>Hello <jsp:getProperty name="user" property="userName" />!</h1>
	<form method="post" action="CustomerTransaction.jsp">
		<div class="panel panel-default">
			<div class="panel-heading">
				1600 Penn
			</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
					<dt>Address</dt>
					<dd>1600 Penn</dd>
					<dt>Apartment Number</dt>
					<dd>13</dd>
					<dt>Apartment Type</dt>
					<dd>Studio</dd>
					<dt>Area of Apartment</dt>
					<dd>1600 sq. ft.</dd>
					<dt>Amenities</dt>
					<dd>AC, Cable, Dishwasher, Fireplace</dd>
					<dt>Community Features</dt>
					<dd>Club House, Utilities included, Pool, Garage</dd>
					<dt>Location</dt>
					<dd><input class="form-control" type="text" name="location" value="" /></dd>
				</dl>
			</div>
			<div class="panel-footer clearfix">
				<input class="btn btn-primary pull-right" type="submit" value="Select" />
				<a href="ApartmentSearchResults.jsp">Back</a>
			</div>
		</div>
	</form>
</t:layout>