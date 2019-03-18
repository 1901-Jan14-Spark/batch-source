import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {
  option: string[] = [];

  constructor() { }

  ngOnInit() {
  }

  
  animals: string[] = ['Cat', 'Dog', 'Monkey', 'Hawk', 'Lizard'];
  colors: string[] = ['Royal', 'Grey', 'Black', 'White', 'Silver', 'Navy'];
  days: string[] = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
  
  show(event){
    this.option = [];
    let selected = event.target.value;

    if(selected === 'animals'){
      this.option = this.animals;
    } else if(selected === 'colors'){
      this.option= this.colors;
    } else if(selected === 'days'){
      this.option = this.days;
    }
  }
}
