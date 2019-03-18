import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[] = [];

  getUsers(){
    this.userService.getUsers()
      .subscribe((allUsers)=>{
        this.users = allUsers;
      });

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

}
