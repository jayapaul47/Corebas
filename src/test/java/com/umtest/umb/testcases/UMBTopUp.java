package com.umtest.umb.testcases;

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
import com.umtest.mobileapps.testcases.MobileAppTopUp;
import com.umtest.selfcare.pagefunction.SelfcareVerificationFuncs;
import com.umtest.testframe.base.DriverFactory;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.listener.ExtentTestNGITestListener;
import com.umtest.umb.pagefunction.UMBLoginLogoutFuncs;
import com.umtest.umb.pagefunction.UMBVerificationFuncs;

public class UMBTopUp extends DriverFactory {
	private RemoteWebDriver driver;
	UMBLoginLogoutFuncs umbLoginLogout;
	UMBVerificationFuncs umbVerification;
	SelfcareVerificationFuncs selfcareVerify;
	MobileAppLoginFuncs mobileAppLoginFuncs;

	private static Logger logger = LogManager.getLogger(UMBTopUp.class);

	@BeforeClass
	public void initialiseObj() throws IOException {
		driver = getDriver("chrome");
		umbLoginLogout = new UMBLoginLogoutFuncs(driver);
		umbVerification = new UMBVerificationFuncs(driver);
		MainUtil.APPLICATION_NAME = "UMB";
	}

	@Test(description = "UMB TOP-UP SELF/TOP-UP FOR FRIEND")
	@Parameters({"planName","category","Receiver_msisdn","topupAmount"})
	public void TopUpUMB(String planName,String category,String Receiver_msisdn, String topupAmount) {
		
		try {
			String mainBalance = null;
			String planType = "Prepaid";
		
					
			MainUtil.dictionary.put("PLAN_NAME", planName);
			MainUtil.dictionary.put("CATEGORY", category);
			MainUtil.dictionary.put("TOPUP_AMOUNT", topupAmount);
			
			if(category.equalsIgnoreCase("TOP-UP FOR FRIEND")) {
				MainUtil.dictionary.put("MSISDN", Receiver_msisdn);
				/*Get main balance and Credit Balance*/
				ExtentTestNGITestListener.createNode("UMB TOP-UP FOR FRIEND: GET MAIN BALANCE");
				mainBalance = umbVerification.getBalance(planType, "BalanceCheck");
				MainUtil.dictionary.put("CURRENT_MAIN_BALANCE", mainBalance);
				ApplicationUtil.getPrepaidAccount(planName);
				MainUtil.dictionary.put("RECEIVER_MSISDN", Receiver_msisdn);
			}else {
				/*Get main balance and Credit Balance*/
				ApplicationUtil.getPrepaidAccount(planName);
				ExtentTestNGITestListener.createNode("UMB TOP-UP SELF: GET MAIN BALANCE");
				mainBalance = umbVerification.getBalance(planType, "BalanceCheck");
				MainUtil.dictionary.put("CURRENT_MAIN_BALANCE", mainBalance);
			}
			
			/*Perform Top-up*/
			ExtentTestNGITestListener.createNode("DO " +category+" via UMB");
			Boolean flag = umbVerification.performTopUp(planType,category);
			
			
			if (flag) {
				
				ApplicationUtil.getAccountDetails(MainUtil.dictionary.get("MSISDN"));
				
				ExtentTestNGITestListener.createNode("UMB Verification");
				driver = getDriver("chrome"); 
				UMBVerificationFuncs umbVerify = new UMBVerificationFuncs(driver);
				umbVerify.umbVerification("PREPAID","");

				ExtentTestNGITestListener.createNode("Selfcare Verification");
				driver = getDriver("chrome");
				SelfcareVerificationFuncs selfcareVerify = new SelfcareVerificationFuncs(driver);
				selfcareVerify.verifySelfcare("PREPAID");
				
				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppUtilFuncs utilFuncs = new MobileAppUtilFuncs(driver);
				MobileAppLoginFuncs loginFuncs = new MobileAppLoginFuncs(driver);
				loginFuncs.loginMobileApp(MainUtil.dictionary.get("MSISDN"));
				utilFuncs.verifyBalanceAndPlanName();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing UMB Top-up  :" + e);
		}
	}
}
