import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WatchListService {

  constructor(private http:HttpClient) { }

  addToList(id:number): Observable<[]>
  {
    console.log("Inside the service, id:" + id);
    return this.http.post('http://localhost:9000/notNetflix/addToWatch', id, {withCredentials: true})  as Observable<[]>;
  }
  
}
