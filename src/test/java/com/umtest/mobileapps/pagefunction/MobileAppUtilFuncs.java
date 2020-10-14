package com.umtest.mobileapps.pagefunction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.lang.reflect.Method;

import com.umtest.mobileapps.pageobject.MobileAppUtilPage;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;
import com.umtest.testframe.listener.ExtentTestNGITestListener;

import java.time.Duration;

public class MobileAppUtilFuncs extends MobileAppUtilPage {

	private static Logger logger = LogManager.getLogger(MobileAppUtilFuncs.class);
	private AndroidDriver driver;

	public MobileAppUtilFuncs(RemoteWebDriver driver) {
		super((AndroidDriver) driver);
		this.driver = (AndroidDriver) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

	}

	public void verifyMobileApp(String verificationType) {

		try {

			if (verificationType.toUpperCase().contains("PREPAID")) {
				verifyBalanceAndPlanName();
			}
			
			verifyUsageDetails(verificationType);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying mobile apps  :" + e);
		}
	}


	public void verifyBalanceAndPlanName() {

		try {

			compareInString(getLabelAccountBalance().getText(), "RM"+MainUtil.dictionary.get("MAIN_BALANCE"), "Account Balance", driver);
			compareInString(getLabelPlanName().getText(), MainUtil.dictionary.get("PLAN_NAME"), "Plan Name", driver);


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying mobile apps  :" + e);
		}
	}
	
	public void storeMobileAppBalace() {

		try {
			String currentBalance = getLabelAccountBalance().getText();
			MainUtil.dictionary.put("CURRENT_MAIN_BALANCE",currentBalance.substring(2, currentBalance.length()));
			logger.info(MainUtil.dictionary.get("CURRENT_MAIN_BALANCE"));

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while storing mail balance  :" + e);
		}
	}


	public void verifyUsageDetails(String verificationType) {
		try {
			
			ExtentTestNGITestListener.createNode("Mobile App Usage Verification");
			if (verifyElementIsDisplayed(getButtonViewUsageDetails(), "View Usage Details Button",driver)) {
				clickElement(getButtonViewUsageDetails(), "View Usage Details Button", driver);
			} else {
			scrollUDLR(driver, 0, "U");
			clickElement(getButtonViewUsageDetails(), "View Usage Details Button", driver);
			}
			getFirstUsageDetailsCategory().click();
			Thread.sleep(2000);
					
			
			ApplicationUtil.verifyMobileAppServiceDetails(verificationType, driver);


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying usage details  :" + e);
		}
	}
	
	public boolean performCreditShare() {
		boolean flag = false;
		try {
			
			//MobileAppUtilPage mobilePage = new MobileAppUtilPage(driver);
		//	Method getterMethod =mobilePage.getClass().getMethod("getButtonRM" + MainUtil.dictionary.get("TRANSFER_AMOUNT"));
				clickElement(getMenuIcon(), "Click Menu Icon", driver);
			clickElement(getMenuTopUpCredit(), "Click on TopUp & Credit menu", driver);
			clickElement(getMenuCreditShare(), "Click on Credit Share icon", driver);
			clickElement(getButtonTransferCredit1(), "Click on Transfer Credit Share button", driver);
			sendKeys(getTextReceiverMsisdn(),MainUtil.dictionary.get("RECEIVER_MSISDN") , "Enter Receiver's MSISDN","", driver);
			WebElement element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cell_RM"+ MainUtil.dictionary.get("TRANSFER_AMOUNT") +"\"]"));
			
