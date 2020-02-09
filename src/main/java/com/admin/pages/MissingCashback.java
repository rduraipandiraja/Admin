package com.admin.pages;

import org.openqa.selenium.By;
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

public class MissingCashback extends WrapperMethods {
	
	public MissingCashback(WebDriver driver, ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@FindBy(how = How.XPATH, using = "//select[@id='sby']") 
	WebElement searchByDropDown;
	
	@FindBy(how = How.XPATH, using = "//button[@id='btn_Submit']") 
	WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='reply']") 
	WebElement amdinReplyTextField;
	
	String adminreply = "//textarea[@id='reply']";
	
	@FindBy(how = How.XPATH, using = "//button[@id='btn_Submit']") 
	WebElement submitButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='key']") 
	WebElement keyword;
	
	String keyWord = "//input[@id='key']";
	
	@FindBy(how = How.ID, using = "status") 
	WebElement ticketStatusDropDown;

	String successMessage = "//div[@id='adminMessageSuccess']";
	
	public void selectSearchbyExitClickIDFromDropDown() {

		reportStep(logger, "About to select the Search by drop down from the Missing Cashback  page ", "INFO");

		selectValuesFromDropdown(searchByDropDown, "Exit ID");

	}
	
	public void selectTicketStatus(String visibleTextForTicketStatus) {

		reportStep(logger, "About to select the Search by drop down from the Missing Cashback  page ", "INFO");

		selectValuesFromDropdown(ticketStatusDropDown, visibleTextForTicketStatus);

	}
	
	public void enerKeyWord(String exitClickID) {

		reportStep(logger, "About to enter exitClickID: "+exitClickID+" at the Admin missing casbhack page  ", "INFO");

		if (isElementLocatedByXpathPresent(keyWord)) {
			
			reportStep(logger, "Validated keyWord element presence - user ticket page", "PASS");
			
		}else {
			
			reportStep(logger, "Not able to Validate keyWord element presence - user ticket page", "FAIL");
		}

		if (enterTextAfterClick(driver, keyword, exitClickID)) {
			
			reportStep(logger, "Successfully entered the Exit click id as keyword ", "PASS");
			
		}else {
			reportStep(logger, "Failed to entered the Exit click id as keyword ", "FAIL");
			
		}
		

	}

	public void clickOnSearchButton() {

		reportStep(logger, "About to click on the Search button at the Missing Cashback ticket admin page", "INFO");

		if (clickAfterWait(driver, searchButton)) {

			reportStep(logger, "Successfully clicked on the Search button from the Missing Cashback Page ", "PASS");
		}else {

			reportStep(logger, "Failed to click on the Search button from the Missing Cashback Page ", "FAIL");
		}

	}

	public void clickOnEditButton(String strExitClick_Value) {

		reportStep(logger, "About to fetch the Ticket ID from the Missing cashback ticket page at admin ", "INFO");

		String xpath = "(//td[@title='"+strExitClick_Value+"']/following::td/a[@class='fa fa-edit'])[1]" ;

		if (isElementLocatedByXpathPresent(xpath)) {
			
			reportStep(logger, "Validated edit button element presence - user ticket page", "PASS");
			
		}else {
			
			reportStep(logger, "Not able to Validate edit button element presence - user ticket page", "FAIL");
		}

		if (jsClickByXpath(driver, xpath)) {
			
			reportStep(logger, "Successfully clicked on the Edit button to write the Ticket admin reply - user ticket page", "PASS");
			
		}else {
			
			reportStep(logger, "FAIL to  click on the Edit button to write the Ticket admin reply - user ticket page", "FAIL");
		}

		if (isElementVisibleByIDPresent(driver, "ViewUserTicket")) {
			
			reportStep(logger, "Successfully redirected to view user ticket", "PASS");
			
		}else {
			
			reportStep(logger, "FAIL to redirect to view user ticket", "FAIL");
		}
	


	}
	
	public String fetchTicketID(String strExitClick_Value) {

		reportStep(logger, "About to fetch the Ticket ID from the Missing cashback ticket page at admin ", "INFO");

		String xpath = "//td[@title='" + strExitClick_Value + "']/../td[2]" ;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}catch (Exception e) {

			reportStep(logger, "Excetption occured during the locating the xpath //td[@title=' + strExitClick_Value + ']/../td[2] to find the Ticket id", "PASS");
		}

		WebElement ele = driver.findElement(By.xpath(xpath));

		return getText(driver, ele);


	}

	public void enterAdminReply(String adminReply) {

		reportStep(logger, "About to enter the Admin Reply at the Missing Cashback page  ", "INFO");

		if (isElementLocatedByXpathPresent(adminreply)) {
			
			reportStep(logger, "Validated adminReply element presence - user ticket page", "PASS");
			
		}else {
			
			reportStep(logger, "Not able to Validate adminReply element presence - user ticket page", "FAIL");
		}

		if(enterTextInChrome(amdinReplyTextField, adminReply)) {

			reportStep(logger, "Successfully entered the admin reply as : "+ adminReply, "PASS");
		}else {

			reportStep(logger, "Failed entered the admin reply as : "+ adminReply, "FAIL");
		}


	}

	public void clickOnSubmitButton() {

		reportStep(logger, "About to click on the Submit button at the Missing Cashback ticket admin page", "INFO");

		if (jsClickByID(driver, "btn_Submit")) {

			reportStep(logger, "Successfully clicked on the Submit button from the Missing Cashback Page ", "PASS");
		}else {

			reportStep(logger, "Failed to click on the Submit button from the Missing Cashback Page ", "FAIL");
		}
		
		if(isElementLocatedByXpathPresent(successMessage)) {
			
			reportStep(logger, "Validated success message - user ticket page", "PASS");
			
		}else {
			
			reportStep(logger, "Not able to validate success message - user ticket page", "FAIL");
		}

	}

	public void clickClear(WebDriver driver) {

		reportStep(logger, "About to click clear in user ticket page", "INFO");
		
		if(jsClickUsingID(driver, "btn_Clear")) {

			reportStep(logger, "Successfully clicked on the clear in user ticket page", "PASS");
		}else {

			reportStep(logger, "Not able to click on the clear in user ticket page", "FAIL");
		}
		
	}


}
