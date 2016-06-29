<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<h1>Hello, ${user.username}!</h1>
	
	<!-- Include library for JSTL tags -->
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
	
	<c:if test="${errorMessage == null}">
		<div class="alert alert-success">
			<b>Success!</b> Transaction Successful.
		</div>
	</c:if>
	
	<c:if test="${errorMessage != null}">
		<div class="alert alert-danger">
			<b>Error!</b> ${errorMessage}
		</div>
	</c:if>
	
	<div class="col-sm-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				Apartment Info
			</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
					<dt>Landlord</dt>
					<dd>${transaction.apartment.landlord}</dd>
					<dt>Address</dt>
					<dd>${transaction.apartment.address}</dd>
					<dt>Apartment Type</dt>
					<dd>${transaction.apartment.aptType}</dd>
					<dt>Area of Apartment</dt>
					<dd>${transaction.apartment.area}</dd>
					<dt>Company rating</dt>
					<dd>TODO</dd>
					<dt>Price per month</dt>
					<dd>${transaction.apartment.pricePerMonth}</dd>
					<dt>Amenities</dt>
					<dd>TODO</dd>
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
					<dd>${transaction.apartment.applicationFee}</dd>
					<dt>Pet Deposit</dt>
					<dd>TODO</dd>
					<dt>Total</dt>
					<dd>${transaction.application.cost}</dd>
				</dl>
			</div>
		</div>
	</div>
</t:layout>