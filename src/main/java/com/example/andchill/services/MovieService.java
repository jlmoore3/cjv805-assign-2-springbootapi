package com.example.andchill.services;

import com.example.andchill.models.Movie;

import com.example.andchill.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* This Service will include validation, calculations, and model calls */
@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // Get everything from the "Movies" collection, regardless of Type
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    // Get only "films"
    public List<Movie> getFilms() {
        Query query = new Query();
        query.addCriteria(Criteria.where("Type").is("Film"));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return movies;
}
// Get only "TV"
    public List<Movie> getTV() {
        Query query = new Query();
        query.addCriteria(Criteria.where("Type").is("TV"));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return movies;
    }

    public void addToMovies(Movie movie) {
        if (!movie.getTitle().isEmpty()) {
            repository.insert(movie);
        }
    }
// Create an endpoint that will retrieve a specific movie or tv show in the database
    public Optional<Movie> getMovieById(String id) {
        Optional<Movie> movie = repository.findById(id);
        if (movie.isEmpty())
        {
            try {
                throw new Exception ("Could not find movie with id: " + id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return movie;
    }

    public List<Movie> getMoviesByGenre(String genre) {
        Query query = new Query();
        query.addCriteria(Criteria.where("Genre").regex(".*" + genre + ".*", "i"));

        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        System.out.println(movies);
        if (movies.size() == 0)
        {
            try {
                throw new Exception ("Could not find movies with genre: " + genre);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

    public List<Movie> getMoviesByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("Title").regex(".*" + title + ".*", "i"));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        if (movies.size() < 1)
        {
            try {
                throw new Exception ("Could not find movies with title: " + title);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

// Create an endpoint that will delete an existing movie or tv show in the database.
    public Optional<Movie> deleteMovie (String id) {
        Optional<Movie> movie = repository.findById(id);
        if (movie.isEmpty())
        {
            try {
                throw new Exception ("Could not find movie with id: " + id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            repository.deleteById(id);
        }
        return movie;
    }
// Create an endpoint that will update and change an existing movie in the database
    public Movie editMovie (String id, Movie newMovieData) {
        Optional<Movie> movie = repository.findById(id);
        if (movie.isEmpty())
        {
            try {
                throw new Exception ("Could not find movie with id: " + id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Update BuyPrice, but only if provided
        if (newMovieData.getBuyPrice() < 0) {
            System.out.println("No Buy Price provided for update; buyPrice not updated");
        }
        else {
            movie.get().setBuyPrice(newMovieData.getBuyPrice());
        }
        //Update RentPrice, but only if provided
        if (newMovieData.getRentPrice() < 0) {
            System.out.println("No Rent Price provided for update; RentPrice not updated");
        }
        else {
            movie.get().setRentPrice(newMovieData.getBuyPrice());
        }
        if (newMovieData.getFeatured() == null) {
            System.out.println("No Featured data provided");
        }
        else{
            movie.get().setFeatured(newMovieData.getFeatured());
        }
        if (newMovieData.getPoster() == null) {
            System.out.println("No poster url data provided");
        }
        else {
            movie.get().setPoster(newMovieData.getPoster());
        }

/*
//Other attributes I don't think the API needs to be able to update
            movie.get().setActors(newMovieData.getActors());
            movie.get().setDirector(newMovieData.getDirector());
            movie.get().setMetascore(newMovieData.getMetascore());
            movie.get().setPlot(newMovieData.getPlot());
            movie.get().setGenre(newMovieData.getGenre());
*/
        Movie updateMovie = repository.save(movie.get());
        return updateMovie;
    }

    /* Get Featured Films or TV by query */
    public List<Movie> getFeaturedFilms(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type.toLowerCase()));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        if (movies.size() < 1)
        {
            try {
                throw new Exception ("Could not find movies with feature type: " + type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

}
