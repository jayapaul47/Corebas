package com.umtest.umrex.pagefunction;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.lib.PropertyHelper;
import com.umtest.testframe.lib.RandomDataGenerator;
import com.umtest.umrex.pageobject.UMREXRegistrationPage;

import java.time.Duration;

public class UMREXPrepaidRegistrationFuncs extends UMREXRegistrationPage {

	private static Logger logger = LogManager.getLogger(UMREXPrepaidRegistrationFuncs.class);
	private AndroidDriver driver;

	public UMREXPrepaidRegistrationFuncs(RemoteWebDriver driver) {
		super((AndroidDriver) driver);
		this.driver = (AndroidDriver) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

	}


	public boolean doPrepaidRegistration(String registrationType, String identificationType) {

		boolean methodReturn = false;

		try {

			clickElement(getButtonPrepaid(), "Prepaid Button", driver);
			clickElement(getButtonScanID(), "Scan ID Button", driver);

			if (identificationType.equalsIgnoreCase("MALAYSIAN")) {
				clickElement(getButtonMyKad(), "MyKad Button", driver);
			} else {
				clickElement(getButtonPassport(), "Passport Button", driver);
			}

			clickElement(getButtonScan(), "Scan Button", driver);


			RandomDataGenerator.generateCustomerDataUMREX(identificationType);
			ApplicationUtil.getMSISDNFromSIMTable("PREPAID", MainUtil.dictionary.get("PLAN_NAME"));


			fillInCustomerDetails(identificationType);
			scanSIMPack(MainUtil.dictionary.get("MSISDN"));


			scrollUDLR(driver, 1, "U");
			scrollUDLR(driver, 1, "U");
			scrollUDLR(driver, 1, "U");

			clickElement(getButtonSubmit(), "Submit Button", driver);

			if (registrationType.equalsIgnoreCase("BUNDLE")) {

				clickElement(getButtonBundlePurchase(), "Bundle Purchase Button", driver);
				dictionary.put("PURCHASE_PASSWORD", PropertyHelper.getENVProperties("UMREX_PURCHASE_PASSWORD"));
				sendKeys(getTextboxPurchasePassword(), dictionary.get("PURCHASE_PASSWORD"), "Password", "", driver);
				sendKeys(getTextboxPurchaseTopupAmount(), dictionary.get("TOPUP_AMOUNT")+"00", "Topup Amount", "", driver);

				if (dictionary.get("BUNDLE_NAME").contains("MB") || dictionary.get("BUNDLE_NAME").contains("mb")) {

					clickElement(getRadioButtonMB(), "Radio MB Button", driver);
				} else if (dictionary.get("BUNDLE_NAME").contains("EPIKKK") || dictionary.get("BUNDLE_NAME").contains("EPIKKK")) {

					clickElement(getRadioButtonEPIKKK(), "Radio EPIKKK Button", driver);
				}

				clickElement(getDropdownBundle(), "Dropdown Bundle", driver);
				clickElement(selectBundleName(dictionary.get("BUNDLE_NAME")), "Bundle Name", driver);
				clickElement(getButtonPurchase(), "Purchase Button", driver);
				clickElement(getButtonConfirm(), "Confirm Button", driver);

			} else if (registrationType.equalsIgnoreCase("TOPUP")) {

				clickElement(getButtonTopup(), "Topup Button", driver);
				dictionary.put("PURCHASE_PASSWORD", PropertyHelper.getENVProperties("UMREX_PURCHASE_PASSWORD"));
				sendKeys(getTextboxTopupPassword(), dictionary.get("PURCHASE_PASSWORD"), "Password", "", driver);
				sendKeys(getTextboxTopupAmount(), dictionary.get("TOPUP_AMOUNT")+"00", "Topup Amount", "", driver);
				clickElement(getButtonFinalTopup(), "Topup Button", driver);
				clickElement(getButtonConfirm(), "Confirm Button", driver);

			} else {

				clickElement(getButtonRegistrationOnly(), "Registration Only Button", driver);
			}

			Thread.sleep(10000);

			getButtonOK();

			boolean checkFlag = checkForText("", getPostSubmitMessage(), "Your registration request is being processed. Please wait for your confirmation SMS.", "Success Message", driver);
			
			if (checkFlag == true) {
				ApplicationUtil.insertAccountIntoDB("PREPAID","UMREX",registrationType);
				ApplicationUtil.updateSIMStatusInSIMDetails(MainUtil.dictionary.get("SIM_NO"));
				methodReturn = true;
				clickElement(getButtonOK(), "Ok Button", driver);
				clickElement(getButtonNO(), "No Button", driver);
			} else {
				clickElement(getButtonOK(), "Ok Button", driver);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
		return methodReturn;
	}

	public void fillInCustomerDetails(String registrationType) {
		try {

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

			sendKeys(getTextboxAddress(), dictionary.get("CUSTOMER_ADDRESS"), "Customer Address", "", driver);
			scrollUDLR(driver, 0, "U");
			sendKeys(getTextboxCity(), dictionary.get("CUSTOMER_CITY"), "Customer City", "", driver);
			sendKeys(getTextboxState(), dictionary.get("CUSTOMER_STATE"), "Customer State", "", driver);
			sendKeys(getTextboxPostcode(), dictionary.get("CUSTOMER_POSTCODE"), "Customer Postcode", "", driver);
			sendKeys(getTextboxEmailID(), dictionary.get("CUSTOMER_EMAIL"), "Customer Email ID", "", driver);
			sendKeys(getTextboxAlternateContact(), dictionary.get("CUSTOMER_NUMBER"), "Customer Contact Number", "", driver);
			scrollUDLR(driver, 0, "U");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while filling up customer details  :" + e);
		}
	}
	
	public boolean doPrepaidPhoneBundleRegistration(String registrationType, String identificationType) {

		boolean methodReturn = false;

		try {

			scrollUDLR(driver, 0, "U");
			clickElement(getButtonPrepaidPhoneBundle(), "Prepaid Phone Bundle Button", driver);
			clickElement(getButtonScanIDPostpaid(), "Scan ID Button", driver);
			
			RandomDataGenerator.generateCustomerDataUMREX(identificationType);
			ApplicationUtil.getMSISDNFromSIMTable("POSTPAID", MainUtil.dictionary.get("PLAN_NAME"));
			ApplicationUtil.getIMEINo();
			
			fillInCustomerDetailsPhoneBundle(identificationType);
					
			clickElement(getButtonAddPrincipalLine(), "Add Pricipal Line Button", driver);
			
			/*if (dictionary.get("MSISDN") != null || dictionary.get("MSISDN") != "NA") {
				
				clickElement(getRadioButtonDealerPool(), "Dealer Pool", driver);
				sendKeys(getTextboxSearchMSISDN(), dictionary.get("MSISDN").substring(4, dictionary.get("MSISDN").length()), "Search MSISDN", "", driver);
			}*/
			//clickElement(getRadioButtonDealerPool(), "Dealer Pool", driver);
			//clickElement(getButtonSearch(), "Search Button", driver);
			//clickElement(getButtonOK(), "OK Button", driver);
			clickElement(getButtonFirstMSISDN(), "Select MSISDN", driver);
			//clickElement(getButtonOK(), "OK Button", driver);
			dictionary.put("MSISDN", getButtonFirstMSISDN().getText());
			System.out.println("MSISDN : "+dictionary.get("MSISDN"));
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(selectPostpaidPlan(MainUtil.dictionary.get("BUNDLE_NAME")), "Select Plan", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			sendKeys(getTextboxIMEI(), dictionary.get("IMEI_NO"), "IMEI No", "", driver);
			clickElement(getButtonVerify(), "Verify Button", driver);
			Thread.sleep(5000);
			
			clickElement(getDropdownPromotion(), "Promo Dropdown", driver);
			clickElement(getSelectFirstPromotion(), "Select First", driver);
			Thread.sleep(5000);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			sendKeys(getTextboxSIMNo(), dictionary.get("SIM_NO"), "SIM", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
		
			getLabelSubscriptionSummary();
			scrollUDLR(driver, 0, "U");
			dictionary.put("TOTAL_AMOUNT", getLabelTotalAmountPhoneBundle().getText());
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getSpinnerEventType(), "Event Type", driver);
			clickElement(selectEvenType("Dealer Outlet"), "Dealer Outlet", driver);
			
			sendKeys(getTextboxEventPostcode(), "55100", "Event Postcode", "", driver);
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
			
			Thread.sleep(20000);
			
			clickElement(getLabelMakePayment(), "Make Payment Label", driver);
			
			scrollUDLR(driver, 0, "U");
			scrollUDLR(driver, 0, "U");
			scrollUDLR(driver, 0, "U");
			
			
			clickElement(getButtonAddPaymentMethod(), "Add Payment Button", driver);
			clickCashButton(driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			sendKeys(getTextboxPurchasePasswordPhoneBundle(), "55100", "Event Postcode", "", driver);

			boolean checkFlag = checkForText("", getLabelSuccessMessagePostpaid(), "Thank you for your order", "Success Message", driver);
			
			if (checkFlag == true) {
				ApplicationUtil.insertAccountIntoDB("POSTPAID","UMREX",registrationType);
				ApplicationUtil.updateSIMStatusInSIMDetails(MainUtil.dictionary.get("SIM_NO"));
				ApplicationUtil.updateIMEIStatusInIMEIDetails(MainUtil.dictionary.get("IMEI_NO"));
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
	
	public void fillInCustomerDetailsPhoneBundle(String registrationType) {
		try {

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
			
			compareInString(getLabelDDMFCheck().getText(), "PASS", "DDMF Check", driver);
			compareInString(getLabelAgeValidationStatus().getText(), "PASS", "Age Validation", driver);
			compareInString(getLabelInternalBlacklistStatus().getText(), "PASS", "Internal Blacklist", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getSpinnerTitle(), "Title Spinner", driver);
			scrollUDLR(driver, 0, "U");
			clickElement(getSelectMR(), "Mr", driver);
			scrollUDLR(driver, 0, "U");
			scrollUDLR(driver, 0, "U");
			sendKeys(getTextboxAddressPostpaid(), dictionary.get("CUSTOMER_ADDRESS"), "Customer Address", "", driver);
			sendKeys(getTextboxPostcodePostpaid(), dictionary.get("CUSTOMER_POSTCODE"), "Customer Postcode", "", driver);
			scrollUDLR(driver, 0, "U");
			sendKeys(getTextboxAlternateNumberArea(), dictionary.get("CUSTOMER_NUMBER").substring(0, 4), "Customer Number Area", "", driver);
			sendKeys(getTextboxAlternateNumber(), dictionary.get("CUSTOMER_NUMBER").substring(4, dictionary.get("CUSTOMER_NUMBER").length()), "Customer Number", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while filling up customer details  :" + e);
		}
	}

	public void scanSIMPack(String MSISDN) {
		try {

			clickElement(getButtonScanSimPack(), "Scan Sim Pack Button", driver);
			clickElement(getButtonEnterSimPackManually(), "Enter Sim Pack Manually Button", driver);
			sendKeys(getTextboxMobileNumber(), MSISDN.substring(1, MSISDN.length()), "Mobile Number", "", driver);
			clickElement(getButtonSIMNext(), "Next Button", driver);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while scanning sim pack  :" + e);
		}
	}
	
	public void clickCashButton(AndroidDriver driver)
	{
		Dimension size = driver.manage().window().getSize();
		
		logger.info(size.width  + "::::::" + size.height);
		
		int x = (int) (size.width * 0.50);
		int y = (int) (size.height * 0.48);
		
		logger.info(x + "::::::" + y);
		
		TouchAction action= new TouchAction(driver);
		action.press(PointOption.point(x, y)).release().perform();
	}
}
