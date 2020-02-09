package com.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.admin.base.WrapperMethods;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PendingCashout extends WrapperMethods {
	
	
	public PendingCashout(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(how = How.ID, using = "sby") 
	WebElement searchByDropDown;

	@FindBy(how = How.ID, using = "user") 
	WebElement keywordTextbox;
	
	@FindBy(how = How.ID, using = "btnCreateCashout") 
	WebElement createCashout;

	public void selectSearchByDropDown(String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down in pending cashout page", "INFO");

		if(selectValuesFromDropdown(searchByDropDown, dropDownValue)) {
		
		reportStep(logger, "Successfully selected value "+dropDownValue+" from the dropdown in pending cashout page", "PASS");
		}else {
		
		reportStep(logger, "Not able to select value "+dropDownValue+" from dropdown in pending cashout page", "FAIL");
		}
	}

	public void enterKeyword(String keyword) {

		reportStep(logger, "About to enter keyword in keyword text box", "INFO");

		if(enterTextInChrome(keywordTextbox, keyword)) {

			reportStep(logger, "Successfully entered keyword "+keyword+" in keyword text box in pending cashout page", "PASS");
		}else {

			reportStep(logger, "Not able to enter keyword "+keyword+" in keyword text box in pending cashout page", "FAIL");
		}
		
	}

	public void clickSubmit() {

		reportStep(logger, "About to click submit in pending cashout page", "INFO");
		
		if(jsClickUsingID(driver, "btnSubmit")) {

			reportStep(logger, "Successfully clicked on the submit in pending cashout page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the submit in pending cashout page", "FAIL");
		}
		
	}

	public void clickEmail(String email) {

		reportStep(logger, "About to click email "+email+" in pending cashout page", "INFO");
		
		String emailXpath = "//a[contains(.,'"+email+"')]";
		
		if(isElementLocatedByXpathPresent(emailXpath)){
			reportStep(logger, "Verified the presence of share button", "INFO");

		}else {
			reportStep(logger, "Not able to verify the presence share button", "FAIL");

		}
		
		WebElement emailAddress = driver.findElement(By.xpath(emailXpath));
		
		if(clickAfterWait(driver, emailAddress)) {

			reportStep(logger, "Successfully clicked email "+email+" in pending cashout page", "PASS");
		}else {

			reportStep(logger, "Not able to click email "+email+" in pending cashout page", "FAIL");
		}
		
	}

	public void clickCreateCashout() {

		reportStep(logger, "About to click create cashout in pending cashout page", "INFO");

		if(clickAfterWait(driver, createCashout)) {
			
			//System.out.println("INNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");

			//reportStep("Successfully clicked on the create cashout in pending cashout page", "PASS");
		}else {

			//reportStep("Not able to click on the create cashout in pending cashout page", "FAIL");
		}
		
		
		
	}

	public void clickOk() {

		reportStep(logger, "About to click OK in pending cashout page", "INFO");
		
		String okXpath = "//*[text()='OK']";
		
		if(isElementLocatedByXpathPresent(okXpath)){
			reportStep(logger, "Verified the presence of ok button", "INFO");

		}else {
			reportStep(logger, "Not able to verify the presence ok button", "FAIL");

		}
		
		WebElement emailAddress = driver.findElement(By.xpath(okXpath));
		
		if(clickAfterWait(driver, emailAddress)) {

			reportStep(logger, "Successfully clicked ok "+okXpath+" in pending cashout page", "PASS");
		}else {

			reportStep(logger, "Not able to click ok "+okXpath+" in pending cashout page", "FAIL");
		}
		
	}
	
	public void validateSuccessMessage() {

		reportStep(logger, "About to validateSuccessMessage in pending cashout page", "INFO");
		
		String successMessage = "//div[@id='adminMessageSuccess']";
		
		if(isElementLocatedByXpathPresent(successMessage)){
			
			reportStep(logger, "Verified the SuccessMessage - i.e Successfully created the Cashout in the admin", "INFO");

		}else {
			reportStep(logger, "Not able to verify the SuccessMessage", "FAIL");

		}
		
	}
	

}





