import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals: string[] = ["Dog", "Cat", "Fox", "Panda"];
  colors: string[] = ["Red","Blue","Green","Yellow"];
  days: string[] = ["Monday","Friday","Saturday","Sunday"];

  selected: string[] = [];
  select: string; 
  
  constructor() { }

  ngOnInit() {
  }

  getSelect(value){
    this.select = "select";
    if(value == "animals"){
        this.selected = this.animals;
    }
    else if(value == "colors"){
        this.selected = this.colors;
    }
    else if(value == "days"){
      this.selected = this.days;
    }
    console.log(value);
    console.log(this.select);
    console.log(this.selected);
  }
}
