<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:useBean id="user" scope="session" type="model.User" />
	<h1>Hello <jsp:getProperty name="user" property="userName" />!</h1>
	<div class="panel panel-default">
		<div class="panel-heading">
			Apartment Search Results
		</div>
		<table class="table">
	       <thead>
	           <tr>
	               <th>Landlord</th>
	               <th>Address</th>
	               <th>Apartment Type</th>
	               <th>Area of Apartment</th>
	               <th>Company rating</th>
	               <th>Price per month</th>
	               <th>Amenities</th>
	               <th></th>
	           </tr>
	       </thead>
	       <tbody>
	           <tr>
	               <td>John Doe</td>
	               <td>1600 Penn</td>
	               <td>Studio</td>
	               <td>1600 sq. ft.</td>
	               <td>4/5</td>
	               <td>1000</td>
	               <td>AC, Cable, Fireplace</td>
	               <td>
	               		<a class="btn btn-primary pull-right" href="ViewApartment.jsp">View/Apply</a>
	               </td>
	           </tr>
	           <tr>
	               <td>Jane Bae</td>
	               <td>3111 F St.</td>
	               <td>2 BD</td>
	               <td>1000 sq. ft.</td>
	               <td>3/5</td>
	               <td>750</td>
	               <td>AC, Cable, Fireplace</td>
	               <td>
	               		<a class="btn btn-primary pull-right" href="ViewApartment.jsp">View/Apply</a>
	               </td>
	           </tr>
	       </tbody>
	   </table>
	</div>


</t:layout>