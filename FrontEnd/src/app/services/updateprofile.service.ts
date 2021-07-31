import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UpdateprofileService {

  constructor(private http:HttpClient) { }





  updateUserInfo(profileInfo:any): Observable<User> {
    return this.http.post('http://localhost:9000/notNetflix/accountUpdate', profileInfo) as Observable<User>;
  }









}
