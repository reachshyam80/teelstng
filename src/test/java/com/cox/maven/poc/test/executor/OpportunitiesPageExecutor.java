package com.cox.maven.poc.test.executor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.coxautoinc.sfdc.common.CommonPage;
import com.coxautoinc.sfdc.opportunities.AddCompetitorPage;
import com.coxautoinc.sfdc.opportunities.AddNotesPage;
import com.coxautoinc.sfdc.opportunities.AddPartnerPage;
import com.coxautoinc.sfdc.opportunities.AddProductsPage;
import com.coxautoinc.sfdc.opportunities.OpportunityPage;
import com.coxautoinc.sfdc.opportunities.ProductSelectionPage;
import com.coxautoinc.sfdc.utilities.CommonUtil;

public class OpportunitiesPageExecutor extends TestNgBaseClass {
	private String excelFilePath;
	private String excelSheetName;
	private OpportunityPage opportunityPage;
	private AddProductsPage addProductsPage;
	private static final Logger logger = LoggerFactory.getLogger(OpportunitiesPageExecutor.class);
	private String productOneName;
	private String productTwoName;
	private String productThreeName;
	private CommonPage commonPage;
	private AddCompetitorPage addCompetitor;
	private AddPartnerPage addPartnerPage;
	private AddNotesPage addNotesPage;
	private CommonUtil commonUtil;
	private String opportunityName;
	private String accountName;
	private String closeDate;
	private String oppType;
	private String oppStage;
	private String userName;
	private String password;

	// private final String path;
	// private static final DesiredCapabilities capability = new
	// DesiredCapabilities();

	public OpportunitiesPageExecutor() {
		// this.path = "src//test//resources//drivers//";
	}

	/**
	 * Method to initialize test variables.
	 */
	@BeforeClass
	@Parameters({ "excelSheetName" })
	public void beforeTest(String sheetName) {
		this.excelSheetName = sheetName;

		this.excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + excelFileName + ".xlsx";
		this.opportunityPage = new OpportunityPage(driver);
		this.addProductsPage = new AddProductsPage(driver);
		this.commonPage = new CommonPage(driver);
		this.addCompetitor = new AddCompetitorPage(driver);
		this.addPartnerPage = new AddPartnerPage(driver);
		this.addNotesPage = new AddNotesPage(driver);
		this.commonUtil = new CommonUtil(driver);
		this.productOneName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product1 Name");
		this.productTwoName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product2 Name");
		this.opportunityName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Opportunity Name");
		this.accountName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Account Name");
		this.closeDate = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Close Date");
		this.oppType = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Opp Type");
		this.oppStage = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Opp Stage");
		this.productThreeName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product3 Name");
		this.userName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Username");
		this.password = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Password");
		productThreeName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product3 Name");
		if (region.equalsIgnoreCase("preprod"))
			throw new SkipException("Test Not Required for Preprod");
		super.login(userName, password);
	}

	/**
	 * Test to verify that a user can successfully log in to SFDC
	 */
	// @Test
	public void login() {
		// logger.info("Entering test method: verifyLoginToSalesForce");
		// LoginPage loginPage = new LoginPage(driver);
		// logger.info("Navigating to url: {}", baseUrl);
		// driver.get(baseUrl);
		// loginPage.loginToSalesForce(userName, password);

		// logger.info("Exiting test method: verifyLoginToSalesForce");

	}

