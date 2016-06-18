<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


			
<t:layout>
<script type="text/javascript">   
	$(function() {$( "#move_in_date" ).datepicker();}); 
</script>
	<jsp:useBean id="user" scope="session" type="model.User" />
	<h1>Hello <jsp:getProperty name="user" property="username" />!</h1>
    <form method="post" action="ApartmentSearch">
    	<div class="panel panel-default marginLeft marginRight">
	    	<div class="panel-heading">
	    		Apartment Search
	    	</div>
	    	<div class="panel-body">
	    		<dl class="dl-horizontal">
	    			<dt>Move-in Date</dt>
	    			<dd>
	    				<div class='searchfield'><input class="form-control" type="text" name="move_in_date" id="move_in_date"/></div>
	    			</dd>
	    			<dt>Price Range</dt>
	    			<dd>
	    				<div class='searchfield'><input class="form-control price-range" type="text" name="price_range_low" value="" /> - <input class="form-control price-range" type="text" name="price_range_high" value="" /></div>
	    			</dd>
	    			<dt>Location</dt>
	    			<dd>
	    				<div class='searchfield'><input class="form-control" type="text" name="location" value="" /></div>
	    			</dd>
	    			<dt>Apartment Type</dt>
	    			<dd>
	    				<div class='searchfield'><select  class="form-control searchfield" name="apartment_type">
							<option value="studio">Studio</option>
							<option value="1bd">1 BD</option>
							<option value="2bd">2 BD</option>
							<option value="3bd">3 BD</option>
						</select></div>
	    			</dd>
	    		</dl>
	    	</div>
	    	<div class="panel-footer clearfix">
	    		<input class="btn btn-default pull-left" type="reset" value="Reset" />
	    		<a class="btn btn-primary pull-right" href="ApartmentSearchResults.jsp"> Search </a>
	    	</div>
    	</div>
    </form>
</t:layout>