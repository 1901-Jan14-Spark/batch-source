import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
people=[{ Name: 'Tony Stark', Email: 'FeMan@gmail.com', Birthday: '01-26-1972'},
{ Name: 'Luke Skywalker', Email: 'Chosen1@gmail.com', Birthday: '03-14-1958'},
{ Name: 'Bruce Wayne', Email: 'WayneEnterprise@gmail.com', Birthday: '04-06-1975'}
]
  constructor() { }

  ngOnInit() {
  }

}
