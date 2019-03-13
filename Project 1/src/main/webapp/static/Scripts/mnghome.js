function sendAjaxGet(url, funct){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function (){
		if(this.readyState === 4){
			funct(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet("http://localhost:9393/Project1/session", runWelcome);

function runWelcome(xhr){
	let response = JSON.parse(xhr.response);
	console.log(response);
	
	if(response.email != null){
		document.getElementById("greeting").innerHTML = `Welcome back, ${response.email} <i class="	fa fa-angle-double-down" style="font-size:20px"></i>`;
	} else {
		window.location = "http://localhost:9393/Project1/login";
	}
}
