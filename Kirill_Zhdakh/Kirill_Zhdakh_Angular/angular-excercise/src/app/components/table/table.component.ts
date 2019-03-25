import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})

export class TableComponent implements OnInit {

  people = [];
  bobifyStr = "Bobify";
  isBobified = false;

  constructor() { }

  ngOnInit() {
  }

  addBobRoss()
  {
    this.people.push({firstname: "Bob", lastname: "Ross", email: "happyliltrees@gmail.com", birthday: "10/29/1942"});
  }

  clearBobRoss()
  {
    this.people = [];
  }

  bobify()
  {
    if (this.isBobified)
    {
      this.bobifyStr = "bobify";
      this.isBobified = false;
    }
    else
    {
      this.bobifyStr = "Unbobify";
      this.isBobified = true;
    }
  }
}
