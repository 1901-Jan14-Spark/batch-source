import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  count: number = 0;
  classVar: string = "redText";

  increment(inc: number){
    this.count +=inc;
    if(this.count%2==0){
      this.classVar = "redText";
    } else {
      this.classVar = "blueText";
    }
    // console.log(this.count);
  }


}
