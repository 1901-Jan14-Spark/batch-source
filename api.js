let baseUrl = "http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=";

document.getElementById("submitButton").addEventListener("click", searchWeather);

function searchWeather(){
    let input = document.getElementById("zipcode").value;
    // console.log(input);
    sendAjaxGet(baseUrl+input, displayWeather);
}

// this function is going to perform all of the steps of AJAX
function sendAjaxGet(url, callback){

    //use constructor to make an XHR object
    let xhr = new XMLHttpRequest();

    xhr.open("GET", url);

    xhr.onreadystatechange = function(){
        if(this.readyState===4 && this.status===200){
            callback(this);
        } else if (this.status== 400){
            displayError();
        }
    }

    xhr.send();
}

// this is the function we're using as a callback function ihn our sendAjaxGet function in order to process our response 
function displayWeather(xhr){
    document.getElementById("error").innerHTML = "";
    //console.log(xhr.response);

    let weather = JSON.parse(xhr.response);
    // console.log(weather);

    document.getElementById("location").innerHTML = `Weather for ${weather.location.name}, ${weather.location.region}`;

    document.getElementById("icon").setAttribute("src","http:"+weather.current.condition.icon);

    document.getElementById("temp").innerHTML = `${weather.current.temp_f} F (feels like ${weather.current.feelslike_f} F)`;

    document.getElementById("condition").innerHTML = weather.current.condition.text;


}

function displayError(){
    document.getElementById("error").innerHTML = "Invalid Zipcode";
} 