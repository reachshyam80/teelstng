package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.By;

/**
 * Selector class for the Product Selection page.
 */
class ProductSelectionSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By selectBtn;
    private By waitingSearchDiv;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new ProductSelectionSelector object.
     */
    ProductSelectionSelector() {
        init();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to get the xpath for the checkbox of the specified product.
     *
     * @param productName in value.
     *
     * @return By object with the xpath for the checkbox of the specified product.
     */
    By getCheckBoxByProductName(String productName) {
        return By.xpath("//span[text()='" + productName
                    + "']/parent::a/parent::div/parent::td/parent::tr/td/div/input");
    }

    /**
     * Method to get the xpath for the alphabetical filter link for the specified letter.
     *
     * @param letter in value.
     *
     * @return By object with the xpath for the alphabetical filter link for the specified letter.
     */
    By getFilterByLetter(String letter) {
        return By.xpath("//span[text()='" + letter + "']");
    }

    By getSelectBtn() {
        return selectBtn;
    }

    By getWaitingSearchDiv() {
        return waitingSearchDiv;
    }

    /**
     * Method to initialize all selector variables.
     */
    private void init() {
        selectBtn = By.xpath("//input[@title='Select']");
        waitingSearchDiv = By.xpath("//*[@class='waitingSearchDiv']");
    }
}
