import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  users: string[] = ['John', 'James', 'Jefferson', 'Jackson','Jordan'];

  show: boolean = true;

  constructor() { }

  ngOnInit() {
  }


}