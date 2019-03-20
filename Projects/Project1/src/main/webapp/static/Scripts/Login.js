let url = "http://localhost:8080/Project1/api/login";

function sendPost(){
	let attempt = getLoginInfo();
	ajaxPostRequest(url, printResponse, attempt);
}

function printResponse(xhrObject) {
	console.log(xhrObject.response);
}

function ajaxPostRequest(url, callback, objectJS) {

	let xhr = new XMLHttpRequest();

	xhr.open("POST", url);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status < 300 && xhr.status >= 200) {
				callback(xhr);
			} else {
				console.log(xhr.status);
			}
		}
	}

	xhr.setRequestHeader("Content-type", "application/json");
	let jsonObject = JSON.stringify(objectJS);
	xhr.send(jsonObject);
}

function getLoginInfo() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    
    return patient;
}