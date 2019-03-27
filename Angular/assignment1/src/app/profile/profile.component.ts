import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profiles = [
    { id: 4, name: 'David' },
    { id: 20, name: 'Lucas' },
    { id: 7, name: 'Jake' },
    { id: 30, name: 'Dan' },
    { id: 16, name: 'Liam' },
    { id: 23, name: 'Travis' }  
  ];

  constructor() { }

  ngOnInit() {
  }
}
