package com.coxautoinc.sfdc.opportunities;

import org.openqa.selenium.By;

/**
 * Selector class for the Add Products page.
 */
class AddProductsSelector {

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to get the xpath for the Product Net Billable Amount input field for the specified product.
     *
     * @param productName in value.
     *
     * @return By object with the xpath for the Product Net Billable Amount input field for the specified product.
     */
    By getProductNetBillableAmountInputByProductName(String productName) {
        return By.xpath("//*[contains(text(),'" + productName + "')]/following-sibling::td[3]/input");
    }

    /**
     * Method to get the xpath for the Quantity input field for the specified product.
     *
     * @param productName in value.
     *
     * @return By object with the xpath for the Quantity input field for the specified product.
     */
    By getQuantityInputByProductName(String productName) {
        return By.xpath("//*[contains(text(),'" + productName + "')]/following-sibling::td[1]/input");
    }
}
