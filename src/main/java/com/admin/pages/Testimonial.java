package com.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.admin.base.WrapperMethods;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Testimonial extends WrapperMethods {

	public Testimonial(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	private String searchByDropDwonXpath = "//select[@id='sby']";
	private String statusDropDwonXpath = "//select[@id='status']";
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='tsearch']") 
	WebElement keywordField;
	
	@FindBy(how = How.XPATH, using = "//button[@id='btn_Submit']") 
	WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='title']") 
	WebElement titleField;
	
	@FindBy(how = How.XPATH, using = "//button[@id='btn_Submit']") 
	WebElement submitTestimonial;
	
	@FindBy(how = How.XPATH, using = "//div[@id='adminMessageSuccess']") 
	WebElement adminSuccessMessage;
	
	String gridCell = "//table[@id='all_list']";
	
	public void selectUserEmailInSearchByDropDown() {
		
		reportStep(logger, "About to select the User Email by Search By drop down in Testimonial page ", "INFO");
		
		select_Dropdown(driver, searchByDropDwonXpath, "User Email");
		
		reportStep(logger  , "Successfully selected the User Email from the Search by drop down ", "PASS");
		
	}
	
	public void selectValueInSearchByDropDown(String dropDownValue) {
		
		reportStep(logger, "About to select the User Email by Search By drop down in Testimonial page ", "INFO");
		
		selectValuesFromDropdownUsingID(driver, "sby", dropDownValue);
		
		reportStep(logger  , "Successfully selected the User Email from the Search by drop down ", "PASS");
		
	}

	public void enterKeyWordAsUserEmail(String userEmail) {
		
		reportStep(logger, "About to enter the User email as Keyword  .. ", "INFO");
		
		if (enterTextInChrome(keywordField, userEmail)) {
			
			reportStep(logger , "Successfully entered the value as Keyword : "+ userEmail, "PASS");
			
		}else {
			
			reportStep(logger, "Failed to enter the value as keyword  :"+ userEmail, "FAIL");
		}
		
	}
	
	public void clickOnSearchButton() {
		
		reportStep(logger, "About to click on the Search button  in the Testimonials Page ", "INFO");
		
		if(clickAfterWait(driver, searchButton)) {
			
			reportStep(logger, "Sucessfully Clicked on the Search button -", "PASS");
		}else {
			
			reportStep(logger, "Failed to click on the Search Button at the Testimonial page - admin ", "FAIL");
		}
		
		if(isElementVisibleByXpathPresent(driver, gridCell)) {
			
			reportStep(logger, "Validated presence of grid cell", "PASS");
		}else {
			
			reportStep(logger, "Not able to validate grid cell", "FAIL");
		}
		
		
		
	}
	
	public void clickOnEditButtonBasedOnStarts(String userEmail,String ratings) {
		
		reportStep(logger, "About to click on the edit button based on the star rating to give approval - The user Email is : "+userEmail + "  Ratings given : " +  ratings, "INFO");
		
		userEmail = userEmail.substring(0, userEmail.indexOf("@"));
		
		String xpath = "//td[contains(text(),'"+userEmail+"')]/following-sibling::td[text()='"+ratings+"']/following-sibling::td/a[1]";
		
		isElementLocatedByXpathPresent(xpath);
		
		if(click(driver, driver.findElement(By.xpath(xpath)))){
			
			reportStep(logger, "Successfully clicked on the edit button for the User : "+ userEmail + " Ratings : " + ratings, "PASS");
		}else {
			
			reportStep(logger, "Failed to click on the edit button for the User : "+ userEmail + " Ratings : " + ratings, "FAIL");
		}
		
	}

	public void clickOnEditButton() {
		
		reportStep(logger, "About to click on the edit button", "INFO");
		
		String xpath = "(//a[@title='Edit'])[1]";
		
		isElementLocatedByXpathPresent(xpath);
		
		if(clickAfterWait(driver, driver.findElement(By.xpath(xpath)))){
			
			reportStep(logger, "Successfully clicked on the edit button", "PASS");
		}else {
			
			reportStep(logger, "Failed to click on the edit button", "FAIL");
		}
		
		if (isElementVisibleByIDPresent(driver, "EditTestimonialInfo")) {
			
			reportStep(logger, "Successfully validate edit testimonials info", "PASS");
			
		} else {
			reportStep(logger, "Failed to validate edit testimonials info", "FAIL");

		}
		
	}

	public void changeStatus(String status) {
		
		//'In-Active'  or 'Active' Should be the Status
		
		reportStep(logger, "About to Change the Status  From In Active to Active   ", "INFO");
		
		selectValuesFromDropdownUsingID(driver, "status", status);
		
		reportStep(logger, "Successfully Changed the Status from In Active to Active ", "PASS");
		
	}
	
	public void enterTitle(String value){
		
		reportStep(logger, "About to enter the Title in Testimonial page  ", "INFO");
		
		if(isElementVisibleByIDPresent(driver, "title")) {
			
			reportStep(logger, "Validate presence of title field", "PASS");
		}else {
			
			reportStep(logger, "Failed to validate presence of title field", "FAIL");
		}
		
		if(enterTextInChrome(titleField, value)) {
			
			reportStep(logger, "Successfully entered the Title as : "+ value, "PASS");
		}else {
			
			reportStep(logger, "Failed to enter the Title as : "+ value, "FAIL");
		}
		
		
	}

	public void clickOnSaveTestimonial() {
		
		reportStep(logger, "About to click on the Save Testimonial button  ", "INFO");
		
		if(click(driver, submitTestimonial)){
			
			reportStep(logger, "Successfully clicked on the Save Testimonial button - Admin ", "PASS");
			
		} else {
			
			reportStep(logger, "Failed -  Not able to click on the Save Testimonial button ", "FAIL");
		}
		
		validateTheElementPresence(driver, adminSuccessMessage);
	}

	
	
}
