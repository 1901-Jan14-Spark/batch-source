//closures take advantage of scoping to make variables inaccessible to other
//segments of code
//functions have access to the global scope
//functions have access to the scope above them
//you are allowed to use nested functions in JS


//The following is making a counter without using closures
// var counter = 0;

//Function to incriment the coutner
// function add(){
//     counter += 1;
// }

// add()
// add()
// add()
// console.log(counter)
// counter =3
// this counter works... but there is a problem...sometimes
// sometimes you do not want all other segments of code to have access
// to the counter

//the way that you could fix this is by using closures!








//Function to incriment the coutner
// function add(){
//     var counter = 0;
//     counter += 1;
//     return counter;
// }

// add()
// add()
// console.log(add())
// the code above also doesn't work. it returns 1, when 3 is desired



// function add(){
//     var counter = 0;
//     function plus() {coutner += 1;}
//     puls();
//     return coutner;
// }
// this... almost works... the only issue is that the plus() function cannot be 
// reached from the outside

//now let's acutally use closures
var add = (function(){
    var counter = 0;
    return function() {counter += 1; return counter}
})()

add()
add()
console.log(add())

// the variable add is assigned to the return values of a self-invokeing function
// the self-invoking function only runs once. it sets the counter to 0
// and it returns a function expression
// this way add becomes a function. It can access the counter in the scope above.
// this access to the higher scope is what a closure is. kind of like "private"
// variables. the counter is protected by the scope of the anonymous function
// it can only be changed using the add() function.