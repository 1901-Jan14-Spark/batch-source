// for(i = 1; i < 101; i++) {
//     if((i % 3 == 0) && (i % 5 == 0)) {
//         console.log("FizzBuzz");
//     } else if (i % 3 == 0) {
//         console.log("Fizz");
//     } else if (i % 5 == 0) {
//         console.log("Buzz");
//     } else {
//         console.log(i);
//     }
// }


const myVar = ["yes", "hi", "no", "computer"];
const maxLength = (arr) => {
    return arr.reduce(function (a, b) {
        return a.length > b.length ? a : b;
    })
}
// console.log(maxLength(myVar));


const numArray = [1, 5, 3, 23, 3];
const maxNun = (arr) => {
    return arr.reduce(function (a, b) {
        return Math.max(a, b);
    })
}
// console.log(maxNun(numArray));

const myReverseArr = ["yes", "hi", "no", "computer"];
const reverseArray = (arr) => {
    return arr.reverse();
}
// console.log(reverseArray(myReverseArr));

const myReverseArr2 = ["yes", "hi", "no", "computer"];
const reverseArray2 = (arr) => {
    let myArr = [];
    for (i = arr.length - 1; i >= 0; i--) {
        myArr.push(arr[i]);
    }
    return myArr;
}
// console.log(reverseArray2(myReverseArr2));


const vowelCount = (str) => {
    let regex = /[aeiou]/g;
    let found = str.match(regex);
    return found.length;
}
// console.log(vowelCount("hello world"));
// console.log(vowelCount("apple"));


const removeScript = (str) => {
    return str.replace("Script", "");
}
// console.log(removeScript("<Script src='cat.png'>"));


const isLeapYear = (year) => {
    return (year % 4 == 0) || (year % 100 != 0 && year % 400 == 0);
}
// console.log(isLeapYear(2024));

const isLeapYear2 = (date) => {
    return new Date(date, 1, 29).getDate() === 29;
}
// console.log(isLeapYear2(1003));
// console.log(isLeapYear2(1004));


const isValidEmail = (str) => {
    const regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(str);
}
// console.log(isValidEmail("Dat@gmail.com"));
// console.log(isValidEmail("Datgmail.com"));


const removeChar = (str, i) => {
    let myStr = str.slice(i, str.length);
    let myStr2 = str.slice(0, i - 1)
    return myStr2 + myStr;
}
// console.log(removeChar("chocolate", 4));

const removeChar2 = (str, i) => {
    return str.replace(str[i], "");
}
// console.log(removeChar2("chocolate", 1));


const myArr = [9, 2, 5, 6, 4, 3, 7, 10, 1, 8];
const swap = (arr, i, j) => {
    let temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

const bubbleSort = (arr) => {
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length; j++) {
            if (arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
            }
        }
    }
    return arr;
}
// console.log(bubbleSort(myArr.slice()));


const isPalindrome = (str) => {
    return str == str.split('').reverse().join('');
}
// console.log(isPalindrome("racecar"));


const isPalindrome2 = (str) => {
    myStr = "";
    for (let i = str.length - 1; i > -1; i--) {
        myStr += str[i];
        // console.log(myStr);
    }
    return str == myStr;
}
// console.log(isPalindrome2("racecar"));
// console.log(isPalindrome2("cat"));


const printShape = (shape, height, character) => {
    switch (shape) {
        case "Square":
            for (let i = 1; i <= height; i++) {
                let square = "";
                for (j = 1; j <= height; j++) {
                    square += character;
                }
                console.log(square);
            }
            break;
        case "Triangle":
            for (let i = 1; i <= height; i++) {
                let triangle = "";
                for (j = 1; j <= i; j++) {
                    triangle += character;
                }
                console.log(triangle);
            }
            break;
        case "Diamond":
            let diamond = "";
            for (i = 1; i < height - 1; i++) {
                let space = "";
                for (j = 0; j < height / 2 + 1 - i; j++) {
                    space += " ";
                }
                diamond += character.repeat(i);
                console.log(space + diamond);
            }
            for (i = height; i > height / 2 + 1; i--) {
                space = " ";
                for (j = -1; j < height - i; j++) {
                    space += " ";
                }
                diamond = diamond.slice(0, -3);
                if (diamond <= 1) {
                    diamond = character;
                }
                console.log(space + diamond);
            }
            break;
        default:
            console.log("Invalid shape request");
            break;
    }
}
// printShape("Square", 3, "$");
// printShape("Triangle", 5, "$");
// printShape("Diamond", 5, "$");


const myArr2 = [1, 2, 3, 4, 5];

function rotate(arr, n) {
    return arr.concat(arr.splice(0, n));
}
// console.log(rotate(myArr2, 4));


const balance = (str) => {
    let i;
    let result = [];

    for (i = 0; i < str.length; i++) {
        if (isBalanced(str[i])) {
            return true;
        } else {
            return false;
        }
    }
    return result;
}
const isBalanced = (str) => {
    let i, ch;
    let bracketsMap = new Map();
    bracketsMap.set(']', '[');
    bracketsMap.set('}', '{');
    bracketsMap.set(')', '(');
    // Use the spread operator to transform a map into a 2D key-value Array.
    let closingBrackets = [...bracketsMap.keys()];
    let openingBrackets = [...bracketsMap.values()];
    let temp = [];
    for (i = 0; i < str.length; i++) {
        ch = str[i];
        if (openingBrackets.indexOf(ch) > -1) {
            temp.push(ch);
        } else if (closingBrackets.indexOf(ch) > -1) {
            let expectedBracket = bracketsMap.get(ch);
            if (temp.length === 0 || (temp.pop() !== expectedBracket)) {
                return false;
            }
        } else {
            continue;
        }
    }
    return (temp.length === 0);
}
const test1 = [
    "()",
    "()()",
    "(())",
    "({[]})"
];

const test2 = [
    "(",
    "(()",
    "([)]",
];

// console.log(balance(test1));
// console.log(balance(test2));