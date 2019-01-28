var url = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";

let xhr = new XMLHttpRequest();

xhr.open("GET", url);

xhr.send();

xhr.onreadystatechange = function(){
    let message = "";
    if(xhr.readyState == 4 && xhr.status == 200){
    message = JSON.parse(xhr.responseText);
    message += " from " + url;
    document.getElementsByTagName("p")[0].innerHTML = message;
    console.log(message);
    }
}

