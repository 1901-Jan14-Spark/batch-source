///////////////////////////////////////////
// getting started 
///////////////////////////////////////////

// console.log("JavaScript is working!")

// // casting to a boolean will show us our falsy values
// console.log(Boolean(0));
// console.log(Boolean());
// console.log(Boolean(""));
// console.log(Boolean(false));
// console.log(Boolean(null));
// console.log(Boolean("seven"*7));
// console.log(Boolean(9)); // this will print true


///////////////////////////////////////////
// working with objects and methods
///////////////////////////////////////////

// create an object 
let sandwich = { 
    breadType: "wheat", 
    cheeseType: "American",
    meatType: "roast beef",
    hasMayo: true,
    size: 6,
    eaten: function(){
        console.log("yum");
        return "yum";
    }
}

// console.log("Eating my sandwich. It has "+sandwich.meatType+" and "+sandwich.cheeseType+" cheese.")

// console.log("Eating my sandwich. It has "+sandwich["meatType"]+" and "+sandwich["cheeseType"]+" cheese.")

///////////////////////////////////////////
// Objects and Arrays, for/in and for/of
///////////////////////////////////////////

let myObj = {
    0: null,
    1: "hello",
    2: true,
    3: 25
}

let myArr = [null, "hello", true, 25];

//iterate over an array, printing each index and value 
// for(i=0;i<myArr.length;i++){
//     console.log(i+": "+myArr[i]);
// }

// // using a dynamic for loop, or a for/in loop with an array
// for(i in myArr){
//     console.log(i+": "+myArr[i]);
// }

// // using a for/of with an array
// for(i of myArr){
//     console.log(i);
// }

// // a for/in loop works just fine with objects
// for(i in myObj){
//     console.log(i+": "+myObj[i]);
// }

// // however, objects unlike arrays are not iterables and cannot use for/of objects 
// for(i of myObj){
//     console.log(i);
// }
// for(i of sandwich){
//     console.log(i);
// }

///////////////////////////////////////////
// var, let, and const
///////////////////////////////////////////

var x = 5;
var x = 6;
// same as 
var x = 5;
x = 6;

let y = 10;
//let y = 12;
y = 12;

// var vs let in block scope

// var pass = false;
// var score = 80;
// if(score>75){
//     var pass = true;
// }

// console.log(pass);

// we see with let that re-declaring a variable within a block scope means that we're treating it like a whole new variable
// let pass = false;
// let score = 80;
// if(score>75){
//     let pass = true;
//     console.log("in my block: " + pass)
// }

// console.log("outside my block: " + pass)

// let myVar = 10;
// function myFunction(){
//     let myVar = 12;
//     console.log(myVar);
// }
// myFunction();
// console.log(myVar);

const z = 10;
// z = 12;

const mySandwich = { 
    breadType: "wheat", 
    cheeseType: "American",
    meatType: "roast beef",
    hasMayo: true,
    size: 6,
    eaten: function(){
        console.log("yum");
        return "yum";
    }
}
// mySandwich = { 
//     breadType: "white", 
//     cheeseType: "American",
//     meatType: "roast beef",
//     hasMayo: true,
//     size: 6,
//     eaten: function(){
//         console.log("yum");
//         return "yum";
//     }
// }

// I cannot reassign my const (can't reassign my sandwich itself), but I can reassign properties within my sandwich object 
mySandwich.breadType = 5;
// console.log(mySandwich)



///////////////////////////////////////////
// functions and arguments 
///////////////////////////////////////////

function printAll(a,b,c){
    console.log(a);
    console.log(b);
    console.log(c);
    return "function completed";
}

// any additional arguments will not cause an issue 
// any argument which is not provided will be undefined
function printAllAgain(){
    for(i of arguments){
        console.log(i);
    }
    return "function completed";
}

// printAllAgain = function(){}


