//in JavaScript, a variable can be declared after it has been used
// in other words... a variable can be used before it has been declared

// x=5;
// var x;

//======
// during hoisting, all declarations asre moved to the top of the scope (using var)
//let and const are not hoisted
// {
//     x=7;
// }
// x = x +10
// console.log(x)

num = 4;

var num = 25;
num = num + 4;
console.log(num)

for (var i = 0; i < 3; ++i){
    var num = num+1
}
console.log(num)
