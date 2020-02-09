package com.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class BonusCredit extends WrapperMethods {
	
	
	public BonusCredit(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(how = How.ID, using = "SubMenu_AddBonusCredits") 
	WebElement subMenuBonusCredits;

	@FindBy(how = How.ID, using = "username") 
	WebElement usernameTextbox;

	@FindBy(how = How.ID, using = "cashback_type") 
	WebElement cashbackTypeDropDown;

	@FindBy(how = How.ID, using = "cashbackvalue") 
	WebElement bonusValueTextbox;

	@FindBy(how = How.ID, using = "confirm_date") 
	WebElement dateRangeTextbox;
	
	public void clickBonusCreditsSubMenu() {

		reportStep(logger, "About to click submenu BonusCredits in admin homepage", "INFO");
		
		//Click BonusCredits sub menu button
		if(jsClickUsingID(driver,"SubMenu_AddBonusCredits")) {

			reportStep(logger, "Successfully clicked on the submenu BonusCredits", "PASS");
		}else {

			reportStep(logger, "Not able to click the submenu BonusCredits", "FAIL");
		}
		
	}

	public void enterUser(String username) {

		reportStep(logger, "About to enter username in username text box", "INFO");

		if(enterTextInChrome(usernameTextbox, username)) {

			reportStep(logger, "Successfully entered username "+username+" in username text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter username "+username+" in username text box", "FAIL");
		}
		
		driver.findElement(By.id("username")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("username")).sendKeys(Keys.ENTER);
		
	}

	public void enterBonusValue(String BonusValue) {

		reportStep(logger, "About to enter BonusValue in BonusValue text box", "INFO");

		if(enterTextInChrome(bonusValueTextbox, BonusValue)) {

			reportStep(logger, "Successfully entered BonusValue "+BonusValue+" in BonusValue text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter BonusValue "+BonusValue+" in BonusValue text box", "FAIL");
		}
		
	}

	public void setDateRangeDate() {
		
	reportStep(logger, "About to set OrderDate", "INFO");


	try {

		System.out.println("In try block about to setDateRange");

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirm_date")));
			
	} catch (Exception e) {

		System.out.println("In catch block not able to setDateRange");
	}
	
	String date = Utils.setCurrentDate();
	
	((JavascriptExecutor)driver).executeScript("document.getElementById('confirm_date').setAttribute('value', '"+date+"')");
	
	reportStep(logger, "Successfully setDateRange", "INFO");
	
	}

	public void selectCashbackTypeFromDropDown(String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");

		if(selectValuesFromDropdown(cashbackTypeDropDown, dropDownValue)) {
		
		reportStep(logger, "Successfully selected value "+dropDownValue+" from the dropdown", "PASS");
		}else {
		
		reportStep(logger, "Not able to select value "+dropDownValue+" from dropdown", "FAIL");
		}
	}

	public void clickSubmit() {

		reportStep(logger, "About to click submit in all cashback page", "INFO");
		
		if(jsClickUsingID(driver,"btn_Submit")) {

			reportStep(logger, "Successfully clicked on the submit in all cashback page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the submit in all cashback page", "FAIL");
		}
		
	}

}