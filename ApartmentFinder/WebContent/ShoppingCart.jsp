<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!-- Include library for JSTL tags -->
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<t:layout>
	<h1>Hello, ${user.username}!</h1>
	<div class="panel panel-default">
		<div class="panel-heading">
		Shopping Cart
		</div>
		<div>
			<c:choose>
				<c:when test="${cartEmpty=='1'}">
					The cart is empty
					<br />
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Address</th>
					<th>Landlord</th>
					<th>Apartment Type</th>
					<th>Area of Apartment</th>
					<th>Company rating</th>
					<th>Price per month</th>
					<th>Lease Term</th>
					<th>Application Fee</th>
					<th></th>
				</tr>
			</thead>
		</table>
		<!-- Since we can't put forms in a table, define a table for each row. It will look like one table anyway. -->
		<form name="cartApt" id="cartApt" action="Apply">
		<c:forEach var="cart" items="${cartItems}">
				<table class="table">
					<tbody>
						<tr>
							<td>${cart.apartment.address}</td>
							<td>${cart.apartment.landlord}</td>
							<td>${cart.apartment.aptType}</td>
							<td>${cart.apartment.area}</td>
							<td>${cart.apartment.rating}</td>
							<td>${cart.apartment.pricePerMonth}</td>
							<td>${cart.leaseTerm}</td>
							<td>${cart.apartment.applicationFee}</td>
							<td class="clearfix">
								<input type="hidden" id="cartid" name="cartid" value="${cart.cartItemId}" />
								<input type="submit" id="cartRemove" name="cartRemove" class="btn btn-primary pull-right" value="Remove" />
							</td>
						</tr>
					</tbody>
			   </table>
		</c:forEach>
			<div class="clearfix">
				<input class="btn btn-primary pull-right" type="submit" value="Checkout" />
				<a class="btn btn-default" href="CustomerHome.jsp">Continue Shopping</a>
			</div>
		</form>
	</div>
</t:layout>