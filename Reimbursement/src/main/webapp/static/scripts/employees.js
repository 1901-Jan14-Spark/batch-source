function sendGet(url, callback){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

//sendGet()

