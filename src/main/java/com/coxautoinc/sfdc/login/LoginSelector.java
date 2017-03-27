package com.coxautoinc.sfdc.login;

import org.openqa.selenium.By;

/**
 * Selector class for the Login page.
 */
class LoginSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By loginBtn = By.id("Login");
    private By passwordInputBx = By.id("password");
    private By userNameInputBx = By.id("username");

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new LoginSelector object.
     */
    LoginSelector() {
        init();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    By getLoginBtn() {
        return loginBtn;
    }

    By getPasswordInputBx() {
        return passwordInputBx;
    }

    By getUserNameInputBx() {
        return userNameInputBx;
    }

    /**
     * Method to initialize all selector variables.
     */
    private void init() {
        passwordInputBx = By.id("password");
        userNameInputBx = By.id("username");
        loginBtn = By.id("Login");
    }
}
