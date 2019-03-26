import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-upcoming',
  templateUrl: './upcoming.component.html',
  styleUrls: ['./upcoming.component.css']
})
export class UpcomingComponent implements OnInit {

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.getUpcoming();
  }

  movies: object[] = [];

  imgUrl: string = "http://image.tmdb.org/t/p/w300";

  getUpcoming() {
    this.movieService.getUpcoming()
    .then((res)=>{
      const data = res;
      console.log(data.results);
      this.movies = data.results;
    })
    .catch((e)=>console.log(e));
  }

}
