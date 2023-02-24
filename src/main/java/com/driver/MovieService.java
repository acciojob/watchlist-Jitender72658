package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Service

public class MovieService {
   @Autowired
   MovieRepository movieRepository;
    public void  addMovie(Movie movie){
        movieRepository.getHmMovies().put(movie.getName(),movie);
        movieRepository.getMovieList().add(movie.getName());
    }
    public void  addDirector(Director director){

        movieRepository.getHmDirector().put(director.getName(),director);
    }

    public void addMovieDirectorPair( String movie, String director){
        List<String> list = movieRepository.getHmMovieDirector().get(director);
        list.add(movie);
    }
    public  Movie getMovieByName(String name){
        return movieRepository.getHmMovies().get(name);
    }
    public Director getDirectorByName(String name){
        return movieRepository.getHmDirector().get(name);
    }
    public List<String> getMoviesByDirectorName(String director){

       // return movieRepository.getHmMovieDirector().get(name);
        List<String> moviesList = new ArrayList<String>();
        if(movieRepository.getHmMovieDirector().containsKey(director)) moviesList =movieRepository.getHmMovieDirector().get(director);
        return moviesList;
    }
    public List<String> findAllMovies(){
        return movieRepository.getMovieList();
    }
    public void deleteDirectorByName(String director){
//        movieRepository.getHmMovieDirector().remove(director);
        List<String> movies = new ArrayList<String>();
        if(movieRepository.getHmMovieDirector().containsKey(director)){
            movies = movieRepository.getHmMovieDirector().get(director);
            for(String movie: movies){
                if(movieRepository.getHmMovies().containsKey(movie)){
                    movieRepository.getHmMovies().remove(movie);
                }
            }

            movieRepository.getHmMovieDirector().remove(director);
        }

        if(movieRepository.getHmDirector().containsKey(director)){
            movieRepository.getHmDirector().remove(director);
        }
    }

    public void deleteAllDirector(){

      //  movieRepository.getHmMovieDirector().clear();
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director:movieRepository.getHmMovieDirector().keySet()){
            for(String movie:movieRepository.getHmMovieDirector().get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieRepository.getHmMovies().containsKey(movie)){
                movieRepository.getHmMovies().remove(movie);
            }
        }
    }
}
