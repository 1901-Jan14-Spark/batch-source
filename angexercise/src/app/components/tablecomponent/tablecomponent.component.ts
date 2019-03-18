import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tablecomponent',
  templateUrl: './tablecomponent.component.html',
  styleUrls: ['./tablecomponent.component.css']
})
export class TablecomponentComponent implements OnInit {

styleTable: boolean = true;

changeStyle(){
  if(this.styleTable == true){
    this.styleTable = false;
  } else if (this.styleTable == false) {
    this.styleTable = true;
  }
}
  people = [
    {firstname: 'Vijay',
    lastname: 'Sad',
    email: 'vk@gmail.com',
    dob: '11/23/1993'
  }, {
    firstname: 'Dat',
    lastname: 'Tran',
    email: 'dt@gmail.com',
    dob: '07/24/1993'
  }, {
    firstname: 'Aaron',
    lastname: 'Chumchal',
    email: 'ac@gmail.com',
    dob: '08/28/1994'
  }
  ]
  constructor() { }

  ngOnInit() {
  }

}
