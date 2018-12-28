$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#studentForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		name : $("#name").val(),
    		branch :  $("#branch").val()
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + "insert",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();
 
    }
    
    function resetData(){
    	$("#name").val("");
    	$("#branch").val("");
    }
})