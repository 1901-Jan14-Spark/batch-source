import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  styleTable: boolean = true;

  users = [{
    fName: 'kyrie',
    lName: 'irving',
    email: 'kIrving@gmail.com',
    dob: '1992/03/23'
  }, {
    fName: 'kobe',
    lName: 'bryant',
    email: 'kBryant@gmail.com',
    dob: '1978/08/23'
  }, {
    fName: 'kevin',
    lName: 'durant',
    email: 'kDurant@gmail.com',
    dob: '1988/09/29'
  }]

  constructor() { }

  ngOnInit() {
  }

}
