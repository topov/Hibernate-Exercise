package model;

import java.util.Collection;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import Interfaces.IMemoryObject;

@Entity
@Table(name = "USERS")
public class User implements IMemoryObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PAID_USER")
	private boolean isPaid;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "USER_PATH")
	private String path;
	@Column(name = "PAID_LEVEL")
	private int paid_level;
	@Embedded
	private Address address;
	@ManyToMany(mappedBy = "users")
	private Map<Long, Song> userSongs;
	@Column(name = "PASSWORD")
	String pswd;

	public User(String username, boolean isPaid, String email, String path, int paid_level) {
		this.username = username;
		this.isPaid = isPaid;
		this.email = email;
		this.path = path;
		this.paid_level = paid_level;
	}

	/**
	 * @param username
	 * @param isPaid
	 * @param email
	 * @param path
	 * @param paid_level
	 * @param address
	 * @param userSongs
	 * @param pswd
	 */
	public User(String username, boolean isPaid, String email, String path, int paid_level, Address address,
			Map<Long, Song> userSongs, String pswd) {
		super();
		this.username = username;
		this.isPaid = isPaid;
		this.email = email;
		this.path = path;
		this.paid_level = paid_level;
		this.address = address;
		this.userSongs = userSongs;
		this.pswd = pswd;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setPaid_level(int paid_level) {
		this.paid_level = paid_level;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public String getEmail() {
		return email;
	}

	public String getPath() {
		return path;
	}

	public int getPaid_level() {
		return paid_level;
	}

	@Override
	public Long getId() {
		return this.id;
	}
	
	public String getPswd() {
		return this.pswd;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public Map<Long, Song> getUserSongs() {
		return userSongs;
	}

	public void setUserSongs(Map<Long, Song> userSongs) {
		this.userSongs = userSongs;
	}

}
