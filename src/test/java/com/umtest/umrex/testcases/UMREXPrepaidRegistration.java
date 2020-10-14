package com.umtest.umrex.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.umtest.mobileapps.pagefunction.MobileAppLoginFuncs;
import com.umtest.mobileapps.pagefunction.MobileAppUtilFuncs;
import com.umtest.selfcare.pagefunction.SelfcareVerificationFuncs;
import com.umtest.testframe.base.DriverFactory;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.listener.ExtentTestNGITestListener;
import com.umtest.umb.pagefunction.UMBVerificationFuncs;
import com.umtest.umrex.pagefunction.UMREXLoginLogoutFuncs;
import com.umtest.umrex.pagefunction.UMREXPrepaidRegistrationFuncs;
import com.umtest.umrexportal.pagefunction.UMREXPortalFuncs;

public class UMREXPrepaidRegistration extends DriverFactory {
	private RemoteWebDriver driver;
	private RemoteWebDriver driverChrome;

	UMREXLoginLogoutFuncs loginFuncs;
	UMREXPrepaidRegistrationFuncs prepaidFuncs;

	ExtentTestNGITestListener ex;

	private static Logger logger = LogManager.getLogger(UMREXPrepaidRegistration.class);

	@BeforeClass
	public void initialiseObj() throws IOException {

		driver = getDriver("UMREX", "Android");
		loginFuncs = new UMREXLoginLogoutFuncs(driver);
		prepaidFuncs = new UMREXPrepaidRegistrationFuncs(driver);

		MainUtil.APPLICATION_NAME = "UMREX";
	}

	@Test(description = "UMREX Prepaid Registration")
	@Parameters({"planName"})
	public void UMREXRegistrationPrepaid(String planName) {

		try {

			ExtentTestNGITestListener.createNode("UMREX Prepaid Registration");
			MainUtil.dictionary.put("PLAN_NAME", planName);
			MainUtil.dictionary.put("REGISTRATION_TYPE", "PLAN");

			if (System.getProperty("simType") == null || System.getProperty("simType").equalsIgnoreCase("PHYSICAL")) {
				MainUtil.dictionary.put("SIM_TYPE", "PHYSICAL");
			} else {
				MainUtil.dictionary.put("SIM_TYPE", "DUMMY");
			}


			loginFuncs.loginUMREX();
			boolean statusFlag = prepaidFuncs.doPrepaidRegistration(MainUtil.dictionary.get("REGISTRATION_TYPE"),"NON MALAYSIAN");
			loginFuncs.logoutUMREX();
			
			if (statusFlag == true) {

				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));

				
				ExtentTestNGITestListener.createNode("UMREX Portal Verfication");
				driverChrome = getDriver("chrome");
				UMREXPortalFuncs umrexPortalVerify = new UMREXPortalFuncs(driverChrome);
				umrexPortalVerify.verifyPrepaidRegistration(MainUtil.dictionary.get("MSISDN"));
				

				ExtentTestNGITestListener.createNode("UMB Verification");
				driverChrome = getDriver("chrome");
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driverChrome);
				umbVerify.umbVerification("PREPAID","PLAN");


				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driverChrome = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driverChrome);
				selfcareVerify.verifySelfcare("PREPAID");


				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
				mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));

				MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
				mobileAppUtilFuncs.verifyMobileApp(MainUtil.dictionary.get("REGISTRATION_TYPE")+"_PREPAID");
			}			


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
	}



	@Test(description = "UMREX Prepaid Registration And Bundle Purchase")
	@Parameters({"planName","bundleName","topupAmount"})
	public void UMREXRegistrationPrepaidBundle(String planName, String bundleName, String topupAmount) {

		try {

			ExtentTestNGITestListener.createNode("UMREX Prepaid Registration And Bundle Purchase");
			MainUtil.dictionary.put("PLAN_NAME", planName);
			MainUtil.dictionary.put("BUNDLE_NAME", bundleName);
			MainUtil.dictionary.put("TOPUP_AMOUNT", topupAmount);
			MainUtil.dictionary.put("REGISTRATION_TYPE", "BUNDLE");

			if (System.getProperty("simType") == null || System.getProperty("simType").equalsIgnoreCase("PHYSICAL")) {
				MainUtil.dictionary.put("SIM_TYPE", "PHYSICAL");
			} else {
				MainUtil.dictionary.put("SIM_TYPE", "DUMMY");
			}

			loginFuncs.loginUMREX();
			boolean statusFlag = prepaidFuncs.doPrepaidRegistration(MainUtil.dictionary.get("REGISTRATION_TYPE"),"NON MALAYSIAN");
			loginFuncs.logoutUMREX();


			if (statusFlag == true) {

				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));
				
				
				ExtentTestNGITestListener.createNode("UMREX Portal Verfication");
				driverChrome = getDriver("chrome");
				UMREXPortalFuncs umrexPortalVerify = new UMREXPortalFuncs(driverChrome);
				umrexPortalVerify.verifyPrepaidRegistration(MainUtil.dictionary.get("MSISDN"));
				

				ExtentTestNGITestListener.createNode("UMB Verification");
				driverChrome = getDriver("chrome");
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driverChrome);
				umbVerify.umbVerification("PREPAID","BUNDLE");


				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driverChrome = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driverChrome);
				selfcareVerify.verifySelfcare("PREPAID");


				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
				mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));

				MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
				mobileAppUtilFuncs.verifyMobileApp(MainUtil.dictionary.get("REGISTRATION_TYPE")+"_PREPAID");
			}			


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
	}



	@Test(description = "UMREX Prepaid Registration And Topup")
	@Parameters({"planName","topupAmount"})
	public void UMREXRegistrationPrepaidTopup(String planName, String topupAmount) {

		try {

			ExtentTestNGITestListener.createNode("UMREX Prepaid Registration And Topup");
			MainUtil.dictionary.put("PLAN_NAME", planName);
			MainUtil.dictionary.put("TOPUP_AMOUNT", topupAmount);
			MainUtil.dictionary.put("REGISTRATION_TYPE", "TOPUP");

			if (System.getProperty("simType") == null || System.getProperty("simType").equalsIgnoreCase("PHYSICAL")) {
				MainUtil.dictionary.put("SIM_TYPE", "PHYSICAL");
			} else {
				MainUtil.dictionary.put("SIM_TYPE", "DUMMY");
			}

			loginFuncs.loginUMREX();
			boolean statusFlag = prepaidFuncs.doPrepaidRegistration(MainUtil.dictionary.get("REGISTRATION_TYPE"),"NON MALAYSIAN");
			loginFuncs.logoutUMREX();


			if (statusFlag == true) {

				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));
				
				
				ExtentTestNGITestListener.createNode("UMREX Portal Verfication");
				driverChrome = getDriver("chrome");
				UMREXPortalFuncs umrexPortalVerify = new UMREXPortalFuncs(driverChrome);
				umrexPortalVerify.verifyPrepaidRegistration(MainUtil.dictionary.get("MSISDN"));
				

				ExtentTestNGITestListener.createNode("UMB Verification");
				driverChrome = getDriver("chrome");
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driverChrome);
				umbVerify.umbVerification("PREPAID","PLAN");


				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driverChrome = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driverChrome);
				selfcareVerify.verifySelfcare("PREPAID");


				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
				mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));

				MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
				mobileAppUtilFuncs.verifyMobileApp(MainUtil.dictionary.get("REGISTRATION_TYPE")+"_PREPAID");
			}			


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
	}
}
