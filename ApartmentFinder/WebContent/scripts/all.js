

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
	$('#printBtn').hide();
});

$(document).on('click', '#printBtn', function(event) {
	window.print();
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
    
    $.ajax({
    	type: 'POST',
    	url: '../Banking/Bank',
    	data: $.param(params),
    	success: function(response) {
    		handleResponse(response);
    		
    		$('#printBtn').show();
    		updateHistory();
    	},
    	error: function(response) {
    		handleResponse(response);
    	}
    });
    
    // call to update the app history
    var updateHistory = function() {
    	var params = {
    			cartId: cartId
    	};
    	
    	$.post('UpdateApplicationHistory', $.param(params), function(response) {console.log(response)});
    }

});

var handleResponse = function(response) {
	if(response.transactionSuccess) {
		$('#successMessage').html('<b>Success!</b> The transaction was successful.');
		$('#successMessage').show();
		$('#failureMessage').hide();
	}
	else {
		$('#failureMessage').html('<b>Error!</b> ' + response.errorMessage);
		$('#failureMessage').show();
		$('#successMessage').hide();
	}
}
