const getUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/books/all";

function makeAjaxGet(url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET",url,false);
    xhr.onreadystatechange = function(){
        if(xhr.readyState===4&&xhr.status===200){
            return callback(this); //passing in the entire xhr object
        }
    }
    xhr.send();
    return xhr.onreadystatechange();
}

function printResponse(xhrObj){
    let jsonResponse = xhrObj.response;
    let books = JSON.parse(jsonResponse);
    console.log(books);
    for(b of books){
        if(b.title === "Test Book"){
            console.log(b);
            return b;
        }
    }
}

let test = makeAjaxGet(getUrl, printResponse);
console.log(test);

