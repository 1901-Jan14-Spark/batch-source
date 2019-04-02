import { Component, OnInit } from '@angular/core';
import { PostUserService } from 'src/app/services/postUserService';

@Component({
  selector: 'app-registration-component',
  templateUrl: './registration-component.component.html',
  styleUrls: ['./registration-component.component.css']
})


export class RegistrationComponentComponent implements OnInit {

  constructor(private postuserService: PostUserService) { }
  ngOnInit() {
  }
  showMsg: boolean = false;
  showMsg2: boolean = false;
  
  add(username: string, password: string, email: string,date: string): void {
    if(username == "" || username == undefined || username == null || password == ""){
      return;
    }
    const momentDate = new Date(date); // Replace event.value with your date value
    let sqldate = (String) (momentDate.getFullYear());
    sqldate += "-"+ ((String)(momentDate.getMonth()));
    sqldate += "-"+ ((String)(momentDate.getDay()));
    let user = {username: username,password: password,email:email,birthday: sqldate}
   
    console.log(user);



    this.postuserService.addUser(user).subscribe((response) => {
      console.log('response from post is ', response);
      if (response == true){
      this.showMsg= true;
      this.showMsg2= false;
      }
      else{
        this.showMsg2= true;
        this.showMsg= false;

      }
    }
    );

  } 
  
}
