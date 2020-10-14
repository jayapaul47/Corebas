package com.umtest.mobileapps.pageobject;

import com.umtest.testframe.lib.AppWait;
import com.umtest.testframe.lib.MainUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MobileAppLoginPage extends MainUtil {

	private AndroidDriver<?> driver;

	public MobileAppLoginPage(AndroidDriver<?> driver) {
		this.driver = driver;
	}


	@AndroidFindBy(xpath = "(//android.widget.ImageView)[3]")
	private AndroidElement buttonENVSetting;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Stage 2']")
	private AndroidElement selectStage2;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
	private AndroidElement buttonOK;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
	private AndroidElement buttonLogin;
	
	@AndroidFindBy(accessibility = "newLogin_textfield_mobile")
	private AndroidElement textboxMobileNumber;
	
	@AndroidFindBy(accessibility = "newLogin_textfield_pin")
	private AndroidElement textboxPIN;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"tutorials_button_close\"]/android.widget.ImageView")
	private AndroidElement buttonWelcomeScreenCancel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='First time Login']")
	private AndroidElement buttonFirstTimeLogin;
	
	@AndroidFindBy(accessibility = "firstTimeLogin_testfield_mobile")
	private AndroidElement textboxFirstTimeLoginMobileNumber;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"firstTimeLogin_button_mobile\"])[1]/android.view.ViewGroup")
	private AndroidElement buttonLoginButtonFirstTime;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
	private AndroidElement dialogboxMessage;


	public AndroidElement getButtonENVSetting() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonENVSetting);
	}
	
	public AndroidElement getSelectStage2() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectStage2);
	}

	public AndroidElement getButtonOK() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonOK);
	}
	
	public AndroidElement getTextboxMobileNumber() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxMobileNumber);
	}
	
	public AndroidElement getTextboxPIN() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPIN);
	}
	
	public AndroidElement getButtonLogin() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonLogin);
	}
	
	public AndroidElement getButtonWelcomeScreenCancel() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonWelcomeScreenCancel);
	}
	
	public AndroidElement getButtonFirstTimeLogin() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonFirstTimeLogin);
	}
	
	public AndroidElement getTextboxFirstTimeLoginMobileNumber() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxFirstTimeLoginMobileNumber);
	}
	
	public AndroidElement getButtonLoginFirstTime() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonLoginButtonFirstTime);
	}
	
	public AndroidElement getDialogboxMessage() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, dialogboxMessage);
	}
	
}
