import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  person = { name: 'Batman', email: 'batman@wayneindustries.com', hobby: 'Not Being Batman', contact: 'Bat Searchlight'};

 hideShow: boolean = true;
 buttname: string = 'show';

 toggle() {

  this.hideShow = !this.hideShow;

  if (this.hideShow){
    this.buttname = 'Hide';
  } else {
    this.buttname = 'Show';
  }
 }

  constructor() { }

  ngOnInit() {
  }

}
