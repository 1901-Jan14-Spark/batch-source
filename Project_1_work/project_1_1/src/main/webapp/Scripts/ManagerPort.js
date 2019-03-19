/**
 * 
 */
let MPurl = "http://localhost:8080/Project_1//EmpReqApi";
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
function popRTable(xhr){
	let requests = JSON.parse(xhr.response);
	console.log(requests);
	let employeeTable = document.getElementById("view");
	for(request of requests){
		let aButtonId = "A" + request.employeeId+request.reason+request.amount;
		let dButtonId = "D" + request.employeeId+request.reason+request.amount;
		let bo = request.approved;
		let req = "pending";
		if (bo === true){
			req = "approved"}
			else{
				req = "Pending";
			}
		addRowP(request.employeeId,  request.dateSubmitted.substr(0,10),request.reason, request.amount, req, aButtonId, dButtonId);
	}
}

function addRowP(id, date, amount, reason, status, aBId, dBid){
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");
	let buttonA = document.createElement("button");
	let buttonD = document.createElement("button");
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);
	row.appendChild(buttonA);
	row.appendChild(buttonD);
	cell1.innerHTML=id;
	cell2.innerHTML=date;
	cell3.innerHTML=amount;
	cell4.innerHTML=reason;
	cell5.innerHTML=status;
	buttonA.innerHTML="Approve";
	buttonA.name = aBId;
	buttonD.innerHTML ="Deny";
	buttonD.name = dBId;
	document.getElementById("view").appendChild(row);
	
}

//document.getElementById("view").addEventListener("click", popRTable);
 sendjaxGet(MPurl, popRTable);

