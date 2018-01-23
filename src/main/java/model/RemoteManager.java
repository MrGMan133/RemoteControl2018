package model;

import java.util.ArrayList;
import java.util.List;

public class RemoteManager {
    private double frequency;
    private List<RemoteObserver> remotes = new ArrayList<RemoteObserver>();

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
        updateRemotes(frequency);
    }
    
    public List<RemoteObserver> getRemotes() {
		return remotes;
	}

	public void addRemote(RemoteObserver remote){
        remotes.add(remote);
        remote.setActive(true);
    }
    public void removeRemote(RemoteObserver remote){
        remotes.remove(remote);
        remote.setActive(false);
    }
    private void updateRemotes(double frequency){
        for (RemoteObserver remote : remotes) {
            remote.update(frequency);
        }
    }
    public boolean actionRequest(Remote remote) {
    	boolean output = false;
    	if (isRemoteActive(remote)) {
			if (this.getFrequency() == remote.getFrequency()) {
				output = true;
			}
		}
    	return output;
    }
    private boolean isRemoteActive(Remote remote) {
    	boolean output = false;
    	if (remotes.contains(remote)) {
			output = true;
		}
    	return output;
    }
}
