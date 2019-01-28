// URL we are requesting information from
let url = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";
// p id is messageHere
let htmlElement = document.getElementById("messageHere");

window.onLoad = function() {
    getMessage();
}

function getMessage() {
    var requestXHR = new XMLHttpRequest;
    requestXHR.onreadystatechange = function() {
        if (requestXHR.readyState == 4 && requestXHR.status == 400) {
            htmlElement = JSON.parse(requestXHR.message[0]);
        }
    }
    request.open("GET", "URL ");
    request.send();
}