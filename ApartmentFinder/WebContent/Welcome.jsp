<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:layout>
<div class="panel panel-default marginLeft marginRight">
	<div class="panel-heading">
		Apartment Finder
	</div>
	<div class="panel-body">
	<h2> Login </h2>
	<form action=Login>
 		<dl class="dl-horizontal">
			<dt>User Name:</dt>
			<dd>
				<input class="form-control" type="text" name="userName" value="" />
			</dd>
			<dt>Password:</dt>
			<dd>
				<input class="form-control" type="password" name="password" value="" />
			</dd>
		</dl>	
	<!-- Navigation links --> 
   		<input class="btn btn-primary pull-right" type=submit value="Login" />
   		<a class="btn btn-default pull-left" href="Register.jsp"> Are you a New User? </a>

	</form>
	</div>
</div>
</t:layout>