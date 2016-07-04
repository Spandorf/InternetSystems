<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<!-- jQuery -->
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
		<script src="http://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" href="/ApartmentFinder/css/all.css">
	</head>
	<body>
		<!-- Navigation Bar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="CustomerHome.jsp">Apartment Finder</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse in">
					<ul class="nav navbar-nav">
						<li>
							<a href="CustomerHome.jsp">Home</a>
						</li>
						<li>
							<a href="ManageApplication">Manage Applications</a>
						</li>
						<li>
							<a href="ViewCart">Cart</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="Logout">Logout</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div id="bodyContent">
			<jsp:doBody />	
		</div>
		
	</body>
</html>