var canvas = document.getElementsByTagName("canvas")[0];
var ctx = canvas.getContext("2d");

var width = 300, height = 600;
var col = 10, row = 20
var block_w = width / col, block_h = height / row;

var board = [];
var current;

function init(){
  for(var i = 0; i < row; i++){
    board[i] = [];
    for(var j = 0; j < col; j++){
      board[i][j] = 0;
    }
  }
}

function render(){
  ctx.fillStyle = "black";
  for(var i = 0; i < col; i++){
    for(var j = 0; j < row; j++){
      if(board[j][i]){
        ctx.fillRect(block_w * i, block_h * j, block_w - 1, block_h  -1);
      }
      ctx.strokeRect(block_w * i, block_h * j, block_w - 1, block_h - 1);
    }
  }
}

function tick(){
  
}

init();
setInterval(render, 30);
