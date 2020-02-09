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

public class Dashboard extends WrapperMethods {

	public String strAdminEnvKey;
	public Select select_PatnerOption;

	/****************************************************** This is default constructor which initializes driver and will create all web element ************************/

	public Dashboard(WebDriver driver, ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

	/***************************************************************** Page variable Creation started *********************************************************************/

	// Menu's
	private String mainMenu_Admin						="MainMenu_Admin";
	private String mainMenu_Charities					="MainMenu_Charities";
	private String mainMenu_Interactive					="MainMenu_Interactive";
	private String mainMenu_Marketing					="MainMenu_Marketing";
	private String mainMenu_Product_Feeds				="MainMenu_ProductFeeds";
	private String mainMenu_Reports						="MainMenu_Reports";
	private String mainMenu_Stores						="MainMenu_Stores";	
	private String mainMenu_Settings					="MainMenu_Settings";	
	private String mainMenu_Cashback					="MainMenu_Cashback";
	private String mainMenu_Dashboard					="MainMenu_Dashboard";
	private String mainMenu_Users						="MainMenu_Users";

	// Sub Menu's
	private String subMenu_EmailTemplates				="SubMenu_EmailTemplates";
	private String subMenu_Cashbacks					="SubMenu_Cashbacks";
	private String subMenu_Charities					="SubMenu_Charities";
	private String subMenu_DynamicPages					="SubMenu_DynamicPages";
	private String subMenu_CashbackReport				="SubMenu_CashbackReport";
	private String subMenu_Stores						="SubMenu_Stores";
	private String subMenu_Users						="SubMenu_Users";
	private String subMenu_ProducBrowserEditmode		="SubMenu_ProductBrowserEditMode";
	private String subMenu_AffiliateNetwork				="SubMenu_AffiliateNetworks";

	// Others
	private String icon_Hamburger						="m_aside_left_minimize_toggle";
	private String breadcrumbDashboard					="(//span[contains(text(),'Dashboard')])[3]";

	/***************************************************************** Methods Creation started *************************************************************************/

	/* Click Hamburger icon */
	public Dashboard clickHamburgerIcon(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click HamburgerIcon", "INFO");

		if(clickByID(driver, icon_Hamburger)) {

			reportStep(logger, "Successfully clicked HamburgerIcon", "PASS");
		}else {

			reportStep(logger, "Not able to click HamburgerIcon", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, mainMenu_Stores)){

			reportStep(logger, "mainMenu_Stores is  visible after clicking HamburgerIcon", "PASS");

		}else {

			reportStep(logger, "mainMenu_Stores not  visible after clicking HamburgerIcon", "FAIL");

		}

		return this;

	}

	/* Click Dashboard */
	public Dashboard clickMainMenuDashboard(WebDriver driver) throws InterruptedException, AWTException  {

		reportStep(logger, "About to click mainMenu_Dashboard", "INFO");

		if(clickByID(driver, mainMenu_Dashboard)) {

			reportStep(logger, "Successfully clicked mainMenu_Dashboard", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Dashboard", "FAIL");
		}

		if(isElementLocatedByXpathPresent(driver, breadcrumbDashboard)){

			reportStep(logger, "Breadcrumb dashboard is  visible after clicking mainMenu_Dashboard", "PASS");

		}else {

			reportStep(logger, "Breadcrumb dashboard not  visible after clicking mainMenu_Dashboard", "FAIL");

		}

		return this;

	}

	/* Click Admin */
	public Dashboard clickMainMenuAdmin(WebDriver driver) throws InterruptedException, AWTException  {

		reportStep(logger, "About to click mainMenu_Admin", "INFO");

		if(clickByID(driver, mainMenu_Admin)) {

			reportStep(logger, "Successfully clicked mainMenu_Admin", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Admin", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_EmailTemplates)){

			reportStep(logger, "subMenu_EmailTemplates is  visible after clicking mainMenu_Admin", "PASS");

		}else {

			reportStep(logger, "subMenu_EmailTemplates is not  visible after clicking mainMenu_Admin", "FAIL");

		}

		return this;

	}

	/* Click Cashback */
	public Dashboard clickMainMenuCashback(WebDriver driver) throws InterruptedException, AWTException  {

		reportStep(logger, "About to click mainMenu_Cashback", "INFO");

		if(clickByID(driver, mainMenu_Cashback)) {

			reportStep(logger, "Successfully clicked mainMenu_Cashback", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Cashback", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_Cashbacks)){

			reportStep(logger, "subMenu_Cashbacks is  visible after clicking mainMenu_Cashback", "PASS");

		}else {

			reportStep(logger, "subMenu_Cashbacks is not  visible after clicking mainMenu_Cashback", "FAIL");

		}

		return this;

	}

	/* Click Charity */
	public Dashboard clickMainMenuCharity(WebDriver driver) throws InterruptedException, AWTException  {

		reportStep(logger, "About to click mainMenu_Charities", "INFO");

		if(clickByID(driver, mainMenu_Charities)) {

			reportStep(logger, "Successfully clicked mainMenu_Charities", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Charities", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_Charities)){

			reportStep(logger, "subMenu_Charities is  visible after clicking mainMenu_Charities", "PASS");

		}else {

			reportStep(logger, "subMenu_Charities is not  visible after clicking mainMenu_Charities", "FAIL");

		}

		return this;

	}

	/* Click Interative */
	public Dashboard clickMainMenuInteractive(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "Successfully clicked - Main menu Interactive and expanding the submenus...", "INFO");

		reportStep(logger, "About to click mainMenu_Interactive", "INFO");

		if(clickByID(driver, mainMenu_Interactive)) {

			reportStep(logger, "Successfully clicked mainMenu_Interactive", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Interactive", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_DynamicPages)){

			reportStep(logger, "subMenu_DynamicPages is  visible after clicking mainMenu_Interactive", "PASS");

		}else {

			reportStep(logger, "subMenu_DynamicPages is not  visible after clicking mainMenu_Interactive", "FAIL");

		}

		return this;

	}

	/* Click Marketing */
	public Dashboard clickMainMenuMarketing(WebDriver driver) throws InterruptedException, AWTException  {

		reportStep(logger, "About to click mainMenu_Marketing", "INFO");

		if(clickByID(driver, mainMenu_Marketing)) {

			reportStep(logger, "Successfully clicked mainMenu_Marketing", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Marketing", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_DynamicPages)){

			reportStep(logger, "subMenu_DynamicPages is  visible after clicking mainMenu_Marketing", "PASS");

		}else {

			reportStep(logger, "subMenu_DynamicPages is not  visible after clicking mainMenu_Marketing", "FAIL");

		}

		return this;

	}

	/* Click Product Feeds */
	public Dashboard clickMainMenuProductFeeds(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click mainMenu_Product_Feeds", "INFO");

		if(clickByID(driver, mainMenu_Product_Feeds)) {

			reportStep(logger, "Successfully clicked mainMenu_Product_Feeds", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Product_Feeds", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_ProducBrowserEditmode)){

			reportStep(logger, "subMenu_ProducBrowserEditmode is  visible after clicking mainMenu_Product_Feeds", "PASS");

		}else {

			reportStep(logger, "subMenu_ProducBrowserEditmode is not  visible after clicking mainMenu_Product_Feeds", "FAIL");

		}

		return this;

	}

	/* Click Reports */
	public Dashboard clickMainMenuReports(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click mainMenu_Reports", "INFO");

		if(clickByID(driver, mainMenu_Reports)) {

			reportStep(logger, "Successfully clicked mainMenu_Reports", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Reports", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_CashbackReport)){

			reportStep(logger, "subMenu_CashbackReport is  visible after clicking mainMenu_Reports", "PASS");

		}else {

			reportStep(logger, "subMenu_CashbackReport is not  visible after clicking mainMenu_Reports", "FAIL");

		}

		return this;

	}

	/* Click Settings */
	public Dashboard clickMainMenuSettings(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click mainMenu_Settings", "INFO");

		if(clickByID(driver, mainMenu_Settings)) {

			reportStep(logger, "Successfully clicked mainMenu_Settings", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Settings", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_AffiliateNetwork)){

			reportStep(logger, "subMenu_AffiliateNetwork is  visible after clicking mainMenu_Settings", "PASS");

		}else {

			reportStep(logger, "subMenu_AffiliateNetwork is not  visible after clicking mainMenu_Settings", "FAIL");

		}

		return this;
	}

	/* Click Stores */
	public Dashboard clickMainMenuStores(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click mainMenu_Stores", "INFO");

		if(clickByID(driver, mainMenu_Stores)) {

			reportStep(logger, "Successfully clicked mainMenu_Stores", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Stores", "FAIL");
		}

		if((ConfigurationSetup.PartnerName).equals("Cashkaro")){

			clickHamburgerIcon(driver);
			
		}

		if(isElementLocatedByIDPresent(driver, subMenu_Stores)){

			reportStep(logger, "subMenu_Stores is  visible after clicking mainMenu_Stores", "PASS");

		}else {

			reportStep(logger, "subMenu_Stores is not  visible after clicking mainMenu_Stores", "FAIL");

		}

		return this;

	}

	/* Click Stores */
	public Dashboard clickMainMenuStore(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click mainMenu_Stores", "INFO");

		if(clickByID(driver, mainMenu_Stores)) {

			reportStep(logger, "Successfully clicked mainMenu_Stores", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Stores", "FAIL");
		}

		if(isElementVisibleByIDPresent(driver, subMenu_Stores)){
			reportStep(logger, "Not required to click stores menu", "INFO");

			
		} else {
			clickHamburgerIcon(driver);
			reportStep(logger, "Need to click stores menu", "INFO");

		}

		if(isElementLocatedByIDPresent(driver, subMenu_Stores)){

			reportStep(logger, "subMenu_Stores is  visible after clicking mainMenu_Stores", "PASS");

		}else {

			reportStep(logger, "subMenu_Stores is not  visible after clicking mainMenu_Stores", "FAIL");

		}

		return this;

	}

	/* Click Users */
	public Dashboard clickMainMenuUsers(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click mainMenu_Users", "INFO");

		if(clickByID(driver, mainMenu_Users)) {

			reportStep(logger, "Successfully clicked mainMenu_Users", "PASS");
		}else {

			reportStep(logger, "Not able to click mainMenu_Users", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, subMenu_Users)){

			reportStep(logger, "subMenu_Users is  visible after clicking mainMenu_Users", "PASS");

		}else {

			reportStep(logger, "subMenu_Users is not  visible after clicking mainMenu_Users", "FAIL");

		}

		return this;

	}


} // End of  Admin_Login_Page