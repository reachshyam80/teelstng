package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.By;

public class AddPartnerSelector {
	
	private By partner;
	private By role;
	
	public AddPartnerSelector() {
		init();
	}
	
	public By getPartner() {
		return partner;
	}

	public By getRole() {
		return role;
	}

	/**
     * Method to initialize all selector variables.
     */
    private void init() {
    	partner = By.xpath("//input[@title='Partner 1']");
    	role = By.id("p80");
    }

}
