

$(document).on('click', '#registerBtn', function(event) {
	var password = $('#password').val();
	var confirmPassword = $('#confirmPassword').val();
	
	if(password !== confirmPassword) {
		alert('Your passwords do not match!');
		event.preventDefault();
	}
});