<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:useBean id="user" scope="session" type="model.User" />
	<h1>Hello <jsp:getProperty name="user" property="Username" />!</h1>
	<div class="col-sm-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				Apartment Info
			</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
					<dt>Landlord</dt>
					<dd>John Doe</dd>
					<dt>Address</dt>
					<dd>1600 Penn</dd>
					<dt>Apartment Type</dt>
					<dd>Studio</dd>
					<dt>Area of Apartment</dt>
					<dd>1600 sq. ft.</dd>
					<dt>Company rating</dt>
					<dd>4/5</dd>
					<dt>Price per month</dt>
					<dd>1000</dd>
					<dt>Amenities</dt>
					<dd>AC, Cable, Fireplace</dd>
				</dl>
			</div>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				Cost Summary
			</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
					<dt>Application Fee</dt>
					<dd>$30000</dd>
					<dt>Pet Deposit</dt>
					<dd>$50</dd>
					<dt>Total</dt>
					<dd>$3000</dd>
				</dl>
			</div>
		</div>
	</div>
</t:layout>