let url = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";

// Executes function on-load
window.onload = function(){
    xhrRequest();
}


function xhrRequest(){
    // Create xhr request
    let xhr = new XMLHttpRequest();

    // Opens xhr request, sets HTTP method and URL
    xhr.open("get", url);

    // Executes on ready state changes
    xhr.onreadystatechange = function(){

        // Checks for completion and success status code
        if(xhr.readyState == 4 && xhr.status == 200){

            // Object created from JSON response
            let obj = JSON.parse(xhr.responseText);

            // Placing message in div element
            document.getElementById("message").innerHTML = `"${obj.message}" from "${xhr.responseURL}"`
        }
    }

    // submitting request 
    xhr.send();
}