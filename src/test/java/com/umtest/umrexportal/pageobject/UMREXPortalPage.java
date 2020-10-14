package com.umtest.umrexportal.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.umtest.testframe.lib.AppWait;
import com.umtest.testframe.lib.MainUtil;

public class UMREXPortalPage extends MainUtil {

	private RemoteWebDriver driver;

	public UMREXPortalPage(RemoteWebDriver driver) {
		this.driver = driver;
	}


	@FindBy(id = "txtUsername")
	private WebElement textboxUsername;
	
	@FindBy(id = "txtPassword")
	private WebElement textboxPassword;
	
	@FindBy(id = "btnLogin")
	private WebElement buttonLogin;
	
	@FindBy(xpath = "//span[@class='menu--label'][text()='Report']")
	private WebElement buttonReports;
	
	@FindBy(xpath = "//li[@class='sub_menu--item mySubMenu RegistrationReport']//a[@class='sub_menu--link'][contains(text(),'Registration Report')]")
	private WebElement buttonRegistrationReport;
	
	@FindBy(id = "btn-search")
	private WebElement buttonSearch;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement textboxSearch;
	
	@FindBy(xpath = "(//td[@class=' td-GroupCodeLimit'])[5]")
	private WebElement labelRegistrationStatus;
	
	
	public WebElement getTextboxUsername() {
		return AppWait.waitForElementToBeClickable(driver, textboxUsername);
	}
	
	public WebElement getTextboxPassword() {
		return AppWait.waitForElementToBeClickable(driver, textboxPassword);
	}
	
	public WebElement getButtonLogin() {
		return AppWait.waitForElementToBeClickable(driver, buttonLogin);
	}
	
	public WebElement getButtonReports() {
		return AppWait.waitForElementToBeClickable(driver, buttonReports);
	}
	
	public WebElement getButtonRegistrationReport() {
		return AppWait.waitForElementToBeClickable(driver, buttonRegistrationReport);
	}
	
	public WebElement getButtonSearch() {
		return AppWait.waitForElementToBeClickable(driver, buttonSearch);
	}
	
	public WebElement getTextboxSearch() {
		return AppWait.waitForElementToBeClickable(driver, textboxSearch);
	}
	
	public WebElement getLabelRegistrationStatus() {
		return AppWait.waitForElementToBeClickable(driver, labelRegistrationStatus);
	}
}
