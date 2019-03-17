// the url where all of our messages will come from 
var baseURL = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";

//the function that will display the message
function showMessage(){
    let xhr = new XMLHttpRequest(); // create a new request

    xhr.open("GET", baseURL); // designate the request method and the address

    

    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){ // check to see if the request has been completed successfully 
        message = JSON.parse(xhr.responseText).message; // turn the message into a string
        message += " from " + baseURL; // combine the message and the source url into a new string
        document.getElementById("message").innerHTML = `${message} from ${baseURL}`;
        } // change the innerHTML of the paragraph tag (referenced by it's id name) to the new combined string
    }
    xhr.send(); // send the request
}

// this event listner executes the function when the button is clicked.
document.getElementById("messageButton").addEventListener("click", showMessage);









