import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-s-directives',
  templateUrl: './s-directives.component.html',
  styleUrls: ['./s-directives.component.css']
})
export class SDirectivesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  condition: boolean = false;
  cats = 
  [{
    id: 5,
    name: 'Fluffy'
  }, {
    id: 8,
    name: 'Speedy'
  },{
    id: 10,
    name: 'Terrance'
  },{
    id: 14,
    name: 'Chips'
  }]

  time: string = 'noon';

  changeCondition(){
    this.condition = !this.condition;
  }

  changeToDay(){
    this.time = 'day';
  }

  changeToNight(){
    this.time = 'night';
  }
}
