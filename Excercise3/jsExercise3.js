//1. Direct Links
const google = document.getElementsByName("google")[0];
google.innerHTML = "Google";
google.href = "https://www.google.com/";

const twitter = document.getElementsByName("twitter")[0];
twitter.innerHTML = "Twitter";
twitter.href = "https://twitter.com/?lang=en";


const slack = document.getElementsByName("slack")[0];
slack.innerHTML = "Slack";
slack.href = "https://slack.com/";

const javaDocs = document.getElementsByName("javadocs")[0];
javaDocs.innerHTML = "JavaDocs";
javaDocs.href = "https://docs.oracle.com/javase/8/docs/api/";



let planetArray = document.getElementById("planet");
window.onload = function(){
    disablePluto();
    // concatenate();
    // alienText();
planetArray.addEventListener("click", alienText);
document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
document.getElementsByTagName("details")[0].addEventListener("mouseout", closeDetails);
document.getElementById("earth_time_check").addEventListener("click", earthTime);
document.getElementsByTagName("h4")[0].addEventListener("click", randomBackground);
document.getElementById("operation").addEventListener("click", operation);

}

// 2. Disable Pluto from Dropdown
function disablePluto(){
    planetArray[2].disabled =  true;
    
}

//3. Alien Text

function alienText(){
        if(planetArray.options[planetArray.selectedIndex].innerHTML == "Earth"){
           hideAlienText();
       }
        else {
            showAlienText();
        }
}


function showAlienText(){
    let para = document.getElementsByTagName("p");
    let paragraph = 0;
    for(paragraph in para){
        if(para[paragraph].innerHTML == "Beep boop"){
            para[paragraph].hidden = false;
        }
    }
}
function hideAlienText(){
    let para = document.getElementsByTagName("p");
    let paragraph = 0;
    for(paragraph in para){
        if(para[paragraph].innerHTML == "Beep boop"){
            para[paragraph].hidden = true;
        }
    }
}

// //4. Submit 
document.getElementById("form-sub").addEventListener("click", addNew);

function addRow(firstname, lastname, email, phone, bday, gender, color, listOptions){
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

    cell1.innerHTML = firstname +" "+ lastname;
    cell2.innerHTML = email;
    cell3.innerHTML = phone;
    cell4.innerHTML = bday;
    cell5.innerHTML = color;
    cell6.innerHTML = gender;
    cell7.innerHTML = listOptions;

    // cell7.innerHTML = createList(activities);

    document.getElementsByClassName("table")[0].appendChild(row);

}

function addNew(){
    var firstname = document.getElementById("firstname").value;
    var lastname = document.getElementById("lastname").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var bday = document.getElementById("bday").value;
    var gender = document.getElementsByName("gender");
    for(i=0; i<gender.length; i++){
        if(gender[i].checked){
            gender = gender[i].value;
        }
    }
    var color = document.getElementById("color").value;
    var activities = document.getElementsByClassName("activity");
    let listOptions = "";
    for(i= 0; i< activities.length; i++){
        if(activities[i].checked){
            listOptions += "<ul><li>"+ activities[i].value +"</li><ul>";
        }
    }

    addRow(firstname, lastname, email, phone, bday, gender, color, listOptions);
}

// function createList(activities){
//     var length = activities.length;
//     var list = document.createElement("ul");
//     for(var i=0; i < length; i++){
//         var listItem = document.createElement("li");
//         var listValue = document.createTextNode(activities[i].value);
//         listItem.appendChild(listValue);
//         list.appendChild(listItem);
//     }
//     return list;
// }

//5. Open the Details element when moused over

function openDetails(){
    document.getElementsByTagName("details")[0].open = true;
}
function closeDetails(){
    document.getElementsByTagName("details")[0].open = false;
}


//6. Concatenates innerHTML

function concatenate(){
    var conString= "";
    var spans = document.getElementsByTagName("span");
    for(i=0; i<spans.length; i++){
        conString += spans[i].innerHTML;
    }
    console.log(conString);
}

//7.  Earth Time

function earthTime(){
    let time = document.getElementById("earth_time");
    let currentTime = new Date();
    time.innerHTML = currentTime.toString();
}

//8. Random Background

function randomBackground(){
    setTimeout(function(){
    document.body.style.backgroundColor = randomGenerator();
    }, 3000);
    
}

function randomGenerator(){
    let randomColor = "";
    do{
        var hue = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')';
    }while(hue == 'rgb(0,0,0)')
    return hue;
}

//9. Operation outputs

function operation(){
    let n1 = Number(document.getElementById("n1").value);
    let n2 = Number(document.getElementById("n2").value);
    let operator = document.getElementById("operation");
    let value = 0;
    // for(i= 0; i < operator.length; i++){
        if(operator.options[operator.selectedIndex].innerHTML == "Add"){
            value = n1 + n2;
        }
        else if(operator.options[operator.selectedIndex].innerHTML == "Subtract"){
            value = n1-n2;
        }
        else if(operator.options[operator.selectedIndex].innerHTML == "Divide"){
            value = n1/n2;
        }
        else if(operator.options[operator.selectedIndex].innerHTML == "Multiply"){
            value = n1*n2;
        }
    // }
    document.getElementById("result").innerHTML = value;
}
// planetArray.options[planetArray.selectedIndex].innerHTML == "Earth")
10.//
function walkTheDom(node, func){
    let nodes = document.getElementsByTagName(node);
    for(i= 0; i < nodes.length; i++){
        func(nodes[i]);
    }
}
