const postUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users";

function makeAjaxPost(url, callback, newPersonObject){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.onreadystatechange = function(){
        if(this.readystate ===4 && this.status === 201){
            callback(this); //this is on xhr
        }
    }
    xhr.setRequestHeader("Content-Type", "application/json");
    let jsonPerson = JSON.stringify(newPersonObject);
    xhr.send(jsonPerson);
}

function printResponse(xhrObj){
    console.log(xhrObj.response);
}

let newPerson ={
    firstName: "Daniel",
    lastName: "Bogar",
    email: "djbogar@outlook.com",
    birthday: "1994-02-15",
    username: "djbogar",
    password: "somepassword",
    password2: "somepassword"
}

makeAjaxPost(postUrl, printResponse, newPerson);