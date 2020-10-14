package com.umtest.mobileapps.testcases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.umtest.mobileapps.pagefunction.MobileAppBundlePurchaseFuncs;
import com.umtest.mobileapps.pagefunction.MobileAppLoginFuncs;
import com.umtest.mobileapps.pagefunction.MobileAppUtilFuncs;
import com.umtest.selfcare.pagefunction.SelfcareVerificationFuncs;
import com.umtest.testframe.base.DriverFactory;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.listener.ExtentTestNGITestListener;
import com.umtest.umb.pagefunction.UMBVerificationFuncs;

public class MobileAppBundlePurchase extends DriverFactory {
	private RemoteWebDriver driver;
	private RemoteWebDriver driverChrome;

	MobileAppLoginFuncs loginFuncs;
	MobileAppUtilFuncs utilFuncs;
	MobileAppBundlePurchaseFuncs bundlePurchaseFuncs;
	ExtentTestNGITestListener ex;

	private static Logger logger = LogManager.getLogger(MobileAppBundlePurchase.class);

	@BeforeClass
	public void initialiseObj() throws IOException {
		driver = getDriver("MOBILEAPP", "Android");
		System.out.println(driver.findElements(By.xpath("//asas")).size());
		loginFuncs = new MobileAppLoginFuncs(driver);
		utilFuncs = new MobileAppUtilFuncs(driver);
		bundlePurchaseFuncs = new MobileAppBundlePurchaseFuncs(driver);
		MainUtil.APPLICATION_NAME = "MOBILEAPP";
	}

	@Test(description = "Mobile App Bundle Purchase")
	@Parameters({"msisdn","bundleName","accountType"})
	public void MobileAppPurchaseBundle(String msisdn, String bundleName, String accountType) {
		
		try {
			
			ExtentTestNGITestListener.createNode("Do Mobile App Bundle Purchase");
			
			MainUtil.dictionary.put("MSISDN", msisdn);
			MainUtil.dictionary.put("BUNDLE_NAME", bundleName);
			MainUtil.dictionary.put("ACCOUNT_TYPE", accountType);
			
			loginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));
			boolean status = bundlePurchaseFuncs.doBundlePurchase(MainUtil.dictionary.get("BUNDLE_NAME"));
			
			if (status) {
				
				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));
				
				ExtentTestNGITestListener.createNode("Mobile App Verification");
				utilFuncs.verifyMobileApp("BUNDLE_PREPAID");
				
				
				ExtentTestNGITestListener.createNode("UMB Verification");
				driverChrome = getDriver("chrome"); 
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driverChrome);
				umbVerify.umbVerification("PREPAID","BUNDLE");


				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driverChrome = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driverChrome);
				selfcareVerify.verifySelfcare("PREPAID");
				
				switch("level") {
				case "yellow":
					System.out.println("");
				case "green":
				case "blue":
				
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing prepaid registration  :" + e);
		}
	}
	
	
}
