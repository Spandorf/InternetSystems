

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
    event.preventDefault();
    $.post("AddToCart", $.param(params), function(response) {
        	alert("Apartment added to cart");
    });

});

$("#cartRemove").click(function() {
    var itemId = $(this).closest("tr").find('#cartid').val();         

    var params = {
    		itemId: itemId
    };
    
    $.post("RemoveFromCart", $.param(params), function(response){});   
});



//hide the message containers initially
$(document).ready(function() {
	$('#successMessage').hide();
	$('#failureMessage').hide();
});

$(document).on("submit", "#applicationForm", function(event) {
	event.preventDefault();
    var appTotal = $('#appTotal').val();
    var cartId = $('#cartId').val();
    var cardholder = $('#cardholder').val();
    var cardType = $('#cardType').val();
    var cardNumber = $('#cardNumber').val();
    var cvv = $('#cvv').val();
    
    var params = {
    		appTotal: appTotal,
    		cartId: cartId,
    		cardholder: cardholder,
    		cardType: cardType,
    		cardNumber: cardNumber,
    		cvv: cvv
    };
    
    $.post('../Banking/Bank', $.param(params)).done(function(response) {
    	alert(response);
		console.log(response);
		if(response.success) {
			$('#successMessage').innerHtml('<b>Success!</b> The transaction was successful.');
			$('#successMessage').show();
		}
		else {
			$('#failureMessage').innerHtml('<b>Error!</b> ' + response.errorMessage);
			$('#successMessage').show();
		}
    });

});
