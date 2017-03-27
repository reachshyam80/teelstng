package com.coxautoinc.sfdc.opportunities;

import com.coxautoinc.sfdc.utilities.CommonUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page Object for the Opportunity page.
 */
public class OpportunityPage {

    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(OpportunityPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final OpportunitySelector opportunitySelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new OpportunityPage object.
     *
     * @param driver in value.
     */
    public OpportunityPage(WebDriver driver) {
        this.commonUtil = new CommonUtil(driver);
        this.opportunitySelector = new OpportunitySelector();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to determine if the Add Product button is displayed.
     *
     * @return true if the Add Product button is displayed.
     */

    public boolean isAddProductBtnDisplayed() {
        return commonUtil.waitForElementToBeVisible(opportunitySelector.getAddProductBtn()).isDisplayed();
    }

    /**
     * Method to determine if the New Quote button is displayed.
     *
     * @return true if the New Quote button is displayed.
     */
    public boolean isNewQuoteBtnDisplayed() {
        return commonUtil.waitForElementToBeVisible(opportunitySelector.getNewQuoteBtn()).isDisplayed();
    }

    /**
     * Method to click the Add Product button.
     */
    public void clickAddProductBtn() {
        logger.info("Clicking Add Product button.");
        commonUtil.waitForElementToBeClickable(opportunitySelector.getAddProductBtn()).click();
    }

    /**
     * Method to click the New Quote button.
     */
    public void clickNewQuoteBtn() {
        logger.info("Clicking New Quote button.");
        commonUtil.waitForElementToBeClickable(opportunitySelector.getNewQuoteBtn()).click();
    }
    
    public void clickOpportunitiesTab(){
    	logger.info("Clicking opportunities Tab");
        commonUtil.waitForElementToBeClickable(opportunitySelector.getOppTabNav()).click();
    }
    
    public void sendKeysToOppName(String oppName){
    	logger.info("Entering sendKeysToOppName", oppName);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(opportunitySelector.getOpportunityNameTxt()).sendKeys(oppName);
    }
    
    public void sendKeysToAccntName(String accntName){
    	logger.info("Entering sendKeysToAccountName", accntName);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(opportunitySelector.getAccountNameTxt()).sendKeys(accntName);
    }
    
    public void sendKeysToEndDate(String endDate){
    	logger.info("Entering sendKeysToAccountName", endDate);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(opportunitySelector.getCloseDate()).sendKeys(endDate);
    }
    
    public void selectType(String type){
    	logger.info("Entering selectType");
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
    	//Select type = new Select(driver.findElement(By.id("opp11")));
		//type.selectByIndex(1);
		//opportunitySelector.getSelectType().
		commonUtil.waitForElementToBeVisible(opportunitySelector.getSelectType()).sendKeys(type);;
        //commonUtil.waitForElementToBeVisible(opportunitySelector.getOpportunityNameTxt()).sendKeys(oppName);
    }
    
    public void selectStage(String stage){
    	logger.info("Entering selectStage", stage);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(opportunitySelector.getSelectStage()).sendKeys(stage);
    }
    
    public void saveOpportunity(){
    	logger.info("Entering saveOpportunity");
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getSaveBtn()).click();
    }
    
    public void newOppbtn(){
    	logger.info("Entering newOppbtn");
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getNewbtn()).click();
    }
    
    public void selectRcdTyp(String recType){
    	logger.info("Entering selectRcdTyp");
    	commonUtil.waitForElementToBeVisible(opportunitySelector.getSelectStage()).sendKeys(recType);
    }
    
    public void continueoppcreate(){
    	logger.info("Entering selectRcdTyp");
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getContinueBtn()).click();
    }
    
    public void addCompetitorToOpp(){
    	logger.info("Entering addPartnerToOpp");
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getAddCompetitor()).click();
    }
    
    public void addPartnerToOpp(){
    	logger.info("Entering addPartnerToOpp");
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getAddPartner()).click();
    }
    
    public void addNotesToOpp(){
    	logger.info("Entering addPartnerToOpp");
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getNewNoteBtn()).click();
    }
}
