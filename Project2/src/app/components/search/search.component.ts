import { Component, OnInit } from "@angular/core";
import { MovieService } from "src/app/services/movie.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-search",
  templateUrl: "./search.component.html",
  styleUrls: ["./search.component.css"]
})
export class SearchComponent implements OnInit {

  minPage: number = 1;
  maxPage: number = 10;
  buttons: number[] = [];
  searchInput: string = localStorage.getItem("searchInput");
  searchUrl: string;
  movies: Object[] = [];

  imgUrl: string = "http://image.tmdb.org/t/p/w300";

  constructor(private movieservice: MovieService, private route: Router) {}

  ngOnInit() {
    localStorage.setItem("pageIndex", "1");
    this.setUrl();
  }

  getMovieSearch()
  {
    this.movieservice.getMovieSearch()
    .then((res)=>{
      const data = res;
      console.log(data.results);
      this.movies = data.results;
      this.maxPage = data.total_pages;
      this.createButtons();
    })
    .catch((e)=>console.log(e));
  }

  setUrl()
  {
      this.searchUrl = `${this.movieservice.getBaseUrl()}search/movie?${this.movieservice.getApiKey()}&query=${localStorage.getItem("searchInput")}`
      localStorage.setItem("searchUrl", this.searchUrl);
      this.getMovieSearch();
  }

  redirectUrl(id: string) {
    localStorage.setItem("movieId", id);
    this.route.navigateByUrl("movies/movie-detail");
  }

  createButtons()
  {
    console.log("This is called");
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
    this.getMovieSearch();
  }
}
