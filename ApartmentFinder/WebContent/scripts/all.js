

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

$(document).on("submit", "#applicationForm", function(event) {
    var apartmentId = $('#apartmentId').val();
    var leaseTerm = $('#leaseTerm').val();
    
    var params = {
    };
    
});