


function sendPut(url, callback){
	let reimId = document.getElementById("reimID");
	let status = document.getElementById("status");
	let resolvedby = document.getElementById("resolvedby");
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.onreadystatechange=function(){
		if(xhr.readystate ===4 && xhr.status ===200){
			callback(this);
		}
		let update = {reimId, status, resolved}
		xhr.send(JSON.stringify(resolvedby));
		}
}

let button = document.getElementById("formbutt");

url ="http://localhost:8080/Reimbursement/reimbursements";
function doPut(){
	sendPut(url, operation)
}
button.addEventListener("click", doPut());

function operation(xhr){
	console.log(xhr.response);	 
	}