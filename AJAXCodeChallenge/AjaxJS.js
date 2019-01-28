 // Use AJAX to make a get request to http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message

// Once the response is retrieved, convert it to a JavaScript object, and display the response on an HTML page. The html page should read “[message] from [url the message was received from].” Both the message and url should be information you get from the response

// Upload your completed exercise to GitHub when you’ve completed. You should not be using any external resources for this exercise or the assessment. You have 2 hours to complete your assessment and this code challenge. Good luck!



// xhr object

document.getElementsByTagName("button")[0].addEventListener("click", AJAXGet);

let xhr = new XMLHttpRequest;

function AJAXGet(){
  
    url = "testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";
    input = "http://";

    xhr.open("GET", input+url);

    function onReadyStateChange(){
        if(xhr.readyState == 4 && xhr.state == 200){
           
        }
    }
    
    console.log(xhr.HEADERS_RECEIVED);
    
    xhr.send();
    console.log(xhr.readyState);
}
result = JSON.parse(xhr.response);
document.getElementsByTagName("p")[0].innerHTML = `${message} from ${input+url}`;



