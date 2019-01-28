var baseURL = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";
var xml = new XMLHttpRequest();
function sendRequest(){
    xml.open("GET", baseURL);
    xml.onreadystatechange = function(){
        if(xml.readyState == 4 && xml.status == 200){
            createMessage();
        }
    }
   xml.send();
}

function createMessage(){
    var resp = document.getElementById("messageOut");
    var messObject = JSON.parse(xml.response);
    var mess = `${messObject.message} from ${baseURL}`;
    resp.innerHTML = mess;
}
sendRequest();

