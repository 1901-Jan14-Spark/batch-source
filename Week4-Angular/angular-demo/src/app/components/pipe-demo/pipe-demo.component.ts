import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe-demo',
  templateUrl: './pipe-demo.component.html',
  styleUrls: ['./pipe-demo.component.css']
})
export class PipeDemoComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  str: string = 'hello';
  num: number = 5;
  day: Date = new Date();

  strArr: string[] = ['cAt', 'doG', 'raBBiT', 'FoX'];
  strArr2: string[] = ['string-cheese','fuji-apples','chocolate-ice-cream'];

}
