import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight-component',
  templateUrl: './highlight-component.component.html',
  styleUrls: ['./highlight-component.component.css']
})
export class HighlightComponentComponent implements OnInit {
  
  color: String;

  changeColor(){
    this.color = "red";
  }
  constructor() { }

  ngOnInit() {
  }

}
