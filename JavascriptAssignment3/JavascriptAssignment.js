//get links working
var link1 = document.getElementsByName("google")[0];
link1.href = "http://www.google.com";
link1.innerHTML = "Google";

var link2 = document.getElementsByName("twitter")[0];
link2.href ="http://www.twitter.com";
link2.innerHTML = "Twitter";

var link3 = document.getElementsByName("slack")[0];
link3.href="http://www.slack";
link3.innerHTML = "Slack";

var link4 = document.getElementsByName("javadocs")[0];
link4.href="https://www.oracle.com/technetwork/java/javase/documentation/javadoc-137458.html";
link4.innerHTML = "JavaDocs";

// remove
var removenode = document.getElementsByTagName("option")[2];
removenode.remove();

//function for alienText
document.getElementById("planet").addEventListener("change", alienText);

function alienText(){
    var selecttoggle = document.getElementById("planet").value;
    if (selecttoggle == 'Mars'){
    hidden1 = document.getElementsByTagName("p")[5];
    hidden1.removeAttribute("hidden");
    }
    else document.getElementsByTagName("p")[5].setAttribute("hidden", "none");
}

//adding to the table
function addRow(name, email, phone, bday, color, chosenGender, activity){

    let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    let cell7 = document.createElement("td");

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);

    cell1.innerHTML = name;
    cell2.innerHTML = email;
    cell3.innerHTML = phone;
    cell4.innerHTML = bday;
    cell5.innerHTML = color;
    cell6.innerHTML = chosenGender;
    cell7.innerHTML = activity;

    document.getElementsByClassName("table")[0].appendChild(row);
}

//add event for button
document.getElementById("form-sub").addEventListener("click", addNew);
document.getElementById("form-sub").addEventListener("click", resetError);

let errorCount = 0;

function resetError(){
    errorCount = 0;
}

function addNew(){
    let actArr = [];
    let chosenGender = "";
    let form = document.getElementsByClassName("form-group")[0];
    let name = document.getElementById("firstname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let bday = document.getElementById("bday").value;
    let color = document.getElementById("color").value;

    for (i = 0; i < form.length; i++) {
        if (form[i].id == "firstname"){
            if (form[i].value == "" || form[i].value.length < 2){
                errorCount += 1;
            }
        } else if (form[i].id == "lastname"){
            if (form[i].value == "" || form[i].value.length < 2) {
                errorCount += 1;
            }
        } else if (form[i].id == "email"){
            if (form[i].value == "" || !(email.endsWith("@gmail.com"))){
                errorCount += 1;
            } 
        } else if (form[i].id == "phone"){
            if (form[i].value == "" || (!phone.match(/^[0-9]+$/)) || phone.length != 10) {
                errorCount += 1;
            }
        } else if (form[i].id == "bday"){
            if (form[i].value == ""){
               errorCount += 1;
            }
        } else if (form[i].id == "color"){
            if (form[i].value == ""){
                errorCount += 1;
            }}

           else if (form[i].name == "gender"){
            if (form[i].checked == false){
                if(chosenGender == false){
                errorCount += 1;
            }}else if (form[i].checked){
                chosenGender = form[i].value;
            }
        }

        // I was not able to finish the validation for activity in time. I would have used another else if statement to check if the form[i] was checked == false and if so then add to the error count//
        else if (form[i].className == "activity"){
             if (form[i].checked){
                actArr.push(form[i].value);
                }
            } 
        }
    
    if (errorCount != 0){
        alert(`One of your fields is empty or is being input incorrectly! Please make sure your first name & last name are both greater than 2 letters. Please also ensure that your phone number is exactly 10 numbers (0-9) and your email must have @gmail.com at the end! We can only accept gmail e-mail addresses at this time. Thank you.`);
    }

    else if (errorCount == 0) {
        addRow(name, email, phone, bday, color, chosenGender, actArr)
    }
}



// opening the Details
document.getElementsByTagName("summary")[0].setAttribute("onmouseover", "openDetails()");
document.getElementsByTagName("summary")[0].setAttribute("onmouseout", "closeDetails()");

function openDetails(){
    document.getElementsByTagName("details")[0].childNodes[3].hidden = false;
}

function closeDetails(){
    document.getElementsByTagName("details")[0].childNodes[3].hidden = true;
}

//concatenates all spam elements

function concatSpan(){
    let spans = document.getElementsByTagName("span");
    let concatenated = "";
    for (i = 0; i < spans.length; i++){
    concatenated += spans[i].innerHTML;
}
console.log(concatenated);
}
concatSpan();

//earthtime function
document.getElementById("earth_time_check").addEventListener("click", showEarthTime);

function showEarthTime(){
    var span = document.getElementById("earth_time");
    if (document.getElementById("earth_time").innerHTML == "") {
        var date = new Date();
        date.toString();
        span.innerHTML = date;
    }
}

//random color background

var changethis = document.getElementsByClassName("container")[0].firstElementChild;
changethis.addEventListener("click", changeBackground);

function randomBackground(){
    var x = Math.floor(Math.random() * 256);
    var y = Math.floor(Math.random() * 256);
    var z = Math.floor(Math.random() * 256);
    var bgColor = "rgb(" + x + "," + y + "," + z + ")";
    console.log(bgColor);
    
    if(x == 0 && y == 0 && z == 0){
        document.body.style.backgroundColor = white;
    }
    document.body.style.background = bgColor;
}

function changeBackground(){
    setTimeout(function(){
        document.body.style.background = randomBackground();
    }, 3000);
}

//n1 and n2
var calcbutton = document.createElement("BUTTON");
var buttontext = document.createTextNode("Solve the problem!");
calcbutton.appendChild(buttontext);
document.getElementsByTagName("h3")[0].appendChild(calcbutton);
calcbutton.addEventListener("click", mathop);

function mathop(){
    var number1 = document.getElementById("n1").value;
    var number2 = document.getElementById("n2").value;
    var num1 = parseInt(number1, 10);
    var num2 = parseInt(number2, 10);
    mathwork = document.getElementById("operation");
    for (i = 0; i < mathwork.length; i++){
        if (mathwork[i].innerHTML == "Add"){
            if (mathwork[i].selected){
                calc = num1 + num2;
            }
        } else if (mathwork[i].innerHTML == "Subtract"){
            if (mathwork[i].selected){
                calc = num1-num2;
            }
        } else if (mathwork[i].innerHTML == "Divide"){
            if (mathwork[i].selected){
                calc = num1 / num2;
            }
        } else if (mathwork[i].innerHTML == "Multiply"){
            if(mathwork[i].selected){
                calc = num1 * num2;
            }
        }

        document.getElementById("result").innerHTML = calc;
    }
}    


// Walk The Dom
function walkTheDOM(node, func){
    func(node);
    node = node.firstChild;
      while(node)
      {
          walkTheDOM(node, func);
        node = node.nextSibling;
      }
}

walkTheDOM(document, function(node){
    if (node.nextSibling == "undefined"){
        console.log("oops");
    }
    console.log(node);
    })