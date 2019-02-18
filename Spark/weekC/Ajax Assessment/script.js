const url = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";
const pTag = document.getElementById("message");

let XHR = new XMLHttpRequest();
XHR.onreadystatechange = function () {
    if (XHR.readyState == 4 && XHR.status == 200) {
        let data = JSON.parse(XHR.responseText);
        console.log(data);
        pTag.innerHTML = `${data.message} from ${url}`;
       
    }
}
XHR.open("GET", url);
XHR.send();

