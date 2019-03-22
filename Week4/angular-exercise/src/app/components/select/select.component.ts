import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-select",
  templateUrl: "./select.component.html",
  styleUrls: ["./select.component.css"]
})
export class SelectComponent implements OnInit {
  

  animals: string[] = ["cat", " dog", " bear", " tiger"];
  colors: string[] = ["blue", " light-blue", " sky-blue"];
  days: string[] = ["sunday", "funday", " holiday"];

  ltype = null;

  constructor() {}

  ngOnInit() {}
}
