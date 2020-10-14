package com.umtest.mobileapps.pagefunction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.mobileapps.pageobject.MobileAppTopupPage;
import com.umtest.testframe.lib.ApplicationUtil;
import java.time.Duration;

public class MobileAppPrepaidTopupFuncs extends MobileAppTopupPage {

	private static Logger logger = LogManager.getLogger(MobileAppPrepaidTopupFuncs.class);
	private AndroidDriver driver;

	public MobileAppPrepaidTopupFuncs(RemoteWebDriver driver) {
		super((AndroidDriver) driver);
		this.driver = (AndroidDriver) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

	}



	public boolean doTopup(String topupType, String topupAmount) {

		boolean returnStatus = false;

		try {

			MobileAppUtilFuncs utilFuncs = new MobileAppUtilFuncs(driver);
			utilFuncs.storeMobileAppBalace();

			clickElement(getButtonTopUp(), "Topup Button", driver);

			if (topupType.equalsIgnoreCase("PIN")) {

				clickElement(getButtonTopUpPin(), "Topup Pin", driver);
				ApplicationUtil.getTopUpPin(topupAmount); sendKeys(getTextboxTopUpPIN(), dictionary.get("TOPUP_PIN"), "PIN", "", driver);
				clickElement(getButtonTopUpNow(), "Topup Pin", driver); Thread.sleep(3000);
				clickElement(getButtonOK(), "OK Button", driver);

				boolean status = true;

				if (status) {
					ApplicationUtil.updateTopupPinStatusInTable(dictionary.get("TOPUP_PIN"));
					ApplicationUtil.updateAccountInfoAfterTopup(dictionary.get("MSISDN"));
					returnStatus = true;
				}


			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while doing topup" + e);
		}
		return returnStatus;
	}

}
