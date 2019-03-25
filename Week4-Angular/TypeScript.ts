function doSomething(){
    for(let i=0; i<5; i++){
        console.log(i);
    }
}

// doSomething();

// console.log(i);
//let i; will give you an error when transpiling
var i;

let x: any;
x = 9;
x = false;

let counter = 5;
// cannot reassign to a type that is not number
//counter = "cat";

let y: number;
y = 5;

let boo: boolean;
let str: string;
let obj: object;

function myVoidFunction(): void{
    console.log("this function doesn't return anything");
}

// myVoidFunction();

let anotherFunction = function(value){
    if(typeof value === "string" && typeof value === "number"){
        return value;
    }
}

let rickRoll = function(){
    while(true){
        console.log("never gonna give you up");
        console.log("never gonna let you down")
    }
}

let u: number[];
// u = [4,5,6,"two"];
let v: string[]
v = ["six","two"];
let w: any[];
w = [4,5,6,"two"];

let drawPoint = (x,y) => {
    console.log(x+", "+y);
}

drawPoint(4,5);

let drawPoint2 = (point) =>{
    console.log(point.x+", "+point.y);
}

drawPoint2({x:5, y:4});
drawPoint2({name:"Holly", email:"HollyRox@gmail.com"});

let drawPoint3 = (point: {x:number, y:number}) => {
    console.log(point.x+", "+point.y);
}

drawPoint3({x:5, y:4});
//drawPoint3({name:"Holly", email:"HollyRox@gmail.com"});

interface Point {
    x: number;
    y: number;
}

let drawPoint4 = (point: Point) => {
    console.log(point.x+", "+point.y);
}

drawPoint4({x:5, y:4});
// drawPoint4({name:"Holly", email:"HollyRox@gmail.com"});

class AlsoPoint{
    x:number;
    y:number;

    constructor(_x?:number, _y?:number){
        this.x = _x;
        this.y = _y;
    }

    drawPoint = ()=>{
        console.log(this.x+", "+this.y);
    }
}

let myPoint: AlsoPoint = new AlsoPoint(10,20);
myPoint.drawPoint();

drawPoint4(myPoint);