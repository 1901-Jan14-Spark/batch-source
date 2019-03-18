import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  mdbTable: string = "mdbTable";
  class: string = "table";

  people: People[] = [
    { firstName: "Magikarp",
      lastName: "Fish",
      email: "magikarp@gmail.com",
      birthday: new Date("2018-03-16")
    },
    { firstName: "Jay",
      lastName: "Shim",
      email: "shimjay1@gmail.com",
      birthday: new Date("1995-08-21")
    },
    { firstName: "Alfonzo",
      lastName: "Shimothy",
      email: "alfonzo@gmail.com",
      birthday: new Date("2018-02-01")
    }
  ];

  constructor() { }

  ngOnInit() {
  }

  changeCSS(){
    if(this.class == "table"){
      this.class = "";
    } else {
      this.class = "table";
    }
  }

}
