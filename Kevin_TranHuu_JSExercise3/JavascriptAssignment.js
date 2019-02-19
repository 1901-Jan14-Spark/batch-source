// JavaScript Assignment - Interacting with the DOM
// -	Achieve the following using only JavaScript (do not change the index.html)
window.onload = function () {
    assignLinks();
    deletePluto();
    document.getElementById("planet").addEventListener("click", alienText);
    document.getElementById("form-sub").addEventListener("click", addToTable);
    document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
    document.getElementsByTagName("details")[0].addEventListener("mouseout", openDetails);
    document.getElementById("earth_time_check").addEventListener("click", earthTime);
    document.getElementsByTagName("h1")[0].addEventListener("click", delayedColorChange);
    document.getElementById("n1").addEventListener("keyup", computeCalculation);
    document.getElementById("n2").addEventListener("keyup", computeCalculation);
    document.getElementById("operation").addEventListener("click", computeCalculation);

}

// 1.	Make each link direct the user to its respective website (see id)

function assignLinks() {
    let links = document.getElementsByTagName("a");

    for (i = 0; i < links.length; i++) {
        links[i].setAttribute("href", `https://${links[i].name}.com`);

        // let linkValue;
        // switch(links[i].name){
        //     case "google":
        //         linkValue = "https://www.google.com/";
        //         break;
        //     case "twitter":
        //         linkValue = "https://twitter.com//";
        //         break;
        //     case "slack":
        //         linkValue = "https://slack.com/";
        //         break;
        //     case "javadocs":
        //         linkValue = "https://javadocs.com/";
        //         break;
        //     default: 
        //         console.log("No case matches input name.")
        //         break;
        // }
        // links[i].setAttribute("href", linkValue);
    }

}

// 2.	Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
function deletePluto() {
    let planets = document.getElementById("planet");
    for (planet of planets) {
        if (planet.innerHTML == "Pluto") {
            planet.disabled = true;
        }
    }
}

// 3.	Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.

function alienText() {
    let mars;
    let planets = document.getElementById("planet");
    let beepBoop = document.getElementsByTagName("p")[5];

    for (planet of planets) {
        if (planet.innerHTML == "Mars") {
            mars = planet;
        }
    }
    if (mars.selected) {
        beepBoop.hidden = false;
    } else {
        beepBoop.hidden = true;
    }
}

// 4.	When the submit button is pressed, get the values from all of the input into a new row in the table below.  Make sure no input is empty, check that first and last name are at least two letters each. Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.

function addToTable() {
    let data = getDataFromForm();
    addRow(data);
}

function getDataFromForm() {
    let firstName = document.getElementById("firstname").value;
    let lastName = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phoneNum = document.getElementById("phone").value;
    let date = document.getElementById("bday").value;
    let birthday = date.substring(5,7) + "/" + date.substring(8,10)+"/" + date.substring(0,4);
    let color = document.getElementById("color").value;
    let genderList = document.getElementsByName("gender");
    let gender;
    for (gend of genderList) {
        if (gend.checked == true) {
            gender = gend.value;
            switch (gend.value) {
                case "female":
                    gender = "Female";
                    break;
                case "male":
                    gender = "Male";
                    break;
                case "other":
                    gender = "Other";
                    break;
                default:
                    break;
            }
        }
    }
    let activityList = document.getElementsByClassName("activity");
    let activities = [];
    let index = 0;
    for (i = 0; i < activityList.length; i++) {
        if (activityList[i].checked == true) {
            switch (activityList[i].value) {
                case "hiking":
                    activities[index] = "hiking";
                    break;
                case "stamp":
                    activities[index] = "stamp collecting";
                    break;
                case "birding":
                    activities[index] = "birding";
                    break;
                case "basket":
                    activities[index] = "underwater basket weaving";
                    break;
                default:
                    break;
            }
            index++;
        }
    }
    let myActivities = "<ul>";
    for(i=0; i < activities.length;i++) {
        myActivities += "<li>" + activities[i] + "</li>";
    }
    myActivities += "</ul>";
    let rowData = [firstName, lastName, email, phoneNum, birthday, color, gender, myActivities];

    if (validateData(rowData) == false) {
        console.log("input missing");
        return;
    }

    return rowData;
}

