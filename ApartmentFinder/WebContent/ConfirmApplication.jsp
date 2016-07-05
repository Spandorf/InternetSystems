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
	<div class="">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					Apartment Info
				</div>
				<div class="panel-body">
					<c:forEach var="cart" items="${cartItems}">
							<table class="table">
								<thead>
									<tr>
										<th>Address</th>
										<th>Landlord</th>
										<th>Apartment Type</th>
										<th>Price per month</th>
										<th>Lease Term</th>
										<th>Application Fee</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${cart.apartment.address}</td>
										<td>${cart.apartment.landlord}</td>
										<td>${cart.apartment.aptType}</td>
										<td>${cart.apartment.rating}</td>
										<td>${cart.leaseTerm}</td>
										<td>${cart.apartment.applicationFee}</td>
										<td>${cart.total}</td>
									</tr>
								</tbody>
						   </table>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-6">
		<form id="applicationForm">
			<input id="appTotal" name="appTotal" type="hidden" value="${appTotal}" />
			<input id="cartId" name="cartId" type="hidden" value="${cartId}" />
			<div class="panel panel-default">
				<div class="panel-heading">
					Payment Info
				</div>
				<div class="panel-body">
					<dl class="dl-horizontal">
						<dt>Card Holder</dt>
						<dd>
							<input class="form-control" type="text" name="cardholder" value="" />
						</dd>
						<dt>Card Type</dt>
						<dd>
							<select class="form-control" name="card_type">
								<option value="visa">Visa</option>
								<option value="master">Master</option>
								<option value="discover">Discover</option>
							</select>
						</dd>
						<dt>Card Number</dt>
						<dd>
							<input class="form-control" type="text" name="card_number" value="" />
						</dd>
						<dt>Security Code</dt>
						<dd>
							<input class="form-control" type="text" name="sec_code" value="" />
						</dd>
						<dt>Expiration Date</dt>
						<dd>
							<input class="form-control" type="text" name="exp_date" value="" />
						</dd>
						<dt>Billing Address</dt>
						<dd>
							<input class="form-control" type="text" name="billing_address" value="" />
						</dd>
					</dl>
				</div>
				<div class="panel-footer clearfix">
					<a id="cancelPaymentBtn" class="btn btn-danger pull-right" href="ApartmentSearchResults.jsp"> Cancel Payment </a>
					<input class="btn btn-primary pull-right" type="submit" value="Confirm Payment" />
					<input class="btn btn-default pull-left" type="reset" value="Reset" />
				</div>
			</div>
		</form>
	</div>
</t:layout>