package cs544.movie.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Embeddable
@Entity
public class Comment {
	@Id
	@GeneratedValue
	private int commentId;
	private String comment;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Movie movie;

	public Comment() {
	}

	public Comment(String comment, Movie movie) {
		super();
		this.comment = comment;
		this.movie = movie;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Movie getMovieComment() {
		return movie;
	}

	public void setMovieComment(Movie movie) {
		this.movie = movie;
	}

	public int getCommentId() {
		return commentId;
	}
}
