package persistency;

import model.Remote;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class RemoteDAO implements IDAO<Remote>{
	@SuppressWarnings("unused")
	private EntityTransaction entityTransaction;
	private DAO dao;
	
	EntityManager entityManager = Persistence
			.createEntityManagerFactory("RemoteControl")
			.createEntityManager();
	
	public RemoteDAO() {
		this.entityTransaction = this.entityManager.getTransaction();
		this.dao = new DAO(entityManager);
	}
	public void save(Remote remote) {
		dao.beginTransaction();
		entityManager.persist(remote);
		dao.commitTransaction();
	}
	public void close() {
		dao.closeEntityManager();
	}
	public Remote find(Long id) {
		return entityManager.find(Remote.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Remote> findAll(){
		return entityManager.createQuery("Select r FROM Remote r").getResultList();
	}
	public void update(Remote remote) {
		dao.beginTransaction();
		entityManager.merge(remote);
		dao.commitTransaction();
	}
	public void remove(Remote remote) {
		dao.beginTransaction();
		entityManager.remove(remote);
		dao.commitTransaction();
	}
}
