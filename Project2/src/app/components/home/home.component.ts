import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';
import { Router } from '@angular/router';

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {
  constructor(private movieService: MovieService, private route: Router) {}

  ngOnInit() {
    localStorage.setItem("pageIndex", "1");
    this.getPopular();
  }

  minPage: number = 1;
  maxPage: number = 10;
  buttons: number[] = [];
  movies: Object[] = [];
  imgUrl: string = "http://image.tmdb.org/t/p/w300";

  getPopular() {
    this.movieService.getPopular()
    .then((res)=>{
      const data = res;
      this.movies = data.results;
      this.maxPage = data.total_pages;
      this.createButtons();
    })
    .catch((e)=>console.log(e));
  }

  redirectUrl(id: string) {
    localStorage.setItem("movieId", id);
    this.route.navigateByUrl("movies/movie-detail");
  }

  createButtons()
  {
    this.buttons = [];
    for(let i = this.minPage; i < this.minPage + 10; ++i)
    {
      if (i <= this.maxPage)
        this.buttons.push(i);
    }
  }

  nextClick()
  {
    this.minPage += 10;
    this.createButtons();
  }

  prevClick()
  {
    this.minPage -= 10;
    this.createButtons();
  }

  pageClick(button: string)
  {
    localStorage.setItem("pageIndex", button);
    this.getPopular();
  }
}
