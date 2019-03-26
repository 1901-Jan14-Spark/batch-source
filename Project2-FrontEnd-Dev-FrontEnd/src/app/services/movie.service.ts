import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  nowPlayingUrl: string = `https://api.themoviedb.org/3/movie/now_playing?api_key=5d0c0be0b57a0b544ed4f305ebcdfee8&language=en-US`;

  upcomingUrl: string = `https://api.themoviedb.org/3/movie/upcoming?api_key=5d0c0be0b57a0b544ed4f305ebcdfee8&language=en-US&region=US`

  trendingUrl: string = `https://api.themoviedb.org/3/movie/popular?api_key=5d0c0be0b57a0b544ed4f305ebcdfee8&language=en-US`

  constructor(private http: HttpClient) { }

  getPopular(): Promise<MoviesModel>{
    console.log("getting all current popular movie");
    return this.http.get<MoviesModel>(this.nowPlayingUrl)
      .toPromise();
  }

  getUpcoming(): Promise<MoviesModel>{
    console.log("getting all current popular movie");
    return this.http.get<MoviesModel>(this.upcomingUrl)
      .toPromise();
  }
  
  getTrending(): Promise<MoviesModel>{
    console.log("getting all current popular movie");
    return this.http.get<MoviesModel>(this.trendingUrl)
      .toPromise();
  }

}
