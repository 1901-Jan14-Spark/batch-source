/**
 * 
 */
window.onload = function(){
	document.getElementById("createEmp").addEventListener("click", createEmployee);
//	document.getElementById("updateEmp").addEventListener("click", updateEmployee);
}

var URL2 = "http://localhost:8080/EmployeePortal/api/employees";


$(document).ready( function () {
    $('#table_id').DataTable({
    	ajax: {
    		url: 'http://localhost:8080/EmployeePortal/api/reimbursements', //where to find the data
    		dataSrc:''
    	},
    	columns:[
    		{data: "rId"},
    		{data: "rAmount"},
    		{data: "rStatus"},
    		{data: "description"},
    		{data: "rStatusChange"},
    		{data: "employee_id"}
    	]
    });
    
    $('#table_id2').DataTable({
    	ajax: {
    		url: 'http://localhost:8080/EmployeePortal/api/employees', //where to find the data
    		dataSrc:''
    	},
    	columns:[
    		{data: "eId"},
    		{data: "fname"},
    		{data: "lname"},
    		{data: "email"},
    		{data: "mId"}
    	]
    });
} );
///////////////////////////////
//////EMPLOYEE AJAX////////
////////////////////////////////

function createEmployee() {
console.log("inside create employee");
let firstname = document.getElementById("cfname").value;
let lastname = document.getElementById("clname").value;
let newtitle = document.getElementById("ctitle").value;
let newemail = document.getElementById("cemail").value;
let pass = document.getElementById("cpassword").value;
let manager = document.getElementById("cmanager").value;



let employee = 
   {
      fname: firstname,
      lname: lastname,
      title: newtitle,
      email: newemail,
      password:pass,
      mId: manager
      
    };

console.log(employee);
makeCAjaxPost(URL2, printFlightResponse, employee);
}

function printFlightResponse(xhrOBJ) {
console.log(xhrOBJ.response);
}

//// Post Function // // 

function makeCAjaxPost(url, callback, newFlightObject) {
let xhr = new XMLHttpRequest();
xhr.open("POST", url);
xhr.onreadystatechange = function() {
if (xhr.readystate===4&&xhr.status===201) {
callback(this);
}else {
//console.log(xhr.response);
}
}
xhr.setRequestHeader("Content-Type", "application/json");
let flightCreated = JSON.stringify(newFlightObject);
console.log(JSON.stringify(newFlightObject));
xhr.send(flightCreated);
}  


function updateEmployee() {
	console.log("inside update employee");
	let firstname = document.getElementById("ufname").value;
	let lastname = document.getElementById("ulname").value;
	let newemail = document.getElementById("uemail").value;
	let pass = document.getElementById("upassword").value;



	let employee = 
	   {
	      fname: firstname,
	      lname: lastname,
	      email: newemail,
	      password:pass,
	      
	    };

	console.log(employee);
	makeUAjaxPost(URL2, printFlightResponse, employee);
	}

	function printFlightResponse(xhrOBJ) {
	console.log(xhrOBJ.response);
	}

	//// Post Function // // 

	function makeUAjaxPost(url, callback, newFlightObject) {
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url);
	xhr.onreadystatechange = function() {
	if (xhr.readystate===4&&xhr.status===201) {
	callback(this);
	}else {
	//console.log(xhr.response);
	}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	let flightCreated = JSON.stringify(newFlightObject);
	console.log(JSON.stringify(newFlightObject));
	xhr.send(flightCreated);
	}  

///////////////////////////////
//////END OF EMPLOYEE AJAX////////
////////////////////////////////
