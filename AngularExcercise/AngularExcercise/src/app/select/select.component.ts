import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  colors: string[] = ['green', 'red', 'purple', 'orange'];
  animals: string[] = ['cow', 'dog', 'dragon', 'trent'];
  days: string[] = ['friday', 'saturday', 'sunday', 'monday'];

  showcolors() {
    document.getElementById('colordiv');
    document.getElementById('animalsdiv');
    document.getElementById('daysdiv');

  }

  constructor() { }

  ngOnInit() {
  }

}
