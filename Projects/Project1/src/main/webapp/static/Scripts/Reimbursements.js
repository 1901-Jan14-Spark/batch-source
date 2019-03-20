window.onload=function(){
	ajaxGetRequest(fillTable);
}

function ajaxGetRequest(process) {
	
	let xhr = new XMLHttpRequest();
	
	xhr.open("GET", "http://localhosts:8080/Project1/api/reimbursements");
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status >= 200 && xhr.status < 300){
				process(JSON.parse(xhr.response));
			} else {
				console.log(xhr.statusText);
			}
		}
	}
	xhr.send();
}

let reimbursements = [];

function fillTable(reimbursements){
	for(reimbursement of reimbursements){
		table.push(reimbursement);
		let row = document.createElement("tr");

		let rebId = document.createElement("td");
		rebId.innerHTML = `<a href="http://localhost:8080/Project1/api/reimbursement?id=${reimbursement.id}">${reimbursement.id}</a>`;
		let empId = document.createElement("td");
		empId.innerHTML = reimbursement.empId;
		let amount = document.createElement("td");
		amount.innerHTML = reimbursement.amount;
		let status = document.createElement("td");
		status.innerHTML = reimbursement.status;
		let reqDate = document.createElement("td");
		r.innerHTML = reimbursement.reqDate;
		let appDate = document.createElement("td");
		appDate.innerHTML = reimbursement.appDate;
		
		
		row.appendChild(rebId);
		row.appendChild(empId);
		row.appendChild(amount);
		row.appendChild(status);
		row.appendChile(reqDate);
		row.appendChild(appDate);
		document.getElementById("table").appendChild(row);
	}

}