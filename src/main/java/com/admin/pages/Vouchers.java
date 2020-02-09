package com.admin.pages;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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

public class Vouchers extends WrapperMethods {
	
	/************************************************** This is default constructor which initializes driver and will create all web element  ***************************/

	public Vouchers(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/***************************************************************** Page Object Creation started *********************************************************************/
	

	public String strWithoutCodeVoucherName,strWithCodeVoucherName,strnewVoucher_Para_Description,strVoucherApplyFor_AllUsers,strVoucherApplyFor_NewUser,strVoucher_Status,strVoucher_Type,
	strVoucher_Code,strNewVoucher_Details;
	
	//Voucher Search page
	private String submenu_Vouchers						="SubMenu_Vouchers";
	private String button_AddNewVoucher					="anc_AddNew";
	
	// tabs
	private String tab_AddnewVoucher_Category			="tab_Category";
	
	//vouchers tab
	private String dropdown_Store						="//select[@id='storeid']";
	private String input_Title							="title";
	private String textarea_Description					="description";
	private String textarea_App_Description				="app_description";
	private String textarea_CashbackText				="cashback_text";
	private String dropdown_Status						="status";
	private String input_Code							="code";
	private String textarea_Details						="details";
	private String calender_Issue_Date					="issuedate";
	private String calender_Expiry_Date					="expirydate";
	private String input_Deep_Link  					="deep_link";
	private String dropdown_Voucher_Apply_For			="voucher_apply";
	private String dropdown_Type						="vtype";
	private String str_Timer							="Timer";
	private String input_Time_Expiry_Date				="expirytime";
	private String dropDown_Select_Cashback_Offer_Type	="cashback_offer_type";
	private String textBox_Code							="code";
	private String dropDown_StoreName					="sby";
	private String input_Keyword_StoreName				="sstring";
	private String checkbox_Desktop						="device_type_desktop";
	private String checkbox_Mobile						="device_type_mobile";
	private String checkbox_Tablet						="device_type_tablet";
	private String checkbox_App							="device_type_app";
	private String title_App							="app_title";
	
	//common
	private String button_Save_Voucher						="btn_Submit";
	private String message_Successfully_NewVoucher_Created	="adminMessageSuccess";
	
	//voucher search page
	private String icon_Edit_First_Voucher					="(//a[@class='fa fa-edit'])[1]";
	private String icon_Edit_Second_Voucher					="(//a[@class='fa fa-edit'])[2]";
	
	//common
	private String list_Of_Vouchers							="gview_all_list";
	private String checkBoxTree								="//i[contains(@role,'presentation')]";

	private String TopDealsCategory							="//a[contains(.,'Top Deals')]";
	private String FashionCategory							="//a[contains(.,'Fashion')]";
	private String ElectronicsCategory						="//a[contains(.,'Electronics')]";
	private String TravelCategory							="//a[contains(.,'Travel')]";
	private String GroceryCategory							="//a[contains(.,'Grocery')]";
	private String DiningCategory							="//a[contains(.,'Dining')]";
	private String BeautyCategory							="//a[contains(.,'Beauty')]";
	private String HealthCategory							="//a[contains(.,'Health')]";
	private String textVoucherID							="//div[@id='jqgh_all_list_voucherid']";

	private String categoryPopularToday						="//a[@id='voucherCat_popular-today_anchor']/parent::li/i";
	private String categoryOne								="voucherCat_pps-atm-cashback-category_anchor";
	private String categoryTwo								="voucherCat_pps-atm-rewards-category_anchor";
	private String categoryThree							="voucherCat_pps-atm-network-18-category_anchor";
	
	/***************************************************************** Methods Creation started *************************************************************************/

	/* Click Submenu Voucher */
	public void clickSubMenuVoucher(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click submenuVouchers", "INFO");

		if(jsClickByID(driver, submenu_Vouchers)) {

			reportStep(logger, "Successfully clicked submenuVouchers", "PASS");
		}else {

			reportStep(logger, "Not able to click submenuVouchers", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, button_AddNewVoucher)){

			reportStep(logger, "button_AddNewVoucher is  visible after clicking submenuVouchers", "PASS");

		}else {

			reportStep(logger, "button_AddNewVoucher not  visible after clicking submenuVouchers", "FAIL");

		}

	}
	
	/* Click Add New Voucher */
	public void clickAddNewVoucher(WebDriver driver) {

		reportStep(logger, "About to click submenuVouchers", "INFO");

		if(jsClickByID(driver, button_AddNewVoucher)) {

			reportStep(logger, "Successfully clicked submenuVouchers", "PASS");
		}else {

			reportStep(logger, "Not able to click submenuVouchers", "FAIL");
		}

	}
	
	/* Select Store */
	public String selectStore(WebDriver driver, String strNewStoreName, String str_StoreId) throws InterruptedException {
		
		reportStep(logger, "About to select "+strNewStoreName+"   (D, M, T, A) from dropdown", "INFO");

		selectValuesFromDropdownUsingValues(driver, dropdown_Store, str_StoreId);
		
		return strNewStoreName;
	}

	/* Click Required Device Type */
	public String clickDeviceTypeDesktop(WebDriver driver) throws InterruptedException {
		
		String deviceType = "Desktop";

		reportStep(logger, "About to click checkbox_Desktop", "INFO");

		if(jsClickByID(driver, checkbox_Desktop)) {

			reportStep(logger, "Successfully clicked checkbox_Desktop", "PASS");
		}else {

			reportStep(logger, "Not able to click checkbox_Desktop", "FAIL");
		}
		
		return deviceType;
	}

	/* Click Required Device Type */
	public String clickDeviceTypeMobile(WebDriver driver) throws InterruptedException {
		
		String deviceType = "Mobile";

		reportStep(logger, "About to click checkbox_Mobile", "INFO");

		if(jsClickByID(driver, checkbox_Mobile)) {

			reportStep(logger, "Successfully clicked checkbox_Mobile", "PASS");
		}else {

			reportStep(logger, "Not able to click checkbox_Mobile", "FAIL");
		}
		
		return deviceType;
	}

	/* Click Required Device Type */
	public String clickDeviceTypeTablet(WebDriver driver) throws InterruptedException {
		
		String deviceType = "Tablet";

		reportStep(logger, "About to click checkbox_Tablet", "INFO");

		if(jsClickByID(driver, checkbox_Tablet)) {

			reportStep(logger, "Successfully clicked checkbox_Tablet", "PASS");
		}else {

			reportStep(logger, "Not able to click checkbox_Tablet", "FAIL");
		}
		
		return deviceType;
	}

	/* Click Required Device Type */
	public String clickDeviceTypeApp(WebDriver driver) throws InterruptedException {
		
		String deviceType = "App";

		reportStep(logger, "About to click checkbox_App", "INFO");

		if(jsClickByID(driver, checkbox_App)) {

			reportStep(logger, "Successfully clicked checkbox_App", "PASS");
		}else {

			reportStep(logger, "Not able to click checkbox_App", "FAIL");
		}
		
		return deviceType;
	}

	/* Select Device Type */
	public void selectDeviceType(WebDriver driver, String str_DeviceName) throws InterruptedException{

		reportStep(logger,"About to select device type: "+str_DeviceName, "INFO");
		
		String string_DeviceName = str_DeviceName;

		switch (string_DeviceName) {

		case "All": {
			
			this.clickDeviceTypeDesktop(driver);
			this.clickDeviceTypeMobile(driver);
			this.clickDeviceTypeTablet(driver);
			this.clickDeviceTypeApp(driver);

		}
			break;

		case "Desktop": {
			
			this.clickDeviceTypeDesktop(driver);

		}
			break;

		case "Mobile": {
			
			this.clickDeviceTypeMobile(driver);

		}
			break;

		case "Tablet": {
			
			this.clickDeviceTypeTablet(driver);
			
		}
			break;

		case "App": {
			
			this.clickDeviceTypeApp(driver);
			
		}
			break;
		}

		reportStep(logger,"Sucessfully selected device type: "+str_DeviceName, "PASS");
		
	}
	
	/* Enter Voucher Name */
	public String enterWithoutCodeVoucherName(WebDriver driver , String strNewStoreName) throws InterruptedException {

		strWithoutCodeVoucherName = ("Voucher With out code for :"+ strNewStoreName );
		
		reportStep(logger, "About to enter Voucher name: "+strWithoutCodeVoucherName, "INFO");		
		
		if(enterTextByID(driver, input_Title, strWithoutCodeVoucherName)) {

			reportStep(logger, "Successfully entered Voucher name: "+strWithoutCodeVoucherName, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher name: "+strWithoutCodeVoucherName, "FAIL");
		}

		return strWithoutCodeVoucherName ;

	}

	/* Enter Voucher Name */
	public String enterWithoutCodeVoucherNameForApp(WebDriver driver , String strNewStoreName) throws InterruptedException {

		strWithoutCodeVoucherName = ("Voucher With out code for :"+ strNewStoreName );
		
		reportStep(logger, "About to enter Voucher name: "+strWithoutCodeVoucherName, "INFO");		
		
		if(enterTextByID(driver, title_App, strWithoutCodeVoucherName)) {

			reportStep(logger, "Successfully entered Voucher name: "+strWithoutCodeVoucherName, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher name: "+strWithoutCodeVoucherName, "FAIL");
		}

		return strWithoutCodeVoucherName ;

	}
	
	/* Enter Voucher Name */
	public String enterWithCodeVoucherName(WebDriver driver , String strNewStoreName) throws InterruptedException {

		strWithCodeVoucherName = ("Voucher With code for :"+ strNewStoreName );
		
		reportStep(logger, "About to enter Voucher name: "+strWithCodeVoucherName, "INFO");		
		
		if(enterTextByID(driver, input_Title, strWithCodeVoucherName)) {

			reportStep(logger, "Successfully entered Voucher name: "+strWithCodeVoucherName, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher name: "+strWithCodeVoucherName, "FAIL");
		}

		return strWithCodeVoucherName ;

	}

	/* Enter Voucher Name */
	public String enterWithCodeVoucherNameForApp(WebDriver driver , String strNewStoreName) throws InterruptedException {

		strWithCodeVoucherName = ("Voucher With code for :"+ strNewStoreName );

		reportStep(logger, "About to enter Voucher name: "+strWithCodeVoucherName, "INFO");		
		
		if(enterTextByID(driver, title_App, strWithCodeVoucherName)) {

			reportStep(logger, "Successfully entered Voucher name: "+strWithCodeVoucherName, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher name: "+strWithCodeVoucherName, "FAIL");
		}

		return strWithCodeVoucherName ;

	}
	
	/* Enter Voucher Paragraph Description */
	public String enterParagraphDescription(WebDriver driver) throws InterruptedException {
		
		strnewVoucher_Para_Description = ("This is Test Automation entering paragraph description for the voucher");
		
		reportStep(logger, "About to enter Voucher Paragraph description: "+"<p>"+ strnewVoucher_Para_Description + "</p>", "INFO");		
		
		if(enterTextByID(driver, textarea_Description, "<p>"+ strnewVoucher_Para_Description + "</p>")) {

			reportStep(logger, "Successfully entered Voucher Paragraph description: "+"<p>"+ strnewVoucher_Para_Description + "</p>", "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher Paragraph description: "+"<p>"+ strnewVoucher_Para_Description + "</p>", "FAIL");
		}

		return strnewVoucher_Para_Description ;

	}
	
	/* Enter Voucher Description */
	public String enterDescription(WebDriver driver) throws InterruptedException {
		
		strnewVoucher_Para_Description = ("This is Test Automation entering description for the voucher");
				
		reportStep(logger, "About to enter Voucher description: "+ strnewVoucher_Para_Description, "INFO");		
		
		if(enterTextByID(driver, textarea_Description, strnewVoucher_Para_Description)) {

			reportStep(logger, "Successfully entered Voucher description: "+ strnewVoucher_Para_Description, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher description: "+ strnewVoucher_Para_Description, "FAIL");
		}

		return strnewVoucher_Para_Description ;

	}
	
	/* Enter Voucher List Description */
	public String enterListDescription(WebDriver driver) throws InterruptedException {
		
		strnewVoucher_Para_Description = ("<ul> <li>This is Test Automation entering paragraph description for the voucher</li> </ul>");
		
		reportStep(logger, "About to enter Voucher list description: "+ strnewVoucher_Para_Description, "INFO");		
		
		if(enterTextByID(driver, textarea_Description, strnewVoucher_Para_Description)) {

			reportStep(logger, "Successfully entered Voucher list description: "+ strnewVoucher_Para_Description, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher list description: "+ strnewVoucher_Para_Description, "FAIL");
		}

		return strnewVoucher_Para_Description ;

	}
	
	/* Enter Voucher Table Description */
	public String enterTableDescription(WebDriver driver) throws InterruptedException {
		
		strnewVoucher_Para_Description = ("<div class="+"store_table"+"><div class="+"store_table_row"+"><div class="+"store_table_left"+"><strong>Sno.</strong></div><div class="+"store_table_right"+"><strong>Description</strong></div></div><div class="+"store_table_row"+"><div class="+"store_table_left"+">1.</div><div class="+"store_table_right"+">This is Test Automation entering paragraph description for the voucher</div> </div></div>");
		
		reportStep(logger, "About to enter Voucher table description: "+ strnewVoucher_Para_Description, "INFO");		
		
		if(enterTextByID(driver, textarea_Description, strnewVoucher_Para_Description)) {

			reportStep(logger, "Successfully entered Voucher table description: "+ strnewVoucher_Para_Description, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher table description: "+ strnewVoucher_Para_Description, "FAIL");
		}

		return strnewVoucher_Para_Description ;

	}

	/* Enter Voucher Deep Link */
	public String enterDeepLink(WebDriver driver,String strnewStore_DeepLink) throws InterruptedException {
		
		reportStep(logger, "About to enter Voucher deeplink: "+ strnewStore_DeepLink, "INFO");		
		
		if(enterTextByID(driver, input_Deep_Link, strnewStore_DeepLink)) {

			reportStep(logger, "Successfully entered Voucher deeplink: "+ strnewStore_DeepLink, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher deeplink: "+ strnewStore_DeepLink, "FAIL");
		}
		
		return strnewStore_DeepLink;
	}
	
	/* Select AllUsers */
	public String selectVoucherApplyForAllUsers(WebDriver driver) throws InterruptedException {
		
		strVoucherApplyFor_AllUsers ="All Users";
		
		reportStep(logger, "About to select dropdown value : "+ strVoucherApplyFor_AllUsers, "INFO");		
		
		if(selectValuesFromDropdownUsingID(driver, dropdown_Voucher_Apply_For, strVoucherApplyFor_AllUsers)) {

			reportStep(logger, "Successfully selected dropdown value : "+ strVoucherApplyFor_AllUsers, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value : "+ strVoucherApplyFor_AllUsers, "FAIL");
		}
		
		return strVoucherApplyFor_AllUsers;
	}
	
	/* Select NewUsers */
	public String selectVoucherApplyForNewUsers(WebDriver driver) throws InterruptedException {
		
		strVoucherApplyFor_AllUsers ="New User";
		
		reportStep(logger, "About to select dropdown value : "+ strVoucherApplyFor_AllUsers, "INFO");		
		
		if(selectValuesFromDropdownUsingID(driver, dropdown_Voucher_Apply_For, strVoucherApplyFor_AllUsers)) {

			reportStep(logger, "Successfully selected dropdown value : "+ strVoucherApplyFor_AllUsers, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value : "+ strVoucherApplyFor_AllUsers, "FAIL");
		}
		
		return strVoucherApplyFor_NewUser;
	}
	
	/* Select Active */
	public String selectStatusActive(WebDriver driver) throws InterruptedException {
		
		strVoucher_Status ="Active";
		
		reportStep(logger, "About to select dropdown value : "+ strVoucher_Status, "INFO");		
		
		if(selectValuesFromDropdownUsingID(driver, dropdown_Status, strVoucher_Status)) {

			reportStep(logger, "Successfully selected dropdown value : "+ strVoucher_Status, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value : "+ strVoucher_Status, "FAIL");
		}
		
		return strVoucher_Status;
	}
	
	/* Select In-Active */
	public String selectStatusInActive(WebDriver driver) throws InterruptedException {
		
		strVoucher_Status ="In-Active";
		
		reportStep(logger, "About to select dropdown value : "+ strVoucher_Status, "INFO");		
		
		if(selectValuesFromDropdownUsingID(driver, dropdown_Status, strVoucher_Status)) {

			reportStep(logger, "Successfully selected dropdown value : "+ strVoucher_Status, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value : "+ strVoucher_Status, "FAIL");
		}
		
		return strVoucher_Status;
	}
	
	
	/* Select Code */
	public String selectVoucherTypeCode(WebDriver driver) throws InterruptedException {
		
		strVoucher_Type ="Code";
		
		reportStep(logger, "About to select dropdown value : "+ strVoucher_Type, "INFO");		
		
		if(selectValuesFromDropdownUsingID(driver, dropdown_Type, strVoucher_Type)) {

			reportStep(logger, "Successfully selected dropdown value : "+ strVoucher_Type, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value : "+ strVoucher_Type, "FAIL");
		}
		
		return strVoucher_Type;
	}
	
	/* Select Promo */
	public String selectVoucherTypePromotion(WebDriver driver) throws InterruptedException {

		strVoucher_Type ="Promotion";
		
		reportStep(logger, "About to select dropdown value : "+ strVoucher_Type, "INFO");		
		
		if(selectValuesFromDropdownUsingID(driver, dropdown_Type, strVoucher_Type)) {

			reportStep(logger, "Successfully selected dropdown value : "+ strVoucher_Type, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value : "+ strVoucher_Type, "FAIL");
		
		}
		
		return strVoucher_Type;
	}
	
	/* Enter Code */
	public String enterVoucherCode(WebDriver driver , String strNewStoreName) throws InterruptedException {

		strVoucher_Code = ("CODE");
		
		reportStep(logger, "About to enter Voucher code: "+ strVoucher_Code, "INFO");		
		
		if(enterTextByID(driver, input_Code, strVoucher_Code)) {

			reportStep(logger, "Successfully entered Voucher code: "+ strVoucher_Code, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher code: "+ strVoucher_Code, "FAIL");
		}

		return strVoucher_Code ;

	}
	
	/* Enter Details */
	public String enterVoucherDetails(WebDriver driver) throws InterruptedException {
		
		strNewVoucher_Details = ("This is Test Automation entering details for the voucher");
		
		reportStep(logger, "About to enter Voucher details: "+ strNewVoucher_Details, "INFO");		
		
		if(enterTextByID(driver, textarea_Details, strNewVoucher_Details)) {

			reportStep(logger, "Successfully entered Voucher details: "+ strNewVoucher_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher details: "+ strNewVoucher_Details, "FAIL");
		}

		return strNewVoucher_Details ;

	}
		
	/* Set IssueDate */
	public void setIssueDate_PreviousDayFromCurrentDate(WebDriver driver) throws InterruptedException {
		
		isElementLocatedByIDPresent(driver, calender_Issue_Date);

		String id = "issuedate";
		String date= Utils.previousDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Set ExpiryDate */
	public void setExpiryDate_FourDaysFromCurrentDate(WebDriver driver) throws InterruptedException {
		
		isElementLocatedByIDPresent(driver, calender_Expiry_Date);
		
		String id = "expirydate";
		String date= Utils.currentDateAfter4days();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Set IssueDate */
	public void setIssueDate_NextDate(WebDriver driver) throws InterruptedException {
		
		isElementLocatedByIDPresent(driver, calender_Issue_Date);
		
		String id = "issuedate";
		String date= Utils.previousDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}

	/* Set ExpiryDate */
	public void setExpiryDate_PreviousDate(WebDriver driver) throws InterruptedException {
		
		isElementLocatedByIDPresent(driver, calender_Expiry_Date);

		String id = "expirydate";
		String date= Utils.previousDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Set ExpiryDate */
	public void setExpireDate_CurrentDate(WebDriver driver) throws InterruptedException {
		
		isElementLocatedByIDPresent(driver, calender_Expiry_Date);

		String id = "expirydate";
		String date= Utils.setCurrentDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Click Save Voucher */
	public void clickSaveVoucher(WebDriver driver) {

		reportStep(logger, "About to click save voucher button", "INFO");

		if(jsClickByID(driver, button_Save_Voucher)) {

			reportStep(logger, "Successfully clicked save voucher button", "PASS");
		}else {

			reportStep(logger, "Not able to click save voucher button", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, message_Successfully_NewVoucher_Created)) {

			reportStep(logger, "Successfully validated sucess message", "PASS");
		}else {

			reportStep(logger, "Not able to  validate sucess message", "FAIL");
		}

	}

	/* Click Category Tab */
	public void clickCategoryTab(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click category tab", "INFO");	
		
		if(scrollUpToElementUsingID(driver, tab_AddnewVoucher_Category)) {

			reportStep(logger, "Successfully clicked category tab", "PASS");
		}else {
			reportStep(logger, "Not able to click category tab ", "FAIL");
		}

		if(clickByID(driver, tab_AddnewVoucher_Category)) {

			reportStep(logger, "Successfully clicked category tab", "PASS");
		}else {

			reportStep(logger, "Not able to click category tab", "FAIL");
		}

	}
	
	/* Click Category Check Box */
	public void clickCategoryCheckbox(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click category tree", "INFO");

		if(jsClickByXpath(driver, checkBoxTree)) {

			reportStep(logger, "Successfully clicked category tree", "PASS");
		}else {

			reportStep(logger, "Not able to click category tree", "FAIL");
		}

		if(jsClickByXpath(driver, categoryPopularToday)) {

			reportStep(logger, "Successfully clicked category popular today", "PASS");
		}else {

			reportStep(logger, "Not able to click category popular today", "FAIL");
		}
		
		if(jsClickByID(driver, categoryOne)) {

			reportStep(logger, "Successfully clicked categoryOne", "PASS");
		}else {

			reportStep(logger, "Not able to click categoryOne", "FAIL");
		}
		


		if(jsClickByID(driver, categoryTwo)) {

			reportStep(logger, "Successfully clicked categoryTwo", "PASS");
		}else {

			reportStep(logger, "Not able to click categoryTwo", "FAIL");
		}
		


		if(jsClickByID(driver, categoryThree)) {

			reportStep(logger, "Successfully clicked categoryThree", "PASS");
		}else {

			reportStep(logger, "Not able to click categoryThree", "FAIL");
		}
	
	}

	/* Click Category Check Box */
	public void clickCategoryCheckbox(WebDriver driver, String selectCategory) throws InterruptedException, AWTException {

		reportStep(logger, "About to click category tree", "INFO");

		if(jsClickByXpath(driver, checkBoxTree)) {

			reportStep(logger, "Successfully clicked category tree", "PASS");
		}else {

			reportStep(logger, "Not able to click category tree", "FAIL");
		}

		if(jsClickByXpath(driver, categoryPopularToday)) {

			reportStep(logger, "Successfully clicked category popular today", "PASS");
		}else {

			reportStep(logger, "Not able to click category popular today", "FAIL");
		}
		
		switch (selectCategory) {
		
		case "categoryOne":

			if(jsClickByID(driver, categoryOne)) {

				reportStep(logger, "Successfully clicked categoryOne", "PASS");
			}else {

				reportStep(logger, "Not able to click categoryOne", "FAIL");
			}

			break;
			
		case "categoryTwo":


			if(jsClickByID(driver, categoryTwo)) {

				reportStep(logger, "Successfully clicked categoryTwo", "PASS");
			}else {

				reportStep(logger, "Not able to click categoryTwo", "FAIL");
			}
			break;
			
		case "categoryThree":


			if(jsClickByID(driver, categoryThree)) {

				reportStep(logger, "Successfully clicked categoryThree", "PASS");
			}else {

				reportStep(logger, "Not able to click categoryThree", "FAIL");
			}
			break;
		}
	
	}

	/* Click Voucher Category */
	public void clickVoucherCategory(WebDriver driver) throws InterruptedException, AWTException {
		
		this.clickCategoryTab(driver);
		this.clickCategoryCheckbox(driver);
	
	}

	/* Click Voucher Category */
	public void clickVoucherCategory(WebDriver driver, String selectCategory) throws InterruptedException, AWTException {
		
		this.clickCategoryTab(driver);
		this.clickCategoryCheckbox(driver, selectCategory);
	
	}

	/* Click Category Check Box */
	public void clickJioCategoryCheckbox(WebDriver driver, String str_Category) throws InterruptedException, AWTException {
		
		reportStep(logger, "About to click category tree", "INFO");

		if(jsClickByXpath(driver, checkBoxTree)) {

			reportStep(logger, "Successfully clicked category tree", "PASS");
		}else {

			reportStep(logger, "Not able to click category tree", "FAIL");
		}

		switch (str_Category) {
		case "Top Deals": {

			if(jsClickByXpath(driver, TopDealsCategory)) {

				reportStep(logger, "Successfully clicked: "+str_Category, "PASS");
			}else {

				reportStep(logger, "Not able to click: "+str_Category, "FAIL");
			}

		}

			break;

		case "Fashion": {

			if(jsClickByXpath(driver, FashionCategory)) {

				reportStep(logger, "Successfully clicked: "+str_Category, "PASS");
			}else {

				reportStep(logger, "Not able to click: "+str_Category, "FAIL");
			}

		}

			break;

		case "Electronics": {

			if(jsClickByXpath(driver, ElectronicsCategory)) {

				reportStep(logger, "Successfully clicked: "+str_Category, "PASS");
			}else {

				reportStep(logger, "Not able to click: "+str_Category, "FAIL");
			}

		}
			break;

		case "Travel": {

			if(jsClickByXpath(driver, TravelCategory)) {

				reportStep(logger, "Successfully clicked: "+str_Category, "PASS");
			}else {

				reportStep(logger, "Not able to click: "+str_Category, "FAIL");
			}

		}
			break;

		case "Grocery": {

			if(jsClickByXpath(driver, GroceryCategory)) {

				reportStep(logger, "Successfully clicked: "+str_Category, "PASS");
			}else {

				reportStep(logger, "Not able to click: "+str_Category, "FAIL");
			}

		}

			break;

		case "Food": {

			if(jsClickByXpath(driver, DiningCategory)) {

				reportStep(logger, "Successfully clicked: "+str_Category, "PASS");
			}else {

				reportStep(logger, "Not able to click: "+str_Category, "FAIL");
			}

		}

			break;

		case "Beauty": {

			if(jsClickByXpath(driver, BeautyCategory)) {

				reportStep(logger, "Successfully clicked: "+str_Category, "PASS");
			}else {

				reportStep(logger, "Not able to click: "+str_Category, "FAIL");
			}

		}
			break;

		case "Health": {

			if(jsClickByXpath(driver, HealthCategory)) {

				reportStep(logger, "Successfully clicked: "+str_Category, "PASS");
			}else {

				reportStep(logger, "Not able to click: "+str_Category, "FAIL");
			}

		}
			break;
			
		}	

		reportStep(logger,
				"Successfully clicked - SeeCouponsWithCB button and navigated to unsigned VIP", "PASS");
	}
		
	/* Click Category Check Box */
	public void clickJioVoucherCategory(WebDriver driver, String str_Category) throws InterruptedException, AWTException {

		this.clickCategoryTab(driver);
		this.clickJioCategoryCheckbox(driver, str_Category);

	}
	
	/* Select Cashback Offer Type */
	public String selectCashbackOfferType(WebDriver driver ,String strCB_Offer_Type) throws InterruptedException {

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, dropDown_Select_Cashback_Offer_Type, strCB_Offer_Type)) {

			reportStep(logger, "Successfully selected value "+strCB_Offer_Type+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strCB_Offer_Type+" from dropdown", "FAIL");
		}
		
		return strCB_Offer_Type;
	}

	/* Enter Code */
	public String enterCode(WebDriver driver ,String str_CODE) throws InterruptedException {
		
		reportStep(logger, "About to enter Voucher code: "+ str_CODE, "INFO");		
		
		if(enterTextByID(driver, textBox_Code, str_CODE)) {

			reportStep(logger, "Successfully entered Voucher code: "+ str_CODE, "PASS");
		}else {

			reportStep(logger, "Not able to enter Voucher code: "+ str_CODE, "FAIL");
		}
		
		return str_CODE;
	}

	/* Click Edit Icon */
	public void clickEditOneVoucher(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to edit icon", "INFO");

		if(jsClickByXpath(driver, icon_Edit_First_Voucher)) {

			reportStep(logger, "Successfully clicked edit icon", "PASS");
		}else {

			reportStep(logger, "Not able to click edit icon", "FAIL");
		}
	}	
	
	/* Click Edit Icon */
	public void clickEditTwoVoucher(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to edit icon", "INFO");

		if(jsClickByXpath(driver, icon_Edit_Second_Voucher)) {

			reportStep(logger, "Successfully clicked edit icon", "PASS");
		}else {

			reportStep(logger, "Not able to click edit icon", "FAIL");
			
		}
	}

	/* Retreive store id after searching the store */
	public String getVoucherID(WebDriver driver, int int_Index) throws InterruptedException {
		
		if(isElementLocatedByXpathPresent(driver, textVoucherID)) {

			reportStep(logger, "Validated voucher ID text", "PASS");
		}else {

			reportStep(logger, "Not able to validate voucher ID text", "FAIL");
			
		}
		
		String xpath = "(//td[@aria-describedby='all_list_voucherid'])["+int_Index+"]";

		String str_VoucherId = getTextByXpath(driver, xpath);
		
		return str_VoucherId;
	}

	/* Retreive store id after searching the store */
	public String getVoucherCount(WebDriver driver) throws InterruptedException {

		reportStep(logger,"About to get the voucher count", "INFO");
		
		String xpath = "//tr[@role='row'][contains(@class,'ui-widget-content jqgrow ui-row-ltr')]";
		
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		   
		int int_VoucherCount = list.size();
		
		String string_VoucherCount = Integer.toString(int_VoucherCount);
		
		reportStep(logger,"Successfully retrieved voucher count: "+string_VoucherCount, "PASS");
		
		return string_VoucherCount;
	}

	public  String[] category_Checkbox_Value(WebDriver driver) throws InterruptedException, AWTException {
				
		String strCategoryName = "Popular Today";
		
		String[] array_Category_Names = new String[] {strCategoryName};
		
		return array_Category_Names;
	}
	
	/* Selecting newVoucher_ExitClick_Count in AddNewVoucher page */
	public String getExitClickCount(WebDriver driver) throws InterruptedException {
		
		String id = "exitclicks";
		String value = "900000";
		
		reportStep(logger, "About to enter voucher exit click: "+value, "INFO");		
		
		if(enterTextByID(driver, id, value)) {

			reportStep(logger, "Successfully entered voucher exit click: "+value, "PASS");
		}else {

			reportStep(logger, "Not able to enter voucher exit click: "+value, "FAIL");
		}

		String exitClickCount = getAttributeByID(driver, id);
		
		return exitClickCount;
	}

	public String getExitClickCount(WebDriver driver, String value) throws InterruptedException {
		
		String id = "exitclicks";
		
		reportStep(logger, "About to enter voucher exit click: "+value, "INFO");		
		
		if(enterTextByID(driver, id, value)) {

			reportStep(logger, "Successfully entered voucher exit click: "+value, "PASS");
		}else {

			reportStep(logger, "Not able to enter voucher exit click: "+value, "FAIL");
		}

		String exitClickCount = getAttributeByID(driver, id);
		
		return exitClickCount;
	}

	/* Get Issue Date */
	public String getIssueDate_Voucher(WebDriver driver) throws InterruptedException {

		String issueDate = "issuedate";

		reportStep(logger, "About to get calendar secondary cashback issue date", "INFO");		

		String calendarSecondaryIssueDate = getAttributeByID(driver, issueDate);
		
		reportStep(logger,"Successfully got calendar secondary cashback issue date: "+calendarSecondaryIssueDate, "PASS");
		
		return calendarSecondaryIssueDate;
	}
	
	/* Get Issue Time */
	public String getIssueTime_Voucher(WebDriver driver) throws InterruptedException {

		String issueTime = "issuetime";

		reportStep(logger, "About to get calendar secondary cashback issue time", "INFO");		

		String calendarSecondaryIssueTime = getAttributeByID(driver, issueTime);
		
		reportStep(logger,"Successfully got calendar secondary cashback issue time: "+calendarSecondaryIssueTime, "PASS");
		
		return calendarSecondaryIssueTime;
	}
	
	/* Get Expiry Date */
	public String getExpiryDate_Voucher(WebDriver driver) throws InterruptedException {

		String expiryDate = "expirydate";

		reportStep(logger, "About to get calendar secondary cashback expiry date", "INFO");		

		String calendarSecondaryExpiryDate = getAttributeByID(driver, expiryDate);
		
		reportStep(logger,"Successfully got calendar secondary cashback expiry date: "+calendarSecondaryExpiryDate, "PASS");
		
		return calendarSecondaryExpiryDate;
	}
	
	/* Get Expiry Time */
	public String getExpiryTime_Voucher(WebDriver driver) throws InterruptedException {

		String expiryTime = "expirytime";

		reportStep(logger, "About to get calendar secondary cashback expiry time", "INFO");		

		String calendarSecondaryExpiryTime = getAttributeByID(driver, expiryTime);
		
		reportStep(logger,"Successfully got calendar secondary cashback expiry time: "+calendarSecondaryExpiryTime, "PASS");
		
		return calendarSecondaryExpiryTime;
	
	}

	/* Get Voucher Type */
	public String getVoucherType(WebDriver driver, String str_VoucherName, int int_Index) throws InterruptedException {
		
		String xpath = "(//td[@title='"+str_VoucherName.trim()+"']/following::td[4])["+int_Index+"]";
		
		String str_VoucherType = getTextByXpath(driver, xpath);
		
		return str_VoucherType;

	}

	/* Enter Search Criteria */
	public void enterSearchCriteria(WebDriver driver) throws InterruptedException {
		
		String dropdownValue = "Store Name";

		if(selectValuesFromDropdownUsingID(driver, dropDown_StoreName, dropdownValue)) {

			reportStep(logger, "Successfully selected dropdown value", "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value", "FAIL");
		}

	}
	
	/* Click Search */
	public void clickSearch(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click  search button", "INFO");
		
		String id = "btn_Submit";

		if(jsClickByID(driver, id)) {

			reportStep(logger, "Successfully clicked search button", "PASS");
		}else {

			reportStep(logger, "Not able to click search button", "FAIL");
		}
		

		if(isElementLocatedByIDPresent(driver, list_Of_Vouchers)) {

			reportStep(logger, "Successfully validated list of vouchers", "PASS");
		}else {

			reportStep(logger, "Not able to  validate list of vouchers", "FAIL");
		}
		
	}

	/* Enter Value */
	public String enterStoreName(WebDriver driver, String str_StoreName) throws InterruptedException {

		reportStep(logger, "About to enter text: "+str_StoreName, "INFO");

		if(enterTextByID(driver, input_Keyword_StoreName, str_StoreName)) {

			reportStep(logger, "Successfully entered text: "+str_StoreName, "PASS");
		}else {

			reportStep(logger, "Not able to enter text: "+str_StoreName, "FAIL");
		}
		
		return str_StoreName;
	}
	
	/* Click Device Type & Enter Voucher Name */
	public void clickDeviceType_EnterVoucherNameWithoutCode(WebDriver driver,String[] array_StoreName, String str_DeviceName) throws InterruptedException{

		String string_DeviceName = str_DeviceName;

		switch (string_DeviceName) {

		case "All": {

			this.clickDeviceTypeDesktop(driver);
			this.clickDeviceTypeMobile(driver);
			this.clickDeviceTypeTablet(driver);
			this.clickDeviceTypeApp(driver);

		}
		break;

		case "Desktop": {

			this.clickDeviceTypeDesktop(driver);

		}
		break;

		case "Mobile": {

			this.clickDeviceTypeMobile(driver);

		}
		break;

		case "Tablet": {

			this.clickDeviceTypeTablet(driver);
		}
		break;

		case "App": {

			this.clickDeviceTypeApp(driver);
		}
		break;
		}

		this.enterWithoutCodeVoucherNameForApp(driver, array_StoreName[0].trim());

	}

	/* Click Device Type & Enter Voucher Name */
	public void clickDeviceType_EnterVoucherNameWithCode(WebDriver driver,String[] array_StoreName, String str_DeviceName) throws InterruptedException{

		String string_DeviceName = str_DeviceName;

		switch (string_DeviceName) {

		case "All": {

			this.clickDeviceTypeDesktop(driver);
			this.clickDeviceTypeMobile(driver);
			this.clickDeviceTypeTablet(driver);
			this.clickDeviceTypeApp(driver);

		}
		break;

		case "Desktop": {

			this.clickDeviceTypeDesktop(driver);

		}
		break;

		case "Mobile": {

			this.clickDeviceTypeMobile(driver);

		}
		break;

		case "Tablet": {

			this.clickDeviceTypeTablet(driver);
		}
		break;

		case "App": {

			this.clickDeviceTypeApp(driver);
		}
		break;
		}


		this.enterWithCodeVoucherNameForApp(driver, array_StoreName[0].trim());

	}

	/* Enter App Description */
	public String enterAppParagraphDescription(WebDriver driver) throws InterruptedException {

		strnewVoucher_Para_Description = ("This is Test Automation entering app paragraph description for the voucher");
		
		reportStep(logger, "About to enter voucher app paragraph description: "+strnewVoucher_Para_Description, "INFO");		
		
		if(enterTextByID(driver, textarea_App_Description, strnewVoucher_Para_Description)) {

			reportStep(logger, "Successfully entered voucher app paragraph description: "+strnewVoucher_Para_Description, "PASS");
		}else {

			reportStep(logger, "Not able to enter voucher app paragraph description: "+strnewVoucher_Para_Description, "FAIL");
		}

		return strnewVoucher_Para_Description ;

	}

	/* Enter App Description */
	public String enterAppParagraphDescription(WebDriver driver, String strnewVoucher_App_Para_Description) throws InterruptedException {
		
		reportStep(logger, "About to enter voucher app paragraph description: "+strnewVoucher_Para_Description, "INFO");		
		
		if(enterTextByID(driver, textarea_App_Description, strnewVoucher_Para_Description)) {

			reportStep(logger, "Successfully entered voucher app paragraph description: "+strnewVoucher_Para_Description, "PASS");
		}else {

			reportStep(logger, "Not able to enter voucher app paragraph description: "+strnewVoucher_Para_Description, "FAIL");
		}

		return strnewVoucher_Para_Description ;

	}

	/* Enter App Description */
	public String enterCashbackText(WebDriver driver, String strCashbackText) throws InterruptedException {
		
		reportStep(logger, "About to enter voucher CashbackText: "+strCashbackText, "INFO");		
		
		if(enterTextByID(driver, textarea_CashbackText, strCashbackText)) {

			reportStep(logger, "Successfully entered voucher CashbackText: "+strCashbackText, "PASS");
		}else {

			reportStep(logger, "Not able to enter voucher CashbackText: "+strCashbackText, "FAIL");
		}

		return strCashbackText ;

	}

	/* Set Expiry Time */
	public void set_ExpiryTime_MinutesSeconds(WebDriver driver) throws InterruptedException{

		reportStep(logger, "About to set the expiry time", "INFO");
		
		isElementLocatedByIDPresent(driver, str_Timer);
		String str_Timer_Value = driver.findElement(By.xpath(str_Timer)).getText();
		StringUtils.substringBefore(str_Timer_Value, "(BST)").trim();
		
		Date objDate = new Date();
		DateFormat objDateFormat = new SimpleDateFormat("HH");
		objDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime = objDateFormat.format(objDate); 
		int int_Hour = Integer.parseInt(txnDateTime)-1;		
		String string_Hours =String.valueOf(int_Hour);  

		reportStep(logger, "Hours::: "+string_Hours, "PASS");

		Date objDate1 = new Date();
		DateFormat objDateFormat1 = new SimpleDateFormat("mm");
		objDateFormat1.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime1 = objDateFormat1.format(objDate1); 
		int int_Minutes = Integer.parseInt(txnDateTime1)+12;		
		String string_Minutes =String.valueOf(int_Minutes);  

		reportStep(logger, "Minutes::: "+string_Minutes, "PASS");
		
		set_Expiry_Time(driver, input_Time_Expiry_Date, string_Hours, string_Minutes);

		reportStep(logger, "Sucessfully set expiry time", "PASS");

	}

	/* Set Expiry Time */
	public void set_ExpiryTime_HoursMinutes(WebDriver driver) throws InterruptedException{

		reportStep(logger, "About to set expiry time", "INFO");
		
		isElementLocatedByIDPresent(driver, str_Timer);
		String str_Timer_Value = driver.findElement(By.xpath(str_Timer)).getAttribute("innerHTML");
		StringUtils.substringBefore(str_Timer_Value, "(BST)").trim();
		
		Date objDate = new Date();
		DateFormat objDateFormat = new SimpleDateFormat("HH");
		objDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime = objDateFormat.format(objDate); 
		int int_Hour = Integer.parseInt(txnDateTime)+5;		
		String string_Hours =String.valueOf(int_Hour);  

		reportStep(logger, "Hours::: "+string_Hours, "PASS");

		Date objDate1 = new Date();
		DateFormat objDateFormat1 = new SimpleDateFormat("mm");
		objDateFormat1.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime1 = objDateFormat1.format(objDate1); 
		int int_Minutes = Integer.parseInt(txnDateTime1);		
		String string_Minutes =String.valueOf(int_Minutes);  

		reportStep(logger, "Minutes::: "+string_Minutes, "PASS");
		
		set_Expiry_Time(driver, input_Time_Expiry_Date, string_Hours, string_Minutes);

		reportStep(logger, "Sucessfully set expiry time", "PASS");

	}

	//*************************************************** Create Voucher *******************************************************************************************

	public String[] enterVoucherWithoutCodeDetails_APITesting(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");
		String strNewVoucher_Desc		= this.enterDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);	
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);
		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, array_CategoryValues[0], strNewVoucher_ExitClick, 
				strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 

		return arrayNewVoucher_Without_Code;
	}

	public String[] enterVoucherWithCodeDetails_APITesting(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);	
		

		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");				
		String strNewVoucher_Desc		= this.enterDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);

		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE, array_CategoryValues[0], 
				strNewVoucher_ExitClick, strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 


		return arrayNewVoucher_With_Code;

	}

	//*************************************************** Create Voucher *******************************************************************************************

	public String[] enterVoucherWithoutCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);

		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_Without_Code = new String[] {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, array_CategoryValues[0], strNewVoucher_ExitClick, 
				strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 

		return arrayNewVoucher_Without_Code;
	}

	public String[] enterVoucherWithCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);	
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");				
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);

		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);

		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE, 
				array_CategoryValues[0], strNewVoucher_ExitClick, strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 


		return arrayNewVoucher_With_Code;

	}

	public String[] enterVoucherWithoutCodeDetails_SelectCategoryPassingParameter(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId, String selectCategory) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver, selectCategory);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);

		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_Without_Code = new String[] {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, array_CategoryValues[0], strNewVoucher_ExitClick, 
				strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 

		return arrayNewVoucher_Without_Code;
	}

	public String[] enterVoucherWithCodeDetails_SelectCategoryPassingParameter(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId, String selectCategory) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);	
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");				
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);

		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver, selectCategory);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);

		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE, 
				array_CategoryValues[0], strNewVoucher_ExitClick, strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 


		return arrayNewVoucher_With_Code;

	}

	//*************************************************** Create Voucher *******************************************************************************************

	public String[] enterExpiredVoucherWithCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);				
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_PreviousDate(driver);

		this.clickVoucherCategory(driver);	
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,
				strNewVoucher_userType,strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE}; 
		
		return arrayNewVoucher_With_Code;
		
	}

	public String[] enterExpiredVoucherWithoutCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);			
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);

		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_PreviousDate(driver);

		reportStep(logger, "Mapping the store..", "PASS");
		this.clickVoucherCategory(driver);

		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType}; 

		return arrayNewVoucher_Without_Code;
	}

	public String[] enterPostScheduledVoucherWithCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);			
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		this.setIssueDate_NextDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);

		this.clickVoucherCategory(driver);
		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE}; 

		return arrayNewVoucher_With_Code;

	}

	public String[] enterPostScheduledVoucherWithoutCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);				
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		this.setIssueDate_NextDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);

		this.clickVoucherCategory(driver);
		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,
				strNewVoucher_userType,strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType}; 

		return arrayNewVoucher_Without_Code;
	}

	//*************************************************** Create Voucher *******************************************************************************************

	public String[] enterInactiveVoucherWithoutCodeDetails(WebDriver driver,String Str, String strCB_Offer_Type, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,Str, str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,Str);
		this.clickDeviceTypeDesktop(driver);
		this.clickDeviceTypeMobile(driver);
		this.clickDeviceTypeTablet(driver);
		this.clickDeviceTypeApp(driver);
		this.enterWithoutCodeVoucherNameForApp(driver,Str.trim());
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusInActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);

		this.clickVoucherCategory(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType}; 
		
		return arrayNewVoucher_Without_Code;
	}
	
	public String[] enterInactiveVoucherWithCodeDetails(WebDriver driver,String Str, String strCB_Offer_Type, String str_CODE, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,Str, str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,Str);
		this.clickDeviceTypeDesktop(driver);
		this.clickDeviceTypeMobile(driver);
		this.clickDeviceTypeTablet(driver);
		this.clickDeviceTypeApp(driver);
		this.enterWithCodeVoucherNameForApp(driver,Str.trim());
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusInActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);

		this.clickVoucherCategory(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE}; 
		
		return arrayNewVoucher_With_Code;
		
	}

	public String[] enterInactiveVoucherWithoutCodeDetails_APITesting(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");
		String strNewVoucher_Desc		= this.enterDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusInActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);

		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,
				strNewVoucher_userType,strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, 
				array_CategoryValues[0], strNewVoucher_ExitClick, strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 

		return arrayNewVoucher_Without_Code;
	}

	public String[] enterInactiveVoucherWithCodeDetails_APITesting(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);	
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");				
		String strNewVoucher_Desc		= this.enterDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusInActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);

		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE, 
				array_CategoryValues[0], strNewVoucher_ExitClick, strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 


		return arrayNewVoucher_With_Code;

	}

	//*************************************************** Create Voucher *******************************************************************************************

	public String[] change_StatusInactiveToStatusActiveVoucherWithoutCode(WebDriver driver,String Str, String str_StoreId) throws InterruptedException {
		
		String strNewStore_selection 	= this.selectStore(driver,Str, str_StoreId);
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Status,strNewVoucher_Details}; 
		
		return arrayNewVoucher_Without_Code;
	}
	
	public String[] change_StatusInactiveToStatusActiveVoucherWithCode(WebDriver driver,String Str, String str_StoreId) throws InterruptedException {
		
		String strNewStore_selection 	= this.selectStore(driver, Str, str_StoreId);
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Status,strNewVoucher_Details}; 
		
		return arrayNewVoucher_With_Code;
		
	}
	
	public String[] change_StatusActiveToStatusInactiveVoucherWithoutCode(WebDriver driver,String Str, String str_StoreId) throws InterruptedException {
		
		String strNewStore_selection 	= this.selectStore(driver,Str, str_StoreId);
		String strNewVoucher_Status		= this.selectStatusInActive(driver);
		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Status,strNewVoucher_Details}; 
		
		return arrayNewVoucher_Without_Code;
	}
	
	public String[] change_StatusActiveToInactiveVoucherWithCode(WebDriver driver,String Str, String str_StoreId) throws InterruptedException {
		
		String strNewStore_selection 	= this.selectStore(driver,Str, str_StoreId);
		String strNewVoucher_Status		= this.selectStatusInActive(driver);
		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Status,strNewVoucher_Details}; 
		
		return arrayNewVoucher_With_Code;
		
	}

	//*************************************************** Create Voucher *******************************************************************************************

	public String[] enterNewUserVoucherWithoutCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_Desc		= this.enterListDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);

		this.clickVoucherCategory(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_App_Desc}; 
		
		return arrayNewVoucher_Without_Code;
	}
	
	public String[] enterNewUserVoucherWithCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);		
		String strNewVoucher_Desc		= this.enterTableDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);

		this.clickVoucherCategory(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,strNewVoucher_Status,
				strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE, strNewVoucher_App_Desc}; 
		
		return arrayNewVoucher_With_Code;
		
	}

	//*************************************************** Create Voucher *******************************************************************************************

	public String[] enterFirstVoucherWithoutCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_App_Title	= this.enterWithoutCodeVoucherNameForApp(driver, "Voucher One Without Code");
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver, "90006");
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver, "Details For Voucher :One");
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		this.enterCashbackText(driver, "Coupons Cashback & Rewards");
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);
		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_Without_Code = new String[] {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, array_CategoryValues[0], strNewVoucher_ExitClick, 
				strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc, strNewVoucher_App_Title}; 

		return arrayNewVoucher_Without_Code;
	}

	public String[] enterSecondVoucherWithCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);	
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);
		String strNewVoucher_App_Title	= this.enterWithCodeVoucherNameForApp(driver, "Voucher Two With Code");
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");				
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver, "90005");
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver, "Details For Voucher :Two");

		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		this.enterCashbackText(driver, "Coupons Cashback & Rewards");
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);
		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE, 
				array_CategoryValues[0], strNewVoucher_ExitClick, strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc, strNewVoucher_App_Title}; 


		return arrayNewVoucher_With_Code;

	}

	public String[] enterThirdVoucherWithoutCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_App_Title	= this.enterWithoutCodeVoucherNameForApp(driver, "Voucher Three Without Code");
		String strNewVoucher_Desc		= this.enterListDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver, "90004");
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver, "Details For Voucher : Three");
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		this.enterCashbackText(driver, "Coupons Cashback & Rewards");
		
		this.clickVoucherCategory(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_App_Desc, strNewVoucher_App_Title}; 
		
		return arrayNewVoucher_Without_Code;
	}

	public String[] enterFourthVoucherWithCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);	
		String strNewVoucher_App_Title	= this.enterWithCodeVoucherNameForApp(driver, "Voucher Four With Code");
		String strNewVoucher_Desc		= this.enterTableDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver, "90003");
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver, "Details For Voucher :Four");
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		this.enterCashbackText(driver, "Coupons Cashback & Rewards");

		this.clickVoucherCategory(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,strNewVoucher_Status,
				strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE, strNewVoucher_App_Desc, strNewVoucher_App_Title}; 
		
		return arrayNewVoucher_With_Code;
		
	}

	public String[] enterFifthVoucherWithoutCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_App_Title	= this.enterWithoutCodeVoucherNameForApp(driver, "Voucher Five Without Code");
		String strNewVoucher_Desc		= this.enterListDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver, "90002");
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver, "Details For Voucher :Five");
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		this.enterCashbackText(driver, "Coupons Cashback & Rewards");

		this.clickVoucherCategory(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_App_Desc, strNewVoucher_App_Title}; 
		
		return arrayNewVoucher_Without_Code;
	}

	public String[] enterSixthVoucherWithCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);	
		String strNewVoucher_App_Title	= this.enterWithCodeVoucherNameForApp(driver, "Voucher Six With Code");
		String strNewVoucher_Desc		= this.enterTableDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver, "90001");
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver, "Details For Voucher :Six");		
		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		this.enterCashbackText(driver, "Coupons Cashback & Rewards");

		this.clickVoucherCategory(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,strNewVoucher_Status,
				strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, strNewVoucher_CODE, strNewVoucher_App_Desc, strNewVoucher_App_Title}; 
		
		return arrayNewVoucher_With_Code;
		
	}

	public String[] enterSeventhVoucherWithoutCodeDetails(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String str_StoreId) throws InterruptedException, AWTException {

		this.clickAddNewVoucher(driver);
		

		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver,array[0].trim());
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_App_Title	= this.enterWithoutCodeVoucherNameForApp(driver, "Voucher Seven Without Code");
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver, "90000");
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver, "Details For Voucher :Seven");
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";
		this.enterCashbackText(driver, "Coupons Cashback & Rewards");

		this.clickVoucherCategory(driver);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);
		this.clickSaveVoucher(driver);

		String[] arrayNewVoucher_Without_Code = new String[] {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, array_CategoryValues[0], strNewVoucher_ExitClick, 
				strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc, strNewVoucher_App_Title}; 

		return arrayNewVoucher_Without_Code;
	}

	//*************************************************** Create Voucher *******************************************************************************************

	public String[] enterVoucherWithoutCode_Jio(WebDriver driver,String[] array, String strCB_Offer_Type, String str_DeviceName, String strCategory, String str_Number, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithoutCodeVoucherName(driver, str_Number);
		this.clickDeviceType_EnterVoucherNameWithoutCode(driver, array, str_DeviceName);	
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForAllUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypePromotion(driver);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickJioVoucherCategory(driver, strCategory);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);
		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_Without_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,strNewVoucher_userType,
				strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, array_CategoryValues[0], strNewVoucher_ExitClick, 
				strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 
		
		return arrayNewVoucher_Without_Code;
	}
	
	public String[] enterVoucherWithCode_Jio(WebDriver driver,String[] array, String strCB_Offer_Type, String str_CODE, String str_DeviceName, String strCategory, String str_Number, String str_StoreId) throws InterruptedException, AWTException {
		
		this.clickAddNewVoucher(driver);	
		
		
		String strNewStore_selection 	= this.selectStore(driver,array[0].trim(), str_StoreId);
		String strNewVoucher_Name 		= this.enterWithCodeVoucherName(driver, str_Number);
		this.clickDeviceType_EnterVoucherNameWithCode(driver, array, str_DeviceName);
		String strNewVoucher_DeepLink	= this.enterDeepLink(driver, "https://www.myntra.com/");				
		String strNewVoucher_Desc		= this.enterParagraphDescription(driver);
		String strNewVoucher_userType	= this.selectVoucherApplyForNewUsers(driver); 
		String strNewVoucher_Status		= this.selectStatusActive(driver);
		String strNewVoucher_Type		= this.selectVoucherTypeCode(driver);
		String strNewVoucher_CODE		= this.enterCode(driver, str_CODE);
		String strNewVoucher_Details	= this.enterVoucherDetails(driver);
		String strNewVoucher_OfferType	= this.selectCashbackOfferType(driver, strCB_Offer_Type);
		String strNewVoucher_ExitClick	= this.getExitClickCount(driver);
		String strNewVoucher_App_Desc	= this.enterAppParagraphDescription(driver);		
		this.setIssueDate_PreviousDayFromCurrentDate(driver);
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		String strNewVoucher_Iss_DateTime = this.getIssueDate_Voucher(driver).trim()+"T"+getIssueTime_Voucher(driver).trim()+"Z";
		String strNewVoucher_Exp_DateTime = this.getExpiryDate_Voucher(driver).trim()+"T"+getExpiryTime_Voucher(driver).trim()+"Z";

		this.clickJioVoucherCategory(driver, strCategory);
		String array_CategoryValues[] 	= this.category_Checkbox_Value(driver);		
		this.clickSaveVoucher(driver);
		
		String[] arrayNewVoucher_With_Code = new String[]  {strNewStore_selection,strNewVoucher_Name,strNewVoucher_Desc,
				strNewVoucher_userType,strNewVoucher_Status,strNewVoucher_Type,strNewVoucher_Details, strNewVoucher_OfferType, 
				strNewVoucher_CODE, array_CategoryValues[0], strNewVoucher_ExitClick, strNewVoucher_DeepLink, strNewVoucher_Iss_DateTime, strNewVoucher_Exp_DateTime, strNewVoucher_App_Desc}; 
			
		return arrayNewVoucher_With_Code;
		
	}

}