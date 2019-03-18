import { Component, OnInit } from '@angular/core';
import { PostService } from "src/app/postservice.service";

@Component({
  selector: 'app-fakeusers',
  templateUrl: './fakeusers.component.html',
  styleUrls: ['./fakeusers.component.css']
})
export class FakeusersComponent implements OnInit {

  constructor(private postService: PostService ) { }

  ngOnInit() {
  }

  posts: Post[] = [];

  getPosts() {
    this.postService.getPosts().subscribe(allPosts => {
      this.posts = allPosts;
      console.log(this.posts);
    });

}
}
