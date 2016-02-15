package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUMS")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@OneToMany(mappedBy = "album")
	private Collection<Song> albumSongs;
//	@ManyToOne
//	private Collection<Artist> artists;

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

	public Collection<Song> getAlbumSongs() {
		return albumSongs;
	}

	public void setAlbumSongs(Collection<Song> albumSongs) {
		this.albumSongs = albumSongs;
	}

	// public Collection<Artist> getArtists() {
	// return artists;
	// }
	//
	// public void setArtists(Collection<Artist> artists) {
	// this.artists = artists;
	// }
}
