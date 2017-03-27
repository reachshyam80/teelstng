package com.coxautoinc.sfdc.common;

import com.coxautoinc.sfdc.utilities.CommonUtil;

import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page object for common page elements
 */
public class CommonPage {

    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(CommonPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonSelector commonSelector;
    private final CommonUtil commonUtil;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new CommonPage object.
     *
     * @param driver in value
     */
    public CommonPage(WebDriver driver) {
        this.commonSelector = new CommonSelector();
        this.commonUtil = new CommonUtil(driver);
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to click the Save button.
     */
    public void clickSaveBtn() {
        logger.info("Clicking the Save button.");
        commonUtil.waitForElementToBeClickable(commonSelector.getSaveBtn()).click();
    }
}
