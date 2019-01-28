console.log("program started sucessfully");

//#1
let googleNode = document.getElementsByTagName("a")[0].href = "https://www.google.com";
document.getElementsByTagName("a")[0].innerHTML = "Google";
let twitterNode = document.getElementsByTagName("a")[1].href = "https://www.twitter.com";
document.getElementsByTagName("a")[1].innerHTML = "Twitter";
let slackNode = document.getElementsByTagName("a")[2].href = "https://www.slack.com";
document.getElementsByTagName("a")[2].innerHTML = "Slack";
let javadocsNode = document.getElementsByTagName("a")[3].href = "https://www.https://www.oracle.com/technetwork/java/javase/documentation/javadoc-137458.html";
document.getElementsByTagName("a")[3].innerHTML = "JavaDocs";


//#2

let planetNodes = document.getElementsByTagName("option");
planetNodes[2].disabled = true;

//#3

function alienText() {
    let secretText = document.getElementsByTagName("p");
    for (i of secretText) {
        console.log(i);
        if (i.hidden) i.setAttribute("hidden", false);
    }
}

document.getElementsByTagName("option")[1].addEventListener("click", alienText);

//#4

document.getElementById("form-sub").addEventListener("click", submitForm);


function isValidEmail(string) { //from assignment 2
    let atPos = string.indexOf("@");
    let dotPos = string.lastIndexOf(".");
    return (atPos > 0 && dotPos == string.length - 4);
}



function submitForm() {
    let firstName = document.getElementById("firstname").value;
    let lastName = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let bDay = document.getElementById("bday").value;
    // let homePlanet = document.getElementById("planet").value;
    let male = document.getElementsByName("gender")[0].value;
    let female = document.getElementsByName("gender")[1].value;
    let other = document.getElementsByName("gender")[2].value;
    let favoriteColor = document.getElementById("color").value; 
    let favoriteActivities = document.getElementsByClassName("activities").value;
    let valid = true;
    let tableNode = document.getElementsByClassName("table table-striped table-bordered table-hover table-sm")[0];
    // console.log(firstName, lastName, email, phone, bDay, gender, favoriteColor, favoriteActivities); //debugging

    console.log(male, female, other);
    

    if (firstName && lastName && email && phone && gender && favoriteColor != true) {
        valid = false; //cancels entry if any elements are empty.
        console.log("All entries are necessary for submission")
    }
    else {
        if (firstName.length < 2 || lastName.length < 2) { //fist and last name must be each at least 2 characters.
            console.log("Name entries must be at least two characters long.")
            valid = false;
        }
        if (isValidEmail(email) != true) { //using my earlier function to check the email
            valid = false;
            console.log("email format incorrect.")
        }
        if (phone.length != 7 && phone.length != 10 && phone.length != 11) { //checks phone number for proper format
            valid = false;
            console.log(phone.length, "phone number format incorrect.");
        }
    
        if (valid) { //if all checks go through, creates new table elements
            console.log(`You have submitted the form`);
            let row = tableNode.insertRow(1);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            let cell5 = row.insertCell(4);
            let cell6 = row.insertCell(5);
            let cell7 = row.insertCell(6);

            row.appendChild(cell1); //appends elements
            row.appendChild(cell2);
            row.appendChild(cell3);
            row.appendChild(cell4);
            row.appendChild(cell5);
            row.appendChild(cell6);
            row.appendChild(cell7);

            cell1.innerHTML = firstName + " " + lastName; //populates elements
            cell2.innerHTML = email;
            cell3.innerHTML = phone;
            cell4.innerHTML = bDay;
            cell5.innerHTML = favoriteColor;
            cell6.innerHTML = gender;
            cell7.innerHTML = favoriteActivities;

            
        }
        }
    }



//#5
let detailsBox = document.getElementsByTagName("details")[0];
detailsBox.addEventListener("mouseover", openDetails);    
detailsBox.addEventListener("mouseout", closeDetails);

function openDetails() {
        detailsBox.setAttribute("open", value = "true");
        console.log("MOUSEOVER", detailsBox.value);
    }
function closeDetails() {
    detailsBox.setAttribute("open", value = "false");
        console.log(detailsBox.value);
}


//#6

function hiddenMessage(){
    let span0= document.getElementsByTagName("span")[0].innerHTML;
    let span1= document.getElementsByTagName("span")[1].innerHTML;
    let span2= document.getElementsByTagName("span")[2].innerHTML;
    let span3= document.getElementsByTagName("span")[3].innerHTML;
    let span4= document.getElementsByTagName("span")[4].innerHTML;
    let span5= document.getElementsByTagName("span")[5].innerHTML;
    let span6= document.getElementsByTagName("span")[6].innerHTML;
    let spanSum=(span0+span1+span2+span3+span4+span5+span6);
    console.log = (spanSum);
}

//#7

document.getElementById("earth_time_check").addEventListener("click", earthTime);

function earthTime(){
    let newNode = document.getElementById("earth_time");
    let date = " " + new Date();
    newNode.innerHTML = `${date}`;
}

//#8

let galacticHeader = document.getElementsByTagName("h1")[0];
galacticHeader.addEventListener("click", changeBackground);
function changeBackground(){
    console.log("title click detected"); //debugging

    let background = document.getElementsByTagName("body")[0];
    let r = Math.floor(Math.random()*255);    //generate 3 random numbers from 0-255
    let g = Math.floor(Math.random()*255);
    let b = Math.floor(Math.random()*255);
    
if(r||g||b){ //if they're all 0, retry
    setTimeout(3000); //pauses 3000 milliseconds
    background.setAttribute("style", `"background color = rgb(${r}, ${g}, ${b})"`);
}
    else{
        changeBackground();
    }
}

//#9

let mathSelect = document.getElementById("operation");
mathSelect.addEventListener("click", doMath);
let answerNode = document.createElement("h5");
answerNode.id = "answer";


function doMath(){
    let math1 = document.getElementById("n1").value;
    let math2 = document.getElementById("n2").value;
    let operation = mathSelect.value;
    let answer;
    if(typeof(Number(math1)) == "number" && typeof(Number(math2) == "number")){
        math1 = Number(math1);
        math2 = Number(math2);
        switch(operation){
            case("Add"): {answer = (math1 + math2); 
                break
            }
            case("Subrtact"):{ answer = (math1 - math2) ;
                break
            }
            case("Multiply"):{ answer = (math1 * math2);
                break
            }
            case("Divide"):{ answer = (math1 / math2);
                break
            }
        }
        answerNode.innerHTML = answer;
        console.log(answer);
    }
    else{
        console.log("Both entries must be numbers")
    }
}

//#10


function walkTheDom(node, func){
    let allElements = document.getElementsByTagName("body")[0].children;
    for (i in allElements){
        func(node);
    }
 return(false);
}

