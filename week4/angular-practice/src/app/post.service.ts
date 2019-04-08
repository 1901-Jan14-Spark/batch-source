import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  url: string = 'https://jsonplaceholder.typicode.com/users';

  constructor(private http: HttpClient) { }

  getPosts(): Observable<String[]> {
    console.log("getting all posts")
    return this.http.get<String[]>(this.url);
  }
}
