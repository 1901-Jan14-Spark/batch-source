import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  user = {
    firstname: "John",
    lastname: "Smith",
    birthday: "11/11/1894",
    major: "Foreign Dependency"
  }

  buttonName: string = "Hide";

  toggle(){
    if(this.buttonName === "Hide"){
      this.buttonName = "View";
      this.user = null;
    }else{
      this.buttonName = "Hide";
      this.user = {
        firstname: "John",
        lastname: "Smith",
        birthday: "11/11/1894",
        major: "Foreign Dependency"
      }
    }
  }
}
