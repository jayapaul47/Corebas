package com.umtest.mobileapps.pageobject;


import java.util.List;

import org.openqa.selenium.WebElement;

import com.umtest.testframe.lib.AppWait;
import com.umtest.testframe.lib.MainUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MobileAppUtilPage extends MainUtil {

	private AndroidDriver<?> driver;

	public MobileAppUtilPage(AndroidDriver<?> driver) {
		this.driver = driver;
	}


	@AndroidFindBy(xpath = "//android.widget.TextView[@text='View All Usage Details']")
	private AndroidElement buttonViewUsageDetails;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@content-desc,\"usageDetail_cell\")])[1]/android.widget.TextView")
	private AndroidElement firstUsageDetailsCategory;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,\"usageDetail_cell\")]/android.widget.TextView")
	private WebElement usageDetailsCategory;

	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[1]//android.widget.TextView[2]")
	private WebElement labelAccountBalance;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
	private WebElement labelPlanName;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sidemenu_button_menu\"]/android.widget.ImageView")
	private WebElement MenuIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Up & Credit']")
	private WebElement MenuTopUpCredit;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CreditShare']")
	private WebElement MenuCreditShare;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")
	private WebElement labelCreditShareBal;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]")
	private WebElement labelCreditBal;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Transfer Credit\"]/android.view.View")
	private WebElement buttonTransferCredit1;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Request Credit\"]/android.widget.TextView")
	private WebElement buttonReqCredit;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"credit_textfield_contact\"]")
	private WebElement textReceiverMsisdn;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Transfer Credit\"]/android.widget.TextView")
	private WebElement buttonTransferCredit2;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Transfer']")
	private WebElement buttonTransferConfirm;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
	private WebElement buttonOK;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cell_RM1\"]")
	private WebElement buttonRM1;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cell_RM3\"]")
	private WebElement buttonRM3;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cell_RM5\"]")
	private WebElement buttonRM5;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cell_RM10\"]")
	private WebElement buttonRM10;
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bills and Payment']")
	private WebElement MenuBillsandPayment;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bill History']")
	private WebElement MenuBillHistory;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Services']")
	private WebElement MenuServices;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='GoLife']")
	private WebElement MenuGoLife;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"goLife_button_viewDetails\"])[2]/android.widget.TextView")
	private WebElement ButtonGoLife5;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"goLife_button_viewDetails\"])[4]/android.widget.TextView")
	private WebElement ButtonGoLife10;
	
	@AndroidFindBy(xpath = "@AndroidFindBy(xpath = \"//android.widget.TextView[@text='Subscribe']\")")
	private WebElement ButtonSubscribe;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='goLife_textField_email']")
	private WebElement Emailaddress;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='goLife_textField_confirmEmail']")
	private WebElement ConfirmEmailaddress;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement Nextbutton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Yes']")
	private WebElement Yesbutton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='I confirm that the information above is true, complete and acurate and agree thatthe information above shall be provided by U Mobile Sdn Bjd to Sun Life Malaysia Assurance Berhad for the purpose of my GOLIFE 5 / GOLIFE 10 application.']")
	private WebElement Confirmcheckbox;
		
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Please click the tick box if you agree to accept the terms and conditions above']")
	private WebElement Termandconditioncheckbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Thank you for subscribing']")
	private WebElement Successmessage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Close']")
	private WebElement Closebutton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='View Certificate']")
	private WebElement ViewCertificatebutton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Upgrade Plan']")
	private WebElement Upgradeplanbutton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Your Plan Now']")
	private WebElement ChangePlanNowbutton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed']")
	private WebElement Proceedbutton;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='CURRENT PLAN']")
	private WebElement Currntplanname;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@id='crpPlanBoxesNext']")
	private WebElement crpplanboxnextbutton;
	
	
	public AndroidElement getButtonViewUsageDetails() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonViewUsageDetails);
	}

	public AndroidElement getFirstUsageDetailsCategory() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, firstUsageDetailsCategory);
	}

	public List<WebElement> getUsageDetailsCategory() {
		return (List<WebElement>) AppWait.waitForElementToBeClickable(driver, usageDetailsCategory);
	}

	public AndroidElement getLabelAccountBalance() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelAccountBalance);
	}

	public AndroidElement getLabelPlanName() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelPlanName);
	}
	
	public AndroidElement getMenuIcon() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, MenuIcon);
	}
	
	public AndroidElement getMenuTopUpCredit() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, MenuTopUpCredit);
	}
	
	public AndroidElement getMenuCreditShare() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, MenuCreditShare);
	}
	
	public AndroidElement getLabelCreditShareBal() {
		return (AndroidElement) AppWait.waitForElementForVisibility(driver, labelCreditShareBal);
	}
	
	public AndroidElement getLabelCreditBal() {
		return (AndroidElement) AppWait.waitForElementForVisibility(driver, labelCreditBal);
	}
	
	public AndroidElement getButtonTransferCredit1() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonTransferCredit1);
	}
	
	public AndroidElement getButtonReqCredit() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonReqCredit);
	}
	
	public AndroidElement getTextReceiverMsisdn() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textReceiverMsisdn);
	}
	
	public AndroidElement getButtonTransferCredit2() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonTransferCredit2);
	}
	
	public AndroidElement getButtonTransferConfirm() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonTransferConfirm);
	}
	
	public AndroidElement getButtonOK() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonOK);
	}
	
	public AndroidElement getButtonDenomination() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, "//android.view.ViewGroup[@content-desc=\"cell_RM"+ MainUtil.dictionary.get("TRANSFER_AMOUNT") +"\"]");
	}
	
	public AndroidElement getButtonRM1() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonRM1);
	}
	
	
	public AndroidElement getButtonRM3() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonRM3);
	}
	
	public AndroidElement getButtonRM5() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonRM5);
	}
	
	public AndroidElement getButtonRM10() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonRM10);
	}
	
	public AndroidElement getMenuBillsandPayment() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, MenuBillsandPayment);
	}
			
	public AndroidElement getMenuBillHistory() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, MenuBillHistory);
	}
	
	public AndroidElement getMenuServices() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, MenuServices);
	}
	
	public AndroidElement getMenuGoLife() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, MenuGoLife);
	}
	
	public AndroidElement getButtonGoLife5() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, ButtonGoLife5);
	}
	
	public AndroidElement getButtonGoLife10() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, ButtonGoLife10);
	}
	
	public AndroidElement getButtonSubscribe() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, ButtonSubscribe);
	}
	
	public AndroidElement getEmailaddress() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Emailaddress);
	}
	
	public AndroidElement getConfirmEmailaddress() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, ConfirmEmailaddress);
	}
	
	public AndroidElement getNextbutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Nextbutton);
	}
	
	public AndroidElement getYesbutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Yesbutton);
	}
	
	public AndroidElement getConfirmcheckbox() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Confirmcheckbox);
	}
	
	public AndroidElement getTermandconditioncheckbox() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Termandconditioncheckbox);
	}
	
	public AndroidElement getSuccessmessage() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Successmessage);
	}
	
	public AndroidElement getClosebutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Closebutton);
	}
	
	public AndroidElement getViewCertificatebutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, ViewCertificatebutton);
	}
	
	public AndroidElement getUpgradeplanbutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Upgradeplanbutton);
	}
	
	public AndroidElement getChangePlanNowbutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, ChangePlanNowbutton);
	}
	
	public AndroidElement getProceedbutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Proceedbutton);
	}
	
	public AndroidElement getCurrntplanname() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Currntplanname);
	}
	
	public AndroidElement getcrpplanboxnextbutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, crpplanboxnextbutton);
	}
}
