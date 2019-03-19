/**
 * 
 */

window.onload=function(){
	document.getElementById("view").addEventListener("click", repopulate);
	document.getElementById("validate").addEventListener("click", validate);
	document.getElementById("decline").addEventListener("click", decline);
	ajaxGetRequest( populateTable);

}

function validate(){
	let temp = document.getElementById("rId").innerHTML;
	if(document.getElementById("rState").innerHTML == 0){
		ajaxPutRequest("validate", printResponse, temp, "Request was approved.", "Unable to approve request.");
	}else if(temp!= null && temp.length > 0){
		alert("Request has already been handled!");
	}
}


function decline(){
	let temp = document.getElementById("rId").innerHTML;
	if(document.getElementById("rState").innerHTML == 0){
		ajaxPutRequest("decline", printResponse, temp, "Request was declined.", "Unable to decline request.");
	}else if(temp!= null && temp.length > 0){
		alert("Request has already been handled!");
	}
}

function ajaxPutRequest(url, callback, objectJS, sMessage, fMessage) {

	let xhr = new XMLHttpRequest();

	xhr.open("put", "http://localhost:8080/ReimbursementApp/api/reimbursement/" + url);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status < 300 && xhr.status >= 200) {
				alert(sMessage);
				callback(xhr);
			} else {
				console.log(xhr.status + xhr.statustext);
				alert(fMessage);
			}
		}
	}

	xhr.setRequestHeader("Content-type", "application/json");
	let jsonObject = JSON.stringify(objectJS);
	xhr.send(jsonObject);
}

function ajaxGetRequest(process) {

	let xhr = new XMLHttpRequest();

	xhr.open("get", "http://localhost:8080/ReimbursementApp/api/reimbursements");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status >= 200 && xhr.status < 300) {
				process(JSON.parse(xhr.response));
			} else {
				console.log(xhr.statusText);
			}
		}
	}
	xhr.send();
}

let table = [];


function repopulate(){
	let setting = document.getElementById("viewSettings").value;
	var new_tbody = document.createElement('tbody');
	new_tbody.id = "reimbBody";
	if(setting === "all"){
		for(reimbursement of table){
			let row = document.createElement("tr");

			let id = document.createElement("td");
			id.innerHTML = reimbursement.id;
			let title = document.createElement("td");
			title.innerHTML = reimbursement.title;
			let amount = document.createElement("td");
			amount.innerHTML = reimbursement.amount;
			let state = document.createElement("td");
			state.innerHTML = reimbursement.state;

			row.appendChild(id);
			row.appendChild(title);
			row.appendChild(amount);
			row.appendChild(state);
			id.addEventListener("click", displayReimbursement);
			new_tbody.appendChild(row);
		}
	}else if(setting === "unresolved"){
			for(reimbursement of table){
				if(reimbursement.state === 0){
					let row = document.createElement("tr");

					let id = document.createElement("td");
					id.innerHTML = reimbursement.id;
					let title = document.createElement("td");
					title.innerHTML = reimbursement.title;
					let amount = document.createElement("td");
					amount.innerHTML = reimbursement.amount;
					let state = document.createElement("td");
					state.innerHTML = reimbursement.state;

					row.appendChild(id);
					row.appendChild(title);
					row.appendChild(amount);
					row.appendChild(state);
					id.addEventListener("click", displayReimbursement);
					new_tbody.appendChild(row);
				}
			}
	}else if(setting === "solved")

				for(reimbursement of table){
					if(reimbursement.state > 0){
						let row = document.createElement("tr");

						let id = document.createElement("td");
						id.innerHTML = reimbursement.id;
						let title = document.createElement("td");
						title.innerHTML = reimbursement.title;
						let amount = document.createElement("td");
						amount.innerHTML = reimbursement.amount;
						let state = document.createElement("td");
						state.innerHTML = reimbursement.state;

						row.appendChild(id);
						row.appendChild(title);
						row.appendChild(amount);
						row.appendChild(state);
						id.addEventListener("click", displayReimbursement);
						new_tbody.appendChild(row);
					}
				}

	document.getElementById("reimbBody").parentNode.replaceChild(new_tbody,document.getElementById("reimbBody") );
}



function populateTable(reimbursements){
	for(reimbursement of reimbursements){
		table.push(reimbursement);
		let row = document.createElement("tr");

		let id = document.createElement("td");
		id.innerHTML = reimbursement.id;
		let title = document.createElement("td");
		title.innerHTML = reimbursement.title;
		let amount = document.createElement("td");
		amount.innerHTML = reimbursement.amount;
		let state = document.createElement("td");
		state.innerHTML = reimbursement.state;

		row.appendChild(id);
		row.appendChild(title);
		row.appendChild(amount);
		row.appendChild(state);

		id.addEventListener("click", displayReimbursement);
		document.getElementById("reimbBody").appendChild(row);
	}
}

function displayReimbursement(){
	for(r of table){
		if(r.id ==  this.innerHTML){
			console.log("inside if");
			document.getElementById("rId").innerHTML = r.id;
			document.getElementById("reId").innerHTML = r.employee_id;
			document.getElementById("rTitle").innerHTML = r.title;
			document.getElementById("rDescription").innerHTML = r.description;
			document.getElementById("rAmount").innerHTML = r.amount;
			document.getElementById("rState").innerHTML = r.state;
			document.getElementById("rmId").innerHTML = r.manager_id;
		}
	}
}

function printResponse(xhrObject) {
	console.log(xhrObject.response);
}
