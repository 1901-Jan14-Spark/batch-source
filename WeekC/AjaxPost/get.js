const getUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/books/all";

function makeAjaxGet(url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET",url,true);
    xhr.onreadystatechange = function(){
        if(xhr.readyState===4&&xhr.status===200){
            callback(this); //passing in the entire xhr object
        }
    }
    xhr.send();
}

function printResponse(xhrObj){
    let jsonResponse = xhrObj.response;
    let books = JSON.parse(jsonResponse);
    console.log(books);
}

makeAjaxGet(getUrl, printResponse);