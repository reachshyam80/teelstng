package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.By;

public class AddCompetitorSelector {

	private By competitorName;
	private By strengths;
	private By weaknesses;
	AddCompetitorSelector(){
		init();
	}
	
	public By getCompetitorName() {
		return competitorName;
	}

	public By getStrengths() {
		return strengths;
	}

	public By getWeaknesses() {
		return weaknesses;
	}

	/**
     * Method to initialize all selector variables.
     */
    private void init() {
    	competitorName = By.id("CompetitorName");
    	strengths = By.id("Strengths");
    	weaknesses = By.id("Weaknesses");
    }
}
