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

function getPendingTickets()
{
	sendAjaxGet("http://localhost:8080/PEAKReimbursment/pendingticketsemp", createPendingTicketTable);
}

function getAcceptedTickets()
{
	sendAjaxGet("http://localhost:8080/PEAKReimbursment/acceptedticketsemp", createAcceptedTicketTable);
}

function getDeclinedTickets()
{
	sendAjaxGet("http://localhost:8080/PEAKReimbursment/declinedticketsemp", createDeclinedTicketTable);
}

function createPendingTicketTable(xhr)
{
	let response = JSON.parse(xhr.response);
	let table = "<thead>"+
				"<tr>"+
				"<th scope=\"col\">"+"Sender"+"</th>"+
				"<th scope=\"col\">"+"Title"+"</th>"+
				"<th scope=\"col\">"+"Description"+"</th>"+
				"<th scope=\"col\">"+"Amount"+"</th></tr>"+
				"</thead>"+
				"<tbody>";
	for(let i = 0; i < response.length; ++i)
	{
		table += "<tr>"+
		"<td hidden>"+response[i].ticketId+"</td>"+
		"<td>"+response[i].ticketOpener.firstName +" "+response[i].ticketOpener.lastName+"</td>"+
		"<td>"+response[i].ticketOpener.title+"</td>"+
		"<td>"+response[i].name+"</td>"+
		"<td>"+"$"+response[i].amount+"</td></tr>";
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
				"<th scope=\"col\">"+"Resolved By"+"</th>"+
				"</tr>"+
				"</thead>"+
				"<tbody>";
	for(let i = 0; i < response.length; ++i)
	{
		table += "<tr>"+
		"<td>"+response[i].ticketOpener.firstName +" "+response[i].ticketOpener.lastName+"</td>"+
		"<td>"+response[i].ticketOpener.title+"</td>"+
		"<td>"+response[i].name+"</td>"+
		"<td>"+"$"+response[i].amount+"</td>" +
		"<td>"+response[i].ticketResolver+"</td></tr>";
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
				"<th scope=\"col\">"+"Resolved By"+"</th>"+
				"</tr>"+
				"</thead>"+
				"<tbody>";
	for(let i = 0; i < response.length; ++i)
	{
		table += "<tr>"+
		"<td>"+response[i].ticketOpener.firstName +" "+response[i].ticketOpener.lastName+"</td>"+
		"<td>"+response[i].ticketOpener.title+"</td>"+
		"<td>"+response[i].name+"</td>"+
		"<td>"+"$"+response[i].amount+"</td>" +
		"<td>"+response[i].ticketResolver+"</td></tr>";
	}
	table += "</tbody>";
	document.getElementById("dtTable").innerHTML = table;
}

sendAjaxGet("http://localhost:8080/PEAKReimbursment/session", checkLogin);

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