import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  buttonStyle = "";
  tableStyle = "";

  constructor() { }

  people = [
    {
    firstName: 'Joe',
    lastName: 'Pizza',
    email: 'joepiz@this.email',
    birthday: '08/16/1978'
    },
    {
      firstName: 'Bill',
      lastName: 'Spring',
      email: 'jbill@oh.what',
      birthday: '03/26/1899'
      },
    {
      firstName: 'Kim',
      lastName: 'Yopu',
      email: 'yop@place.com',
      birthday: '10/10/1910'
      }
  ]

  changeStyle(){
    if(''==this.buttonStyle){
      this.buttonStyle = "btn btn-warning";
      this.tableStyle = "table table-bordered table-striped";
    }
    else{
      this.buttonStyle = "";
      this.tableStyle = "";
    }
  }
  ngOnInit() {
  }

}
