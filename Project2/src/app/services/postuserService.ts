import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {user} from '../user';

@Injectable({
  providedIn: 'root'
})
export class PostUserService {
    postUrl: string = "http://moviefinder.us-east-2.elasticbeanstalk.com/users";

  constructor(private http: HttpClient) { }

  addUser (user: user): Observable<boolean> { 
    return this.http.post<boolean>(this.postUrl, user);
  }
}
