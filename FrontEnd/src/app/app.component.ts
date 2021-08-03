import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { NavbarService } from './services/navbar.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'FrontEnd';

  links: Array<{ text: string; path: string; }> = [];
  isLoggedIn = false;

  constructor(private router: Router, private navbarService: NavbarService) { 
    this.router.config.unshift(
      { path: 'Not Netflix', component: WelcomeComponent},
      { path: 'Signin', component: SigninComponent },
      { path: 'Signup', component: SignupComponent}

    );
   }




  ngOnInit(): void {
    this.links = this.navbarService.getLinks();
    this.navbarService.getLoginStatus().subscribe(status => this.isLoggedIn = status);
  }

  logout() {
    this.navbarService.updateLoginStatus(false);
    this.router.navigate(['welcome']);
  }





  navbarfixed:boolean = false;

  @HostListener('window:scroll', ['$event']) onscroll() {

    if(window.scrollY > 100) {
      this.navbarfixed = true;
    } else {
      this.navbarfixed = false;
    }
  }
} 
