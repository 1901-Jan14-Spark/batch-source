window.onload=function(){
	ajaxGetRequest( populateTable);
}

function ajaxGetRequest( process) {

	let xhr = new XMLHttpRequest();

	xhr.open("get", "http://localhost:8080/api/reimbursements/emp");

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

function populateTable(reimbursements){
	for(reimbursement of reimbursements){
		let row = document.createElement("tr");

		let id = document.createElement("td");
		id.innerHTML = reimbursement.id;
		let title = document.createElement("td");
		title.innerHTML = reimbursement.title;
		let description = document.createElement("td");
		description.innerHTML = reimbursement.description;
		let amount = document.createElement("td");
		amount.innerHTML = reimbursement.amount;
		let status = document.createElement("td");
		status.innerHTML = reimbursement.status;
		
		row.appendChild(id);
		row.appendChild(title);
		row.appendChild(description);
		row.appendChild(amount);
		row.appendChild(status);
		document.getElementById("reimbTable").appendChild(row);
	}
}