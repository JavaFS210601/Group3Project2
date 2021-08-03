import { Movie } from "./movie";

export class Moviesearchresults {


    constructor (

        public id:number,
        public results:Movie,
        public total_pages:number,
        public total_results:number

    ){}



}
