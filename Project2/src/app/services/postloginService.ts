import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import { user2 } from '../user2';
import { NgIf } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class PostloginService {
    postUrl: string = "http://moviefinder.us-east-2.elasticbeanstalk.com/users";

  constructor(private http: HttpClient) { }

  verifyUser (user2: user2): Observable<user2> { 
    return this.http.post<user2>(this.postUrl, user2 );
  }
}
