function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() ;
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			func(this);
		}
	}
	
	xhr.send();
}
  
 let ActiveB=document.getElementById("ActiveB");
 ActiveB.addEventListener("click", sendAjaxGet("http://localhost:8080/Project-1/api/viewActive", getActive)) ;
 let empInfo=document.getElementById("empInfo");
 empInfo.addEventListener("click", sendAjaxGet("http://localhost:8080/Project-1/api/session", listInfo)) ;
 let ResolvedB=document.getElementById("ResolvedB");
 ResolvedB.addEventListener("click", sendAjaxGet("http://localhost:8080/Project-1/api/viewResolved", getResolved)) ;
function listInfo(xhr){
	let session = JSON.parse(xhr.response);
	let id = "n/a";
	let name = "n/a";
	let birthday = "n/a";
	let salary = "n/a";
	let position = "n/a";
	let reportsto = "n/a";
	let hireDate = "n/a";
	
		id = session.id;
		name = session.name;
		birthday = session.birthday;
		salary = session.salary;
		position = session.position;
		reportsto = session.reportsto;
		hireDate = session.hireDate;
//	console.log(employees);
		let IDinfo=document.getElementById("IDInfo");
		IDinfo.innerHTML=`ID: ${id}`;
		let Nameinfo=document.getElementById("NameInfo");
		Nameinfo.innerHTML=`Name: ${name}`;
		let Depinfo=document.getElementById("DepInfo");
		Depinfo.innerHTML=`Department: ${position}`;
		let HDinfo=document.getElementById("HDInfo");
		HDinfo.innerHTML=`Start Date: ${hireDate}`;
		let Salinfo=document.getElementById("SalInfo");
		Salinfo.innerHTML=`Salary: ${salary}`;
		let BDinfo=document.getElementById("BDInfo");
		BDinfo.innerHTML=`Date of Birth: ${birthday}`;
	
}
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
let submit=document.getElementById("submit");
submit.addEventListener("click",  doFunction);
function doFunction(){
	let cat=document.getElementById("category").value;
	let cost=document.getElementById("cost").value;
	let merch=document.getElementById("merchant").value;
	let date=document.getElementById("date").value;
	
	
	
	
	
	let NewRequest = {
	 "category": cat,
	 "cost": cost,
	 "date":date,
	 "merchant":merch,
	}
	console.log(NewRequest);
	
	let request=JSON.stringify(NewRequest)
	console.log(request);
   sendAjaxPost("http://localhost:8080/Project-1/api/createReimbursement", printResponse, request);
}
function printResponse(xhrObj){
	  console.log(xhrObj.response);
	}

//Active Reimbursements------------------------------------------------------------------------
function getActive(xhr){
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
		let app_by="n/a";
		let deny_by="n/a";
		
			id = requests[i].id;
			console.log(id);
			name = requests[i].empName;
			category = requests[i].category;
			cost = requests[i].cost;
			merchant = requests[i].merchant;
			purchaseDate = requests[i].purchaseDate;
			app_by=requests[i].aprovedBy;
			den_by=requests[i].deniedBy;
			
		
			
		
		nextRow.innerHTML = `<td>${id}</td><td>${name}</td><td>${category}</td><td>${cost}</td><td>${merchant}</td><td>${purchaseDate}</td><td>${app_by}</td><td>${den_by}</td>`;
		
		table.appendChild(nextRow);
	}	
}
function getResolved(xhr){
	let requests = JSON.parse(xhr.response);
//	console.log(employees);
	
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
			app_by=requests[i].aprovedBy;
			den_by=requests[i].deniedBy;
			
		
			
		
		nextRow.innerHTML = `<td>${id}</td><td>${name}</td><td>${category}</td><td>${cost}</td><td>${merchant}</td><td>${purchaseDate}</td><td>${app_by}</td><td>${den_by}</td>`;
		
		table.appendChild(nextRow);
	}	
}