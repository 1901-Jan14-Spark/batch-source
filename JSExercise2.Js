
//0)
    // for (var i=1; i < 101; i++){
         
    //     if ((i % 5 == 0) && (i % 3 == 0)) 
    //     { 
    //     console.log("FizzBuzz");} 
    //      else if (i % 3 == 0) {console.log("Fizz"); }
    //     else if (i % 5 == 0) {console.log("Buzz"); }
    //      else console.log(i);
    // }







//1)
//    function maxLength(myArray){

//   //  let container = myArray[0];
//   for(x=0; x<myArray.length; x++){

//      if( myArray[0].length < myArray[x].length){
//         myArray[0] = myArray[x]
//         }
    
//   }
  
//   console.log(myArray[0]);
//     }

//  maxLength(["James", "Marrrrrrrrrrrrry", "Thoseoners", "tep"]);









//2)
//  function reverseArray(myArray){
 
//      let i = 0;
//      //-1 for the index??
//     let num = myArray.length - 1;

//     var newArray= [];
    
//     while( 0 <= num){

//         newArray[i] = myArray[num];



//         num--;
//         i++;
//     }
//     console.log(newArray);
//  }

//  reverseArray([1,2,3,4,5]);













//3)
// function vowelCount(string){

//   //  int[] array = new int[5];
//    let array = [0,0,0,0,0];
    
//     for ( i = 0; i < string.length; i++) {
//          let letter = string.charAt(i);
//          console.log(letter);
        
//         if(letter == 'a') {  
//             array[0]++; 
//         } else if (letter == 'e') { 
//             array[1]++;
//         } else if (letter == 'i') {
//             array[2]++;
//         } else if (letter == 'o') {
//             array[3]++;
//         } else if (letter == 'u') {
//             array[4]++;
//         } 
//     }
    
//     console.log( array);

// }


// vowelCount("wasyioirun");






//4
//  function removeScript(string) {

//   let deleteWord = "Script"
//  let xContainer = [];
//  let yContainer = [];

//  for ( i = 0; i < string.length; i++) {

//      if( string.charAt(i) == deleteWord.charAt(i) ){ 
//         yContainer.push =  string.charAt(i);
//        }
        
//      else{
//          if (string === undefined || string.length == 0){
//       xContainer.push = string.charAt(i);
//     }
//     else 
//     for (y in yContainer ){
//     xContainer.push = y; }
//     xContainer.push = string.charAt(i); 
      


//      }

//      console.log(xContainer);
//  }
//  console.log(xContainer);

 

// }


// removeScript("ScrffddScriptka")






// 5)
// function isLeapYear(date){

//     if  (date % 100 === 0) 
//     { return (date % 400 === 0) }
        
//        else  { return(date % 4 === 0);
//     }
      



// }

// console.log(isLeapYear(2016));








//6)
// function isValidEmail(string) {
//     var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
//     return pattern.test(string);
// };

// console.log(isValidEmail("ajsbaaol.com"));






//7)

// function removeChar(string, index){
//  y = 0; 
// var newString ="";
//    while( y != index) {

//    newString +=  string.charAt(y);
  
//    y++;}
// var counter = index + 1;
//    while( counter  < string.length) {
//     newString +=  string.charAt(counter);
//     counter++;
// }
// console.log(newString);


//    }

//    removeChar("ajasj", 2);







// //8)

// function bubbleSort(numArray){


//    var  n = numArray.length;
//    var temp = 0;

//    for (i = 0; i < n; i++) {
//        for (j = 1; j < (n - i); j++) {

//            if (numArray[j - 1] > numArray[j]) {
//                temp = numArray[j - 1];
//                numArray[j - 1] = numArray[j];
//                numArray[j] = temp;
//            }

//        }
//    }return numArray;

//console.log(bubbleSort(["1", "5","9" , "3"]));







// 10)
// function isPalindrome(someStr){
//  var length = someStr.length;
//   var reverse = "";

//    for (  i = length - 1; i >= 0; i-- ){
//    reverse = reverse + someStr.charAt(i);
//    }
//    console.log(reverse);
//  return (reverse == someStr) ? true: false;


// }

// console.log(isPalindrome("hadah"));












//11)

// function printShape(shape, height, character){
//  var someString = "";

// switch (shape){
// case "Triangle":

// for( i = 1; i <= height; ++i)
//     {
//         for( j = 1; j <= i; ++j)
//         {

//          someString += character;
//            // console.log(j);

//         }
//         console.log(someString);

//         console.log ("\n");
//     }
   
//    case "Square":

   

//    for( i = 1; i <= height; i++)
//    {
//        for( j = 1; j <= height; j++)
//        {

//         someString += character;
//           // console.log(j);

//        }
//        console.log(someString);
      
//        console.log ("\n");
//    }

// }

// }

// printShape("Square", 3, '#');







//12)

// function rotate(array, n){


// var tempArray1= [];
// var num;

// var tempArray2= [];

//     for(i=0; i< n; i++){
//         tempArray1[i] = array[i];
//         num = i;
        
//     }
        
//      console.log( tempArray1);

//         tempArray2 = array.slice(num +1,array.length );


//          var tArrayLength = tempArray2.length;


         
//               for (x in tempArray1)   {
//            tempArray2[tArrayLength] = tempArray1[x];
//            tArrayLength++;

//          }
//      console.log( tempArray2);
//      var temp = array[0]
//      var  i; 
 
// }


// console.log(rotate(["1","2","3","4","5"], 3));












