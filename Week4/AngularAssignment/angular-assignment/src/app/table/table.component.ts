import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  btnClass = '';
  tClass = '';
  people = [
    {
      fname: 'ToVa',
      lname: 'Mc CurKye',
      email: 'tmccurlye0@usda.gov',
      birthday: '01/12/1983'
    },
    {
      fname: 'Asia',
      lname: 'VarNs',
      email: 'avarns1@shop-pro.jp',
      birthday: '08/02/1972'
    },
    {
      fname: 'Neel',
      lname: 'Dreng',
      email: 'ndreng2@issuu.com',
      birthday: '11/26/1981'
    },
    {
      fname: 'Munroe',
      lname: 'HaPs',
      email: 'mhaps3@springer.com',
      birthday: '10/10/1996'
    },
    {
      fname: 'Caesar',
      lname: 'CheaVin',
      email: 'ccheavin4@ebay.com',
      birthday: '10/20/1979'
    },
    {
      fname: 'Moises',
      lname: 'HallAs',
      email: 'mhallas5@ibm.com',
      birthday: '03/29/2001'
    },
    {
      fname: 'kaLa',
      lname: 'Cayet',
      email: 'kcayet6@mit.edu',
      birthday: '08/02/1983'
    },
    {
      fname: 'DOy',
      lname: 'Bythway',
      email: 'dbythway7@addthis.com',
      birthday: '06/25/2000'
    },
    {
      fname: 'EzeKel',
      lname: 'Littler',
      email: 'elittler8@unicef.org',
      birthday: '11/06/1991'
    },
    {
      fname: 'RozeLle',
      lname: 'Boatwright',
      email: 'rboatwright9@pcworld.com',
      birthday: '03/04/2001'
    }
  ];
  toggleStyle(){
    if(''==this.tClass){
      this.tClass = "table table-hover"
      this.btnClass = "btn btn-outline-primary"
    }else{
      this.tClass = '';
      this.btnClass = '';
    }
  }
  constructor() { }

  ngOnInit() {
  }

}
