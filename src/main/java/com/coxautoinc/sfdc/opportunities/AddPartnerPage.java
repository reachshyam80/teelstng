package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coxautoinc.sfdc.utilities.CommonUtil;

public class AddPartnerPage {
	//~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(OpportunityPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final AddPartnerSelector addPartnerSelector;
    
    
    //~ Constructors ---------------------------------------------------------------------------------------------------

      /**
       * Creates a new AddCompetitorPage object.
       *
       * @param driver in value.
       */
    
    public AddPartnerPage(WebDriver driver){
    	this.commonUtil = new CommonUtil(driver);
    	this.addPartnerSelector = new AddPartnerSelector();
    }
    
    public void sendKeysToPartnerName(String partnerName){
    	logger.info("Entering sendKeysToOppName", partnerName);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(addPartnerSelector.getPartner()).sendKeys(partnerName);
    }
    
    public void sendKeysToPartRole(String role){
    	logger.info("Entering sendKeysToOppName", role);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(addPartnerSelector.getRole()).sendKeys(role);
    }
}
