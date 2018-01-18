package administrator;

import model.Remote;
import model.RemoteManager;
import utilities.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Administrator {
    private static final Logger log = Logger.getLogger(Administrator.class.getName());
    private Remote remote;
    private RemoteManager remoteManager;
    private RandomGenerator randomGenerator;
    private int amountToMake = 10;

    private List<Remote> remotesToSave = new ArrayList<Remote>();

    public void createRemotes(){
        remotesToSave = randomGenerator.setRemotes(amountToMake);
        for (Remote remote : remotesToSave) {
            remote.setRemoteManager(remoteManager);
            log.info("Remote: " + remote.toString() + " created.");
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
}
