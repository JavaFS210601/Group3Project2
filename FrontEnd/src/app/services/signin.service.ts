import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { Userlogin } from '../models/userlogin';


@Injectable({
  providedIn: 'root'
})


export class SigninService {


  constructor(private http:HttpClient) { }



  signInUser(userCredentials:any): Observable<User> {
    return this.http.post('http://localhost:9000/notNetflix/login', userCredentials) as Observable<User>;
  }
}