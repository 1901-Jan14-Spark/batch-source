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