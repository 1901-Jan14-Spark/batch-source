/**
 * 
 * 
 */


document.getElementById("logout").addEventListener("click", function(){
	location.href = "Logout";
	console.log("Logout");
})


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
		let statusId = request.employeeId+request.reason+request.amount;
		let formId = "f"+request.employeeId+request.reason+request.amount;
		let bo = request.approved;
		let req = "Pending";
		if (bo == 1){
			req = "Approved"}
		else if(bo == 2){
			req = "Denied"
		}else{
			req = "Pending";
			}
		addRowP(request.employeeId,  request.dateSubmitted.substr(0,10),request.reason, request.amount, req, aButtonId, dButtonId, statusId, formId);
	}
}



function addRowP(id, date, reason, amount,  status, aBId, dBId, statusId, formId){
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");
	
	let opt = document.createElement("option");
	
	let buttonA = document.createElement("button");
	let buttonD = document.createElement("button");
	let buttonS = document.createElement("button");
	
	//let recordForm = document.createElement('FORM');
	let idInput = document.createElement("input");
	let reasonInput = document.createElement("input");
	let amountInput = document.createElement("input");
	let dateInput = document.createElement("input");
	let statusInput = document.createElement("input");
	
	opt.innerHTML = id;
	
	
	//recordForm.id = formId;
	idInput.value=id;
	reasonInput.value=reason;
	amountInput.value=amount;
	dateInput.value=date;
	statusInput.value=status;
	
	idInput.name="id";
	reasonInput.name="reason";
	amountInput.name="amount";
	dateInput.name="date";
	statusInput.name="status";
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);
	
	row.appendChild(buttonA);
	row.appendChild(buttonD);
	row.appendChild(buttonS);
	
	cell1.innerHTML=id;
	cell2.innerHTML=date;
	cell3.innerHTML=reason;
	cell4.innerHTML=amount;
	cell5.innerHTML=status;
	cell5.id = statusId;
	
	buttonA.innerHTML="Approve";
	buttonA.name = aBId;
	buttonA.addEventListener("click",function(statusId, formId){
		cell5.innerHTML="Approved";
		statusInput.value="Approved";
	});
	buttonD.innerHTML ="Deny";
	buttonD.name = dBId;
	buttonD.addEventListener("click",function(statusId, formId){
		cell5.innerHTML="Denied";
		statusInput.value="Denied";
		//document.getElementById(formId).appendChild(idInput);
	});
	buttonS.innerHTML = "Submit Changes";
	buttonS.addEventListener("click",function(){
		document.getElementById("form").appendChild(idInput);
		document.getElementById("form").appendChild(reasonInput);
		document.getElementById("form").appendChild(amountInput);
		document.getElementById("form").appendChild(dateInput);
		document.getElementById("form").appendChild(statusInput);
		document.getElementById("form").submit();
	})
	document.getElementById("view").appendChild(row);
	
	document.getElementById("emps").appendChild(opt);
	
	var sel = document.getElementById("emps");
	document.getElementById("emps").addEventListener("change",function(){
	
		var option = sel.options[sel.selectedIndex];
		console.log(option);
		
	})
	
	
	
//	document.getElementById("form").appendChild(idInput);
//	document.getElementById("form").appendChild(reasonInput);
//	document.getElementById("form").appendChild(amountInput);
//	document.getElementById("form").appendChild(dateInput);
//	document.getElementById("form").appendChild(statusInput);
//	
}

//document.getElementById("view").addEventListener("click", popRTable);
 sendjaxGet(MPurl, popRTable);

