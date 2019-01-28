// Thomas Marsden

let google = document.getElementsByName("google");
let twitter = document.getElementsByName("twitter");
let slack = document.getElementsByName("slack");
let javadocs = document.getElementsByName("javadocs");

let planets = document.getElementById("planet");

// functions to execute when the document index.html is loaded
window.onload = function(){
    startUp();
    createLinks();
    removePlanet();
    alienText();
    printSpan();
}

// these are the functions that will be executed on different 'listeners'
function startUp(){
    planet[1].setAttribute("onclick", "alienText()");
    planet[2].setAttribute("onclick", "alienText()");
    document.getElementsByTagName("summary")[0].setAttribute("onmouseover", "openDetails()");
    document.getElementsByTagName("summary")[0].setAttribute("onmouseout", "closeDetails()");
    document.getElementById("form-sub").setAttribute("onclick", "submitForm()");
    document.getElementsByClassName("form-group")[0][8].checked = true;
    document.getElementById("earth_time").appendChild(createNode("span", "earth_time_span"));
    document.getElementById("earth_time_check").setAttribute("onclick", "displayEarthTime()");
    document.getElementsByTagName("h4")[0].setAttribute("onclick", "changeBackground()");
    createElements("button", "calculator-button", "", document.getElementsByClassName("float-right")[0]);
    document.getElementById("calculator-button").innerHTML = "=";
    document.getElementById("calculator-button").setAttribute("onclick", "calculate()");
}

// 1
function createLinks(){
    google[0].innerHTML = "Google";
    google[0].href = "https://www,google.com";

    twitter[0].innerHTML = "Twitter";
    twitter[0].href = "https://www.twitter.com";

    slack[0].innerHTML = "Slack";
    slack[0].href = "https://www.slack.com";

    javadocs[0].innerHTML = "Javadocs";
    javadocs[0].href = "https://www.javadocs.com";
}

// 2
function removePlanet(){
    planets[2].disabled = true;
}

// 3
document.getElementById("planet").addEventListener("change", alienText);
function alienText() {
    let selection = document.getElementById("planet").value;
    if(selection != "Earth") {
        let newNode = document.getElementsByTagName("p")[5];
        newNode.removeAttribute("hidden");
    } else {
        document.getElementsByTagName("p")[5].setAttribute("hidden", "none");
    }
}

// 4
function submitForm(){
    let form = document.getElementsByClassName("form-group")[0];
    let hobbyCounter = 0;
    let selectedGender = "";
    let hobbyArr = [];

    for(i = 0; i < form.length; i++){
        if(form[i].id == "firstname"){
        if(form[i].value == "" || form[i].value.length < 2){
            alert("Enter First Name Please");
        }
        } else if(form[i].id == "lastname"){
            if(form[i].value == "" || form[i].value.length < 2){
                alert("Please Enter Last Name");
            }
        } else if(form[i].id == "email"){
            if(form[i].value == ""){
                alert("Please Enter A Valid Email");
            }
        } else if(form[i].id == "phone"){
            if(form[i].value == ""){
                alert("Please Enter A Valid Phone Number");
            }
        } else if(form[i].id == "bday"){
            if(form[i].value == ""){
                alert("Enter A Valid Birthday");
            }
        } else if(form[i].name == "gender"){
            if(form[i].checked == true){
                selectedGender = form[i].value;
            }

        } else if(form[i].className == "activity"){
            if(form[i].checked == true){
                hobbyArr.push(form[i].value);
                counter += 1;
            }
        }
    }
    if(hobbyCounter == 0){
        alert("Please Pick 1 or More Hobbies");
    } addRow(form[0].value + " " + form[1].value, form[2].value, form[3].value, form[4].value, selectedGender, form[9].value, hobbyArr);
}

// adds elements in form to table
function addRow(name, email, phone, bday, gender, color, activity){
    var table = document.getElementsByClassName("table")[0];
    var row = table.insertRow(1);

    var cell0 = row.insertCell(0);
    var cell1 = row.insertCell(1);
    var cell2 = row.insertCell(2);
    var cell3 = row.insertCell(3);
    var cell4 = row.insertCell(4);
    var cell5 = row.insertCell(5);
    var cell6 = row.insertCell(6);

    cell0.innerHTML = name;
    cell1.innerHTML = email;
    cell2.innerHTML = phone;
    cell3.innerHTML = bday;
    cell4.innerHTML = color;
    cell5.innerHTML = gender;
    cell6.innerHTML = appendHobbies(activity);
}

// adds hobbies in an unordered list to the table
function appendHobbies(activity){
    var str = "<ul>"
        for(i = 0; i < activity.length; i++){
            str += "<li>" + activity[i] + "</li>";
        }
    str += "</ul>"
    return str;
}

// 5
function openDetails(){
    document.getElementsByTagName("details")[0].childNodes[3].hidden = false;
}
function closeDetails(){
    document.getElementsByTagName("details")[0].childNodes[3].hidden = true;
}

// 6
function printSpan(){
    var spans = $(document).find("span");
    console.log(spans);
}

// 7
function displayEarthTime(){
    var span = document.getElementById("earth_time_check");
    if(span.innerHTML == "Earth time"){
        var date = new Date();
        date.toString();
        span.innerHTML = date;
    } else{
        span.innerHTML = "Earth time";
    }
}

// 8

function changeBackground(){
    setTimeout(function(){
        document.body.style.backgroundColor = randomColor();
    }, 3000);
}
  
function randomColor() {
    var hexiCode = '0123456789ABCDEF';
    var rgb = '#';
    for (var i = 0; i < 6; i++) {
        rgb += hexiCode[Math.floor(Math.random() * 16)];
    }
    if(rgb == "#000000"){
        randomColor();
    } else {
      return rgb;
    }
}

// # 9
function calculate(){
    var total = 0;
    var num1 = Number(document.getElementById("n1").value);
    var num2 = Number(document.getElementById("n2").value);
    var option = document.getElementById("operation");
    for(i = 0; i < option.length; i++){
        if(option[i].innerHTML == "Add"){
            if(option[i].selected){
                total = num1 + num2;
            }
        } else if(option[i].innerHTML == "Subtract"){
            if(option[i].selected){
            total = num1 - num2;
            }
        } else if(option[i].innerHTML == "Divide"){
            if(option[i].selected){
            total = num1 / num2;
            }
        } else if(option[i].innerHTML == "Multiply"){
            if(option[i].selected){
            total = num1 * num2;
            }
        }
    }
    document.getElementById("result").innerHTML = total;
}

// used to create new elements such as the "=" button
function createElements(tag, id, style, referenceNode){
    let created = document.createElement(tag);
    created.setAttribute("id", id);
    created.setAttribute("style", style);
    insertAfter(created, referenceNode);
}

// creates new tag node
function createNode(tag, id){
    let created = document.createElement(tag);
    created.setAttribute("id", id);
    return created;
}

function insertAfter(newNode, referenceNode) {
    referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}

// 10
function walkTheDom(node, func) {
    var all = document.getElementsByTagName(node);
    for(i = 0; i < all.length - 1; i++){
        func(all[i]);
    }
}

function nodeText(node) {
    node.innerHTML = "hehe";
}