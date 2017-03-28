package com.coxautoinc.sfdc.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains utility methods used throughout the project.
 */
public class CommonUtil {

    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private final Wait<WebDriver> fluentWait;
    private final WebDriverWait wait;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new CommonUtil object.
     *
     * @param driver in value
     */
    public CommonUtil(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.fluentWait =
            new FluentWait<>(driver).withTimeout(2, TimeUnit.MINUTES).pollingEvery(1, TimeUnit.SECONDS).ignoring(
                org.openqa.selenium.NoSuchElementException.class).ignoring(
                org.openqa.selenium.ElementNotVisibleException.class).ignoring(
                org.openqa.selenium.StaleElementReferenceException.class).ignoring(
                org.openqa.selenium.TimeoutException.class).ignoring(org.openqa.selenium.WebDriverException.class);
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method will read particular column data(ex : If we pass ColumnName as Dealer ID it will read the Dealer ID column
     * data) depends on ColumnName and filepath and returns the list
     *
     * @param filePath in value
     * @param sheetName in value
     * @param columnName - column name for data which is to be read
     *
     * @return ColumnData as a String
     */
    public String getColumnDataFromExcel(String filePath, String sheetName, String columnName) {
        ExcelReader excl = new ExcelReader();
        String columnValue = null;
        try {
            HashMap<String, List<String>> exclData = excl.getExcel(filePath, sheetName);
            List<String> columnData = exclData.get(columnName);
            for (int i = 0; i < columnData.size(); i++) {
                columnValue = columnData.get(0);
            }
        } catch (Exception e) {
        	
            logger.error("Failed to read data from excel file path: " + filePath + ", sheet name: " + sheetName
                    + ", column name: " + columnName);
            e.printStackTrace();
        }
        return columnValue;
    }

    /**
     * Method to wait for the specified element to be clickable
     *
     * @param elementBy in value.
     *
     * @return WebElement once found.
     */
    public WebElement waitForElementToBeClickable(By elementBy) {
        return wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    /**
     * Method to wait for the specified element to be clickable
     *
     * @param element in value.
     *
     * @return WebElement once found.
     */
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method to wait for the specified element to be visible in the DOM
     *
     * @param elementBy in value.
     *
     * @return WebElement once found.
     */
    public WebElement waitForElementToBeVisible(By elementBy) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    /**
     * Will wait for the presence of an object.
     *
     * @param elementBy in value
     *
     * @return out value
     */
    public WebElement waitForElementUsingFluentWait(By elementBy) {
        return fluentWait.until(driver -> {
                assert driver != null;
                return driver.findElement(elementBy);
            });
    }

    /**
     * Method to wait for a specified element to no longer be displayed.
     *
     * @param elementBy in value
     */
    public void waitForInvisibilityOfElement(By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }
    
    
    
}
