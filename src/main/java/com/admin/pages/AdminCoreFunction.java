package com.admin.pages;

import java.util.List;

import org.omg.CosNaming.IstringHelper;
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

public class AdminCoreFunction extends WrapperMethods {

	public AdminCoreFunction(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
	
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(how = How.ID, using = "username") 
	WebElement adminUserNameTextBox;

	@FindBy(how = How.ID, using = "password") 
	WebElement adminPasswordTextBox;

	@FindBy(how = How.ID, using = "btn_Submit") 
	WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//h3[text()='Welcome Development']") 
	WebElement welComeDevText;

	@FindBy(how = How.XPATH, using = "(//span[text()='Stores'])[2]") 
	WebElement submenuStores;						

	@FindBy(how = How.ID, using = "SubMenu_Vouchers") 
	WebElement submenuVouchers;

	@FindBy(how = How.XPATH, using = "(//span[text()='Stores'])[1]") 
	WebElement menuStores;

	@FindBy(how = How.ID, using = "MainMenu_Users") 
	WebElement menuUsers;						

	@FindBy(how = How.ID, using = "SubMenu_Users") 
	WebElement subMenuUsers;						

	@FindBy(how = How.ID, using = "SubMenu_ProductBrowserEditMode") 
	WebElement submenuProductBrowserEdit;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Product Feeds')]") 
	WebElement menuProductFeed;

	@FindBy(how = How.ID, using = "MainMenu_Settings") 
	WebElement menuSettings;

	@FindBy(how = How.ID, using = "SubMenu_PartnerSettings") 
	WebElement menuParterSettings;
	@FindBy(how = How.ID, using = "partnerEdit_6") 
	WebElement editPartner;
	@FindBy(how = How.ID, using = "SubMenu_AffiliateNetworks") 
	WebElement menuAffliateNetworks;
	@FindBy(how = How.XPATH, using = "//textarea[@id='productCashbackUrl']") 
	WebElement productURLTextArea;
	@FindBy(how = How.ID, using = "btn_Submit") 
	WebElement editNetwork;
	@FindBy(how = How.XPATH, using = "//span[text()='Cashback']") 
	WebElement menuCashback;
	@FindBy(how = How.XPATH, using = "//div[@id='adminMessageSuccess']") 
	WebElement netWorkEditSuccessMessage;

	//Exit id page : 
	@FindBy(how = How.XPATH, using = "//span[contains(.,'Reports')]") 
	WebElement reports;
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Exit Clicks')]") 
	WebElement exitClicks;
	@FindBy(how = How.XPATH, using = "//select[@id='sby']") 
	WebElement exitClickPagesearchByDropdown;
	@FindBy(how = How.XPATH, using = "//input[@id='sterm']") 
	WebElement exitClickPagesearchKeyword;
	@FindBy(how = How.XPATH, using = "//button[@id='btn_Submit']") 
	WebElement exitClickPageSubmitButton;
	@FindBy(how = How.XPATH, using = "//table[@id='all_list']") 
	WebElement resultTableOfExitID;
	
	//Email master :
	@FindBy(how = How.XPATH, using = "//select[@id='searchBy']") 
	WebElement emailMasterSearchByDropDown;

	@FindBy(how = How.XPATH, using = "//input[@id='key']") 
	WebElement searchKey;

	@FindBy(how = How.ID, using = "btnSubmit") 
	WebElement searchButton;

	@FindBy(how = How.ID, using = "MainMenu_EmailMaster") 
	WebElement emailMasterMainMenu;

	@FindBy(how = How.ID, using = "SubMenu_EmailMasterBrowser") 
	WebElement emailMasterBrowserSubMenu;

	//EarnKaro admin drop down  :
	
	@FindBy(how = How.XPATH, using = "//select[@id='partnerdomain']") 
	WebElement selectEarnKaro;
	
	//Missing Cashaback
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'Interactive')]") 
	WebElement interActive;
	@FindBy(how = How.XPATH, using = "//a[@id='SubMenu_UserTickets']") 
	WebElement subMenuUserTickets;
	@FindBy(how = How.XPATH, using = "//a[@id='SubMenu_Testimonials']") 
	WebElement subMenuTestimonials;

	String earnkaroLogo = "//img[contains(@src,'earnkaro')]";

	
	public void enterUsername(String username) {

		reportStep(logger, "About to enter username in admin login page", "INFO");


		if(enterTextInChrome(adminUserNameTextBox, username)) {

			reportStep(logger, "Successfully entered username "+username+" in text box", "PASS");

		}else {

			reportStep(logger, "Not able to enter username "+username+" in text box", "FAIL");
		}
	}

	public void enterPassword(String password) {

		reportStep(logger, "About to enter password in admin page", "INFO");

		//Enter the password
		if(enterTextInChrome(adminPasswordTextBox, password)) {

			reportStep(logger, "Successfully entered pwd "+password+" in text box", "PASS");
		}else {

			reportStep(logger, "Not able to enter pwd "+password+" in text box", "FAIL");
		}
	}

	public void clickSubmit(){

		reportStep(logger, "About to click submit button after filling the form in admin page", "INFO");
		
		try {

			if(clickAfterWait(driver, submitButton)) {

				reportStep(logger, "Successfully clicked on the submit button", "PASS");
			}else {

				reportStep(logger, "Not able to click the submit button", "FAIL");
			}
			
			validateTheElementPresence(driver, welComeDevText);
			
		} catch (Exception e) {

			if(clickAfterWait(driver, submitButton)) {

				reportStep(logger, "Successfully clicked on the submit button", "PASS");
			}else {

				reportStep(logger, "Not able to click the submit button", "FAIL");
			}
			
			validateTheElementPresence(driver, welComeDevText);
		}
	}

	public void clickStoresMenu() {

		reportStep(logger, "About to click menu stores in admin homepage", "INFO");

		//Click stores menu button
		if(clickAfterWait(driver, menuStores)) {

			reportStep(logger, "Successfully clicked on the menu stores", "PASS");
		}else {

			reportStep(logger, "Not able to click the menu stores", "FAIL");
		}

	}

	public void clickStoresSubMenu() {

		reportStep(logger, "About to click submenu stores in admin homepage", "INFO");

		jsClickUsingID(driver, "SubMenu_Stores");

		reportStep(logger, "Successfully clicked submenu stores in admin homepage", "INFO");

	}

	public void clickVouchersSubMenu() {

		reportStep(logger, "About to click submenu voucher in admin homepage", "INFO");

		jsClickUsingID(driver, "SubMenu_Vouchers");

		reportStep(logger, "Successfully clicked submenu vouchers in admin homepage", "INFO");

	}

	public void clickPendingCashoutsSubMenu() {

		reportStep(logger, "About to click submenu PendingCashouts in admin homepage", "INFO");
		
		if (isElementLocatedByIDPresent(driver, "SubMenu_PendingCashouts")) {
			
			reportStep(logger, "Validated submenu PendingCashouts presence in admin homepage", "PASS");
			
		} else {
			
			reportStep(logger, "Not able to validate submenu PendingCashouts presence in admin homepage", "FAIL");

		}

		jsClickByID(driver, "SubMenu_PendingCashouts");
		
		reportStep(logger, "Successfully clicked submenu PendingCashouts in admin homepage", "INFO");

	}

	public void clickProductFeedMenu() {

		reportStep(logger, "About to click menu product feed in admin homepage", "INFO");

		//Click stores menu button
		if(clickAfterWait(driver, menuProductFeed)) {

			reportStep(logger, "Successfully clicked on the menu product feed", "PASS");
		}else {

			reportStep(logger, "Not able to click the menu product feed", "FAIL");
		}

	}

	public void clickProductBrowserEditModeSubMenu() {

		reportStep(logger, "About to click submenu product browser edit mode in admin homepage", "INFO");

		//Click stores menu button
		if(clickAfterWait(driver, submenuProductBrowserEdit)) {

			reportStep(logger, "Successfully clicked on the submenu product browser edit mode", "PASS");
		}else {

			reportStep(logger, "Not able to click the submenu product browser edit mode", "FAIL");
		}

	}

	public void clickOnSettings() {

		reportStep(logger, "About to click on the menu Settings in the admin ", "INFO");

		if(clickAfterWait(driver, menuSettings)) {

			reportStep(logger, "successfully clicked on the menu settings in Admin ", "PASS");

		}else {

			reportStep(logger, "Not able to clicked on the menu settings in Admin ", "FAIL");
		}


	}

	public void clickOnAffiliateNetworks() {

		reportStep(logger, "About to click on the Affilitate Networks  ", "INFO");

		if(jsClickUsingXpath(driver, menuAffliateNetworks)) {

			reportStep(logger, "successfully clicked on the Affiliate Networks ", "PASS");

		}else {

			reportStep(logger, "Failed - Not able to click on Affiliate Networks ", "FAIL");
		}


	}
	
	public void editTheAffiliateNetwork(String networkName) {
		
		reportStep(logger, "About to edit the Affliate Network : "+ networkName, "INFO");
		
		String networkEditLink = "//td[text()='"+networkName+"']/following-sibling::td[4]/a[1]";
		
		isElementLocatedByXpathPresent(networkEditLink);
		
		WebElement element = driver.findElement(By.xpath(networkEditLink));
		
		if(click(driver, element)) {
			
			reportStep(logger, "Successfully click on the Edit Button for the network : "+ networkName, "PASS");
		}else {
			
			reportStep(logger, "Failed to click on the Edit Button for the network : "+ networkName, "FAIL");
		}
		
	}
	
	public void enterProductCashbackURL(String productCashbackUrl) {
		
		reportStep(logger,"About to Config the Cashback URL  as "+ productCashbackUrl, "INFO");
		
		if(enterTextInChrome(productURLTextArea, productCashbackUrl)) {
			
			reportStep(logger, "Successfully Entered the ProductCashbackURL in to the Text Area as : "+ productCashbackUrl, "PASS");
			
		}else {
			reportStep(logger, "Failed to Enter the ProductCashbackURL in to the Text Area as : "+ productCashbackUrl, "FAIL");
		}
		
	}
	
	public void clickOnSubmitButton() {
		
		reportStep(logger, "About to click on the Edit Network Button  ", "INFO");
		
		if(clickAfterWait(driver, editNetwork)) {
			
			reportStep(logger, "Successfully clicked on the Edit Network button -  ", "PASS");
		} else {
			
			reportStep(logger, "Failed to click on the EDit Network button", "FAIL");
		}
		
	}
	
	public void successMessageValidation() {
		
		reportStep(logger, "About to vaidate the Success Message - Once after editing the Network ", "INFO");
		validateTheElementPresence(driver, netWorkEditSuccessMessage);
		
	}
	
	public void clickOnPartnerSettings() {

		reportStep(logger, "About to click on the Partner Settings in the admin ", "INFO");

		if(clickAfterWait(driver, menuParterSettings)) {

			reportStep(logger, "Successfully clicked on the Partner settings in Admin ", "PASS");

		} else {

			reportStep(logger, "Failed - Not able to clicked on the Partner settings in Admin ", "FAIL");
		}
	}
	
	public void clickOnEditPartner() {

		reportStep(logger, "About to click on the edit Partner ", "INFO");

		if(clickAfterWait(driver, editPartner)) {

			reportStep(logger, "Successfully clicked on edit Partner ", "PASS");

		} else {

			reportStep(logger, "Failed to  click on edit Partner  ", "FAIL");
		}
	}

	public void clickCashbackMenu(WebDriver driver) {

		reportStep(logger, "About to click menu cashback in admin homepage", "INFO");

		//Click csashback menu button
		if(clickAfterWait(driver, menuCashback)) {

			reportStep(logger, "Successfully clicked on the menu cashback", "PASS");
		}else {

			reportStep(logger, "Not able to click the menu cashback", "FAIL");
		}

	}

	public void clickOnReports(WebDriver driver) {

		reportStep(logger, "About to click on Reports Main menu from the Admin ", "INFO");

		if (clickAfterWait(driver, reports)) {

			reportStep(logger, "Successfully clicked on the reports menu from Exit click page ", "PASS");
		}else {

			reportStep(logger, "Failed to click on the reports menu from Exit click page ", "FAIL");
		}

	}

	public void clickOnExitClick(WebDriver driver) {

		reportStep(logger, "About to click on the Report's main menu -> Exit click sub menu", "INFO");

		if (clickAfterWait(driver, exitClicks)) {

			reportStep(logger, "Successfully clicked on the Exit click sub menu from Exit click page ", "PASS");
		}else {

			reportStep(logger, "Failed to click on the reports Exit click sub menu from Exit click page ", "FAIL");
		}


	}

	public void selectSearchByEmailFromExitClickPage() {

		reportStep(logger, "About to select the Search by drop down from the exit click page ", "INFO");

		selectValuesFromDropdown(exitClickPagesearchByDropdown, "User Email");
	}

	public void enterSearchKeywordFromExitClickPage(String email) {

		reportStep(logger, "About to enter the Search keyword from the exit click page ", "INFO");

		if (enterTextInChrome(exitClickPagesearchKeyword, email)) {

			reportStep(logger, "Successfully entered the text : "+ email + " to the Search keyword field ", "PASS");

		}else {

			reportStep(logger, "Failed to  enter the text : "+ email + " to the Search keyword field at Admin Exit click page  ", "FAIL");

		}
	}

	public void clickOnSearchButtonFromExitClickPage() {

		reportStep(logger, "About to click on the Search button from the exit click page  ", "INFO");

		if (clickAfterWait(driver, exitClickPageSubmitButton)) {

			reportStep(logger, "Successfully clicked on the Search button at the Admin Exit click page ", "PASS");

		}else {

			reportStep(logger, "Failed to click on the Search button at the Admin Exit click page ", "FAIL");
		}

	}

	public String extractExitClickFromTable() {

		if(waitTillElementPresence(driver, resultTableOfExitID)) {

			reportStep(logger, "Exit click results table is present ", "INFO");

		}else {

			reportStep(logger, "Exit click results table is not present - Once after clicking on the Search button from the exit click page ", "FAIL");

		}

		reportStep(logger, "About to extract the exit click id from the RESULT TABLE ", "INFO");

		String exitClickId = driver.findElement(By.xpath("((//tr)[3]/td)[1]")).getText();

		System.out.println("exit click id is " +  exitClickId );
		
		reportStep(logger, "Successfully got the Exit Click Id As ", exitClickId);

		return exitClickId;


	}

	public void clickOnInteractiveMainMenu() {
		
		reportStep(logger, "About to click on the Interactive Main menu at the Admin page ", "INFO");
		
		if (clickAfterWait(driver, interActive)) {
			
			reportStep(logger, "Successfully clicked on the Interactive Main menu at the Admin ", "PASS");
			
		}else {
			
			reportStep(logger, "Failed to  click on the Interactive Main menu at the Admin", "FAIL");
			
		}
		
	}
	
	public void clickOnsubMenuUserTickets() {

		reportStep(logger, "About to click on the subMenuUserTickets Main menu at the Admin page ", "INFO");

		if (jsClickByID(driver, "SubMenu_UserTickets")) {

			reportStep(logger, "Successfully clicked on the subMenuUserTickets Main menu at the Admin ", "PASS");

		}else {

			reportStep(logger, "Failed to  click on the SUB Menu UserTickets at the Admin", "FAIL");

		}
		
		if (isElementVisibleByIDPresent(driver, "UserTickets")) {

			reportStep(logger, "Validate presence of user ticket bread crumb", "PASS");

		}else {

			reportStep(logger, "Failed to validate presence of user ticket bread crumb", "FAIL");

		}

	}

	public void clickOnSubMenuTestimonials() {

		reportStep(logger, "About to click on the subMenu -  Testimonials  ", "INFO");

		if (clickAfterWait(driver, subMenuTestimonials)) {

			reportStep(logger, "Successfully clicked on subMenu -  Testimonials ", "PASS");

		}else {

			reportStep(logger, "Failed to  click on the subMenu -  Testimonials", "FAIL");

		}
		
		if (isElementVisibleByIDPresent(driver, "AllTestimonials")) {

			reportStep(logger, "Validate presence of AllTestimonials bread crumb", "PASS");

		}else {

			reportStep(logger, "Failed to validate presence of AllTestimonials bread crumb", "FAIL");

		}

	}
	
	public void clickUsersMenu() {

		reportStep(logger, "About to click menu users in admin homepage", "INFO");

		//Click stores menu button
		if(clickAfterWait(driver, menuUsers)) {

			reportStep(logger, "Successfully clicked on the menu users", "PASS");
		}else {

			reportStep(logger, "Not able to click the menu users", "FAIL");
		}

	}

	public void clickUsersSubMenu() {

		reportStep(logger, "About to click submenu users in admin homepage", "INFO");

		//Click stores menu button
		if(clickAfterWait(driver, subMenuUsers)) {

			reportStep(logger, "Successfully clicked on the submenu users", "PASS");
		}else {

			reportStep(logger, "Not able to click the submenu users", "FAIL");
		}

	}

	/*It clicks on the Email Master*/
	public void clickOnEmailMaster() {
		
		reportStep(logger, "About to click on the Email master - Main menu ", "INFO");
		
		if(clickAfterWait(driver, emailMasterMainMenu)) {
			
			reportStep(logger, "Successfully clicked on the Email Master - Main Menu ", "PASS");
		} else {
			
			reportStep(logger, "Failed to click on the Email Master - Main Menu", "FAIL");
		}
		
	}

	/*It clicks on the Email Master Browser*/
	public void clickOnEmailMasterBrowser() {
		
		reportStep(logger, "About to click on the Email master Browser - Main menu ", "INFO");
		
		if(clickAfterWait(driver, emailMasterBrowserSubMenu)) {
			
			reportStep(logger, "Successfully clicked on the Email Master Browser - Main Menu ", "PASS");
		} else {
			
			reportStep(logger, "Failed to click on the Email Master  Browser- Main Menu", "FAIL");
		}
		
	}

	/*It clicks on the Email Master Browser*/
	public void selectEmailFromSearchByDropDown_EmailMaster() {
		
		reportStep(logger, "Select Email from the Search By drop down ", "INFO");
		selectValuesFromDropdown(emailMasterSearchByDropDown, "Email");
		
	}

	/*Enter User Email to search */
	public void enterUserEmailAsKeyForSearchEmailMaster(String value) {
		
		reportStep(logger, "About to enter the User Email to search the user" + value, "INFO");
		
		if(enterTextInChrome(searchKey,value)) {
			reportStep(logger, "Failed to enter search Key Email  as " + value, "PASS");
			
		} else {
			
			reportStep(logger , "Failed to enter the search key Email Value as : " + value, "FAIL");
			
		}
		
		
		
		
	}

	/*click on Search button*/
	public void clickOnSearchButtonEmailMaster() {

		reportStep(logger, "About to click on the Search Button ", "INFO");

		if(clickAfterWait(driver, searchButton)) {

			reportStep(logger, "Successfully clicked on the Search Button - Email Master", "PASS");
		} else {

			reportStep(logger, "Failed to click on the Search Button ", "FAIL");
		}

	}

}