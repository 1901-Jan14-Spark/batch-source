window.onload = function(){
	console.log("Hello profile");
	setTimeout(getInfo, 1500);
	document.getElementById("updateEmp").addEventListener("click", updateEmployee);

}

var infoUrl = "http://localhost:8080/EmployeePortal/session";


////Get Function // // 

function getInfo(){
console.log("Inside get Info.");
makeAjaxGet(infoUrl, printInfo);
}

function makeAjaxGet(url, callback) {
 let xhr = new XMLHttpRequest();
 xhr.open("GET", url);
 xhr.onreadystatechange = function() {
   if (xhr.readyState===4 && xhr.status>=200 && xhr.status<300 ) {
     callback(this);
   }else {
//     console.log(xhr.response);
   }
 }
 xhr.send();
}

function printInfo(info){
	let parsed = JSON.parse(info.response);
document.getElementById("email").innerHTML = parsed.email;
document.getElementById("fullname").innerHTML = parsed.fullname;
document.getElementById("title").innerHTML = parsed.title;

	
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
