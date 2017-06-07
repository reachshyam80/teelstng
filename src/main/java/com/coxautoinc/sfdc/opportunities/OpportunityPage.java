package com.coxautoinc.sfdc.opportunities;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coxautoinc.sfdc.utilities.CommonUtil;

/**
 * Page Object for the Opportunity page.
 */
public class OpportunityPage {

    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(OpportunityPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final OpportunitySelector opportunitySelector;
    private final WebDriver driver;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new OpportunityPage object.
     *
     * @param driver in value.
     */
    public OpportunityPage(WebDriver driver) {
        this.commonUtil = new CommonUtil(driver);
        this.driver = driver;
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
    	commonUtil.waitForElementUsingFluentWait(opportunitySelector.getSelectRcdTyp()).click();
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
    /**
     * Method to switch to the Select account name from Pop up
     */
    public void selectAccntName(String accountName) {
        // Store the current window.
        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;

        // Get all available windows.
        Set<String> handles = driver.getWindowHandles();

        // Iterate until new window appears.
        while (handles.size() < 2) {
            handles = driver.getWindowHandles();
        }

        // Set subWindow as the newest window found.
        for (String handle : handles) {
            subWindowHandler = handle;
        }

        // Switch to popup window.
        driver.switchTo().window(subWindowHandler);
        driver.switchTo().frame("resultsFrame");
        // Click OK button.
        commonUtil.waitForElementToBeClickable(By.linkText(accountName)).click();

        // Switch back to the initial window.
        driver.switchTo().window(parentWindowHandler);
    }
    
    public void clickAccntNamePopup(){
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getAddAccntPopup()).click();
    }
    
    public void sendKeysToGlobalSearch(String accntName){
    	logger.info("Entering sendKeysToGlobalSearch", accntName);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(opportunitySelector.getGlobalSearchTextBox()).sendKeys(accntName);
    }
    
    public void clickGlobalSearchBtn(){
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getGlobalSearchButton()).click();
    }
    
    public void clickNewOpptyBtn(){
    	commonUtil.waitForElementUsingFluentWait(opportunitySelector.getNewOpptyBtn()).click();
    }
    
    
    public void sendKeysToAmount(String amount){
    	logger.info("Entering sendKeysToAmount", amount);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(opportunitySelector.getAmountTxt()).sendKeys(amount);
    }
    
    public void sendKeysToDesc(String desc){
    	logger.info("Entering sendKeysToDesc", desc);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(opportunitySelector.getDescTxt()).sendKeys(desc);
    }
    
    public void clickNavigateToOppty(){
    	commonUtil.waitForElementToBeClickable(opportunitySelector.getNavigateToOppty()).click();
    }
    
    /**
     * Method to delete visible opportunities with the specified opportunity name.
     *
     * @param opportunityName in value.
     */
    public void clickDeleteLinkForOpportunitiesByName(String opportunityName) {
        List<WebElement> webElements;
        int numWebElements = driver.findElements(opportunitySelector.getDeleteOpptyLink(opportunityName)).size();
        for (int i = 0; i < numWebElements; i++) {
            logger.info("Deleting test Opportunities with name: '{}'", opportunityName);
            driver.findElement(By.xpath(".//*[@id='0015B00000I9vRO_RelatedOpportunityList_body']/div/a[2]")).click();;
            webElements = driver.findElements(opportunitySelector.getDeleteOpptyLink(opportunityName));

            // Click the top delete link
            webElements.get(0).click();

            // Click Ok
            driver.switchTo().alert().accept();

            // Wait for the page to reload
            //commonUtil.waitForElementToBeClickable(opportunitySelector.getNewOpportunityBtn());
        }
    }
}
