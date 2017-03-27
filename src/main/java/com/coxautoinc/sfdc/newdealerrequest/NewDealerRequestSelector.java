package com.coxautoinc.sfdc.newdealerrequest;

import org.openqa.selenium.By;

public class NewDealerRequestSelector {
	
	private By newDlrReqLink;
	private By selectUrgReq;
	private By checkSubmit;
	private By selectOwnershipChange;
	private By accntName;
	private By selDealerGrp;
	private By dealerGrpAccnt;
	private By dealerType;
	private By namePlate;
	private By addNamePlateBtn;
	private By custWebsiteUrl;
	private By custType;
	private By lotSizeNew;
	private By lotSizeUsed;
	private By physLocPhone;
	private By physLocStreet1;
	private By physLocCity;
	private By selectphysLocState;
	private By physLocZip;
	private By selectPhysAddSameAsBilling;

	NewDealerRequestSelector(){
		init();
	}
	
	public By getNewDlrReqLink() {
		return newDlrReqLink;
	}

	public By getSelectUrgReq() {
		return selectUrgReq;
	}

	public By getCheckSubmit() {
		return checkSubmit;
	}

	public By getSelectOwnershipChange() {
		return selectOwnershipChange;
	}

	public By getAccntName() {
		return accntName;
	}

	public By getSelDealerGrp() {
		return selDealerGrp;
	}

	public By getDealerGrpAccnt() {
		return dealerGrpAccnt;
	}

	public By getDealerType() {
		return dealerType;
	}

	public By getNamePlate() {
		return namePlate;
	}

	public By getAddNamePlateBtn() {
		return addNamePlateBtn;
	}

	public By getCustWebsiteUrl() {
		return custWebsiteUrl;
	}

	public By getCustType() {
		return custType;
	}

	public By getLotSizeNew() {
		return lotSizeNew;
	}

	public By getLotSizeUsed() {
		return lotSizeUsed;
	}

	public By getPhysLocPhone() {
		return physLocPhone;
	}

	public By getPhysLocStreet1() {
		return physLocStreet1;
	}

	public By getPhysLocCity() {
		return physLocCity;
	}

	public By getSelectphysLocState() {
		return selectphysLocState;
	}

	public By getPhysLocZip() {
		return physLocZip;
	}

	public By getSelectPhysAddSameAsBilling() {
		return selectPhysAddSameAsBilling;
	}

	private void init(){
		newDlrReqLink = By.linkText("New Dealer Request");
		selectUrgReq = By.id("00Nj000000C1bRV");
		checkSubmit = By.id("00Nj000000C14Ox");
		selectOwnershipChange = By.id("00Nj000000C1bRK");
		accntName = By.id("00Nj000000C14OY");
		selDealerGrp = By.id("00Nj000000C1bRJ");
		dealerGrpAccnt = By.id("CF00Nj000000C14Ty");
		dealerType = By.id("00Nj000000C1bRI");
		namePlate = By.id("00Nj000000C1bRN_unselected");
		addNamePlateBtn = By.xpath("//a[@title = 'Add']");
		custWebsiteUrl = By.id("00Nj000000C1bRH");
		custType = By.id("00Nj000000C1bRG");
		lotSizeNew = By.id("00Nj000000C1bRL");
		lotSizeUsed = By.id("00Nj000000C1bRM");
		physLocPhone = By.id("00Nj000000C1bRP");
		physLocStreet1 = By.id("00Nj000000C1bRS");
		physLocCity = By.id("00Nj000000C1bRO");
		selectphysLocState = By.id("00Nj000000C1bRR");
		physLocZip = By.id("00Nj000000C1bRQ");
		selectPhysAddSameAsBilling = By.id("00Nj000000C1bR8");
	}
}
