import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

Text = document.getElementById('myText');
filler = 'Welcome to my page';
  constructor() { }

  ngOnInit() {
  }

}
