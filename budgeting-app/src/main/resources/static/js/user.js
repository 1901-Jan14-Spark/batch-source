window.onload = function () {
	grabUsers();
}


//variables initialized
const categoryURL = "http://localhost:9595/user/all/top";
const getUserUrl = "http://localhost:9595/user/all";;


////////////////////////AJAX Request /////////////////////////////
const sendAjaxGet = (url, callback) => {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);

	xhr.onreadystatechange = function () {
		if (this.readyState === 4 && this.status === 200) {
			callback(this);
		}
	}
	xhr.send();
}

const sendAjaxGet2 = (url, callback, info) => {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);

	xhr.onreadystatechange = function () {
		if (this.readyState === 4 && this.status === 200) {
			callback(this, info);
		}
	}
	xhr.send();
}

const grabUsers = () => {
	sendAjaxGet(getUserUrl, displayUsers);
}

const displayUsers = (xhr) => {
	let data = JSON.parse(xhr.response);
	sendAjaxGet2(categoryURL, addUserTop, data);
}

const addUserTop = (xhr, allUser) => {
	let data = JSON.parse(xhr.response);
//	console.log(data)
	let myRe = /^[^\d]*(\d+)/;

	for (j = 0; j < allUser.length; j++) {
		for (i = 0; i < Object.size(data); i++) {
			let idOfUser = myRe.exec(Object.entries(data)[i][0])[1];

			if (idOfUser == allUser[j].id) {
				addUserRow(allUser[j].id, allUser[j].firstName, allUser[j].lastName, Object.entries(data)[i][1]);
			}
		}
	}
}

Object.size = function (obj) {
	let size = 0,
	key;
	for (key in obj) {
		if (obj.hasOwnProperty(key)) size++;
	}
	return size;
};

const addUserRow = (id, firstName, lastName, category) => {
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");

	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);

	cell1.innerHTML = id;
	cell2.innerHTML = firstName;
	cell3.innerHTML = lastName;
	cell4.innerHTML = category;


	document.getElementById("userTableBody").appendChild(row);
}

//Toggle the side navigation
$("#sidebarToggle").on('click', function (e) {
	e.preventDefault();
	$("body").toggleClass("sidebar-toggled");
	$(".sidebar").toggleClass("toggled");
});