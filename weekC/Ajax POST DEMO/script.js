const getUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/books/all";

const postUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/books";

function makeAjaxGet(url, cb) {
    let XHR = new XMLHttpRequest();
    XHR.onreadystatechange = function () {
        if (XHR.readyState == 4 && XHR.status == 200) {
            cb(this);
        }
    }
    XHR.open("GET", url, true);
    XHR.send();
}

function printResponse(xhr) {
    let jsonResponse = xhr.response;
    let books = JSON.parse(jsonResponse);
    console.log(books);
}

makeAjaxGet(getUrl, printResponse);

function makeAjaxPost(url, cb, newBookObject) {
    let XHR2 = new XMLHttpRequest();
    XHR2.onreadystatechange = function () {
        if (XHR2.readyState == 4 && XHR2.status == 201) {
            cb(this);
        }
    }
    XHR2.open("POST", url);
    XHR2.setRequestHeader('Content-type','application/json');
    let jsonBook = JSON.stringify(newBookObject);
    XHR2.send(jsonBook);
}

function printResponse2(xhrObj) {
    console.log(xhrObj.response);
}

let newBook = {
    title: "Ice and Fire",
    author: "G.R.R.M",
    publishYear: 1996
};

// makeAjaxPost(postUrl, printResponse2, newBook);