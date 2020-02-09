package com.admin.pages;

import org.apache.commons.lang3.StringUtils;
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

public class Cashback extends WrapperMethods {
	
	
	public Cashback(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(how = How.ID, using = "SubMenu_Cashbacks") 
	WebElement subMenuCashback;

	@FindBy(how = How.ID, using = "sby") 
	WebElement searchByDropDown;

	@FindBy(how = How.ID, using = "status") 
	WebElement cashbackDropDown;

	@FindBy(how = How.ID, using = "key") WebElement keywordTextbox;

	@FindBy(how = How.ID, using = "exit_id") 
	WebElement exitIDTextbox;

	@FindBy(how = How.ID, using = "tranactionid") 
	WebElement transactionIdTextbox;

	@FindBy(how = How.ID, using = "orderid") 
	WebElement orderIdTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='ordervalue']") 
	WebElement orderValueTextbox;

	@FindBy(how = How.ID, using = "cmsn_frm_network") 
	WebElement confirmCommisionNetworkTextbox;

	@FindBy(how = How.ID, using = "cashbackvalue") 
	WebElement cashbackTextbox;

	@FindBy(how = How.ID, using = "details") 
	WebElement detailsTextbox;

	@FindBy(how = How.ID, using = "cashback_type") 
	WebElement cashbackTypeDropDown;

	@FindBy(how = How.ID, using = "status") 
	WebElement statusDropDown;
	
	@FindBy(how = How.ID, using = "btn_Submit") 
	WebElement submitButton;

	@FindBy(how = How.ID, using = "btn_Clear") 
	WebElement clearButton;

	@FindBy(how = How.XPATH, using = "(//a[@class='fa fa-edit'])[1]") 
	WebElement editButton;
	
	String buttonEdit = "(//a[@class='fa fa-edit requiredValidation'])[1]";

	String exitIDTextBox = "//input[@id='exit_id']";
	
	String dropDown = "//select[@id='sby']";

	@FindBy(how = How.ID, using = "adminMessageSuccess") 
	WebElement successMessage;
	
	@FindBy(how = How.XPATH, using = "//*[@text='Save Cashback']|//*[text()='Save Cashback']") 
	WebElement saveCashback;

	@FindBy(how = How.XPATH, using = "//table[@id='all_list']/tbody/tr[2]/td[2]") 
	WebElement cashbackID;
	
	@FindBy(how = How.XPATH, using = "//span[@id='networkDetails']") 
	WebElement transactionID;
	
	public void clickCashbackSubMenu(WebDriver driver) {

		reportStep(logger, "About to click submenu cashback in admin homepage", "INFO");
		
		//Click cashback submenu button
		if(jsClickUsingID(driver, "SubMenu_Cashbacks")) {

			reportStep(logger, "Successfully clicked on the submenu cashback", "PASS");
		}else {

			reportStep(logger, "Not able to click the submenu cashback", "FAIL");
		}
		
	}
	
