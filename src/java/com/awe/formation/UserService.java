package com.awe.formation;

/**
 * Created by dzialoszynski on 01/06/19.
 */
public class UserService {
    private LoginAction loginAction;
    private UserPreferences userPreferences;

    public LoginAction getLoginAction() {
        return loginAction;
    }

    public UserPreferences getUserPreferences() {

        return userPreferences;
    }

    public UserService(LoginAction loginAction, UserPreferences userPreferences) {

        this.loginAction = loginAction;
        this.userPreferences = userPreferences;
    }

    public void setLoginAction(LoginAction loginAction) {
        this.loginAction = loginAction;
    }

    public void setUserPreferences(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    public UserService() {
    }
}
