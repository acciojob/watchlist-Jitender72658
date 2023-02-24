package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository

public class MovieRepository {
    private HashMap<String,Movie> hmMovies;
     private    HashMap<String,Director> hmDirector;
    private HashMap<String, List<String>>  hmMovieDirector;

    public MovieRepository(){
        hmMovies = new HashMap<>();
        hmDirector = new HashMap<>();
        hmMovieDirector = new HashMap<>();
   }
    public void  addMovie(Movie movie){
        hmMovies.put(movie.getName(),movie);
    }
    public void  addDirector(Director director){
        hmDirector.put(director.getName(),director);
    }

    public void addMovieDirectorPair( String movie, String director){
        if(hmMovies.containsKey(movie) && hmDirector.containsKey(director)){
            hmMovies.put(movie, hmMovies.get(movie));
            hmDirector.put(director, hmDirector.get(director));
            List<String> currentMovies = new ArrayList<String>();
            if(hmMovieDirector.containsKey(director)) currentMovies = hmMovieDirector.get(director);
            currentMovies.add(movie);
            hmMovieDirector.put(director, currentMovies);
        }
    }
    public  Movie getMovieByName(String name){
        return hmMovies.get(name);
    }
    public Director getDirectorByName(String name){

        return hmDirector.get(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> movieList = new ArrayList<String>();
        if(hmMovieDirector.containsKey(director)) movieList =hmMovieDirector.get(director);
        return movieList;
    }
    public List<String> findAllMovies(){

        return new ArrayList<>(hmMovies.keySet());
    }
    public void deleteDirectorByName(String director){

        List<String> movies = new ArrayList<String>();
        if(hmMovieDirector.containsKey(director)){
            movies = hmMovieDirector.get(director);
            for(String movie: movies){
                if(hmMovies.containsKey(movie)){
                    hmMovies.remove(movie);
                }
            }

            hmMovieDirector.remove(director);
        }

        if(hmDirector.containsKey(director)){
            hmDirector.remove(director);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> moviesSet = new HashSet<String>();

        for(String director:hmMovieDirector.keySet()){
            for(String movie:hmMovieDirector.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(hmMovies.containsKey(movie)){
                hmMovies.remove(movie);
            }
        }
    }
}
