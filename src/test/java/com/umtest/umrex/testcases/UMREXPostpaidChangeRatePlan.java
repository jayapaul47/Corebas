package com.umtest.umrex.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.umtest.testframe.base.DriverFactory;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.listener.ExtentTestNGITestListener;
import com.umtest.umrex.pagefunction.UMREXLoginLogoutFuncs;
import com.umtest.umrex.pagefunction.UMREXPostpaidChangeRatePlanFuncs;
import com.umtest.umrex.pagefunction.UMREXPostpaidRegistrationFuncs;

public class UMREXPostpaidChangeRatePlan extends DriverFactory {
	private RemoteWebDriver driver;
	private RemoteWebDriver driverChrome;

	UMREXLoginLogoutFuncs loginFuncs;
	UMREXPostpaidRegistrationFuncs postpaidFuncs;
	UMREXPostpaidChangeRatePlanFuncs postpaidcrpfuncs;
	
	
	ExtentTestNGITestListener ex;

	private static Logger logger = LogManager.getLogger(UMREXPostpaidChangeRatePlan.class);

	@BeforeClass
	public void initialiseObj() throws IOException {

		driver = getDriver("UMREX", "Android");
		loginFuncs = new UMREXLoginLogoutFuncs(driver);
		postpaidFuncs = new UMREXPostpaidRegistrationFuncs(driver);
		postpaidcrpfuncs = new UMREXPostpaidChangeRatePlanFuncs(driver);
		
		MainUtil.APPLICATION_NAME = "UMREX";
	}
	
	@Test(description = "UMREX Postpaid Registration")
	@Parameters({"NewplanName","msisdn","ChangeRateplantype"})
	public void UMREXRegistrationPostpaid(String NewplanName,String msisdn,String ChangeRateplantype) {

		try {
			ExtentTestNGITestListener.createNode("UMREX Postpaid Registration");
			MainUtil.dictionary.put("NEWPLAN_NAME", NewplanName);
			MainUtil.dictionary.put("msisn", msisdn);
			MainUtil.dictionary.put("ChangeRateplantype", ChangeRateplantype);
			MainUtil.dictionary.put("REGISTRATION_TYPE", "PLAN");
			
			if (System.getProperty("simType") == null || System.getProperty("simType").equalsIgnoreCase("PHYSICAL")) {
				MainUtil.dictionary.put("SIM_TYPE", "PHYSICAL");
			} else {
				MainUtil.dictionary.put("SIM_TYPE", "DUMMY");
			}
			
			loginFuncs.loginUMREX();
			boolean statusFlag = postpaidcrpfuncs.doPostpaidChangePlan(MainUtil.dictionary.get("REGISTRATION_TYPE"),"MALAYSIAN");
			loginFuncs.logoutUMREX();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing Postpaid change Rate Plan  :" + e);
		}
	}
}
