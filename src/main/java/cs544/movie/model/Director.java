package cs544.movie.model;

import javax.persistence.Column;

public class Director extends Artists {
	 @Column(name="director")
	    private String director;
	public Director(String name, String dOB, String birthPlace, String biography, String characters, byte[] picture,
			Movie movie) {
		super(name, dOB, birthPlace, biography, characters, picture, movie);
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}	
}
