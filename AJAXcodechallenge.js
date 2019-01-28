//Colin Keiper AJAX code challenge submission
//There are several places in this file where I know I do not have the correct syntax or command, so instead I have a similar-looking command written in its place to convey the intent. I know this code will not run, but this is the best representation of my internalized AJAX knowledge I can give you.
let rawJSON = document.XMLHTTPRequest("http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message") //make request to server and store response in a variable. (The proper syntax for this is in my notes)

object = rawJSON.JSONpasrse(); //parse the raw data from request into a JS object
message = object[0]; //get message from object

document.getElementById("messageHere").innerHTML = `${message} from http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message` //add message to HTML