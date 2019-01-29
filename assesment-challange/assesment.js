let baseUrl = "http://testapp-env.hnpsxrq3bj.us-east-1.elasticbeanstalk.com:8080/message";

document.getElementById("button").addEventListener("click", loadMessage);


function loadMessage() {
    const xhr = new XMLHttpRequest();

    xhr.open("GET", baseUrl , true);

    xhr.onreadystatechange = function(){
        if(this.readyState===4 && this.status===200){
            var parseMessage = JSON.parse(xhr.response);
            document.getElementById('output').innerHTML = `<h1>${parseMessage.message} from ${baseUrl}`;
        } else if (this.status== 400){
            displayError();
        }
    }
    xhr.send();
}

function displayError(){
    document.getElementById("error").innerHTML = "Error 400";
}
