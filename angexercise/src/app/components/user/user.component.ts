import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  user: user[] = [];

  getUsers(){
    this.userService.getUsers().subscribe((allUsers)=>{
      this.user = allUsers;
    })
  }
}
