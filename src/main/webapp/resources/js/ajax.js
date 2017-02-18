/*
 * in this javascript file declare all common script method
 */
var ajax = {
    
    load : function(url, param){
        var data={};
        $.ajax({
            async    : false,
            type     : "GET",
            url     : url,
            data    : param,
            success : function(resonse) {
                data = resonse.data;
            },
            error     : function(e) {
                console.log("ERROR: ", e);
            }
        });
        return data
    },
    post    : function(url, data, header){
        var data='';
        console.log(url);
        console.log(data);
        console.log(header);
        
        $.ajax({
            type      : "POST",
            url       : url,
            data      : JSON.stringify(data),
            dataType  : 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(header.csrfToken, header.csrfHeader);
            },
            success  : function(resonse) {
                isPost = true;
                success(resonse.message);
            },
            error      : function(e) {
                isPost = false;
                console.log("ERROR: ", e);
                error("Unable to perform");
            }
        });
        return isPost;
    }
};
