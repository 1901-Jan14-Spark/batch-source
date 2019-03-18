import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {



people: any[] = [
  {
    firstname: 'peter',
    lastname: 'mckensey',
    email: 'pMckensey@aol.com',
    birthday: '09-24-1950'
  }, {
    firstname: 'gonzalo',
    lastname: 'reyes',
    email: 'Reyes@mail.com',
    birthday: '01-13-1989'
  }, {
    firstname: 'jessica',
    lastname: 'olivas',
    email: 'Jolivas@gmail.com',
    birthday: '09-24-1990'
  }
];
  constructor() { }

  ngOnInit() {
  }

}
