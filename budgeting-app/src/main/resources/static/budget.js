window.onload = function(){
	makeAjaxGet(avgUrl, avgId);
	makeAjaxGet(maxUrl, maxId);
	makeAjaxGet(minUrl, minId);
	makeAjaxGet(sumUrl, sumId);
	makeAjaxGet(medianUrl, medianId);
	makeAjaxGetExpenses(expenseAllUrl);
	makeAjaxGetUsers(userUrl);
	sumbitId.addEventListener("click", runPost);
	updateId.addEventListener("click", runUpdate);
	deleteId.addEventListener("click", runDelete);
//	addRow(makeAjaxGet(avgUrl, avgId), makeAjaxGet(maxUrl, maxId), makeAjaxGet(minUrl, minId), makeAjaxGet(sumUrl, sumId), makeAjaxGet(medianUrl, medianId));
}


//document.getElementById("userBtn").addEventListner("click", makeAjaxPost);

const expenseAllUrl = "http://localhost:9595/expense/all";
const avgUrl = "http://localhost:9595/expense/avg";
const maxUrl = "http://localhost:9595/expense/max";
const minUrl = "http://localhost:9595/expense/min";
const sumUrl = "http://localhost:9595/expense/sum";
const medianUrl = "http://localhost:9595/expense/median";
const postUrl = "http://localhost:9595/expense";
const putUrl = "http://localhost:9595/expense";
const deleteUrl = "http://localhost:9595/expense";
const userUrl = "http://localhost:9595/user/all";

const sumbitId = document.getElementById("submitBtn");
const updateId = document.getElementById("updateBtn");
const deleteId = document.getElementById("deleteBtn");

const expenseId = document.getElementById("expenseId");
const maxId = document.getElementById("max");
const avgId = document.getElementById("avg");
const minId = document.getElementById("min");
const sumId = document.getElementById("sum");
const medianId = document.getElementById("median");
const expensesAllId = document.getElementById("expenses");
const selectId = document.getElementById("users");

const costValue = document.getElementById("cost");
const categoryName = document.getElementById("category");
const merchantName = document.getElementById("merchant");
const firstName = document.getElementById("firstName");
const lastName = document.getElementById("lastName");

const userArray = [];
const expenseArray = [];


function makeAjaxGet(url, val){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let value = JSON.parse(xhr.response);
			value = (value).toFixed(2);
			val.append(value);
		}
	}
	xhr.send();
}
function makeAjaxGetExpenses(url){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url); //false so values on window load can be accessed in correct manor
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let expenses = JSON.parse(xhr.response);
			for(expense of expenses){
				addRow(expense.id, (expense.cost).toFixed(2), expense.category, expense.merchant, expense.user.id, expense.user.firstName, expense.user.lastName);
				addExpense(expense.id, expense.cost, expense.category, expense.merchant, expense.user);
			}
		}
	}
	xhr.send();
	console.log(expenseArray);
}
function makeAjaxGetUsers(url){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url); //false so values on window load can be accessed in correct manor
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let users = JSON.parse(xhr.response);
			for(user of users){
				addUser(user.id, user.firstName, user.lastName);
			}
		}
	}
	xhr.send();
//	console.log(userArray);
}

function addRow(id, cost, category, merchant, userId, firstName, lastName){
	let row = document.createElement("tr");
	let cel1 = document.createElement("td");
	let cel2 = document.createElement("td");
	let cel3 = document.createElement("td");
	let cel4 = document.createElement("td");
	let cel5 = document.createElement("td");
	let cel6 = document.createElement("td");
	let cel7 = document.createElement("td");
	
	row.appendChild(cel1);
	row.appendChild(cel2);
	row.appendChild(cel3);
	row.appendChild(cel4);
	row.appendChild(cel5);
	row.appendChild(cel6);
	row.appendChild(cel7);
	
	cel1.innerHTML = id;
	cel2.innerHTML = cost;
	cel3.innerHTML = category;
	cel4.innerHTML = merchant;
	cel5.innerHTML = userId;
	cel6.innerHTML = firstName;
	cel7.innerHTML = lastName;
	
	expensesAllId.appendChild(row);
}

function addUser(id, first, last){
	let option = document.createElement("option");
	option.innerHTML = id + ": " + first +" "+ last;
	document.getElementById("userSelect").appendChild(option);
	let userObj = {id: id, firstName: first, lastName: last};
	userArray.push(userObj);
}

function addExpense(id, cost, category, merchant, user){
	let expenseObj = {id: id, cost: cost, category: category, merchant: merchant, user: user};
	expenseArray.push(expenseObj);
}

