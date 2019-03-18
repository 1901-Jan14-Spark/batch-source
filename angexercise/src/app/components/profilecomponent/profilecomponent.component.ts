import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profilecomponent',
  templateUrl: './profilecomponent.component.html',
  styleUrls: ['./profilecomponent.component.css']
})
export class ProfilecomponentComponent implements OnInit {

  show: boolean = true;
  showString: String = "show";
  
  changeCondition() {
    this.show = !this.show;
    if (this.show == true){
      this.showString = "show";
    } else {
      this.showString = "hide";
    }
  }

  user: String[] = ["Vijay", "25"];

  constructor() { }

  ngOnInit() {
  }

}
