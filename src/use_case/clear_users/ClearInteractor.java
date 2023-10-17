package use_case.clear_users;

// TODO Complete me

import use_case.login.LoginOutputBoundary;

public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface userDataAccessObject;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface){
        this.userDataAccessObject = userDataAccessInterface;
    }

    public void execute(){
        this.userDataAccessObject.delete();
    }
}
