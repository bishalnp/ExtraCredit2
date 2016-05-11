package cs544.movie.service;

import java.util.List;

import cs544.movie.model.Artists;

public interface ArtistService {
	void createArtist(Artists artist);

	void updateArtist(int id, Artists artist);

	List<Artists> getAllArtists();

	void deleteArtists(int id);

	Artists getArtistsById(int id);
}
