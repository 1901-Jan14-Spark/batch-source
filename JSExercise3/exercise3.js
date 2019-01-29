


// Problem 1
// This portion of the code changes the name of each link
let links = document.getElementsByTagName("a");
links[0].innerHTML = "Google ";
links[1].innerHTML = "Twitter ";
links[2].innerHTML = "Slack ";
links[3].innerHTML = "JavaDocs ";
// This positon changes the actual destination of each link when clicked
links[0].href = "https://www.google.com/";
links[1].href = "https://twitter.com/";
links[2].href = "https://slack.com/";
links[3].href = "https://javadocs.com/";

// Problem 2
// Disabling the Pluto option within the dropdown menu
let planetSelection = document.getElementById("planet");
planetSelection[2].hidden = true; // simply hiding the planet option will remove it from the users view

// Problem 3
var hiddenText = document.getElementsByTagName("p"[5]);
var planetChoice = document.getElementById("planet");
function alienText(){
    if(planetChoice == "Add"){
        if(selection[i].selected){
            answer = n1 + n2;
        }
    }    
}


// Problem 4
// Create new row of info in the table when the submit button is clicked
function addNewRow(name, email, phone, bday, color, gender, acts){
    let table = document.getElementsByClassName("table")[0];
    let row = table.insertRow(1);

    // Create a new column/cell for each piece of data entered by the user
    let nameCell = row.insertCell(0);
    let emailCell = row.insertCell(1);
    let phoneCell = row.insertCell(2);
    let bdayCell = row.insertCell(3);
    let colorCell = row.insertCell(4);
    let genderCell = row.insertCell(5);
    let favActsCell = row.insertCell(6);


    // let firstNameCell = document.createElement("td");
    // let lastNameCell = document.createElement("td");
    // let emailCell = document.createElement("td");
    // let phoneCell = document.createElement("td");
    // let birthdayCell = document.createElement("td");
    // let planetCell = document.createElement("td");
    // let genderCell = document.createElement("td");
    // let favActsCell = document.createElement("td");

    // Adds the full row to the table
    row.appendChild(nameCell);
    row.appendChild(emailCell);
    row.appendChild(phoneCell);
    row.appendChild(birthdayCell);
    row.appendChild(colorCell);
    row.appendChild(genderCell);
    row.appendChild(favActsCell);

    // Get the info from the user
    nameCell.innerHTML = document.getElementById("firstname");  
    emailCell.innerHTML = document.getElementsById("email");
    phoneCell.innerHTML = document.getElementById("phone");
    birthdayCell.innerHTML = document.getElementById("bday");
    colorCell.innerHTML = document.getElementById("color");
    genderCell.innerHTML = document.getElementsByName("gender");
    favActsCell.innerHTML = document.getElementsByClassName("activity");

    // document.getElementsByClassName("table table-striped table-bordered table-hover table-sm").appendChild(row);
}
// add the information when the submit button is clicked
document.getElementById("form-sub").addEventListener("click", addNewRow);

// Problem 5
let details = document.getElementsByTagName("details")[0];
function openDetails(){
    details.open = true;
}
details.addEventListener("mouseover", openDetails);

// Problem 6
function showSpans(){
    // Get each span from the html file
    let span1 = document.getElementsByTagName("span")[0].innerHTML;
    let span2 = document.getElementsByTagName("span")[1].innerHTML;
    let span3 = document.getElementsByTagName("span")[2].innerHTML;
    let span4 = document.getElementsByTagName("span")[3].innerHTML;
    let span5 = document.getElementsByTagName("span")[4].innerHTML;
    let span6 = document.getElementsByTagName("span")[5].innerHTML;
    let span7 = document.getElementsByTagName("span")[6].innerHTML;
    
    // Creat new spans from each of the spans
    var spanCombo = span1.concat(span2).concat(span3).concat(span4).concat(span5).concat(span6).concat(span7);
    return spanCombo;
}

// Problem 7
var timeButton = document.getElementById("earth_time_check");
var displayTime = document.getElementById("earth_time");
function displayEarthTime(){    
    //creates a new time object
    var time = new Date();
    //converts the time object to string form
    var timeString = time.toString();
    //displaye the time in the button
    displayTime.innerHTML = timeString;
}
timeButton.addEventListener("click", displayEarthTime);

// Problem 8
let heading = document.getElementsByTagName("h1")[0];
function changeColor(){
    // create the time delay
    setTimeout(function(){
        document.body.style.backgroundColor = getRandomColor();
      }, 3000);    
}
// this function generates a random color
function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    // this portion checks to make sure the color isn't black
    if(color == "#000000"){
      getRandomColor();
    }else{
      return color;
    }
}
heading.addEventListener("click", changeColor);

// Problem 9
function calculator(){
var n1 = Number(document.getElementById("n1").value);
var n2 = Number(document.getElementById("n2").value);
var selection = document.getElementById("operation");
var answer = 0;
    // iterates through the choices to determine which is selected
    for(i = 0; i < selection.length; i++){
        if(selection[i].innerHTML == "Add"){
            // determines if choice is selected
            if(selection[i].selected){
                // completes the mathematical operation;
                answer = n1 + n2;
            }
        } else if (selection[i].innerHTML == "Subtract"){
            if(selection[i].selected){
                answer = n1 - n2;
            }
        } else if(selection[i].innerHTML == "Divide"){
            if(selection[i].selected){
                answer = n1 / n2;
            }
        } else if(selection[i].innerHTML == "Multiply"){
            if(selection[i].selected){
                answer = n1 * n2;
            }
        }
    }
    document.getElementById("result").innerHTML = answer;
}

// Problem 10
function walkTheDom(node, func){

}





