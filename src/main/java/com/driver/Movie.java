package com.driver;


public class Movie {
    private String name;
    private int duration ;
    private double imdbRating;

    public String getName(){
        return name;
    }

    public void setMovie(String movie) {
        this.name = movie;
    }

    public int getDurationInMinutes() {
        return duration;
    }

    public void setDurationInMinutes(int duration) {
        this.duration = duration;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    Movie(){

    }
    public  Movie(String name, int duration, double imdbRating){
          this.name = name;
          this.duration = duration;
          this.imdbRating = imdbRating;
      }
}
