<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <form method="post" action="ApartmentSearch">
    	<div class="panel panel-default marginLeft marginRight">
	    	<div class="panel-heading">
	    		Apartment Search
	    	</div>
	    	<div class="panel-body">
	    		<dl class="dl-horizontal">
	    			<dt>Move-in Date</dt>
	    			<dd>
	    				<input class="form-control" type="text" name="move_in_date" value="" />
	    			</dd>
	    			<dt>Price Range</dt>
	    			<dd>
	    				<input class="form-control" type="text" name="price_range_low" value="" /> - <input class="form-control" type="text" name="price_range_high" value="" />
	    			</dd>
	    			<dt>Location</dt>
	    			<dd>
	    				<input class="form-control" type="text" name="location" value="" />
	    			</dd>
	    			<dt>Apartment Type</dt>
	    			<dd>
	    				<select  class="form-control" name="apartment_type">
							<option value="studio">Studio</option>
							<option value="1bd">1 BD</option>
							<option value="2bd">2 BD</option>
							<option value="3bd">3 BD</option>
						</select>
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