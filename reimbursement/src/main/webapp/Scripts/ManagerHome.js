
let url = "http://localhost:8080/reimbursement/AllReqsServlet";
sendAjaxGet(url, displayRequests);
let url2 = "http://localhost:8080/reimbursement/getemployee";
sendAjaxGet(url2, displayEmployee);
let EInfoUrl = "http://localhost:8080/reimbursement/ManagerInfoServlet";
sendAjaxGet(EInfoUrl,displayUserInfo);

document.getElementById("all").addEventListener("click", function() {
	url1 = "http://localhost:8080/reimbursement/AllReqsServlet"
	sendAjaxGet(url1, displayRequests);
});

document.getElementById("pending").addEventListener("click", function() {
	url2 = "http://localhost:8080/reimbursement/AllPendingReqs";
	sendAjaxGet(url2, displayRequests);
});

document.getElementById("approved").addEventListener("click", function() {
	url3 = "http://localhost:8080/reimbursement/AllApprovedReqs";
	sendAjaxGet(url3, displayRequests);
});


document.getElementById("denied").addEventListener("click", function() {
	url4 = "http://localhost:8080/reimbursement/AllDeniedReqs";
	sendAjaxGet(url4, displayRequests);
});


function sendAjaxGet(url, func) {
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState==4 && this.status==200) {
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}
function resetReqTable(){
	let table1 = document.getElementById("requestTableBody")
	let table = Array.from(table1.childNodes)
	for(i=0;i<table.length;i++){
			table[i].removeAttribute("hidden");
	}
}
function searchReqTable(){
	resetReqTable();
	let un = document.getElementById("searchUser").value
	let table1 = document.getElementById("requestTableBody")
	let table = Array.from(table1.childNodes)
	let rowID = "rtb" + un;
	for(i=0;i<table.length;i++){
		if(table[i].id != rowID)
			table[i].setAttribute("hidden",true);
	}
}

function displayRequests(xhr) {
	let requestArr = JSON.parse(xhr.responseText).requests;
	let table = document.getElementById("requestTable");
	table.removeChild(document.getElementById("requestTableBody"));
	let newBody = document.createElement("tbody");
	newBody.setAttribute("id", "requestTableBody");
	table.appendChild(newBody);
	for (i in requestArr) {
		let newRow = document.createElement("tr");
		if (requestArr[i].manager || requestArr[i].employee ) {
			if(requestArr[i].manager){
			man = `${requestArr[i].manager.firstname} ${requestArr[i].manager.lastname}`;}
			else{
				man = 'N/A';
			    }
			emp = `${requestArr[i].employee.firstname} ${requestArr[i].employee.lastname}`;
		}

		newRow.innerHTML = 
			`<td>${requestArr[i].id}</td>
			<td>${requestArr[i].status}</td> 
			<td>${requestArr[i].amount}</td> 
			<td>${emp}</td>
			<td>${man}</td>`;
		newRow.setAttribute("id","rtb"+requestArr[i].employee.username);
		newBody.appendChild(newRow);
		
	}
}

function displayEmployee(xhr) {
	employeeArr = JSON.parse(xhr.response).employees;
	let table = document.getElementById("employeestable");
	let newBody = document.createElement("tbody");
	newBody.setAttribute("id", "employeesTableBody");
	table.appendChild(newBody);
	for (i in employeeArr) {
		let newRow = document.createElement("tr");

		newRow.innerHTML = 
			`<td>${employeeArr[i].id}</td>
			<td>${employeeArr[i].firstname}</td> 
			<td>${employeeArr[i].lastname}</td>
			<td>${employeeArr[i].username}</td>`; 
		newBody.appendChild(newRow);
	}
}

function displayUserInfo(xhr){
	let requestArr = JSON.parse(xhr.response)
	fullname = `${requestArr.manager.firstname} ${requestArr.manager.lastname}`;
	 document.getElementById("fullname").innerHTML = fullname;
	Email = `Email: ${requestArr.manager.username}`;
	 document.getElementById("email").innerHTML = Email;
	Id = `ID: ${requestArr.manager.id}`;
	 document.getElementById("id").innerHTML = Id;
}
