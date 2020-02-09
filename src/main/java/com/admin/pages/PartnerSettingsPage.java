package com.admin.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.admin.base.WrapperMethods;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PartnerSettingsPage extends WrapperMethods {
	
	public PartnerSettingsPage(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(how = How.XPATH, using = "//td[contains(.,'earnkaro.iamsavings.co.uk')]/parent::tr/td/a[1]") 
	WebElement editPartnerDetails_Beta;

	@FindBy(how = How.XPATH, using = "//td[contains(.,'trackingstaging.earnkaro.com')]/parent::tr/td/a[1]") 
	WebElement editPartnerDetails_Staging;

	@FindBy(how = How.ID, using = "sign_up_bonus") 
	WebElement signUpBonus;

	@FindBy(how = How.ID, using = "referral_signup_bonus") 
	WebElement referralSignUpBonus;

	@FindBy(how = How.ID, using = "btn_Submit") 
	WebElement submitButton;

	@FindBy(how = How.ID, using = "customer_info_email_id") 
	WebElement customerEmail;

	public void clickEditPartnerDetails(WebElement element){

		reportStep(logger, "About to click edit partner details in partner settings page", "INFO");

			if(clickAfterWait(driver, element)) {

				reportStep(logger, "Successfully clicked edit partner details in partner settings page", "PASS");
			}else {

				reportStep(logger, "Not able to click edit partner details in partner settings page", "FAIL");
			}
	}

	public void clickEditPartnerDetails(WebDriver driver, String partnerURL){

		reportStep(logger, "About to click edit partner details in partner settings page", "INFO");

			if(jsClickByXpath(driver, "//td[text()='"+partnerURL+"']/following-sibling::td/a[@data-original-title='Edit Partner Details']")) {

				reportStep(logger, "Successfully clicked edit partner details in partner settings page", "PASS");
			}else {

				reportStep(logger, "Not able to click edit partner details in partner settings page", "FAIL");
			}
	}

	public void enterSignUpBonus(String bonus) {

		reportStep(logger, "About to enter signup bonus in partner settings page", "INFO");


		if(enterTextInChrome(signUpBonus, bonus)) {

			reportStep(logger, "Successfully entered signup bonus "+bonus+" in partner settings page", "PASS");

		}else {

			reportStep(logger, "Not able to enter signup bonus "+bonus+" in partner settings page", "FAIL");
		}
	}

	public void enterReferralSignUpBonus(String bonus) {

		reportStep(logger, "About to enter referral signup bonus in partner settings page", "INFO");


		if(enterTextInChrome(referralSignUpBonus, bonus)) {

			reportStep(logger, "Successfully entered referral signup bonus "+bonus+" in partner settings page", "PASS");

		}else {

			reportStep(logger, "Not able to enter referral signup bonus "+bonus+" in partner settings page", "FAIL");
		}
	}

	public void clickSubmit(){

		reportStep(logger, "About to click submit button after filling the form in admin page", "INFO");

		//Click submit
		if(clickAfterWait(driver, submitButton)) {

			reportStep(logger, "Successfully clicked on the submit button", "PASS");
		}else {

			reportStep(logger, "Not able to click the submit button", "FAIL");
		}
	}

	public void enterCustomerEmailID(String customerEmailID) {

		reportStep(logger, "About to enter referral signup bonus in partner settings page", "INFO");


		if(enterTextUsingSendKeys(customerEmail, customerEmailID)) {

			reportStep(logger, "Successfully entered customerEmail: "+customerEmailID+" in partner settings page", "PASS");

		}else {

			reportStep(logger, "Not able to enter customerEmail: "+customerEmailID+" in partner settings page", "FAIL");
		}
	}

	public String getPartnerID(WebDriver driver, String url) {

		String currentURL = null;
		String partnerID = null;

		reportStep(logger, "About to get partner ID", "INFO");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains(url.trim()));


		if(driver.getCurrentUrl().contains(url.trim())) {

			currentURL = driver.getCurrentUrl();
			partnerID = StringUtils.substringBetween(currentURL, "add_partners.php?id=", "&mode=edit");
			
			reportStep(logger, "Successfully got Partner ID: "+partnerID+" in partner settings page URL", "PASS");

		}else {

			reportStep(logger, "Not able to get partner ID: "+partnerID+" in partner settings page URL", "FAIL");
		}
		
		return partnerID;
	}

}