let expsURL = "http://localhost:8080/ERS/api/reimbursements";
let sessionURL = "http://localhost:8080/ERS/session";

function ajaxRequest(method, url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open(method, url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			callback(this);
		}
	}
	xhr.send();
}

function ajaxPOST(url, approveReq){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 201){
			console.log("It's working!!");
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	let flightJSON = JSON.stringify(newFlightObj);
	xhr.send(flightJSON);
}

window.onload = function(){
	ajaxRequest("GET", sessionURL, showSession);
}

function showSession(xhr){
    let session = JSON.parse(xhr.responseText);
    let fname = document.getElementById("email");

    fname.setAttribute("placeholder", session.email);
    
	
}



