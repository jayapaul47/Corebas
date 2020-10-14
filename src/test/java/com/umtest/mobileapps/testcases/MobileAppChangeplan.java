package com.umtest.mobileapps.testcases;

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

public class MobileAppChangeplan extends DriverFactory {
	private RemoteWebDriver driver;
	private RemoteWebDriver driverChrome;

	MobileAppLoginFuncs loginFuncs;
	MobileAppUtilFuncs utilFuncs;
	ExtentTestNGITestListener ex;

	private static Logger logger = LogManager.getLogger(MobileAppChangeplan.class);

	@BeforeClass
	public void initialiseObj() throws IOException {
		driver = getDriver("MOBILEAPP", "Android");
		loginFuncs = new MobileAppLoginFuncs(driver);
		utilFuncs = new MobileAppUtilFuncs(driver);
		MainUtil.APPLICATION_NAME = "MOBILEAPP";
	}

	@Test(description = "Mobile App Changeplan")
	@Parameters({"NewplanName","msisdn"})
	public void MobileAppChangeRatePlan(String NewplanName, String msisdn) {
		
		try {
			
			ExtentTestNGITestListener.createNode("Do Mobile App Prepaid Top");
					
			MainUtil.dictionary.put("PLAN_NAME", NewplanName);
			MainUtil.dictionary.put("msisdn", msisdn);
			
			loginFuncs.loginMobileApp(MainUtil.dictionary.get("msisdn"));
			boolean status = utilFuncs.doChangerateplan(MainUtil.dictionary.get("PLAN_NAME"));
			
			if (status == true) {
				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("msisdn"));

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
			logger.error("Exception occured while doing postpaid ChangeRateplan  :" + e);
		}
	}
}
		
