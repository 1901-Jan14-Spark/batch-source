/**
 * 
 */

window.onload = function(){
//	console.log("I'm alive");
//	document.getElementById("submitButton").addEventListener("click", sendPost);
}

let url = "http://localhost:8080/ReimbursementApp/api/login";

function sendPost(){
	let temp = getDataFromForm();
	ajaxPostRequest(url, printResponse, temp);
}

function printResponse(xhrObject) {
	console.log(xhrObject.response);
}

function ajaxPostRequest(url, callback, objectJS) {

	let xhr = new XMLHttpRequest();

	xhr.open("post", url);

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

function getDataFromForm() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    
    return patient;
}