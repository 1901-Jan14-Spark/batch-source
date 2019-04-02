import { Component, OnInit } from '@angular/core';
import { PostloginService } from 'src/app/services/postloginService';


@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  constructor(private postloginService: PostloginService) { }

  ngOnInit() {
  }
  showMsg: boolean = false;
  

  tryLogin(uname: string, pass: string, ): void {

    let user2 = {username: uname,password: pass}
    
    console.log(user2);

    this.postloginService.verifyUser(user2).subscribe((response) => {

      console.log('response from post is ', response);
      console.log(response)
      if(response[0] != null){
       
      }else{
        this.showMsg= true;
      }
      
    });
}
}