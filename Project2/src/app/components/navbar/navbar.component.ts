import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router:Router) { }

  inputValue: string;

  ngOnInit() {
  }

  generateUrl()
  {
    if(this.inputValue)
    {
      localStorage.setItem("searchInput", this.inputValue);
      this.inputValue = "";
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate(["/search"]));
    }
  }
}
