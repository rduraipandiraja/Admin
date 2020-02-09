package com.admin.pages;

import com.admin.base.ConfigurationSetup;
import com.admin.base.WrapperMethods;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login extends WrapperMethods {

	public String strAdminEnvKey;
	public Select select_PatnerOption;

	/****************************************************** This is default constructor which initializes driver and will create all web element ************************/

	public Login(WebDriver driver, ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/***************************************************************** Page variable Creation started *********************************************************************/

	// Login Field's
	private String input_UserName 						= "username";
	private String input_Password 	 					= "password";
	private String button_Login 	 					= "btn_Submit";
	private String select_Partner 	 					= "partnerdomain";
	private String mainMenu_Dashboard					= "MainMenu_Dashboard";

	// Others
	private String breadcrumbDashboard					= "//span[contains(text(),'Dashboard')]";

	/***************************************************************** Methods Creation started *************************************************************************/

	/* Navigate to admin login page */
	public Login navigateAdminLoginPage(WebDriver driver) {

		reportStep(logger, "Navigating to  : " + (ConfigurationSetup.AdminURL).trim(), "INFO");

		maximizeWindow(driver);

		loadURL(driver, (ConfigurationSetup.AdminURL).trim());

		reportStep(logger, "Successfully Navigated to : " + (ConfigurationSetup.AdminURL).trim(), "PASS");

		return this;
	}

	/* Select admin drop down */
	public Login selectValueAdminDropdown(WebDriver driver, String dropdownValue) throws InterruptedException {

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, select_Partner, dropdownValue)) {

			reportStep(logger, "Successfully selected value "+dropdownValue+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+dropdownValue+" from dropdown", "FAIL");
		}
		
		Thread.sleep(2000);

		return this;
	}

	/* Enter admin Username */
	public Login enterUserName(WebDriver driver, String userName) {

		reportStep(logger, "About to enter username: "+userName+" in text field", "INFO");

		if(enterTextByIDAfterVisibility(driver, input_UserName, userName)) {

			reportStep(logger, "Successfully entered username: "+userName+" in text field", "PASS");
		}else {

			reportStep(logger, "Not able to enter username: "+userName+" in text field", "FAIL");
		}

		return this;
	}

	/* Enter admin Password */
	public Login enterPassword(WebDriver driver, String password) {

		reportStep(logger, "About to enter username: "+password+" in text field", "INFO");

		if(enterTextByIDAfterVisibility(driver, input_Password, password)) {

			reportStep(logger, "Successfully entered password: "+password+" in text field", "PASS");
		}else {

			reportStep(logger, "Not able to enter password: "+password+" in text field", "FAIL");
		}

		return this;
	}

	/* Enter admin Password */
	public Login clickLogin(WebDriver driver) {

		reportStep(logger, "About to click login button", "INFO");

		if(clickByID(driver, button_Login)) {

			reportStep(logger, "Successfully clicked login button", "PASS");
		}else {

			reportStep(logger, "Not able to click login button", "FAIL");
		}

		return this;
	}

	/* Enter credentials */
	public Login enterAdminLoginCredentials(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to enter admin login credentials", "INFO");

		deleteCookiesAndRefresh(driver);

		reportStep(logger, "About to redirect to dashboard after entering dev6Ck admin & enter credentials", "INFO");

		selectValueAdminDropdown(driver, ConfigurationSetup.dropdown);
		enterUserName(driver, ConfigurationSetup.userName);
		enterPassword(driver, ConfigurationSetup.password);
		clickLogin(driver);

		reportStep(logger, "Successfully redirected to dashboard after entering dev6Ck admin & enter credentials", "PASS");


		if(isElementLocatedByXpathPresent(driver, breadcrumbDashboard)){

			reportStep(logger, "Breadcrumb dashboard is  visible after clicking mainMenu_Dashboard", "PASS");

		}else {

			reportStep(logger, "Breadcrumb dashboard not  visible after clicking mainMenu_Dashboard", "FAIL");

		}

		return this;

	} // End of enter_Credentials_And_Homepage_Navigation

} // End of  Admin_Login_Page