function sendAjaxGet(url, func){
	console.log("getting");
	let xhr = new XMLHttpRequest() ;
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			func(this);
		}
	}
	
	xhr.send();
}
document.getElementById("ResolvedB").addEventListener("click", sendAjaxGet("http://localhost:8080/Project-1/api/resolve", fillResolve));
//fillResolve.stopImmediatePropagation();
document.getElementById("tbutton").addEventListener("click", sendAjaxGet("http://localhost:8080/Project-1/api/table", fillTable) );
document.getElementById("aButton").addEventListener("click", sendAjaxGet("http://localhost:8080/Project-1/api/active", fillActive) );
let xbutton=document.getElementById("xButton")
xbutton.addEventListener("click", sendAjaxGet("http://localhost:8080/Project-1/api/active", ReimById) );
console.log("rrrrrrrrrrrrrrrrrrr");

function fillTable(xhr){
	let employees = JSON.parse(xhr.response);
//	console.log(employees);
	console.log("table is filled")
	let table = document.getElementById("table");
	
	for(i in employees){
		let nextRow = document.createElement("tr");
		let id = "n/a";
		let name = "n/a";
		let birthday = "n/a";
		let salary = "n/a";
		let position = "n/a";
		let reportsto = "n/a";
		let hireDate = "n/a";
		if(employees[i].department){
			id = employees[i].id;
			name = employees[i].name;
			birthday = employees[i].birthday;
			salary = employees[i].salary;
			position = employees[i].position;
			reportsto = employees[i].reportsto;
			hireDate = employees[i].hireDate;
		}
		
		nextRow.innerHTML = `<td>${employees[i].id}</td><td>${employees[i].name}</td><td>${employees[i].birthday}</td><td>${employees[i].salary}</td><td>${employees[i].position}</td><td>${employees[i].reportsto}</td><td>${employees[i].hireDate}</td>`;
		
		table.appendChild(nextRow);
	}	
}
//Approve Get ----------------------------------------------------------------------------------------------------------
function fillActive(xhr){
	let requests = JSON.parse(xhr.response);
//	console.log(employees);
	
	let table = document.getElementById("ActiveT");
	
	for(i in requests){
		let nextRow = document.createElement("tr");
		let id = "n/a";
		let name = "n/a";
		let category = "n/a";
		let cost = "n/a";
		let merchant = "n/a";
		let purchaseDate = "n/a";
		
		
			id = requests[i].id;
			console.log(id);
			name = requests[i].empName;
			category = requests[i].category;
			cost = requests[i].cost;
			merchant = requests[i].merchant;
			purchaseDate = requests[i].purchaseDate;
			
			let select=document.getElementById("select");
			let option = document.createElement("option");
			option.innerHTML=id;
			select.append(option);
		
		nextRow.innerHTML = `<td>${id}</td><td>${name}</td><td>${category}</td><td>${cost}</td><td>${merchant}</td><td>${purchaseDate}</td>`;
		
		table.appendChild(nextRow);
	}	
}
// post---------------------------------------------------------------------------------------------------------
function sendAjaxPost(url, func, newUserObject){
	let xhr = new XMLHttpRequest() ;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			func(this);
		}
	}
	
	xhr.send(newUserObject);
}
let approve=document.getElementById("Approve");
approve.addEventListener("click",  doApproveFunction);
function doApproveFunction(){
	let ReimId=document.getElementById("select").value;
	console.log(ReimId);
	
	
	
	
	
	let NewRequest = {
	 "id": ReimId,
	 }
	console.log(NewRequest);
	
	let request=JSON.stringify(NewRequest)
	console.log(request);
   sendAjaxPost("http://localhost:8080/Project-1/api/approve", printResponse, request);
}

let deny=document.getElementById("Deny");
deny.addEventListener("click",  doDenyFunction);
function doDenyFunction(){
	let ReimId=document.getElementById("select").value;
	console.log(ReimId);
	
	
	
	
	
	let NewRequest = {
	 "id": ReimId,
	 }
	console.log(NewRequest);
	
	let request=JSON.stringify(NewRequest)
	console.log(request);
   sendAjaxPost("http://localhost:8080/Project-1/api/deny", printResponse, request);
}
function printResponse(xhrObj){
	  console.log(xhrObj.response);
	}
// Fill Resolved Table___________________________________________________________________________________
 
function fillResolve(xhr){
	let requests = JSON.parse(xhr.response);
	console.log(" Resolve Table filled");
	
	let table = document.getElementById("ResolvedT");
	
	for(i in requests){
		let nextRow = document.createElement("tr");
		let id = "n/a";
		let name = "n/a";
		let category = "n/a";
		let cost = "n/a";
		let merchant = "n/a";
		let purchaseDate = "n/a";
		let app_by="n/a";
		let deny_by="n/a";
		
			id = requests[i].id;
			console.log(id);
			name = requests[i].empName;
			category = requests[i].category;
			cost = requests[i].cost;
			merchant = requests[i].merchant;
			purchaseDate = requests[i].purchaseDate;
			app_by=requests[i].approvedBy;
			den_by=requests[i].deniedBy;
			
		
			
		
		nextRow.innerHTML = `<td>${id}</td><td>${name}</td><td>${category}</td><td>${cost}</td><td>${merchant}</td><td>${purchaseDate}</td><td>${app_by}</td><td>${den_by}</td>`;
		
		table.appendChild(nextRow);
		
	}	
}
// ReimById-----------------------------------------------------------------------
function ReimById(xhr){
	let requests = JSON.parse(xhr.response);
	console.log("Table filled");
	let Empl = document.getElementById("selectReimId").value;
	console.log(Empl)
	let table = document.getElementById("ReimByIDT");
	
	for(i in requests){
		
		let nextRow = document.createElement("tr");
		let id = "n/a";
		let name = "n/a";
		let category = "n/a";
		let cost = "n/a";
		let merchant = "n/a";
		let purchaseDate = "n/a";
		let app_by="n/a";
		let deny_by="n/a";
		if(Empl==requests[i].empName){
			id = requests[i].id;
			console.log(id);
			name = requests[i].empName;
			category = requests[i].category;
			cost = requests[i].cost;
			merchant = requests[i].merchant;
			purchaseDate = requests[i].purchaseDate;
			app_by=requests[i].approvedBy;
			den_by=requests[i].deniedBy;
			
		
			
		
		nextRow.innerHTML = `<td>${id}</td><td>${name}</td><td>${category}</td><td>${cost}</td><td>${merchant}</td><td>${purchaseDate}</td><td>${app_by}</td><td>${den_by}</td>`;
		
		table.appendChild(nextRow);
		}
	}	
}
