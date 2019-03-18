function sendAjaxGet(url, funct){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function (){
		if(this.readyState === 4 && this.status === 200){
			funct(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet("http://localhost:9393/Project1/session", showError);

function showError(xhr){
	let errorMessage = JSON.parse(xhr.response);
	if(errorMessage.email == "error"){
		console.log(errorMessage.email);
		let errorP = document.getElementById("hiddenMessage");
		errorP.removeAttribute("hidden");
		errorP.innerHTML = "Your email or password seem to be incorrect. Please try again.";
	} else {
		errorP.setAttribute("hidden", true);
	}

}
