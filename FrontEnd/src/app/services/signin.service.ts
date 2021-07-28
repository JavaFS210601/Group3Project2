import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class SigninService {

  constructor(private httpClient:HttpClient) { }


  signInUser(userloginInput : any) {
    return this.httpClient.post('http://localhost:8087/login', userloginInput);
  }
}
