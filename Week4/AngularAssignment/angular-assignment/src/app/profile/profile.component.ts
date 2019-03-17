import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  isHidden= false;
  user = {
    fname: "Dave",
    email: "HiImDave@dave.rrc",
    phone: "4-212-555-3030"
  };
  hideorshow = "Show"
  toggleInfo(){
    if(!this.isHidden){
      this.isHidden=true;
      this.hideorshow= "Hide";
    }else{
      this.isHidden=false;
      this.hideorshow= "Show";
    }
  }
  constructor() { }

  ngOnInit() {
  }

}
