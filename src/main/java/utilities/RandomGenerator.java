package utilities;

import model.Remote;
import model.RemoteManager;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public static List<Remote> setRemotes(int amount){
        List<Remote> remotes = new ArrayList<Remote>();
        for (int i = 0; i < amount; i++) {
            remotes.add(new Remote());
        }
        return remotes;
    }

}
