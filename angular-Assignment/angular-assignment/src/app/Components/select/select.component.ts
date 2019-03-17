import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals: string[] = ["Dog", "Hamster", "Snake", "Cat", "Monkey"];
  isA: boolean = false;
  colors: string[] = ["Red", " Orange", " Yellow", "Green", "Blue", "Indigo", "Violet"];
  isC: boolean = false;
  days: string[] = ["Monday", "Tuesday", " Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
  isD: boolean = false;


  constructor() { }

  ngOnInit() {
  }

}
