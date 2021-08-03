import { Component, OnInit} from '@angular/core';
import { User } from 'src/app/models/user';
import { Userlogin } from 'src/app/models/userlogin';
import { SigninService } from 'src/app/services/signin.service';
import { UpdateprofileService } from 'src/app/services/updateprofile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  profile_id:any = undefined;
  profile_firstname:any=undefined;
  profile_lastname:any=undefined;
  profile_email:any=undefined;
  profile_username:any=undefined;
  profile_password:any=undefined;
  profile_joindate:any = undefined;

  public email:string = "";
  public username:string =""; //should this be allowed to get updated or not?
  public password:string = "";
  public joindate:any;

  public userProfile:any =null;

  // hiddenToggle:boolean = true;

  constructor(private updateprofileService: UpdateprofileService, private signInService: SigninService) { }

  ngOnInit(): void {
  }

//change the value "hidden" variable to the opposite of what it is
  // toggleVisibility(){
  //   this.hiddenToggle = !this.hiddenToggle 
    
  // } 

  signIn():void {

    let userCredentials:Userlogin = {

      username: this.username,
      password: this.password

    }

    this.signInService.signInUser(userCredentials).subscribe(
      (data: User)  => { 
        this.userProfile = data;
        console.log(this.userProfile);

        const head1 = document.getElementById("profileTableHead"); 
        const h1 = document.createElement("h6")
        h1.textContent = "ID"; 
        head1?.appendChild(h1);

        const cell1 = document.getElementById("profileTableHead"); 
        const c1 = document.createElement("p")
        c1.textContent = this.userProfile.id; 
        cell1?.appendChild(c1);

        const head2 = document.getElementById("profileTableHead"); 
        const h2 = document.createElement("h6")
        h2.textContent = "First Name"; 
        head2?.appendChild(h2);

        const cell2 = document.getElementById("profileTableHead");
        const c2 = document.createElement("p"); 
        c2.innerHTML = this.userProfile.first_name; 
        cell2?.appendChild(c2);

        const head3 = document.getElementById("profileTableHead"); 
        const h3 = document.createElement("h6")
        h3.textContent = "Last Name"; 
        head3?.appendChild(h3);

        const cell3 = document.getElementById("profileTableHead");
        const c3 = document.createElement("p"); 
        c3.innerHTML = this.userProfile.last_name; 
        cell3?.appendChild(c3);

        const head4 = document.getElementById("profileTableHead"); 
        const h4 = document.createElement("h6")
        h4.textContent = "Username"; 
        head4?.appendChild(h4);

        const cell4 = document.getElementById("profileTableHead");
        const c4 = document.createElement("p"); 
        c4.innerHTML = this.userProfile.username; 
        cell4?.appendChild(c4);
      },
    
      () => {
        this.userProfile = null;
        alert("Something went wrong! Please try again.");
        console.log("Something went wrong signing you in!");
      }
    );
    // document.getElementById("viewInfoButton")?.addEventListener('onclick', this.toggleVisibility);
  }

  updatePassword():void {

    let profileInfo:User = {

      id: this.profile_id,
      first_name: this.profile_firstname,
      last_name: this.profile_firstname,
      email: this.profile_email,
      username: this.profile_username,
      password: this.password,
      join_date: this.joindate
    }

    this.updateprofileService.updateUserInfo(profileInfo).subscribe(
      (data: User)  => { 
        this.userProfile = data;
        console.log(this.userProfile);
      },
    
      () => {
        this.userProfile = null;
        alert("Something went wrong signing you in!");
        console.log("Something went wrong signing you in!");
      }
      );
  }


  updateEmail():void {

    let profileInfo:User = {

      id: this.profile_id,
      first_name: this.profile_firstname,
      last_name: this.profile_lastname,
      email: this.email,
      username: this.profile_username,
      password: this.profile_password,
      join_date: this.joindate
    }

    this.updateprofileService.updateUserInfo(profileInfo).subscribe(
      (data: User)  => { 
        this.userProfile = data;
        console.log(this.userProfile);
      },
    
      () => {
        this.userProfile = null;
        alert("Something went wrong signing you in!");
        console.log("Something went wrong signing you in!");
      }
      );
  }





}

