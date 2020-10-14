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
import com.umtest.umrex.pagefunction.UMREXPostpaidRegistrationFuncs;

public class UMREXPostpaidRegistration extends DriverFactory {
	private RemoteWebDriver driver;
	private RemoteWebDriver driverChrome;

	UMREXLoginLogoutFuncs loginFuncs;
	UMREXPostpaidRegistrationFuncs postpaidFuncs;

	ExtentTestNGITestListener ex;

	private static Logger logger = LogManager.getLogger(UMREXPostpaidRegistration.class);

	@BeforeClass
	public void initialiseObj() throws IOException {

		driver = getDriver("UMREX", "Android");
		loginFuncs = new UMREXLoginLogoutFuncs(driver);
		postpaidFuncs = new UMREXPostpaidRegistrationFuncs(driver);

		MainUtil.APPLICATION_NAME = "UMREX";
	}

	@Test(description = "UMREX Postpaid Registration")
	@Parameters({"planName"})
	public void UMREXRegistrationPostpaid(String planName) {

		try {

			ExtentTestNGITestListener.createNode("UMREX Postpaid Registration");
			MainUtil.dictionary.put("PLAN_NAME", planName);
			MainUtil.dictionary.put("REGISTRATION_TYPE", "PLAN");
			
			if (System.getProperty("simType") == null || System.getProperty("simType").equalsIgnoreCase("PHYSICAL")) {
				MainUtil.dictionary.put("SIM_TYPE", "PHYSICAL");
			} else {
				MainUtil.dictionary.put("SIM_TYPE", "DUMMY");
			}
			
			loginFuncs.loginUMREX();
			boolean statusFlag = postpaidFuncs.doPostpaidRegistration(MainUtil.dictionary.get("REGISTRATION_TYPE"),"MALAYSIAN");
			loginFuncs.logoutUMREX();
			Thread.sleep(60000);
			if (statusFlag == true) {
				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));

				ExtentTestNGITestListener.createNode("UMB Verification");
				driverChrome = getDriver("chrome");
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driverChrome);
				umbVerify.umbVerification("POSTPAID","PLAN");


				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driverChrome = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driverChrome);
				selfcareVerify.verifySelfcare("POSTPAID");


				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
				mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));

				MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
				mobileAppUtilFuncs.verifyMobileApp(MainUtil.dictionary.get("REGISTRATION_TYPE")+"_POSTPAID");
			}			


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
	}
	
	@Test(description = "UMREX Postpaid Registration MultiLine")
	@Parameters({"planName"})
	public void UMREXRegistrationPostpaid_Multiline(String planName) {

		try {

			ExtentTestNGITestListener.createNode("UMREX Postpaid Registration");
			MainUtil.dictionary.put("PLAN_NAME", planName);
			MainUtil.dictionary.put("REGISTRATION_TYPE", "PLAN");
			
			if (System.getProperty("simType") == null || System.getProperty("simType").equalsIgnoreCase("PHYSICAL")) {
				MainUtil.dictionary.put("SIM_TYPE", "PHYSICAL");
			} else {
				MainUtil.dictionary.put("SIM_TYPE", "DUMMY");
			}
			
			loginFuncs.loginUMREX();
			boolean statusFlag = postpaidFuncs.doPostpaidRegistration_multiline(MainUtil.dictionary.get("REGISTRATION_TYPE"),"MALAYSIAN");
			loginFuncs.logoutUMREX();
			
			String[] arrplan_name = MainUtil.dictionary.get("PLAN_NAME").split(";");
			System.out.println(arrplan_name.length);
			
			for (int q = 1; q==arrplan_name.length; q++) {
				
				MainUtil.dictionary.put("MSISDN", MainUtil.dictionary.get("MSISDN"+q));	
				MainUtil.dictionary.put("PLAN_NAME", MainUtil.dictionary.get("PLAN_NAME"+q));
				MainUtil.dictionary.put("SIM_NO", MainUtil.dictionary.get("SIM_NO"+q));
					
			if (statusFlag == true) {

				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));

				ExtentTestNGITestListener.createNode("UMB Verification");
				driverChrome = getDriver("chrome");
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driverChrome);
				umbVerify.umbVerification("POSTPAID","PLAN");


				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driverChrome = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driverChrome);
				selfcareVerify.verifySelfcare("POSTPAID");


				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
				mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));

				MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
				mobileAppUtilFuncs.verifyMobileApp(MainUtil.dictionary.get("REGISTRATION_TYPE")+"_POSTPAID");
			}			
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
	}
	
	@Test(description = "UMREX Postpaid Broadband Registration")
	@Parameters({"planName"})
	public void UMREXRegistrationPostpaid_Broadband(String planName) {

		try {

			ExtentTestNGITestListener.createNode("UMREX Postpaid Broadband Registration");
			MainUtil.dictionary.put("PLAN_NAME", planName);
			MainUtil.dictionary.put("REGISTRATION_TYPE", "PLAN");
			
			if (System.getProperty("simType") == null || System.getProperty("simType").equalsIgnoreCase("PHYSICAL")) {
				MainUtil.dictionary.put("SIM_TYPE", "PHYSICAL");
			} else {
				MainUtil.dictionary.put("SIM_TYPE", "DUMMY");
			}
			
			loginFuncs.loginUMREX();
			boolean statusFlag = postpaidFuncs.doPostpaidRegistration_Broadband(MainUtil.dictionary.get("REGISTRATION_TYPE"),"NON MALAYSIAN");
			loginFuncs.logoutUMREX();
					
			if (statusFlag == true) {

				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));

				ExtentTestNGITestListener.createNode("UMB Verification");
				driverChrome = getDriver("chrome");
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driverChrome);
				umbVerify.umbVerification("POSTPAID","PLAN");


				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driverChrome = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driverChrome);
				selfcareVerify.verifySelfcare("POSTPAID");


				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
				mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));

				MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
				mobileAppUtilFuncs.verifyMobileApp(MainUtil.dictionary.get("REGISTRATION_TYPE")+"_POSTPAID");
			}			


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
	}
	
}
