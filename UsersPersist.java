package db_services;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Song;
import model.User;

public class UsersPersist {

	private static final Logger LOGGER = Logger.getLogger(UsersPersist.class);
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	/**
	 * Method for registering new user on the server
	 * 
	 * @param user
	 *            - <code>User</code> object
	 * @throws ClassNotFoundException
	 *             if connection driver could not be loaded.
	 * 
	 * @return <b><code>ID</code></b> if successfully is written in DB or <b>
	 *         <code>-1</code></b> if not.
	 */
	public Long addUserInDB(User user) throws ClassNotFoundException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(user);
		session.getTransaction().commit();
		session.close();
		user.setId(id);
		return id;
	}

	public User getUserFromDB(Long id) {

		User user = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		user= (User) session.get(User.class, id);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	public static boolean validateUser(String username, String password) {
		
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//		try {
//			String hql = "FROM User WHERE username=:username AND password=:password";
//			System.out.println(hql);
//			org.hibernate.Query query = session.createQuery(hql);
//			query.setParameter("username", username);
//			query.setParameter("password", password);
//			java.util.List result = query.list();
//
//			System.out.println("resultset:" + result);
//
//			Iterator iterator = result.iterator();
//			if (iterator.hasNext()) {
//				LOGGER.trace("User: " + username + "  is logged successfully!");
//				return true;
//			} else {
//				LOGGER.trace("User " + username + " is not logged successfully!");
//				return false;
//			}
//		} catch (HibernateException e) {
//			if (transaction != null)
//				transaction.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
		User user;

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		user = (User) session.get(User.class, username);
		if (user.getPswd()==password){} // LOGING LOGIC
		return false;
	}


	public static User returnUserById(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User result = (User) session.get(User.class, id);
		session.getTransaction().commit();
		session.close();
		return result;
	}

	// Session session = sessionFactory.openSession();
	// Transaction transaction = null;
	// try {
	// String hql = "FROM User WHERE username=:username AND password=:password";
	// System.out.println(hql);
	// org.hibernate.Query query = session.createQuery(hql);
	// query.setParameter("username", username);
	// query.setParameter("password", password);
	// java.util.List result = query.list();
	//
	// System.out.println("resultset:" + result);
	//
	// Iterator iterator = result.iterator();
	// if (iterator.hasNext()) {
	// LOGGER.trace("User: " + username + " is logged successfully!");
	// return true;
	// } else {
	// LOGGER.trace("User " + username + " is not logged successfully!");
	// return false;
	// }
	// } catch (HibernateException e) {
	// if (transaction != null)
	// transaction.rollback();
	// e.printStackTrace();
	// } finally {
	// session.close();
	// }

	public static User returnUserByName(String usr) {
		User user;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		user = (User) session.get(User.class, usr);
		return user;
	}

	public void updateDB(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
}
