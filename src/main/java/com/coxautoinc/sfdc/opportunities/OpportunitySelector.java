package com.coxautoinc.sfdc.opportunities;

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

	/**
     * Method to initialize all selector variables.
     */
    private void init() {
        addProductBtn = By.xpath("//input[@name='addProd']");
        newQuoteBtn = By.xpath("//input[@name='newQuote']");
        oppTabNav = By.xpath("//a[@title = 'Opportunities Tab']");
        newbtn = By.name("new");
        selectRcdTyp = By.id("p3");
        continueBtn = By.xpath("//input[@value = 'Continue']");
        opportunityNameTxt = By.id("opp3");
        accountNameTxt = By.id("opp4");
        closeDate = By.id("opp9");
        selectType = By.id("opp5");
        selectStage = By.id("opp11");
        saveBtn = By.name("save_new");
        addPartner = By.name("newPartner");
        addCompetitor = By.name("newComp");
        newNoteBtn = By.name("newNote");
        addAccntPopup = By.id("opp4_lkwgt");
    }
}