function validateData(rowData) {
    var reg = /(.+)@(.+){2,}\.(.+){2,}/gi;
    for (i = 0; i < rowData.length; i++) {
        if (rowData[i] == null || rowData[i] == "") {
            return false;
        } else if (rowData[0].length <= 2 || rowData[1].length <= 2) {
            console.log("inside name length");
            return false;
        } else if (rowData[0].length <= 2 || rowData[1].length <= 2) {
            console.log("inside name length");
            return false;
        } else if (rowData[3].length != 10 || isNaN(Number(rowData[3])) == true) {
            console.log("inside phone");
            return false;
        } else if (!reg.test(rowData[2]) == "false") {
            console.log("inside the email");
            return false;
        }
    }
    console.log("data validated");
    return true;
}
function addRow(rowData) {

    let row = document.createElement("tr");
    row.scope = "row";
    let cellName = document.createElement("td");
    let cellEmail = document.createElement("td");
    let cellPhone = document.createElement("td");
    let cellBirthday = document.createElement("td");
    let cellFavoriteColor = document.createElement("td");
    let cellGender = document.createElement("td");
    let cellActivities = document.createElement("td");

    row.appendChild(cellName);
    row.appendChild(cellEmail);
    row.appendChild(cellPhone);
    row.appendChild(cellBirthday);
    row.appendChild(cellFavoriteColor);
    row.appendChild(cellGender);
    row.appendChild(cellActivities);

    cellName.innerHTML = rowData[0];
    cellEmail.innerHTML = rowData[2];
    cellPhone.innerHTML = rowData[3];
    cellBirthday.innerHTML = rowData[4];
    cellFavoriteColor.innerHTML = rowData[5];
    cellGender.innerHTML = rowData[6];
    cellActivities.innerHTML = rowData[7];

    document.getElementsByClassName("table")[0].appendChild(row);

}



// 5.	Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. The details should be hidden when the mouse is removed from the summary.

function openDetails() {
    let detailPar = document.getElementsByTagName("details")[0];
    if (detailPar.open === false) {
        detailPar.open = true;
    } else {
        detailPar.open = false;
    }
}

// 6.	Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.

function concatenateInnerHtml() {
    let spanList = document.getElementsByTagName("span");
    let innerHtmls = "";
    for (span of spanList) {
        innerHtmls += span.innerHTML;
    }
    console.log(innerHtmls);
}

// 7.	Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked. 

function earthTime() {
    let clock = document.getElementById("earth_time");
    let date1 = new Date();
    clock.innerHTML = date1.toLocaleTimeString();
}

// 8.	Three seconds after a user clicks on the “Intergalactic Directory” heading, the 	background color should change to a random color. Make sure this color is never black so we can still read our black text! (there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black background)
function getRndColor() {
    // Returns a color that with a minimum rbg value of 40 to avoid dark backgrounds
    return Math.floor(Math.random() * (255 - 40)) + 40;
}

function changeColor() {
    document.getElementsByTagName("h1")[0].style.backgroundColor = `rgb(${getRndColor()}, ${getRndColor()}, ${getRndColor()})`;
}

function delayedColorChange() {
    setTimeout(changeColor, 3000);
}

// 9.	When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display the result in the element with id result.

function computeCalculation() {
    let n1 = Number(document.getElementById("n1").value);
    let n2 = Number(document.getElementById("n2").value);

    if (isNaN(n1) == true || isNaN(n2) == true) {
        document.getElementById("result").innerHTML = "Invalid input.";
        return;
    }

    let operationType = document.getElementById("operation").value;
    let result;

    switch (operationType) {
        case "Add":
            result = n1 + n2;
            break;
        case "Subtract":
            result = n1 - n2;
            break;
        case "Multiply":
            result = n1 * n2;
            break;
        case "Divide":
            result = n1 / n2;
            break;
        default:
            break;
    }

    document.getElementById("result").innerHTML = result;
}

// 10.	Define function walkTheDom(node, func)
// 	This function should traverse every node in the DOM. 
// 	Use recursion. On each node, call func(node).

function print(node) {
    console.log(node);
}

function walkTheDom(node, func) {
    let childrenOfNode = node.childNodes;
    func(node);
    for (child of childrenOfNode) {
        walkTheDom(child, func);
    }
}
