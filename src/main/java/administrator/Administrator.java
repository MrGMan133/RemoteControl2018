package administrator;

import model.Remote;
import model.RemoteManager;
import persistency.RemoteService;
import utilities.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Administrator {
    private static final Logger log = Logger.getLogger(Administrator.class.getName());
    private RemoteManager remoteManager = new RemoteManager();
    private int amountToMake = 10;
    private RemoteService remoteService = new RemoteService();

    private List<Remote> remotesToSave = new ArrayList<Remote>();

    public void createRemotes(){
        remotesToSave = RandomGenerator.setRemotes(amountToMake);
        for (Remote remote : remotesToSave) {
            log.info("Remote: " + remote.toString() + " created.");
            remoteService.persist(remote);
        }
    }
    public List<Remote> getRemotesToSave() {
        return remotesToSave;
    }
    public List<String> getRemoteInfo(){
        List<String> remoteInfo = new ArrayList<String>();
        for (Remote remote:remotesToSave) {
            remoteInfo.add(remote.toString());
        }
        return  remoteInfo;
    }
    public void activateRemote(Remote remote) {
    	remoteManager.addRemote(remote);
    	remote.setRemoteManager(remoteManager);
    	remote.setActive(true);
    	log.info("Remote: " + remote.toString() + " activated");
    }
    public void deactivateRemote(Remote remote) {
    	remoteManager.removeRemote(remote);
    	remote.setRemoteManager(null);
    	remote.setActive(false);
    	log.info("Remote: " + remote.toString() + " deactivated");
    }
    public void updateFrequency(double frequency) {
    	remoteManager.setFrequency(frequency);
    	log.info("Frequency updated to: " + frequency);
    }
}
