package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Remote extends RemoteObserver{

	@TableGenerator(name = "remote_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "remote_gen")
    private long id;
    private double frequency;
    private boolean active;

    public Remote(){
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public RemoteManager getRemoteManager() {
        return remoteManager;
    }

    public void setRemoteManager(RemoteManager remoteManager) {
        this.remoteManager = remoteManager;
    }

    public void  update(double frequency){
        this.frequency = frequency;
    }
    @Override
	public String toString() {
		return "Remote [id=" + id + ", Frequency=" + frequency + ", Active=" + active
				+ "]";
	}
}
