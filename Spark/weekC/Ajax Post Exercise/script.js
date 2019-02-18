const getURL = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users/all";
const postURL = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users";


/////////  GET METHOD //////////////////

const ajaxGET = (url, cb) => {
    let XHR = new XMLHttpRequest();
    XHR.onreadystatechange = function () {
        if (XHR.readyState == 4 && XHR.status == 200) {
            cb(this);
        }
    }
    XHR.open("GET", url, true);
    XHR.send();
}

const printGetResponse = (xhr) => {
    let jsonRes = xhr.response;
    let users = JSON.parse(jsonRes);
    console.log(users);
}

ajaxGET(getURL, printGetResponse);

/////////  POST METHOD //////////////////

const ajaxPOST = (url, cb, newUserObject) => {
    let XHR = new XMLHttpRequest();
    XHR.onreadystatechange = function () {
        if (XHR.readyState == 4 && XHR.status == 201) {
            cb(this);
            
        } else {
            console.log(XHR.response);
        }
    }
    XHR.open("POST", url);
    XHR.setRequestHeader('Content-type','application/json');
    let jsonUser = JSON.stringify(newUserObject);
    XHR.send(jsonUser)
}

const printPostResponse = (xhrObj) => {
    console.log(xhrObj.response);
}

let newUser = {
    firstName: "Dat",
    lastName: "Tran",
    email: "dat@gmail.com",
    birthday: 1900/01/01,
    username: "dat07",
    password: "hello world",
    password2: "hello world"
}

// ajaxPOST(postURL, printPostResponse, newUser);