function makeAjaxPost(url, newExpense){
	console.log("make ajax Post");
	let xhr = new XMLHttpRequest();
	console.log("open");
	xhr.open("POST", url);
//	getValues();
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 201){
			console.log(xhr.response);
			console.log("response");
		}
		else{
			console.log("response else");
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	console.log(newExpense);
//	createExpense();
	console.log(newExpense);
	let jsonExpense = JSON.stringify(newExpense);
//	console.log(jsonExpense);
	xhr.send(jsonExpense);
//	getValues();
	}

//function getValues(){
//	console.log(costValue.value);
//	console.log(merchantName.value);
//	console.log(categoryName.value);
//	console.log(firstName.value);
//	console.log(lastName.value);
//	console.log(selectId.value);
//}

let tempUser = {firstName: null, id: 0,  lastName: null};

let newExpense = {
	category : "string",
	cost : 0,
	id : 0,
	merchant : "string",
	user : tempUser,
};

function createExpense(){
let user = document.getElementById("userSelect").value;
let userId = parseInt(user.substring(0, user.indexOf(":")));
console.log(userArray[userId - 1]);
newExpense.user = userArray[userId - 1];
newExpense.category = categoryName.value;
newExpense.cost = costValue.value;
newExpense.id = expenseId.value;
newExpense.merchant = merchantName.value;
}

function updateExpense(){
	let user = document.getElementById("userSelect").value;
	let userId = parseInt(user.substring(0, user.indexOf(":")));
	console.log(userArray[userId - 1]);
	let expenseIndex = null;
	for(i = 0; i<expenseArray.length; i++){
		if(expenseId.value == expenseArray[i].id){
			expenseIndex += i;
		}
	}
	if(document.getElementById("userSelect").value == ""){
		newExpense.user = expenseArray[expenseIndex].user;
	}
	else{
		newExpense.user = userArray[userId - 1];
	}
	if(categoryName.value == ""){
		newExpense.category = expenseArray[expenseIndex].category;
	}
	else{
		newExpense.category = categoryName.value;
	}
	if(costValue.value == 0){
		newExpense.cost = parseInt(expenseArray[expenseIndex].cost);
	}
	else{
		newExpense.cost = costValue.value;
	}
	if(merchantName.value == ""){
		newExpense.merchant = expenseArray[expenseIndex].merchant;
	}
	else{
		newExpense.merchant = merchantName.value;
	}
	newExpense.id = expenseId.value;
//	console.log(expenseArray[expenseIndex].id);
//	console.log(expenseArray[2].id);
//	console.log(expenseId.value);
//	console.log(expenseIndex);
//	console.log(document.getElementById("userSelect").value);
}

function deleteExpense(){

	let user = document.getElementById("userSelect").value;
	let userId = parseInt(user.substring(0, user.indexOf(":")));
	let expenseIndex = null;
	for(i = 0; i<expenseArray.length; i++){
		if(expenseId.value == expenseArray[i].id){
			expenseIndex += i;
		}
	}
	if(document.getElementById("userSelect").value == ""){
		newExpense.user = expenseArray[expenseIndex].user;
	}
	else{
		newExpense.user = userArray[userId - 1];
	}
	newExpense.category = "string";
	newExpense.cost = 0;
	newExpense.merchant = "string";
	newExpense.id = expenseId.value;
}
//let newExpense = {
//	"id": 29,
//	"cost": 50,
//	"category": "Food",
//	"merchant": "Noodles",
//	"user" : tempUser,
//};

function runPost(){
	console.log("run post");
	makeAjaxPost(postUrl, newExpense);
	window.location.reload();
}
function runUpdate(){
	console.log("run put");
	makeAjaxPut(putUrl, newExpense);
	window.location.reload();
}
function runDelete(){
	console.log("run delete");
	makeAjaxDelete(deleteUrl, newExpense);
	window.location.reload();
}
 
function makeAjaxPut(url, newExpense){
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 204){
			console.log(xhr.response);
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	console.log(newExpense);
	updateExpense();
//	console.log(newExpense);
//	console.log(userArray);
//	console.log(expenseArray);
	let jsonExpense = JSON.stringify(newExpense);
	xhr.send(jsonExpense);
//	getValues();
}

function makeAjaxDelete(url, newExpense){
	let xhr = new XMLHttpRequest();
	xhr.open("DELETE", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 204){
			console.log(xhr.response);
		}
	}
	xhr.setRequestHeader("Content-Type", "application/json");
	deleteExpense();
	let jsonExpense = JSON.stringify(newExpense);
	xhr.send(jsonExpense);
}

