let allUsers = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users/all";
let addUser = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users ";

window.onload = function(){
  openUsers();
  postUser();
}

function openUsers(){
    sendAjaxGet(allUsers, displayUsers);
}

function postUser(){
  let newUser = createUser("J", "Shim", "shimjay1@gmail.com", "1995-08-21", "myUsername", "hunter123", "hunter123");
  sendAjaxPost(addUser, doNothing, newUser);
}

function sendAjaxGet(url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url);

    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            callback(this);
        } else if (this.status == 400){
            displayError();
        }
    }

    xhr.send();
}

function sendAjaxPost(url, callback, newUser){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);

    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 201){
            callback(this);
        }else {
          console.log(xhr.response);
        }
    }
    xhr.setRequestHeader("content-type", "application/json");
    let jsonData = JSON.stringify(newUser);

    xhr.send(jsonData);
}

function displayUsers(xhr){
    let users = JSON.parse(xhr.response);
    console.log(users);
}

function createUser(first, last, em, bday, user, pass, pass2){
  var user = {
    firstName: first,
    lastName: last,
    email: em,
    birthday: bday,
    username: user,
    password: pass,
    password2: pass2
  };

  return user;
}

function doNothing(){
  console.log("Nothing was done");
}
