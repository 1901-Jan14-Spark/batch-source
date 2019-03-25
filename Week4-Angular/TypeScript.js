function doSomething() {
    for (var i_1 = 0; i_1 < 5; i_1++) {
        console.log(i_1);
    }
}
// doSomething();
// console.log(i);
//let i; will give you an error when transpiling
var i;
var x;
x = 9;
x = false;
var counter = 5;
// cannot reassign to a type that is not number
//counter = "cat";
var y;
y = 5;
var boo;
var str;
var obj;
function myVoidFunction() {
    console.log("this function doesn't return anything");
}
// myVoidFunction();
var anotherFunction = function (value) {
    if (typeof value === "string" && typeof value === "number") {
        return value;
    }
};
var rickRoll = function () {
    while (true) {
        console.log("never gonna give you up");
        console.log("never gonna let you down");
    }
};
var u;
// u = [4,5,6,"two"];
var v;
v = ["six", "two"];
var w;
w = [4, 5, 6, "two"];
var drawPoint = function (x, y) {
    console.log(x + ", " + y);
};
drawPoint(4, 5);
var drawPoint2 = function (point) {
    console.log(point.x + ", " + point.y);
};
drawPoint2({ x: 5, y: 4 });
drawPoint2({ name: "Holly", email: "HollyRox@gmail.com" });
var drawPoint3 = function (point) {
    console.log(point.x + ", " + point.y);
};
drawPoint3({ x: 5, y: 4 });
var drawPoint4 = function (point) {
    console.log(point.x + ", " + point.y);
};
drawPoint4({ x: 5, y: 4 });
// drawPoint4({name:"Holly", email:"HollyRox@gmail.com"});

var AlsoPoint = /** @class */ (function () {
    function AlsoPoint(_x, _y) {
        var _this = this;
        this.drawPoint = function () {
            console.log(_this.x + ", " + _this.y);
        };
        this.x = _x;
        this.y = _y;
    }
    return AlsoPoint;
}());
var myPoint = new AlsoPoint(10, 20);
myPoint.drawPoint();
drawPoint4(myPoint);
