package com.admin.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.admin.base.WrapperMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AffillateNetwork extends WrapperMethods {
 
 
	 /************************************************* This is default constructor which initializes driver and will create all web element  **************************/
	
	 public AffillateNetwork(WebDriver driver, ExtentTest logger) {

			this.driver = driver;
			this.logger = logger;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	 }
	 
	 /**************************************************************** Page Object Creation started ********************************************************************/
 
	 private String submenu_Affilliate_Network_Click    = "//a[contains(.,'Affiliate Networks')]";
	 private String breadcrumb_Affilliate_Network		= "//span[contains(.,'Affiliate Networks')][@class='m-nav__link-text']";
	 private String breadcrumb_Edit_Network     		= "//span[contains(.,'Edit Network')][@class='m-nav__link-text']";
	 private String icon_Edit_Adda52					="(//i[@class='fa fa-edit'])[1]";
	  
	 /**************************************************************** Methods Creation started ************************************************************************/
 
	 // Click SubMenu Affiliate Network /
	 public void clickSubMenuAffiliateNetwork(WebDriver driver) throws InterruptedException {

		 reportStep(logger, "About to click subMenu_Affiliate_Network", "INFO");

		 if(jsClickByXpath(driver, submenu_Affilliate_Network_Click)) {

			 reportStep(logger, "Successfully clicked subMenu_Affiliate_Network", "PASS");
		 }else {

			 reportStep(logger, "Not able to click subMenu_Affiliate_Network", "FAIL");
		 }

		 if(isElementLocatedByXpathPresent(driver, breadcrumb_Affilliate_Network)) {

			 reportStep(logger, "Successfully clicked subMenu_Affiliate_Network & validated breadcrumb_Affilliate_Network", "PASS");
		 }else {

			 reportStep(logger, "Not able to validate breadcrumb_Affilliate_Network after clicking subMenu_Affiliate_Network", "FAIL");
		 }

	 }

	 // Click Edit Icon Affiliate Network /
	 public void clickAffiliateNetworkEditIcon(WebDriver driver, String str_Afilliate_Network) throws InterruptedException {

		 String xpath = "//td[contains(.,'"+str_Afilliate_Network+"')]/following::td[4]/a";

		 reportStep(logger, "About to click Affiliate_Network edit button", "INFO");

		 if(jsClickByXpath(driver, xpath)) {

			 reportStep(logger, "Successfully clicked Affiliate_Network  edit button", "PASS");
		 }else {

			 reportStep(logger, "Not able to click Affiliate_Network  edit button", "FAIL");
		 }

		 if(isElementLocatedByXpathPresent(driver, breadcrumb_Edit_Network)) {

			 reportStep(logger, "Successfully clicked Affiliate_Network & validated breadcrumb_Edit_Network", "PASS");
		 }else {

			 reportStep(logger, "Not able to validate breadcrumb_Edit_Network after clicking Affiliate_Network", "FAIL");
		 }

	 }

	 // Get Affiliate Network ID /
	 public String getAffiliateNetworkID(WebDriver driver) throws InterruptedException {

		 reportStep(logger, "About to Retrieve Affiliate_Network_Id_Retrieve", "INFO");

		 String str_Affilliate_Network_Id = driver.getCurrentUrl();
		 String str_Affilliate_Network_Id_From_URL = StringUtils.substringBetween(str_Affilliate_Network_Id, "edit_network.php?id=", "&mode=edit").trim();

		 reportStep(logger, "Successfully Retrieved Affiliate_Network_Id: "+str_Affilliate_Network_Id_From_URL, "PASS");

		 return str_Affilliate_Network_Id_From_URL;

	 }

	 // Click Edit Icon Affiliate Network /
	 public void clickAffiliateNetworkAdda52EditIcon(WebDriver driver) throws InterruptedException {

		 reportStep(logger, "About to click edit icon", "INFO");

		 if(jsClickByXpath(driver, icon_Edit_Adda52)) {

			 reportStep(logger, "Successfully clicked subMenu_Affiliate_Network", "PASS");
		 }else {

			 reportStep(logger, "Not able to click edit icon", "FAIL");
		 }
	 } 

	 // Click Edit Icon Affiliate Network /
	 public void clickEditIcon(WebDriver driver, String strAffilliateNetwork) throws InterruptedException {
		  
		  String xpath = "//td[contains(.,'"+strAffilliateNetwork+"')]/following::td[4]/a/i[@class='fa fa-edit']";

			reportStep(logger, "About to click Affiliate_Network: "+strAffilliateNetwork+" edit button", "INFO");

			if(jsClickByXpath(driver, xpath)) {

				reportStep(logger, "Successfully clicked Affiliate_Network: "+strAffilliateNetwork+"  edit button", "PASS");
			}else {

				reportStep(logger, "Not able to click Affiliate_Network: "+strAffilliateNetwork+"  edit button", "FAIL");
			}
	} 

}