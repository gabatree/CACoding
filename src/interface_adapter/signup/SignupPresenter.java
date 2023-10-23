package interface_adapter.signup;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SignupPresenter implements SignupOutputBoundary, ClearOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData response) {
        // On success, switch to the login view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    public void prepareSuccessView2(ClearOutputData clearOutputData) {
        SignupState signupState = signupViewModel.getState();
        ArrayList<String> users = clearOutputData.get_usernames();
        String usernames = "";
        for (String i : users){
            usernames = usernames + i + "\n";
        }
        signupState.setUsername(usernames);
        signupViewModel.firePropertyChanged();
    }
}
