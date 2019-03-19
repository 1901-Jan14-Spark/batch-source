/**
 * 
 */
window.onload = function(){
	document.getElementById("submitButton").addEventListener("click", sendPost);
}

function ajaxPostRequest(callback, objectJS) {

	let xhr = new XMLHttpRequest();

	xhr.open("post", "http://localhost:8080/ReimbursementApp/api/reimbursements");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status < 300 && xhr.status >= 200) {
				callback(xhr);
			} else {
				console.log(xhr.status + xhr.statustext);
			}
		}
	}

	xhr.setRequestHeader("Content-type", "application/json");
	let jsonObject = JSON.stringify(objectJS);
	xhr.send(jsonObject);
}

// Submit post Request
function sendPost(){
	let temp = getDataFromForm();
	ajaxPostRequest(printResponse, temp);
}

function getDataFromForm() {
    let title = document.getElementById("title").value;
    let amount = document.getElementById("amount").value;
    let description  =  document.getElementById("description").value;
    let reimbursement = {
    		title : title,
    		amount : amount,
    		description : description
    } 
    console.log(reimbursement);
    return reimbursement;
}
  
function printResponse(xhrObject) {
	console.log(xhrObject.response);
}
