package com.cox.maven.poc.test.executor;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.coxautoinc.sfdc.login.LoginPage;
import com.coxautoinc.sfdc.utilities.CommonUtil;

public class CreateNewDealer extends TestNgBaseClass {

	private static final Logger logger = LoggerFactory.getLogger(OpportunitiesPageExecutor.class);
	private String excelFilePath;
	private String excelSheetName;
	private String userName;
	private String password;
	private CommonUtil commonUtil;
	
	@BeforeClass
	@Parameters({"excelSheetName","excelFileName"})
	public void beforeTest(String sheetName,String excelFileName) {
		this.commonUtil = new CommonUtil(driver);
		this.excelSheetName = sheetName;
		this.excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/"
				+ excelFileName+ ".xlsx";
		userName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Username");
		password = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Password");
		try {
			FileUtils.cleanDirectory(new File("tmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// login();
	}
	@Test
	public void login() {
		logger.info("Entering test method: verifyLoginToSalesForce");

		LoginPage loginPage = new LoginPage(driver);

		// Navigate to SFDC.
		logger.info("Navigating to url: {}", baseUrl);
		driver.get(baseUrl);
		loginPage.loginToSalesForce(userName,password);
		screenshot("Login Page onload");
		// Assert that the search button is displayed to show that we are logged
		// in,
		// return a custom error message if it is not found.
		// Assert.assertTrue(homePage.isSearchBtnDisplayed(), "The Search button
		// for SFDC was not found.");

		logger.info("Exiting test method: verifyLoginToSalesForce");

	}

	@Test(dependsOnMethods = "login")
	public void loadNewDealerRequest() {
		System.out.println("second class for suite");
		try {

			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New Dealer Request")));

			// driver.findElement(By.xpath("//a[contains(text(), 'New Dealer
			// Request']")).click();
			driver.findElement(By.linkText("New Dealer Request")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("00Nj000000C1bRV")));
			screenshot("Dealer Page onload");
			Select dropdown = new Select(driver.findElement(By.id("00Nj000000C1bRV")));
			dropdown.selectByIndex(1);
			if (driver.findElement(By.id("00Nj000000C14Ox")).isSelected()) {
				driver.findElement(By.id("00Nj000000C14Ox")).click();
			}
			Select ownershipChange = new Select(driver.findElement(By.id("00Nj000000C1bRK")));
			ownershipChange.selectByIndex(1);
			driver.findElement(By.id("00Nj000000C14OY")).sendKeys("TestAutomationDemoNew1");
			new Select(driver.findElement(By.id("00Nj000000C1bRJ"))).selectByIndex(1);
			driver.findElement(By.id("CF00Nj000000C14Ty")).sendKeys("Test Customer 1");

			new Select(driver.findElement(By.id("00Nj000000C1bRI"))).selectByIndex(1);
			for (int i = 1; i <= 4; i++)
				new Select(driver.findElement(By.id("00Nj000000C1bRN_unselected"))).selectByIndex(i);
			driver.findElement(By.xpath("//a[@title = 'Add']")).click();
			driver.findElement(By.id("00Nj000000C1bRH")).sendKeys("www.testAutomation.com");
			new Select(driver.findElement(By.id("00Nj000000C1bRG"))).selectByIndex(2);
			new Select(driver.findElement(By.id("00Nj000000C1bRL"))).selectByIndex(2);
			new Select(driver.findElement(By.id("00Nj000000C1bRM"))).selectByIndex(2);
			driver.findElement(By.id("00Nj000000C1bRP")).sendKeys("111-222-3333");
			driver.findElement(By.id("00Nj000000C1bRS")).sendKeys("111 Summit Trl");
			driver.findElement(By.id("00Nj000000C1bRO")).sendKeys("Dunwoody");
			new Select(driver.findElement(By.id("00Nj000000C1bRR"))).selectByIndex(1);
			driver.findElement(By.id("00Nj000000C1bRQ")).sendKeys("30090");
			new Select(driver.findElement(By.id("00Nj000000C1bR8"))).selectByIndex(2);
			driver.findElement(By.name("save")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("second class for suite");
	}



	@AfterTest
	public void afterTest() {
		screenshot("Save New Dealer Request");
		// driver.close();
		driver.quit();

	}

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
