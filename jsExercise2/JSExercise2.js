//Problem 0
console.log("Call fizzBuzz()");
function fizzBuzz()
{
    for(i=1;i<=100;i++)
    {
        var output = "";
        if(i%3 === 0)
            output = output + "Fizz";

        if(i%5 === 0)
            output = output + "Buzz";

        if((i%3 === 0) || (i%5 === 0))
            console.log(output);

        else
            console.log(i);
    }
    return "fizzBuzz function complete.";
}


//Problem 1
console.log("Call maxLength([array here])");
function maxLength(array)
{
    var longestStrInd = 0;
    for(i=0;i<array.length;i++)
    {
        if(array[i].length > array[longestStrInd].length)
        {
            longestStrInd = i;
        }
    }
    return "Index: " + longestStrInd;
}


//Problem 2 brute force this
console.log("Call reverseArray([array here])");
function reverseArray(array)
{
    var half = Math.floor(array.length/2);
    console.log("half: " + half);
    var temp;
    for(i=0;i<half;i++)
    {
        temp = array[i];
        array[i] = array[(array.length-1)-i];
        array[(array.length-1)-i] = temp;
    }
    return array;
}


//Problem 3
console.log("Call vowelCount(string here)");
function vowelCount(input)
{
    var count = 0;
    var c = "";
    for(i=0;i<input.length;i++)
    {
        c = input.charAt(i);
        switch(c.toLowerCase())
        {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
            case "y":
                count++;
            break;
            default:
            break;
        }
    }
    return count;
}


//Problem 4
console.log("Call removeScript(string here)");
function removeScript(input)
{
    // var find = /(^|\s)Script(\s|$)/;
    var find = /Script/gi;
    return input.replace(find, "");
}


//Problem 5
console.log("Call isLeapYear(year here, month here, day here)");
function isLeapYear(year, month, day)
{
    var input = new Date(year, month, day)
    var output = false;
    if(input.getFullYear()%4 == 0)
    {
        if(input.getFullYear()%100 == 0)
        {
            if(input.getFullYear()%400 == 0)
                output = true;
        }  
        output = true;
    }
    return output;
}


//Problem 6
console.log("Call isValidEmail(string here)");
function isValidEmail(input)
{
    var valid = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return valid.test(input.toLowerCase());
}


//Problem 7
console.log("Call removeChar(string here, index here)");
function removeChar(input, index)
{
    var find = input.charAt(index);
    return input.replace(find, "");
}


//Problem 8
console.log("Call bubbleSort(numbered array here)");
function bubbleSort(array)
{
    var temp;
    var didSwap = false;
    //this loop repeats until the swap flag states false
    do
    {
        didSwap = false;
        //this loop travels through the array
        for(i=0;i<array.length-1;i++)
        {
            if(array[i] > array[i+1])
            {
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                didSwap = true;
            }
        }
    }while(didSwap == true)
    return array;
}


//Problem 10
console.log("Call isPalindrome(string here)");
function isPalindrome(input)
{
    var output = true;
    var quotient = Math.floor(input.length/2);
    for(i=0;i<=quotient;i++)
    {
        if(input.charAt(i) != input.charAt((input.length-1)-i))
        {
            output = false;
            break;
        }
        
    }
    return output;
}


//Problem 11
console.log("Call printShape(shape here, height here, character here)");
function printShape(shape, height, character)
{
    switch(shape)
    {
        case "square":
            return printSquare(height, character);
        break;
        case "triangle":
            return printTriangle(height, character);
        break;
        case "diamond":
            return printDiamond(height, character);
        break;
        default:
            return "not a valid shape.";
    }
}

function printSquare(height, character)
{
    var output = "";
    for(i=0;i<height;i++)
    {
        output = output + character;
    }
    for(y=0;y<height;y++)
    {
        console.log(output);
    }
    return "printShape function complete.";
}

function printTriangle(height, character)
{
    var output = "";
    for(i=0;i<height;i++)
    {
        output = output + character;
        console.log(output);
    }
    return "printShape function complete.";
}

function printDiamond(height, character)
{
    var output;
    var mid = Math.floor(height/2);
    var tier = mid;
    //each run creates a tier
    for(y=0;y<tier;y++)
    {
        //clear output before populating a tier
        output = "";
        //append output with space
        for(i=0;i<mid;i++)
        {
            output = output + " ";
        }
        //append output with characters 
        for(j=0;j<height-(mid*2);j++)
        {
            output = output + character;
        }
        console.log(output);
        mid--;//reduce # of space and increase # of chars for each tier
    }
    //midline and bottom half
    for(y=0;y<=tier;y++)
    {
        //clear output before populating a tier
        output = "";
        //append output with space
        for(i=0;i<mid;i++)
        {
            output = output + " ";
        }
        //append output with characters 
        for(j=0;j<height-(mid*2);j++)
        {
            output = output + character;
        }
        console.log(output);
        mid++;//increase # of space and decrease # of chars for each tier
    }
    return "printShape function complete.";
}


//Problem 12
console.log("Call rotate(array here, n here)");
function rotate(array, n)
{ 
    var clone = array.slice(0);
    var outputArr = array.slice(n);
    for(j=0;j<n;j++)
    {
        outputArr.push(array[j]);
    }
    return outputArr;
}


//Problem 13
console.log("Call balanced(string here)");
function balanced(input)
{
    output = false;
    var leftHalf = new Array();
    var rightHalf = new Array();
    //if the input has odd number of chars then brackets are not balanced
    if(input.length%2 == 0)
    {
        var mid = input.length/2;//input should have even # of chars at this point so Math.floor not needed
        //both arrays will have same length
        //populate left array with left half of input
        for(i=0;i<mid;i++)
            leftHalf.push(input.charAt(i));
        //populate right array
        for(j=mid;j<input.length;j++)
            rightHalf.push(input.charAt(j));

        //check first index of left array and last index of right array, they should match as bracket types
        loop1: 
        for(y=0;y<leftHalf.length;y++)
        {
            var leftComp = leftHalf[y];
            var rightComp = rightHalf[(rightHalf.length-1)-y];
            //if bracket types dont match then break from loop
            switch(leftComp)
            {
                case "(":
                    if(rightComp != ")")
                    {
                        output = false;
                        break loop1;
                    }
                    break;
                case ")":
                    if(rightComp != "(")
                    {
                        output = false;
                        break loop1;
                    }
                    break;
                case "{":
                    if(rightComp != "}")
                    {
                        output = false;
                        break loop1;
                    }
                    break;  
                case "}":
                    if(rightComp != "{")
                    {
                        output = false;
                        break loop1;
                    }
                    break;
                case "[":
                    if(rightComp != "]")
                    {
                        output = false;
                        break loop1;
                    }   
                    break;
                case "]":
                    if(rightComp != "[")
                    {
                        output = false;
                        break loop1;
                    }
                    break;
            }
            output = true;
        }
    }
    return output;
}