	public void selectSearchByStatusFromDropDown(String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");
		
		if(isElementVisibleByXpathPresent(driver, dropDown)) {

			reportStep(logger, "Successfully validated exit ID text box presence", "PASS");
		}else {

			reportStep(logger, "Not able to validate exit ID text box presence", "FAIL");
		}

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
	
	public void selectCashbackStatusFromDropDown(String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");

		if(selectValuesFromDropdown(cashbackDropDown, dropDownValue)) {
		
		reportStep(logger, "Successfully selected value "+dropDownValue+" from the dropdown", "PASS");
		}else {
		
		reportStep(logger, "Not able to select value "+dropDownValue+" from dropdown", "FAIL");
		}
	}

	public void clickSubmit(WebDriver driver) {

		reportStep(logger, "About to click submit in all cashback page", "INFO");
		
		if(jsClickUsingID(driver, "btn_Submit")) {

			reportStep(logger, "Successfully clicked on the submit in all cashback page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the submit in all cashback page", "FAIL");
		}
		
	}
	
	public void validateSuccessMessage(WebDriver driver) {

		if(validateTheElementPresence(driver, successMessage)) {

			reportStep(logger, "Successfully validated success message after submitting cashback form", "PASS");
		}else {

			reportStep(logger, "Not able to validate success message after submitting cashback form", "FAIL");
		}
		
	}
	
	public void clickSaveCashbackUsingAppium(WebDriver driver) {

		reportStep(logger, "About to click on Save Cashback Using Appium ", "INFO");
		
		if(clickAfterWait(driver, saveCashback)) {

			reportStep(logger, "Successfully clicked on the  Save Cashback ", "PASS");
		}else {

			reportStep(logger, "Not able to click on the Save Cashback at cashback page", "FAIL");
		}
		
	}

	public void clickClear(WebDriver driver) {

		reportStep(logger, "About to click clear in all cashback page", "INFO");
		
		if(jsClickUsingID(driver, "btn_Clear")) {

			reportStep(logger, "Successfully clicked on the clear in all cashback page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the clear in all cashback page", "FAIL");
		}
		
	}

	public void clickAddNewButton(WebDriver driver) {
		
	reportStep(logger, "About to click add new button", "INFO");
	
	if(jsClickUsingID(driver, "anc_AddNew")) {

		reportStep(logger, "Successfully clicked add new button in AllCashbackPage", "PASS");
	}else {

		reportStep(logger, "Not able to click add new button in AllCashbackPage", "FAIL");
	}

	
	}

	public void enterExitId(WebDriver driver, String exitId) {

		reportStep(logger, "About to enter exitId in keyword text box", "INFO");

		if(enterTextInChrome(exitIDTextbox, exitId)) {

			reportStep(logger, "Successfully entered exitId "+exitId+" in exitId text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter exitId "+exitId+" in exitId text box", "FAIL");
		}
		
	}
	
	public void entertransactionId(WebDriver driver, String transactionId) {

		reportStep(logger, "About to enter transactionId in transactionId text box", "INFO");

		if(enterTextInChrome(transactionIdTextbox, transactionId)) {

			reportStep(logger, "Successfully entered transactionId "+transactionId+" in transactionId text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter transactionId "+transactionId+" in transactionId text box", "FAIL");
		}
		
	}
	
	public void enterOrderId(WebDriver driver, String orderId) {

		reportStep(logger, "About to enter orderId in orderId text box", "INFO");

		if(enterTextInChrome(orderIdTextbox, orderId)) {

			reportStep(logger, "Successfully entered orderId "+orderId+" in orderId text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter orderId "+orderId+" in orderId text box", "FAIL");
		}
		
	}

	public void enterOrderValue(WebDriver driver, String orderValue) {

		reportStep(logger, "About to enter orderValue in orderValue text box", "INFO");

		if(enterTextAfterClick(driver, orderValueTextbox, orderValue)) {


			reportStep(logger, "Successfully entered orderValue "+orderValue+" in orderValue text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter orderValue "+orderValue+" in orderValue text box", "FAIL");
		}
		
	}

	public void enterconfirmCommisionNetwork(WebDriver driver, String confirmCommisionNetwork) {

		reportStep(logger, "About to enter confirmCommisionNetwork in confirmCommisionNetwork text box", "INFO");

		if(enterTextInChrome(confirmCommisionNetworkTextbox, confirmCommisionNetwork)) {

			reportStep(logger, "Successfully entered confirmCommisionNetwork "+confirmCommisionNetwork+" in confirmCommisionNetwork text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter confirmCommisionNetwork "+confirmCommisionNetwork+" in confirmCommisionNetwork text box", "FAIL");
		}
		
	}

	public void entercashback(WebDriver driver, String cashback) {

		reportStep(logger, "About to enter cashback in cashback text box", "INFO");

		if(enterTextInChrome(cashbackTextbox, cashback)) {

			reportStep(logger, "Successfully entered orderValue "+cashback+" in cashback text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter orderValue "+cashback+" in cashback text box", "FAIL");
		}
		
	}

	public void selectCashbackTypeFromDropDown(WebDriver driver, String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");

		if(selectValuesFromDropdown(cashbackTypeDropDown, dropDownValue)) {
		
		reportStep(logger, "Successfully selected value "+dropDownValue+" from the dropdown", "PASS");
		}else {
		
		reportStep(logger, "Not able to select value "+dropDownValue+" from dropdown", "FAIL");
		}
	}
	
	public void selectStatusFromDropDown(WebDriver driver, String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");

		if(selectValuesFromDropdown(statusDropDown, dropDownValue)) {
		
		reportStep(logger, "Successfully selected value "+dropDownValue+" from the dropdown", "PASS");
		}else {
		
		reportStep(logger, "Not able to select value "+dropDownValue+" from dropdown", "FAIL");
		}
	}

	public void enterDetails(WebDriver driver, String details) {

		reportStep(logger, "About to enter details in details text box", "INFO");

		if(enterTextInChrome(detailsTextbox, details)) {

			reportStep(logger, "Successfully entered details "+details+" in details text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter details "+details+" in details text box", "FAIL");
		}
		
	}

	public void setOrderDate(WebDriver driver) {
		
	reportStep(logger, "About to set OrderDate", "INFO");


	try {

		System.out.println("In try block about to set OrderDate");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("order_date")));
			
	} catch (Exception e) {

		System.out.println("In catch block not able to set OrderDate");
	}
	
