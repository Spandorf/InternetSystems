<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	<!-- Include library for JSTL tags -->
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<head>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script src="/ApartmentFinder/scripts/all.js"></script>
</head>

<t:layout>
	<h1>Hello, ${user.username}!</h1>
	<form id="apartmentForm">
		<input type="hidden" id="apartmentId" name="apartmentId" value="${apartment.id}" />
		
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
					<dd>
						<c:forEach var="ame" items="${apartment.amenities}">
							${ame.name}, 
						</c:forEach>
					</dd>
					<dt>Community Features</dt>
					<dd>
						<c:forEach var="commFeature" items="${apartment.communityFeatures}">
							${commFeature.name}, 
						</c:forEach>
					</dd>
					<dt>Lease Term (Months)</dt>
					<dd>
						<select id="leaseTerm" name="leaseTerm">
							<option value="6">6 Months</option>
							<option value="12">12 Months</option>
						</select>
					</dd>
				</dl>
			</div>
			<div class="panel-footer clearfix">
				<input class="btn btn-primary pull-right" type="submit" value="Add to Cart" />
				<a class="btn btn-default" href="ApartmentSearchResults.jsp">Back</a>
				<a class="btn btn-default" href="ViewCart">Checkout</a>
			</div>
		</div>
	</form>
</t:layout>