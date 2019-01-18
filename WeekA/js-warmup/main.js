// 1. Use the console log function to write "hello world" to the console.
/*
    console.log("hello world")
*/

//2. Declare a variable, x, and assign it a numeric value. Write an if statement which evaluates the condition of whether x is greater than 10. If it is, write "x is greater than 10" to the console. If it is not, write "x is equal to or less than 10." 
/*
    let x = 8;
    if(x>10){
        console.log("x is greater than 10");
    } else {
        console.log("x is equal to or less than 10");
    }
*/

//3. Using a for loop, print "greetings" to the console 4 times
/*
    for(i=0;i<4;i++){
        console.log("greetings");
    }
*/

//4. Using a while loop, print "greetings" to the console 4 times
/*
    let condition = true;
    let counter = 0;
    while(condition){
        console.log("greetings");
        counter = counter + 1; //counter++ would achieve the same thing
        if(counter==4){
            condition = false;
        }
    }
*/
// can also be achieved
/*
    let condition = true;
    let counter = 0;
    while(condition){
        console.log("greetings");
        counter = counter + 1; //counter++ would achieve the same thing
        if(counter==4){
            break;
        }
    }
*/

//5. Color switch statement
/*
    let color = "orange";
    switch(color){
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
            console.log("unknown color");
    }
*/

//6. printNums
/*
    function printNums(){
        for(i=1;i<11;i++){
            console.log(i);
        }
    }
    printNums();
*/

//7. printUpToVal
/*
    function printUpToVal(x){
        for(i=1;i<x+1;i++){
            console.log(i);
        }
    }
    printUpToVal(8);
*/

//8. printRange
/*
    function printRange(x,y){
        for(i=x;i<y+1;i++){
            console.log(i);
        }
    }
    printRange(2,8);

*/

//9. printString
/*
    function printString(str,n){
        output = "";
        for(i=0;i<n;i++){
            output = output + str; //output+=str would achieve the same thing 
        }
        return output;
    }

    console.log(printString("hello",5));
*/