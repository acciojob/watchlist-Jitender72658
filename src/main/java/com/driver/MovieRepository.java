package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository

public class MovieRepository {
    private HashMap<String,Movie> hmMovies;
     private    HashMap<String,Director> hmDirector;
    private HashMap<String, List<String>>  hmMovieDirector;

    public HashMap<String, Movie> getHmMovies() {
        return hmMovies;
    }

    public void setHmMovies(HashMap<String, Movie> hmMovies) {
        this.hmMovies = hmMovies;
    }

    public HashMap<String, Director> getHmDirector() {
        return hmDirector;
    }

    public void setHmDirector(HashMap<String, Director> hmDirector) {
        this.hmDirector = hmDirector;
    }

    public HashMap<String, List<String>> getHmMovieDirector() {
        return hmMovieDirector;
    }

    public void setHmMovieDirector(HashMap<String, List<String>> hmMovieDirector) {
        this.hmMovieDirector = hmMovieDirector;
    }

    public List<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<String> movieList) {
        this.movieList = movieList;
    }

    private List<String> movieList;
    MovieRepository(){
        hmMovies = new HashMap<>();
        hmDirector = new HashMap<>();
        hmMovieDirector = new HashMap<>();
        movieList = new ArrayList<>();
    }
}
