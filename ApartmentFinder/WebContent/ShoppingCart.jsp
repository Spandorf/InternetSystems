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
		<div class="panel-body">
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
						<td>${cart.apartment.pricePerMonth}</td>
						<td>${cart.leaseTerm}</td>
						<td>${cart.apartment.applicationFee}</td>
						<td>${cart.total}</td>
					</tr>
				</tbody>
		   </table>
		</c:forEach>
		<form name="cartApt" id="cartApt" action="Apply">
		<input type="hidden" id="cartId" name="cartId" value="${cartId}" />
			<div class="panel-footer clearfix">
				<input class="btn btn-primary pull-right" type="submit" value="Checkout" />
				<span class="pull-right carttotal"> Total cost: ${total}   </span>
				<a class="btn btn-default" href="CustomerHome.jsp">Continue Shopping</a>
			</div>
		</form>
	</div>
	</div>
</t:layout>