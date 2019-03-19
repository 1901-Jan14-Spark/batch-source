function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}


//	let url ="http://localhost:8080/Reimbursement/api/reimbursementslist";
	sendAjaxGet("http://localhost:8080/Reimbursement/api/reimbursementslist", populate);

	function populate(xhr){
		reims = JSON.parse(xhr.response)
		 let table = document.getElementById("ReimsTab");
		for (r in reims){
			let nextRow = document.createElement("tr");
			nextRow.innerHTML = `<td>${reims[r].reim_id}</td>
			<td>${reims[r].reim_name}</td><td>${reims[r].requester_Id}</td>
			<td>${reims[r].amount}</td><td>${reims[r].reimStatus}</td><td>${reims[r].resolvedId}</td>`;
			table.appendChild(nextRow);
		}
		
	}