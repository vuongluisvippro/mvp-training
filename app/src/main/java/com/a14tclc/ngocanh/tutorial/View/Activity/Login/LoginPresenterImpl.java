package com.a14tclc.ngocanh.tutorial.View.Activity.Login;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginModel mLoginModel;
    private LoginView mLoginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.mLoginView = loginView;
        mLoginModel = new LoginModelImpl(loginView);
    }

    @Override
    public void login(final String username, String password) {
        mLoginModel.login(username, password);
    }
}
