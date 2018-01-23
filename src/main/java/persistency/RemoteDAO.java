package persistency;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.Remote;

public class RemoteDAO implements DaoInterface<Remote> {

	private Session currentSession;
	     
	    private Transaction currentTransaction;
	 
	    public RemoteDAO() {
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
	 
	    public void persist(Remote entity) {
	        getCurrentSession().save(entity);
	    }
	 
	    public void update(Remote entity) {
	        getCurrentSession().update(entity);
	    }
	 
	    public Remote findById(long id) {
	    	Remote remote = (Remote) getCurrentSession().get(Remote.class, id);
	        return remote;
	    }
	 
	    public void delete(Remote entity) {
	        getCurrentSession().delete(entity);
	    }
	 
	    @SuppressWarnings("unchecked")
	    public List<Remote> findAll() {
	        List<Remote> remotes = (List<Remote>) getCurrentSession().createQuery("from Remote").list();
	        return remotes;
	    }
	    public void deleteAll() {
	        List<Remote> entityList = findAll();
	        for (Remote entity : entityList) {
	            delete(entity);
	        }
	    }

}
