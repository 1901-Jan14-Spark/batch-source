import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  users: string[] = ['Messi', 'Ronaldo', 'Salah', "Kane"];

  show: boolean = true;

  constructor() { }

  ngOnInit() {
  }


}
