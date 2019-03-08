function Person(){
    
    let name;
    let age;

    this.getAge = function(){
        return age;
    }

    this.setAge = function(ageInput){
        age = ageInput;
    }

    this.getName = function(){
        return name;
    }

    this.setName = function(nameInput){
        name = nameInput;
    }

}


function Employee(){

    let isWorking;

    this.getIsWorking = function(){
        return isWorking;
    }

    this.setIsWorking = function(isWorkingInput){
        isWorking = isWorkingInput;
    }

    this.__proto__ = new Person();

}