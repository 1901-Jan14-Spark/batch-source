url: "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";

XMLHttpRequest=document.getElementById("sumbit").addEventListener("clcik", getInfo)
var request = document.getElementById("Input").nodeValue;
function getInfo(){

var Message=//information from url


document.getElementById("Respones").innerHTML=`${Message} from ${URL}`
}