function ajaxReq(command,extension,callback,body){//Ajax request that handles all instances of AJAX
    let url ="http://localhost:9595" + extension;
    let xhr = new XMLHttpRequest();
    xhr.open(command,url);
    xhr.onreadystatechange=function(){
        if(this.readyState==4 && this.status == 200){
            callback(xhr);
            return;
        }
        if(this.readyState==4 && (this.status == 201 || this.status==204)){
            callback(xhr);
            return;
        }
        if(this.readyState==4){//This line could be better, but it gets the job done in the current context
            callback(xhr)
        }
    }
    if(command != "GET"){
        xhr.setRequestHeader("Content-type", "application/json")
        let message = JSON.stringify(body);
        xhr.send(message);
    }else
        xhr.send();
}