//identify div element and create 'h1' tag to display output
var disp = document.getElementById("content");
var output = document.createElement("h1");
disp.appendChild(output);
//output.innerHTML = "test";

//create xmlHttprequest
var xhr = new XMLHttpRequest();
//open request
xhr.open("GET", "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message"
);
//trigger function based on readyStateChange
//for the life of me I cannot remember how to implement this step
//send request
xhr.send();

//function displays 'message' to page
function func(){
    output.innerHTML// = referance to 'message' value here 
                    // appended with value from xhr.responseURL
}