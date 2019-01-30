// console.log("Hello world");

// console.log(Boolean(-1));

// create an object
let sandwich = {
    breadType: "grain",
    cheeseType: "American",
    meatType: "roast beef",
    hasMayo: true,
    size: 6
}

// console.log("Eating my sandwich. It has " + sandwich['meatType'] + " and " + sandwich['cheeseType'] + " cheese.");

let myObj = {
    0: null,
    1: "hello",
    2: true,
    3: 25
}

// using a dynamic for loop, or a for/in loop with an array

// const myArr = [1,true,"five", null]

// using a for/of with array
// for(i of myArr) {
//     console.log(i);
// }

// for(i in myObj) {
//     console.log(i + ": " + myObj[i]);
// }

// for(i of myObj) {
//     console.log(i);
// }

// for(i of sandwich) {
//     console.log(i);
// }

// var x = 5;
// var x = 6;

// let y = 10;
// y = 12;

// block scope example: var vs let

// var pass = false;
// var score = 80;
// if(score > 75) {
//     var pass = true;
// }
// console.log(pass);

// let pass = false;
// const score = 80;
// if(score>75) {
//     pass = true;
//     console.log("inside the block scope " + pass);
// }

// console.log("outside the block scope " + pass);

// let myVar = 10;
// function myFunc() {
//     let myVar = 12;
//     console.log("inside the block scope " + myVar);
// }

// myFunc();
// console.log("out the block scope " + myVar); 

// const z = 10;

// const mySandwich = {
//     breadType: "grain",
//     cheeseType: "American",
//     meatType: "roast beef",
//     hasMayo: true,
//     size: 6
// }

// mySandwich.breadType = 5;
// console.log(mySandwich);

//// functions and arguments

// function printAll(a,b,c) {
//     console.log(a);
//     console.log(b);
//     console.log(c);
//     return "function completed"
// }

// printAll(2,null,3);

function printAllAgain() {
    for(i of arguments) {
        console.log(i);
    }
}

printAllAgain(true, "green", 100);