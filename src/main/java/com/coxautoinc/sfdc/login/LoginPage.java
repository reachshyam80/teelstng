package com.coxautoinc.sfdc.login;

import com.coxautoinc.sfdc.utilities.CommonUtil;

import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Login page.
 */
public class LoginPage {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final LoginSelector loginSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new LoginPage object.
     *
     * @param driver in value.
     */
    public LoginPage(WebDriver driver) {
        this.commonUtil = new CommonUtil(driver);
        this.loginSelector = new LoginSelector();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to log in to SFDC using specified credentials.
     *
     * @param username in value.
     * @param password in value.
     */
    public void loginToSalesForce(String username, String password) {
        sendKeysToUserNameInputField(username);
        sendKeysToPasswordInputField(password);
        clickSalesForceLoginBtn();
    }

    /**
     * Method to click the login button of SalesForce.
     */
    private void clickSalesForceLoginBtn() {
        commonUtil.waitForElementToBeClickable(loginSelector.getLoginBtn()).click();
    }

    /**
     * Method to send keys to the password input field of SalesForce.
     *
     * @param input in value.
     */
    private void sendKeysToPasswordInputField(String input) {
        commonUtil.waitForElementToBeVisible(loginSelector.getPasswordInputBx()).clear();
        commonUtil.waitForElementToBeVisible(loginSelector.getPasswordInputBx()).sendKeys(input);
    }

    /**
     * Method to send keys to the username input field of SalesForce
     *
     * @param input in value
     */
    private void sendKeysToUserNameInputField(String input) {
        commonUtil.waitForElementToBeVisible(loginSelector.getUserNameInputBx()).clear();
        commonUtil.waitForElementToBeVisible(loginSelector.getUserNameInputBx()).sendKeys(input);
    }
}
