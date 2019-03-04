let xhr = new XMLHttpRequest;
let url = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";
xhr.open("GET", url);
xhr.onreadystatechange = function(){
    if(this.readyState == 4 && this.status == 200){
        console.log(this.status)
        console.log(this.readyState)
        processReq(this);
    }
    else
        console.log("Waiting....");
}
xhr.send();
function processReq(response){
    message = JSON.parse(response.response);
    document.getElementById("response").innerHTML = message.message + " - From: " + url;
}
