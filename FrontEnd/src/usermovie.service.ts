import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsermovieService {

  addToFavorites(id: number) 
  {
    return this.http.post('http://localhost:8088/notNetflix/addFavorite', id) as Observable<{}>;
  }

  constructor(private http:HttpClient) { }
}
