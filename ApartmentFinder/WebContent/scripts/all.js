

$(document).on('click', '#registerBtn', function(event) {
	var password = $('#password').val();
	var confirmPassword = $('#confirmPassword').val();
	
	if(password !== confirmPassword) {
		alert('Your passwords do not match!');
		event.preventDefault();
	}
});

$(document).on("submit", "#apartmentForm", function(event) {
    var apartmentId = $('#apartmentId').val();
    var leaseTerm = $('#leaseTerm').val();
    
    var params = {
    		apartmentId: apartmentId,
    		leaseTerm: leaseTerm
    };
    
    $.post("AddToCart", $.param(params), function(response) {
        	alert("Apartment added to cart");
    });

    event.preventDefault(); // Important! Prevents submitting the form.
});