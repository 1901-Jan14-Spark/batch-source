url = "http://localhost:8080/reimbursement/employeeallReqs";
sendAjaxGet(url, display);
EInfoUrl = "http://localhost:8080/reimbursement/employeeInfoReqs";
sendAjaxGet(EInfoUrl,displayUserInfo);

document.getElementById("all").addEventListener("click", function() {
	url1 = "http://localhost:8080/reimbursement/employeeallReqs"
	sendAjaxGet(url1, display);
});

document.getElementById("pending").addEventListener("click", function() {
	url2 = "http://localhost:8080/reimbursement/employeependingReqs";
	sendAjaxGet(url2, display);
});

document.getElementById("approved").addEventListener("click", function() {
	url3 = "http://localhost:8080/reimbursement/employeeresolvedReqs";
	sendAjaxGet(url3, display);
});


document.getElementById("denied").addEventListener("click", function() {
	url4 = "http://localhost:8080/reimbursement/employeedeniededReqs";
	sendAjaxGet(url4, display);
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

function display(xhr) {
	let requestArr = JSON.parse(xhr.responseText).requests;
	let table = document.getElementById("requestTable");
	table.removeChild(document.getElementById("requestTableBody"));
	let newBody = document.createElement("tbody");
	newBody.setAttribute("id", "requestTableBody");
	table.appendChild(newBody);
	for (i in requestArr) {
		let newRow = document.createElement("tr");
		if (requestArr[i].manager) {
			man = `${requestArr[i].manager.firstname} ${requestArr[i].manager.lastname}`;
		} else {
			man = "N/A";
		}
		newRow.innerHTML = `<td>${requestArr[i].id}</td>
			<td>${requestArr[i].status}</td> 
			<td>${requestArr[i].amount}</td> 
			<td>${man}</td>`;
		newBody.appendChild(newRow);
	}
}
function displayUserInfo(xhr){
	let requestArr = JSON.parse(xhr.response)
	fullname = `${requestArr.Employee.firstname} ${requestArr.Employee.lastname}`;
	 document.getElementById("fullname").innerHTML = fullname;
	Email = `Email: ${requestArr.Employee.username}`;
	 document.getElementById("email").innerHTML = Email;
	Id = `ID: ${requestArr.Employee.id}`;
	 document.getElementById("id").innerHTML = Id;
}