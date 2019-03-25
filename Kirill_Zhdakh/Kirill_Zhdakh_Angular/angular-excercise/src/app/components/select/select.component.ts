import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  form = new FormGroup({
    options: new FormControl('animals'),
  });

  animals = ['Cow', 'Cat', 'Dog', 'Bear'];
  colors = ['Red', 'Green', 'Yellow', 'Blue'];
  days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday'];
  constructor() { }
  displayItems = [];
  ngOnInit() {
  }

  changeDisplay(str)
  {
    if (str == "animals")
      this.displayItems = this.animals;
    else if (str == "colors")
      this.displayItems = this.colors;
    else
      this.displayItems = this.days;
  }
}
