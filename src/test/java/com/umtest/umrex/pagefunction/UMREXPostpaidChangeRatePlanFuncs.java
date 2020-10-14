package com.umtest.umrex.pagefunction;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.lib.PropertyHelper;
import com.umtest.testframe.lib.RandomDataGenerator;
import com.umtest.umrex.pageobject.UMREXRegistrationPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UMREXPostpaidChangeRatePlanFuncs extends UMREXRegistrationPage {
	private static Logger logger = LogManager.getLogger(UMREXPostpaidChangeRatePlanFuncs.class);
	private AndroidDriver driver;

	public UMREXPostpaidChangeRatePlanFuncs(RemoteWebDriver driver) {
		super((AndroidDriver) driver);
		this.driver = (AndroidDriver) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
		
		
	}
	public boolean doPostpaidChangePlan(String registrationType, String identificationType) {

		boolean methodReturn = false;

		try {
			clickElement(getButtonPostpaid(), "Postpaid Button", driver);
			if (registrationType.equalsIgnoreCase("MALAYSIAN")) {
				clickElement(getbuttonReadIDPostpaid(), "Read ID Button", driver);
			} else {	
			 clickElement(getButtonScanIDPostpaid(), "Scan ID Button", driver);
			}
			
			ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("msisdn"));
			
			if (registrationType.equalsIgnoreCase("MALAYSIAN")) {
				clickElement(getCardtype(), "Card Type", driver);
				clickElement(getselectMyKad(), "Select MyKad", driver);
				sendKeys(getTextboxIDNumber(), dictionary.get("CUSTOMER_ID"), "Customer ID", "", driver);
				sendKeys(getTextboxName(), dictionary.get("CUSTOMER_NAME"), "Customer Name", "", driver);
				clickElement(getSpinnerGender(), "Gender Spinner", driver);
				clickElement(getSelectMale(), "Select Male", driver);
				sendKeys(getDateDD(), dictionary.get("CUSTOMER_DOB_DD"), "Customer DOB Date", "", driver);
				sendKeys(getDateMM(), dictionary.get("CUSTOMER_DOB_MM"), "Customer DOB Month", "", driver);
				sendKeys(getDateYYYY(), dictionary.get("CUSTOMER_DOB_YYYY"), "Customer DOB Year", "", driver);
				clickElement(getRace(), "Race", driver);
				clickElement(getselectMalay(), "Select Malay", driver);
				sendKeys(gettextboxAddressform(), dictionary.get("CUSTOMER_ADDRESS"), "CUSTOMER ADDRESS", "", driver);
				sendKeys(gettextboxPostcodeform(), dictionary.get("CUSTOMER_POSTCODE"), "CUSTOMER ADDRESS", "", driver);
				sendKeys(gettextboxPostcodeform(), dictionary.get("CUSTOMER_CITY"), "CUSTOMER CITY", "", driver);
				sendKeys(gettextboxPostcodeform(), dictionary.get("CUSTOMER_STATE"), "CUSTOMER STATE", "", driver);
				scrollUDLR(driver, 0, "U");
				clickElement(getButtonContinue(), "Continue Button", driver);
				clickElement(getButtonContinue(), "Continue Button", driver);
			} else {
				
			
			sendKeys(getTextboxIDNumber(), dictionary.get("CUSTOMER_ID"), "Customer ID", "", driver);
			sendKeys(getTextboxName(), dictionary.get("CUSTOMER_NAME"), "Customer Name", "", driver);
			clickElement(getSpinnerGender(), "Gender Spinner", driver);
			clickElement(getSelectMale(), "Select Male", driver);
			sendKeys(getDateDD(), dictionary.get("CUSTOMER_DOB_DD"), "Customer DOB Date", "", driver);
			sendKeys(getDateMM(), dictionary.get("CUSTOMER_DOB_MM"), "Customer DOB Month", "", driver);
			sendKeys(getDateYYYY(), dictionary.get("CUSTOMER_DOB_YYYY"), "Customer DOB Year", "", driver);
			clickElement(getSpinnerNationality(), "Nationality Spinner", driver);
			clickElement(getSelectAntartica(), "Select Antartica", driver);
			scrollUDLR(driver, 0, "U");
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
		}
			
			clickElement(getCRPSelectMSISDN(), "Select MSISDN Button", driver);
			
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fl.pra:id/tvItem'][@text='"+MainUtil.dictionary.get("msisdn")+" (Principal)']")).click();
			
			clickElement(getCRPSelectType(), "CRP Select Type", driver);
			
			clickElement(getChangeposttopostprinciple(), "CRP Postpaid to Postpaid", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getSelectButton(), "Select Button", driver);
			
			clickElement(selectPostpaidPlan(MainUtil.dictionary.get("NEWPLAN_NAME")), "Select Plan", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getButtonTNC(), "Terms And Conditions", driver);
			scrollUDLR(driver, 0, "U");
			scrollUDLR(driver, 0, "U");
			clickElement(getSpinnerERFEmail(), "Send eRF Email", driver);
			clickElement(getSelectEmailID(), "Select Email ID", driver);
			
			clickElement(getSignatureArea(), "Tap here to sign", driver);
			doSignature(driver);
			clickElement(getButtonSign(), "Sign", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			dictionary.put("PURCHASE_PASSWORD", PropertyHelper.getENVProperties("UMREX_PURCHASE_PASSWORD"));
			sendKeys(getTextboxPurchasePasswordPostpaid(), dictionary.get("PURCHASE_PASSWORD"), "Password", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonYES(), "Yes Button", driver);

			boolean checkFlag = checkForText("", getLabelSuccessMessagePostpaid(), "Thank you for your order", "Success Message", driver);
			
			if (checkFlag == true) {
				ApplicationUtil.updateRateplanName(MainUtil.dictionary.get("msisdn"), MainUtil.dictionary.get("NEWPLAN_NAME")) ;
				
				methodReturn = true;
				clickElement(getButtonBackToHome(), "Back To Home Button", driver);
			} else {
				clickElement(getButtonOK(), "Ok Button", driver);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
		return methodReturn;
		}
}
