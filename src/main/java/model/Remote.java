package model;

public class Remote extends RemoteObserver{

    private int id;
    private double frequency;
    private boolean active;

    public Remote(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
