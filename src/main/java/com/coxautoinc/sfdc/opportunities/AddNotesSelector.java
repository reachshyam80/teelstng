package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.By;

public class AddNotesSelector {
	//~ Instance fields ------------------------------------------------------------------------------------------------

    private By titleTxt;
    private By bodyTxt;
    
    public AddNotesSelector() {
		init();
	}
    
    public By getTitleTxt() {
		return titleTxt;
	}

	public By getBodyTxt() {
		return bodyTxt;
	}

	private void init(){
    	titleTxt = By.id("Title");
    	bodyTxt = By.name("Body");
    }
}
