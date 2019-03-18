import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {
  highlightColor: string;
  constructor() { }

  ngOnInit() {
  }
  Highlight(){
      this.highlightColor = "orangeHighlight";
  }
  UnHighlight(){
    this.highlightColor = "";
  }
}
