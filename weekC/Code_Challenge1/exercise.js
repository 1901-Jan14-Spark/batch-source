// Use AJAX to make a get request to http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message
//
// Once the response is retrieved, convert it to a JavaScript object, and display the response on an HTML page.
// The html page should read “[message] from [url the message was received from].” Both the message and url should be information you get from the response
//
// Upload your completed exercise to GitHub when you’ve completed. You should not be using any external resources for this exercise or the assessment.
// You have 2 hours to complete your assessment and this code challenge. Good luck!


let baseUrl = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";

window.onload = function(){
  openMessage();
}

function openMessage(){
    sendAjaxGet(baseUrl, displayMessage);
}

function sendAjaxGet(url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);

    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            callback(this);
        } else if (this.status == 400){
            displayError();
        }
    }

    xhr.send();
}

function displayMessage(xhr){
    let message = JSON.parse(xhr.response);

    document.getElementById("message").innerHTML = `${message.message} from ${xhr.responseURL}`;

}
