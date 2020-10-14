package com.umtest.umrex.pagefunction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.lib.PropertyHelper;
import com.umtest.testframe.lib.RandomDataGenerator;
import com.umtest.umrex.pageobject.UMREXRegistrationPage;

import java.time.Duration;

public class UMREXPostpaidRegistrationFuncs extends UMREXRegistrationPage {

	private static Logger logger = LogManager.getLogger(UMREXPostpaidRegistrationFuncs.class);
	private AndroidDriver driver;

	public UMREXPostpaidRegistrationFuncs(RemoteWebDriver driver) {
		super((AndroidDriver) driver);
		this.driver = (AndroidDriver) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

	}


	public boolean doPostpaidRegistration(String registrationType, String identificationType) {

		boolean methodReturn = false;

		try {

			clickElement(getButtonPostpaid(), "Postpaid Button", driver);
			if (identificationType.equals("MALAYSIAN")) {
				clickElement(getbuttonReadIDPostpaid(), "Read ID Button", driver);
			} else {	
			 clickElement(getButtonScanIDPostpaid(), "Scan ID Button", driver);
			}
			
			RandomDataGenerator.generateCustomerDataUMREX(identificationType);
			ApplicationUtil.getMSISDNFromSIMTable("POSTPAID", MainUtil.dictionary.get("PLAN_NAME"));
			
			fillInCustomerDetails(identificationType);
					
			clickElement(getButtonAddPrincipalLine(), "Add Pricipal Line Button", driver);
			
			if (dictionary.get("MSISDN") != null || dictionary.get("MSISDN") != "NA") {
				
				clickElement(getRadioButtonDealerPool(), "Dealer Pool", driver);
				sendKeys(getTextboxSearchMSISDN(), dictionary.get("MSISDN").substring(4, dictionary.get("MSISDN").length()), "Search MSISDN", "", driver);
			}
			
			clickElement(getButtonSearch(), "Search Button", driver);
			clickElement(getButtonOK(), "OK Button", driver);
			clickElement(getButtonFirstMSISDN(), "Select MSISDN", driver);
			dictionary.put("MSISDN", getButtonFirstMSISDN().getText());
			System.out.println("MSISDN : "+dictionary.get("MSISDN"));
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(selectPostpaidPlan(MainUtil.dictionary.get("PLAN_NAME")), "Select Plan", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			scrollUDLR(driver, 0, "U");
			sendKeys(getTextboxEmail(), dictionary.get("CUSTOMER_EMAIL"), "Customer Email ID", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			sendKeys(getTextboxSIMNo(), dictionary.get("SIM_NO"), "SIM", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getSpinnerEventType(), "Event Type", driver);
			clickElement(selectEvenType("Dealer Outlet"), "Dealer Outlet", driver);
			
			clickElement(getButtonEventStartDate(), "Event Start Date", driver);
			clickElement(getButtonOK(), "Ok Button", driver);
			clickElement(getButtonEventEndDate(), "Event End Date", driver);
			clickElement(getButtonOK(), "Ok Button", driver);
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
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			dictionary.put("PURCHASE_PASSWORD", PropertyHelper.getENVProperties("UMREX_PURCHASE_PASSWORD"));
			sendKeys(getTextboxPurchasePasswordPostpaid(), dictionary.get("PURCHASE_PASSWORD"), "Password", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonYES(), "Yes Button", driver);
			
			while (verifyElementIsDisplayed(getRetrybutton(), "Retry button",driver)) {
				 clickElement(getRetrybutton(), "Retry Button", driver);
			}
			
			boolean checkFlag = checkForText("", getLabelSuccessMessagePostpaid(), "Thank you for your order", "Success Message", driver);
			
			if (checkFlag == true) {
				ApplicationUtil.insertAccountIntoDB("POSTPAID","UMREX",registrationType);
				ApplicationUtil.updateSIMStatusInSIMDetails(MainUtil.dictionary.get("SIM_NO"));
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

	
	public boolean doPostpaidRegistration_multiline(String registrationType, String identificationType) {

		boolean methodReturn = false;

		try {

			clickElement(getButtonPostpaid(), "Postpaid Button", driver);
			if (identificationType.equals("MALAYSIAN")) {
				clickElement(getbuttonReadIDPostpaid(), "Read ID Button", driver);
			} else {	
			 clickElement(getButtonScanIDPostpaid(), "Scan ID Button", driver);
			}
			
			RandomDataGenerator.generateCustomerDataUMREX(identificationType);
			
			String[] arrplanname = MainUtil.dictionary.get("PLAN_NAME").split(";");
			System.out.println(arrplanname.length);
			
			String linecount=Integer.toString(arrplanname.length);
			ApplicationUtil.getMSISDNFromSIMTableForMultiline("POSTPAID", MainUtil.dictionary.get("PLAN_NAME"),linecount);
			int j = 1;
			for (int i = 0; i<arrplanname.length; i++)
			{
				dictionary.put("PLAN_NAME"+j, arrplanname[i]);
				j++;
			}
			
			System.out.println(arrplanname.length);
			System.out.println(dictionary.get("PLAN_NAME1"));
			System.out.println(dictionary.get("PLAN_NAME2"));	
			System.out.println(dictionary.get("MSISDN1"));
			System.out.println(dictionary.get("MSISDN2"));
			System.out.println(dictionary.get("SIM_NO1"));
			System.out.println(dictionary.get("SIM_NO2"));
			
			fillInCustomerDetails(identificationType);
					
			clickElement(getButtonAddPrincipalLine(), "Add Pricipal Line Button", driver);
			
			if (dictionary.get("MSISDN1") != null || dictionary.get("MSISDN1") != "NA") {
				
				clickElement(getRadioButtonDealerPool(), "Dealer Pool", driver);
				sendKeys(getTextboxSearchMSISDN(), dictionary.get("MSISDN1").substring(4, dictionary.get("MSISDN1").length()), "Search MSISDN1", "", driver);
			}
			
			clickElement(getButtonSearch(), "Search Button", driver);
			clickElement(getButtonOK(), "OK Button", driver);
			clickElement(getButtonFirstMSISDN(), "Select MSISDN", driver);
			dictionary.put("MSISDN1", getButtonFirstMSISDN().getText());
			System.out.println("MSISDN : "+dictionary.get("MSISDN1"));
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(selectPostpaidPlan(MainUtil.dictionary.get("PLAN_NAME1")), "Select Plan", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getTextboxEmail(), "Continue Email ID", driver);
			sendKeys(getTextboxEmail(), dictionary.get("CUSTOMER_EMAIL"), "Customer Email ID", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			sendKeys(getTextboxSIMNo(), dictionary.get("SIM_NO1"), "SIM", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			
			for (int k = 2; k==arrplanname.length; k++) {
				
			clickElement(getButtonAddNewline(), "Add New Line Button", driver);
			
			int intIndex = MainUtil.dictionary.get("PLAN_NAME"+k).indexOf("Share 20");
			if(intIndex == - 1) {
				clickElement(getButtonAddPrincipalLine(), "Add Pricipal Line Button", driver);
			} else {
				clickElement(getButtonAddmemberline(), "Add Member Line Button", driver);
			}
			
			if (dictionary.get("MSISDN"+k) != null || dictionary.get("MSISDN"+k) != "NA") {
				
				clickElement(getRadioButtonDealerPool(), "Dealer Pool", driver);
				sendKeys(getTextboxSearchMSISDN(), dictionary.get("MSISDN"+k).substring(4, dictionary.get("MSISDN"+k).length()), "Search MSISDN", "", driver);
			}
			
			clickElement(getButtonSearch(), "Search Button", driver);
			clickElement(getButtonOK(), "OK Button", driver);
			clickElement(getButtonFirstMSISDN(), "Select MSISDN", driver);
			dictionary.put("MSISDN"+k, getButtonFirstMSISDN().getText());
			System.out.println("MSISDN : "+dictionary.get("MSISDN"+k));
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(selectPostpaidPlan(MainUtil.dictionary.get("PLAN_NAME"+k)), "Select Plan", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			sendKeys(getTextboxEmail(), dictionary.get("CUSTOMER_EMAIL"), "Customer Email ID", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			sendKeys(getTextboxSIMNo(), dictionary.get("SIM_NO"+k), "SIM", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			}
			
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getSpinnerEventType(), "Event Type", driver);
			clickElement(selectEvenType("Dealer Outlet"), "Dealer Outlet", driver);
			
			clickElement(getButtonEventStartDate(), "Event Start Date", driver);
			clickElement(getButtonOK(), "Ok Button", driver);
			clickElement(getButtonEventEndDate(), "Event End Date", driver);
			clickElement(getButtonOK(), "Ok Button", driver);
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
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			dictionary.put("PURCHASE_PASSWORD", PropertyHelper.getENVProperties("UMREX_PURCHASE_PASSWORD"));
			sendKeys(getTextboxPurchasePasswordPostpaid(), dictionary.get("PURCHASE_PASSWORD"), "Password", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonYES(), "Yes Button", driver);

			boolean checkFlag = checkForText("", getLabelSuccessMessagePostpaid(), "Thank you for your order", "Success Message", driver);
			
			for (int q = 1; q==arrplanname.length; q++) {
				
				dictionary.put("MSISDN", dictionary.get("MSISDN"+q));	
				dictionary.put("PLAN_NAME", dictionary.get("PLAN_NAME"+q));
				dictionary.put("SIM_NO", dictionary.get("SIM_NO"+q));
			
			if (checkFlag == true) {
				ApplicationUtil.insertAccountIntoDB("POSTPAID","UMREX",registrationType);
				ApplicationUtil.updateSIMStatusInSIMDetails(MainUtil.dictionary.get("SIM_NO"));
				methodReturn = true;
				clickElement(getButtonBackToHome(), "Back To Home Button", driver);
			} else {
				clickElement(getButtonOK(), "Ok Button", driver);
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
		return methodReturn;
	}
	
	
	public boolean doPostpaidRegistration_Broadband(String registrationType, String identificationType) {

		boolean methodReturn = false;

		try {

			clickElement(getbuttonBroadband(), "Broadband Button", driver);
			if (identificationType.equals("MALAYSIAN")) {
				clickElement(getbuttonReadIDPostpaid(), "Read ID Button", driver);
			} else {	
			 clickElement(getButtonScanIDPostpaid(), "Scan ID Button", driver);
			}
			
			RandomDataGenerator.generateCustomerDataUMREX(identificationType);
			ApplicationUtil.getMSISDNFromSIMTable("POSTPAID", MainUtil.dictionary.get("PLAN_NAME"));
			
			fillInCustomerDetails(identificationType);
					
			clickElement(getButtonAddPrincipalLine(), "Add Pricipal Line Button", driver);
			
			if (dictionary.get("MSISDN") != null || dictionary.get("MSISDN") != "NA") {
				
				clickElement(getRadioButtonDealerPool(), "Dealer Pool", driver);
				sendKeys(getTextboxSearchMSISDN(), dictionary.get("MSISDN").substring(4, dictionary.get("MSISDN").length()), "Search MSISDN", "", driver);
			}
			
			clickElement(getButtonSearch(), "Search Button", driver);
			clickElement(getButtonOK(), "OK Button", driver);
			clickElement(getButtonFirstMSISDN(), "Select MSISDN", driver);
			dictionary.put("MSISDN", getButtonFirstMSISDN().getText());
			System.out.println("MSISDN : "+dictionary.get("MSISDN"));
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(selectPostpaidPlan("UB USIM Plan - Broadband"), "Select Plan", driver);
			clickElement(getRadioButtonUBUSIM(MainUtil.dictionary.get("PLAN_NAME")), "Select Plan", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			sendKeys(getTextboxEmail(), dictionary.get("CUSTOMER_EMAIL"), "Customer Email ID", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			sendKeys(getTextboxSIMNo(), dictionary.get("SIM_NO"), "SIM", "", driver);
			clickElement(getcheckboxBroadbandDataSIMonly(), "Data SIM Only", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getSpinnerEventType(), "Event Type", driver);
			clickElement(selectEvenType("Dealer Outlet"), "Dealer Outlet", driver);
			
			clickElement(getButtonEventStartDate(), "Event Start Date", driver);
			clickElement(getButtonOK(), "Ok Button", driver);
			clickElement(getButtonEventEndDate(), "Event End Date", driver);
			clickElement(getButtonOK(), "Ok Button", driver);
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
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			dictionary.put("PURCHASE_PASSWORD", PropertyHelper.getENVProperties("UMREX_PURCHASE_PASSWORD"));
			sendKeys(getTextboxPurchasePasswordPostpaid(), dictionary.get("PURCHASE_PASSWORD"), "Password", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			clickElement(getButtonYES(), "Yes Button", driver);

			boolean checkFlag = checkForText("", getLabelSuccessMessagePostpaid(), "Thank you for your order", "Success Message", driver);
			
			if (checkFlag == true) {
				ApplicationUtil.insertAccountIntoDB("POSTPAID","UMREX",registrationType);
				ApplicationUtil.updateSIMStatusInSIMDetails(MainUtil.dictionary.get("SIM_NO"));
				methodReturn = true;
				clickElement(getButtonBackToHome(), "Back To Home Button", driver);
			} else {
				clickElement(getButtonOK(), "Ok Button", driver);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing Broadband registration  :" + e);
		}
		return methodReturn;
	}
	
	public void fillInCustomerDetails(String registrationType) {
		try {

			if (registrationType.equals("MALAYSIAN")) {
				
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
				scrollUDLR(driver, 0, "U");
				sendKeys(gettextboxAddressform(), dictionary.get("CUSTOMER_ADDRESS"), "CUSTOMER ADDRESS", "", driver);
				sendKeys(gettextboxPostcodeform(), dictionary.get("CUSTOMER_POSTCODE"), "CUSTOMER ADDRESS", "", driver);
				sendKeys(gettextboxCityform(), dictionary.get("CUSTOMER_CITY"), "CUSTOMER CITY", "", driver);
				scrollUDLR(driver, 0, "U");
				sendKeys(gettextboxStateform(), dictionary.get("CUSTOMER_STATE"), "CUSTOMER STATE", "", driver);
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
			compareInString(getLabelDDMFCheck().getText(), "PASS", "DDMF Check", driver);
			compareInString(getLabelAgeValidationStatus().getText(), "PASS", "Age Validation", driver);
			compareInString(getLabelInternalBlacklistStatus().getText(), "PASS", "Internal Blacklist", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			
			clickElement(getButtonContinue(), "Continue Button", driver);
			//clickElement(getSpinnerTitle(), "Title Spinner", driver);
			//scrollUDLR(driver, 0, "U");
			//clickElement(getSelectMR(), "Mr", driver);
			scrollUDLR(driver, 0, "U");
			scrollUDLR(driver, 0, "U");
			if (registrationType.equals("NON MALAYSIAN")) {
				sendKeys(getTextboxAddressPostpaid(), dictionary.get("CUSTOMER_ADDRESS"), "Customer Address", "", driver);
				sendKeys(getTextboxPostcodePostpaid(), dictionary.get("CUSTOMER_POSTCODE"), "Customer Postcode", "", driver);
			}
			
			scrollUDLR(driver, 0, "U");
			sendKeys(getTextboxAlternateNumberArea(), dictionary.get("CUSTOMER_NUMBER").substring(0, 4), "Customer Number Area", "", driver);
			sendKeys(getTextboxAlternateNumber(), dictionary.get("CUSTOMER_NUMBER").substring(4, dictionary.get("CUSTOMER_NUMBER").length()), "Customer Number", "", driver);
			clickElement(getButtonContinue(), "Continue Button", driver);
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while filling up customer details  :" + e);
		}
	}

}
