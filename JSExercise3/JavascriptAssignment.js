// JavaScript Assignment - Interacting with the DOM
// - Achieve the following using only JavaScript (do not change the index.html)
//
// 1. Make each link direct the user to its respective website (see id)
//
// 2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
//
// 3. Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.
//
// 4. When the submit button is pressed, get the values from all of the input into a new row in the table below.
//     Make sure no input is empty, check that first and last name are at least two letters each. Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.
//
// 5. Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over.
//     The details should be hidden when the mouse is removed from the summary.
//
// 6. Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
//
// 7. Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked.
//
// 8. Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change to a random color.
//     Make sure this color is never black so we can still read our black text!
//     (there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black background)
//
// 9. When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display the result in the element with id result.
//
// 10. Define function walkTheDom(node, func)
//     - This function should traverse every node in the DOM.
//     - Use recursion. On each node, call func(node).

// variable initialize

let google = document.getElementsByName("google");
let twitter = document.getElementsByName("twitter");
let slack = document.getElementsByName("slack");
let javadocs = document.getElementsByName("javadocs");

let planets = document.getElementById("planet");


window.onload = function(){
  createOnStartUp();
  addLinks();
  removePluto();
  printSpan();
  console.log()
}

// global functions
function createSomething(tag, id, style, referenceNode){
  let created = document.createElement(tag);
  created.setAttribute("id", id);
  created.setAttribute("style", style);
  insertAfter(created, referenceNode);
}
function createNode(tag, id){
  let created = document.createElement(tag);
  created.setAttribute("id", id);
  return created;
}

function insertAfter(newNode, referenceNode) {
  referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}

function addText(str, locationId){
  var para = document.createElement("p");
  var node = document.createTextNode(str);
  para.appendChild(node);
  var element = document.getElementById(locationId);
  element.appendChild(para);
}

function removeElements(node){
  var tempNode = document.getElementById(node);
  while(tempNode.firstChild){
    tempNode.removeChild(tempNode.firstChild);
  }
}

function createOnStartUp(){
  planet[1].setAttribute("onclick", "alienText()");
  planet[0].setAttribute("onclick", "removeAlienText()");

  createSomething("div", "alientext", "color: red", planet);
  createSomething("div", "submiterror", "color: red", document.getElementById("form-sub"));

  document.getElementsByTagName("summary")[0].setAttribute("onmouseover", "openDetails()");
  document.getElementsByTagName("summary")[0].setAttribute("onmouseout", "closeDetails()");

  document.getElementById("form-sub").setAttribute("onclick", "submitForm()");
  document.getElementsByClassName("form-group")[0][8].checked = true;

  document.getElementById("earth_time").appendChild(createNode("span", "earth_time_span"));
  document.getElementById("earth_time_check").setAttribute("onclick", "displayTime()");

  document.getElementsByTagName("h4")[0].setAttribute("onclick", "changeBackground()");

  createSomething("button", "calculator-button", "", document.getElementsByClassName("float-right")[0]);
  document.getElementById("calculator-button").innerHTML = "calculate";
  document.getElementById("calculator-button").setAttribute("onclick", "calculate()");
}

// ALL below are: window.onload functions
function openDetails(){
  document.getElementsByTagName("details")[0].childNodes[3].hidden = false;
}
function closeDetails(){
  document.getElementsByTagName("details")[0].childNodes[3].hidden = true;
}

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

function walkTheDom(node, func){
  var all = document.getElementsByTagName(node);
  for(i = 0; i < all.length - 1; i++){
    func(all[i]);
  }
}

function testFunction(node){
  node.innerHTML = "HAHAHAHAHAHAHAHHAHAHAHAHAHAHAHA";
}

function changeBackground(){
  setTimeout(function(){
    document.body.style.backgroundColor = getRandomColor();
  }, 3000);
}

function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  if(color == "#000000"){
    getRandomColor();
  }else{
    return color;
  }
}

function displayTime(){
  var span = document.getElementById("earth_time_check");
  if(span.innerHTML == "Earth time"){
    var date = new Date();
    date.toString();
    span.innerHTML = date;
  } else{
    span.innerHTML = "Earth time";
  }
}

function printSpan(){
  var total = "";
  var spans = $(document).find("span");
  for(i = 0; i < spans.length; i++){
    total += spans[i].innerHTML;
  }
}

//holy moly thats ugly..
function submitForm(){
  let form = document.getElementsByClassName("form-group")[0];
  var counter = 0;
  var error = 0;
  var selectedGender = "";
  var hobbyArr = [];
  removeElements("submiterror");

  // console.log(form[10]);
  // console.log(form[10].value);

  for(i = 0; i < form.length; i++){
    if(form[i].id == "firstname"){
      if(form[i].value == "" || form[i].value.length < 2){
        addText("ERROR: Enter yo FIRST NAME", "submiterror");
        error += 1;
      }
    } else if(form[i].id == "lastname"){
      if(form[i].value == "" || form[i].value.length < 2){
        addText("ERROR: That aint yo LAST NAME", "submiterror");
        error += 1;
      }
    } else if(form[i].id == "email"){
      if(form[i].value == ""){
        addText("ERROR: Com'on mate, give me yo EMAIL", "submiterror");
        error += 1;
      }
    } else if(form[i].id == "phone"){
      if(form[i].value == ""){
        addText("ERROR: I can't call you bb without yo PHONE", "submiterror");
        error += 1;
      }
    } else if(form[i].id == "bday"){
      if(form[i].value == ""){
        addText("ERROR: Can I congradulate you on your BIRTHDAY?", "submiterror");
        error += 1;
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
  if(counter == 0){
    addText("ERROR: My person, pick a HOBBY", "submiterror");
    error += 1;
  }
  if(!(error > 0)){
    //0=first, 1=last, 2=email, 3=phone, 4=bday, 5=planet, 6,7,8=gender, 9=color, 10,11,12,13=activity
    addRow(form[0].value + " " + form[1].value, form[2].value, form[3].value, form[4].value, selectedGender, form[9].value, hobbyArr);
  }
}

function addRow(name, email, phone, bday, gender, color, activity){
//0=name, 1=email, 2=phone, 3=birthday, 4=color, 5=gender, 6= act
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
  cell6.innerHTML = cell6Func(activity);
}

function cell6Func(activity){
  var str = "<ul>"
    for(i = 0; i < activity.length; i++){
      str += "<li>" + activity[i] + "</li>";
    }
  str += "</ul>"
  return str;
}

function alienText(){
  if(document.getElementById("alientext").innerHTML == ""){
    addText("This is some ALIEN TEXT", "alientext");
  }
}

function removeAlienText(){
  if(document.getElementById("alientext").innerHTML != ""){
    document.getElementById("alientext").innerHTML = "";
  }
}

function removePluto(){
  planets[2].disabled = true;
}

function addLinks(){
  google[0].innerHTML = "Google";
  google[0].href = "https://google.com";

  twitter[0].innerHTML = "Twitter";
  twitter[0].href = "https://twitter.com";

  slack[0].innerHTML = "Slack";
  slack[0].href = "https://slack.com";

  javadocs[0].innerHTML = "Javadocs";
  javadocs[0].href = "https://javadocs.com";
}
