import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

  constructor(private userService: UserService) { }
  
  users: User[] = [];
  user: User;
  ngOnInit() {
    this.getUsers();
  }

  getUsers(){
    this.userService.getUsers()
    .subscribe((allUsers: User[])=>{
      this.users = allUsers;
      console.log(this.users);
    });
  }

  populateUsers(){
    
  }
  // getPost(id:number){
  //   this.postService.getPost(id)
  //   .subscribe((post: Post)=>{
  //     this.post = post;
  //     console.log(this.post);
  //   });
  // }

}
