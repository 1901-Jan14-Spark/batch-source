/**
 * 
 */
let meUrl = "http://localhost:8080/Project_1//ManagersEmployee";

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

function popMInfo(xhr){
	let managerInfo = JSON.parse(xhr.response);
	console.log(managerInfo);
	let employeeTable = document.getElementById("Employees");
	for(employee of managerInfo){
		addRow(employee.firstName, employee.employeeId);
		
	}
}
function addRow(name, id){
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	
	//let opt = document.createElement("option");
	

	
	row.appendChild(cell1);
	row.appendChild(cell2);
	cell1.innerHTML=name;
	cell2.innerHTML=id;
	document.getElementById("Employees").appendChild(row);
	
}



sendjaxGet(meUrl, popMInfo);