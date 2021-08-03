import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie';
<<<<<<< HEAD
=======
import { MovieVideo } from '../models/movie-video';
>>>>>>> ffc1446b4c9c2d445f78ed6c6d34849a13e8e0eb
import { MovieVideoResultsList } from '../models/movie-video-results-list';
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

  getMovieById(id:number):Observable<Movie>
  {
    return this.http.get("https://api.themoviedb.org/3/movie/"+ String(id) +"?api_key=d31f2229dfccbf4519727987a761bc61 ") as Observable<Movie>;
  }

  getMovieVideos(id:String):Observable<MovieVideoResultsList>
  {
    return this.http.get("https://api.themoviedb.org/3/movie/"+String(id)+"/videos?api_key=d31f2229dfccbf4519727987a761bc61&language=en-US") as Observable<MovieVideoResultsList>;
  }


}
