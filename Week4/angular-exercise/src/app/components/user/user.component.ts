import { Component, OnInit } from "@angular/core";
import { PostService } from "src/app/services/post.service";

@Component({
  selector: "app-user",
  templateUrl: "./user.component.html",
  styleUrls: ["./user.component.css"]
})
export class UserComponent implements OnInit {
  constructor(private postService: PostService) {}

  ngOnInit() {}

  posts: Post[] = [];

  getPosts() {
    this.postService.getPosts().subscribe(allPosts => {
      this.posts = allPosts;
      console.log(this.posts);
    });
  }
}
