package com.umtest.selfcare.pagefunction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import com.umtest.selfcare.pageobject.SelfcareLoginLogoutPage;
import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.testframe.lib.MainUtil;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SelfcareVerificationFuncs extends SelfcareLoginLogoutPage {

	private static Logger logger = LogManager.getLogger(SelfcareLoginLogoutFuncs.class);
	private RemoteWebDriver driver;
		
	public SelfcareVerificationFuncs(RemoteWebDriver driver) {
		super(driver);
		this.driver =  driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
	}


    public void verifySelfcare(String accountType) {
        try {
        	
        	SelfcareLoginLogoutFuncs loginFuncs = new SelfcareLoginLogoutFuncs(driver);
        	loginFuncs.loginSelfcare(MainUtil.dictionary.get("MSISDN"));
        	
        	if (accountType.toUpperCase().contains("PREPAID")) {
        		loginFuncs.verifySelfcareBalanceAndPlanName();
			}
        	
        	if (accountType.toUpperCase().contains("POSTPAID")) {
        		ApplicationUtil.getPlanDetails_Postpaid(MainUtil.dictionary.get("PLAN_NAME"));
        		loginFuncs.verifySelfcarePostpaidplandetail();
			}
        	
        	loginFuncs.logoutSelfcare();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while verifying Selfcare  :" + e);
        }
    }
    public void verifyPostpaidBillpayment() {
        try {
        	
        	SelfcareLoginLogoutFuncs loginFuncs = new SelfcareLoginLogoutFuncs(driver);
        	loginFuncs.loginSelfcare(MainUtil.dictionary.get("msisdn"));
        	
        	        	
        	clickElement(getBillandpayment(), "Bill & Payment Button", driver);
        	clickElement(getPaymentHistory(), "Payment History Button", driver);
            WebElement paymentdetail= driver.findElementByXPath("//body//tr[2]");
            
        	//body//tr[2]
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime todaysDate =  LocalDateTime.now();
            String subscribtionDate = dtf.format(todaysDate);
            System.out.println(subscribtionDate);
            
            compareInString(paymentdetail.getText(), "MYR "+MainUtil.dictionary.get("Amount")+".00", "Payment Amount", driver);
            compareInString(paymentdetail.getText(), subscribtionDate, "Payment Date", driver);
                    	
          //div[@class='table_plan table_padding selfcare_table']/tbody/tr	
                    	
        	loginFuncs.logoutSelfcare();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while verifying Selfcare  :" + e);
        }
    }
}
