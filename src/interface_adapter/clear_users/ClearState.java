package interface_adapter.clear_users;

// TODO Complete me

import java.util.ArrayList;

public class ClearState {
    private ArrayList<String> users;

    public ClearState(ClearState copy) {
        this.users = copy.users;
    }

    public ClearState(){}

    public ArrayList<String > getUsers() {
        return users;
    }
}
