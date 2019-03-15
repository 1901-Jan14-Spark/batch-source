import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-a-directives',
  templateUrl: './a-directives.component.html',
  styleUrls: ['./a-directives.component.css']
})
export class ADirectivesComponent implements OnInit {

  colors: string[] = ['blue', 'green', 'red'];
  isChecked: boolean = false;
  classes: string[] = ['italic','bold','highlight'];
  selectedClasses: string[] = [];

  constructor() { }

  ngOnInit() {
  }

  updateClasses(event){
    this.selectedClasses = [];
    let opt = event.target.options;

    for(let i=0; i<opt.length; i++){
      if(opt[i].selected){
        this.selectedClasses.push(opt[i].text)
      }
    }

  }

}
