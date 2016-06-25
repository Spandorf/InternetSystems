<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<h1>Hello, ${user.username}!</h1>
	<form method="post" action="Apply">
		<input type="hidden" name="id" value="${apartment.id}" />
		
		<div class="panel panel-default">
			<jsp:useBean id="apartment" scope="session" type="model.Apartment" />
			<div class="panel-heading">
				<jsp:getProperty name="apartment" property="address" />
			</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
					<dt>Address</dt>
					<dd>${apartment.address}</dd>
					<dt>Apartment Number</dt>
					<dd>${apartment.aptNumber}</dd>
					<dt>Apartment Type</dt>
					<dd>${apartment.aptType}</dd>
					<dt>Area of Apartment</dt>
					<dd>${apartment.area}</dd>
					<dt>Amenities</dt>
					<dd>TODO</dd>
					<dt>Community Features</dt>
					<dd>TODO</dd>
					<dt>Lease Term (Months)</dt>
					<dd>
						<select name="leaseTerm">
							<option value="6">6 Months</option>
							<option value="12">12 Months</option>
						</select>
					</dd>
				</dl>
			</div>
			<div class="panel-footer clearfix">
				<input class="btn btn-primary pull-right" type="submit" value="Select" />
				<a class="btn btn-default" href="ApartmentSearchResults.jsp">Back</a>
			</div>
		</div>
	</form>
</t:layout>