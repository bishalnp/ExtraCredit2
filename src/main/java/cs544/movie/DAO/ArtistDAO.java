package cs544.movie.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.movie.model.Artists;

public interface ArtistDAO extends JpaRepository<Artists, Integer> {
	List<Artists> findByFullName(String fullName);
}
