import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  things: string[] = ["animals", "colors", "days"];

  animals: string[] = ["dog", "cat", "horse"];
  colors: string[] = ["red", "green", "blue"];
  days: string[] = ["monday", "tuesday", "wednesday"];

  printItems: string[];

  constructor() { }

  ngOnInit() {
  }

  isSelected(item): void {
    if(item == "animals") this.printItems = this.animals;
    else if(item == "colors") this.printItems = this.colors;
    else this.printItems = this.days;
  }

}
