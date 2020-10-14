package com.umtest.selfcare.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.umtest.testframe.lib.AppWait;
import com.umtest.testframe.lib.MainUtil;

public class SelfcareLoginLogoutPage extends MainUtil {

	private RemoteWebDriver driver;

	public SelfcareLoginLogoutPage(RemoteWebDriver driver) {
		this.driver = driver;
	}


	@FindBy(xpath = "//a[contains(text(),'Click here to retrieve your PIN')]")
	private WebElement buttonRetrievePIN;
	
	@FindBy(id = "msisdn")
	private WebElement textboxMSISDN;
	
	@FindBy(xpath = "//input[@class='button-black']")
	private WebElement buttonSubmit;
	
	@FindBy(xpath = "//input[@value='Close']")
	private WebElement buttonClose;
	
	@FindBy(xpath = "//a[contains(@class,'selfcare-nav-link')]")
	private WebElement buttonSelfcareLogin;
	
	@FindBy(id = "password")
	private WebElement textboxPIN;
	
	@FindBy(id = "btn_login_submit")
	private WebElement buttonLogin;
	
	@FindBy(xpath = "//div[@class='menu my_account expand']")
	private WebElement buttonManageAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Account Details')]")
	private WebElement buttonAccountDetails;
	
	@FindBy(xpath = "//div[@class='due']")
	private WebElement labelExpiryDate;
	
	@FindBy(xpath = "(//td[@align='left'])[4]")
	private WebElement labelPlanName;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement buttonLogout;
	
	
	@FindBy(xpath="//div[contains(text(),'Mobile Number:')]//following::div[1]")
	private WebElement MobileNumber;
	
	@FindBy(xpath="(//span[@class='value'])[1]")
	private WebElement BSCSAccountNumber;
	
	@FindBy(xpath="(//span[@class='value'])[2]")
	private WebElement DateRegister;
	
	@FindBy(xpath="//span[@class='value Active']")
	private WebElement Status;
	
	@FindBy(xpath="//div[@class='table_plan selfcare_table']/table/tbody/tr[2]/td[2]")
	private WebElement CurrentRatePlan;
	
	@FindBy(xpath="//div[@class='table_plan selfcare_table']/table/tbody/tr[4]/td[2]")
	private WebElement CreditLimit;
	
	@FindBy(xpath="//div[contains(text(),'balance')]//following::div[1]")
	private WebElement CurrentBalance;
	
	
	
	@FindBy(xpath = "//div[@class='menu my_bill expand']//a[contains(text(),'Payment History')]")
	private WebElement PaymentHistory;
	
	@FindBy(xpath = "//a[contains(text(),'Change Rate Plan')]")
	private WebElement ChangeRatePlan;
	
	@FindBy(xpath = "//a[@class='button']")
	private WebElement Changeyourplannowbutton;
	
	@FindBy(xpath = "//button[@id='principlebtn']")
	private WebElement Proceedbutton;
	
	@FindBy(xpath = "//div[@class='crp-confirm-inline-inputs']")
	private WebElement CRPConfirmCheckbox;
	
	@FindBy(xpath = "//button[@name='confirmBtn']")
	private WebElement CRPConfirmbutton;
	
	@FindBy(xpath = "//div[@class='menu my_bill expand']")
	private WebElement Billandpayment;
	
	@FindBy(xpath = "//div[contains(text(),'MYR')]")
	private WebElement labelAccountBalance;
	
	public WebElement getButtonRetrievePIN() {
		return AppWait.waitForElementToBeClickable(driver, buttonRetrievePIN);
	}
	
	public WebElement getTextboxMSISDN() {
		return AppWait.waitForElementToBeClickable(driver, textboxMSISDN);
	}
	
	public WebElement getButtonSubmit() {
		return AppWait.waitForElementToBeClickable(driver, buttonSubmit);
	}
	
	public WebElement getButtonClose() {
		return AppWait.waitForElementToBeClickable(driver, buttonClose);
	}
	
	
	public WebElement getButtonSelfcareLogin() {
		return AppWait.waitForElementToBeClickable(driver, buttonSelfcareLogin);
	}

	public WebElement getTextboxPassword() {
		return AppWait.waitForElementToBeClickable(driver, textboxPIN);
	}
	
	public WebElement getButtonLogin() {
		return AppWait.waitForElementToBeClickable(driver, buttonLogin);
	}
	
	public WebElement getButtonManageAccount() {
		return AppWait.waitForElementToBeClickable(driver, buttonManageAccount);
	}
	
	public WebElement getButtonAccountDetails() {
		return AppWait.waitForElementToBeClickable(driver, buttonAccountDetails);
	}
	
	public WebElement getLabelExpiryDate() {
		return AppWait.waitForElementToBeClickable(driver, labelExpiryDate);
	}
	
	public WebElement getLabelPlanName() {
		return AppWait.waitForElementToBeClickable(driver, labelPlanName);
	}
	
	public WebElement getButtonLogout() {
		return AppWait.waitForElementToBeClickable(driver, buttonLogout);
	}
	
	public WebElement getMobileNumber() {
		return AppWait.waitForElementToBeClickable(driver, MobileNumber);
	}
	
	public WebElement getBSCSAccountNumber() {
		return AppWait.waitForElementToBeClickable(driver, BSCSAccountNumber);
	}
	
	public WebElement getDateRegister() {
		return AppWait.waitForElementToBeClickable(driver, DateRegister);
	}
	
	public WebElement getStatus() {
		return AppWait.waitForElementToBeClickable(driver, Status);
	}
	
	public WebElement getCurrentRatePlan() {
		return AppWait.waitForElementToBeClickable(driver, CurrentRatePlan);
	}
	
	public WebElement getCreditLimit() {
		return AppWait.waitForElementToBeClickable(driver, CreditLimit);
	}
	
	public WebElement getCurrentBalance() {
		return AppWait.waitForElementToBeClickable(driver, CurrentBalance);
	}
	
	public WebElement getPaymentHistory() {
		return AppWait.waitForElementToBeClickable(driver, PaymentHistory);
	}
	
	public WebElement getChangeRatePlan() {
		return AppWait.waitForElementToBeClickable(driver, ChangeRatePlan);
	}
	
	public WebElement getChangeyourplannowbutton() {
		return AppWait.waitForElementToBeClickable(driver, Changeyourplannowbutton);
	}
	
	public WebElement getProceedbutton() {
		return AppWait.waitForElementToBeClickable(driver, Proceedbutton);
	}
	
	public WebElement getCRPConfirmCheckbox() {
		return AppWait.waitForElementToBeClickable(driver, CRPConfirmCheckbox);
	}
	
	public WebElement getCRPConfirmbutton() {
		return AppWait.waitForElementToBeClickable(driver, CRPConfirmbutton);
	}
	
	public WebElement getBillandpayment() {
		return AppWait.waitForElementToBeClickable(driver, Billandpayment);
	}
	
	public WebElement getLabelAccountBalance() {
		return AppWait.waitForElementToBeClickable(driver, labelAccountBalance);
	}
}
