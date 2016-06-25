<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<h1>Hello, ${user.username}!</h1>
	<div class="col-sm-6">
		<div class="col-sm-12">
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
		<div class="col-sm-12">
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
	</div>
	<div class="col-sm-6">
		<form method="post" action="CustomerTransactionConfirmation">
			<input name="cost" type="hidden" value="${transaction.application.cost}" />
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