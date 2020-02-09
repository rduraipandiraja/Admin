package com.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.admin.base.WrapperMethods;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentSettingsPage extends WrapperMethods {


	public PaymentSettingsPage(WebDriver driver, ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);


	}


	@FindBy(how = How.XPATH, using = "//td[.='cashkaro.iamsavings.co.uk']/following::td/a[@data-original-title='Edit Payment Methods']") 
	WebElement paymentMethodEditButton;
	
	@FindBy(how = How.ID, using = "btn_Submit") 
	WebElement updatePaymentSettings;

	public void clickOnPartnerPaymentEditButton() {

		reportStep(logger, "About to click on the Partner Payment edit button ", "INFO");

		if(clickAfterWait(driver, paymentMethodEditButton)) {

			reportStep(logger, "successfully clicked on Partner Payment edit button in Admin ", "PASS");

		}else {

			reportStep(logger, "Not able to clicked on Partner Payment edit button in Admin ", "FAIL");
		}

	}

	public void clickEditPaymentMethod(WebDriver driver, String partnerURL){

		reportStep(logger, "About to click edit partner details in partner settings page", "INFO");

			if(jsClickByXpath(driver, "//td[text()='"+partnerURL+"']/following-sibling::td/a[@data-original-title='Edit Payment Methods']")) {

				reportStep(logger, "Successfully clicked edit partner details in partner settings page", "PASS");
			}else {

				reportStep(logger, "Not able to click edit partner details in partner settings page", "FAIL");
			}
	}

	/* editPaymentMethod_Select_Status in Partner_Settings Menu */
	public void editPaymentMethod_Select_Status(int paymentID, String status) {

		reportStep(logger , "About to select the Payment method number "+ paymentID +  " Status as: "+ status, "INFO");
		
		if(selectValuesFromDropdown(driver, "//select[@id='status"+paymentID+"']", status)) {
			
			reportStep(logger , "Successfully selected payment method ID "+ paymentID + " 's status as :"+ status, "PASS");
			
		}else {
			
			reportStep(logger , "Failed to select the payment method ID  "+ paymentID + " 's  status as :"+ status, "FAIL");
		}
		
	}
	
	/* editPaymentMethod_Select_CashbackType in Partner_Settings Menu */
	public void dropDown_Select_CashbackType(int paymentID, String cashbackType) {
		
		reportStep(logger, "About to select cashback type - editPaymentMethod in Partner_Settings", "INFO");
		
		if(selectValuesFromDropdown(driver, "//select[@id='cashback_type_"+paymentID+"']", cashbackType)) {
			
			reportStep(logger , "Successfully selected payment method ID "+ paymentID + " 's Cashback type  as :"+ cashbackType, "PASS");
		}else {
			
			reportStep(logger , "Failed to  select  payment method ID "+ paymentID + " 's Cashback type  as :"+ cashbackType, "FAIL");
		}
		


	}

	public void clickOnUpdatePaymentSettingsButton() {
		
		reportStep(logger, "About to click on the Update Payment  Setting  button ", "INFO");
		
		if(clickAfterWait(driver, updatePaymentSettings)) {
			
			reportStep(logger, "Successfully clicked on the Update Payment settigs button ", "PASS");
			
		}else {
			
			reportStep(logger, "Failed to  click on the Update Payment settigs button ", "FAIL");
		}
		
	}


}
