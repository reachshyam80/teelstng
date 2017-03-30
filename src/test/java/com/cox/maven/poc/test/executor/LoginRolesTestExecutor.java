package com.cox.maven.poc.test.executor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
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
	@Parameters({ "excelSheetName", "excelFileName","loginExcelSheetName" })
	public void beforeTest(String sheetName, String excelFileName, String loginSheetName) throws Exception {
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
	}
	/**
	 * Test to verify that a user can successfully log in to SFDC
	 */
	@Test
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
	@Test(dependsOnMethods = "login")
	public void roleBasedLogin(){
		int i = 0;
		//Navigate to people tab
		for(String users: user){
			roleBasedLoginPage.clickPeopleTab();
			roleBasedLoginPage.sendKeysToName(users);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(users))).click();;
		roleBasedLoginPage.clickUserActionMenu();
		roleBasedLoginPage.clickUserDetailLink();
		if(driver.findElements(roleBasedLoginSelector.getUserLoginBtn()).size() > 0 ){
			roleBasedLoginPage.clickLoginBtn();
		if(driver.findElements(roleBasedLoginSelector.getAllTabsMenu()).size() > 0 ){
			roleBasedLoginPage.clickAllTabs();
		try{
		if(driver.findElements(roleBasedLoginSelector.getBuAccountLink()).size() > 0 ){
			System.out.println("BU Search present");
			logger.error("The Search BU link field was displayed for user: " + users + "with role" + role.get(i)+
					 "BU Account Team");
		}
		}catch (Exception e) {
			
		}
		if(driver.findElements(roleBasedLoginSelector.getBuAccountLinkSearch()).size() > 0 ){
			System.out.println("BU Account Team Search");
			logger.error("The BU Account Team Search link field was displayed for user: " + users + "with role" + role.get(i)+
					 "BU Account Team");
		}
		}else{
			logger.info("All tabs link is not present for the user "+users+" with role "+role.get(i));
		}
		roleBasedLoginPage.clickLogoutMenu();
		roleBasedLoginPage.clickLogoutLink();
		
		}else{
			logger.info("Login button not present for the user "+users+" with role "+role.get(i));
		}
		i++;
		}	
	}
	@AfterClass
	public void tearDown() throws IOException{
		 driver.quit();
	}
}
