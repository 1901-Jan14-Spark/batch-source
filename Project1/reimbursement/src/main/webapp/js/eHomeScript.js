function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState===4 && xhr.status===200){
			func(xhr);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendAjaxGet('http://localhost:8080/RefundSite/curremp', display);

function display(xhr){
	let requests = JSON.parse(xhr.response);
	document.getElementById("currUserName").innerHTML = requests.eName;
}