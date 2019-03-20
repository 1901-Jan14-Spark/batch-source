function sendGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

sendGet("http://localhost:8080/Reimbursement/api/session", populateUser);

function populateUser(xhr){
	let response = JSON.parse(xhr.response);
	if(response.username != null){
		document.getElementById("user").innerHTML = "Welcome: "+response.username;
	} else {
		window.location = "http://localhost:8080/Reimbursement/login";
	}

	//sendGet(("http://localhost:8080/Reimbursement/api/employeeslist ), populate2);

//	function populate2(xhr){
//		employees = JSON.parse(xhr.response)
//		let table = document.getElementById("EmpTab");
//		for (e in employees){
//			let nextRow = document.createElement("tr");
//			nextRow.innerHTML = `<td>${employees[e].id}</td>
//				<td>${employees[e].first}</td><td>${employees[e].last}</td>
//				<td>${employees[e].username}</td><td>${employees[e].password}</td>`;
//			table.appendChild(nextRow);
//		}	
//	}
	
	//sendGet("http://localhost:8080/Reimbursement/api/reimbursementslist", populate3);

//	function populate3(xhr){
//		reims = JSON.parse(xhr.response)
//		 let table = document.getElementById("ReimsTab");
//		for (r in reims){
//			let nextRow = document.createElement("tr");
//			nextRow.innerHTML = `<td>${reims[r].reim_id}</td>
//			<td>${reims[r].reim_name}</td><td>${reims[r].requester_Id}</td>
//			<td>${reims[r].amount}</td><td>${reims[r].reimStatus}</td><td>${reims[r].resolvedId}</td>`;
//			table.appendChild(nextRow);
//		}
//		
//	}
}