package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coxautoinc.sfdc.utilities.CommonUtil;

public class AddNotesPage {
	//~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(OpportunityPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final AddNotesSelector addNotesSelector;
    
    
    public AddNotesPage(WebDriver driver) {
    	this.commonUtil = new CommonUtil(driver);
    	this.addNotesSelector = new AddNotesSelector();
	}
    
    public void sendKeysToNoteTitle(String title){
    	logger.info("Entering sendKeysToOppName", title);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(addNotesSelector.getTitleTxt()).sendKeys(title);
    }
    
    public void sendKeysToNoteBody(String body){
    	logger.info("Entering sendKeysToOppName", body);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(addNotesSelector.getBodyTxt()).sendKeys(body);
    }
}
