package com.umtest.selfcare.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.umtest.testframe.lib.AppWait;
import com.umtest.testframe.lib.MainUtil;

public class SelfcareGolifePurchasePage extends MainUtil {
	
	private RemoteWebDriver driver;

	public SelfcareGolifePurchasePage(RemoteWebDriver driver) {
		this.driver = driver;
	}	
	
	@FindBy(xpath = "//div[@class='menu golife expand']")
	private WebElement buttonGoLIFE;
	
	@FindBy(xpath = "//a[contains(text(),'Life Insurance')]")
	private WebElement buttonlifeinsurance;
	
	@FindBy(xpath = "//div[@class='dragger-row']//div[1]//div[1]//div[2]//div[6]//a[1]")
	private WebElement GOLIFE5;
	
	@FindBy(xpath = "//div[@class='dragger']//div[2]//div[1]//div[2]//div[6]//a[1]")
	private WebElement GOLIFE10;
	
	@FindBy(xpath = "//a[contains(text(),'Next')]")
	private WebElement buttonNext;
	
	@FindBy(xpath = "//div[@class='up-form-row']//div[@class='inline-inputs']//label[1]")
	private WebElement buttonYes;
	
	@FindBy(xpath = "//div[contains(@class,'up-form-block')]/div[contains(@class,'inline-inputs')]/label[1]")
	private WebElement Aggrementcheckbox;
	
	@FindBy(xpath = "//input[contains(@name,'glsubmit')]")
	private WebElement buttonNextSubmit;
	
	@FindBy(xpath = "//input[@name='glemail1']")
	private WebElement emailaddress;
	
	
	@FindBy(xpath = "//input[@name='glemail2']")
	private WebElement confirmemailaddress;
	
	@FindBy(xpath = "//*[@id=\"glform\"]/div[1]/label/i")
	private WebElement confirmcheckbox;
	
	@FindBy(xpath = "//input[@id='finalSubmit']")
	private WebElement FinalSubmitbutton;
	
	@FindBy(xpath = "//a[contains(text(),'My Certificate')]")
	private WebElement buttonMyCertificate;
	
	@FindBy(xpath = "//div[@class='policy-details-header']//div[1]//div[2]")
	private WebElement DateofSubscription;
	
	@FindBy(xpath = "//div[@class='policy-details-header']//div[1]//div[3]")
	private WebElement DateofNextCharging;
	
	@FindBy(xpath = "//div[@class='policy-details-header']//div[2]//div[1]")
	private WebElement InsurancePlanname;
	
	@FindBy(xpath = "//div[@class='policy-details-header']//div[2]//div[2]")
	private WebElement InsuranceStatus;
	
	@FindBy(xpath = "//div[@class='policy-details-header']//div[2]//div[3]")
	private WebElement DateofCertRenewal;
	
	@FindBy(xpath = "//div[@class='policy-details-header']//div[4]")
	private WebElement PremiumAmount;
	
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
	
	@FindBy(xpath = "//*[@id=\"main_block\"]/div/div/div[2]/div[2]/a[2]")
	private WebElement buttonContinue;
		
	public WebElement getbuttonGoLIFE() {
		return AppWait.waitForElementToBeClickable(driver, buttonGoLIFE);
	}
	
	public WebElement getbuttonlifeinsurance() {
		return AppWait.waitForElementToBeClickable(driver, buttonlifeinsurance);
	}
	
	public WebElement getGOLIFE5() {
		return AppWait.waitForElementToBeClickable(driver, GOLIFE5);
	}
	
	public WebElement getGOLIFE10() {
		return AppWait.waitForElementToBeClickable(driver, GOLIFE10);
	}
	
	public WebElement getbuttonNext() {
		return AppWait.waitForElementToBeClickable(driver, buttonNext);
	}
	
	public WebElement getbuttonYes() {
		return AppWait.waitForElementToBeClickable(driver, buttonYes);
	}
	
	public WebElement getAggrementcheckbox() {
		return AppWait.waitForElementToBeClickable(driver, Aggrementcheckbox);
	}
	
	public WebElement getbuttonNextSubmit() {
		return AppWait.waitForElementToBeClickable(driver, buttonNextSubmit);
	}
	
	public WebElement getemailaddress() {
		return AppWait.waitForElementToBeClickable(driver, emailaddress);
	}
	
	public WebElement getconfirmemailaddress() {
		return AppWait.waitForElementToBeClickable(driver, confirmemailaddress);
	}
	
	public WebElement getconfirmcheckbox() {
		return AppWait.waitForElementToBeClickable(driver, confirmcheckbox);
	}
	
	public WebElement getFinalSubmitbutton() {
		return AppWait.waitForElementToBeClickable(driver, FinalSubmitbutton);
	}
	
	public WebElement getbuttonMyCertificate() {
		return AppWait.waitForElementToBeClickable(driver, buttonMyCertificate);
	}
	
	public WebElement getDateofSubscription() {
		return AppWait.waitForElementToBeClickable(driver, DateofSubscription);
	}
	
	public WebElement getDateofNextCharging() {
		return AppWait.waitForElementToBeClickable(driver, DateofNextCharging);
	}
	
	public WebElement getInsurancePlanname() {
		return AppWait.waitForElementToBeClickable(driver, InsurancePlanname);
	}
	
	public WebElement getInsuranceStatus() {
		return AppWait.waitForElementToBeClickable(driver, InsuranceStatus);
	}
	
	public WebElement getDateofCertRenewal() {
		return AppWait.waitForElementToBeClickable(driver, DateofCertRenewal);
	}
	
	public WebElement getPremiumAmount() {
		return AppWait.waitForElementToBeClickable(driver, PremiumAmount);
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
	
	public WebElement getbuttonContinue() {
		return AppWait.waitForElementToBeClickable(driver, buttonContinue);
	}
}
