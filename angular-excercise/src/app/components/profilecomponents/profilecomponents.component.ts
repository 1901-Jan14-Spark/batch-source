import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profilecomponents',
  templateUrl: './profilecomponents.component.html',
  styleUrls: ['./profilecomponents.component.css']
})
export class ProfilecomponentsComponent implements OnInit {

  constructor() { }

  show: boolean = false;

  users: string[] = ["Jack", "John", "James"];
  ngOnInit() {
  }

}
