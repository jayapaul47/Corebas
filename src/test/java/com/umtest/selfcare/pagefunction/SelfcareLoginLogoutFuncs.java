package com.umtest.selfcare.pagefunction;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.selfcare.pageobject.SelfcareLoginLogoutPage;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.lib.PropertyHelper;
import java.time.Duration;

public class SelfcareLoginLogoutFuncs extends SelfcareLoginLogoutPage {

	private static Logger logger = LogManager.getLogger(SelfcareLoginLogoutFuncs.class);
	private RemoteWebDriver driver;

	public SelfcareLoginLogoutFuncs(RemoteWebDriver driver) {
		super(driver);
		this.driver =  driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

	}


	public void loginSelfcare(String msisdn) {
		try {
			
			MainUtil.launchURL(PropertyHelper.getENVProperties("SELFCARE_URL"), driver);
			String pin = ApplicationUtil.getSelfcareLoginPin(msisdn);
			
			if (pin == null) {
				clickElement(getButtonRetrievePIN(), "PIN Retrieve Button", driver);
				sendKeys(getTextboxMSISDN(), msisdn, "MSISDN", "", driver);
				clickElement(getButtonSubmit(), "Submit Button", driver);
				clickElement(getButtonClose(), "Close Button", driver);
				pin = ApplicationUtil.getSelfcareLoginPin(msisdn);
				clickElement(getButtonSelfcareLogin(), "Selfcare Login Button", driver);
			} 

			sendKeys(getTextboxMSISDN(), msisdn, "MSISDN", "", driver);
			sendKeys(getTextboxPassword(), pin, "PIN", "", driver);
			clickElement(getButtonLogin(), "Login Button", driver);
			
			if (verifyElementExistUsingXpathString("//input[@value='Close']", "Service Unavailable Message", driver)) {
				clickElement(getButtonClose(), "Close Button", driver);
				sendKeys(getTextboxMSISDN(), msisdn, "MSISDN", "", driver);
				sendKeys(getTextboxPassword(), pin, "PIN", "", driver);
				clickElement(getButtonLogin(), "Login Button", driver);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while logging to Selfcare  :" + e);
		}
	}
	
	
	public void verifySelfcareBalanceAndPlanName() {
        try {
        	
        	clickElement(getButtonManageAccount(), "Manage Account Button", driver);
        	clickElement(getButtonAccountDetails(), "Account Details Button", driver);
        	
        	compareInString(getLabelAccountBalance().getText(), "MYR "+MainUtil.dictionary.get("MAIN_BALANCE"), "Account Balance", driver);
        	compareInString(getLabelExpiryDate().getText(), "Expiry Date: "+MainUtil.dictionary.get("ACTIVE_END_DATE"), "Expiry Date", driver);
        	compareInString(getLabelPlanName().getText(), MainUtil.dictionary.get("PLAN_NAME"), "Plan Name", driver);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while verifying Selfcare Balance & Planname  :" + e);
        }
    }
	
	public void verifySelfcarePostpaidplandetail() {
        try {
        	
        	clickElement(getButtonManageAccount(), "Manage Account Button", driver);
        	clickElement(getButtonAccountDetails(), "Account Details Button", driver);
        	
        	compareInString(getMobileNumber().getText(), MainUtil.dictionary.get("MSISDN"), "Mobile Number", driver);
        	compareInString(getStatus().getText(), "Active", "Plan Status", driver);
        	compareInString(getCurrentRatePlan().getText(), MainUtil.dictionary.get("SELFCARE_PLAN"), "Current Rate Plan", driver);
        	compareInString(getCreditLimit().getText(), MainUtil.dictionary.get("CREDIT_LIMIT"), "Credit Limit", driver);
                	
        	
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while verifying Selfcare Balance & Planname  :" + e);
        }
    }
	
		
	public void logoutSelfcare() {
        try {
        	
        	clickElement(getButtonLogout(), "Logout Button", driver);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while verifying logging out from selfcare  :" + e);
        }
    }
}
