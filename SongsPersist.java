package db_services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Song;
import model.User;

public class SongsPersist {

	private static final Logger LOGGER = Logger.getLogger(SongsPersist.class);
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	/**
	 * Method for adding a song in DB
	 * 
	 * @param song
	 * @throws ClassNotFoundException
	 *             if the connection driver could not be loaded.
	 * @return <b><code>true</code></b> if successfully is written in DB or <b>
	 *         <code>false</code></b> if not.
	 */
<<<<<<< HEAD
	public Long addSongInDB(Song song) throws ClassNotFoundException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(song);
		session.getTransaction().commit();
		session.close();
		return id;
	}
=======
>>>>>>> 38385d1cddd7536f053e92b2f4b510fd54b0a8b8

	public ArrayList<Song> getSongsForUser(Long id) throws ClassNotFoundException {

		ArrayList<Song> songs = new ArrayList<>();
<<<<<<< HEAD
//		Session session = sessionFactory.openSession();
//		try {
//			String hql = "FROM Song WHERE user_id=:user_id";
//			System.out.println(hql);
//			org.hibernate.Query query = session.createQuery(hql);
//			query.setParameter("user_id", id);
//			List result = query.list();
//			if (songs.addAll(result)) {
//				LOGGER.trace("Songs for user " + id + " are got successfully!");
//			} else {
//				LOGGER.trace("Songs for user " + id + " are got UNsuccessfully!");
//			}
//
//			return songs;
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			LOGGER.error("Can't get Songs! Error !" + e.getMessage());
//		} finally {
//			session.close();
//		}
//		return songs;
=======
>>>>>>> 38385d1cddd7536f053e92b2f4b510fd54b0a8b8
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Song result = session.get(Song.class, id); // USER ID ???????
		session.getTransaction().commit();
		session.close();
		return songs;
	}

	public Long addSongInDB(Song song) throws ClassNotFoundException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(song);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	public void deleteSongDB(Long songID) throws ClassNotFoundException {
		Song song;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
<<<<<<< HEAD
		if((song = (Song) session.get(Song.class, songID))!=null) {
		session.delete(song);
		}
		else {}//LOGGER
		session.getTransaction().commit();
		session.close();
		
=======
		if ((song = (Song) session.get(Song.class, songID)) != null) {
			session.delete(song);
		} else {
		} // LOGGER
		session.getTransaction().commit();
		session.close();

>>>>>>> 38385d1cddd7536f053e92b2f4b510fd54b0a8b8
	}
}