	/**
	 * Test to verify that a user can create an opportunity
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void createOpportunities(){

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(sdf.format(cal.getTime()));
		 //opportunityPage.clickOpportunitiesTab();
		 //opportunityPage.newOppbtn();
		opportunityPage.sendKeysToGlobalSearch("testDealerGrp");
		opportunityPage.clickGlobalSearchBtn();
		commonUtil.waitForElementUsingFluentWait(By.linkText("testDealerGrp")).click();
		opportunityPage.clickNewOpptyBtn();
		//driver.switchTo().frame(commonUtil.waitForElementUsingFluentWait(By.id("p:i:i:f:pb")));
		
		//driver.switchTo().frame(commonUtil.waitForElementUsingFluentWait(By.xpath("//*[@id='Opportunity Creation Guided Flow']")));
		WebElement iFrame= driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iFrame);
		//opportunityPage.selectRcdTyp(
				//commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Record Type of new record"));
		opportunityPage.continueoppcreate();
		 opportunityPage.sendKeysToOppName(opportunityName);
		// opportunityPage.clickAccntNamePopup();
		// opportunityPage.selectAccntName(accountName);
		opportunityPage.sendKeysToEndDate(sdf.format(cal.getTime()));
		opportunityPage.selectType(oppType);
		// opportunityPage.selectStage(oppStage);
		opportunityPage.sendKeysToAmount("10");
		opportunityPage.sendKeysToDesc("Test Desc");
		opportunityPage.continueoppcreate();
		opportunityPage.clickNavigateToOppty();
		//driver.switchTo().defaultContent();
		//opportunityName = driver.findElement(By.xpath(".//*[@id='opp3_ileinner']")).getText();
		// opportunityPage.saveOpportunity();
	}

	/**
	 * Test to verify that a user can select the add product button
	 */
	@Test(dependsOnMethods = "createOpportunities")
	public void selectProducts() {
		logger.info("Entering test method: selectProducts");
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		opportunityPage.clickAddProductBtn();
		ProductSelectionPage productSelectionPage = new ProductSelectionPage(driver);

		// Filter by first letter of product one.
		productSelectionPage.clickFilterByLetter(productOneName.substring(0, 1));

		// Check product one.
		productSelectionPage.clickCheckBoxByProductName(productOneName);

		// Filter by first letter of product two.
		productSelectionPage.clickFilterByLetter(productTwoName.substring(0, 1));

		// Check product two.
		productSelectionPage.clickCheckBoxByProductName(productTwoName);
		// Click the Select button.
		productSelectionPage.clickSelectBtn();

		// Assert that the Quantity input fields are displayed to verify that we
		// are on the Add Products page.
		// Assert.assertTrue(addProductsPage.isQuantityInputFieldDisplayedForProduct(productOneName),
		// "The Quantity input field was not displayed for product: " +
		// productOneName);
		// Assert.assertTrue(addProductsPage.isQuantityInputFieldDisplayedForProduct(productTwoName),
		// "The Quantity input field was not displayed for product: " +
		// productTwoName);

		logger.info("Exiting test method: selectProducts");
	}

