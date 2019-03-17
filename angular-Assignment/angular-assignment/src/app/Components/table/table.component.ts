import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  style: boolean = true;

  users = [{
    Name: 'Kelby Behounek',
    Desc: 'The Cool Dad',
    DOB: '1991/08/10'
  },{
    Name: 'Jazmin Behounek',
    Desc: 'The Best Mom',
    DOB: '1994/03/21'
  },{
    Name: 'Melanie Behounek',
    Desc: 'The Best Climber',
    DOB: '2013/10/08'
  },{
    Name: 'Leah Behounek',
    Desc: 'The Brains',
    DOB: '2015/06/01'
  }]

  constructor() { }

  ngOnInit() {
  }

}
