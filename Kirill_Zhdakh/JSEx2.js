//0 DONE
function fizzBuzz() {
    let arr = Array();
    for (i = 0; i < 100; ++i) {
        if (i % 3 == 0 && i % 5 == 0) {
            arr.push("FizzBuzz");
        }
        else if (i % 3 == 0) {
            arr.push("Fizz");
        }
        else if (i % 5 == 0 ){
            arr.push("Buzz");
        }
        else {
            arr.push(i);
        }
    }
    arr.join(", ");
    return arr.toString();
}
//1 DONE
function maxLength(arr) {
    if (arr.length == 0)
        return String("This array is empty.");

    let max = arr[0].length;
    let ind = 0;
    for (i = 0; i < arr.length; ++i) {
        if (max < arr[i].length) {
            max = arr[i].length;
            ind = i;
        }
    return ind;
}
//2 DONE
function reverseArray(arr) {
    let result = Array();
    for (let i = arr.length; i > 0; --i) {
        result.push(arr[i - 1]);
    }
    return result;
    }
//3 DONE
function vowelCount(str) {
    return str.match(/[aeiou]/g).length;
}
//4 DONE
function removeScript(str) {
    return str.replace(/Script/g, "");
    }
//5 DONE
function isLeapYear(date) {
    return (date.getFullYear() % 4 == 0) ? true : false;
    }
//6 DONE
function isValidEmail(str) {
    //Could be better, but I was wasting too much time on this
    return str.match(/^[a-zA-Z0-9._\-]{5,}@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/g);
}
//7 DONE
function removeChar(str, ind) {
    return str.replace(str[ind], "");
    }
//8 DONE
function bubbleSort(arr) {
    let swapped;
    do {
        swapped = false;
        for (let i = 0; i < arr.length; i++) {
            if (arr[i] && arr[i + 1] && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                swapped = true;
            }
        }
    } while (swapped);
    return arr;
    }
//9 DONE
function isPalindrome(str) {
    str = str.toLowerCase();
    let temp = reverseStr(str);
    return Boolean(str.match(temp));
}
//10 DONE
function printShape(shape, height, char) {
    switch (shape) {
        case "Square":
            {
                let str = "";
                let i;
                for (i = 0; i < height; ++i) {
                    str += appendCharsToStr(char, height, true);
                }
                console.log(str);
            }
            break;
        case "Triangle":
            {
                let str = "";
                let i;
                for (i = 0; i < height; ++i) {
                    str += appendCharsToStr(char, i + 1, true);
                }
                console.log(str);
            }
            break;
        case "Diamond":
            {
                if (height % 2 == 0) {
                    console.log("Diamond requires an odd height");
                    break;
                }
                let str = "";
                let i;
                let charAmount = 1;
                let maxSpace = Math.floor(height * 0.5);
                for (i = maxSpace; i > 0; --i) {
                    str += appendCharsToStr(' ', i, false);
                    str += appendCharsToStr(char, charAmount, true);
                    charAmount += 2;
                }
                str += appendCharsToStr(char, height, true);
                charAmount = height;
                for (i = 0; i < maxSpace + 1; ++i) {
                    str += appendCharsToStr(' ', i, false);
                    str += appendCharsToStr(char, charAmount, true);
                    charAmount -= 2;
                }
                console.log(str);
            }
            break;
        default:
            {
                console.log("Invalid shape");
            }
    }
    }
//11 DONE
function rotateArr(arr, count) {
    for (let i = 0; i < count; ++i) {
        let temp = arr.shift();
        arr.push(temp);
    }
    return arr;
}
//12 DONE
function matchBrackets(str) {
    let result = false;

    if (!str) {
        console.log("Empty string.")
        return result;
    }

    let charArr = Array();

    for (let i = 0; i < str.length; ++i) {
        charArr.push(str[i]);
    }

    while (charArr.length > 0) {
        let temp = charArr.shift();
        switch (temp) {
            case '(':
                {
                    if (charArr[0] == ')') {
                        result = true;
                        charArr.shift();
                    }
                    else if (charArr[charArr.length - 1] == ')') {
                        result = true;
                        charArr.pop();
                    }
                    else {
                        result = false;
                        charArr = "";
                    }
                }
                break;
            case '[':
                {
                    if (charArr[0] == ']') {
                        result = true;
                        charArr.shift();
                    }
                    else if (charArr[charArr.length - 1] == ']') {
                        result = true;
                        charArr.pop();
                    }
                    else {
                        result = false;
                        charArr = "";
                    }
                }
                break;
            case '{':
                {
                    if (charArr[0] == '}') {
                        result = true;
                        charArr.shift();
                    }
                    else if (charArr[charArr.length - 1] == '}') {
                        result = true;
                        charArr.pop();
                    }
                    else {
                        result = false;
                        charArr = "";
                    }
                }
                break;
            default:
                {
                    result = false;
                    charArr = "";
                }
                break;
        }
    }
    return result;
}



//helper funcs
function appendCharsToStr(char, size, lineBreak) {
    let str = "";
    let i;
    for (i = 0; i < size; ++i) {
        str += char;
    }
    if (lineBreak)
        str += '\n';
    return str;
}
function randArr(max, size) {
    let arr = Array();
    for (let i = 0; i < size; ++i) {
        arr.push(Math.round(Math.random() * Math.floor(max)));
    }
    return arr;
 }
function reverseStr(str) {
    let temp = "";
    for (let i = str.length; i > 0; --i) {
        temp += str[i - 1];
    }
    return temp;
}
function swap(arr, curr, next) {
    let temp = arr[curr];
    arr[curr] = arr[next];
    arr[next] = temp;
}