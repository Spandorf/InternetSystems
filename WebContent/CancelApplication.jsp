<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!-- Include library for JSTL tags -->
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<t:layout>
	<h1>Hello, ${user.username}!</h1>
		<form method="post" action="CancelApplication">
		<input type="hidden" name="id" value="${application.id}" />
		
		<div class="panel panel-default">
			<jsp:useBean id="apartment" scope="session" type="model.Apartment" />
			<div class="panel-heading">
				<jsp:getProperty name="apartment" property="address" />
			</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
					<dt>Landlord</dt>
					<dd>${application.apartment.aptNumber}</dd>
					<dt>Address</dt>
					<dd>${application.apartment.address}</dd>
					<dt>Apartment Type</dt>
					<dd>${application.apartment.aptType}</dd>
					<dt>Area of Apartment</dt>
					<dd>${application.apartment.area}</dd>
					<dt>Rating</dt>
					<dd>${application.apartment.rating}</dd>
					<dt>Price Per Month</dt>
					<dd>${application.apartment.pricePerMonth}</dd>
					<dt>Amenities</dt>
					<dd>
						<c:forEach var="ame" items="${application.apartment.amenities}">
							${ame.name}, 
						</c:forEach>
					</dd>
					<dt>Community Features</dt>
					<dd>
						<c:forEach var="commFeature" items="${application.apartment.communityFeatures}">
							${commFeature.name}, 
						</c:forEach>
					</dd>
				</dl>
			<div class="panel-heading">
				Cost Summary
			</div>
			<div class="panel-body">
				<dl class="dl-horizontal">
					<dt>Application Fee</dt>
					<dd>${application.Cost}</dd>
					<dt>Pet Deposit</dt>
					<dd>TODO</dd>
					<dt>Total</dt>
					<dd>${application.Cost}</dd>
				</dl>
			</div>
			</div>
			<div class="panel-footer clearfix">
				<input class="btn btn-primary pull-right" type="submit" value="Confirm Cancellation" />
				<a class="btn btn-default" href="ManageApplication">Discard Cancellation</a>
			</div>
		</div>
	</form>
</t:layout>