import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  
  animals: string[] = [ 'Cat', 'Dog', 'Monkey', 'Hawk', 'Lizard'];
  colors: string[] = ['Royal', 'Grey', 'Black', 'White', 'Silver', 'Navy'];
  days: string[] = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

  aSelected: boolean = false;
  cSelected: boolean = false;
  dSelected: boolean = false;

  

}
