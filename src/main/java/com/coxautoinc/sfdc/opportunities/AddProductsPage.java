package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page Object for the Add Products page.
 */
public class AddProductsPage {

    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(AddProductsPage.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final AddProductsSelector addProductsSelector;
    private final WebDriver driver;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new AddProductsPage object.
     *
     * @param driver in value.
     */
    public AddProductsPage(WebDriver driver) {
        this.driver = driver;
        this.addProductsSelector = new AddProductsSelector();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to determine if the Quantity input field is displayed for the specified product.
     *
     * @param productName in value.
     *
     * @return true if the Quantity input field is displayed for the specified product.
     */
    public boolean isQuantityInputFieldDisplayedForProduct(String productName) {
        return driver.findElement(addProductsSelector.getQuantityInputByProductName(productName)).isDisplayed();
    }

    /**
     * Method to clear and send keys to the Product Net Billable Amount input field for the specified product.
     *
     * @param productName in value.
     * @param input in value.
     */
    public void sendKeysToProductNetBillableAmountInputByProductName(String productName, String input) {
        logger.info("Entering Product Net Billable Amount value: '{}' for Product: '{}'", input, productName);
        driver.findElement(addProductsSelector.getProductNetBillableAmountInputByProductName(productName)).clear();
        driver.findElement(addProductsSelector.getProductNetBillableAmountInputByProductName(productName)).sendKeys(
            input);
    }

    /**
     * Method to clear and send keys to the Quantity input field for the specified product.
     *
     * @param productName in value
     * @param input in value
     */
    public void sendKeysToQuantityInputByProductName(String productName, String input) {
        logger.info("Entering Quantity value: '{}' for Product: '{}'", input, productName);
        driver.findElement(addProductsSelector.getQuantityInputByProductName(productName)).clear();
        driver.findElement(addProductsSelector.getQuantityInputByProductName(productName)).sendKeys(input);
    }
}
