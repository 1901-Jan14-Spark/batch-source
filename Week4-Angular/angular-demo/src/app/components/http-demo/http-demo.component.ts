import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-http-demo',
  templateUrl: './http-demo.component.html',
  styleUrls: ['./http-demo.component.css']
})
export class HttpDemoComponent implements OnInit {

  constructor(private postService: PostService) { }

  ngOnInit() {
  }

  posts: Post[];

  getPosts(){
    this.postService.getPosts()
      .subscribe((allPosts)=>{
        this.posts = allPosts;
        console.log(this.posts);
      });
  }

}