	/**
	 * Test to verify that the product is added to the opportunity when creating
	 * it
	 * 
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods = "selectProducts")
	public void addProducts() {
		logger.info("Entering test method: addProducts");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@value='Save'] | //input[@title='Save'])[1]")));
		addProductsPage.sendKeysToQuantityInputByProductName(productOneName,
				(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product1 Quantity")));
		addProductsPage.sendKeysToProductNetBillableAmountInputByProductName(productOneName,
				(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product1 Sales Price")));
		addProductsPage.sendKeysToQuantityInputByProductName(productTwoName,
				(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product2 Quantity")));
		addProductsPage.sendKeysToProductNetBillableAmountInputByProductName(productTwoName,
				(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product2 Sales Price")));
		// Click Save.
		commonPage.clickSaveBtn();

		// Assert that the New Quote button is displayed to show that we are on
		// the Opportunity page after saving.
		// Assert.assertTrue(opportunityPage.isNewQuoteBtnDisplayed(),
		// "New Quote button was not found. Products may not have been saved
		// successfully.");

		logger.info("Exiting test method: addProducts");

	}

	/**
	 * Test to verify that a Product can be added to an existing opportunity
	 */
	@Test(dependsOnMethods = "addProducts")
	public void addProductToOpportunity() {
		logger.info("Entering test method: addProductToOpportunity");
		ProductSelectionPage productSelectionPage = new ProductSelectionPage(driver);

		// Click the Add Products button.
		opportunityPage.clickAddProductBtn();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Select']")));
		// Filter by first letter of product one.
		productSelectionPage.clickFilterByLetter(productThreeName.substring(0, 1));

		// Check product one.
		productSelectionPage.clickCheckBoxByProductName(productThreeName);
		// Click the Select button.
		productSelectionPage.clickSelectBtn();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@value='Save'] | //input[@title='Save'])[1]")));
		addProductsPage.sendKeysToQuantityInputByProductName(productThreeName,
				(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product3 Quantity")));
		addProductsPage.sendKeysToProductNetBillableAmountInputByProductName(productThreeName,
				(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Product3 Sales Price")));
		// Click Save.
		commonPage.clickSaveBtn();
		// Assert that the Quantity input fields are displayed to verify that we
		// are on the Add Products page.
		// Assert.assertTrue(addProductsPage.isQuantityInputFieldDisplayedForProduct(productOneName),
		// "The Quantity input field was not displayed for product: " +
		// productOneName);
		// Assert.assertTrue(addProductsPage.isQuantityInputFieldDisplayedForProduct(productTwoName),
		// "The Quantity input field was not displayed for product: " +
		// productTwoName);

		logger.info("Exiting test method: addProductToOpportunity");
	}

	/**
	 * Test to verify that a competitor can be added to the opportunity
	 */
	@Test(dependsOnMethods = "addProductToOpportunity")
	public void addCompetitor() {
		logger.info("Entering test method: addCompetitor");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("newComp")));
		opportunityPage.addCompetitorToOpp();

		addCompetitor.sendKeysToCompName(
				commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Competitor Name"));
		addCompetitor.sendKeysToCompStrength(
				commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Competitor Strength"));
		addCompetitor.sendKeysToCompWeakness(
				commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Competitor Weakness"));
		commonPage.clickSaveBtn();
		logger.info("Entering test method: addCompetitor");

	}

	/**
	 * Test to verify that a partner can be added to the opportunity
	 */
	@Test(dependsOnMethods = "addCompetitor")
	public void addPartner() {
		logger.info("Entering test method: addPartner");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("newPartner")));
		opportunityPage.addPartnerToOpp();
		addPartnerPage.sendKeysToPartnerName(
				commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Partner Name"));
		addPartnerPage
				.sendKeysToPartRole(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Partner Role"));
		commonPage.clickSaveBtn();

		logger.info("Entering test method: addPartner");
	}

	/**
	 * Test to verify that notes can be added to the opportunity
	 */
	@Test(dependsOnMethods = "addPartner")
	public void addNotes() {
		logger.info("Entering test method: addNotes");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("newNote")));
		opportunityPage.addNotesToOpp();
		addNotesPage
				.sendKeysToNoteTitle(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Notes Title"));
		addNotesPage.sendKeysToNoteBody(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Notes body"));
		commonPage.clickSaveBtn();
		logger.info("Entering test method: addNotes");

	}

	/**
	 * Test to verify that an existing Product can be modified
	 */
	@Test(dependsOnMethods = "addNotes")
	public void editProduct() {
		logger.info("Entering test method: editProduct");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("newNote")));
		driver.findElement(By.xpath("//a[contains(@title,'" + productThreeName + "')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("UnitPrice")));
		driver.findElement(By.id("UnitPrice")).clear();
		driver.findElement(By.id("UnitPrice")).sendKeys("20");
		commonPage.clickSaveBtn();
		logger.info("Entering test method: editProduct");
	}

	/**
	 * Method executes after all the tests are complete.
	 */
	@AfterClass(alwaysRun = false)
	public void cleanUp() {
		if((!region.equalsIgnoreCase("preprod")) && (null!= opportunityName)){
		 logger.info("Entering test method: cleanUp");

	        // Search for the dealer.
		 	opportunityPage.sendKeysToGlobalSearch("testDealerGrp");
			opportunityPage.clickGlobalSearchBtn();

	        // Click on the dealer from the results page.
			commonUtil.waitForElementUsingFluentWait(By.linkText("testDealerGrp")).click();

	        // Find the recent opportunities with the entered test name "Java Test Products".
	        //accountPage.clickDeleteLinkForOpportunitiesByName(commonUtil.getColumnDataFromExcel(excelFilePath,
	                //excelSheetName, "Opportunity Dealer Interested Product"));
			System.out.println("aaOpptyName"+opportunityName);
	        opportunityPage.clickDeleteLinkForOpportunitiesByName(opportunityName);
		}
	        logger.info("Exiting test method: cleanUp");
	}

}
