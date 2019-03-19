/**
 * 
 */
let burl = "http://localhost:8080/Project_1//EmpApi";

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("Onready")
		if(this.readyState===4 && this.status===200){
			callback(this)
		}
	}
	xhr.open("GET",url);
	xhr.send();
}

function popInfo(xhr){
	let employee = JSON.parse(xhr.response);
	console.log(employee);
	
	 document.getElementById("employeeName").innerHTML = employee.firstName;
	 document.getElementById("MangerID").innerHTML = employee.managerId;
	 document.getElementById("employeeId").innerHTML = employee.employeeId;
	 
	
	
}

sendAjaxGet(burl,popInfo);