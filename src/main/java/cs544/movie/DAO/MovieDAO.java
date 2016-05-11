package cs544.movie.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs544.movie.model.Movie;
import cs544.movie.service.MovieService;


public class MovieDAO implements MovieService{
	private static int idCount = 1;
	private Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
	public List<Movie> getAll() {
		return new ArrayList<Movie>(movies.values());
	}

	public void createMovie(Movie movie) {
		movie.setMovieId(idCount);
		movies.put(idCount, movie);
		idCount++;
		
	}

	public void updateMovie(int id, Movie movie) {
		movies.put(id, movie);
	}

	public void deleteMovie(int id) {
		Movie removed = movies.remove(id);
		if (removed == null) {
			throw new NoSuchResourceException("Movie", id);
		}
		
	}

	public Movie getMovieById(int id) {
		return movies.get(id);
	}

	public List<Movie> getMovieByName(String name) {
		return new ArrayList<Movie>(movies.values());
	}

	public List<Movie> getMovieByYear(int year) {
		return new ArrayList<Movie>(movies.values());
	}

	public List<Movie> getByGenres(String genres) {
		return new ArrayList<Movie>(movies.values());
	}

	public List<Movie> getByArtists(String name) {
		return new ArrayList<Movie>(movies.values());
	}

	public List<Movie> getByDirectors(String name) {
		return new ArrayList<Movie>(movies.values());
	}
	
}
