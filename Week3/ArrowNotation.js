//ES5. this is the "normal" way of writing funcitons
// var x = function(x,y){
//     return x*y;
// }
// // z = x(3,4)

//ES6 below, is a funciton written using arrow notation
// arrow notation is a short syntax for writing funciton expressions
//you don't need 'funciton' keyword or 'return' keyword
// 1. declaration
// 2. parameters
// 3. statements
// const a = (x,y) => x*y;
// console.log(a(3,6))

// (parameters) => {statements}
// you can have arrow functions with any number of parameters
// if you only have one you can actually omit the ()
// if you do not want to return something, then you can enclose the statemetns on the
// right side in curly braces.
const b = x => {x+5};
console.log(b(3))