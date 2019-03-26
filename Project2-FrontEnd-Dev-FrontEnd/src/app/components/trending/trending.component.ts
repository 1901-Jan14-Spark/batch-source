import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-trending',
  templateUrl: './trending.component.html',
  styleUrls: ['./trending.component.css']
})
export class TrendingComponent implements OnInit {

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.getTrending();
  }

  movies: Object[] = [];

  imgUrl: string = "http://image.tmdb.org/t/p/w300";

  getTrending() {
    this.movieService.getTrending()
    .then((res)=>{
      const data = res;
      console.log(data.results);
      this.movies = data.results;
    })
    .catch((e)=>console.log(e));
  }

}
