package com.coxautoinc.sfdc.common;

import org.openqa.selenium.By;

/**
 * Selector class for common page elements.
 */
class CommonSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By saveBtn;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new CommonSelector object.
     */
    CommonSelector() {
        init();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    By getSaveBtn() {
        return saveBtn;
    }

    /**
     * Method to initialize all selector variables.
     */
    private void init() {
        saveBtn = By.xpath("(//input[@value='Save'] | //input[@title='Save'])[1]");
    }
}
