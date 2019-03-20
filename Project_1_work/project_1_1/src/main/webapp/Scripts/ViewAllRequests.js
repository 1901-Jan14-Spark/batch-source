/**
 * 
 */

let allUrl = "http://localhost:8080/Project_1//AllEmpReqApi";
function sendjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this)
		}
	}
	xhr.open("GET",url);
	xhr.send();
}
function popMode(xhr){
	let requests = JSON.parse(xhr.response);
	console.log(requests);
	let employeeTable = document.getElementById("modalTable");
	for(request of requests){
		
	addRowA(request.employeeId,  request.dateSubmitted.substr(0,10),request.reason, request.amount);
	}
}


function addRowA(id, date, reason, amount){
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	
	
	cell1.innerHTML=id;
	cell2.innerHTML=date;
	cell3.innerHTML=reason;
	cell4.innerHTML=amount;
	
	document.getElementById("modalTable").appendChild(row);
	
		
	
	
	
	
//	document.getElementById("form").appendChild(idInput);
//	document.getElementById("form").appendChild(reasonInput);
//	document.getElementById("form").appendChild(amountInput);
//	document.getElementById("form").appendChild(dateInput);
//	document.getElementById("form").appendChild(statusInput);
//	
}

//document.getElementById("view").addEventListener("click", popRTable);
 sendjaxGet(allUrl, popMode);
