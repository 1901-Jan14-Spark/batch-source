// Exercise 0

function printUpTo100() {
    for (i = 1; i <= 100; i++) {
        if (i % 15 == 0) {
            console.log("FizzBuzz");
        }
        else if (i % 3 == 0) {
            console.log("Fizz");
        }
        else if (i % 5 == 0) {
            console.log("Buzz");
        }
        else if (i % 15 == 0) {
            console.log("FizzBuzz");
        }
        else {
            console.log(i);
        }
    }
}
// printUpTo100();

// Exercise 1
// let array = ["32rfwefwefwef23f", "1", "12", "123", "1234", "12345", "sdgbskjgbsrkdwfefejgskgbrkj"];

function maxLength(array) {
    if (!Array.isArray(array)) {
        return "This is not an Array.";
    }
    if (array.length == 0) {
        return "Array is empty.";
    }
    let longest = array[0];
    for (i = 1; i <= array.length - 1; i++) {
        if (array[i].length > longest.length) {
            longest = array[i];
        }
    }
    return longest;
}
// console.log(maxLength(array));

// Exercise 2
// let array = ["32rfwefwefwef23f", "1", "12", "123", "1234", "12345", "sdgbskjgbsrkdwfefejgskgbrkj"];
function reverseArray(array) {
    let reversedArray = new Array(array.length);
    for (i = 0; i < array.length; i++) {
        // reversedArray[array.length - (array.length-i)] = array[array.length - (1+i)];
        reversedArray[i] = array[array.length - (1 + i)];
    }
    return reversedArray;
}
// console.log(reverseArray(array));

// Exercise 3
// let word = "I'm a word.";
function vowelCount(word) {
    var vowelCounter = 0;
    for (i = 0; i < word.length; i++) {
        switch (word.charAt(i).toLowerCase()) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
            // "y" is a vowel!
                vowelCounter++;
                break;
            default:
                break;
        }
    }
    return vowelCounter;
}
//console.log(vowelCount(word));

//Exercise 4
// var string = "Helol dkfnslgnScript lksgn lsScriptsdlg nslkg";
function removeScript(string) {
    // var regex = /Script/gi;
    // return string.replace(regex, '');
    let wordIndex;
    let wordToRemove = "Script";
    while (string.includes(wordToRemove) == true) {
        wordIndex = string.indexOf(wordToRemove);
        string = string.substring(0, wordIndex) + string.substring(wordIndex + wordToRemove.length, string.length);
    }
    return string;

}
//console.log(removeScript(string));

//Exercise 5
// var date = new Date(1600, 2, 11);
function isLeapYear(date) {
    if(typeof(date) != typeof(Date))
        return "Invalid date format, try using a date Object.";
    if (date.getFullYear() % 4 == 0) {
        if (date.getFullYear() % 100 == 0 && date.getFullYear() % 400 != 0) {
            return false;
        }
        return true;
    }
    return false;
}
// console.log(isLeapYear(date));

// Exercise 6
// let myEmail = "kevin.tranhuu@gmail.com";
function isValidEmail(string) {
    var reg = /(.+)@(.+){2,}\.(.+){2,}/gi;
    return reg.test(string);
}

// console.log(isValidEmail(myEmail));

// Exercise 7
// var kelby = "Giod morning Kevin.";
function removeChar(string, index) {
    return string.substring(0, index) + string.substring(index + 1, string.length);
}
// console.log(removeChar(kelby,2));

// Exercise 8
// var myArray = [1, 35, 5, 65, 4, 7, 354, 5, -25];
// var notMyArray = "hello";

function bubbleSort(array) {
    if (!Array.isArray(array) || array.length < 2) {
        return "Invalid input";
    }
    for (i = 0; i < array.length; i++) {
        if (typeof (array[i]) != "number" || array[i] == NaN) {
            return "Invalid array input";
        }
    }
    let myTemp = array[0];
    let isOrdered;
    do {
        isOrdered = true;
        for (i = 1; i < array.length; i++) {
            if (myTemp > array[i]) {
                array[i - 1] = array[i];
                array[i] = myTemp;
                isOrdered = false;
            }
            myTemp = array[i];
        }
        myTemp = array[0];
    }while (!isOrdered)
    return array;
}
// console.log(bubbleSort(myArray));

