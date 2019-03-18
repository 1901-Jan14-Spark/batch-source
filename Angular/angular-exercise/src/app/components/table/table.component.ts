import { Component, OnInit } from '@angular/core';
import { People } from '../People';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  peoples: People[] = [{
    firstname: "kevin",
    lastname: "Tran",
    email: "kth@gmail.com",
    birthday: new Date("1994-4-8")
  }, {
    firstname: "kelby",
    lastname: "Behounek",
    email: "kb@gmail.com",
    birthday: new Date("1993-3-7")
  }, {
    firstname: "Andrew",
    lastname: "Ha",
    email: "ah@gmail.com",
    birthday: new Date("1992-2-6")
  }];

  stylez: string = "";

  toggleStyle(){
    if(this.stylez === ""){
      this.stylez = "table";
    }else{
      this.stylez = "";
    }
  }
}
