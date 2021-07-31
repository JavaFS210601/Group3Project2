import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Moviesearchresults } from '../models/moviesearchresults';

@Injectable({
  providedIn: 'root'
})
export class ApimoviesService {







  
  constructor(private http:HttpClient) { }




  searchForMovies(search:string):Observable<Moviesearchresults>
  {
    return this.http.get("https://api.themoviedb.org/3/search/movie?api_key=d31f2229dfccbf4519727987a761bc61&language=en-US&query="+search+"&page=1&include_adult=false") as Observable<Moviesearchresults>;
  }






}
