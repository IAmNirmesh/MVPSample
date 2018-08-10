package rahul.nirmesh.mvpsample.presenter;

import rahul.nirmesh.mvpsample.model.User;
import rahul.nirmesh.mvpsample.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        if (loginCode == 0)
            loginView.onLoginError("You must enter your Email Id");
        else if (loginCode == 1)
            loginView.onLoginError("You must enter a valid Email Id");
        else if (loginCode == 2)
            loginView.onLoginError("Password should be greater than 6");
        else
            loginView.onLoginSuccess("Login Successfully Done.");
    }
}
