// function doSomething(){
//     for(let i = 0; i<5; i++){
//         console.log(i);
//     }
// }

// doSomething();



// console.log(i);

// var i;

// let x;

// x=9;
// x=false;


// let counter = 5;
// counter = "cat";

// let y: number;

// y=5;


// function myVoidFunction(): void{
//     console.log("this function doesn't return anything")
// }

// // myVoidFunction();

// let anotherFunction = function(value: any){
//     if(typeof value === "string" && typeof value === "number")
//     return value;
// }


let u: number[];

u =[4,5,6]

let v: string[]

v =["meh", "blah", "gross", "horrible"]

let w: any[];

w = [4,5,6, "meh", "gross"]

let drawPoint(x,y)=>{
    console.log(x+", " +y);
}

drawPoint(4,5);

let drawPoint2 = (point) =>{
    console.log(point.x + ", "+point.y);
}

drawPoint2({x:5, y:4});

drawPoint2({name: "holly", email:"gmai;er;er@gmail.com"});

let drawPoint3 =(point: {x:number, y:number})=>{
    console.log(point.x + ", "+point.y);
}


interface Point {

    x:number;
    y:number;

}

let drawPoint4 = (point: Point) =>{
    console.log(point.x + ", "+point.y);
}


class AlsoPoint{

    x: number;
    y: number;

    constructor(_x?:number, _y?:number){
        this.x = _x;
        this.y = _y;
    }

    drawPoint =()=>{
        console.log(this.x+", "+this.y);
    }
}

let myPoint: AlsoPoint = new AlsoPoint();
myPoint.drawPoint();