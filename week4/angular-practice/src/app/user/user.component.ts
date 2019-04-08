import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/post.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  posts: String[] = [];

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.getPosts();
  }

  getPosts(){
    this.postService.getPosts().subscribe((allPosts)=>{
        this.posts = allPosts;
      });
    }
}
