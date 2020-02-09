package com.admin.pages;

import java.util.List;

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

public class Users extends WrapperMethods {
	
	public Users(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	String userId = "//table[@id='all_list']/tbody/tr[2]/td[1]";
	String userName = "//table[@id='all_list']/tbody/tr[2]/td[3]";

	@FindBy(how = How.ID, using = "sby") 
	WebElement searchByDropDown;

	@FindBy(how = How.ID, using = "key") 
	WebElement keywordTextbox;

	@FindBy(how = How.XPATH, using = "//table[@id='all_list']/tbody/tr[2]/td[1]") 
	WebElement userIdXpath;

	@FindBy(how = How.XPATH, using = "//table[@id='all_list']/tbody/tr[2]/td[3]") 
	WebElement userNameXpath;

	@FindBy(how = How.XPATH, using = "//a[@class='fa fa-edit']") 
	WebElement editIConClick;
	
	@FindBy(how = How.XPATH, using = "//a[@class='fa fa-eye']") 
	WebElement eyeIconClick;

	@FindBy(how = How.ID, using = "status") 
	WebElement statusDropDown;

	@FindBy(how = How.ID, using = "referral_bonus") 
	WebElement referralBonus;
	
	String referralbonus = "referral_bonus";

	@FindBy(how = How.ID, using = "email") 
	WebElement email;

	@FindBy(how = How.XPATH, using = "//div[@id='adminMessageSuccess']") 
	WebElement successMessage;

	String facebookID = "//th[text()='Facebook ID']/following-sibling::td";
	
	public void selectSearchByDropDown(String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");

		if(selectValuesFromDropdown(searchByDropDown, dropDownValue)) {

			reportStep(logger, "Successfully selected value "+dropDownValue+" from the dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+dropDownValue+" from dropdown", "FAIL");
		}
	}

	public void enterKeyword(String keyword) {

		reportStep(logger, "About to enter keyword in keyword text box", "INFO");

		if(enterTextInChrome(keywordTextbox, keyword)) {

			reportStep(logger, "Successfully entered keyword "+keyword+" in keyword text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter keyword "+keyword+" in keyword text box", "FAIL");
		}

	}

	public void clickSubmitButton() {

		reportStep(logger, "About to click submit button", "INFO");

		//Click submit button
		if(jsClickUsingID(driver, "users_search_form_submit")) {

			reportStep(logger, "Successfully clicked submit button", "PASS");
		}else {

			reportStep(logger, "Not able to click submit button", "FAIL");
		}

	}

	public String extractUserIdValueFromResultstableFirstRow(){

		reportStep(logger, "About to extract UserId from User page", "INFO");

		validateTheElementPresence(driver, userIdXpath);
		String userIdValue = driver.findElement(By.xpath(userId)).getText();

		reportStep(logger, "Successfully retrieved the extract UserId from User page", "INFO");

		return userIdValue;

	}

	public String extractUserNameValueFromResultstableFirstRow(){

		reportStep(logger, "About to extract UserName from User page", "INFO");

		validateTheElementPresence(driver, userNameXpath);
		String userNameValue = driver.findElement(By.xpath(userName)).getText();

		reportStep(logger, "Successfully retrieved the extract UserName from User page", "INFO");

		return userNameValue;

	}

	public void clickEditButton() {

		reportStep(logger, "About to click edit button", "INFO");

		//Click submit button
		if(jsClickUsingXpath(driver, editIConClick)) {

			reportStep(logger, "Successfully clicked edit button", "PASS");
		}else {

			reportStep(logger, "Not able to click edit button", "FAIL");
		}

		reportStep(logger, "Successfully clicked edit button", "PASS");

	}
	
	public void selectStatusFromDropDown(String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");

		if(selectValuesFromDropdown(statusDropDown, dropDownValue)) {
		
		reportStep(logger, "Successfully selected value "+dropDownValue+" from the dropdown", "PASS");
		}else {
		
		reportStep(logger, "Not able to select value "+dropDownValue+" from dropdown", "FAIL");
		}
	}

	public void clickSubmitButtonUserForm() {

		reportStep(logger, "About to click submit button after doing changes in users form", "INFO");

		//Click submit button
		if(jsClickUsingID(driver, "btn_Submit")) {

			reportStep(logger, "Successfully clicked submit button", "PASS");
		}else {

			reportStep(logger, "Not able to click submit button", "FAIL");
		}
		
		if(validateTheElementPresence(driver, successMessage)) {

			reportStep(logger, "Successfully updated user", "PASS");
		}else {

			reportStep(logger, "Not able update user", "FAIL");
		}
		
	}

	public void clickClearButtonUserForm() {

		reportStep(logger, "About to click clear button after doing changes in users form", "INFO");

		//Click submit button
		if(jsClickUsingID(driver, "users_search_form_clear")) {

			reportStep(logger, "Successfully clicked clear button", "PASS");
		}else {

			reportStep(logger, "Not able to click clear button", "FAIL");
		}
		
		if(validateTheElementPresence(driver, searchByDropDown)) {

			reportStep(logger, "Successfully validated presence of searchByDropDown", "PASS");
		}else {

			reportStep(logger, "SearchByDropDown is not present", "FAIL");
		}
		
	}

	public void enterReferralBonus(String bonus) {

		reportStep(logger, "About to enter referral bonus in users page", "INFO");
		
		if(isElementVisibleByIDPresent(driver, referralbonus)) {

			reportStep(logger, "Waiting for presence of user referral bonus text box", "PASS");

		}else {

			reportStep(logger, "Verified presence of user referral bonus text box", "FAIL");
		}
		
		if(enterTextInChrome(referralBonus, bonus)) {

			reportStep(logger, "Successfully entered referral bonus "+bonus+" in users page", "PASS");

		}else {

			reportStep(logger, "Not able to enter referral bonus "+bonus+" in users page", "FAIL");
		}
	}

	public void enterEmail(String emailAddress) {

		reportStep(logger, "About to enter emailAddress in users page", "INFO");


		if(enterTextInChrome(email, emailAddress)) {

			reportStep(logger, "Successfully entered email "+emailAddress+" in users page", "PASS");

		}else {

			reportStep(logger, "Not able to enter email "+emailAddress+" in users page", "FAIL");
		}
	}

	public void validateUserEditSuccessMessage() {
		
		reportStep(logger, "Once after the User is been de activated - Verifying the Success message in the admin", "INFO");
		validateTheElementPresence(driver, successMessage);
		
	}

	public void clickEyeButton() {

		reportStep(logger, "About to click Eye button", "INFO");

		//Click submit button
		if(jsClickUsingXpath(driver, eyeIconClick)) {

			reportStep(logger, "Successfully clicked Eye button", "PASS");
		}else {

			reportStep(logger, "Not able to click Eye button", "FAIL");
		}

		reportStep(logger, "Successfully clicked Eye button", "PASS");

	}
	
	public String extractFacebookID(){

		reportStep(logger, "About to extract FacebookID from User page", "INFO");

		String facebookid = null;
				
		try {
			
			isElementLocatedByXpathPresent(facebookID);
			facebookid = driver.findElement(By.xpath(facebookID)).getText();

			reportStep(logger, "Successfully retrieved the extract FacebookID from User page", "PASS");
			
		} catch (Exception e) {

			reportStep(logger, "Not able to extract FacebookID from User page reason is: "+e.getMessage(), "FAIL");
		}

		return facebookid;

	}

}