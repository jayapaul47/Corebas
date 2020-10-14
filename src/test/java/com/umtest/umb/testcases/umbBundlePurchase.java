package com.umtest.umb.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.umtest.isd.pagefunction.isdSubscriberInfoFunc;
import com.umtest.mobileapps.pagefunction.MobileAppLoginFuncs;
import com.umtest.mobileapps.pagefunction.MobileAppUtilFuncs;
import com.umtest.selfcare.pagefunction.SelfcareVerificationFuncs;
import com.umtest.testframe.base.DriverFactory;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.listener.ExtentTestNGITestListener;
import com.umtest.umb.pagefunction.UMBLoginLogoutFuncs;
import com.umtest.umb.pagefunction.UMBUSSDFuncs;
import com.umtest.umb.pagefunction.UMBVerificationFuncs;

import io.appium.java_client.android.AndroidDriver;

public class umbBundlePurchase extends DriverFactory {
	private RemoteWebDriver driver;
	UMBLoginLogoutFuncs umbLoginLogout;
	UMBVerificationFuncs umbVerification;
	UMBUSSDFuncs umbUSSDFunc;
	ApplicationUtil appUtil;
	private static Logger logger = LogManager.getLogger(umbBundlePurchase.class);
	

	@BeforeClass
	public void initialiseObj() throws IOException {
		driver = getDriver("chrome");
		umbLoginLogout = new UMBLoginLogoutFuncs(driver);
		umbVerification = new UMBVerificationFuncs(driver);
		umbUSSDFunc = new UMBUSSDFuncs(driver);
	
		
		MainUtil.APPLICATION_NAME = "UMB";
	}
	
	@Test(description = "UMB Bundle Purchase")
	@Parameters({"bundleName","msisdn","planType"})
	public void bundlePurchase(String bundleName, String msisdn, String planType) {
		
		
		try {
			String mainBalance = null;
			MainUtil.dictionary.put("MSISDN", msisdn);
			MainUtil.dictionary.put("OPERATION_TYPE", "BUNDLE");
			
			/*Purchase Bundle*/
			ExtentTestNGITestListener.createNode("GET ACCOUNT BALANCE");
			if(planType.equalsIgnoreCase("PREPAID")) {
				mainBalance = umbVerification.getBalance(planType, "BalanceCheck");
				MainUtil.dictionary.put("CURRENT_BALANCE", mainBalance);
				String[] arrBundle = bundleName.split(":");
	    		MainUtil.dictionary.put("CATEGORY", arrBundle[0]);
	    		MainUtil.dictionary.put("BUNDLE_NAME", arrBundle[1]);
			}else {
				MainUtil.dictionary.put("CATEGORY", bundleName);
	    		MainUtil.dictionary.put("BUNDLE_NAME", bundleName);
			}
		
			
			ExtentTestNGITestListener.createNode("UMB PURCHASE BUNDLE");
    		Boolean flag = umbVerification.bundlePurchaseUMB(planType);
    		
    		//Boolean flag = true;
    		
    		if(flag) {
    		ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN")); 
    		/*Verify UMB*/
    		ExtentTestNGITestListener.createNode("UMB Bundle Verification");
			umbVerification.umbVerification(planType,MainUtil.dictionary.get("OPERATION_TYPE"));
			
			/*Verify Mobile App*/
		/*	ExtentTestNGITestListener.createNode("Mobile App Verification");
			driver = getDriver("MOBILEAPP", "Android");
			MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
			mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));

			MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
			mobileAppUtilFuncs.verifyMobileApp(MainUtil.dictionary.get("OPERATION_TYPE")+"_"+planType);
			
			if(planType.equalsIgnoreCase("Prepaid")) {
				Verify Selfcare
				ExtentTestNGITestListener.createNode("Selfcare Balance Verification");
				driver = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driver);
				selfcareVerify.verifySelfcare(planType);
				
				Verify ISD
				ExtentTestNGITestListener.createNode("ISD Subscriber Info Verification");
				driver = getDriver("chrome");
				isdSubscriberInfoFunc isdVerification = new isdSubscriberInfoFunc(driver);
				isdVerification.verifySubscriberInfo();
				}*/
			
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured during bundle purchase  :" + e);
		}
	}
}


