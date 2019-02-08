window.onload = function () {
	createOnStartUp();
}


// variables initialized
const getAllUrl = "http://localhost:9595/expense/all";
const getUserUrl = "http://localhost:9595/user/all";
const getMinUrl = "http://localhost:9595/expense/min";
const getMaxUrl = "http://localhost:9595/expense/max";
const getAvgUrl = "http://localhost:9595/expense/avg";
const getMedianUrl = "http://localhost:9595/expense/median";
const getSumUrl = "http://localhost:9595/expense/sum";
const expenseUrl = "http://localhost:9595/expense";
const minValHolder = document.getElementById("min_value");
const maxValHolder = document.getElementById("max_value");
const avgValHolder = document.getElementById("avg_value");
const medianValHolder = document.getElementById("median_value");
const sumValHolder = document.getElementById("sum_value");
const addBtn = document.getElementById("add_btn");
const updateBtn = document.getElementById("update_btn");
const deleteBtn = document.getElementById("delete_btn")
const id = document.getElementById("id");
const category = document.getElementById("category");
const cost = document.getElementById("cost");
const merchant = document.getElementById("merchant");
const userId = document.getElementById("user_id");
const deleteId = document.getElementById("deleteId");
const updateId = document.getElementById("updateId");
const updateCategory = document.getElementById("updateCategory");
const updateCost = document.getElementById("updateCost");
const updateMerchant = document.getElementById("updateMerchant");
const userList = document.getElementById("inputUser");
const userList2 = document.getElementById("inputUser2");
const expensesList = document.getElementById("merchantTable");
const styleChooseUser = document.getElementById("chooseUser");


//////////////////////// AJAX Request /////////////////////////////
const ajaxGET = (url) => {
	let XHR = new XMLHttpRequest();
	XHR.onreadystatechange = function () {
		if (XHR.readyState == 4 && XHR.status == 200) {
			let data = JSON.parse(XHR.response);
			//			console.log(data);
			for (user of data) {
				addMerchantRow(user.id, user.merchant, user.category, user.cost, user.user.firstName + " " + user.user.lastName);
			}
		}
	}
	XHR.open("GET", url, true);
	XHR.send();
}

//const ajaxGETUSER = (url) => {
//	let XHR = new XMLHttpRequest();
//	XHR.onreadystatechange = function () {
//		if (XHR.readyState == 4 && XHR.status == 200) {
//			let data = JSON.parse(XHR.response);
//			console.log(data);
//		}
//	}
//	XHR.open("GET", url, true);
//	XHR.send();
//}

const ajaxGETTypeValue = (url, typeHolder) => {
	let XHR = new XMLHttpRequest();
	XHR.onreadystatechange = function () {
		if (XHR.readyState == 4 && XHR.status == 200) {
			let data = JSON.parse(XHR.response);
			//			console.log(data);
			data = (data).toFixed(2);
			typeHolder.append(data);
		}
	}
	XHR.open("GET", url, true);
	XHR.send();
}

const ajaxGetUserList = (url) => {
	let XHR = new XMLHttpRequest();
	XHR.onreadystatechange = function () {
		if (XHR.readyState == 4 && XHR.status == 200) {
			let data = JSON.parse(XHR.response);
			for (user of data) {
				addUserList(user.id + ": " + user.firstName + " " + user.lastName);
			}
		}
	}
	XHR.open("GET", url, true);
	XHR.send();
}

const ajaxGetUserList2 = (url) => {
	let XHR = new XMLHttpRequest();
	XHR.onreadystatechange = function () {
		if (XHR.readyState == 4 && XHR.status == 200) {
			let data = JSON.parse(XHR.response);
			for (user of data) {
				addUserList2(user.id + ": " + user.firstName + " " + user.lastName);
			}
		}
	}
	XHR.open("GET", url, true);
	XHR.send();
}

const ajaxPOST = (url, newUserObject) => {
	let XHR = new XMLHttpRequest();
	XHR.onreadystatechange = function () {
		if (XHR.readyState == 4 && XHR.status == 201) {
			//        	console.log(XHR.response);   
		} else {
			console.log(XHR.response);
		}
	}
	XHR.open("POST", url);
	XHR.setRequestHeader('Content-type', 'application/json');
	let jsonUser = JSON.stringify(newUserObject);
	XHR.send(jsonUser);
}

