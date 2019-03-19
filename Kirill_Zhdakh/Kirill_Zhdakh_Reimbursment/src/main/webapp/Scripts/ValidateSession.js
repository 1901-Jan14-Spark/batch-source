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
	}
}

function submit(id)
{
	document.getElementById("id").reset();
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