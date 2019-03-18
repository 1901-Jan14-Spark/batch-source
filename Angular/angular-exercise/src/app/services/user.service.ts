import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  
  url: string = 'https://jsonplaceholder.typicode.com/users';

getUsers(): Observable<User[]>{
  console.log("Getting all users");
  return this.http.get<User[]>(this.url);
}

// getUser(id: number): Promise<User>{
//   console.log("Getting user with id: " + id);
//   return this.http.get<User>(this.url + "/" +id).toPromise();
// }

}