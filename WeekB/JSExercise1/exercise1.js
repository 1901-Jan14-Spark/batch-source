// Problem 1: Create a function "isWeekday" which takes a single argument and returns true if the argument is a day during the work week. It should return false if it is not.

function isWeekday(input){
    switch(input){
      case "Monday":  
      case "Tuesday":
      case "Wednesday":
      case "Thursday":
      case "Friday":
        return true;
      default:
        return false;
    } 
}

// Problem 2: Create a function "isEven" which takes a single argument and returns true if the argument is an even integer. It should return false if it is not

function isEven(input){
    return (input%2==0)?true:false;
}

// Problem 3: Write a JavaScript function which takes a single argument and returns the type

function findType(input){
    return typeof input;
}

// Problem 4: Write a JavaScript function which takes a single argument and determines if it's prime. If it is, return true. If it's not return false.

function isPrime(input){
    if(input===1){
        return false;
    }
    for(let i=2;i<=Math.sqrt(input);i++){
        if(input%i===0){
            return false;
        }
    }
    return true;
}

// Problem 5: Write a JavaScript function which calculates the first number to the power of the second number. Do not do this recursively. Do not use the Math library.

function calculateExponent(base, exponent){
    let product = 1;
    for(i=0;i<exponent;i++){
        product *= base;
    }
    return product;
}


// Problem 6: Write a JavaScript function which calculates the first number to the power of the second number. Do this recursively.

function calculateExponent2(base, exponent){
    if(exponent==0){
        return 1;
    } else if (exponent==1){
        return base;
    } else {
        return base*calculateExponent2(base,exponent-1);
    }
}