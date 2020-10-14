package com.umtest.selfcare.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.umtest.testframe.lib.AppWait;
import com.umtest.testframe.lib.MainUtil;

public class SelfcarePaybillPage extends MainUtil {
	
	private RemoteWebDriver driver;

	public SelfcarePaybillPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='menu my_bill expand']")
	private WebElement Billandpayment;
	
	@FindBy(xpath = "//div[@class='menu my_bill expand']//a[contains(text(),'Pay Bill')]")
	private WebElement Paybill;
	
	@FindBy(xpath = "//input[@name='amount']")
	private WebElement InsertPaymentAmount;
	
	@FindBy(xpath = "//div[@class='box-option']/label[1]")
	private WebElement PaymentMethodVisa;
	
	@FindBy(xpath = "//div[@class='box-option']/label[2]")
	private WebElement PaymentMethodMasterCard;
	
	@FindBy(xpath = "//div[@class='box-option']/label[3]")
	private WebElement PaymentMethodAmericanExp;
	
	@FindBy(xpath = "//input[@id='agreeterm']")
	private WebElement billpayAgreementcheckbox;
	
	@FindBy(xpath = "//input[@name='paynow']")
	private WebElement Paynowbutton;
		
	@FindBy(xpath = "//input[@id='CARDNAME']")
	private WebElement Cardname;
	
	@FindBy(xpath = "//td[1]//table[1]//tbody[1]//tr[1]//td[1]//input[1]")
	private WebElement CardTypeVisa;
	
	@FindBy(xpath = "//td[2]//table[1]//tbody[1]//tr[1]//td[1]//input[1]")
	private WebElement CardTypeMaster;
	
	@FindBy(xpath = "//input[@id='CARD_NO1']")
	private WebElement CardNumber1;
	
	@FindBy(xpath = "//input[@id='CARD_NO2']")
	private WebElement CardNumber2;
	
	@FindBy(xpath = "//input[@id='CARD_NO3']")
	private WebElement CardNumber3;
	
	@FindBy(xpath = "//input[@id='CARD_NO4']")
	private WebElement CardNumber4;
	
	@FindBy(xpath = "//select[@id='CARD_EXP_MM']")
	private WebElement CardExpiryMonth;
	
	@FindBy(xpath = "//select[@id='CARD_EXP_YY']")
	private WebElement CardExpiryYear;
	
	@FindBy(xpath = "//input[@id='CARD_CVC']")
	private WebElement CardCVV;
	
	@FindBy(xpath = "//select[@id='CARD_ISSUER_BANK_COUNTRY_CODE']")
	private WebElement CardIssuerBankCountry;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	private WebElement CardSubmitbutton;
	
	@FindBy(xpath = "//div[@class='invoice_succ_msg']")
	private WebElement Successfulmessage;
	
	@FindBy(xpath = "//body//tr[3]")
	private WebElement PaymentAmount;
	
	@FindBy(xpath = "//body//tr[4]")
	private WebElement PaymentDescription;
	
	@FindBy(xpath = "//body//tr[5]")
	private WebElement paymentNumber;

	@FindBy(xpath = "//a[contains(text(),'Top Up Now')]")
	private WebElement TopupNowbutton;
	
	@FindBy(xpath = "//*[@id=\"topuppayment_form\"]/div[2]/div[1]/label[1]")
	private WebElement topUpValue10button;
	
	@FindBy(xpath = "//*[@id=\"topuppayment_form\"]/div[2]/div[1]/label[2]")
	private WebElement topUpValue30button;
	
	@FindBy(xpath = "//*[@id=\"topuppayment_form\"]/div[2]/div[1]/label[3]")
	private WebElement topUpValue50button;
	
	@FindBy(xpath = "//*[@id=\"topuppayment_form\"]/div[2]/div[1]/label[4]")
	private WebElement topUpValue100button;
	
	@FindBy(xpath = "//div[contains(text(),'Top Up My Account')]")
	private WebElement buttonTopupMyAccount;
	
	@FindBy(xpath = "//*[@id=\"main_block\"]/div/div/div[1]/div/div[2]/div[2]/ul/li[2]/a")
	private WebElement buttonTopup;
	
	@FindBy(xpath = "//a[@class='menu topup_forfriend']")
	private WebElement buttonTopupforfriend;

	@FindBy(xpath = "//input[@placeholder='01X']")
	private WebElement buttonplaceholderfirst;
	
	@FindBy(xpath = "//input[@placeholder='xxx xxxx']")
	private WebElement buttonplaceholderlast;
	
	@FindBy(xpath = "//label//input[contains(@class,'field')]")
	private WebElement buttonEmailAddress;
	
	@FindBy(xpath = "//div[@id='reloadOptions']//div[1]//label[1]")
	private WebElement Reloadoption10button;
	
	@FindBy(xpath = "//div[@id='reloadOptions']//div[2]//label[1]")
	private WebElement Reloadoption30button;
	
	@FindBy(xpath = "//div[@id='reloadOptions']//div[3]//label[1]")
	private WebElement Reloadoption50button;
	
	@FindBy(xpath = "//div[@id='reloadOptions']//div[4]//label[1]")
	private WebElement Reloadoption100button;
	
	@FindBy(xpath = "//div[contains(@class,'top-up-form-row value-option')]//div[1]//label[1]")
	private WebElement ReloadTypeVisabutton;
	
	@FindBy(xpath = "//div[contains(@class,'top-up-form-row value-option')]//div[2]//label[1]")
	private WebElement ReloadTypeMasterbutton;
	
	@FindBy(xpath = "//div[contains(@class,'top-up-form-row value-option')]//div[3]//label[1]")
	private WebElement ReloadTypeAmExbutton;

	@FindBy(xpath = "//div[contains(@class,'terms-big')]")
	private WebElement Termsandconditioncheckbox;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement Nextbutton;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement TopupSubmitbutton;
	
	@FindBy(xpath = "//div[contains(@class,'two-panels-layout-heading-valigner')]")
	private WebElement Topupforfriendsuccessmsg;
	
	@FindBy(xpath = "//div[contains(text(),'MYR')]")
	private WebElement labelAccountBalance;
	
	public WebElement getBillandpayment() {
		return AppWait.waitForElementToBeClickable(driver, Billandpayment);
	}
	
	public WebElement getPaybill() {
		return AppWait.waitForElementToBeClickable(driver, Paybill);
	}
	
	public WebElement getInsertPaymentAmount() {
		return AppWait.waitForElementToBeClickable(driver, InsertPaymentAmount);
	}
	
	public WebElement getPaymentMethodVisa() {
		return AppWait.waitForElementToBeClickable(driver, PaymentMethodVisa);
	}
	
	public WebElement getPaymentMethodMasterCard() {
		return AppWait.waitForElementToBeClickable(driver, PaymentMethodMasterCard);
	}
	
	public WebElement getPaymentMethodAmericanExp() {
		return AppWait.waitForElementToBeClickable(driver, PaymentMethodAmericanExp);
	}
	
	public WebElement getbillpayAgreementcheckbox() {
		return AppWait.waitForElementToBeClickable(driver, billpayAgreementcheckbox);
	}
	
	public WebElement getPaynowbutton() {
		return AppWait.waitForElementToBeClickable(driver, Paynowbutton);
	}
	
	public WebElement getCardname() {
		return AppWait.waitForElementToBeClickable(driver, Cardname);
	}
	
	public WebElement getCardTypeVisa() {
		return AppWait.waitForElementToBeClickable(driver, CardTypeVisa);
	}
	
	public WebElement getCardTypeMaster() {
		return AppWait.waitForElementToBeClickable(driver, CardTypeMaster);
	}
	
	public WebElement getCardNumber1() {
		return AppWait.waitForElementToBeClickable(driver, CardNumber1);
	}
	
	public WebElement getCardNumber2() {
		return AppWait.waitForElementToBeClickable(driver, CardNumber2);
	}
	
	public WebElement getCardNumber3() {
		return AppWait.waitForElementToBeClickable(driver, CardNumber3);
	}
	
	public WebElement getCardNumber4() {
		return AppWait.waitForElementToBeClickable(driver, CardNumber4);
	}
	
	public WebElement getCardExpiryMonth() {
		return AppWait.waitForElementToBeClickable(driver, CardExpiryMonth);
	}
	
	public WebElement getCardExpiryYear() {
		return AppWait.waitForElementToBeClickable(driver, CardExpiryYear);
	}
	
	public WebElement getCardCVV() {
		return AppWait.waitForElementToBeClickable(driver, CardCVV);
	}
	
	public WebElement getCardIssuerBankCountry() {
		return AppWait.waitForElementToBeClickable(driver, CardIssuerBankCountry);
	}
	
	public WebElement getCardSubmitbutton() {
		return AppWait.waitForElementToBeClickable(driver, CardSubmitbutton);
	}
	
	public WebElement getSuccessfulmessage() {
		return AppWait.waitForElementToBeClickable(driver, Successfulmessage);
	}
	
	public WebElement getPaymentAmount() {
		return AppWait.waitForElementToBeClickable(driver, PaymentAmount);
	}
	
	public WebElement getPaymentDescription() {
		return AppWait.waitForElementToBeClickable(driver, PaymentDescription);
	}
	
	public WebElement getpaymentNumber() {
		return AppWait.waitForElementToBeClickable(driver, paymentNumber);
	}
	
	public WebElement getTopupNowbutton() {
		return AppWait.waitForElementToBeClickable(driver, TopupNowbutton);
	}
	
	public WebElement gettopUpValue10button() {
		return AppWait.waitForElementToBeClickable(driver, topUpValue10button);
	}
	
	public WebElement gettopUpValue30button() {
		return AppWait.waitForElementToBeClickable(driver, topUpValue30button);
	}
	
	public WebElement gettopUpValue50button() {
		return AppWait.waitForElementToBeClickable(driver, topUpValue50button);
	}
	
	public WebElement gettopUpValue100button() {
		return AppWait.waitForElementToBeClickable(driver, topUpValue100button);
	}
	
	public WebElement getbuttonTopupMyAccount() {
		return AppWait.waitForElementToBeClickable(driver, buttonTopupMyAccount);
	}
	
	public WebElement getbuttonTopup() {
		return AppWait.waitForElementToBeClickable(driver, buttonTopup);
	}
	
	public WebElement getbuttonTopupforfriend() {
		return AppWait.waitForElementToBeClickable(driver, buttonTopupforfriend);
	}
	
	public WebElement getbuttonplaceholderfirst() {
		return AppWait.waitForElementToBeClickable(driver, buttonplaceholderfirst);
	}
	
	public WebElement getbuttonplaceholderlast() {
		return AppWait.waitForElementToBeClickable(driver, buttonplaceholderlast);
	}
	
	public WebElement getbuttonEmailAddress() {
		return AppWait.waitForElementToBeClickable(driver, buttonEmailAddress);
	}
	
	public WebElement getReloadoption10button() {
		return AppWait.waitForElementToBeClickable(driver, Reloadoption10button);
	}
	
	public WebElement getReloadoption30button() {
		return AppWait.waitForElementToBeClickable(driver, Reloadoption30button);
	}
	
	public WebElement getReloadoption50button() {
		return AppWait.waitForElementToBeClickable(driver, Reloadoption50button);
	}
	
	public WebElement getReloadoption100button() {
		return AppWait.waitForElementToBeClickable(driver, Reloadoption100button);
	}
	
	public WebElement getReloadTypeVisabutton() {
		return AppWait.waitForElementToBeClickable(driver, ReloadTypeVisabutton);
	}
	
	public WebElement getReloadTypeMasterbutton() {
		return AppWait.waitForElementToBeClickable(driver, ReloadTypeMasterbutton);
	}
	
	public WebElement getReloadTypeAmExbutton() {
		return AppWait.waitForElementToBeClickable(driver, ReloadTypeAmExbutton);
	}
	
	public WebElement getTermsandconditioncheckbox() {
		return AppWait.waitForElementToBeClickable(driver, Termsandconditioncheckbox);
	}
	
	public WebElement getNextbutton() {
		return AppWait.waitForElementToBeClickable(driver, Nextbutton);
	}
	
	public WebElement getTopupSubmitbutton() {
		return AppWait.waitForElementToBeClickable(driver, TopupSubmitbutton);
	}
	
	public WebElement getTopupforfriendsuccessmsg() {
		return AppWait.waitForElementToBeClickable(driver, Topupforfriendsuccessmsg);
	}
	
	public WebElement getLabelAccountBalance() {
		return AppWait.waitForElementToBeClickable(driver, labelAccountBalance);
	}
}
