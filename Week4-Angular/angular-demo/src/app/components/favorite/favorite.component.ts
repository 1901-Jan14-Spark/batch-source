import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  clazz: string = 'glyphicon glyphicon-star-empty';
  isFavorite: boolean = false;

  toggleClass(){
    if(this.clazz=='glyphicon glyphicon-star-empty'){
      this.clazz = 'glyphicon glyphicon-star';
    } else {
      this.clazz = 'glyphicon glyphicon-star-empty'
    }
  }

  changeIsFavorite(){
    this.isFavorite = !this.isFavorite;
  }

}
