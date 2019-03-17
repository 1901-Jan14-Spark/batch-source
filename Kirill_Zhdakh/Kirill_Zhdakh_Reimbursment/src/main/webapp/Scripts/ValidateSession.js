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


sendAjaxGet("http://localhost:8080/KirillReimbursment/profile", checkLogin);

function checkLogin(xhr){
	let response = JSON.parse(xhr.response);
	if(response.username == null)
		window.location = "http://localhost:8080/KirillReimbursment/login";
}