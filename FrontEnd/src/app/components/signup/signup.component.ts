import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public username:string="";
  public password:string="";
  public first_name:string="";
  public last_name:string="";
  public email:string="";

  constructor(private signUpService:SignupService) { }

  ngOnInit(): void {
  }

  signUp():void
  {
    let userInfo:User ={
    id:0,
    username:this.username,
    password:this.password,
    first_name:this.first_name,
    last_name:this.last_name,
    email:this.email,
    join_date:Date.now()
    }
    console.log(userInfo);

    this.signUpService.signUp(userInfo).subscribe(
      
    )

  }

}
