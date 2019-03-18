import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/http.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private httpService: UserService) {}

  users: User[] = [];

  ngOnInit() {
  }

  getUsers(){
    this.httpService.getUsers()
      .subscribe((allUsers)=>{
        this.users = allUsers;
      });
  }

}
