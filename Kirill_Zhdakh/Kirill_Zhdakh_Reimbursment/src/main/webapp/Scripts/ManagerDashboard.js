function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}


sendAjaxGet("http://localhost:8080/PEAKReimbursment/session", checkLogin);


function getPendingTickets()
{
	sendAjaxGet("http://localhost:8080/PEAKReimbursment/pendingtickets", createPendingTicketTable);
}

function getAcceptedTickets()
{
	sendAjaxGet("http://localhost:8080/PEAKReimbursment/acceptedtickets", createAcceptedTicketTable);
}

function getDeclinedTickets()
{
	sendAjaxGet("http://localhost:8080/PEAKReimbursment/declinedtickets", createDeclinedTicketTable);
}

function createPendingTicketTable(xhr)
{
	let response = JSON.parse(xhr.response);
	let table = "<thead>"+
				"<tr>"+
				"<th scope=\"col\">"+"Sender"+"</th>"+
				"<th scope=\"col\">"+"Title"+"</th>"+
				"<th scope=\"col\">"+"Description"+"</th>"+
				"<th scope=\"col\">"+"Amount"+"</th>"+
				"<th scope=\"col\">"+"Options"+"</th>"+
				"</tr>"+
				"</thead>"+
				"<tbody>";
	for(let i = 0; i < response.length; ++i)
	{
		table += "<tr>"+
		"<td>"+response[i].ticketOpener.firstName +" "+response[i].ticketOpener.lastName+"</td>"+
		"<td>"+response[i].ticketOpener.title+"</td>"+
		"<td>"+response[i].name+"</td>"+
		"<td>"+"$"+response[i].amount+"</td>"+
		"<td>"+"<div class=\"btn-group btn-group-toggle\" data-toggle=\"buttons\">"+ 
			   "<label class=\"btn btn-outline-success btn-sm\" style=\"margin-right: 10px;\">"+ 
			   "<input type=\"radio\" name=\"pendingoptions\" autocomplete=\"off\">Accept"+
			   "</label>"+
			   "<label class=\"btn btn-outline-danger btn-sm\">"+ 
			   "<input type=\"radio\" name=\"pendingoptions\" autocomplete=\"off\">Deny"+
			   "</label></div></td></tr>";
	}
	table += "</tbody>";
	document.getElementById("ptTable").innerHTML = table;
}

function createAcceptedTicketTable(xhr)
{
	let response = JSON.parse(xhr.response);
	let table = "<thead>" +
				"<tr>" +
				"<th scope=\"col\">"+"Sender"+"</th>"+
				"<th scope=\"col\">"+"Title"+"</th>"+
				"<th scope=\"col\">"+"Description"+"</th>"+
				"<th scope=\"col\">"+"Amount"+"</th>"+
				"</tr>"+
				"</thead>"+
				"<tbody>";
	for(let i = 0; i < response.length; ++i)
	{
		table += "<tr>"+
		"<td>"+response[i].ticketOpener.firstName +" "+response[i].ticketOpener.lastName+"</td>"+
		"<td>"+response[i].ticketOpener.title+"</td>"+
		"<td>"+response[i].name+"</td>"+
		"<td>"+"$"+response[i].amount+"</td></tr>";
	}
	table += "</tbody>";
	document.getElementById("atTable").innerHTML = table;
}

function createDeclinedTicketTable(xhr)
{
	let response = JSON.parse(xhr.response);
	let table = "<thead>" +
				"<tr>" +
				"<th scope=\"col\">"+"Sender"+"</th>"+
				"<th scope=\"col\">"+"Title"+"</th>"+
				"<th scope=\"col\">"+"Description"+"</th>"+
				"<th scope=\"col\">"+"Amount"+"</th>"+
				"</tr>"+
				"</thead>"+
				"<tbody>";
	for(let i = 0; i < response.length; ++i)
	{
		table += "<tr>"+
		"<td>"+response[i].ticketOpener.firstName +" "+response[i].ticketOpener.lastName+"</td>"+
		"<td>"+response[i].ticketOpener.title+"</td>"+
		"<td>"+response[i].name+"</td>"+
		"<td>"+"$"+response[i].amount+"</td><tr>";
	}
	table += "</tbody>";
	document.getElementById("dtTable").innerHTML = table;
}

