import { Component, OnInit} from '@angular/core';
import { User } from 'src/app/models/user';
import { Userlogin } from 'src/app/models/userlogin';
import { NavbarService } from 'src/app/services/navbar.service';
import { SigninService } from 'src/app/services/signin.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  public username:string ="";
  public password:string = "";

  public userLogin:any =null;

  isLoggedIn = false;

  constructor(private signInService: SigninService, private navbarService: NavbarService) { 
    this.navbarService.getLoginStatus().subscribe(status => this.isLoggedIn = status);
  }


  ngOnInit(): void {
    
  }

  loginUser() {
    this.navbarService.updateNavAfterAuth();
    this.navbarService.updateLoginStatus(true);
  }

  signIn():void {

    let userCredentials:Userlogin = {

      username: this.username,
      password: this.password

    }

    this.signInService.signInUser(userCredentials).subscribe(
      (data: User)  => { 
        this.userLogin = data;
        this.loginUser();
        alert("Welcome" + this.userLogin.first_name + " You're Logged In to Account: " + this.userLogin.id);
        // location.assign('userhome'); //use the route path not the app-user-homepage selector!!!
        //this works and sends user to homepage. Now I need to be able to share sign in info w/ userhome & userprofile
      },
    
      () => {
        this.userLogin = null;
        alert("Something went wrong! Please try again.");
        console.log("Something went wrong signing you in!");
      }
    );
  }


}