package persistency;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.RemoteManager;

public class RemoteManagerDao implements DaoInterface<RemoteManager> {

	private Session currentSession;
	     
	    private Transaction currentTransaction;
	 
	    public RemoteManagerDao() {
	    }
	 
	    public Session openCurrentSession() {
	        currentSession = getSessionFactory().openSession();
	        return currentSession;
	    }
	 
	    public Session openCurrentSessionwithTransaction() {
	        currentSession = getSessionFactory().openSession();
	        currentTransaction = currentSession.beginTransaction();
	        return currentSession;
	    }
	     
	    public void closeCurrentSession() {
	        currentSession.close();
	    }
	     
	    public void closeCurrentSessionwithTransaction() {
	        currentTransaction.commit();
	        currentSession.close();
	    }
	     
	    private static SessionFactory getSessionFactory() {
	        Configuration configuration = new Configuration().configure();
	        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties());
	        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
	        return sessionFactory;
	    }
	 
	    public Session getCurrentSession() {
	        return currentSession;
	    }
	 
	    public void setCurrentSession(Session currentSession) {
	        this.currentSession = currentSession;
	    }
	 
	    public Transaction getCurrentTransaction() {
	        return currentTransaction;
	    }
	 
	    public void setCurrentTransaction(Transaction currentTransaction) {
	        this.currentTransaction = currentTransaction;
	    }
	 
	    public void persist(RemoteManager entity) {
	        getCurrentSession().save(entity);
	    }
	 
	    public void update(RemoteManager entity) {
	        getCurrentSession().update(entity);
	    }
	 
	    public RemoteManager findById(long id) {
	    	RemoteManager remoteManager = (RemoteManager) getCurrentSession().get(RemoteManager.class, id);
	        return remoteManager;
	    }
	 
	    public void delete(RemoteManager entity) {
	        getCurrentSession().delete(entity);
	    }
	 
	    @SuppressWarnings("unchecked")
	    public List<RemoteManager> findAll() {
	        List<RemoteManager> remoteManagers = (List<RemoteManager>) getCurrentSession().createQuery("from RemoteManager").list();
	        return remoteManagers;
	    }
	    public void deleteAll() {
	        List<RemoteManager> entityList = findAll();
	        for (RemoteManager entity : entityList) {
	            delete(entity);
	        }
	    }
}
