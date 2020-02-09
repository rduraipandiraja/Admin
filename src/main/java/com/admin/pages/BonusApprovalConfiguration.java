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
import com.admin.utilities.Utils;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BonusApprovalConfiguration extends WrapperMethods {
		
	public BonusApprovalConfiguration(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	String minAmount = "//input[@name='minamount[]']";

	public void clickBonusApprovalConfigurationSubMenu(WebDriver driver) {

		reportStep(logger, "About to click submenu BonusApprovalConfiguration in admin homepage", "INFO");
		
		//Click cashback submenu button
		if(jsClickUsingID(driver, "SubMenu_BonusApprovalConfiguration")) {

			reportStep(logger, "Successfully clicked on the submenu BonusApprovalConfiguration", "PASS");
		}else {

			reportStep(logger, "Not able to click the submenu BonusApprovalConfiguration", "FAIL");
		}
		
		if(isElementVisibleByXpathPresent(driver, minAmount)) {

			reportStep(logger, "Successfully verified minAmount element presence", "PASS");
		}else {

			reportStep(logger, "Not able to verify minAmount element presence", "FAIL");
		}
		
	}
	
	public void enterMinimumAmount(String amount) throws InterruptedException {

		reportStep(logger, "About to enter minAmount in text box", "INFO");
		
		if(isElementVisibleByXpathPresent(driver, minAmount)) {

			reportStep(logger, "Successfully verified minAmount element presence", "PASS");
		}else {

			reportStep(logger, "Not able to verify minAmount element presence", "FAIL");
		}

		if(enterTextByXpath(driver, minAmount, amount)) {

			reportStep(logger, "Successfully entered "+amount+" in minAmount text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter "+amount+" in minAmount text box", "FAIL");
		}
		
	}
	
	public void clickSubmit(WebDriver driver) {

		reportStep(logger, "About to click submit in all cashback page", "INFO");
		
		if(jsClickUsingID(driver, "btn_Submit")) {

			reportStep(logger, "Successfully clicked on the submit in all cashback page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the submit in all cashback page", "FAIL");
		}
		
		if(isElementVisibleByIDPresent(driver, "adminMessageSuccess")) {

			reportStep(logger, "Successfully validated success message", "PASS");
		}else {

			reportStep(logger, "Not able to validate success message", "FAIL");
		}
		
	}
	
}





