//Use AJAX to make a get request to http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message

// Once the response is retrieved, convert it to a JavaScript object, and display the response on an HTML page. The html page should read “[message] from [url the message was received from].” Both the message and url should be information you get from the response

// Upload your completed exercise to GitHub when you’ve completed. You should not be using any external resources for this exercise or the assessment. You have 2 hours to complete your assessment and this code challenge. Good luck!
/html/body


// Best guess is to set up an HTTP request addressed to the address given in the exercise

let request = URL("http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message");

let x = document.getElementsByTagName("body");
console.log(x)
let x = fetch("http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message", {"credentials":"omit","headers":{"accept":"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8","accept-language":"en-US,en;q=0.9","cache-control":"max-age=0","upgrade-insecure-requests":"1"},"referrerPolicy":"no-referrer-when-downgrade","body":null,"method":"GET","mode":"cors"}); ;



// fetch("http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/favicon.ico", {"credentials":"omit","headers":{"accept":"image/webp,image/apng,image/*,*/*;q=0.8","accept-language":"en-US,en;q=0.9","cache-control":"no-cache","pragma":"no-cache"},"referrer":"http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message","referrerPolicy":"no-referrer-when-downgrade","body":null,"method":"GET","mode":"cors"});