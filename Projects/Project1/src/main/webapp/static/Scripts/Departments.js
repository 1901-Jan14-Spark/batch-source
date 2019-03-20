function sendAjaxGet(url){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet("http://localhost:8080/Project1/api/departments");