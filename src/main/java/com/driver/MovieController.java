package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
     MovieService movieService;
  public MovieController(){

    }
    @PostMapping("/add-movie")
   public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New Movie Added Successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New Director Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
   public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name") String movie,@RequestParam("director") String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New Movie-Director Pair Added Successfully", HttpStatus.CREATED);
    }


    @GetMapping("/getMovieByName")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String name){
        Movie ans =  movieService.getMovieByName(name);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
   public @GetMapping("/getDirectorByName/{name}")
    ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
     Director ans =  movieService.getDirectorByName(name);
       return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

     @GetMapping("/get-movies-by-director-name/{director}")
   public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name){
        List<String> ans =  movieService.getMoviesByDirectorName(name);
         return new ResponseEntity<>(ans, HttpStatus.CREATED);
     }

     @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>>  findAllMovies(){
         List<String> ans = movieService.findAllMovies();
         return new ResponseEntity<>(ans, HttpStatus.CREATED);
     }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(@RequestParam("name") String directorName){
           movieService.deleteDirectorByName(directorName);
         return new ResponseEntity<>("All Movies of "+directorName+" Deleted Successfully", HttpStatus.CREATED);
     }

     @DeleteMapping("/delete-all-directors")
     public ResponseEntity<String>  deleteAllDirectors(){
        movieService.deleteAllDirector();
         return new ResponseEntity<>("Add Directors Deleted Successfully", HttpStatus.CREATED);
     }
}
