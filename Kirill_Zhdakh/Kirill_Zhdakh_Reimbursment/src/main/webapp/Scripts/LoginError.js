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


sendAjaxGet("http://localhost:8080/PEAKReimbursment/session", checkLogin);

function checkLogin(xhr){
	let response = JSON.parse(xhr.response);
	if(response.error != null)
		document.getElementById("loginerror").innerHTML = response.error;
}