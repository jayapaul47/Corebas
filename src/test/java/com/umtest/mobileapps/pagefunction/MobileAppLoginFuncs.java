package com.umtest.mobileapps.pagefunction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.mobileapps.pageobject.MobileAppLoginPage;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.PropertyHelper;
import com.umtest.testframe.listener.ExtentTestNGITestListener;

import java.time.Duration;

public class MobileAppLoginFuncs extends MobileAppLoginPage {

    private static Logger logger = LogManager.getLogger(MobileAppLoginFuncs.class);
    private AndroidDriver driver;

    public MobileAppLoginFuncs(RemoteWebDriver driver) {
        super((AndroidDriver) driver);
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

    }


    public void loginMobileApp(String msisdn) {
        try {
        	
        	((AndroidDriver) driver).resetApp();
    		((AndroidDriver) driver).launchApp();
        	
        	String pin = ApplicationUtil.getSelfcareLoginPin(msisdn);
            selectENV(System.getProperty("env"));
            
            if (pin == null) {
            	
            	clickElement(getButtonFirstTimeLogin(), "First Time Login Button", driver);
            	sendKeys(getTextboxFirstTimeLoginMobileNumber(), msisdn, "Mobile Number", "", driver);
            	clickElement(getButtonLoginFirstTime(), "Login Button", driver);
            	sendKeys(getTextboxPIN(), ApplicationUtil.getSelfcareLoginPin(msisdn), "PIN", "", driver);
            	
            	
            } else {
            	
            	clickElement(getButtonLogin(), "Login Button", driver);
                sendKeys(getTextboxMobileNumber(), msisdn, "Mobile Number", "", driver);
                sendKeys(getTextboxPIN(), pin, "PIN", "", driver);
            }
             
            hideKeyboard(driver);
            if (verifyElementIsDisplayed(getButtonWelcomeScreenCancel(), "Welcome Screen", driver)) {
            	clickElement(getButtonWelcomeScreenCancel(), "Welcome Screen Cancel Button", driver);
			}
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while logging to Mobile App  :" + e);
        }
    }
    
    public void selectENV(String env) {
        try {
            if (env.equalsIgnoreCase("uat")) {
            	clickElement(getButtonENVSetting(), "Environment Setting Button", driver);
            	clickElement(getSelectStage2(), "Stage 2", driver);
            	clickElement(getButtonOK(), "OK Button", driver);
            	dictionary.put(null, null);
            	dictionary.put("null", "null");
			} else {

			}
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while selecting environment "+env+"  :" + e);
        }
    }

}
