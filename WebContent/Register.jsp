<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<head>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script src="/ApartmentFinder/scripts/all.js"></script>
</head>

<t:layout>
<div class="panel panel-default marginLeft marginRight">
	<div class="panel-heading">
		Register 
	</div>
	<div class="panel-body">
		<h2> Register </h2>
		<form action=Register>
 		<dl class="dl-horizontal">
			<dt>User Name:</dt>
			<dd>
				<input class="form-control" type="text" name="userName" value="" />
			</dd>
			<dt>Password:</dt>
			<dd>
				<input class="form-control" id="password" type=password name="password" value="" />
			</dd>
			<dt>Confirm Password:</dt>
			<dd>
				<input class="form-control" id="confirmPassword" type=password name="confirm_password" value="" />
			</dd>
		</dl>	
		<input class="btn btn-primary pull-right" type=submit id="registerBtn" value=Register />
		</form>
   	</div>
</div>
</t:layout>
