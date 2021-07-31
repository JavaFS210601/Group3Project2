
import { Component, OnInit } from '@angular/core';
import { Moviesearchresults } from 'src/app/models/moviesearchresults';
import { ApimoviesService } from 'src/app/services/apimovies.service';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {


  public movieSearch:string="";

  public movieSearchResult:any=null;

  constructor(private movieService:ApimoviesService) { }

  ngOnInit(): void {
  }




  searchForMovies():void {

    let movie:string = this.movieSearch;

    this.movieService.searchForMovies(movie).subscribe(
      (data:Moviesearchresults) => {
        this.movieSearchResult = data;
        console.log(this.movieSearchResult);
      },

      () => {
        this.movieSearchResult = null;
        alert("Something went wrong signing you in!");
        console.log("Something went wrong signing you in!");
      }

    );
  }




}
