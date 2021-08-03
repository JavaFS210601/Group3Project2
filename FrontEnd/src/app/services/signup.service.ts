import { HttpClient, HttpStatusCode } from '@angular/common/http';
import { User } from 'src/app/models/user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class SignupService {

  constructor(private http:HttpClient) { }

  signUp(userInfo:any):Observable<{}>
  {
    return this.http.post('http://localhost:9000/notNetflix/accountCreation', userInfo) as Observable<{}>;
  }
}
