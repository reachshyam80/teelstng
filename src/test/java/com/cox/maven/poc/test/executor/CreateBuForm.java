package com.cox.maven.poc.test.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import com.coxautoinc.sfdc.buform.BuFormPage;
import com.coxautoinc.sfdc.common.CommonPage;
import com.coxautoinc.sfdc.login.LoginPage;
import com.coxautoinc.sfdc.utilities.CommonUtil;
public class CreateBuForm extends TestNgBaseClass {

	private static final Logger logger = LoggerFactory.getLogger(OpportunitiesPageExecutor.class);
	private String excelFilePath;
	private String excelSheetName;
	private String userName;
	private String password;
	private String browserName;
	private CommonUtil commonUtil;
	private BuFormPage buFormPage;
	private CommonPage commonPage;
	
    /**
     * Method to initialize test variables.
     */
	/**
	 * @param sheetName
	 * @param excelFileName
	 * @param browserName
	 */
	@BeforeClass
	@Parameters({ "loginExcelSheetName", "excelFileName"})
	public void beforeTest(String sheetName, String excelFileName) throws Exception {
		this.commonUtil = new CommonUtil(driver);
		this.buFormPage = new BuFormPage(driver);
		this.excelSheetName = sheetName;
		this.excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + excelFileName + ".xlsx";
		userName = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Username");
		password = commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Password");
		this.commonPage = new CommonPage(driver);
		/*try {
			FileUtils.cleanDirectory(new File("tmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		super.login(userName,password);
	}
	/**
	 * Test to verify that a user can successfully log in to SFDC
	 */
	//@Test
	public void login() {
		logger.info("Entering test method: verifyLoginToSalesForce");

		LoginPage loginPage = new LoginPage(driver);

		// Navigate to SFDC.
		logger.info("Navigating to url: {}", baseUrl);
		driver.get(baseUrl);
		loginPage.loginToSalesForce(userName, password);
		//screenshot("Login Page onload");
		// Assert that the search button is displayed to show that we are logged
		// in,
		// return a custom error message if it is not found.
		// Assert.assertTrue(homePage.isSearchBtnDisplayed(), "The Search button
		// for SFDC was not found.");

		logger.info("Exiting test method: verifyLoginToSalesForce");

	}
	/**
	 * Test to verify that a user can create Buform
	 */
	//@Test(dependsOnMethods = "login")
	@Test
	public void loadBuForm() {
		try {
			buFormPage.sendKeysToSearch(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Search"));
			buFormPage.clickBuOpportunity();
			buFormPage.clickBuOpportunityRequest();
		//	buFormPage.selectRequestType(type);
			//screenshot("Dealer Page onload");
			/*newDealerRequestPage.sendKeysToUrgentReq(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Urgent Request"));
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
			newDealerRequestPage.sendKeysToSelBillingAdd(commonUtil.getColumnDataFromExcel(excelFilePath, excelSheetName, "Billing Address same as Physical?"));*/
			commonPage.clickSaveBtn();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("second class for suite");
}
}
