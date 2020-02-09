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

public class NetworkStoreDomainMapping extends WrapperMethods {

	/*
	 *  Author : Mallikarjunaswamy 
	 *  Title  : NetworkDomain setting in admin - Make link end point settings
	 * 	
	 * 
	 * 
	 * 
	 * 
*/
	/*
	 * Follwing are the shorten URL domains - go through the official sites for more info
	 * 
		bitly.com =https://bitly.com/
		tiny.cc = https://tiny.cc/
		bit.do = https://bit.do/
		rebrand.ly/d93d5 = https://app.rebrandly.com/links
		http://j.mp/2VvtbN0 = https://smallseotools.com/url-shortener/
		goo.gl = Not supported
		t2m.io = https://t2m.io
		tinyurl.com = https://tinyurl.com 
		https://bit.ly/2KjvdPh
*/	
	
	
	//Constructor creation :
	public NetworkStoreDomainMapping(WebDriver driver, ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Element creation:

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Network Store Domain Mapping')])[1]") 
	WebElement networkStoreDomain;

	@FindBy(how = How.ID, using = "btn_Tools") 
	WebElement toolButton;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Update Shorten URL Domains']") 
	WebElement updateShortenURL;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='btn_Tools']/li/a") 
	WebElement buttonTools;
	
	@FindBy(how = How.ID, using = "shorten_url_domains") 
	WebElement updateShortenURLTextArea;
	
	@FindBy(how = How.XPATH, using = "//button[@id='btn_Submit'][text()='Submit']") 
	WebElement submitButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='domainurl']") 
	WebElement domainURLField;

	@FindBy(how = How.XPATH, using = "//button[@id='btn_Submit'][text()='Search']") 
	WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//td[text()='AppiumMakeLinkStore']") 
	WebElement searchResultsStoreName;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Please try different search criteria.']") 
	WebElement searchResultsErrorMessage;
	
	//Method creations :
	public void clickOnNetworkDomainMapping() {
		
		reportStep(logger, "About to click submenu stores in admin homepage", "INFO");

		if(jsClickUsingID(driver, "SubMenu_NetworkStoreDomainMapping")) {
			
			reportStep(logger, "Successfully clicked on the Network Store Domain Mapping  ", "PASS");
			
		}else {
			reportStep(logger, "Failed to click on the Network Store Domain Mapping ", "FAIL");
		}

		
	}

	public void clickOnToolsButton() {
		
		reportStep(logger, "About to click on the Tools button to select Shorten URL Domain ", "INFO");
		
		if(jsClickUsingXpath(driver, buttonTools)){
			
			reportStep(logger, "Successfuly clicked on the Tools button ", "PASS");
			
		}else {
			
			reportStep(logger, "Failed to click on the Tools button ", "FAIL");
		}
		
	}

	public void clickOnUpdateShortenURLDomain() {
		
		reportStep(logger, "About to click on the Update Shorten URL Domain", "INFO");
		
		if(jsClickUsingXpath(driver, updateShortenURL)){
			
			reportStep(logger, "Successfully clicked on the Update Shorten URL Domains", "PASS");
		}else {
			
			reportStep(logger, "Failed to click on the Update Shorten URL Domains", "FAIL");
		}
	}
	
	public void enterShortenURL(String shortenURL) {
		
		reportStep(logger, "About to enter the Shorten URLs to the Domain URL text area", "INFO");
		
		if (enterTextInChrome(updateShortenURLTextArea, shortenURL)) {
			
			reportStep(logger, "Successfully entered or Updates the shorten URLS as " + shortenURL, "PASS");
			
		}else {
			
			reportStep(logger, "Failed to enter or Update the shorten URLS as " +  shortenURL, "Fail");
		}
		
	}
	
	public void clickOnSubmit() {
		
		reportStep(logger, "Successfully clicked on Submit button ", "INFO");
		
		if(clickAfterWait(driver, submitButton)) {
			
			reportStep(logger, "Successfully clicked on Submit button ", "PASS");
			
		}else {
			
			reportStep(logger, "Failed to click on Submit buttno  ", "FAIL");
		}
	}

	public void validateShortenURLSuccessMessage() {
		
		reportStep(logger, "About validate the Success message once after Config the Shorten URLS", "INFO");
		
		isElementLocatedByXpathPresent("//div[text()='Shorten URL domains has been successfully updated.']");
		
		reportStep(logger, "Successfully config the Shorten URLS", "INFO");
		
	}
	
	public void enterDomainURLForSearch(String domainURL) {
		
		reportStep(logger, "About to enter the Domain URL "+  domainURL +  " to Search  Network Store Domain Mapping", "INFO");
		
		if(enterTextInChrome(domainURLField, domainURL)){
			
			reportStep(logger, "Successfully entered the Domain URL as : " + domainURL, "PASS");
		}else {
			
			reportStep(logger, "Failed to enter the Domain URL as : " + domainURL, "FAIL");
		}
		
		
	}

	public void clickOnSearchButton() {
		
		reportStep(logger, "About to click on Search Button in Network Store Domain Mapping  ", "INFO");
		
		if(clickAfterWait(driver, searchButton)) {
			
			reportStep(logger, "Successfully clicked on the Search Buttoon In the Network Store Domain Mapping ", "PASS");
		}else {
			
			reportStep(logger, "Failed to click on the Search Buttoon In the Network Store Domain Mapping ", "FAIL");
		}
	}

	public void verifySearchDomainIsAvailable() {

		reportStep(logger, "About to vlaidate the Searched Domain is Available or Not  ", "INFO");

		if(validateTheElementPresence(driver, searchResultsStoreName)) {

			reportStep(logger, "Success - Requied Domain : appium.io - Which is required test data is available ", "PASS");

		}else {
			
			if(validateTheElementPresence(driver, searchResultsErrorMessage)) {
				
				reportStep(logger, "Fail - Requied Domain : appium.io - Which is required test data is not available - Might be Test Data issue"
								+ " Plz, Set the set data Properly , before you run this test case ", "FAIL");
			}else {
				
				reportStep(logger, "Fail - Check in the admin manually  ", "FAIL");
				
			}

			
		}
		
	}

	

}
