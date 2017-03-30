package com.coxautoinc.sfdc.role.based.login;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coxautoinc.sfdc.utilities.CommonUtil;

public class RoleBasedLoginPage {
	 //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(RoleBasedLoginPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final RoleBasedLoginSelector roleBasedLoginSelector;
    //private final WebDriver driver;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new RoleBasedLogin object.
     *
     * @param driver in value.
     */
    public RoleBasedLoginPage(WebDriver driver) {
        this.commonUtil = new CommonUtil(driver);
        //this.driver = driver;
        this.roleBasedLoginSelector = new RoleBasedLoginSelector();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to click the People tab.
     */
    public void clickPeopleTab() {
        logger.info("Clicking clickPeopleTab.");
        commonUtil.waitForElementToBeClickable(roleBasedLoginSelector.getPeopleTab()).click();
    }
    
    public void sendKeysToName(String name){
    	logger.info("Entering sendKeysToName", name);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(roleBasedLoginSelector.getPeopleSearchInput()).sendKeys(name);
    }
    public void clickUserActionMenu() {
        logger.info("Clicking clickUserActionMenu.");
        commonUtil.waitForElementToBeClickable(roleBasedLoginSelector.getUserActionMenu()).click();
    }
    public void clickUserDetailLink() {
        logger.info("Clicking clickUserDetailLink.");
        commonUtil.waitForElementToBeClickable(roleBasedLoginSelector.getUserDetails()).click();
    }
    public void clickLoginBtn() {
        logger.info("Clicking clickLoginBtn.");
        commonUtil.waitForElementToBeClickable(roleBasedLoginSelector.getUserLoginBtn()).click();
    }
    
    public void clickAllTabs() {
        logger.info("Clicking clickAllTabs.");
        commonUtil.waitForElementToBeClickable(roleBasedLoginSelector.getAllTabsMenu()).click();
    }
    
    public void clickLogoutMenu() {
        logger.info("Clicking clickLogoutMenu.");
        commonUtil.waitForElementToBeClickable(roleBasedLoginSelector.getMenuButtonLogout()).click();
    }
    public void clickLogoutLink() {
        logger.info("Clicking clickLogoutLink.");
        commonUtil.waitForElementToBeClickable(roleBasedLoginSelector.getLogoutLink()).click();
    }
}
