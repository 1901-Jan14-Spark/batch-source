import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-radios',
  templateUrl: './radios.component.html',
  styleUrls: ['./radios.component.css']
})
export class RadiosComponent implements OnInit {

  constructor() { }

  animals:string[] = ["cat", "dog", "hamster"];
  days: string[] = ["monday", "tuesday", "wednesday"];
  colors: string[] = ["red", "blue", "yellow"];

  
  ngOnInit() {
  }

}
