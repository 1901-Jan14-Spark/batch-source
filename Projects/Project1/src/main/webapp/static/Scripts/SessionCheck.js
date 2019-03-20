/**
 * checking to find the condition of the current session, letting someone know when they're logged in, and redirecting them if they're not
 */

function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet("http://localhost:8080/Project1/session", populateUser);

function populateUser(xhr){
	let response = JSON.parse(xhr.response);
	console.log(response);
	if(response.username != null){
		document.getElementById("currentUser").innerHTML = "Welcome back "+ response.firstname + "!";
	} else {
		window.location = "http://localhost:8080/Project1/login";
	}
}