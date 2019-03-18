import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-selectcomponent',
  templateUrl: './selectcomponent.component.html',
  styleUrls: ['./selectcomponent.component.css']
})
export class SelectcomponentComponent implements OnInit {

  animals = ['cat', 'dog', 'llama', 'fish'];
  colors = ['red', 'blue', 'orange'];
  days = ['monday', 'tuesday', 'saturday'];
  
  constructor() { }

  ngOnInit() {
  }

}
