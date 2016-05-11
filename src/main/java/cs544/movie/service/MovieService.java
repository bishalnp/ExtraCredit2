package cs544.movie.service;

import java.util.List;

import cs544.movie.model.Movie;

public interface MovieService {

	List<Movie> getAll();

	void createMovie(Movie movie);

	void updateMovie(int id, Movie movie);

	void deleteMovie(int id);

	Movie getMovieById(int id);

	List<Movie> getMovieByName(String name);

	List<Movie> getMovieByYear(int year);

	List<Movie> getByGenres(String genres);

	List<Movie> getByArtists(String name);

	List<Movie> getByDirectors(String name);
}
