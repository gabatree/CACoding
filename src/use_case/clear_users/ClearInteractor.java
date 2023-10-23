package use_case.clear_users;

// TODO Complete me

import interface_adapter.clear_users.ClearPresenter;
import use_case.login.LoginOutputBoundary;

import java.util.ArrayList;

public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary singnupPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface, ClearOutputBoundary clearOutputBoundary){
        this.userDataAccessObject = userDataAccessInterface;
        this.singnupPresenter = clearOutputBoundary;
    }

    public String execute(){
        ArrayList<String> usernames = this.userDataAccessObject.delete();
        ClearOutputData clearOutputData = new ClearOutputData(usernames);
        String username = "";
        for (String i : clearOutputData.get_usernames()){
            username = username + i + "\n";
        }
        return username;
    }
}
