package com.cox.maven.poc.test.executor;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.coxautoinc.sfdc.common.CommonPage;
import com.coxautoinc.sfdc.login.LoginPage;
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

	@BeforeClass
	@Parameters({"excelSheetName","excelFileName"})
	public void beforeTest(String sheetName,String excelFileName) {
		System.out.println("Before Test");
		System.out.println("excelSheetName1"+excelSheetName);
		this.excelSheetName = sheetName;
		this.excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/"
				+ excelFileName + ".xlsx";
		System.out.println(excelFilePath);
		System.out.println(excelSheetName);
		this.opportunityPage = new OpportunityPage(driver);
		this.addProductsPage = new AddProductsPage(driver);
		this.commonPage = new CommonPage(driver);
		this.addCompetitor = new AddCompetitorPage(driver);
		this.addPartnerPage = new AddPartnerPage(driver);
		this.addNotesPage = new AddNotesPage(driver);
		this.commonUtil = new CommonUtil(driver);
		// productOneName = "ADP Write Back";
		// productTwoName = "Labor Time Guides- Honda";
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
		System.out.println(productOneName);
		productThreeName = "BHPH Monthly";
	}

	@Test
	public void login() {
		logger.info("Entering test method: verifyLoginToSalesForce");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Navigating to url: {}", baseUrl);
		driver.get(baseUrl);
		loginPage.loginToSalesForce(userName,password);

		logger.info("Exiting test method: verifyLoginToSalesForce");

	}

	@Test(dependsOnMethods = "login")
	public void createOpportunities() {
		opportunityPage.clickOpportunitiesTab();
		System.out.println("After Test");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new")));
		driver.findElement(By.name("new")).click();
		// opportunityPage.newOppbtn();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("p3")));
		Select dropdown = new Select(driver.findElement(By.id("p3")));
		dropdown.selectByIndex(0);
		// opportunityPage.selectRcdTyp("At Risk");
		// driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("opp3"))).click();
		opportunityPage.continueoppcreate();
		opportunityPage.sendKeysToOppName(opportunityName);
		opportunityPage.sendKeysToAccntName(accountName);
		opportunityPage.sendKeysToEndDate(closeDate);
		opportunityPage.selectType(oppType);
		opportunityPage.selectStage(oppStage);
		opportunityPage.saveOpportunity();
	}

	@Test(dependsOnMethods = "createOpportunities")
	public void selectProducts() {
		logger.info("Entering test method: selectProducts");
		ProductSelectionPage productSelectionPage = new ProductSelectionPage(driver);

		// Click the Add Products button.
		// opportunityPage.clickAddProductBtn();

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
	 * Test to verify that the price book for each product can be completed.
	 * 
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods = "selectProducts")
	public void addProducts() {
		logger.info("Entering test method: addProducts");

		// Enter Quantity and Net Billable Amount for product one.
		System.out.println(productOneName);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@value='Save'] | //input[@title='Save'])[1]")));
		addProductsPage.sendKeysToQuantityInputByProductName(productOneName, "1");
		addProductsPage.sendKeysToProductNetBillableAmountInputByProductName(productOneName, "10");
		addProductsPage.sendKeysToQuantityInputByProductName(productTwoName, "1");
		addProductsPage.sendKeysToProductNetBillableAmountInputByProductName(productTwoName, "10");
		// Click Save.
		commonPage.clickSaveBtn();

		// Assert that the New Quote button is displayed to show that we are on
		// the Opportunity page after saving.
		// Assert.assertTrue(opportunityPage.isNewQuoteBtnDisplayed(),
		// "New Quote button was not found. Products may not have been saved
		// successfully.");

		logger.info("Exiting test method: addProducts");

	}

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
		addProductsPage.sendKeysToQuantityInputByProductName(productThreeName, "1");
		addProductsPage.sendKeysToProductNetBillableAmountInputByProductName(productThreeName, "10");
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

	@Test(dependsOnMethods = "addProductToOpportunity")
	public void addCompetitor() {
		logger.info("Entering test method: addCompetitor");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("newComp")));
		opportunityPage.addCompetitorToOpp();

		addCompetitor.sendKeysToCompName("Test Competitor");
		addCompetitor.sendKeysToCompStrength("Test Strength");
		addCompetitor.sendKeysToCompWeakness("Test Weakness");
		commonPage.clickSaveBtn();
		logger.info("Entering test method: addCompetitor");

	}

	@Test(dependsOnMethods = "addCompetitor")
	public void addPartner() {
		logger.info("Entering test method: addPartner");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("newPartner")));
		opportunityPage.addPartnerToOpp();
		addPartnerPage.sendKeysToPartnerName("Test Customer 1");
		addPartnerPage.sendKeysToPartRole("Advertiser");
		commonPage.clickSaveBtn();

		logger.info("Entering test method: addPartner");
	}

	@Test(dependsOnMethods = "addPartner")
	public void addNotes() {
		logger.info("Entering test method: addNotes");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("newNote")));
		opportunityPage.addNotesToOpp();
		addNotesPage.sendKeysToNoteTitle("Test Automation Notes");
		addNotesPage.sendKeysToNoteBody("Test Notes Body");
		commonPage.clickSaveBtn();
		logger.info("Entering test method: addNotes");

	}

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

	@AfterTest
	public void afterTest() throws IOException {
		System.out.println("After Test");
		// System.out.print("\nBrowser close");
		driver.quit();
	}

}
