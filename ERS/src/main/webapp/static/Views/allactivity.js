let empsURL = "http://localhost:8080/ERS/api/employees";
let expsURL = "http://localhost:8080/ERS/api/reimbursements";

function ajaxRequest(method, url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open(method, url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
            console.log("You cllaalde it!");
			callback(this);
		}
    }
    console.log("You cllaalde it!2");
	xhr.send();
}

function ajaxPOST(url, reqObj){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.open("POST", url);
	xhr.onreadystatechange = function (){
		if(this.readyState === 4 && xhr.status === 201){
			console.log("....");
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	let reqJSON = JSON.stringify(reqObj);
	console.log(reqJSON);
	xhr.send(reqJSON);
}

window.onload = function(){
	ajaxRequest("GET", expsURL, displayExps);
}

function displayExps(xhr){
	let expsArr = JSON.parse(xhr.response);
	console.log(expsArr);
	for(exp of expsArr){
		if(exp.resolvedby != null)
		addExps(exp.id, exp.email, exp.price, exp.status, exp.resolvedby);
	}
}

function addExps(id, email, price, status, resolvedby){

	let row = document.createElement("tr");
	row.setAttribute("id", "reqrow"+id);
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");
	
	row.appendChild(cell1);
	row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
	row.appendChild(cell5);
	
	cell1.innerHTML=id;
	cell2.innerHTML=email;
	cell3.innerHTML=price;
	cell4.innerHTML=status;
	cell5.innerHTML=resolvedby;
	
	document.getElementById("allReimbursements").appendChild(row);	
}