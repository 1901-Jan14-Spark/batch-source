import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent implements OnInit {

  constructor() { }

  users = [{
    fName: 'hassan',
    lName: 'raqib',
    email: 'hraiqb1@gmail.com',
    dob: '1995/11/28'
  }, {
    fName: 'Jack',
    lName: 'o\'Valtrades',
    email: 'traderjack@gmail.com',
    dob: '2002/08/23'
  }, {
    fName: 'timorthy',
    lName: 'fitzgerald',
    email: 'tomthy1@gmail.com',
    dob: '1942/09/29'
  }]

  ngOnInit() {
  }

}
