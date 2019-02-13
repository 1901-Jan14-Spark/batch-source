window.onload = function() {
    document.getElementById("callCenterOptions").addEventListener("click", retrieveCallList);
    let selection = document.getElementById("callCenterOptions").value;
    if(selection == "All Calls") {
        let newNode = document.getElementsByTagName("div")[0];
        newNode.removeAttribute("hidden");
        document.getElementsByTagName("div")[1].setAttribute("hidden", "none");
    } else {
            retrieveCallList;
        }
}

function retrieveCallList() {
    let selection = document.getElementById("callCenterOptions").value;
    if(selection == "Call Metrics") {
        let newNode = document.getElementsByTagName("div")[1];
        newNode.removeAttribute("hidden");
        document.getElementsByTagName("div")[0].setAttribute("hidden", "none");
    } else {
        let newNode = document.getElementsByTagName("div")[0];
        newNode.removeAttribute("hidden");
        document.getElementsByTagName("div")[1].setAttribute("hidden", "none");
    }
}

function populateCallCenterCall(callTime, id, notes, resolved, id2, firstName, lastName) {
    let row = document.createElement("tr");
    let cell0 = document.createElement("td");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    row.appendChild(cell0);
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    cell0.innerHTML = callTime;
    cell1.innerHTML = id;
    cell2.innerHTML = notes;
    cell3.innerHTML = resolved;
    cell4.innerHTML = id2;
    cell5.innerHTML = firstName;
    cell6.innerHTML = lastName;
    document.getElementById("info").appendChild(row);
}

function populateCallSum(sum) {
    document.getElementById("newSum").innerHTML = sum;
}

function populateCallMin(min) {
    document.getElementById("newMin").innerHTML = min;
}

function populateCallMedian(median) {
    document.getElementById("newMedian").innerHTML = median;
}

function populateCallMax(max) {
    document.getElementById("newMax").innerHTML = max;
}

function populateCallAverage(average) {
    document.getElementById("newAverage").innerHTML = average;
}

// the below will populate all caller fields
let getUrl = "http://localhost:9595/call/all";
function getAllCallers(callBack) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", getUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            callBack(this);
        }
    }
    xhr.send();
}

function allCallerInfo(xhrObj) {
    let jsonResponse = xhrObj.response;
    let callInfo = JSON.parse(jsonResponse);
    for(caller of callInfo) {
        populateCallCenterCall(caller.callTime, caller.id, caller.notes, caller.resolved, caller.user.id, caller.user.firstName, caller.user.lastName);
    }
}

// this will populate the sum info
let getSumUrl = "http://localhost:9595/call/sum";
function getSumInfo(callBack) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", getSumUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            callBack(this);
        }
    }
    xhr.send();
}

function getSum(xhrObj) {
    let jsonResponse = xhrObj.response;
    populateCallSum(jsonResponse);
}

// this will populate the min info
let getMinUrl = "http://localhost:9595/call/min";
function getMinInfo(callBack) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", getMinUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            callBack(this);
        }
    }
    xhr.send();
}

function getMin(xhrObj) {
    let jsonResponse = xhrObj.response;
    populateCallMin(jsonResponse);
}

// this will populate the median info
let getMedianUrl = "http://localhost:9595/call/median";
function getMedianInfo(callBack) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", getMedianUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            callBack(this);
        }
    }
    xhr.send();
}

function getMedian(xhrObj) {
    let jsonResponse = xhrObj.response;
    populateCallMedian(jsonResponse);
}

// this will populate the max info
let getMaxUrl = "http://localhost:9595/call/max";
function getMaxInfo(callBack) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", getMaxUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            callBack(this);
        }
    }
    xhr.send();
}

function getMax(xhrObj) {
    let jsonResponse = xhrObj.response;
    populateCallMax(jsonResponse);
}

// this will populate the average info
let getAverageUrl = "http://localhost:9595/call/avg";
function getAverageInfo(callBack) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", getAverageUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            callBack(this);
        }
    }
    xhr.send();
}

function getAverage(xhrObj) {
    let jsonResponse = xhrObj.response;
    populateCallAverage(jsonResponse);
}

getAllCallers(allCallerInfo);
populateAllMetrics();

function populateAllMetrics() {
    getSumInfo(getSum);
    getMinInfo(getMin);
    getMedianInfo(getMedian);
    getMaxInfo(getMax);
    getAverageInfo(getAverage);
}

// this will create a new call
let postCreateUrl = "http://localhost:9595/call";
function postCreateCaller(callBack, newCallerObject) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", postCreateUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 201) {
            callBack(this);
        } else {
            console.log(xhr.response);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/json");
    let createCall = JSON.stringify(newCallerObject);
    xhr.send(createCall);
}

function postCaller(xhrObj) {
    let jsonResponse = xhrObj.response;
    console.log(jsonResponse);
}

function createCaller() {
    let popNewCall = {
        "callTime": document.getElementById("callTime").value,
        "id": document.getElementById("callID").value,
        "notes": document.getElementById("callNotes").value,
        "resolved": document.getElementById("callResolved").value,
        "user": {
            "firstName": "",
            "id": document.getElementById("callerID").value,
            "lastName": ""
        }
    }
    postCreateCaller(postCaller, popNewCall);
}

// delete a call
let postDeleteUrl = "http://localhost:9595/call";

function postDeleteCaller(callBack, deleteCallerObject) {
    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", postDeleteUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            callBack(this);
        } else {
            console.log(xhr.response);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/json");
    let deleteCall = JSON.stringify(deleteCallerObject);
    xhr.send(deleteCall);
}

function deleteCaller(xhrObj) {
    let jsonResponse = xhrObj.response;
    console.log(jsonResponse);
}

function deleteCaller() {
    let callerID = document.getElementById("callID2").value;
    let popDelCall = {
        "callTime": 1,
        "id": callerID,
        "notes": "string",
        "resolved": true,
        "user": {
            "firstName": "string",
            "id": 1,
            "lastName": "string"
        }
    }
    postDeleteCaller(deleteCaller, popDelCall);
}

// update a call 
function updateCaller(deleteCall) {
    if(deleteCall < 0) {
        console.log("error1");
        return false;
    } else {
        console.log("updateCaller");
        postDeleteCaller(deleteCaller, callerId2);
    }
}

let postUpdateUrl = "http://localhost:9595/call";

function postUpdateCaller(callBack, updateCallerObject) {
    let xhr = new XMLHttpRequest();
    xhr.open("PUT", postUpdateUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 201) {
            callBack(this);
        } else {
            console.log(xhr.response);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/json");
    let updateCall = JSON.stringify(updateCallerObject);
    xhr.send(updateCall);
}

function updateCaller(xhrObj) {
    let jsonResponse = xhrObj.response;
    console.log(jsonResponse);
}

function updateCaller() {
    let callTime = document.getElementById("callTime").value;
    let callerID = document.getElementById("callID").value;
    let notes = document.getElementById("callNotes").value;
    let resolved = document.getElementById("callResolved").value;
    let callerID3 = document.getElementById("callerID").value;
    let updateCall = {
        "callTime": callTime,
        "id": callerID,
        "notes": notes,
        "resolved": resolved,
        "user": {
            "firstName": "string",
            "id": callerID3,
            "lastName": "string"
        }
    }
    postUpdateCaller(updateCaller, updateCall);
}