const ajaxPUT = (url, newUserObject) => {
	let XHR = new XMLHttpRequest();
	XHR.onreadystatechange = function () {
		if (XHR.readyState == 4 && XHR.status == 204) {
			//        	console.log(XHR.response);   
		} else {
			console.log(XHR.response);
		}
	}
	XHR.open("PUT", url);
	XHR.setRequestHeader('Content-type', 'application/json');
	let jsonUser = JSON.stringify(newUserObject);
	XHR.send(jsonUser);
}

const ajaxDELETE = (url, newUserObject) => {
	let XHR = new XMLHttpRequest();
	XHR.onreadystatechange = function () {
		if (XHR.readyState == 4 && XHR.status == 204) {
			//        	console.log(XHR.response);   
		} else {
			console.log(XHR.response);
		}
	}
	XHR.open("DELETE", url);
	XHR.setRequestHeader('Content-type', 'application/json');
	let jsonUser = JSON.stringify(newUserObject);
	XHR.send(jsonUser);
}

// AJAX functions
const addExpense = () => {
	let collection = userList.selectedOptions;
	let output = "";
	let incId = 0;

	for (let i = 0; i < collection.length; i++) {
		output += collection[i].label;
		output = parseInt(output.split(" ").slice(0, 2));

		incId = parseInt(expensesList.rows.length);
	}

	let newExpense = {};
	newExpense.id = incId;
	newExpense.merchant = merchant.value;
	newExpense.category = category.value;
	newExpense.cost = cost.value;
	newExpense.user = {
		firstName: null,
		id: output,
		lastName: null
	}
	console.log(newExpense)
	ajaxPOST(expenseUrl, newExpense);
	refreshPage();
}

const updateExpense = () => {
	let collection = userList2.selectedOptions;
	let output = "";

	for (let i = 0; i < collection.length; i++) {
		output += collection[i].label;
		output = parseInt(output.split(" ").slice(0, 2));
	}

	let newExpense = {};
	newExpense.id = updateId.value;
	newExpense.merchant = updateMerchant.value;
	newExpense.category = updateCategory.value;
	newExpense.cost = updateCost.value;
	newExpense.user = {
		firstName: null,
		id: output,
		lastName: null
	}
	console.log(newExpense)
	ajaxPUT(expenseUrl, newExpense);
	refreshPage();
}

const deleteExpense = () => {
	let newExpense = {};
	newExpense.id = deleteId.value;
	newExpense.merchant = "string";
	newExpense.category = "string";
	newExpense.cost = 0;
	newExpense.user = {
		firstName: null,
		id: 1,
		lastName: null
	}
	console.log(newExpense)
	ajaxDELETE(expenseUrl, newExpense);
	refreshPage();
}

// global functions
const createOnStartUp = () => {
	ajaxGET(getAllUrl);
	//	ajaxGETUSER(getUserUrl);
	ajaxGETTypeValue(getMinUrl, minValHolder);
	ajaxGETTypeValue(getMaxUrl, maxValHolder);
	ajaxGETTypeValue(getAvgUrl, avgValHolder);
	ajaxGETTypeValue(getMedianUrl, medianValHolder);
	ajaxGETTypeValue(getSumUrl, sumValHolder);
	ajaxGetUserList(getUserUrl);
	ajaxGetUserList2(getUserUrl);
	addBtn.addEventListener("click", addExpense);
	updateBtn.addEventListener("click", updateExpense);
	deleteBtn.addEventListener("click", deleteExpense);
}

const addMerchantRow = (id, merchant, category, cost, name, userId) => {
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");

	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);

	cell1.innerHTML = id;
	cell2.innerHTML = merchant;
	cell3.innerHTML = category;
	cell4.innerHTML = cost;
	cell5.innerHTML = name;

	document.getElementById("merchantTableBody").appendChild(row);
}

const addUserList = (idAndName) => {
	let option = document.createElement("option");

	option.innerHTML = idAndName;

	option.setAttribute("id", "option_id");

	document.getElementById("inputUser").appendChild(option);
}

const addUserList2 = (idAndName) => {
	let option = document.createElement("option");

	option.innerHTML = idAndName;

	option.setAttribute("id", "option_id2");

	document.getElementById("inputUser2").appendChild(option);
}

const refreshPage = () => {
	setTimeout(function () {
		window.location.reload(true)
	}, 0)
}

// Toggle the side navigation
$("#sidebarToggle").on('click', function(e) {
  e.preventDefault();
  $("body").toggleClass("sidebar-toggled");
  $(".sidebar").toggleClass("toggled");
});