import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-select",
  templateUrl: "./select.component.html",
  styleUrls: ["./select.component.css"]
})
export class SelectComponent implements OnInit {
  

  animals: string[] = ["cat", " dog", " bear", " tiger"];
  isAnimal: boolean = false;
  colors: string[] = ["blue", " light-blue", " sky-blue"];
  isColor: boolean = false;
  days: string[] = ["sunday", "funday", " holiday"];
  isday: boolean = false;

  constructor() {}

  ngOnInit() {}
}