// // Exercise 10
// var someStr = "Racecar";

function isPalindrome(someStr) {
    someStr = someStr.toLowerCase();
    // CaPiTaL LeTtErS DoN'T MaTtEr In PaLyNdRoMeS
    for (i = 0; i < someStr.length / 2; i++) {
        if (someStr[i] != someStr[someStr.length - (1 + i)]) {
            return false;
        }
    }
    return true;
}

// console.log(isPalindrome(someStr));

// Exercise 11

function printShape(shape, height, character) {
    switch (shape) {
        case "Square":
            var toBePrinted = "";
            for (i = 0; i < height; i++) {
                toBePrinted += character;
            }
            for (i = 0; i < height; i++) {
                console.log(toBePrinted);
            }
            break;
        case "Triangle":
            var toBePrinted;
            for (i = 1; i <= height; i++) {
                toBePrinted = "";
                for (j = 0; j < i; j++) {
                    toBePrinted += character;
                }
                console.log(toBePrinted);
            }
            break;
        case "Diamond":
            if (height % 2 == 0) {
                console.log("Please enter an odd number for the height using a diamond shape.");
                break;
            }
            var toBePrinted = "";
            for (i = 0; i < height / 2; i++) {
                for (j = 1; j < height / 2 - i; j++) {
                    toBePrinted += " ";
                }
                for (j = 0; j < i * 2 + 1; j++) {
                    toBePrinted += character;
                }
                console.log(toBePrinted);
                toBePrinted = "";
            }
            for (i = 0; i < (height - 1) / 2; i++) {
                for (j = 0; j < i + 1; j++) {
                    toBePrinted += " ";
                }
                for (j = 0; j < height - 2 * (i + 1); j++) {
                    toBePrinted += character;
                }
                console.log(toBePrinted);
                toBePrinted = "";
            }
            // for (i = 0; i < height; i++) {
            //     for (j = 1; j <= height; j++) {
            //         if (i < height / 2) {
            //             if (j < ((height / 2) + 0.5 - i) || j > ((height / 2) + 0.5 + i)) {
            //                 toBePrinted += " ";
            //             } else {
            //                 toBePrinted += character;
            //             }
            //         } else {
            //             if (j < ((height / 2) + 0.5 - i) || j > ((height / 2) + 0.5 + i)) {
            //                 toBePrinted += " ";
            //             } else {
            //                 toBePrinted += character;
            //             }
            //         }
            //     }
            //     console.log(toBePrinted);
            //     toBePrinted = "";
            // }
            break;
        default:
            console.log("Shape not recognized. Please select between Diamond, Triangle, and Square.")
            break;
    }
}
// printShape("Diamond", 5, "c");

// Exercise 12

// let myArray1 = [1, 2, 3, 4, 5, 6, 7, 8];
function rotate(array, n) {
    let shift = n % array.length;
    let newArray1 = new Array(array.length);
    for (i = 0; i < array.length; i++) {
        if (i + shift < array.length) {
            newArray1[i] = array[i + shift];
        } else {
            newArray1[i] = array[(i + shift) % array.length];
        }
    }
    return newArray1;
}

// console.log(rotate(myArray1,12));

// Exercise 13
// let myString = "(()())";
function balanced(string) {
    if (string.length % 2 != 0) {
        return false;
    }
    for (i = 0; i < string.length / 2; i++) {
        switch (string[i]) {
            case "{":
                if (string.charAt(string.length - i - 1) == "}") {
                    continue;
                }
                else {
                    return false;
                }
            case "[":
                if (string.charAt(string.length - i - 1) == "]") {
                    continue;
                }
                else {
                    return false;
                }
            case "(":
                if (string.charAt(string.length - i -1) == ")") {
                    continue;
                }
                else {
                    return false;
                }
                case "}":
                if (string.charAt(string.length - i - 1) == "{") {
                    continue;
                }
                else {
                    return false;
                }
            case "]":
                if (string.charAt(string.length - i - 1) == "[") {
                    continue;
                }
                else {
                    return false;
                }
            case ")":
                if (string.charAt(string.length - i -1) == "(") {
                    continue;
                }
                else {
                    return false;
                }
            default:
                return false;
        }
    }
    return true;
}
// console.log(balanced(myString));



