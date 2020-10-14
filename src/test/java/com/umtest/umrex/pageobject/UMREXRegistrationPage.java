package com.umtest.umrex.pageobject;

import com.umtest.testframe.lib.AppWait;
import com.umtest.testframe.lib.MainUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UMREXRegistrationPage extends MainUtil {

	private AndroidDriver<?> driver;

	public UMREXRegistrationPage(AndroidDriver<?> driver) {
		this.driver = driver;
	}


	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Prepaid']")
	private AndroidElement buttonPrepaid;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Postpaid']")
	private AndroidElement buttonPostpaid;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Prepaid Phone Bundle']")
	private AndroidElement buttonPrepaidPhoneBundle;
	
	@AndroidFindBy(id = "com.fl.pra:id/home_scan_card_auto")
	private AndroidElement buttonScanID;
	
	@AndroidFindBy(id = "com.fl.pra:id/llScanId")
	private AndroidElement buttonScanIDPostpaid;
	
	@AndroidFindBy(id = "com.fl.pra:id/btn_scan_myKad")
	private AndroidElement buttonMyKad;

	@AndroidFindBy(id = "com.fl.pra:id/btn_scan_passport")
	private AndroidElement buttonPassport;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SCAN']")
	private AndroidElement buttonScan;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bypass Setting']")
	private AndroidElement optionBypassSetting;
	
	@AndroidFindBy(id = "com.fl.pra:id/scScanId")
	private AndroidElement toggleBypassScanID;
	
	@AndroidFindBy(id = "com.fl.pra:id/scReadId")
	private AndroidElement toggleBypassReadID;
	
	@AndroidFindBy(id = "com.fl.pra:id/etIdNumber")
	private AndroidElement textboxIDNumber;
	
	@AndroidFindBy(id = "com.fl.pra:id/etName")
	private AndroidElement textboxName;
	
	@AndroidFindBy(id = "com.fl.pra:id/spGender")
	private AndroidElement spinnerGender;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Male']")
	private AndroidElement selectMale;
	
	@AndroidFindBy(id = "com.fl.pra:id/etDobDD")
	private AndroidElement dateDD;
	
	@AndroidFindBy(id = "com.fl.pra:id/etDobMM")
	private AndroidElement dateMM;
	
	@AndroidFindBy(id = "com.fl.pra:id/etDobYYYY")
	private AndroidElement dateYYYY;
	
	@AndroidFindBy(id = "com.fl.pra:id/spNationality")
	private AndroidElement spinnerNationality;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Antarctica']")
	private AndroidElement selectAntartica;
	
	@AndroidFindBy(id = "com.fl.pra:id/btnContinue")
	private AndroidElement buttonContinue;
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[2]")
	private AndroidElement buttonContinuePhoneBundle;
	
	@AndroidFindBy(id = "com.fl.pra:id/address")
	private AndroidElement textboxAddress;
	
	@AndroidFindBy(id = "com.fl.pra:id/city")
	private AndroidElement textboxCity;
	
	@AndroidFindBy(id = "com.fl.pra:id/state")
	private AndroidElement textboxState;
	
	@AndroidFindBy(id = "com.fl.pra:id/postcode")
	private AndroidElement textboxPostcode;

	@AndroidFindBy(id = "com.fl.pra:id/email")
	private AndroidElement textboxEmailID;
	
	@AndroidFindBy(id = "com.fl.pra:id/alternate_contact_number")
	private AndroidElement textboxAlternateContact;
	
	@AndroidFindBy(id = "com.fl.pra:id/proceed_scan_barcode_btn")
	private AndroidElement buttonScanSimPack;
	
	@AndroidFindBy(id = "com.fl.pra:id/btn_scan_simpack_manual")
	private AndroidElement buttonEnterSimPackManually;
	
	@AndroidFindBy(id = "com.fl.pra:id/mobile_number")
	private AndroidElement textboxMobileNumber;
	
	@AndroidFindBy(id = "com.fl.pra:id/next_sim")
	private AndroidElement buttonSIMNext;
	
	@AndroidFindBy(id = "com.fl.pra:id/submit")
	public AndroidElement buttonSubmit;
	
	@AndroidFindBy(id = "com.fl.pra:id/dialog_reg_btn")
	private AndroidElement buttonRegistrationOnly;
	
	@AndroidFindBy(id = "com.fl.pra:id/dialog_topup_btn")
	private AndroidElement buttonTopup;
	
	@AndroidFindBy(id = "com.fl.pra:id/dialog_purchase_btn")
	private AndroidElement buttonBundlePurchase;
	
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement buttonOK;
	
	@AndroidFindBy(id = "android:id/message")
	private AndroidElement postSubmitMessage;
	
	@AndroidFindBy(id = "android:id/button2")
	private AndroidElement buttonNO;
	
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement buttonYES;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='YES']")
	private AndroidElement buttonYESBundlePurchase;
	
	@AndroidFindBy(id = "com.fl.pra:id/purchase_password")
	private AndroidElement textboxPurchasePassword;
	
	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	private AndroidElement textboxPurchasePasswordPhoneBundle;
	
	@AndroidFindBy(id = "com.fl.pra:id/topup_password")
	private AndroidElement textboxTopupPassword;
	
	@AndroidFindBy(id = "com.fl.pra:id/purchase_amount")
	private AndroidElement textboxPurchaseTopupAmount;
	
	@AndroidFindBy(id = "com.fl.pra:id/topup_amount")
	private AndroidElement textboxTopupAmount;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='UMI']")
	private AndroidElement radioButtonUMI;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='MB']")
	private AndroidElement radioButtonMB;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EPIKKK']")
	private AndroidElement radioButtonEPIKKK;
	
	@AndroidFindBy(id = "com.fl.pra:id/product_package")
	private AndroidElement dropdownBundle;
	
	@AndroidFindBy(id = "com.fl.pra:id/purchase_btn")
	private AndroidElement buttonPurchase;
	
	@AndroidFindBy(id = "com.fl.pra:id/topup_btn")
	private AndroidElement buttonFinalTopup;
	
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement buttonConfirm;
	
	@AndroidFindBy(id = "com.fl.pra:id/ddmf_status_tv")
	private AndroidElement labelDDMFCheckStatus;
	
	@AndroidFindBy(id = "com.fl.pra:id/age_validation_status_tv")
	private AndroidElement labelAgeValidationStatus;
	
	@AndroidFindBy(id = "com.fl.pra:id/internal_blacklist_status_tv")
	private AndroidElement labelInternalBlacklistStatus;
	
	@AndroidFindBy(id = "com.fl.pra:id/ai_new_title")
	private AndroidElement spinnerTitle;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Mr']")
	private AndroidElement selectMR;
	
	@AndroidFindBy(id = "com.fl.pra:id/ai_new_address1")
	private AndroidElement textboxAddressPostpaid;
	
	@AndroidFindBy(id = "com.fl.pra:id/ai_new_postcode")
	private AndroidElement textboxPostcodePostpaid;
	
	@AndroidFindBy(id = "com.fl.pra:id/ai_new_phone1_area_et")
	private AndroidElement textboxAlternateNumberArea;
	
	@AndroidFindBy(id = "com.fl.pra:id/ai_new_phone1")
	private AndroidElement textboxAlternateNumber;
	
	@AndroidFindBy(id = "com.fl.pra:id/cl_add_new_principle")
	private AndroidElement buttonAddPrincipalLine;
	
	@AndroidFindBy(id = "com.fl.pra:id/tv_search_label")
	private AndroidElement buttonSearch;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.fl.pra:id/tv_msisdn_item'])[1]")
	private AndroidElement buttonFirstMSISDN;
	
	@AndroidFindBy(id = "com.fl.pra:id/et_email")
	private AndroidElement textboxEmail;
	
	@AndroidFindBy(id = "com.fl.pra:id/et_sim_info")
	private AndroidElement textboxSIMNo;
	
	@AndroidFindBy(id = "com.fl.pra:id/tvAdvancePayment")
	private AndroidElement labelAdvancePayment;
	
	@AndroidFindBy(id = "com.fl.pra:id/tvDeposit")
	private AndroidElement labelForeignDeposit;
	
	@AndroidFindBy(id = "com.fl.pra:id/tv_total_payment")
	private AndroidElement labelTotalAmount;
	
	@AndroidFindBy(id = "com.fl.pra:id/sales_event_type_spinner")
	private AndroidElement spinnerEventType;
	
	@AndroidFindBy(id = "com.fl.pra:id/sales_event_start_date")
	private AndroidElement buttonEventStartDate;
	
	@AndroidFindBy(id = "com.fl.pra:id/sales_event_end_date")
	private AndroidElement buttonEventEndDate;
	
	@AndroidFindBy(id = "com.fl.pra:id/sales_event_postcode")
	private AndroidElement textboxEventPostcode;
	
	@AndroidFindBy(id = "com.fl.pra:id/cbTncDeclaration")
	private AndroidElement buttonTNC;
	
	@AndroidFindBy(id = "com.fl.pra:id/spContactList")
	private AndroidElement spinnerERFEmail;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.CheckedTextView[2]")
	private AndroidElement selectEmailID;
	
	@AndroidFindBy(id = "com.fl.pra:id/llSignWholeLayout")
	private AndroidElement signatureArea;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.view.View[2]")
	private AndroidElement buttonSign;
	
	@AndroidFindBy(id = "com.fl.pra:id/erecharge_password_et")
	private AndroidElement textboxPurchasePasswordPostpaid;
	
	@AndroidFindBy(id = "com.fl.pra:id/tvOrderResultTitle")
	private AndroidElement labelSuccessMessagePostpaid;
	
	@AndroidFindBy(id = "com.fl.pra:id/tvOrderNo")
	private AndroidElement labelOrderNumberPostpaid;
	
	@AndroidFindBy(id = "com.fl.pra:id/tvBack2HomeBtn")
	private AndroidElement buttonBackToHome;
	
	@AndroidFindBy(id = "com.fl.pra:id/rb_specific_pool")
	private AndroidElement radioButtonDealerPool;
	
	@AndroidFindBy(id = "com.fl.pra:id/rb_common_pool")
	private AndroidElement radioButtonCommonPool;
	
	@AndroidFindBy(id = "com.fl.pra:id/et_msisdn_pattern")
	private AndroidElement textboxSearchMSISDN;
	
	@AndroidFindBy(id = "com.fl.pra:id/etImei")
	private AndroidElement textboxIMEI;
	
	@AndroidFindBy(id = "com.fl.pra:id/tvVerifyBtn")
	private AndroidElement buttonVerify;
	
	@AndroidFindBy(id = "com.fl.pra:id/cl_add_new_line")
	private AndroidElement buttonAddNewline;

	@AndroidFindBy(id = "com.fl.pra:id/cl_add_member_line")
	private AndroidElement buttonAddmemberline;
	
	@AndroidFindBy(id = "com.fl.pra:id/tvPromo")
	private AndroidElement dropdownPromotion;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.fl.pra:id/tvItem'])[1]")
	private AndroidElement selectFirstPromotion;
	
	@AndroidFindBy(id = "com.fl.pra:id/etPhoneModemPromo")
	private AndroidElement textboxPhoneModemPromo;
	
	@AndroidFindBy(id = "com.fl.pra:id/etHandsetModel")
	private AndroidElement textboxHandsetModel;
	
	@AndroidFindBy(id = "com.fl.pra:id/tvPhoneTotalPayment")
	private AndroidElement labelTotalAmountPhoneBundle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Broadband']")
	private AndroidElement buttonBroadband;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Offer']")
	private AndroidElement buttonChangeOffer;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Postpaid Phone Bundle']")
	private AndroidElement buttonPostpaidPhoneBundle;
		
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.fl.pra:id/cb_broadband_data_sim'][@text='Click For Broadband Data SIM Only']")
	private AndroidElement checkboxBroadbandDataSIMonly;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Make Payment']")
	private AndroidElement labelMakePayment;
	
	@AndroidFindBy(id = "com.fl.pra:id/tv_title")
	private AndroidElement labelSubscriptionSummary;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='btnaddpayment']")
	private AndroidElement buttonAddPaymentMethod;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Cash']")
	private AndroidElement buttonCashPayment;
	
	@AndroidFindBy(id = "com.fl.pra:id/spCardType")
	private AndroidElement Cardtype;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='MyKad']")
	private AndroidElement selectMyKad;
	
	@AndroidFindBy(id = "com.fl.pra:id/spRace")
	private AndroidElement Race;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Malay']")
	private AndroidElement selectMalay;
	
	@AndroidFindBy(id = "com.fl.pra:id/etAddress1")
	private AndroidElement textboxAddressform;
	
	@AndroidFindBy(id = "com.fl.pra:id/etCity")
	private AndroidElement textboxCityform;
	
	@AndroidFindBy(id = "com.fl.pra:id/etState")
	private AndroidElement textboxStateform;
	
	@AndroidFindBy(id = "com.fl.pra:id/etPostcode")
	private AndroidElement textboxPostcodeform;
	
	@AndroidFindBy(id = "com.fl.pra:id/llReadId")
	private AndroidElement buttonReadIDPostpaid;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.fl.pra:id/tvSubsInfo'][@text='Select MSISDN']")
	private AndroidElement CRPSelectMSISDN;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.fl.pra:id/tvCRPType'][@text='Please Select']")
	private AndroidElement CRPSelectType;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.fl.pra:id/tvName'][@text='Change Postpaid Rate Plan']")
	private AndroidElement Changeposttopostprinciple;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.fl.pra:id/tvName'][@text='Postpaid Principal to Prepaid']")
	private AndroidElement Changeposttoprepaid;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.fl.pra:id/tvName'][@text='Postpaid Principal to Postpaid Member']")
	private AndroidElement Changeprincipletomember;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.fl.pra:id/tvNewPlan'][@text='Select']")
	private AndroidElement SelectButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1'][@text='Retry']")
	private AndroidElement Retrybutton;
	
	public AndroidElement getButtonPrepaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonPrepaid);
	}
	
	public AndroidElement getButtonPostpaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonPostpaid);
	}
	
	public AndroidElement getButtonPrepaidPhoneBundle() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonPrepaidPhoneBundle);
	}

	public AndroidElement getButtonScanID() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonScanID);
	}
	
	public AndroidElement getButtonScanIDPostpaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonScanIDPostpaid);
	}
	
	public AndroidElement getButtonMyKad() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonMyKad);
	}
	
	public AndroidElement getButtonPassport() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonPassport);
	}
	
	public AndroidElement getButtonScan() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonScan);
	}
	
	public AndroidElement getOptionBypassSetting() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, optionBypassSetting);
	}
	
	public AndroidElement getToggleBypassScanID() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, toggleBypassScanID);
	}
	
	public AndroidElement getToggleBypassReadID() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, toggleBypassReadID);
	}
	
	public AndroidElement getTextboxIDNumber() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxIDNumber);
	}
	
	public AndroidElement getTextboxName() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxName);
	}
	
	public AndroidElement getSpinnerGender() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, spinnerGender);
	}
	
	public AndroidElement getSelectMale() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectMale);
	}
	
	public AndroidElement getDateDD() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, dateDD);
	}
	
	public AndroidElement getDateMM() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, dateMM);
	}
	
	public AndroidElement getDateYYYY() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, dateYYYY);
	}
	
	public AndroidElement getSpinnerNationality() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, spinnerNationality);
	}
	
	public AndroidElement getSelectAntartica() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectAntartica);
	}
	
	public AndroidElement getButtonContinue() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonContinue);
	}
	
	public AndroidElement getButtonContinuePhoneBundle() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonContinuePhoneBundle);
	}
	
	public AndroidElement getTextboxAddress() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxAddress);
	}
	
	public AndroidElement getTextboxCity() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxCity);
	}
	
	public AndroidElement getTextboxState() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxState);
	}
	
	public AndroidElement getTextboxPostcode() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPostcode);
	}
	
	public AndroidElement getTextboxEmailID() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxEmailID);
	}
	
	public AndroidElement getTextboxAlternateContact() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxAlternateContact);
	}
	
	public AndroidElement getButtonScanSimPack() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonScanSimPack);
	}
	
	public AndroidElement getButtonEnterSimPackManually() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonEnterSimPackManually);
	}
	
	public AndroidElement getTextboxMobileNumber() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxMobileNumber);
	}
	
	public AndroidElement getButtonSIMNext() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonSIMNext);
	}
	
	public AndroidElement getButtonSubmit() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonSubmit);
	}
	
	public AndroidElement getButtonRegistrationOnly() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonRegistrationOnly);
	}
	
	public AndroidElement getButtonTopup() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonTopup);
	}
	
	public AndroidElement getButtonBundlePurchase() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonBundlePurchase);
	}
	
	public AndroidElement getButtonOK() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonOK);
	}
	
	public AndroidElement getPostSubmitMessage() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, postSubmitMessage);
	}
	
	public AndroidElement getButtonNO() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonNO);
	}
	
	public AndroidElement getButtonYES() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonYES);
	}
	
	public AndroidElement getButtonYESBundlePurchase() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonYESBundlePurchase);
	}
	
	public AndroidElement getTextboxPurchasePassword() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPurchasePassword);
	}
	
	public AndroidElement getTextboxPurchasePasswordPhoneBundle() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPurchasePasswordPhoneBundle);
	}
	
	public AndroidElement getTextboxTopupPassword() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxTopupPassword);
	}
	
	public AndroidElement getTextboxPurchaseTopupAmount() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPurchaseTopupAmount);
	}
	
	public AndroidElement getTextboxTopupAmount() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxTopupAmount);
	}
	
	public AndroidElement getRadioButtonUMI() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, radioButtonUMI);
	}
	
	public AndroidElement getRadioButtonMB() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, radioButtonMB);
	}
	
	public AndroidElement getRadioButtonEPIKKK() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, radioButtonEPIKKK);
	}
	
	public AndroidElement getDropdownBundle() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, dropdownBundle);
	}
	
	public AndroidElement selectBundleName(String bundleName) {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, "//android.widget.TextView[@resource-id='com.fl.pra:id/planTV'][@text='"+bundleName+"']");
	}
	
	public AndroidElement getButtonPurchase() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonPurchase);
	}
	
	public AndroidElement getButtonFinalTopup() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonFinalTopup);
	}
	
	public AndroidElement getButtonConfirm() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonConfirm);
	}
	
	public AndroidElement getLabelDDMFCheck() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelDDMFCheckStatus);
	}
	
	public AndroidElement getLabelAgeValidationStatus() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelAgeValidationStatus);
	}
	
	public AndroidElement getLabelInternalBlacklistStatus() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelInternalBlacklistStatus);
	}
	
	public AndroidElement getSpinnerTitle() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, spinnerTitle);
	}

	public AndroidElement getSelectMR() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectMR);
	}
	
	public AndroidElement getTextboxAddressPostpaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxAddressPostpaid);
	}
	
	public AndroidElement getTextboxPostcodePostpaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPostcodePostpaid);
	}
	
	public AndroidElement getTextboxAlternateNumberArea() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxAlternateNumberArea);
	}
	
	public AndroidElement getTextboxAlternateNumber() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxAlternateNumber);
	}
	
	public AndroidElement getButtonAddPrincipalLine() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonAddPrincipalLine);
	}
	
	public AndroidElement getButtonSearch() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonSearch);
	}
	
	public AndroidElement getButtonFirstMSISDN() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonFirstMSISDN);
	}
	
	public AndroidElement selectPostpaidPlan(String planName) {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, "//android.widget.TextView[@resource-id='com.fl.pra:id/tvDisplayName'][contains(@text,'"+planName+"')]");
	}
	
	public AndroidElement selectSpecificMSISDN(String msisdn) {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, "//android.widget.TextView[@resource-id='com.fl.pra:id/tv_msisdn_item'][@text='"+msisdn+"']");
	}
	
	public AndroidElement getTextboxEmail() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxEmail);
	}
	
	public AndroidElement getTextboxSIMNo() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxSIMNo);
	}
	
	public AndroidElement getLabelAdvancePayment() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelAdvancePayment);
	}
	
	public AndroidElement getLabelForeignDeposit() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelForeignDeposit);
	}
	
	public AndroidElement getLabelTotalAmount() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelTotalAmount);
	}
	
	public AndroidElement getSpinnerEventType() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, spinnerEventType);
	}
	
	public AndroidElement selectEvenType(String eventType) {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, "//android.widget.CheckedTextView[@resource-id='android:id/text1'][@text='"+eventType+"']");
	}
	
	public AndroidElement getButtonEventStartDate() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonEventStartDate);
	}
	
	public AndroidElement getButtonEventEndDate() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonEventEndDate);
	}
	
	public AndroidElement getTextboxEventPostcode() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxEventPostcode);
	}
	
	public AndroidElement getButtonTNC() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonTNC);
	}
	
	public AndroidElement getSpinnerERFEmail() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, spinnerERFEmail);
	}
	
	public AndroidElement getSelectEmailID() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectEmailID);
	}
	
	public AndroidElement getSignatureArea() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, signatureArea);
	}
	
	public AndroidElement getButtonSign() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonSign);
	}
	
	public AndroidElement getTextboxPurchasePasswordPostpaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPurchasePasswordPostpaid);
	}
	
	public AndroidElement getLabelSuccessMessagePostpaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelSuccessMessagePostpaid);
	}
	
	public AndroidElement getLabelOrderNumberPostpaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelOrderNumberPostpaid);
	}
	
	public AndroidElement getButtonBackToHome() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonBackToHome);
	}
	
	public AndroidElement getRadioButtonDealerPool() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, radioButtonDealerPool);
	}
	
	public AndroidElement getRadioButtonCommonPool() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, radioButtonCommonPool);
	}
	
	public AndroidElement getTextboxSearchMSISDN() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxSearchMSISDN);
	}
	
	public AndroidElement getTextboxIMEI() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxIMEI);
	}
	
	public AndroidElement getButtonVerify() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonVerify);
	}
	
	public AndroidElement getButtonAddNewline() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonAddNewline);
	}

	public AndroidElement getButtonAddmemberline() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonAddmemberline);
	}
	
	public AndroidElement getDropdownPromotion() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, dropdownPromotion);
	}
	
	public AndroidElement getSelectFirstPromotion() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectFirstPromotion);
	}
	
	public AndroidElement getTextboxPhoneModemPromo() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPhoneModemPromo);
	}
	
	public AndroidElement getTextboxHandsetModel() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxHandsetModel);
	}
	
	public AndroidElement getLabelTotalAmountPhoneBundle() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, labelTotalAmountPhoneBundle);
	}
	
	public AndroidElement getbuttonBroadband() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonBroadband);
	}

	public AndroidElement getbuttonChangeOffer() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonChangeOffer);
	}
	
	public AndroidElement getbuttonPostpaidPhoneBundle() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonPostpaidPhoneBundle);
	}
	
	public AndroidElement getRadioButtonUBUSIM(String planName) {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, "//android.widget.RadioButton[@text='"+planName+"']");
	}
	
	public AndroidElement getcheckboxBroadbandDataSIMonly() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, checkboxBroadbandDataSIMonly);
	}
	
	public AndroidElement getLabelMakePayment() {
		return (AndroidElement) AppWait.waitForElementForVisibility(driver, labelMakePayment);
	}
	
	public AndroidElement getLabelSubscriptionSummary() {
		return (AndroidElement) AppWait.waitForElementForVisibility(driver, labelSubscriptionSummary);
	}
	
	public AndroidElement getButtonAddPaymentMethod() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonAddPaymentMethod);
	}
	
	public AndroidElement getButtonCashPayment() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonCashPayment);
	}
	
	public AndroidElement getCardtype() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Cardtype);
	}
	
	public AndroidElement getselectMyKad() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectMyKad);
	}
	
	public AndroidElement getRace() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Race);
	}
	
	public AndroidElement getselectMalay() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, selectMalay);
	}
	
	public AndroidElement gettextboxAddressform() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxAddressform);
	}
	
	public AndroidElement gettextboxCityform() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxCityform);
	}
	
	public AndroidElement gettextboxStateform() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxStateform);
	}
	
	public AndroidElement gettextboxPostcodeform() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, textboxPostcodeform);
	}
	
	public AndroidElement getbuttonReadIDPostpaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, buttonReadIDPostpaid);
	}
	
	public AndroidElement getCRPSelectMSISDN() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, CRPSelectMSISDN);
	}
	
	public AndroidElement getCRPSelectType() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, CRPSelectType);
	}
	
	public AndroidElement getChangeposttopostprinciple() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Changeposttopostprinciple);
	}
	
	public AndroidElement getChangeposttoprepaid() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Changeposttoprepaid);
	}

	public AndroidElement getChangeprincipletomember() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Changeprincipletomember);
	}
	
	public AndroidElement getSelectButton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, SelectButton);
	}
	
	public AndroidElement getRetrybutton() {
		return (AndroidElement) AppWait.waitForElementToBeClickable(driver, Retrybutton);
	}
	
}
