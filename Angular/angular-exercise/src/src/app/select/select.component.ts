import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {
  animals: string[] = ["cat", "dog", "mongoose", "zebra", "lion"];
  colors: string[] = ["red", "blue", "green", "yellow", "orange"];
  days: string[] = ["Monday", "Tuesday", "Wednesday", "Thursday"];
a: boolean=false;
b: boolean=false;
c: boolean=false;

  constructor() { }

  ngOnInit() {
  }

}
