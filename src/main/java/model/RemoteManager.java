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

    public void addRemote(RemoteObserver remote){
        remotes.add(remote);
    }
    public void removeRemote(RemoteObserver remote){
        remotes.remove(remote);
    }
    private void updateRemotes(double frequency){
        for (RemoteObserver remote : remotes) {
            remote.update(frequency);
        }
    }
}
