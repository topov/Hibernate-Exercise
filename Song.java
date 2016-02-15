package model;

<<<<<<< HEAD
import javax.persistence.Embedded;
=======
import java.util.Collection;

import javax.persistence.Column;
>>>>>>> 38385d1cddd7536f053e92b2f4b510fd54b0a8b8
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;
import Interfaces.IMemoryObject;


@Entity
@Table(name = "files")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String filename;
	private String path;
	private long user_id;
	private String artist;
	private boolean isPublic;
	
	public Song (String filename,String path,long user_id,String artist,boolean isPublic) {
		this.filename=filename;
		this.path=path;
		this.user_id=user_id;
		this.artist=artist;
		this.isPublic=isPublic;
		}

	public String getFilename() {
		return filename;
	}
=======
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Interfaces.IMemoryObject;

@Entity
@Table(name = "SONGS")
public class Song implements IMemoryObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "PATH")
	private String path;
	@ManyToOne
	private Artist artist;
	@Column(name = "DURATION")
	private int duration;
	@Column(name = "TITLE")
	private String title;
	@ManyToOne
	private Album album;
	@Column(name = "HASHCODE")
	private String hashCode;
	@ManyToMany
	private Collection<User> users;
>>>>>>> 38385d1cddd7536f053e92b2f4b510fd54b0a8b8

	public String getPath() {
		return path;
	}

<<<<<<< HEAD
	public long getUser_id() {
		return user_id;
	}

	public String getArtist() {
		return artist;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
=======
	public void setPath(String path) {
		this.path = path;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
>>>>>>> 38385d1cddd7536f053e92b2f4b510fd54b0a8b8

}
