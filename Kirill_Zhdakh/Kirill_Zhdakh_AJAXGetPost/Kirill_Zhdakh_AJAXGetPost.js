const getUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users/all";
const postUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users";

function AjaxGET(url, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(this);
        }
    }
    xhr.send();
}

function printGETResponse(xhr) {
    let response = xhr.response;
    let data = JSON.parse(response);
    console.log(data);
}

function AjaxPOST(url, callback, obj) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 201)
            callback(this);
    }
    xhr.setRequestHeader("Content-Type", "application/json");
    let jsonObj = JSON.stringify(obj);
    xhr.send(jsonObj);
}

function printPOSTResponse(xhr) {
    console.log(xhr.response);
}

let infoObj = {
    firstName: "Kirill",
    lastName: "Zhdakh",
    email: "abcde@gmail.com",
    birthday: "1996-06-19",
    username: "Galgo",
    password: "hmmmm123",
    password2: "hmmmm123"
}

AjaxGET(getUrl, printGETResponse);
AjaxPOST(postUrl, printPOSTResponse, infoObj);
