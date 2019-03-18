import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  list: string[];


  selectRadio(event){
    let val = event.target.value;
    if(val === "animals"){
      this.list = ["Cow", "Dog", "Cat", "Fox", "Mouse"];
    } else if(val === "colors"){
      this.list = ["Blue", "Green", "Red", "Purple", "Magenta", "Yellow"];
    } else{
      this.list = ["Monday", "Wednesday", "Friday", "Sunday"];
    }
  }
}
