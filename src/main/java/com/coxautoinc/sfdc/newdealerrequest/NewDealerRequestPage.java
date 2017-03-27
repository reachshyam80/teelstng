package com.coxautoinc.sfdc.newdealerrequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coxautoinc.sfdc.opportunities.OpportunityPage;
import com.coxautoinc.sfdc.utilities.CommonUtil;

public class NewDealerRequestPage {
	//~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(OpportunityPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final NewDealerRequestSelector newDealerRequestSelector;
    
    public NewDealerRequestPage(WebDriver driver) {
    	this.commonUtil = new CommonUtil(driver);
    	this.newDealerRequestSelector = new NewDealerRequestSelector();
	}
    
    public void sendKeysToUrgentReq(String value){
    	logger.info("Entering sendKeysToUrgentReq", value);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
    	if(value == ""){
    		new Select(commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getSelectUrgReq())).selectByIndex(2);
    	}else
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getSelectUrgReq()).sendKeys(value);
    }
    
    public void sendKeysToSubmit(String value){
    	logger.info("Entering sendKeysToSubmit", value);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
    	if((null != value) && (value.equalsIgnoreCase("No") && (commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getCheckSubmit()).isSelected()))){
    		commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getCheckSubmit()).click();
    	}
        
    }
    
    public void sendKeysToOwnershipChng(String value){
    	logger.info("Entering sendKeysToOwnershipChng", value);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getSelectOwnershipChange()).sendKeys(value);
    }
    
    public void sendKeysToAccntName(String accntName){
    	logger.info("Entering sendKeysToAccntName", accntName);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getAccntName()).sendKeys(accntName);
    }
    
    public void sendKeysToDealerGrp(String dealerGrp){
    	logger.info("Entering sendKeysToDealerGrp", dealerGrp);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getSelDealerGrp()).sendKeys(dealerGrp);
    }
    
    public void sendKeysToDealerGrpAccnt(String dealerGrpAccnt){
    	logger.info("Entering sendKeysToDealerGrpAccnt", dealerGrpAccnt);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getDealerGrpAccnt()).sendKeys(dealerGrpAccnt);
    }
    
    public void sendKeysToDealerType(String dealerTyp){
    	logger.info("Entering sendKeysToDealerType", dealerTyp);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getDealerType()).sendKeys(dealerTyp);
    }
    
    public void selectNamePlate(String namePlate){
    	logger.info("Entering selectNamePlate", namePlate);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
    	for (int i = 1; i <= 4; i++)
			new Select(commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getNamePlate())).selectByIndex(i);
        //commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getNamePlate()).sendKeys(namePlate);
    }
    
    public void sendKeysToURL(String url){
    	logger.info("Entering sendKeysToOppName", url);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getCustWebsiteUrl()).sendKeys(url);
    }
    
    public void sendKeysToSelCustTyp(String custTyp){
    	logger.info("Entering sendKeysToOppName", custTyp);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getCustType()).sendKeys(custTyp);
    }
    
    public void sendKeysToSelNewLotSize(String lotSize){
    	logger.info("Entering sendKeysToOppName", lotSize);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getLotSizeNew()).sendKeys(lotSize);
    }
    
    public void sendKeysToSelLotSizeUsed(String lotSize){
    	logger.info("Entering sendKeysToOppName", lotSize);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getLotSizeUsed()).sendKeys(lotSize);
    }
    
    public void sendKeysToPhone(String phone){
    	logger.info("Entering sendKeysToOppName", phone);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getPhysLocPhone()).sendKeys(phone);
    }
    
    public void sendKeysToStreet(String street){
    	logger.info("Entering sendKeysToOppName", street);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getPhysLocStreet1()).sendKeys(street);
    }
    
    public void sendKeysToCity(String city){
    	logger.info("Entering sendKeysToOppName", city);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getPhysLocCity()).sendKeys(city);
    }
    
    public void sendKeysToSelState(String state){
    	logger.info("Entering sendKeysToOppName", state);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getSelectphysLocState()).sendKeys(state);
    }
    
    public void sendKeysToZip(String zip){
    	logger.info("Entering sendKeysToOppName", zip);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getPhysLocZip()).sendKeys(zip);
    }
    
    public void sendKeysToSelBillingAdd(String addressFlag){
    	logger.info("Entering sendKeysToOppName", addressFlag);
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeVisible(newDealerRequestSelector.getSelectPhysAddSameAsBilling()).sendKeys(addressFlag);
    }
    
    public void createNewDealerReq(){
    	logger.info("Entering sendKeysToOppName");
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeClickable(newDealerRequestSelector.getNewDlrReqLink()).click();
    }
    
    public void addNamePlate(){
    	logger.info("Entering addNamePlate");
        //commonUtil.waitForElementToBeVisible(homeSelector.getSearchInput()).clear();
        commonUtil.waitForElementToBeClickable(newDealerRequestSelector.getAddNamePlateBtn()).click();
    }
    
    
}
