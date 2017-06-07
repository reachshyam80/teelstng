package com.cox.maven.poc.test.executor;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.coxautoinc.sfdc.login.LoginPage;
import com.coxautoinc.sfdc.role.based.login.RoleBasedLoginPage;
import com.coxautoinc.sfdc.role.based.login.RoleBasedLoginSelector;
import com.coxautoinc.sfdc.utilities.CommonUtil;
import com.coxautoinc.sfdc.utilities.ExcelReader;

public class LoginRolesTestExecutor extends TestNgBaseClass{
	private static final Logger logger = LoggerFactory.getLogger(OpportunitiesPageExecutor.class);
	private String userName;
	private String password;
	private CommonUtil commonUtil;
	private String excelFilePath;
	private String excelSheetName;
	private String loginExcelSheetName;
	private RoleBasedLoginPage roleBasedLoginPage;
	private RoleBasedLoginSelector roleBasedLoginSelector;
	List<String> user;
	List<String> role;
	/**
	 * Method to initialize test variables.
	 * @throws Exception 
	 */
	@BeforeClass
	@Parameters({ "excelSheetName","loginExcelSheetName" })
	public void beforeTest(String sheetName, String loginSheetName) throws Exception {
		this.commonUtil = new CommonUtil(driver);
		this.roleBasedLoginPage = new RoleBasedLoginPage(driver);
		this.roleBasedLoginSelector = new RoleBasedLoginSelector();
		ExcelReader excl = new ExcelReader();
		this.excelSheetName = sheetName;
		this.excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + excelFileName + ".xlsx";
		this.loginExcelSheetName = loginSheetName;
		this.userName = commonUtil.getColumnDataFromExcel(excelFilePath, loginExcelSheetName, "Username");
		this.password = commonUtil.getColumnDataFromExcel(excelFilePath, loginExcelSheetName, "Password");
		HashMap<String, List<String>> exclData = excl.getExcel(excelFilePath, sheetName);
		user = exclData.get("User");
		role = exclData.get("Role");
		File directory = new File("Screenshots");
		File tmpFolder = new File("tmp");
		try {
			if(directory.exists()){
				FileUtils.cleanDirectory(directory);
			}
			if(tmpFolder.exists()){
				FileUtils.cleanDirectory(tmpFolder);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.login(userName, password);
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin://qadbmdm1:1521/QAMDM1","api","soupqa");
		//Class.forName("oracle.jdbc.driver.­OracleDriver");
		//Statement stmt = con.createStatement();	
		//ResultSet rs = stmt.executeQuery("select *  from employee");
	}
	/**
	 * Test to verify that a user can successfully log in to SFDC
	 */
	//@Test
	public void login() {
		logger.info("Entering test method: verifyLoginToSalesForce");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Navigating to url: {}", baseUrl);
		driver.get(baseUrl);
		loginPage.loginToSalesForce(userName, password);

		logger.info("Exiting test method: verifyLoginToSalesForce");

	}
	/**
	 * Test to verify if the BU search button/link is present for different user roles
	 */
	@Test(retryAnalyzer = com.coxautoinc.sfdc.utilities.TestNGRetry.class)
	public void roleBasedLogin(){
		String userRole = "";
		String userProfile = "";
		//Navigate to people tab
		for(String users: user){
			//driver.navigate().refresh();
			roleBasedLoginPage.clickPeopleTab();
			roleBasedLoginPage.sendKeysToName(users);
			 commonUtil.waitForElementUsingFluentWait(By.linkText(users)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText(users))).click();;
		roleBasedLoginPage.clickUserActionMenu();
		roleBasedLoginPage.clickUserDetailLink();
		commonUtil.waitForElementToBeVisible(By.xpath(".//table[@class='detailList']/tbody/tr[1]/td[4]/a"));
		userRole = driver.findElement(By.xpath(".//table[@class='detailList']/tbody/tr[1]/td[4]/a")).getText();
		userProfile = driver.findElement(By.xpath(".//table[@class='detailList']/tbody/tr[3]/td[4]/a")).getText();
		System.out.println("userRole"+userRole);
		System.out.println("userProfile"+userProfile);
		if(driver.findElements(roleBasedLoginSelector.getUserLoginBtn()).size() > 0 ){
			//System.out.println(driver.findElement(By.xpath(".//table[@class='detailList']/tbody/tr[3]/td[4]/a")).getText());
			commonUtil.waitForElementToBeVisible(By.xpath(".//table[@class='detailList']")).click();
			screenshot("USer Details " + users+ "  -  "+ userRole);
			//driver.findElement(By.xpath("//html")).click();
			roleBasedLoginPage.clickLoginBtn();
			
		if(driver.findElements(roleBasedLoginSelector.getAllTabsMenu()).size() > 0 ){
			roleBasedLoginPage.clickAllTabs();
		try{
		if(driver.findElements(roleBasedLoginSelector.getBuAccountLink()).size() > 0 ){
			screenshot("BU Account team link for " + users+ "  -  "+ userRole);
			logger.error("The Search BU link field was displayed for user: " + users + " with role  " + userRole+ " and profile "+userProfile +
					 " BU Account Team");
		}
		}catch (Exception e) {
			
		}
		if(driver.findElements(roleBasedLoginSelector.getBuAccountLinkSearch()).size() > 0 ){
			screenshot("BU Account team Search link for " + users+ " - "+ userRole);
			logger.error("The BU Account Team Search link field was displayed for user:  " + users + " with role  " + userRole+ " and profile "+userProfile +
					 " BU Account Team");
		}
		}else{
			logger.info("All tabs link is not present for the user " +users+ " with role " + userRole+ " and profile "+userProfile );
		}
		roleBasedLoginPage.clickLogoutMenu();
		roleBasedLoginPage.clickLogoutLink();
		
		}else{
			logger.info("Login button not present for the user "+users+" with role "+ userRole+ " and profile "+userProfile);
		}
		}	
		
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
					new File("Screenshots" + File.separator + "ID-" + page + "-DATE-" + dateFormat.format(date) + ".png"));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	@AfterClass
	public void afterTest() throws IOException{
		//roleBasedLoginPage.clickPeopleTab();
		 //driver.quit();
	}
}
