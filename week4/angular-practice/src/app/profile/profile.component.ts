import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: User = {
    name: 'Magikarp',
    address: 'The Great Ocean'
  };

  view: string = "Hide";
  hide: boolean = false;


  constructor() { }

  ngOnInit() {
  }

  toggleView(): void {
    if(this.hide){
      this.hide = false;
      this.view = "Hide";
    } else {
      this.hide = true;
      this.view = "Show";
    }
  }

}
