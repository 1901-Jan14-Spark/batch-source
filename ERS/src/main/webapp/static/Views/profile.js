sessionURL = "http://localhost:8080/ERS/session"

function ajaxRequest(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			callback(this);
		}
	}
	xhr.send();
}

window.onload = function(){
	ajaxRequest(sessionURL, showSession);
}

function showSession(xhr){
    let session = JSON.parse(xhr.responseText);
    let fname = document.getElementById("fname");
    let lname = document.getElementById("lname");

    fname.setAttribute("placeholder", session.fname);
    lname.setAttribute("placeholder", session.lname);
	
}