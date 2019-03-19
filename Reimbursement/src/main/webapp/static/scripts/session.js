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


sendAjaxGet("http://localhost:8080/Reimbursement/api/session", populateUser);

function populateUser(xhr){
	let response = JSON.parse(xhr.response);
	console.log(response);
	if(response.username != null){
		document.getElementById("user").innerHTML = "Welcome: "+response.username;
	} else {
		window.location = "http://localhost:8080/Reimbursement/login";
	}
}