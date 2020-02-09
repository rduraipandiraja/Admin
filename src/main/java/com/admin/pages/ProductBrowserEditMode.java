package com.admin.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.admin.base.WrapperMethods;
import com.admin.utilities.Utils;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductBrowserEditMode extends WrapperMethods {
	
	public String strAdminEnvKey;
	public Select select_PatnerOption;
	
	/****************************************************** This is default constructor which initializes driver and will create all web element ************************/

	public ProductBrowserEditMode(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***************************************************************** Page Object Creation started *********************************************************************/
	
	// Admin Login
	private String Prod_BEM_BreadCrum			= "ProductBrowser";
	private String solrUpdate					= "btn_Tools";
	private String option_Store_PCB_Refresh		= "solrLiveRefershPrimaryCashback";
	private String option_Store_SCB_Refresh		= "solrLiveRefreshSecondaryCashback";
	private String option_Store_Voucher_Refresh	= "solrLiveRefreshVouchers";
	private String text_Store_PCB_Refresh		= "//div[contains(text(),'SOLR Primary Cashback')]";
	private String text_Store_SCB_Refresh		= "//div[contains(text(),'SOLR Secondary Cashback')]";
	private String text_Store_Voucher_Refresh	= "//div[contains(text(),'SOLR Vouchers')]";
	private String button_Refresh				= "//button[contains(.,'Refresh')]";
	private String button_SolrRefresh_OK		= "//button[contains(.,'OK')]";
	
	// Menu
	private String subMenuProductBrowserEditMode="SubMenu_ProductBrowserEditMode";
	private String productID					="(//p[@class='proTitle']/following-sibling::p)[1]";
	private String statusInactive				="(//p[@class='proTitle'])[2]/parent::div/following-sibling::div[2]/div[5]/label/div[contains(@class,'switch-off')]";
	private String statusActive					="(//p[@class='proTitle'])[2]/parent::div/following-sibling::div[2]/div[5]/label/div[contains(@class,'switch-on')]";
	
	@FindBy(how = How.ID, using = "seller") 
	WebElement dropdownSeller;
	
	
	
	@FindBy(how = How.ID, using = "btnSubmit") 
	WebElement buttonSubmit;


	/***************************************************************** Methods Creation started *************************************************************************/

	
	/* Click subMenu Product Browser Edit Mode */
	public void clickSubMenuProductBrowserEditMode(WebDriver objDriver) throws InterruptedException {
		
		 reportStep(logger, "About to click subMenu_Affiliate_Network", "INFO");

		 if(jsClickByID(objDriver, subMenuProductBrowserEditMode)) {

			 reportStep(logger, "Successfully clicked subMenuProductBrowserEditMode", "PASS");
		 }else {

			 reportStep(logger, "Not able to click subMenuProductBrowserEditMode", "FAIL");
		 }

		 if(isElementLocatedByIDPresent(objDriver, Prod_BEM_BreadCrum)) {

			 reportStep(logger, "Successfully clicked subMenuProductBrowserEditMode & validated Prod_BEM_BreadCrum", "PASS");
		 }else {

			 reportStep(logger, "Not able to validate Prod_BEM_BreadCrum after clicking subMenuProductBrowserEditMode", "FAIL");
		 }

	}
	
	/* Click PCB Refresh */
	public void clickPrimaryCashbackSolrRefresh(WebDriver objDriver) throws InterruptedException {

		reportStep(logger, "About to click PCB_Refresh", "INFO");

		/*if(CCL_Class.WrapperClass.clickByID(objDriver, solrUpdate)) {

			reportStep(logger, "Successfully clicked solrUpdate");
		}else {

			reportStep(logger, "Not able to click solrUpdate");
		}*/

		if(jsClickByID(objDriver, option_Store_PCB_Refresh)) {

			reportStep(logger, "Successfully clicked PCB_Refresh", "PASS");
		}else {

			reportStep(logger, "Not able to click PCB_Refresh", "FAIL");
		}

		 if(isElementLocatedByXpathPresent(objDriver, text_Store_PCB_Refresh)) {

			 reportStep(logger, "Successfully clicked option_Store_PCB_Refresh", "PASS");
		 }else {

			 reportStep(logger, "Not able to click option_Store_PCB_Refresh", "FAIL");
		 }

		if(jsClickByXpathAfterVisbility(objDriver, button_Refresh)) {

			reportStep(logger, "Successfully clicked button_Refresh", "PASS");
		}else {

			reportStep(logger, "Not able to click button_Refresh", "FAIL");
		}

		reportStep(logger, "About to click SolrRefresh_OK", "INFO");

		if(jsClickByXpath_AfterWaitRequireSeconds(objDriver, button_SolrRefresh_OK, 500)) {

			reportStep(logger, "Successfully clicked SolrRefresh_OK", "PASS");
		}else {

			reportStep(logger, "Not able to click SolrRefresh_OK", "FAIL");
		}

	}
	
	/* Click SCB Refresh */
	public void clickSecondaryCashbackSolrRefresh(WebDriver objDriver) throws InterruptedException {

		reportStep(logger, "About to click SCB_Refresh", "INFO");

		/*if(CCL_Class.WrapperClass.clickByID(objDriver, solrUpdate)) {

			reportStep(logger, "Successfully clicked solrUpdate");
		}else {

			reportStep(logger, "Not able to click solrUpdate");
		}*/

		if(jsClickByID(objDriver, option_Store_SCB_Refresh)) {

			reportStep(logger, "Successfully clicked SCB_Refresh", "PASS");
		}else {

			reportStep(logger, "Not able to click SCB_Refresh", "FAIL");
		}

		 if(isElementLocatedByXpathPresent(objDriver, text_Store_SCB_Refresh)) {

			 reportStep(logger, "Successfully clicked option_Store_SCB_Refresh", "PASS");
		 }else {

			 reportStep(logger, "Not able to click option_Store_SCB_Refresh", "FAIL");
		 }

		if(jsClickByXpathAfterVisbility(objDriver, button_Refresh)) {

			reportStep(logger, "Successfully clicked button_Refresh", "PASS");
		}else {

			reportStep(logger, "Not able to click button_Refresh", "FAIL");
		}

		reportStep(logger, "About to click SolrRefresh_OK", "INFO");

		if(jsClickByXpath_AfterWaitRequireSeconds(objDriver, button_SolrRefresh_OK, 500)) {

			reportStep(logger, "Successfully clicked SolrRefresh_OK", "PASS");
		}else {

			reportStep(logger, "Not able to click SolrRefresh_OK", "FAIL");
		}

	}
	
	/* Click Voucher Refresh */
	public void clickVoucherSolrRefresh(WebDriver objDriver) throws InterruptedException {

		reportStep(logger, "About to click Voucher_Refresh", "INFO");

		/*if(CCL_Class.WrapperClass.clickByID(objDriver, solrUpdate)) {

			reportStep(logger, "Successfully clicked solrUpdate");
		}else {

			reportStep(logger, "Not able to click solrUpdate");
		}*/

		if(jsClickByID(objDriver, option_Store_Voucher_Refresh)) {

			reportStep(logger, "Successfully clicked Voucher_Refresh", "PASS");
		}else {

			reportStep(logger, "Not able to click Voucher_Refresh", "FAIL");
		}

		 if(isElementLocatedByXpathPresent(objDriver, text_Store_Voucher_Refresh)) {

			 reportStep(logger, "Successfully clicked option_Store_Voucher_Refresh", "PASS");
		 }else {

			 reportStep(logger, "Not able to click option_Store_Voucher_Refresh", "FAIL");
		 }

		if(jsClickByXpathAfterVisbility(objDriver, button_Refresh)) {

			reportStep(logger, "Successfully clicked button_Refresh", "PASS");
		}else {

			reportStep(logger, "Not able to click button_Refresh", "FAIL");
		}

		reportStep(logger, "About to click SolrRefresh_OK", "INFO");

		if(jsClickByXpath_AfterWaitRequireSeconds(objDriver, button_SolrRefresh_OK, 500)) {

			reportStep(logger, "Successfully clicked SolrRefresh_OK", "PASS");
		}else {

			reportStep(logger, "Not able to click SolrRefresh_OK", "FAIL");
		}

	}
	
	public void selectValueFromDropdown(String dropdownValue) {
		
		reportStep(logger, "About to select dropdown value", "INFO");
		
		if(isElementVisibleByIDPresent(driver, "seller")) {

			reportStep(logger, "Validated dropdown presence", "PASS");
		}else {

			reportStep(logger, "Not able to validate dropdown presence", "FAIL");
		}
		
		if(selectValuesFromDropdown(dropdownSeller, dropdownValue)) {
			
			reportStep(logger , "Successfully selected dropdown value "+ dropdownValue, "PASS");
		}else {
			
			reportStep(logger , "Failed to select dropdown value "+ dropdownValue, "FAIL");
		}
		


	}

	public void clickSubmitButton() {
		
		reportStep(logger, "About to click on the submit  button ", "INFO");
		
		if(clickAfterWait(driver, buttonSubmit)) {
			
			reportStep(logger, "Successfully clicked on the submit button ", "PASS");
			
		}else {
			
			reportStep(logger, "Failed to  click on the submit button ", "FAIL");
		}
		
	}

	public String getProductID(WebDriver driver, int index) {

		reportStep(logger, "About to get Product ID", "INFO");

		String ProductId = getTextByXpath(driver, "(//p[@class='proTitle'])["+index+"]/following-sibling::p");
		
		String Productid = StringUtils.substringAfter(ProductId, "PPS ID:").trim();

		reportStep(logger, "Successfully got Product ID: "+Productid, "INFO");
				
		return Productid;
		 
	}

	public void setStatusForProduct(WebDriver driver, int index) {

		reportStep(logger, "About to get Product ID", "INFO");
		
		if (isElementLocatedByXpathPresent(driver, statusInactive)) {

			reportStep(logger, "About to validate products default status in-active", "INFO");
			
		} else {

			reportStep(logger, "Not able to validate products default status in-active", "INFO");

		}

		if (jsClickByXpath(driver, "(//label[@id='updateMetaDataStatus'])["+index+"]")) {

			reportStep(logger, "About to click change status in-active", "INFO");
			
		} else {

			reportStep(logger, "Not able to click change status in-active", "INFO");

		}
		
		if (isElementLocatedByXpathPresent(driver, statusActive)) {

			reportStep(logger, "About to validate products default status active", "INFO");
			
		} else {

			reportStep(logger, "Not able to validate products default status active", "INFO");

		}
				
	}

}





