import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlightcomponent',
  templateUrl: './highlightcomponent.component.html',
  styleUrls: ['./highlightcomponent.component.css']
})
export class HighlightcomponentComponent implements OnInit {

  constructor() { }

  color: string;

  changeColor(){
    this.color = "red";
  }

  revert(){
    this.color="";
  }

  ngOnInit() {
  }

}
