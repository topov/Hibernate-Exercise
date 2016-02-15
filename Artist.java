package model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ARTISTS")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NAME")
	private String name;
	@OneToMany(mappedBy = "artist")
	private Collection<Song> artistSongs;
//	@OneToMany(mappedBy = "artists")
//	private Collection<Album> artistAlbums;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Song> getArtistSongs() {
		return artistSongs;
	}

	public void setArtistSongs(List<Song> artistSongs) {
		this.artistSongs = artistSongs;
	}

//	public Collection<Album> getArtistAlbums() {
//		return artistAlbums;
//	}
//
//	public void setArtistAlbums(List<Album> artistAlbums) {
//		this.artistAlbums = artistAlbums;
//	}
}
