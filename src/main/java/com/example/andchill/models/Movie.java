package com.example.andchill.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Movies")
public class Movie {

    @Id
    private String id;
    private String Type;
    private String Title;
    private String Plot;
    private String PosterSm;
    private String Poster;
    private String Featured;
    private double RentPrice;
    private double BuyPrice;
    private String Genre;
    private String Actors;
    private int Runtime;
    private int Year;
    private String Rated;
    private String Release;
    private String Ratings;
    private String Director;
    private int Metascore;
    private double imdbRating;

    /* Test Example:
            {"Type": "Film",
            "Title": "Dogma",
            "Plot": "An abortion clinic worker with a special heritage is called upon to save the existence of humanity from being negated by two renegade angels trying to exploit a loop-hole and reenter Heaven.",
            "PosterSm": "https://m.media-amazon.com/images/M/MV5BYzAyOWUyZjQtNDBiMy00ZDExLTgwNmMtZDdmY2ViNzkyN2Y0XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX100.jpg",
            "Poster": "https://m.media-amazon.com/images/M/MV5BYzAyOWUyZjQtNDBiMy00ZDExLTgwNmMtZDdmY2ViNzkyN2Y0XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
            "Featured": "Indie",
            "RentPrice": "3.99",
            "BuyPrice": "9.99",
            "Genre": "Adventure, Comedy, Drama",
            "Actors": "Ben Affleck, Matt Damon, Linda Fiorentino"}

            a.	Movie or TV Show name, - "Title"
            b.	Movie/TV Show price, - redundant, covered by RentPrice and BuyPrice below
            c.	Synopsis of the movie or tv show, - "Plot"
            d.	A value to represent if the item is a movie or tv show - "Type"
            e.	Movie/TV show small poster (image path of the movie/tv show) - "PosterSm"
            f.	Movie/TV  show large poster (image path of the movie /tv show) - "Poster"
            g.	The price to rent the movie or tv show - "RentPrice"
            h.	The price to purchase the movie or tv show outright. - "BuyPrice"
            i.	A field to determine if the movie or tv show is a featured movie or tv show - "Featured"

    Other data to add later for React app

    */

    public Movie() {
    }

    public Movie(String id, String type, String title, String plot, String posterSm, String poster, String featured, double rentPrice, double buyPrice, String genre, String actors, int runtime, int year, String rated, String release, String ratings, String director, int metascore, double imdbRating) {
        this.id = id;
        Type = type;
        Title = title;
        Plot = plot;
        PosterSm = posterSm;
        Poster = poster;
        Featured = featured;
        RentPrice = rentPrice;
        BuyPrice = buyPrice;
        Genre = genre;
        Actors = actors;
        Runtime = runtime;
        Year = year;
        Rated = rated;
        Release = release;
        Ratings = ratings;
        Director = director;
        Metascore = metascore;
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", Type='" + Type + '\'' +
                ", Title='" + Title + '\'' +
                ", Plot='" + Plot + '\'' +
                ", PosterSm='" + PosterSm + '\'' +
                ", Poster='" + Poster + '\'' +
                ", Featured='" + Featured + '\'' +
                ", RentPrice=" + RentPrice +
                ", BuyPrice=" + BuyPrice +
                ", Genre='" + Genre + '\'' +
                ", Actors='" + Actors + '\'' +
                ", Runtime=" + Runtime +
                ", Year=" + Year +
                ", Rated='" + Rated + '\'' +
                ", Release='" + Release + '\'' +
                ", Ratings='" + Ratings + '\'' +
                ", Director='" + Director + '\'' +
                ", Metascore=" + Metascore +
                ", imdbRating=" + imdbRating +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getPosterSm() {
        return PosterSm;
    }

    public void setPosterSm(String posterSm) {
        PosterSm = posterSm;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getFeatured() {
        return Featured;
    }

    public void setFeatured(String featured) {
        Featured = featured;
    }

    public double getRentPrice() {
        return RentPrice;
    }

    public void setRentPrice(double rentPrice) {
        RentPrice = rentPrice;
    }

    public double getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        BuyPrice = buyPrice;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public int getRuntime() {
        return Runtime;
    }

    public void setRuntime(int runtime) {
        Runtime = runtime;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getRelease() {
        return Release;
    }

    public void setRelease(String release) {
        Release = release;
    }

    public String getRatings() {
        return Ratings;
    }

    public void setRatings(String ratings) {
        Ratings = ratings;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public int getMetascore() {
        return Metascore;
    }

    public void setMetascore(int metascore) {
        Metascore = metascore;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}

