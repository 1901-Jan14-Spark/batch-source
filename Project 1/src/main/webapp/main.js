let postUrl = "http://localhost:9393/login";

document.getElementById("loginButton").addEventListener("click", loginAttempt);

function loginAttempt(){
    ajaxPost("POST", postUrl);
}

function ajaxPost(method, url){
	let email = document.getElementById("emailInp").value;
	let password = document.getElementById("passInp").value;
    var xhr = new XMLHttpRequest();
    xhr.open(method, postUrl, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
        	callback(this);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/json");
    let JSONString = JSON.stringify(email);
    let JSONPass = JSON.stringify(password);
    xhr.send(xhr.response);
}

function testFunction(data){
    document.getElementById("hiddenMessage").removeAttribute("hidden");
    document.getElementById("hiddenMessage").innerHTML = `${data}`;
}