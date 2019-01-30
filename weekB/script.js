// Define x,y, and z

let x = "0" && ""; // ""  does not
let y = 25 || null; // 25  short circuit
let z = (0 && false) || ((5*"cat")|| 25)  // does not 25

// Bonus: How would you implement a function which took a number array and return the max value?