package persistency;

import java.util.List;

import model.Remote;

public class RemoteService {
	private static RemoteDAO remoteDAO;

	public RemoteService() {
		remoteDAO = new RemoteDAO();
	}

	public void persist(Remote entity) {
		remoteDAO.openCurrentSessionwithTransaction();
		remoteDAO.persist(entity);
		remoteDAO.closeCurrentSessionwithTransaction();
	}

	public void update(Remote entity) {
		remoteDAO.openCurrentSessionwithTransaction();
		remoteDAO.update(entity);
		remoteDAO.closeCurrentSessionwithTransaction();
	}

	public Remote findById(long id) {
		remoteDAO.openCurrentSession();
		Remote remote = remoteDAO.findById(id);
		remoteDAO.closeCurrentSession();
		return remote;
	}

	public void delete(long id) {
		remoteDAO.openCurrentSessionwithTransaction();
		Remote remote = remoteDAO.findById(id);
		remoteDAO.delete(remote);
		remoteDAO.closeCurrentSessionwithTransaction();
	}

	public List<Remote> findAll() {
		remoteDAO.openCurrentSession();
		List<Remote> remotes = remoteDAO.findAll();
		remoteDAO.closeCurrentSession();
		return remotes;
	}

	public void deleteAll() {
		remoteDAO.openCurrentSessionwithTransaction();
		remoteDAO.deleteAll();
		remoteDAO.closeCurrentSessionwithTransaction();
	}

	public RemoteDAO remoteDao() {
		return remoteDAO;
	}
}
