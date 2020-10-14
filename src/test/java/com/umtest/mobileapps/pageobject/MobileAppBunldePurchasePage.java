package com.umtest.mobileapps.pageobject;

import com.umtest.testframe.lib.AppWait;
import com.umtest.testframe.lib.MainUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MobileAppBunldePurchasePage extends MainUtil {

	private AndroidDriver<?> driver;

	public MobileAppBunldePurchasePage(AndroidDriver<?> driver) {
		this.driver = driver;
	}

	
	@AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"MultiBar, tab, 2 of 3\"]//android.view.ViewGroup)[3]")
	private AndroidElement buttonPurchaseAddon;
	
	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(@text,'GX')]")
	private AndroidElement selectGX;
	
	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(@text,'UMI')]")
	private AndroidElement selectUMI;
	
	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(@text,'MB')]")
	private AndroidElement selectMB;
	
	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(@text,'Epikkk')]")
	private AndroidElement selectEpikkk;
	
	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(@text,'Unlimited Call')]")
	private AndroidElement selectUnlimitedCall;
	
	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(@text,'Game-Onz')]")
	private AndroidElement selectGameOnz;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm']")
	private AndroidElement buttonConfirm;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	private AndroidElement buttonContinue;
	
	private String buttonContinueString = "//android.widget.TextView[@text='Continue']";
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Successful']")
	private AndroidElement successMessage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Close']")
	private AndroidElement buttonClose;
	
	
	public AndroidElement getButtonPurchaseAddon() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonPurchaseAddon);
	}
	
	public AndroidElement selectGX() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectGX);
	}
	
	public AndroidElement selectUMI() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectUMI);
	}
	
	public AndroidElement selectMB() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectMB);
	}
	
	public AndroidElement selectEpikkk() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectEpikkk);
	}
	
	public AndroidElement selectUnlimitedCall() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectUnlimitedCall);
	}
	
	public AndroidElement selectGameOnz() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectGameOnz);
	}
	
	public AndroidElement getButtonConfirm() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonConfirm);
	}
	
	public AndroidElement getButtonContinue() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonContinue);
	}
	
	public String getButtonContinueString() {
		return buttonContinueString;
	}
	
	public AndroidElement getSuccessMessage() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, successMessage);
	}
	
	public AndroidElement getButtonClose() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonClose);
	}
}
