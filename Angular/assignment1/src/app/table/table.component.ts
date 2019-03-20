import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  style: boolean = true;

  people = [{
    firstname: 'david',
    lastname: 'van alstine',
    email: 'vanalstinedj@gmail.com',
    birthday: '01/10/1996'
  }, {
    firstname: 'joel',
    lastname: 'van alstine',
    email: 'vanalsintj@gmail.com',
    birthday: '11/25/1996'
  },{
   firstname: 'julieanne',
    lastname: 'van alstine',
    email: 'vanalsintjd@gmail.com',
    birthday: '12/25/1994'
  }];

  styled: string = "";

  changeStyle(){
    if(this.styled === ""){
      this.styled = "table";
    } else {
      this.styled = "";
    }
  }

  constructor() { }

  ngOnInit() {
  }

}
