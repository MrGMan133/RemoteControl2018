package model;

import model.RemoteManager;

abstract class RemoteObserver {
    protected RemoteManager remoteManager;
    public abstract void update(double frequency);
    public abstract void setActive(boolean active);
}
