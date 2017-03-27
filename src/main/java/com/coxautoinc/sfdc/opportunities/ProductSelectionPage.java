package com.coxautoinc.sfdc.opportunities;

import com.coxautoinc.sfdc.utilities.CommonUtil;

import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page Object for the Product Selection page.
 */
public class ProductSelectionPage {

    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(ProductSelectionPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final CommonUtil commonUtil;
    private final ProductSelectionSelector productSelectionSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new ProductSelectionPage object.
     *
     * @param driver in value
     */
    public ProductSelectionPage(WebDriver driver) {
        this.commonUtil = new CommonUtil(driver);
        this.productSelectionSelector = new ProductSelectionSelector();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to click the checkbox for the specified product.
     *
     * @param productName in value.
     */
    public void clickCheckBoxByProductName(String productName) {
        logger.info("Clicking checkbox for product: '{}'", productName);
        commonUtil.waitForInvisibilityOfElement(productSelectionSelector.getWaitingSearchDiv());
        commonUtil.waitForElementToBeClickable(productSelectionSelector.getCheckBoxByProductName(productName)).click();
    }

    /**
     * Method to click the alphabetical filter with the specified letter.
     *
     * @param letter in value.
     */
    public void clickFilterByLetter(String letter) {
        logger.info("Clicking alphabetic filter for letter: '{}'", letter);
        commonUtil.waitForElementToBeClickable(productSelectionSelector.getFilterByLetter(letter)).click();
    }

    /**
     * Method to click the Select button.
     */
    public void clickSelectBtn() {
        logger.info("Clicking Select button.");
        commonUtil.waitForElementToBeClickable(productSelectionSelector.getSelectBtn()).click();
    }
}
