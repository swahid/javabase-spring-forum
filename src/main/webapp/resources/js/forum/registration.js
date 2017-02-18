
/*
 * registration function with jquery ajax 
 */
$(document).ready(function($) {
    
    var revapi = $('.tp-banner').revolution({
                    delay : 15000,
                    startwidth : 1200,
                    startheight : 278,
                    hideThumbs : 10,
                    fullWidth : "on"
                });
    
    $("#registerForm").submit(function(event) {
        
        event.preventDefault();
        
        // Form validation use jquery validation plugin
        javascript: $(registerForm).validationEngine('attach');
        if (!$(registerForm).validationEngine('validate')) {
            return;
        }
        var data = {}
            data["username"]   = $("#firstName").val(),
            data["username"]   = $("#lastName").val(),
            data["username"]   = $("#username").val(),
            data["password"]   = $("#pass2").val(),
            url = "registration/new";
        
        var token = $('#csrfToken').val();
        var header = $('#csrfHeader').val();
        
        /*
         * if in spring aplication csrf enable
         * send csrf parameter in header otherwise 405 error
         */
        $.ajax({
            type      : "POST",
            url       : url,
            data      : JSON.stringify(data),
            dataType  : 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(header, token);
            },
            success  : function(resonse) {
                var message = "registration Sucess";
                console.log(resonse.data);
                alert(resonse.message);
                data = null;
                document.getElementById("registerForm").reset()
            },
            error      : function(e) {
                console.log("ERROR: ",e);
                alert("registration falied");
//                        $("#msg").html(e.message);
                data = null;
                document.getElementById("registerForm").reset()
            }
        });
        
    });
});