			clickElement(element, "Select Denomination:" + MainUtil.dictionary.get("TRANSFER_AMOUNT") , driver);
		//	clickElement(getButtonDenomination(), "Select Denomination:" + MainUtil.dictionary.get("TRANSFER_AMOUNT") , driver);
			clickElement(getButtonTransferCredit2(), "Click on Transfer Credit Share button", driver);
			clickElement(getButtonTransferConfirm(), "Click on Confirm Transfer button", driver);
			flag = compareInString(getButtonOK().getText(), "OK", "Confirmation", driver);
			clickElement(getButtonOK(), "Click OK", driver);
			if(flag) {
				String	senderChargers = MainUtil.calculateBalance(MainUtil.dictionary.get("TRANSFER_AMOUNT"),"-" + ApplicationUtil.getSenderReceiverFee("sender_sfee",MainUtil.dictionary.get("TRANSFER_AMOUNT")));
				String	receivingAmount = MainUtil.calculateBalance(MainUtil.dictionary.get("TRANSFER_AMOUNT"), ApplicationUtil.getSenderReceiverFee("receiver_sfee",MainUtil.dictionary.get("TRANSFER_AMOUNT")));
				
				ApplicationUtil.updateAccInfoAfterCreditTransfer(MainUtil.dictionary.get("MSISDN"),"main_balance",MainUtil.calculateBalance(MainUtil.dictionary.get("CURRENT_BALANCE"),senderChargers));
				ApplicationUtil.updateAccInfoAfterCreditTransfer(MainUtil.dictionary.get("RECEIVER_MSISDN"),"credit_amount",MainUtil.calculateBalance(MainUtil.dictionary.get("CREDIT_AMOUNT"),"-" + receivingAmount));
			}


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying mobile apps  :" + e);
		}
		return flag;
	}
	
	public void verifyCreditShareBalance() {

		try {
			verifyBalanceAndPlanName();
			clickElement(getMenuIcon(), "Click Menu Icon", driver);
			clickElement(getMenuTopUpCredit(), "Click on TopUp & Credit menu", driver);
			clickElement(getMenuCreditShare(), "Click on Credit Share icon", driver);
			compareInString(getLabelCreditShareBal().getText(), "RM"+MainUtil.dictionary.get("CREDIT_AMOUNT"), "Credit Share Balance", driver);
			//compareInString(getLabelPlanName().getText(), MainUtil.dictionary.get("PLAN_NAME"), "Plan Name", driver);


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying mobile apps  :" + e);
		}
	}
	public void verifyPostpaidbillpayment() {

		try {
			
			clickElement(getMenuIcon(), "Click Menu Icon", driver);
			clickElement(getMenuBillsandPayment(), "Click on Bills & Payment menu", driver);
			clickElement(getMenuBillHistory(), "Click on Bill History Menu", driver);
		
			List<WebElement> childs = driver.findElementsByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
			for(WebElement element:childs)
		     {
				
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
			        LocalDateTime todaysDate =  LocalDateTime.now();
			        String subscribtionDate = dtf.format(todaysDate);
					compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]")).getText(), "RM"+MainUtil.dictionary.get("Amount")+".00  Paid", "Amount Paid", driver);
					compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getText(), subscribtionDate, "Date of Amount Paid", driver);
		     }


		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying mobile apps  :" + e);
		}
	}
	
	public void verifyMobileAppGolifeInsurance(String Golife) {

		try {
			clickElement(getMenuIcon(), "Click Menu Icon", driver);
			scrollUDLR(driver, 0, "U");
			clickElement(getMenuServices(), "Click Services button", driver);
			scrollUDLR(driver, 0, "U");
			clickElement(getMenuGoLife(), "Click Golife button", driver);
				
			scrollUDLR(driver, 0, "U");
			String Insuranceplanname;
			if (Golife.equals("GOLIFE5")) {
				Insuranceplanname = "GoLife 5";
				clickElement(getButtonGoLife5(), "Click Golife5 insurance Section", driver);
			} else {
				Insuranceplanname = "GoLife 10";
				clickElement(getButtonGoLife10(), "Click Golife10 insurance Section", driver);
			}
			
			clickElement(getViewCertificatebutton(), "Click View Certificate button", driver);
			
			for (int i =3;i<7;i++) {
				
				List<WebElement> childs = driver.findElementsByXPath("//android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup["+i+"]");
				for(WebElement element:childs)
			     {
					
					if (i==3) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
				        LocalDateTime todaysDate =  LocalDateTime.now();
				        String subscribtionDate = dtf.format(todaysDate);
						compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]")).getText(), "Date of Subscription", "Date of Subscription description", driver);
						compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getText(), subscribtionDate, "Date of Subscription", driver);
					} else if (i==4) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
				        LocalDateTime todaysDate =  LocalDateTime.now();
				        LocalDateTime currentmonth = todaysDate.plusMonths(1);
				        LocalDateTime currentday = todaysDate.plusDays(30);
			            String Nextchargingdate = dtf.format(currentday);
			            System.out.println(Nextchargingdate);
						compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]")).getText(), "Date of next charging", "Date of Next Charging description", driver);
						compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getText(), Nextchargingdate, "Date of Next Charging", driver);
					} else if (i==5) {
						compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]")).getText(), "Plan", "Plan description", driver);
						compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getText(), Insuranceplanname, "Plan Name", driver);
					} else {
						compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[1]")).getText(), "Status", "Status description", driver);
						compareInString(element.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getText(), "ACTIVE", "Plan Status", driver);
					}
			     }
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying mobile apps Golife :" + e);
		}
	}
	
	public boolean doChangerateplan(String newplanname) {
		boolean flag = false;
		try {
			clickElement(getUpgradeplanbutton(), "Click Upgrade Plan Link", driver);
			
			scrollUDLR(driver, 0, "U");
			scrollUDLR(driver, 0, "U");
			
			clickElement(getChangePlanNowbutton(), "Click Change Plan Now Button", driver);
						
			scrollUDLR(driver, 0, "U");
			scrollUDLR(driver, 0, "U");
			
			clickElement(getProceedbutton(), "Click Proceed Button", driver);
			
			scrollUDLR(driver, 0, "U");
			clickElement(getCurrntplanname(), "Click currentplan description", driver);
			
			List<WebElement> childs = driver.findElementsByXPath("//android.view.View/android.view.View[3]/android.view.View/android.view.View[1]");
			for(WebElement element:childs) {
				System.out.println(element.getText());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while verifying mobile apps  :" + e);
		}
		return flag;
	}
}	
