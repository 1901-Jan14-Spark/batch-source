/**
 * 
 */

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(this.readState===4 && this.status===200){
			callback(this)
		}
	}
	xhr.open("GET",url);
	xhr.send();
}