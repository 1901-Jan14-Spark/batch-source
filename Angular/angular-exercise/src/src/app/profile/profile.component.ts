import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  Users: string[] = ["Aaron Chumchal",  "Age:24",  "Location: Reston VA"];
  Visible: boolean = true;
  constructor() { }

  ngOnInit() {
  }

}
