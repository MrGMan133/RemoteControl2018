package persistency;

import java.io.Serializable;

public interface IDAO<T> {
	public void save(T entity);
	public void remove(T entity);
	public Object find(Long id);
	public void update(T entity);
}
