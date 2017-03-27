package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coxautoinc.sfdc.utilities.CommonUtil;

public class AddCompetitorPage {
	//~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(OpportunityPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final AddCompetitorSelector addCompetitorSelector;
    
  //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new AddCompetitorPage object.
     *
     * @param driver in value.
     */
    public AddCompetitorPage(WebDriver driver) {
        this.commonUtil = new CommonUtil(driver);
        this.addCompetitorSelector = new AddCompetitorSelector();
    }
    
    public void sendKeysToCompName(String compName){
    	logger.info("Entering sendKeysToOppName", compName);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(addCompetitorSelector.getCompetitorName()).sendKeys(compName);
    }
    
    public void sendKeysToCompStrength(String strength){
    	logger.info("Entering sendKeysToOppName", strength);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(addCompetitorSelector.getStrengths()).sendKeys(strength);
    }
    
    public void sendKeysToCompWeakness(String weakness){
    	logger.info("Entering sendKeysToOppName", weakness);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(addCompetitorSelector.getWeaknesses()).sendKeys(weakness);
    }
}
