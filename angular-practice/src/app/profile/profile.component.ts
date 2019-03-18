import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile: string[] = ['Daniel'];

  accountView: boolean = false;

  constructor() { }
  status: string = "Show";

  view(){
    if(this.accountView == false){
      this.accountView = true;
      this.status = "Hide";
    }
    else{
      this.accountView = false;
      this.status = "Show";
    }
  }

  ngOnInit() {
  }

}