	String date = Utils.setCurrentDate();
	
	((JavascriptExecutor)driver).executeScript("document.getElementById('order_date').setAttribute('value', '"+date+"')");
	
	reportStep(logger, "Successfully set OrderDate", "INFO");
	
	}
	
	public void setPendingDate(WebDriver driver) {
		
	reportStep(logger, "About to set PendingDate", "INFO");


	try {

		System.out.println("In try block about to set PendingDate");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pending_date")));
			
	} catch (Exception e) {

		System.out.println("In catch block not able to set PendingDate");
	}
	
	String date = Utils.setCurrentDate();
	
	((JavascriptExecutor)driver).executeScript("document.getElementById('pending_date').setAttribute('value', '"+date+"')");
	
	reportStep(logger, "Successfully set PendingDate", "INFO");
	
	}
	
	public void setConfirmDate(WebDriver driver) {
		
	reportStep(logger, "About to set ConfirmDate", "INFO");


	try {

		System.out.println("In try block about to set ConfirmDate");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirm_date")));
			
	} catch (Exception e) {

		System.out.println("In catch block not able to set ConfirmDate");
	}
	
	String date = Utils.setCurrentDate();
	
	((JavascriptExecutor)driver).executeScript("document.getElementById('confirm_date').setAttribute('value', '"+date+"')");
	
	reportStep(logger, "Successfully set ConfirmDate", "INFO");
	
	}
	
	public void setFailDate(WebDriver driver) {
		
	reportStep(logger, "About to set FailDate", "INFO");


	try {

		System.out.println("In try block about to set FailDate");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fail_date")));
			
	} catch (Exception e) {

		System.out.println("In catch block not able to set FailDate");
	}
	
	String date = Utils.setCurrentDate();
	
	((JavascriptExecutor)driver).executeScript("document.getElementById('fail_date').setAttribute('value', '"+date+"')");
	
	reportStep(logger, "Successfully set FailDate", "INFO");
	
	}

	public void clickEdit(WebDriver driver) {

		reportStep(logger, "About to click edit in all cashback page", "INFO");
		
		if(jsClickByXpath(driver, buttonEdit)) {

			reportStep(logger, "Successfully clicked on the edit in all cashback page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the edit in all cashback page", "FAIL");
		}
		
		if(isElementVisibleByXpathPresent(driver, exitIDTextBox)) {

			reportStep(logger, "Successfully validated exit ID text box presence", "PASS");
		}else {

			reportStep(logger, "Not able to validate exit ID text box presence", "FAIL");
		}
		
	}

	public String getCashbackID(WebDriver driver) {

		reportStep(logger, "About to get cashback ID", "INFO");

		String cashbackid = getText(driver, cashbackID);

		reportStep(logger, "Successfully got cashback ID: "+cashbackid, "INFO");
				
		return cashbackid;
		 
	}

	public String getCashbackID(WebDriver driver, String index) {

		reportStep(logger, "About to get cashback ID", "INFO");

		String cashbackid = getTextByXpath(driver, "//table[@id='all_list']/tbody/tr["+index+"]/td[2]");

		reportStep(logger, "Successfully got cashback ID: "+cashbackid, "INFO");
				
		return cashbackid;
		 
	}

	public String getTransactionID(WebDriver driver) {

		reportStep(logger, "About to get transactionID", "INFO");

		String transactionid = getText(driver, transactionID);

		reportStep(logger, "Successfully got transactionID: "+transactionid, "INFO");
				
		return StringUtils.substringAfter(transactionid.trim(), "Transaction ID:");
		 
	}

}