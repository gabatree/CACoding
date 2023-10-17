package interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;

// TODO Complete me
public class ClearController {
    final ClearInputBoundary ClearUseCaseInteractor;
    public ClearController(ClearInputBoundary ClearUseCaseInteractor){
        this.ClearUseCaseInteractor = ClearUseCaseInteractor;
    }
    public void execute(){
        ClearUseCaseInteractor.execute();
    }
}
