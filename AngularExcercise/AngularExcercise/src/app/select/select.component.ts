import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  options = '';
  colors: string[] = ['green', 'red', 'purple', 'orange'];
  animals: string[] = ['cow', 'dog', 'dragon', 'trent'];
  days: string[] = ['friday', 'saturday', 'sunday', 'monday'];

  constructor() { }

  ngOnInit() {
  }

}
