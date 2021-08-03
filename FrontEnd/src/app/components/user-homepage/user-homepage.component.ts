
import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { MovieVideo } from 'src/app/models/movie-video';
import { MovieVideoResultsList } from 'src/app/models/movie-video-results-list';
import { Moviesearchresults } from 'src/app/models/moviesearchresults';
import { ApimoviesService } from 'src/app/services/apimovies.service';
import { DomSanitizer, SafeResourceUrl, SafeUrl} from '@angular/platform-browser';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})

export class UserHomepageComponent implements OnInit {


  public movieSearch:string="";

  public videoSearch:string="";

  public movieSearchResult:any=null;

  public fullResults:Array<Movie> = [];

  public movieVideoResults:any=null;

  public movieVideos:Array<MovieVideo> = [];

  constructor(private movieService:ApimoviesService, private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
  }




  searchForMovies():void {

    let movie:string = this.movieSearch;

    this.movieService.searchForMovies(movie).subscribe(
      (data:Moviesearchresults) => {
        this.movieSearchResult = data;
        console.log(this.movieSearchResult);

        //Get the actual information from each item in movieSearchResult.results
        for(let oneMovie of this.movieSearchResult.results)
        {
          // console.log(oneMovie);
          //get back one item by the id
          this.movieService.getMovieById(oneMovie.id).subscribe(
            (data:Movie) => {
              this.fullResults.push(data);
            }
          )
        }
        //loop through the list of search results to get one video for each 
        for(let oneMovie of this.fullResults)
        {
          //get the list of videos for the movie we're on in the loop
          this.movieService.getMovieVideos(String(oneMovie.id)).subscribe(
            //if we get smething back...
            (data:MovieVideoResultsList) =>{
              //put the first result's video url in the movie object's video_url field
              this.movieVideoResults = data
              console.log("data = "+ this.movieVideoResults.results[0].key);
              oneMovie.video_url = "https://www.youtube.com/embed/" + this.movieVideoResults.results[0].key;
              // this.sanitizer.bypassSecurityTrustUrl(oneMovie.video_url)
              oneMovie.safe_url = this.sanitizer.bypassSecurityTrustResourceUrl(oneMovie.video_url);
              console.log("oneMovie.video_url: " + oneMovie.video_url)
            }
          )
          // console.log("oneMovie = " + oneMovie.video_url);
        }
        console.log("fullResults = " + this.fullResults);

      },//End of if we get something back
      
      //If we get nothing back
      () => {
        this.movieSearchResult = null;
        alert("Something went wrong signing you in!");
        console.log("Something went wrong signing you in!");
      }

    );
  }

  searchForMovieVideos():void {
    // console.log(this.videoSearch);
    this.fullResults = [];

    this.movieService.getMovieVideos(this.videoSearch).subscribe(
      (data:MovieVideoResultsList) => {
        this.movieVideoResults = data;
        // console.log(this.movieVideoResults);
        for(let one of this.movieVideoResults.results)
        {
          this.sanitizer.bypassSecurityTrustUrl(one.key)
          this.movieVideos.push(one);
        }
      }
    )
  }
 
//   public sanitizeVideo(aString:string)
// {
//   console.log(aString);
//   return this.sanitizer.bypassSecurityTrustResourceUrl(aString);
// }
<<<<<<< HEAD

}

=======
>>>>>>> ffc1446b4c9c2d445f78ed6c6d34849a13e8e0eb

}


<<<<<<< HEAD
=======


>>>>>>> ffc1446b4c9c2d445f78ed6c6d34849a13e8e0eb
// function removeElementsByClass(className: string){
//   const elements = document.getElementsByClassName(className);
//   while(elements.length > 0){
//       elements[0].parentNode.removeChild(elements[0]);
//   }
<<<<<<< HEAD
// }
// import { Component, OnInit } from '@angular/core';
// import { Moviesearchresults } from 'src/app/models/moviesearchresults';
// import { ApimoviesService } from 'src/app/services/apimovies.service';


// @Component({
//   selector: 'app-user-homepage',
//   templateUrl: './user-homepage.component.html',
//   styleUrls: ['./user-homepage.component.css']
// })
// export class UserHomepageComponent implements OnInit {

//   public movieSearch:string="";

//   public movieSearchResult:any=null;

//   constructor(private movieService:ApimoviesService) {

//    }

//   ngOnInit(): void {

//   }

//   searchForMovies():void {

//     let movie:string = this.movieSearch;

//     this.movieService.searchForMovies(movie).subscribe(
//       (data:Moviesearchresults) => {
//         this.movieSearchResult = data;
//         console.log(this.movieSearchResult);
//       },

//       () => {
//         this.movieSearchResult = null;
//         alert("Something went wrong signing you in!");
//         console.log("Something went wrong signing you in!");
//       }

//     );
//   }
// }
=======
// }
>>>>>>> ffc1446b4c9c2d445f78ed6c6d34849a13e8e0eb
