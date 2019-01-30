const url = 'http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=';
const zipcode = document.getElementById("zipcode");
const zipcodeBtn = document.getElementById('submit');
const location2 = document.getElementById('location');
const icon = document.getElementById('icon');
const condition = document.getElementById('condition');
const temperature = document.getElementById('temp');

zipcodeBtn.addEventListener("click", function() {
    let XHR = new XMLHttpRequest();
    XHR.onreadystatechange = function () {
        if (XHR.readyState == 4 && XHR.status == 200) {
            let data = JSON.parse(XHR.responseText);
            // console.log(data);
            location2.innerHTML = "Location: " + data.location.name + ", " + data.location.region;
            icon.setAttribute("src", "https:" + data.current.condition.icon);
            condition.innerHTML = "Condition: " + data.current.condition.text;
            temperature.innerHTML = "Temperature: " + data.current.temp_f;
        }
    }
    XHR.open("GET", "http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=" + zipcode.value);
    XHR.send();

    // console.log(typeof(zipcode.value));
})