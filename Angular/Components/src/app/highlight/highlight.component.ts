import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {
  colors: string[] = ['red', 'green', 'blue'];
  style: string="";

  constructor() { }

  ngOnInit() {
  }

  updateStyle(color: string): void {
    if(color != undefined){
      this.style = color;
    }
  }
}