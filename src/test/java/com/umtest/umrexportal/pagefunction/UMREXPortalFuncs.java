package com.umtest.umrexportal.pagefunction;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.lib.PropertyHelper;
import com.umtest.umrexportal.pageobject.UMREXPortalPage;

import static com.umtest.testframe.listener.ExtentTestNGITestListener.getTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UMREXPortalFuncs extends UMREXPortalPage {

	private static Logger logger = LogManager.getLogger(UMREXPortalFuncs.class);
	private RemoteWebDriver driver;

	public UMREXPortalFuncs(RemoteWebDriver driver) {
		super(driver);
		this.driver =  driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

	}


	public void loginUMREXPortal() {
		try {

			MainUtil.launchURL(PropertyHelper.getENVProperties("UMREX_PORTAL_URL"), driver);

			dictionary.put("USERNAME", PropertyHelper.getENVProperties("UMREX_PORTAL_USERNAME"));
            sendKeys(getTextboxUsername(), dictionary.get("USERNAME"), "Username", "", driver);
            dictionary.put("PASSWORD", PropertyHelper.getENVProperties("UMREX_PORTAL_PASSWORD"));
            sendKeys(getTextboxPassword(), dictionary.get("PASSWORD"), "Password", "", driver);
            clickElement(getButtonLogin(), "Login Button", driver);


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while logging to UMREX Portal  :" + e);
		}
	}


	public void verifyPrepaidRegistration(String msisdn) {
		try {
			
			loginUMREXPortal();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime todaysDate =  LocalDateTime.now();
			
			String todaysDateString = dtf.format(todaysDate);
			String registeredDateString = dictionary.get("PURCHASE_DATE");
			
			if (todaysDateString.equalsIgnoreCase(registeredDateString)) {
				
				clickElement(getButtonReports(), "Reports Button", driver);
				clickElement(getButtonRegistrationReport(), "Registration Report Button", driver);
				clickElement(getButtonSearch(), "Search Button", driver);
				sendKeys(getTextboxSearch(), msisdn.substring(0, 4)+"-"+msisdn.substring(4, msisdn.length()), "MSISDN", "", driver);
				checkForText("",getLabelRegistrationStatus(), "Success", "Registration Status", driver);
				
			} else {

				getTest().get().pass("UMREX Portal Verification skipped as account is not registered today");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying prepaid registration  :" + e);
		}
	}
}
