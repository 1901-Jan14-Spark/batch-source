import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  classVar:string = "";

  changeColor() {
    if(this.classVar == ""){
      this.classVar = "redText";
    }else{
      this.classVar = "";
    }
  }

}
