package com.umtest.umb.pagefunction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umtest.testframe.lib.ApplicationUtil;
import com.umtest.umb.pageobject.UMBDialSimulatorPage;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

public class UMBUSSDFuncs extends UMBDialSimulatorPage {

    private static Logger logger = LogManager.getLogger(UMBUSSDFuncs.class);
    private RemoteWebDriver driver;

    public UMBUSSDFuncs(RemoteWebDriver driver) {
    	super(driver);
		this.driver =  driver;
		PageFactory.initElements(driver, this);

    }

    //Perform USSD operation and verify output
    public String DialForPurchase() {
    	
       	String USSDResponse = null;
        try {
          	clickElement(getlinkSimulation(),"Click on Simulation link", driver);
        	clickElement(getLinkPhonesim(),"Click on Phonesim link", driver);
        	sendKeys(gettextboxMSISDN(), dictionary.get("MSISDN"),"", "Enter MSISDN", driver);
        	sendKeys(getTextboxUSSDCode(), dictionary.get("USSD_CODE"),"", "Enter USSD Code", driver);
        	
        	clickElement(getbuttonSend(),"Click on Send", driver);
        	
        	USSDResponse = gettextareaUSSDResponse().getText();
        	if(USSDResponse.contains("系统繁忙。请稍后再试")) {
        		ResetUMBScreen();
        		sendKeys(gettextboxMSISDN(), dictionary.get("MSISDN"),"", "Enter MSISDN", driver);
            	sendKeys(getTextboxUSSDCode(), dictionary.get("USSD_CODE"),"", "Enter USSD Code", driver);
            	clickElement(getbuttonSend(),"Click on Send", driver);
            	USSDResponse = gettextareaUSSDResponse().getText();
        	}
        	logger.info(USSDResponse);

        	
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while performing UMB USSD operation  :" + e);
        }
        
        return USSDResponse;
    }
    
    
    //Perform USSD clear screen operation
    public void ResetUMBScreen() {
        try {
          	clickElement(getbuttonClear(),"Click on Reset USSD button", driver);
        	logger.info("USSD screen cleared");
        	
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while clearing USSD Screen in UMB  :" + e);
        }
        
  
    }
    
    
}
