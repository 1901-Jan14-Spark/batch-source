/**
 * 
 */
window.onload=function(){
	document.getElementById("updateEmp").addEventListener("click", updateEmployee);
}

var URL2 = "http://localhost:8080/EmployeePortal/api/employees";

///////////////////////////////
//////EMPLOYEE AJAX////////
////////////////////////////////

function printFlightResponse(xhrOBJ) {
	console.log(xhrOBJ.response);
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
