import { Component, OnInit } from '@angular/core';
import { SigninService } from 'src/app/services/signin.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private signInService: SigninService) { }

  messageTrue = false;

  ngOnInit(): void {
  }



  signIn() {

    let user_name = document.getElementsByName('username');
    let passWord =  document.getElementsByName('password');

    let user_login = {
      username:user_name,
      password:passWord

    }

    this.signInService.signInUser(user_login).subscribe(
      data => {
        console.log(data);
        this.messageTrue = true;
      });


  }




}

  // //This is the function that gets our pokemon object given a user input
  // //getPoke() function goes here...it utilizes the getPokeFromApi() in PokemonService
  // //Thus, it will return an observable. We need to subscribe tp the observable to get its message(data)
  // getPoke():void{
  //   //getPokemonFromApi returns an observable, so we're gonna subscribe to it to see its message
  //   this.ps.getPokemonFromApi(this.input).subscribe(
  //     //we turn the message we get into a pokemon object and assign it to our pokemon variable above
  //     (data:Pokemon) => { this.pokemon = data; },//this happens if things go right

  //     //if things go wrong...set the pokemon variable = null, since we didn't get any data back
  //     () => {
  //       this.pokemon = null; //for readability & to reset input...
  //       console.log("Something went wrong catching your Pokemon!!!");
  //     }

  //   )
  // }