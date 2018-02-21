package com.coxautoinc.sfdc.buform;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coxautoinc.sfdc.opportunities.OpportunityPage;
import com.coxautoinc.sfdc.utilities.CommonUtil;

public class BuFormPage {
	// ~ Static fields/initializers
	// -------------------------------------------------------------------------------------

	private static final Logger logger = LoggerFactory.getLogger(BuFormPage.class);

	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	private final CommonUtil commonUtil;
	private final BuFormSelector BuFormSelector;

	public BuFormPage(WebDriver driver) {

		this.commonUtil = new CommonUtil(driver);
		this.BuFormSelector = new BuFormSelector();

	}
    public void sendKeysToSearch(String search){
    	logger.info("Entering sendkeysotSearch", search);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(BuFormSelector.getSearchOpp()).sendKeys(search);
    }
    public void clickBuOpportunity(){
    	logger.info("Click BUform in Opportunity");
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(BuFormSelector.getSelectBuOpportunity()).click();
        
    }
	
    public void clickBuOpportunityRequest(){
    	logger.info("Click BUform in Opportunity");
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(BuFormSelector.getSelectBuOpportunityRequest()).click();
        
    }
    public void selectRequestType(String type){
    	logger.info("Click BUform in Opportunity", type);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(BuFormSelector.getSelectRequestType()).sendKeys(type);
        
    }

}
