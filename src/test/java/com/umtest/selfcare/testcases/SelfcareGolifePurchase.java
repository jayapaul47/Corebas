package com.umtest.selfcare.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.umtest.mobileapps.pagefunction.MobileAppLoginFuncs;
import com.umtest.mobileapps.pagefunction.MobileAppUtilFuncs;
import com.umtest.selfcare.pagefunction.SelfcareGolifePurchaseFuncs;
import com.umtest.selfcare.pagefunction.SelfcareLoginLogoutFuncs;
import com.umtest.testframe.base.DriverFactory;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.listener.ExtentTestNGITestListener;

public class SelfcareGolifePurchase extends DriverFactory {
	private RemoteWebDriver driver;
	private RemoteWebDriver driverChrome;
	
	
	SelfcareLoginLogoutFuncs loginFuncs;
	SelfcareGolifePurchaseFuncs Selfcare_Funcs;
	MobileAppUtilFuncs utilFuncs;
	ExtentTestNGITestListener ex;

	private static Logger logger = LogManager.getLogger(SelfcareGolifePurchase.class);

	@BeforeClass
	public void initialiseObj() throws IOException {
		driver = getDriver("chrome");
		loginFuncs = new SelfcareLoginLogoutFuncs(driver);
		Selfcare_Funcs = new SelfcareGolifePurchaseFuncs(driver);
		
		MainUtil.APPLICATION_NAME = "SELFCARE";
	}

	@Test(description = "Selfcare Postpaid Purchase Golife insurance")
	@Parameters({"msisdn","Golife"})
	public void SelfcarePurchaseGolife(String msisdn,String Golife) {
		boolean methodReturn = false;
		try {
			
			ExtentTestNGITestListener.createNode("Purchase Golife insurance from Selfcare");
			MainUtil.dictionary.put("Golife", Golife);
			MainUtil.dictionary.put("msisdn", msisdn);
			
			loginFuncs.loginSelfcare(MainUtil.dictionary.get("msisdn"));
			boolean statusFlag = Selfcare_Funcs.PurchaseGolife(MainUtil.dictionary.get("Golife"));
			loginFuncs.logoutSelfcare();
			
			if (statusFlag == true) {
				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
				mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("msisdn"));

				MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
				mobileAppUtilFuncs.verifyMobileAppGolifeInsurance(MainUtil.dictionary.get("Golife"));
				
			}
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured while doing PayBill :" + e);
		}
	}
	
	
	@Test(description = "Selfcare Prepaid Purchase Golife insurance")
	@Parameters({"Golife","msisdn","Amount","PaymentType","Cardnumber"})
	public void SelfcarePurchaseGolife_Prepaid(String Golife,String msisdn,String Amount,String PaymentType,String Cardnumber) {
		boolean methodReturn = false;
		try {
			
			ExtentTestNGITestListener.createNode("Purchase Golife insurance from Selfcare");
			MainUtil.dictionary.put("Golife", Golife);
			MainUtil.dictionary.put("msisdn", msisdn);
			
			loginFuncs.loginSelfcare(MainUtil.dictionary.get("msisdn"));
			boolean statusFlag = Selfcare_Funcs.PurchaseGolife_Prepaid(Golife,Amount,PaymentType,Cardnumber);
			loginFuncs.logoutSelfcare();
			
			if (statusFlag == true) {
				ExtentTestNGITestListener.createNode("Mobile App Verification");
				driver = getDriver("MOBILEAPP", "Android");
				MobileAppLoginFuncs mobileAppLoginFuncs = new MobileAppLoginFuncs(driver);
				mobileAppLoginFuncs.loginMobileApp(MainUtil.dictionary.get("msisdn"));

				MobileAppUtilFuncs mobileAppUtilFuncs = new MobileAppUtilFuncs(driver);
				mobileAppUtilFuncs.verifyMobileAppGolifeInsurance(MainUtil.dictionary.get("Golife"));
				
			}
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception occured while doing PayBill :" + e);
		}
	}
}
