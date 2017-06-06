package com.coxautoinc.sfdc.opportunities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

/**
 * Selector class for the Opportunity page.
 */
class OpportunitySelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By addProductBtn;
    private By newQuoteBtn;
    private By oppTabNav;
    private By newbtn;
    private By selectRcdTyp;
    private By continueBtn;
    private By opportunityNameTxt;
    private By accountNameTxt;
    private By closeDate;
    private By selectType;
    private By selectStage;
    private By saveBtn;
    private By addPartner;
    private By addCompetitor;
    private By newNoteBtn;
    private By addAccntPopup;
    private By globalSearchTextBox;
    private By globalSearchButton;
    private By newOpptyBtn;
    private By amountTxt;
    private By descTxt;
    private By navigateToOppty;
    private By deleteOpptyLink;
    

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new OpportunitySelector object.
     */
    OpportunitySelector() {
        init();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    By getAddProductBtn() {
        return addProductBtn;
    }

    By getNewQuoteBtn() {
        return newQuoteBtn;
    }

    public By getNewbtn() {
		return newbtn;
	}

	public By getSelectRcdTyp() {
		return selectRcdTyp;
	}

	public By getOpportunityNameTxt() {
		return opportunityNameTxt;
	}

	public By getAccountNameTxt() {
		return accountNameTxt;
	}

	public By getCloseDate() {
		return closeDate;
	}

	public By getSelectType() {
		return selectType;
	}

	public By getSelectStage() {
		return selectStage;
	}

	public By getContinueBtn() {
		return continueBtn;
	}

	public By getSaveBtn() {
		return saveBtn;
	}

	public By getOppTabNav() {
		return oppTabNav;
	}

	public By getAddPartner() {
		return addPartner;
	}

	public By getAddCompetitor() {
		return addCompetitor;
	}

	public By getNewNoteBtn() {
		return newNoteBtn;
	}

	public By getAddAccntPopup() {
		return addAccntPopup;
	}

	public By getGlobalSearchTextBox() {
		return globalSearchTextBox;
	}

	public By getGlobalSearchButton() {
		return globalSearchButton;
	}

	public By getNewOpptyBtn() {
		return newOpptyBtn;
	}

	public By getAmountTxt() {
		return amountTxt;
	}

	public By getDescTxt() {
		return descTxt;
	}

	public By getNavigateToOppty() {
		return navigateToOppty;
	}

	public By getDeleteOpptyLink(String opportunityName) {
		return By.xpath("//a[contains(text(),'" + opportunityName + "')]/ancestor::tr/td/a[text()='Del']");
	}

	/**
     * Method to initialize all selector variables.
     */
    private void init() {
        addProductBtn = By.xpath("//input[@name='addProd']");
        newQuoteBtn = By.xpath("//input[@name='newQuote']");
        oppTabNav = By.xpath("//a[@title = 'Opportunities Tab']");
        newbtn = By.name("new");
        //selectRcdTyp = By.id("p3");
        //selectRcdTyp = By.xpath("//input[@value='At_Risk']");
        selectRcdTyp = By.xpath("//*[@id='p:i:i:f:pb:d:Select_Opportunity_Record_Type.At_Risk.radio']");
        //selectRcdTyp = By.id("p:i:i:f:pb:d:Select_Opportunity_Record_Type.At_Risk.radio");
        //continueBtn = By.xpath("//input[@value = 'Continue']");
        continueBtn = By.xpath("//input[@value = 'Next']");
        opportunityNameTxt = By.id("p:i:i:f:pb:d:Opportunity_Name_At_Risk.input");
        accountNameTxt = By.id("opp4");
        closeDate = By.id("p:i:i:f:pb:d:AtRiskClose_Date.input");
        selectType = By.id("p:i:i:f:pb:d:Type.input");
        selectStage = By.id("opp11");
        saveBtn = By.name("save");
        addPartner = By.name("newPartner");
        addCompetitor = By.name("newComp");
        newNoteBtn = By.name("newNote");
        addAccntPopup = By.id("opp4_lkwgt");
        globalSearchTextBox= By.id("phSearchInput");
        globalSearchButton = By.id("phSearchButton");
        newOpptyBtn = By.name("new_flow_opportunity2");
        amountTxt = By.id("p:i:i:f:pb:d:AtRiskAmount.input");
        descTxt = By.id("p:i:i:f:pb:d:AtRiskDescription.input");
        navigateToOppty = By.linkText("here.");
        
    }
    

}
