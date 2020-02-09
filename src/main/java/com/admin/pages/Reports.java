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

public class Reports extends WrapperMethods {
	
	public Reports(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(how = How.ID, using = "SubMenu_ExitClicks") 
	WebElement subMenuExitClick;

	@FindBy(how = How.ID, using = "sby") 
	WebElement searchByDropDown;

	@FindBy(how = How.ID, using = "sterm") 
	WebElement keywordTextbox;
	
	@FindBy(how = How.ID, using = "btn_Submit") 
	WebElement submitButton;

	@FindBy(how = How.ID, using = "anc_ExpandCollapse") 
	WebElement expandCollapseButton;
	
	@FindBy(how = How.ID, using = "btn_Clear") 
	WebElement clearButton;
	
	public void clickExitClickSubMenu(WebDriver driver) {

		reportStep(logger, "About to click submenu ExitClick in admin homepage", "INFO");
		
		if(jsClickByID(driver, "SubMenu_ExitClicks")) {
			
			reportStep(logger, "Successfully clicked on the submenu ExitClick", "PASS");
		}else {

			reportStep(logger, "Not able to click the submenu ExitClick", "FAIL");
		}
		
	}
	
	public void selectSearchByDropDown(WebDriver driver, String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");

		if(selectValuesFromDropdown(searchByDropDown, dropDownValue)) {
		
		reportStep(logger, "Successfully selected value "+dropDownValue+" from the dropdown", "PASS");
		}else {
		
		reportStep(logger, "Not able to select value "+dropDownValue+" from dropdown", "FAIL");
		}
	}

	public void enterKeyword(WebDriver driver, String keyword) {

		reportStep(logger, "About to enter keyword in keyword text box", "INFO");

		if(enterTextInChrome(keywordTextbox, keyword)) {

			reportStep(logger, "Successfully entered keyword "+keyword+" in keyword text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter keyword "+keyword+" in keyword text box", "FAIL");
		}
		
	}
	
	public void clickSubmit(WebDriver driver) {

		reportStep(logger, "About to click submit in view exit click page", "INFO");
		
		if(clickAfterWait(driver, submitButton)) {

			reportStep(logger, "Successfully clicked on the submit in view exit click page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the submit in view exit click page", "FAIL");
		}
		
	}

	public void clickExpandCollapseButton(WebDriver driver) {

		reportStep(logger, "About to click expandCollapseButton in view exit click page", "INFO");
		
		if(isElementVisibleByIDPresent(driver, "anc_ExpandCollapse")) {

			reportStep(logger, "Validated presence of expandCollapseButton in view exit click page", "PASS");
		}else {

			reportStep(logger, "Not able to validate presence of expandCollapseButton in view exit click page", "FAIL");
		}
		
		if(jsClickByID(driver, "anc_ExpandCollapse")) {

			reportStep(logger, "Successfully clicked on the expandCollapseButton in view exit click page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the expandCollapseButton in view exit click page", "FAIL");
		}
		
		if(isElementVisibleByIDPresent(driver, "btn_Clear")) {

			reportStep(logger, "Validated presence of clear button in view exit click page", "PASS");
		}else {

			reportStep(logger, "Not able to validate presence of clear button in view exit click page", "FAIL");
		}
		
	}

	public void clickSubmitUsingJavaScript(WebDriver driver) {

		reportStep(logger, "About to click submit in view exit click page", "INFO");
		
		if(jsClickByID(driver, "btn_Submit")) {

			reportStep(logger, "Successfully clicked on the submit in view exit click page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the submit in view exit click page", "FAIL");
		}
		
	}

	public void clickClear(WebDriver driver) {

		reportStep(logger, "About to click clear in view exit click page", "INFO");
		
		
		
		if(jsClickByID(driver, "btn_Clear")) {

			reportStep(logger, "Successfully clicked on the clear in view exit click page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the clear in view exit click page", "FAIL");
		}
		
	}

	public String extractExitClickValueFromResultstableFirstRow(WebDriver driver){

		reportStep(logger, "About to extract exit id from reports page", "INFO");
		
		String searchResultsTable= "//table[@id='all_list']/tbody/tr[2]/td[1]";
		
		if(isElementLocatedByXpathPresent(searchResultsTable)) {

			reportStep(logger, "Presence exit id from reports page", "INFO");
		}else {

			reportStep(logger, "Successfully retrieved the extract exit id from reports page", "INFO");
		}
	
		String reqExitClick = driver.findElement(By.xpath(searchResultsTable)).getText();

		reportStep(logger, "Successfully retrieved the extract exit id from reports page", "INFO");
		
		return reqExitClick;

	}

	public String extractExitClickValueFromResultstableFirstRow(WebDriver driver, String index){

		reportStep(logger, "About to extract exit id from reports page", "INFO");
		
		String searchResultsTable= "//table[@id='all_list']/tbody/tr["+index+"]/td[1]";
		
		if(isElementLocatedByXpathPresent(searchResultsTable)) {

			reportStep(logger, "Presence exit id from reports page", "INFO");
		}else {

			reportStep(logger, "Successfully retrieved the extract exit id from reports page", "INFO");
		}
	
		String reqExitClick = driver.findElement(By.xpath(searchResultsTable)).getText();

		reportStep(logger, "Successfully retrieved the extract exit id from reports page", "INFO");
		
		return reqExitClick;

	}

	public String extractRequiredExitIdUsingStoreNameExitClickType(String storeName, String exitClickType){

		reportStep(logger, "About to extract UserId from view exit click page", "INFO");
	
		String reqExitClick= "//table[@id='all_list']/tbody/tr/td[contains(.,'"+storeName+"')]/parent::tr/td[contains(.,'"+exitClickType+"')]/parent::tr/td[1]";
		
		if(isElementLocatedByXpathPresent(reqExitClick)) {

			reportStep(logger, "For the store name: "+storeName+" there is exitclicktype "+exitClickType+"", "INFO");
		}else {

			reportStep(logger, "Not able to find the store name: "+storeName+" having exitclicktype "+exitClickType+"", "FAIL");
		}
		
		String exitId = driver.findElement(By.xpath(reqExitClick)).getText();

		reportStep(logger, "Successfully retrieved the extract exitId: "+exitId+" from view exit click page", "INFO");

		return exitId;

	}

	public String extractRequiredExitIdUsingStoreNameExitClickType(String storeName, String exitClickType, int index){

		reportStep(logger, "About to extract shared exitId from view exit click page", "INFO");
	
		String reqExitClick= "(//table[@id='all_list']/tbody/tr/td[contains(.,'"+storeName+"')]/parent::tr/td[contains(.,'"+exitClickType+"')]/parent::tr/td[1])["+index+"]";
		
		if(isElementLocatedByXpathPresent(reqExitClick)) {

			reportStep(logger, "For the store name: "+storeName+" there is exitclicktype "+exitClickType+"", "INFO");
		}else {

			reportStep(logger, "Not able to find the store name: "+storeName+" having exitclicktype "+exitClickType+"", "FAIL");
		}
		
		String exitId = driver.findElement(By.xpath(reqExitClick)).getText();

		reportStep(logger, "Successfully retrieved the extract shared exitId: "+exitId+" from view exit click page", "INFO");

		return exitId;

	}

	public String extractRequiredExitIdUsingStoreNameExitClickTypeSharedId(String storeName, String sharedID){

		reportStep(logger, "About to extract normal exitId from view exit click page", "INFO");
	
		String reqExitClick= "//table[@id='all_list']/tbody/tr/td[contains(.,'"+storeName+"')]/parent::tr/td[contains(.,'"+sharedID+"')]/parent::tr/td[1]/parent::tr/td[contains(.,'Normal')]/parent::tr/td[1]";
		
		if(isElementLocatedByXpathPresent(reqExitClick)) {

			reportStep(logger, "For the store name: "+storeName+" there is exitclicktype "+sharedID+"", "INFO");
		}else {

			reportStep(logger, "Not able to find the store name: "+storeName+" having exitclicktype "+sharedID+"", "FAIL");
		}
		
		String exitId = driver.findElement(By.xpath(reqExitClick)).getText();

		reportStep(logger, "Successfully retrieved the extract normal exitId: "+exitId+" from view exit click page", "INFO");

		return exitId;

	}

}