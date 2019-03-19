/**
 * 
 */

window.onload=function(){
	document.getElementById("view").addEventListener("click", repopulate);
	ajaxGetRequest( populateTable);
	
}



function ajaxGetRequest( process) {

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
	console.log("repopulating");
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
			new_tbody.appendChild(row);
		}}else if(setting === "unresolved"){
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
				new_tbody.appendChild(row);
			}
		}}else if(setting === "solved")
			if(reimbursement.state > 0){
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
		new_tbody.appendChild(row);
	}}
	
	document.getElementById("reimbBody").parentNode.replaceChild(new_tbody,document.getElementById("reimbBody") );
}



function populateTable(reimbursements){
	for(reimbursement of reimbursements){
		table.push(reimbursement);
		let row = document.createElement("tr");

		let id = document.createElement("td");
		id.innerHTML = `<a href="http://localhost:8080/ReimbursementApp/api/reimbursement?id=${reimbursement.id}">${reimbursement.id}</a>`;
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
		document.getElementById("reimbBody").appendChild(row);
	}
}