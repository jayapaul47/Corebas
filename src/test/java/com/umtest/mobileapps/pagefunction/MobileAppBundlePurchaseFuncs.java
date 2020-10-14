package com.umtest.mobileapps.pagefunction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.mobileapps.pageobject.MobileAppBunldePurchasePage;
import com.umtest.mobileapps.pageobject.MobileAppTopupPage;
import com.umtest.mobileapps.testcases.MobileAppBundlePurchase;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;

import java.time.Duration;

public class MobileAppBundlePurchaseFuncs extends MobileAppBunldePurchasePage {

	private static Logger logger = LogManager.getLogger(MobileAppBundlePurchaseFuncs.class);
	private AndroidDriver driver;

	public MobileAppBundlePurchaseFuncs(RemoteWebDriver driver) {
		super((AndroidDriver) driver);
		this.driver = (AndroidDriver) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

	}



	public boolean doBundlePurchase(String bundleName) {

		boolean returnStatus = false;

		try {

			MobileAppUtilFuncs utilFuncs = new MobileAppUtilFuncs(driver);
			utilFuncs.storeMobileAppBalace();

			clickElement(getButtonPurchaseAddon(), "Addon Button", driver);
			Thread.sleep(2000);


			if (bundleName.toUpperCase().contains("GX")) {
				clickElement(selectGX(), "GX Button", driver);

			} else if (bundleName.toUpperCase().contains("UMI")) {		
				clickElement(selectUMI(), "UMI Button", driver);

			} else if (bundleName.toUpperCase().contains("MB")) {
				clickElement(selectMB(), "MB Button", driver);

			} else if (bundleName.toUpperCase().contains("EPIKKK")) {
				clickElement(selectEpikkk(), "EPIKKK Button", driver);

			} else if (bundleName.toUpperCase().contains("GT")) {
				selectEpikkk().click();
				clickElement(selectUnlimitedCall(), "Unlimited Call Button", driver);

			} else if (bundleName.toUpperCase().contains("GAMEONZ")) {
				selectEpikkk().click();
				clickElement(selectGameOnz(), "Game Onz Button", driver);

			}

			String buyNowXpath = "//android.view.ViewGroup[contains(@content-desc,'addOns_"+bundleName+"')]//android.view.ViewGroup[contains(@content-desc,'button_Buy Now')]";

			while (verifyElementExistUsingXpathString(buyNowXpath, "Buy Now Button", driver)  == false) {
				scrollUDLRMobileApp(driver, 1, "U");
			}

			clickElementUsingXpathString(buyNowXpath, bundleName+" Buy Now", driver);
			clickElement(getButtonConfirm(), "Confirm Button", driver);

			Thread.sleep(1000);
			if (verifyElementExistUsingXpathString(getButtonContinueString(), "Continue Button", driver)) {
				clickElement(getButtonContinue(), "Continue Button", driver);
			}


			Thread.sleep(2000);
			boolean checkFlag = checkForText("", getSuccessMessage(), "Successful", "Success Message", driver);
			//boolean checkFlag = true;
			
			
			if (checkFlag) {
				clickElement(getButtonClose(), "Close Button", driver);
				dictionary.put("BUNDLE_NAME", bundleName.replaceAll("\\s",""));
				ApplicationUtil.getBundleDetails("PREPAID", MainUtil.dictionary.get("BUNDLE_NAME"));
				ApplicationUtil.getUMBDetails("PREPAID", MainUtil.dictionary.get("CATEGORY"));
				String bundlePurchaseDate = MainUtil.getBundlePurchaseDate();
				String bundleExpiry = MainUtil.calculateBundleExpiry(MainUtil.dictionary.get("BUNDLE_NAME"));
				String updatedBalance = MainUtil.calculateBalance(MainUtil.dictionary.get("CURRENT_MAIN_BALANCE"), MainUtil.dictionary.get("PRICE"));
				ApplicationUtil.updateAccInfoAfterBundle("PREPAID", MainUtil.dictionary.get("MSISDN"), updatedBalance, MainUtil.dictionary.get("BUNDLE_NAME"), bundlePurchaseDate, bundleExpiry);
				returnStatus = true;
			}



		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing topup" + e);
		}
		return returnStatus;
	}

}
