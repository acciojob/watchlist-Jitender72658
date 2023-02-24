package com.driver;


public class Movie {
    private String name;
    private int durationInMinutes ;
    private double imdbRating;

    public String getName(){
        return name;
    }

    public void setMovie(String movie) {
        this.name = movie;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int duration) {
        this.durationInMinutes = duration;
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
          this.durationInMinutes = duration;
          this.imdbRating = imdbRating;
      }
}
