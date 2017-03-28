package com.cox.maven.poc.test.executor;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.coxautoinc.sfdc.common.CommonPage;
import com.coxautoinc.sfdc.login.LoginPage;
import com.coxautoinc.sfdc.newdealerrequest.NewDealerRequestPage;
import com.coxautoinc.sfdc.utilities.CommonUtil;

public class CreateNewDealer extends TestNgBaseClass {

	private static final Logger logger = LoggerFactory.getLogger(OpportunitiesPageExecutor.class);
	private String excelFilePath;
	private String excelSheetName;
	private String userName;
	private String password;
	private CommonUtil commonUtil;
	private NewDealerRequestPage newDealerRequestPage;
	private CommonPage commonPage;
	
    /**
     * Method to initialize test variables.
     */
	@BeforeClass
	@Parameters({ "excelSheetName", "excelFileName" })
	public void beforeTest(String sheetName, String excelFileName) {
		this.commonUtil = new CommonUtil(driver);
		this.newDealerRequestPage = new NewDealerRequestPage(driver);
		this.excelSheetName = sheetName;
		this.excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + excelFileName + ".xlsx";
		userName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Username");
		password = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Password");
		this.commonPage = new CommonPage(driver);
		try {
			FileUtils.cleanDirectory(new File("tmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Test to verify that a user can successfully log in to SFDC
	 */
	@Test
	public void login() {
		logger.info("Entering test method: verifyLoginToSalesForce");

		LoginPage loginPage = new LoginPage(driver);

		// Navigate to SFDC.
		logger.info("Navigating to url: {}", baseUrl);
		driver.get(baseUrl);
		loginPage.loginToSalesForce(userName, password);
		screenshot("Login Page onload");
		// Assert that the search button is displayed to show that we are logged
		// in,
		// return a custom error message if it is not found.
		// Assert.assertTrue(homePage.isSearchBtnDisplayed(), "The Search button
		// for SFDC was not found.");

		logger.info("Exiting test method: verifyLoginToSalesForce");

	}
	/**
	 * Test to verify that a user can create a new dealer
	 */
	@Test(dependsOnMethods = "login")
	public void loadNewDealerRequest() {
		try {
			newDealerRequestPage.createNewDealerReq();
			screenshot("Dealer Page onload");
			newDealerRequestPage.sendKeysToUrgentReq(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Urgent Request"));
			newDealerRequestPage.sendKeysToSubmit(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Submit"));
			newDealerRequestPage.sendKeysToOwnershipChng(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Ownership Change"));
			newDealerRequestPage.sendKeysToAccntName(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Account Name"));
			newDealerRequestPage.sendKeysToDealerGrp(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Existing Dealer Group"));
			newDealerRequestPage.sendKeysToDealerGrpAccnt(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Dealer Group Account"));
			newDealerRequestPage.sendKeysToDealerType(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Dealer Type"));
			newDealerRequestPage.selectNamePlate("");
			newDealerRequestPage.addNamePlate();
			newDealerRequestPage.sendKeysToURL(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Customer's Website URL"));
			newDealerRequestPage.sendKeysToSelCustTyp(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Customer Type"));
			newDealerRequestPage.sendKeysToSelLotSizeUsed(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Lot Size - New"));
			newDealerRequestPage.sendKeysToSelNewLotSize(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Lot Size - Used"));
			newDealerRequestPage.sendKeysToPhone(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Physical Location Phone"));
			newDealerRequestPage.sendKeysToStreet(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Physical Location Street 1"));
			newDealerRequestPage.sendKeysToCity(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Physical Location City"));
			newDealerRequestPage.sendKeysToSelState(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Physical Location State"));
			newDealerRequestPage.sendKeysToZip(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Physical Location Postal Code"));
			newDealerRequestPage.sendKeysToSelBillingAdd(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Billing Address same as Physical?"));
			commonPage.clickSaveBtn();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("second class for suite");
	}
	/**
	 * After Test Method to perform actions after the Test is complete
	 */
	@AfterTest
	public void afterTest() {
		screenshot("Save New Dealer Request");
		// driver.close();
		driver.quit();

	}
	/**
	 * Method to get the required screenshots
	 */
	public void screenshot(String page) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd hh mm a");
			Date date = new Date();

			FileUtils.copyFile(screenshot,
					new File("tmp" + File.separator + "ID-" + page + "-DATE-" + dateFormat.format(date) + ".png"));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

}
