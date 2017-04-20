package com.coxautoinc.sfdc.role.based.login;

import org.openqa.selenium.By;

public class RoleBasedLoginSelector {
	
	private By peopleTab;
	private By peopleSearchInput;
	private By userLink;
	private By userActionMenu;
	private By userDetails;
	private By userLoginBtn;
	private By allTabsMenu;
	private By buAccountLink;
	private By buAccountLinkSearch;
	private By menuButtonLogout;
	private By logoutLink;
	

	//~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new RoleBasedLoginSelector object.
     */
	public RoleBasedLoginSelector() {
        init();
    }
	
	public By getPeopleTab() {
		return peopleTab;
	}

	public By getPeopleSearchInput() {
		return peopleSearchInput;
	}

	public By getUserLink() {
		return userLink;
	}

	public By getUserActionMenu() {
		return userActionMenu;
	}

	public By getUserDetails() {
		return userDetails;
	}

	public By getUserLoginBtn() {
		return userLoginBtn;
	}

	public By getAllTabsMenu() {
		return allTabsMenu;
	}

	public By getBuAccountLink() {
		return buAccountLink;
	}

	public By getBuAccountLinkSearch() {
		return buAccountLinkSearch;
	}

	public By getMenuButtonLogout() {
		return menuButtonLogout;
	}

	public By getLogoutLink() {
		return logoutLink;
	}

	/**
     * Method to initialize all selector variables.
     */
    private void init() {
    	peopleTab = By.xpath("//a[@title = 'People Tab']");
    	peopleSearchInput = By.id("searchBox:49:input");
    	userActionMenu = By.xpath("//a[@title = 'User Action Menu']");
    	userDetails = By.xpath("//a[@title = 'User Detail']");
    	userLoginBtn = By.name("login");
    	//userLoginBtn = By.xpath(".//*[@id='topButtonRow']/input[4]");
    	//userLoginBtn = By.xpath("//button[@title = 'Login']");
    	allTabsMenu = By.xpath("//img[@title='All Tabs']");
    	buAccountLink = By.linkText("BU Account Team");
    	buAccountLinkSearch = By.linkText("BU Account Team Search");
    	menuButtonLogout = By.className("menuButtonButton");
    	logoutLink = By.linkText("Logout");
    }
}
