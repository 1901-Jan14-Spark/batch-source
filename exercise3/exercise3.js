window.onload = function () {
    createOnStartUp();
    addLinks();
    removePluto();
    printSpan();
    appendLineBreak();
    changeBackground();
}


// variable initialize
const googleLink = document.getElementsByName("google")[0];
const twitterLink = document.getElementsByName("twitter")[0];
const slackLink = document.getElementsByName("slack")[0];
const java = document.getElementsByName("javadocs")[0];
const planet = document.getElementById("planet");
const alienText = document.getElementById("alientext");
const form_sub = document.getElementById("form-sub");
const summary = document.getElementsByTagName("summary")[0];
const earth_time = document.getElementById("earth_time");
const earth_time_check = document.getElementById("earth_time_check");
const wh4 = document.getElementsByTagName("h4")[0];
const num2 = document.getElementById("n2");
const option = document.getElementById("operation");


//  global functions
const createOnStartUp = () => {
    planet[1].setAttribute("onclick", "alienText()");
    planet[0].setAttribute("onclick", "removeAlienText()");
    createElement("div", "alientext", "color: red", planet);
    form_sub.addEventListener("click", submitForm);
    summary.setAttribute("onmouseover", "openDetails()");
    summary.setAttribute("onmouseout", "closeDetails()");
    earth_time.appendChild(createNode("span", "earth_time_span"));
    earth_time_check.setAttribute("onclick", "displayTime()");
    wh4.setAttribute("onclick", "changeBackground()");
    createElement("button", "calculator-button", "", document.getElementsByClassName("float-right")[0]);
    document.getElementById("calculator-button").innerHTML = "calculate";
    document.getElementById("calculator-button").setAttribute("onclick", "calculate()");
}

const createElement = (element, id, style, referenceNode) => {
    let created = document.createElement(element);
    created.setAttribute("id", id);
    created.setAttribute("style", style);
    insertAfter(created, referenceNode);
}

const insertAfter = (newNode, referenceNode) => {
    referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}

const createNode = (tag, id) => {
    let created = document.createElement(tag);
    created.setAttribute("id", id);
    return created;
}

const appendLineBreak = () => {
    createElement("br", "", "", num2);
    createElement("br", "", "", num2);
    createElement("br", "", "", num2);
}


// 1.
const addLinks = () => {
    googleLink.innerHTML = "Google";
    googleLink.href = "https://www.google.com/";

    twitterLink.innerHTML = "Twitter";
    twitterLink.href = "https://twitter.com/";

    slackLink.innerHTML = "Slack";
    slackLink.href = "https://slack.com/";

    java.innerHTML = "Docs";
    java.href = "https://docs.oracle.com/en/java/javase/11/";
}


// 2.
const removePluto = () => {
    planet.lastElementChild.disabled = true;
}


// 3.
const addAlienText = () => {
    // console.log("add");
    if (alienText.innerHTML == "") {
        alienText.innerHTML = "Insert alien language here"
    }
}

const removeAlienText = () => {
    // console.log("remove");
    if (alienText.innerHTML != "") {
        alienText.innerHTML = "";
    }
}


// 4.
const addRow = (name, email, phone, bday, color, gender, hobby) => {

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
    cell5.innerHTML = gender;
    cell6.innerHTML = color;
    cell7.innerHTML = hobby;

    document.querySelector(".table").appendChild(row);
}

const submitForm = () => {
    let form = document.getElementsByClassName("form-group")[0];
    let counter = 0;
    let error = 0;
    let selectedGender = "";
    let hobbyArr = [];

    for (i = 0; i < form.length; i++) {
        if (form[i].id == "firstname") {
            if (form[i].value == "" || form[i].value.length < 2) {
                error += 1;
            }
        } else if (form[i].id == "lastname") {
            if (form[i].value == "" || form[i].value.length < 2) {
                error += 1;
            }
        } else if (form[i].id == "email") {
            if (form[i].value == "") {
                error += 1;
            }
        } else if (form[i].id == "phone") {
            if (form[i].value == "") {
                error += 1;
            }
        } else if (form[i].id == "bday") {
            if (form[i].value == "") {
                error += 1;
            }
        } else if (form[i].name == "gender") {
            if (form[i].checked == true) {
                selectedGender = form[i].value;
            }

        } else if (form[i].className == "activity") {
            if (form[i].checked == true) {
                hobbyArr.push(form[i].value);
                counter += 1;
            }
        }
    }
    if (counter == 0) {
        error += 1;
    }
    if (error <= 0) {
        addRow(form[0].value + " " + form[1].value, form[2].value, form[3].value, form[4].value, selectedGender, form[9].value, hobbyArr);
    }
}


// 5.
const openDetails = () => {
    document.getElementsByTagName("details")[0].childNodes[3].hidden = false;
}
const closeDetails = () => {
    document.getElementsByTagName("details")[0].childNodes[3].hidden = true;
}


// 6. 
const printSpan = () => {
    let spanTextHolder = "";
    let spans = $(document).find("span");
    for (i = 0; i < spans.length; i++) {
        spanTextHolder += spans[i].innerHTML;
        // console.log(spanTextHolder);
    }
}


// 7.
const displayTime = () => {
    let span = earth_time_check;
    if (span.innerHTML == "Earth time") {
        let date = new Date();
        date.toString();
        span.innerHTML = date;
    } else {
        span.innerHTML = "Earth time";
    }
}


// 8.
const changeBackground = () => {
    setTimeout(function () {
        document.body.style.backgroundColor = getRandomColor();
    }, 3000);
}

const getRandomColor = () => {
    let letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    if (color == "#000000") {
        getRandomColor();
    } else {
        return color;
    }
}


// 9.
const calculate = () => {
    let total = 0;
    let num1Val = Number(document.getElementById("n1").value);
    let num2Val = Number(document.getElementById("n2").value);
    for (i = 0; i < option.length; i++) {
        if (option[i].innerHTML == "Add") {
            if (option[i].selected) {
                total = num1Val + num2Val;
            }
        } else if (option[i].innerHTML == "Subtract") {
            if (option[i].selected) {
                total = num1Val - num2Val;
            }
        } else if (option[i].innerHTML == "Divide") {
            if (option[i].selected) {
                total = num1Val / num2Val;
            }
        } else if (option[i].innerHTML == "Multiply") {
            if (option[i].selected) {
                total = num1Val * num2Val;
            }
        }
    }
    document.getElementById("result").innerHTML = total;
}


// 10.
const walkTheDom = (node, cb) => {
    let all = document.getElementsByTagName(node);
    for (i = 0; i < all.length - 1; i++) {
        cb(all[i]);
    }
}