

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

// hide the message containers initially
$(document).ready(function() {
	$('#successMessage').hide();
	$('#failureMessage').hide();
});

$(document).on('click', '#confirmPaymentBtn', function() {
	var data = {};
	data.cost = $("#cost").val();
	data.cardholder = $("#cardholder").val();
	data.cardType = $("#cardType").val();
	data.cardNumber = $("#cardNumber").val();
	data.cvv = $("#cvv").val();
	
	$.ajax({
		url: '../Banking/Bank',
		data: JSON.stringify(data),
		type: 'POST',
		success: function(response) {
			console.log(response);
			if(response.success) {
				$('#successMessage').innerHtml('<b>Success!</b> The transaction was successful.');
				$('#successMessage').show();
			}
			else {
				$('#failureMessage').innerHtml('<b>Error!</b> ' + response.errorMessage);
				$('#successMessage').show();
			}
		},
		error: function(response) {
			console.log(response);
			$('#failureMessage').innerHtml('<b>Error!</b> The transaction was not successful.');
		}
	});
});