import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {
  animals = ["Cat","Dog","Bird"];
  colors = ["Red","Blue","Yellow"];
  days = ["Monday","Thursday","Saturday"];
  ltype = '';
  constructor() { }

  ngOnInit() {
  }

}
