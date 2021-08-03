import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UpdateprofileService } from 'src/app/services/updateprofile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  profile_id:number = 3;
  profile_firstname:string="gianna";
  profile_lastname:string="williams";
  profile_email:string="gigi93@gmail.com";
  profile_username:string="three";
  profile_password:string="three";
  profile_joindate:any;

  public email:string = "";
  public username:string =""; //should this be allowed to get updated or not?
  public password:string = "";
  public joindate:any;

  public userProfile:any =null;

  constructor(private updateprofileService: UpdateprofileService) { }

  ngOnInit(): void {
  }


  updatePassword():void { //make separate methods for updating each part of profile

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
