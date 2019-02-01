let getURL ="http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users";

function postSend(getURL, callback, newUser){
    let xhr= new XMLHttpRequest();
        console.log("1");
    xhr.open("POST", getURL);
    console.log("2");
    xhr.onreadystatechange= function(){
        console.log("3");
        if(xhr.state === 4 && xhr.status === 201){
            console.log("4");
            callback(this);
            console.log("5");
        }
        else{
            console.log(xhr.response);
        }
    }
    xhr.setRequestHeader("Content-Type","application/json");
    let jsonNewUser= JSON.stringify(newUser);
    xhr.send(jsonNewUser);
}

let newUser ={
    firstName: "Javier",
    lastName: "Rodriguez",
    email: "August112641@gmail.com",
    birthday: "1995-20-08",
    username: "JavRo",
    password: "pass1234",
    password2: "pass1234"
}

function response(obj){
console.log(obj.response);
}

postSend(getURL, response, newUser);