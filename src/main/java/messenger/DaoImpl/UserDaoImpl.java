package messenger.DaoImpl;

import java.util.List;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import messenger.Dao.UserDao;
import messenger.Domain.User;

@Service

public class UserDaoImpl implements UserDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public <T> void persistObject(T entity) {
		em.persist(entity);
	}
	
	public <T> T find(Class<T> entityClass, Object primaryKey) {
		return em.find(entityClass, primaryKey);
	}

	public <T> void removeObject(T entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public <T> void mergeObject(T entity) {
		em.merge(entity);
	}

	public User[] getAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT user FROM User user", User.class);
		List<User> resultList = query.getResultList();
		User[] users = new User[resultList.size()];
		users = resultList.toArray(users);
		return users;
	}

	@Override
	public User getUserByName(String username) {
		TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE username = :username", User.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}

	@Override
	public User getUserById(Long userId) {
		TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE userid = :userid", User.class);
		query.setParameter("userid", userId);
		return query.getSingleResult();
	}
	
}