// Problem 1: Create a function "isWeekday" which takes a single argument and returns true if the argument is a day during the work week. It should return false if it is not.

function isWeekday(str) {
    day = str.trim().toLowerCase();
    switch (day) {
        case "monday":
            return true;
            break;
        case "tuesday":
            return true;
            break;
        case "wednesday":
            return true;
            break;
        case "thursday":
            return true;
            break;
        case "friday":
            return true;
            break;
        default:
            return false;
            break;
    }
}

// Switch case fall out. Happen when you forget to add a break statement.

// console.log(isWeekday("FrIDAY"));
// console.log(isWeekday("Fr  I  DAY"));


// Problem 2: Create a function "isEven" which takes a single argument and returns true if the argument is an even integer. It should return false if it is not

function isEven(num) {
    return num % 2 == 0;
}

console.log(isEven(5));

// Problem 3: Write a JavaScript function which takes a single argument and returns the type

function findType(input) {
    return typeof(input);
}

// console.log(findType(5))
// console.log(findType(false))
// console.log(findType("hello world"))

// Problem 4: Write a JavaScript function which takes a single argument and determines if it's prime. If it is, return true. If it's not return false.

function isPrime(num) {
    if (num == 1 || num == 2) {
        return true;
    } else {
        for (let i = 2; i < num; i++) {
            if (num % i === 0) {
                return false;
            }
            return num !== 1 && num !== 0;
        }
    }
}

// console.log(isPrime(8));

// Problem 5: Write a JavaScript function which calculates the first number to the power of the second number. Do not do this recursively.

// function calculateExponent(base, exponent) {
//     if (base == 1) {
//         return 1;
//     } else {
//         return Math.pow(base, exponent)
//     }
// }

// function calculateExponent(base, exponent){
//     if(exponent === 0){
//         return 1;
//     }
//     var value = base;
//     while(exponent - 1 > 0){
//         -- exponent;
//         value *= base;
//     }
//     return value;
//  }

// function calculateExponent(base, exponent) {
//     let counter = 1;
//     if (base == 1) {
//         return 1;
//     }
//     for(i = 0; i < exponent; i++) {
//         counter *= base;
//     }
//     return counter;
// }

function calculateExponent(base, exponent) {
    if(exponent == 0) {
        return 1;
    }
    let x = base;
    for(i = 0; i < exponent; i++) {
        x*= base;
    }
    return x;
}

function calculateExponent(base, exponent) {
    return base ** exponent;
}

console.log(calculateExponent(2, 3));


// Problem 6: Write a JavaScript function which calculates the first number to the power of the second number. Do this recursively.

// function calculateExponent2(base, exponent) {
//     if(exponent == 0) {`
//         return 1;
//     } else {
//         return base * calculateExponent(base, exponent - 1);
//     }
// }

function calculateExponent2(base, exponent) {
    return base * calculateExponent(base, exponent - 1);
}

console.log(calculateExponent2(2, 3));

// Problem 7: Write a JavaScript function which calculates the area of a

function calculateArea(a) {
    return a * a;
}

// console.log(calculateArea(8));

base *= num;
base = base * num;