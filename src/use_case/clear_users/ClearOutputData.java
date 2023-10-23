package use_case.clear_users;

// TODO Complete me

import java.util.ArrayList;
import java.util.SplittableRandom;

public class ClearOutputData {
    private final ArrayList<String > usernames;

    public ClearOutputData(ArrayList<String> usernames) {
        this.usernames = usernames;
    }
    public ArrayList<String> get_usernames(){return this.usernames;}
}
