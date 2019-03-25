import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  buttonText = 'Hide';
  show = true;
  user = {name: 'Bobby', age: 25};

  constructor() { }

  ngOnInit() {
  }

  toggleShow()
  {
      if (this.show)
      {
        this.show = false;
        this.buttonText = "Show";
      }
      else
      {
        this.show = true;
        this.buttonText = "Hide";
      }
  }
}
