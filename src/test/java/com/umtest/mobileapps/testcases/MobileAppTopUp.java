package com.umtest.mobileapps.testcases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.umtest.mobileapps.pagefunction.MobileAppLoginFuncs;
import com.umtest.mobileapps.pagefunction.MobileAppPrepaidTopupFuncs;
import com.umtest.mobileapps.pagefunction.MobileAppUtilFuncs;
import com.umtest.selfcare.pagefunction.SelfcareVerificationFuncs;
import com.umtest.testframe.base.DriverFactory;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.listener.ExtentTestNGITestListener;
import com.umtest.umb.pagefunction.UMBVerificationFuncs;

public class MobileAppTopUp extends DriverFactory {
	private RemoteWebDriver driver;
	private RemoteWebDriver driverChrome;

	MobileAppLoginFuncs loginFuncs;
	MobileAppUtilFuncs utilFuncs;
	MobileAppPrepaidTopupFuncs topupFuncs;
	ExtentTestNGITestListener ex;

	private static Logger logger = LogManager.getLogger(MobileAppTopUp.class);

	@BeforeClass
	public void initialiseObj() throws IOException {
		driver = getDriver("MOBILEAPP", "Android");
		loginFuncs = new MobileAppLoginFuncs(driver);
		utilFuncs = new MobileAppUtilFuncs(driver);
		topupFuncs = new MobileAppPrepaidTopupFuncs(driver);
		MainUtil.APPLICATION_NAME = "MOBILEAPP";
	}

	@Test(description = "Mobile App Topup")
	@Parameters({"planName","topupType","topupAmount"})
	public void MobileAppTopup(String planName, String topupType, String topupAmount) {
		
		try {
			
			ExtentTestNGITestListener.createNode("Do Mobile App Prepaid Top");
					
			MainUtil.dictionary.put("PLAN_NAME", planName);
			MainUtil.dictionary.put("TOPUP_TYPE", topupType);
			MainUtil.dictionary.put("TOPUP_AMOUNT", topupAmount);
			
			ApplicationUtil.getPrepaidAccount(planName);
			
			loginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));
			boolean status = topupFuncs.doTopup(MainUtil.dictionary.get("TOPUP_TYPE"), MainUtil.dictionary.get("TOPUP_AMOUNT"));
			
			if (status) {
				
				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));
				
				ExtentTestNGITestListener.createNode("Mobile App Verification");
				utilFuncs.verifyMobileApp("TOPUP_ONLY_PREPAID");
				
				
				ExtentTestNGITestListener.createNode("UMB Verification");
				driverChrome = getDriver("chrome"); 
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driverChrome);
				umbVerify.umbVerification("PREPAID","PLAN");


				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driverChrome = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driverChrome);
				selfcareVerify.verifySelfcare("PREPAID");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
	}
}
