/**
 * 
 */

function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.onreadystatechange =function(){
		if(this.readyState === 4 && this.status ===200){
			func(this);
		}
	}
	
	xhr.open("GET", url);
	xhr.send();
	
}

sendAjaxGet("http://localhost:8080/ServletLogin/session", populateUser);

function populateUser(xhr){
	let response = JSON.parse(xhr.response)
	
	console.log(response)
	
	if(response.username !=null){
		document.getElementById("session").innerHTML = "You're Logged in as "+response.username;
	} else{
		windows.location ="http://localhost:8080/ServletLogin/login";
	}
		
}