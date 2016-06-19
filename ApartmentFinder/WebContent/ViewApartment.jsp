<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:useBean id="user" scope="session" type="model.User" />
	<h1>Hello <jsp:getProperty name="user" property="username" />!</h1>
	<form method="post" action="CustomerTransaction.jsp">
		<div class="panel panel-default">
			<jsp:useBean id="apartment" scope="session" type="model.Apartment" />
			<div class="panel-heading">
				<jsp:getProperty name="apartment" property="address" />
			</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
					<dt>Address</dt>
					<dd><jsp:getProperty name="apartment" property="address"/></dd>
					<dt>Apartment Number</dt>
					<dd><jsp:getProperty name="apartment" property="aptNumber"/></dd>
					<dt>Apartment Type</dt>
					<dd><jsp:getProperty name="apartment" property="aptType"/></dd>
					<dt>Area of Apartment</dt>
					<dd><jsp:getProperty name="apartment" property="area"/></dd>
					<dt>Amenities</dt>
					<dd>TODO</dd>
					<dt>Community Features</dt>
					<dd>TODO</dd>
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