$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#marksForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var data={rollNumber :$("rollNumber").val()}
    	var formData = {
    	    subjectName : $("#subjectName").val(),
    	    marks :  $("#marks").val(),
    		std   :  data
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
    	$("#roll").val("");
    	$("#branch").val("");
    	$("#marks").val("");
    }
})