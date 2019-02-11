const getUrl = "http://registrationapp-env.jwspm2r7ae.us-east-1.elasticbeanstalk.com:8080/users/all";

function makeAjaxGet(url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            callback(this);//this is xhr in xhr.onreadystatechange, passing in the entire xhr object
        }

    }
    xhr.send();
}

function printResponse(xhrObj){
    let jsonResponse = xhrObj.response;
    let people = JSON.parse(jsonResponse);
    console.log(people);
}

makeAjaxGet(getUrl, printResponse);