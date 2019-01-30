console.log("hello world");

const x = 7;
if(x > 10) {
    console.log("x is greater than 10");
} else {
    console.log("x is equal to or less than 10");
}

for(i = 0; i < 4; i++) {
    console.log("greetings");
}

let counter = 0;
while (counter < 4) {
    console.log("greetings");
    counter++;
}

const color = "orange";
switch (color) {
    case "orange":
        console.log("yellow and red");
        break;
    case "green":
        console.log("blue and yellow");
        break;
    case "purple":
        console.log("red and blue");
        break;
    default:
        console.log("color not found");
        break;
}

const printNums = () => {
    for(i = 1; i <= 10; i++) {
        console.log(i);
    }
}

printNums();

const printUpTotal = (num) => {
    for(i = 1; i < num; i++) {
        console.log(i);
    }
}

printUpTotal(5);

const printRange = (num1, num2) => {
    if(num1 < num2) {
        for(i = num1; i < num2; i++) {
            console.log(i);
        }
    } else {
        for(i = num2; i < num1; i++) {
            console.log(i);
        }
    }
}

printRange(6, 1);

const printString = (str, num) => {
    myStr = "";
    for(i = 0; i < num; i++) {
        myStr += str;
    }
    return myStr;
}

console.log(printString("hello ", 5));
