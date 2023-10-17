package use_case.clear_users;

// TODO Complete me

import java.util.ArrayList;

public class ClearOutputData {
    private final ArrayList usernames;


    public ClearOutputData(ArrayList usernames) {
        this.usernames = usernames;
    }
    public ArrayList get_usernames(){return this.usernames;}
}