function getEmployees()
{
	sendAjaxGet("http://localhost:8080/PEAKReimbursment/getemployees", createEmployeeTable);
}

function createEmployeeTable(xhr)
{
	let response = JSON.parse(xhr.response);
	let table = "<thead>" +
				"<tr>" +
				"<th scope=\"col\">"+"#"+"</th>"+
				"<th scope=\"col\">"+"Name"+"</th>"+
				"<th scope=\"col\">"+"Username"+"</th>"+
				"<th scope=\"col\">"+"Email"+"</th>"+
				"<th scope=\"col\">"+"Title"+"</th>"+
				"</tr>"+
				"</thead>"+
				"<tbody>";
	for(let i = 0; i < response.length; ++i)
	{
		table += "<tr>"+
		"<th scope=\"row\">"+(i + 1)+"</th>"+
		"<td>"+response[i].firstName+" "+response[i].lastName+"</td>"+
		"<td>"+response[i].username+"</td>"+
		"<td>"+response[i].email+"</td>"+
		"<td>"+response[i].title+"</td></tr>";
	}
	table += "</tbody>";
	document.getElementById("employeeTable").innerHTML = table;
}

function checkLogin(xhr){
	let response = JSON.parse(xhr.response);
	if(response.username == null)
		window.location = "http://localhost:8080/PEAKReimbursment/login";
	else
	{
		document.getElementById("navbardropacc").innerHTML = response.firstname + " " + response.lastname + " ("+response.title+")";
		document.getElementById("profFirstName").innerHTML = "First Name: " + response.firstname;
		document.getElementById("profLastName").innerHTML = "Last Name: " + response.lastname;
		document.getElementById("profUsername").innerHTML = "Username: " + response.username;
		document.getElementById("profEmail").innerHTML = "Email: " + response.email;
		document.getElementById("profPosition").innerHTML = "Position: " + response.title;
	}
}

function submit(id)
{
	document.getElementById(id).reset();
}

function validateRegisterForm(event)
{
    event.preventDefault();
    if(document.registerForm.firstname.value=="")
    {
      document.getElementById("registererror").innerHTML = "Please provide a first name";
      return false;
    }
    else if(!document.registerForm.firstname.value.match(/^[A-Za-z]{2,}$/))
    {
      document.getElementById("registererror").innerHTML = "Invalid first name";
      return false;
    }
    else if(document.registerForm.lastname.value=="")
    {
      document.getElementById("registererror").innerHTML = "Please provide a last name";
      return false;
    }
    else if(!document.registerForm.lastname.value.match(/^[A-Za-z]{2,}$/))
    {
      document.getElementById("registererror").innerHTML = "Invalid last name";
      return false;
    }
    else if(document.registerForm.username.value=="")
    {
      document.getElementById("registererror").innerHTML = "Please provide a username";
      return false;
    }
    else if(document.registerForm.email.value=="")
    {
      document.getElementById("registererror").innerHTML = "Please provide an email";
      return false;
    }
    else if(document.registerForm.password.value=="")
    {
      document.getElementById("registererror").innerHTML = "Please provide an password";
      return false;
    }
    else if(document.registerForm.password2.value !== document.registerForm.password.value)
    {
      document.getElementById("registererror").innerHTML = "Password does not match";
      return false;
    }
    else {
        document.registerForm.submit();
        submit("registerForm");
    }
}

function validateProfileForm(event)
{
    event.preventDefault();
    if(document.profileForm.password.value=="")
    {
      document.getElementById("profileerror").innerHTML = "Please provide an password";
      return false;
    }
    else if(document.profileForm.password2.value !== document.profileForm.password.value)
    {
      document.getElementById("profileerror").innerHTML = "Password does not match";
      return false;
    }
    else {
        document.profileForm.submit();
        submit("profileForm");
    }
}

function validateTicketForm(event)
{
    event.preventDefault();
    if(document.ticketForm.descript.value=="")
    {
      document.getElementById("ticketerror").innerHTML = "Please provide a description";
      return false;
    }
    else if(document.ticketForm.amount.value=="")
    {
      document.getElementById("ticketerror").innerHTML = "Please provide an amount";
      return false;
    }
    else {
        document.ticketForm.submit();
        submit("ticketForm");
    }
}