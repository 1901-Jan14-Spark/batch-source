/**
 *  evaluate the current session, displaying username when there is a current session with a username attribute
 *  and redirecting the page when there is not
 */

function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}


sendAjaxGet("http://localhost:8080/ServletLogin/session", populateUser);

function populateUser(xhr){
	let response = JSON.parse(xhr.response);
	console.log(response);
	if(response.username != null){
		document.getElementById("user").innerHTML = "You are logged in as "+response.username;
	} else {
		window.location = "http://localhost:8080/ServletLogin/login";
	}
}