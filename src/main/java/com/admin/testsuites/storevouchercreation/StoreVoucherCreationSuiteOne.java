package com.admin.testsuites.storevouchercreation;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.asserts.SoftAssert;

import com.admin.base.StoresCCL;
import com.admin.base.WrapperMethods;
import com.admin.pages.AdminCoreFunction;
import com.admin.pages.AffillateNetwork;
import com.admin.pages.Dashboard;
import com.admin.pages.Login;
import com.admin.pages.ProductBrowserEditMode;
import com.admin.pages.Stores;
import com.admin.pages.Vouchers;


public class StoreVoucherCreationSuiteOne extends WrapperMethods {

	/*************************************************************************************************************************************************************************************/
	/** 										 Cashback Store one - Creation and Loading the Corresponding Dynamic Values into Json File							   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_One_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_One[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "", "", "Terms and conditions", "All", "999041", "72", "ACTIVATE CASHBACK", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_One[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_One[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_One[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Others_Details_One[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_One[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_One[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_One[0].trim());

			objAddStore.clickPickOfTheDayPickOfTheWeek_SpecificStore(driver, arrayNewStoreDetails_One[0].trim());

			driver.navigate().refresh();

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);

			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_One[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_One, "Increased Rate", "All", strStoreID);

			String arrayNewVoucher_With_Code_One[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_One, "Increased Rate", "COUPON CODE", "All", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_One[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_One[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_One[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);

			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_One[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_One_Details  = new String[] {arrayNewStoreDetails_One[0], arrayNewStoreDetails_One[1], arrayNewStoreDetails_One[2], arrayNewStoreDetails_One[3], arrayNewStore_Nor_PCBDetails_One[6].toString(),
					arrayNewStoreDetails_One[5], arrayNewStoreDetails_One[7], arrayNewStoreDetails_One[10], arrayNewStoreDetails_One[11], arrayNewStore_Nor_PCBDetails_One[0].toString(), 
					arrayNewStore_Nor_PCBDetails_One[4].toString(), arrayNewStore_Nor_PCBDetails_One[5].toString(), arrayNewStore_Nor_SCBDetails_One[1].toString(), arrayNewStore_Nor_SCBDetails_One[2].toString(), 
					arrayNewStore_Nor_SCBDetails_One[3].toString(), arrayNewVoucher_Without_Code_One[1], arrayNewVoucher_Without_Code_One[2], arrayNewVoucher_Without_Code_One[5], arrayNewVoucher_Without_Code_One[6], 
					arrayNewVoucher_Without_Code_One[7], arrayNewVoucher_With_Code_One[1], arrayNewVoucher_With_Code_One[2], arrayNewVoucher_With_Code_One[5], arrayNewVoucher_With_Code_One[6], 
					arrayNewVoucher_With_Code_One[7], arrayNewVoucher_With_Code_One[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_One[12], "" , 
					arrayNewVoucher_Without_Code_One[7], arrayNewVoucher_With_Code_One[9], arrayNewVoucher_Without_Code_One[8], arrayNewVoucher_With_Code_One[10], arrayNewVoucher_Without_Code_One[9], 
					arrayNewVoucher_Without_Code_One[10], arrayNewVoucher_With_Code_One[11], arrayNewVoucher_With_Code_One[12], arrayNewVoucher_With_Code_One[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_One[0]).toString(), arrayNewVoucher_With_Code_One[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_One[3], 
					arrayNewVoucher_Without_Code_One[11], arrayNewVoucher_Without_Code_One[12], arrayNewVoucher_With_Code_One[12], arrayNewVoucher_With_Code_One[13], arrayNewStore_Nor_PCBDetails_One[7].toString(),
					arrayNewStoreDetails_One[14], arrayNewStoreDetails_One[15], (arrayNewStore_Others_Details_One[1]).toString(), arrayNewVoucher_Without_Code_One[13], arrayNewVoucher_With_Code_One[14],
					arrayNewStoreDetails_One[16], arrayNewStoreDetails_One[17], arrayNewStoreDetails_One[18], arrayNewStoreDetails_One[19], arrayNewStoreDetails_One[20], arrayNewStoreDetails_One[21], arrayNewStoreDetails_One[22],
					arrayNewStoreDetails_One[23], arrayNewStoreDetails_One[24], arrayNewStore_Nor_PCBDetails_One[6].toString(), arrayNewStore_Nor_PCBDetails_One[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_One("CB", array_New_CashBack_Store_One_Details,"CB_Store_One");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		} catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_One");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger,"Store Creation has not been done", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store two - Creation and Loading the Corresponding Dynamic Values into Json File							   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test
	public void cashback_Store_Two_Creation(Method method) throws InterruptedException, AWTException{

		try{

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Two[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "", "", "Terms and conditions", "All", "999041", "72", "ACTIVATE CASHBACK", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Two[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Two[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Two[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Two[0]+" social message");

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_Two[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "Increased Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "All",0);

			Object arrayNewStore_Cal_SCBDetails_Two[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "All",0);

			Object arrayNewStore_Others_Details_Two[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Two[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Two[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Two[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);

			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Two[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Two, "Increased Rate", "All", strStoreID);

			String arrayNewVoucher_With_Code_Two[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Two, "Increased Rate", "COUPON CODE", "All", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Two[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Two[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Two[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);

			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Two[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Two_Details = new String[] {arrayNewStoreDetails_Two[0], arrayNewStoreDetails_Two[1], arrayNewStoreDetails_Two[2], arrayNewStoreDetails_Two[3], arrayNewStore_Cal_PCBDetails_Two[11].toString(),
					arrayNewStoreDetails_Two[5], arrayNewStoreDetails_Two[7], arrayNewStoreDetails_Two[10], arrayNewStoreDetails_Two[11], arrayNewStore_Cal_PCBDetails_Two[0].toString(), 
					arrayNewStore_Cal_PCBDetails_Two[6].toString(), arrayNewStore_Cal_PCBDetails_Two[5].toString(), arrayNewStore_Cal_SCBDetails_Two[1].toString(), arrayNewStore_Cal_SCBDetails_Two[2].toString(), 
					arrayNewStore_Cal_SCBDetails_Two[3].toString(), arrayNewVoucher_Without_Code_Two[1], arrayNewVoucher_Without_Code_Two[2], arrayNewVoucher_Without_Code_Two[5], arrayNewVoucher_Without_Code_Two[6], 
					arrayNewVoucher_Without_Code_Two[7], arrayNewVoucher_With_Code_Two[1], arrayNewVoucher_With_Code_Two[2], arrayNewVoucher_With_Code_Two[5], arrayNewVoucher_With_Code_Two[6], 
					arrayNewVoucher_With_Code_Two[7], arrayNewVoucher_With_Code_Two[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Two[12], "" , 
					arrayNewVoucher_Without_Code_Two[7], arrayNewVoucher_With_Code_Two[9], arrayNewVoucher_Without_Code_Two[8], arrayNewVoucher_With_Code_Two[10], arrayNewVoucher_Without_Code_Two[9], 
					arrayNewVoucher_Without_Code_Two[10], arrayNewVoucher_With_Code_Two[11], arrayNewVoucher_With_Code_Two[12], arrayNewVoucher_With_Code_Two[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Two[0]).toString(), arrayNewVoucher_With_Code_Two[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Two[3], 
					arrayNewVoucher_Without_Code_Two[11], arrayNewVoucher_Without_Code_Two[12], arrayNewVoucher_With_Code_Two[12], arrayNewVoucher_With_Code_Two[13], arrayNewStore_Cal_PCBDetails_Two[12].toString(),
					arrayNewStoreDetails_Two[14], arrayNewStoreDetails_Two[15], (arrayNewStore_Others_Details_Two[1]).toString(), arrayNewVoucher_Without_Code_Two[13], arrayNewVoucher_With_Code_Two[14],
					arrayNewStoreDetails_Two[16], arrayNewStoreDetails_Two[17], arrayNewStoreDetails_Two[18], arrayNewStoreDetails_Two[19], arrayNewStoreDetails_Two[20], arrayNewStoreDetails_Two[21], arrayNewStoreDetails_Two[22],
					arrayNewStoreDetails_Two[23], arrayNewStoreDetails_Two[24], arrayNewStore_Cal_PCBDetails_Two[11].toString(), arrayNewStore_Cal_PCBDetails_Two[12].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Two("CB", array_New_CashBack_Store_Two_Details,"CB_Store_Two");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		} catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Two");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger,"Store Creation has not been done", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store three - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test
	public void cashback_Store_Three_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Three[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "ACTIVATE CASHBACK", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			Object arrayNewStore_Nor_PCBDetails_Three[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Three[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			objAddStore.clickAddAnotherRow(driver);

			Object arrayNewStore_Nor_SCBDetails_Three_[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 1);

			Object arrayNewStore_Others_Details_Three[] = objAddStore.enterOthers(driver, "Terms and conditions");

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.click_Button_AddStore(driver);

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Three[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Three[] = objVouchers.enterVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Three, "Increased Rate", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Three_Details  = new String[] {arrayNewStoreDetails_Three[0], arrayNewVoucher_Without_Code_Three[1], arrayNewStore_Others_Details_Three[0].toString(), 
					arrayNewStoreDetails_Three[7], arrayNewStore_Nor_PCBDetails_Three[5].toString(), arrayNewStore_Nor_PCBDetails_Three[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Three[4].toString(), arrayNewStore_Nor_SCBDetails_Three[2].toString(), arrayNewStore_Nor_SCBDetails_Three[1].toString(), 
					arrayNewStore_Nor_SCBDetails_Three[3].toString(), arrayNewStore_Nor_SCBDetails_Three_[2].toString(), arrayNewStore_Nor_SCBDetails_Three_[1].toString(), 
					arrayNewStore_Nor_SCBDetails_Three_[3].toString(),
					arrayNewStoreDetails_Three[16], arrayNewStoreDetails_Three[17], arrayNewStoreDetails_Three[18], arrayNewStoreDetails_Three[19], arrayNewStoreDetails_Three[20], arrayNewStoreDetails_Three[21], arrayNewStoreDetails_Three[22],
					arrayNewStoreDetails_Three[23], arrayNewStoreDetails_Three[24], strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Three("CB", array_New_CashBack_Store_Three_Details,"CB_Store_Three");
			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Three");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger,"Store Creation has not been done", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store four - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Four_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Four[] = objAddStore.enterCashbackStoreDetails(driver, "In-Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			objAddStore.enterNormalShortDescription(driver);

			objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Four[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Four_Details  = new String[] {arrayNewStoreDetails_Four[0], strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Four("CB", array_New_CashBack_Store_Four_Details,"CB_Store_Four");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Four");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store five - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Five_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Five[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_Five[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "Exclusive Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Cal_SCBDetails_Five[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Exclusive Rate", "All", 0);

			objAddStore.clickAddAnotherRow(driver);

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 1);

			Object arrayNewStore_Cal_SCBDetails_Five_[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Exclusive Rate", "All", 1);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Five[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			objVouchers.enterVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Five, "Exclusive Rate", "All", strStoreID);

			objVouchers.enterVoucherWithCodeDetails(driver, arrayNewStoreDetails_Five, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Five_Details = new String[] {arrayNewStoreDetails_Five[0], arrayNewStore_Cal_PCBDetails_Five[6].toString(),  
					arrayNewStore_Cal_PCBDetails_Five[0].toString(),  arrayNewStore_Cal_PCBDetails_Five[5].toString(),  arrayNewStore_Cal_PCBDetails_Five[4].toString(), 
					arrayNewStore_Cal_SCBDetails_Five[2].toString(),  arrayNewStore_Cal_SCBDetails_Five[1].toString(),  arrayNewStore_Cal_SCBDetails_Five[3].toString(),  
					arrayNewStore_Cal_SCBDetails_Five[4].toString(), arrayNewStore_Cal_SCBDetails_Five_[2].toString(),  arrayNewStore_Cal_SCBDetails_Five_[1].toString(),  
					arrayNewStore_Cal_SCBDetails_Five_[3].toString(),  arrayNewStore_Cal_SCBDetails_Five_[4].toString(), strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Five("CB", array_New_CashBack_Store_Five_Details,"CB_Store_Five");
			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Five");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger,"Store Creation has not been done", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store six - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Six_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Six[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_Six[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "Exclusive Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Cal_SCBDetails_Six[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering calender Secondary cashback", "Exclusive Rate", "All", 0);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Six[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			objVouchers.enterExpiredVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Six, "Exclusive Rate", "All", strStoreID);

			objVouchers.enterPostScheduledVoucherWithCodeDetails(driver, arrayNewStoreDetails_Six, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Six[0]);

			objVouchers.clickSearch(driver);

			objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Six_Details = new String[] {arrayNewStoreDetails_Six[0], arrayNewStore_Cal_PCBDetails_Six[6].toString(),  
					arrayNewStore_Cal_PCBDetails_Six[0].toString(),  arrayNewStore_Cal_PCBDetails_Six[5].toString(),  arrayNewStore_Cal_PCBDetails_Six[4].toString(), 
					arrayNewStore_Cal_SCBDetails_Six[2].toString(),  arrayNewStore_Cal_SCBDetails_Six[1].toString(),  arrayNewStore_Cal_SCBDetails_Six[3].toString(),  
					arrayNewStore_Cal_SCBDetails_Six[4].toString(), arrayNewStoreDetails_Six[1], strStoreID, strVoucherID_One, strVoucherID_Two, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Six("CB", array_New_CashBack_Store_Six_Details,"CB_Store_Six");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Six");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger,"Store Creation has not been done", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store seven - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Seven_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Seven[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_Seven[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "Increased Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Cal_SCBDetails_Seven[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "All", 0);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Seven[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			objVouchers.enterPostScheduledVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Seven, "Increased Rate", "All", strStoreID);

			objVouchers.enterExpiredVoucherWithCodeDetails(driver, arrayNewStoreDetails_Seven, "Increased Rate", "COUPON CODE", "All", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Seven[0]);

			objVouchers.clickSearch(driver);

			objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Seven_Details = new String[] {arrayNewStoreDetails_Seven[0], arrayNewStore_Cal_PCBDetails_Seven[6].toString(),  
					arrayNewStore_Cal_PCBDetails_Seven[0].toString(),  arrayNewStore_Cal_PCBDetails_Seven[5].toString(),  arrayNewStore_Cal_PCBDetails_Seven[4].toString(), 
					arrayNewStore_Cal_SCBDetails_Seven[2].toString(),  arrayNewStore_Cal_SCBDetails_Seven[1].toString(),  arrayNewStore_Cal_SCBDetails_Seven[3].toString(),  
					arrayNewStore_Cal_SCBDetails_Seven[4].toString(), arrayNewStoreDetails_Seven[1], strStoreID, strVoucherID_One, strVoucherID_Two, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Seven("CB", array_New_CashBack_Store_Seven_Details,"CB_Store_Seven");	

			basedOnBooleanValuePrintsReport(value);		

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/


		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Seven");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}


	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store eight - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test
	public void cashback_Store_Eight_Creation(Method method) throws InterruptedException, AWTException{



		try{

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_One[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "", "", "Terms and conditions", "All", "999041", "72", "ACTIVATE CASHBACK", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_One[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_One[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_One[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Others_Details_One[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_One[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_One[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_One[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);

			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_One[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_One, "Increased Rate", "All", strStoreID);

			String arrayNewVoucher_With_Code_One[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_One, "Increased Rate", "COUPON CODE", "All", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_One[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_One[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_One[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);

			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_One[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Eight_Details = new String[] {arrayNewStoreDetails_One[0], arrayNewStoreDetails_One[1], arrayNewStoreDetails_One[2], arrayNewStoreDetails_One[3], arrayNewStore_Nor_PCBDetails_One[6].toString(),
					arrayNewStoreDetails_One[5], arrayNewStoreDetails_One[7], arrayNewStoreDetails_One[10], arrayNewStoreDetails_One[11], arrayNewStore_Nor_PCBDetails_One[0].toString(), 
					arrayNewStore_Nor_PCBDetails_One[4].toString(), arrayNewStore_Nor_PCBDetails_One[5].toString(), arrayNewStore_Nor_SCBDetails_One[1].toString(), arrayNewStore_Nor_SCBDetails_One[2].toString(), 
					arrayNewStore_Nor_SCBDetails_One[3].toString(), arrayNewVoucher_Without_Code_One[1], arrayNewVoucher_Without_Code_One[2], arrayNewVoucher_Without_Code_One[5], arrayNewVoucher_Without_Code_One[6], 
					arrayNewVoucher_Without_Code_One[7], arrayNewVoucher_With_Code_One[1], arrayNewVoucher_With_Code_One[2], arrayNewVoucher_With_Code_One[5], arrayNewVoucher_With_Code_One[6], 
					arrayNewVoucher_With_Code_One[7], arrayNewVoucher_With_Code_One[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_One[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_One[7], arrayNewVoucher_With_Code_One[9], arrayNewVoucher_Without_Code_One[8], arrayNewVoucher_With_Code_One[10], arrayNewVoucher_Without_Code_One[9], 
					arrayNewVoucher_Without_Code_One[10], arrayNewVoucher_With_Code_One[11], arrayNewVoucher_With_Code_One[12], arrayNewVoucher_With_Code_One[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_One[0]).toString(), arrayNewVoucher_With_Code_One[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_One[3], 
					arrayNewVoucher_Without_Code_One[11], arrayNewVoucher_Without_Code_One[12], arrayNewVoucher_With_Code_One[12], arrayNewVoucher_With_Code_One[13], arrayNewStore_Nor_PCBDetails_One[7].toString(),
					arrayNewStoreDetails_One[14], arrayNewStoreDetails_One[15], (arrayNewStore_Others_Details_One[1]).toString(), arrayNewVoucher_Without_Code_One[13], arrayNewVoucher_With_Code_One[14],
					arrayNewStoreDetails_One[16], arrayNewStoreDetails_One[17], arrayNewStoreDetails_One[18], arrayNewStoreDetails_One[19], arrayNewStoreDetails_One[20], arrayNewStoreDetails_One[21], arrayNewStoreDetails_One[22],
					arrayNewStoreDetails_One[23], arrayNewStoreDetails_One[24], arrayNewStore_Nor_PCBDetails_One[6].toString(), arrayNewStore_Nor_PCBDetails_One[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Eight("CB", array_New_CashBack_Store_Eight_Details,"CB_Store_Eight");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Eight");

			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}
	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store nine - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test
	public void cashback_Store_Nine_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Nine[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "ACTIVATE CASHBACK", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Nine[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Nine[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Nine[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Nine[0]+" social message");

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_Nine[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "Increased Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Cal_SCBDetails_Nine[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "All", 0);

			objAddStore.clickAddAnotherRow(driver);

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 1);

			Object arrayNewStore_Cal_SCBDetails_Eleven_[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "All", 1);

			Object arrayNewStore_Others_Details_Nine[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Nine[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Nine[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Nine[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);

			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Nine[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Nine, "Increased Rate", "All", strStoreID);

			String arrayNewVoucher_With_Code_Nine[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Nine, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Nine[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Nine[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Nine[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);

			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Nine[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Nine_Details = new String[] {arrayNewStoreDetails_Nine[0], arrayNewStoreDetails_Nine[1], arrayNewStoreDetails_Nine[2], arrayNewStoreDetails_Nine[3], arrayNewStore_Cal_PCBDetails_Nine[11].toString(),
					arrayNewStoreDetails_Nine[5], arrayNewStoreDetails_Nine[7], arrayNewStoreDetails_Nine[10], arrayNewStoreDetails_Nine[11], arrayNewStore_Cal_PCBDetails_Nine[0].toString(), 
					arrayNewStore_Cal_PCBDetails_Nine[6].toString(), arrayNewStore_Cal_PCBDetails_Nine[5].toString(), arrayNewStore_Cal_SCBDetails_Nine[1].toString(), arrayNewStore_Cal_SCBDetails_Nine[2].toString(), 
					arrayNewStore_Cal_SCBDetails_Nine[3].toString(), arrayNewVoucher_Without_Code_Nine[1], arrayNewVoucher_Without_Code_Nine[2], arrayNewVoucher_Without_Code_Nine[5], arrayNewVoucher_Without_Code_Nine[6], 
					arrayNewVoucher_Without_Code_Nine[7], arrayNewVoucher_With_Code_Nine[1], arrayNewVoucher_With_Code_Nine[2], arrayNewVoucher_With_Code_Nine[5], arrayNewVoucher_With_Code_Nine[6], 
					arrayNewVoucher_With_Code_Nine[7], arrayNewVoucher_With_Code_Nine[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Nine[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Nine[7], arrayNewVoucher_With_Code_Nine[9], arrayNewVoucher_Without_Code_Nine[8], arrayNewVoucher_With_Code_Nine[10], arrayNewVoucher_Without_Code_Nine[9], 
					arrayNewVoucher_Without_Code_Nine[10], arrayNewVoucher_With_Code_Nine[11], arrayNewVoucher_With_Code_Nine[12], arrayNewVoucher_With_Code_Nine[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Nine[0]).toString(), arrayNewVoucher_With_Code_Nine[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Nine[3], 
					arrayNewVoucher_Without_Code_Nine[11], arrayNewVoucher_Without_Code_Nine[12], arrayNewVoucher_With_Code_Nine[12], arrayNewVoucher_With_Code_Nine[13], arrayNewStore_Cal_PCBDetails_Nine[12].toString(),
					arrayNewStoreDetails_Nine[14], arrayNewStoreDetails_Nine[15], (arrayNewStore_Others_Details_Nine[1]).toString(), arrayNewVoucher_Without_Code_Nine[13], arrayNewVoucher_With_Code_Nine[14], arrayNewStore_Cal_SCBDetails_Nine[6].toString(), arrayNewStore_Cal_PCBDetails_Nine[8].toString(),
					arrayNewStore_Cal_SCBDetails_Eleven_[1].toString(),arrayNewStore_Cal_SCBDetails_Eleven_[3].toString(),arrayNewStore_Cal_SCBDetails_Eleven_[2].toString()
					,arrayNewStore_Cal_SCBDetails_Eleven_[4].toString(), 
					arrayNewStoreDetails_Nine[16], arrayNewStoreDetails_Nine[17], arrayNewStoreDetails_Nine[18], arrayNewStoreDetails_Nine[19], arrayNewStoreDetails_Nine[20], arrayNewStoreDetails_Nine[21], arrayNewStoreDetails_Nine[22],
					arrayNewStoreDetails_Nine[23], arrayNewStoreDetails_Nine[24], arrayNewStore_Cal_PCBDetails_Nine[11].toString(), arrayNewStore_Cal_PCBDetails_Nine[12].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Nine("CB", array_New_CashBack_Store_Nine_Details,"CB_Store_Nine");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Nine");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store ten - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Ten_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Ten[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "ACTIVATE CASHBACK", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Others_Details_Ten[] = objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Ten[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/
			
			String arrayVoucherOneName[] = {"one"};
			String arrayVoucherTwoName[] = {"two"};
			String arrayVoucherThreeName[] = {"three"};

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Ten[] = objVouchers.enterVoucherWithoutCodeDetails_SelectCategoryPassingParameter(driver, arrayVoucherOneName, "Exclusive Rate", "All", strStoreID, "categoryOne");

			String arrayNewVoucher_With_Code_Ten[] = objVouchers.enterVoucherWithCodeDetails_SelectCategoryPassingParameter(driver, arrayVoucherTwoName, "Exclusive Rate", "COUPON CODE", "All", strStoreID, "categoryTwo");

			String arrayNewVoucher_Without_Code_Ten_One[] = objVouchers.enterVoucherWithoutCodeDetails_SelectCategoryPassingParameter(driver, arrayVoucherThreeName, "Exclusive Rate", "All", strStoreID, "categoryThree");

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Ten_Details = new String[] {arrayNewStoreDetails_Ten[0], arrayNewVoucher_Without_Code_Ten[1], arrayNewStore_Others_Details_Ten[0].toString(), 
					arrayNewStoreDetails_Ten[7], arrayNewStoreDetails_Ten[16], arrayNewStoreDetails_Ten[17], arrayNewStoreDetails_Ten[18], arrayNewStoreDetails_Ten[19], arrayNewStoreDetails_Ten[20], arrayNewStoreDetails_Ten[21], arrayNewStoreDetails_Ten[22],
					arrayNewStoreDetails_Ten[23], arrayNewStoreDetails_Ten[24], arrayNewVoucher_With_Code_Ten[1], arrayNewVoucher_Without_Code_Ten_One[1], strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Ten("CB", array_New_CashBack_Store_Ten_Details,"CB_Store_Ten");	

			basedOnBooleanValuePrintsReport(value);		

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/


		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Ten");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store eleven - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Eleven_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Eleven[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickSEOTab(driver);

			objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Eleven[0]);

			objAddStore.enterMetaTags(driver, "This Is Test automation meta tag");

			objAddStore.enterProductMetaTags(driver, "This Is Test automation product meta tag");

			objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Eleven[0]+" social message");

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_Eleven[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "Increased Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Cal_SCBDetails_Eleven[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "All", 0);

			objAddStore.clickAddAnotherRow(driver);

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 1);

			Object arrayNewStore_Cal_SCBDetails_Eleven_[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 1, "Percentage", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "All", 1);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.StoreContent_Creation(driver);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Eleven[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Eleven_One[] = objVouchers.enterFirstVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Eleven, "Exclusive Rate", "All", strStoreID);

			String arrayNewVoucher_With_Code_Eleven_Two[] = objVouchers.enterSecondVoucherWithCodeDetails(driver, arrayNewStoreDetails_Eleven, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			String arrayNewVoucher_Without_Code_Eleven_Three[] = objVouchers.enterThirdVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Eleven, "Increased Rate", "All", strStoreID);

			String arrayNewVoucher_With_Code_Eleven_Four[] = objVouchers.enterFourthVoucherWithCodeDetails(driver, arrayNewStoreDetails_Eleven, "Increased Rate", "COUPON CODE", "All", strStoreID);

			String arrayNewVoucher_Without_Code_Eleven_Five[] = objVouchers.enterFifthVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Eleven, "Increased Rate", "All", strStoreID);

			String arrayNewVoucher_With_Code_Eleven_Six[] = objVouchers.enterSixthVoucherWithCodeDetails(driver, arrayNewStoreDetails_Eleven, "Increased Rate", "COUPON CODE", "All", strStoreID);

			String arrayNewVoucher_Without_Code_Eleven_Seven[] = objVouchers.enterSeventhVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Eleven, "Exclusive Rate", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Eleven_Details = new String[] {arrayNewStoreDetails_Eleven[0], arrayNewStoreDetails_Eleven[1], arrayNewStore_Cal_PCBDetails_Eleven[11].toString(), 
					arrayNewStoreDetails_Eleven[5], arrayNewVoucher_Without_Code_Eleven_One[1], arrayNewVoucher_Without_Code_Eleven_One[2], arrayNewVoucher_With_Code_Eleven_Two[0], 
					arrayNewVoucher_With_Code_Eleven_Two[1], arrayNewVoucher_With_Code_Eleven_Two[2], arrayNewVoucher_With_Code_Eleven_Two[8], arrayNewVoucher_Without_Code_Eleven_Three[0], 
					arrayNewVoucher_Without_Code_Eleven_Three[1], arrayNewVoucher_Without_Code_Eleven_Three[2], arrayNewVoucher_With_Code_Eleven_Four[0], 
					arrayNewVoucher_With_Code_Eleven_Four[1], arrayNewVoucher_With_Code_Eleven_Four[2], arrayNewVoucher_With_Code_Eleven_Four[8], 
					arrayNewVoucher_Without_Code_Eleven_Five[0], arrayNewVoucher_Without_Code_Eleven_Five[1], arrayNewVoucher_Without_Code_Eleven_Five[2], 
					arrayNewVoucher_With_Code_Eleven_Six[0], arrayNewVoucher_With_Code_Eleven_Six[1], arrayNewVoucher_With_Code_Eleven_Six[2], 
					arrayNewVoucher_With_Code_Eleven_Six[8], arrayNewVoucher_Without_Code_Eleven_Seven[0], arrayNewVoucher_Without_Code_Eleven_Seven[1], 
					arrayNewVoucher_Without_Code_Eleven_Seven[2], arrayNewStore_Cal_PCBDetails_Eleven[6].toString(),  arrayNewStore_Cal_PCBDetails_Eleven[0].toString(),  
					arrayNewStore_Cal_PCBDetails_Eleven[5].toString(),  arrayNewStore_Cal_PCBDetails_Eleven[4].toString(), arrayNewStore_Cal_SCBDetails_Eleven[2].toString(),  
					arrayNewStore_Cal_SCBDetails_Eleven[1].toString(),  arrayNewStore_Cal_SCBDetails_Eleven[3].toString(),  arrayNewStore_Cal_SCBDetails_Eleven[4].toString(), 
					arrayNewStore_Cal_SCBDetails_Eleven_[2].toString(),  arrayNewStore_Cal_SCBDetails_Eleven_[1].toString(),  arrayNewStore_Cal_SCBDetails_Eleven_[3].toString(), 
					arrayNewStore_Cal_SCBDetails_Eleven_[4].toString(), arrayNewStoreDetails_Eleven[0], arrayNewVoucher_Without_Code_Eleven_One[7], 
					arrayNewVoucher_With_Code_Eleven_Two[7], arrayNewVoucher_Without_Code_Eleven_Three[7], arrayNewVoucher_With_Code_Eleven_Four[7], arrayNewVoucher_Without_Code_Eleven_Five[7], 
					arrayNewVoucher_With_Code_Eleven_Six[7], arrayNewVoucher_Without_Code_Eleven_Seven[6], arrayNewStoreDetails_Eleven[7], arrayNewStoreDetails_Eleven[10], 
					arrayNewStore_Cal_PCBDetails_Eleven[12].toString(), arrayNewStoreDetails_Eleven[14], arrayNewStoreDetails_Eleven[15], arrayNewVoucher_Without_Code_Eleven_One[13], arrayNewVoucher_With_Code_Eleven_Two[14], 
					arrayNewVoucher_Without_Code_Eleven_Three[8], arrayNewVoucher_With_Code_Eleven_Four[9], arrayNewVoucher_Without_Code_Eleven_Five[8], arrayNewVoucher_With_Code_Eleven_Six[9],
					arrayNewVoucher_Without_Code_Eleven_Seven[13],
					arrayNewVoucher_Without_Code_Eleven_One[14], arrayNewVoucher_With_Code_Eleven_Two[15], arrayNewVoucher_Without_Code_Eleven_Three[9], arrayNewVoucher_With_Code_Eleven_Four[10], 
					arrayNewVoucher_Without_Code_Eleven_Five[9], arrayNewVoucher_With_Code_Eleven_Six[10], arrayNewVoucher_Without_Code_Eleven_Seven[14], arrayNewStore_Cal_PCBDetails_Eleven[11].toString(), arrayNewStore_Cal_PCBDetails_Eleven[12].toString(), strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Eleven("CB", array_New_CashBack_Store_Eleven_Details,"CB_Store_Eleven");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Eleven");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store twelve - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Twelve_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/
			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Twelve[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "Desktop", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Twelve[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Twelve[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Twelve[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Twelve[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_Twelve[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Twelve[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "Desktop", 0);

			objAddStore.clickAddAnotherRow(driver);

			Object arrayNewStore_Nor_SCBDetails_Twelve_[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "Desktop", 1);

			Object arrayNewStore_Others_Details_Twelve[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Twelve[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Twelve[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Twelve[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);

			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Twelve[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Twelve, "Increased Rate", "Desktop", strStoreID);

			String arrayNewVoucher_With_Code_Twelve[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Twelve, "Increased Rate", "COUPON CODE", "Desktop", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Twelve[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Twelve[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Twelve[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);

			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Twelve[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Twelve_Details = new String[] {arrayNewStoreDetails_Twelve[0], arrayNewStoreDetails_Twelve[1], arrayNewStoreDetails_Twelve[2], arrayNewStoreDetails_Twelve[3], arrayNewStoreDetails_Twelve[4],
					arrayNewStoreDetails_Twelve[5], arrayNewStoreDetails_Twelve[7], arrayNewStoreDetails_Twelve[10], arrayNewStoreDetails_Twelve[11], arrayNewStore_Nor_PCBDetails_Twelve[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Twelve[4].toString(), arrayNewStore_Nor_PCBDetails_Twelve[5].toString(), arrayNewStore_Nor_SCBDetails_Twelve[1].toString(), arrayNewStore_Nor_SCBDetails_Twelve[2].toString(), 
					arrayNewStore_Nor_SCBDetails_Twelve[3].toString(), arrayNewVoucher_Without_Code_Twelve[1], arrayNewVoucher_Without_Code_Twelve[2], arrayNewVoucher_Without_Code_Twelve[5], arrayNewVoucher_Without_Code_Twelve[6], 
					arrayNewVoucher_Without_Code_Twelve[7], arrayNewVoucher_With_Code_Twelve[1], arrayNewVoucher_With_Code_Twelve[2], arrayNewVoucher_With_Code_Twelve[5], arrayNewVoucher_With_Code_Twelve[6], 
					arrayNewVoucher_With_Code_Twelve[7], arrayNewVoucher_With_Code_Twelve[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Twelve[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Twelve[7], arrayNewVoucher_With_Code_Twelve[9], arrayNewVoucher_Without_Code_Twelve[8], arrayNewVoucher_With_Code_Twelve[10], arrayNewVoucher_Without_Code_Twelve[9], 
					arrayNewVoucher_Without_Code_Twelve[10], arrayNewVoucher_With_Code_Twelve[11], arrayNewVoucher_With_Code_Twelve[12], arrayNewVoucher_With_Code_Twelve[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Twelve[0]).toString(), arrayNewVoucher_With_Code_Twelve[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Twelve[3], 
					arrayNewVoucher_Without_Code_Twelve[11], arrayNewVoucher_Without_Code_Twelve[12], arrayNewVoucher_With_Code_Twelve[12], arrayNewVoucher_With_Code_Twelve[13], arrayNewStoreDetails_Twelve[13],
					arrayNewStoreDetails_Twelve[14], arrayNewStoreDetails_Twelve[15], (arrayNewStore_Others_Details_Twelve[1]).toString(), arrayNewVoucher_Without_Code_Twelve[13], arrayNewVoucher_With_Code_Twelve[14], 
					arrayNewStore_Nor_SCBDetails_Twelve_[1].toString(), arrayNewStore_Nor_SCBDetails_Twelve_[2].toString(), arrayNewStore_Nor_SCBDetails_Twelve_[3].toString() , arrayNewStore_Nor_PCBDetails_Twelve[6].toString(), arrayNewStore_Nor_PCBDetails_Twelve[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Twelve("CB", array_New_CashBack_Store_Twelve_Details,"CB_Store_Twelve");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Twelve");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store thirteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Thirteen_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Thirteen[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "Mobile", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Thirteen[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Thirteen[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Thirteen[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Thirteen[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_Thirteen[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Thirteen[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "Mobile", 0);

			Object arrayNewStore_Others_Details_Thirteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Thirteen[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Thirteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Thirteen[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);

			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Thirteen[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Thirteen, "Increased Rate", "Mobile", strStoreID);

			String arrayNewVoucher_With_Code_Thirteen[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Thirteen, "Increased Rate", "COUPON CODE", "Mobile", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Thirteen[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Thirteen[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Thirteen[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);

			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Thirteen[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Thirteen_Details = new String[] {arrayNewStoreDetails_Thirteen[0], arrayNewStoreDetails_Thirteen[1], arrayNewStoreDetails_Thirteen[2], arrayNewStoreDetails_Thirteen[3], arrayNewStoreDetails_Thirteen[4],
					arrayNewStoreDetails_Thirteen[5], arrayNewStoreDetails_Thirteen[7], arrayNewStoreDetails_Thirteen[10], arrayNewStoreDetails_Thirteen[11], arrayNewStore_Nor_PCBDetails_Thirteen[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Thirteen[4].toString(), arrayNewStore_Nor_PCBDetails_Thirteen[5].toString(), arrayNewStore_Nor_SCBDetails_Thirteen[1].toString(), arrayNewStore_Nor_SCBDetails_Thirteen[2].toString(), 
					arrayNewStore_Nor_SCBDetails_Thirteen[3].toString(), arrayNewVoucher_Without_Code_Thirteen[1], arrayNewVoucher_Without_Code_Thirteen[2], arrayNewVoucher_Without_Code_Thirteen[5], arrayNewVoucher_Without_Code_Thirteen[6], 
					arrayNewVoucher_Without_Code_Thirteen[7], arrayNewVoucher_With_Code_Thirteen[1], arrayNewVoucher_With_Code_Thirteen[2], arrayNewVoucher_With_Code_Thirteen[5], arrayNewVoucher_With_Code_Thirteen[6], 
					arrayNewVoucher_With_Code_Thirteen[7], arrayNewVoucher_With_Code_Thirteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Thirteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Thirteen[7], arrayNewVoucher_With_Code_Thirteen[9], arrayNewVoucher_Without_Code_Thirteen[8], arrayNewVoucher_With_Code_Thirteen[10], arrayNewVoucher_Without_Code_Thirteen[9], 
					arrayNewVoucher_Without_Code_Thirteen[10], arrayNewVoucher_With_Code_Thirteen[11], arrayNewVoucher_With_Code_Thirteen[12], arrayNewVoucher_With_Code_Thirteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Thirteen[0]).toString(), arrayNewVoucher_With_Code_Thirteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Thirteen[3], 
					arrayNewVoucher_Without_Code_Thirteen[11], arrayNewVoucher_Without_Code_Thirteen[12], arrayNewVoucher_With_Code_Thirteen[12], arrayNewVoucher_With_Code_Thirteen[13], arrayNewStoreDetails_Thirteen[13],
					arrayNewStoreDetails_Thirteen[14], arrayNewStoreDetails_Thirteen[15], (arrayNewStore_Others_Details_Thirteen[1]).toString(), arrayNewVoucher_Without_Code_Thirteen[13], arrayNewVoucher_With_Code_Thirteen[14], arrayNewStore_Nor_PCBDetails_Thirteen[6].toString(), arrayNewStore_Nor_PCBDetails_Thirteen[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Thirteen("CB", array_New_CashBack_Store_Thirteen_Details,"CB_Store_Thirteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Thirteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store fourteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Fourteen_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Fourteen[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "Tablet", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Fourteen[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Fourteen[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Fourteen[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Fourteen[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_Fourteen[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Fourteen[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "Tablet", 0);

			Object arrayNewStore_Others_Details_Fourteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Fourteen[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Fourteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Fourteen[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);

			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Fourteen[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Fourteen, "Increased Rate", "Tablet", strStoreID);

			String arrayNewVoucher_With_Code_Fourteen[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Fourteen, "Increased Rate", "COUPON CODE", "Tablet", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Fourteen[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Fourteen[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Fourteen[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			reportStep(logger, "Navigating to Settings -> -> Affiliate network click and navigation verification..", "INFO");
			objDashboard.clickMainMenuSettings(driver);
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			reportStep(logger,  "About edit icon for the respective affilliate network..", "INFO");
			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Fourteen[3].trim());

			reportStep(logger,  "About to retrieve affiliate network id..", "INFO");
			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Fourteen_Details = new String[] {arrayNewStoreDetails_Fourteen[0], arrayNewStoreDetails_Fourteen[1], arrayNewStoreDetails_Fourteen[2], arrayNewStoreDetails_Fourteen[3], arrayNewStoreDetails_Fourteen[4],
					arrayNewStoreDetails_Fourteen[5], arrayNewStoreDetails_Fourteen[7], arrayNewStoreDetails_Fourteen[10], arrayNewStoreDetails_Fourteen[11], arrayNewStore_Nor_PCBDetails_Fourteen[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Fourteen[4].toString(), arrayNewStore_Nor_PCBDetails_Fourteen[5].toString(), arrayNewStore_Nor_SCBDetails_Fourteen[1].toString(), arrayNewStore_Nor_SCBDetails_Fourteen[2].toString(), 
					arrayNewStore_Nor_SCBDetails_Fourteen[3].toString(), arrayNewVoucher_Without_Code_Fourteen[1], arrayNewVoucher_Without_Code_Fourteen[2], arrayNewVoucher_Without_Code_Fourteen[5], arrayNewVoucher_Without_Code_Fourteen[6], 
					arrayNewVoucher_Without_Code_Fourteen[7], arrayNewVoucher_With_Code_Fourteen[1], arrayNewVoucher_With_Code_Fourteen[2], arrayNewVoucher_With_Code_Fourteen[5], arrayNewVoucher_With_Code_Fourteen[6], 
					arrayNewVoucher_With_Code_Fourteen[7], arrayNewVoucher_With_Code_Fourteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Fourteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Fourteen[7], arrayNewVoucher_With_Code_Fourteen[9], arrayNewVoucher_Without_Code_Fourteen[8], arrayNewVoucher_With_Code_Fourteen[10], arrayNewVoucher_Without_Code_Fourteen[9], 
					arrayNewVoucher_Without_Code_Fourteen[10], arrayNewVoucher_With_Code_Fourteen[11], arrayNewVoucher_With_Code_Fourteen[12], arrayNewVoucher_With_Code_Fourteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Fourteen[0]).toString(), arrayNewVoucher_With_Code_Fourteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Fourteen[3], 
					arrayNewVoucher_Without_Code_Fourteen[11], arrayNewVoucher_Without_Code_Fourteen[12], arrayNewVoucher_With_Code_Fourteen[12], arrayNewVoucher_With_Code_Fourteen[13], arrayNewStoreDetails_Fourteen[13],
					arrayNewStoreDetails_Fourteen[14], arrayNewStoreDetails_Fourteen[15], (arrayNewStore_Others_Details_Fourteen[1]).toString(), arrayNewVoucher_Without_Code_Fourteen[13], 
					arrayNewVoucher_With_Code_Fourteen[14], arrayNewStore_Nor_PCBDetails_Fourteen[6].toString(), arrayNewStore_Nor_PCBDetails_Fourteen[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Fourteen("CB", array_New_CashBack_Store_Fourteen_Details,"CB_Store_Fourteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Fourteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store fourteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_Fifteen_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objAffillateNetwork = new AffillateNetwork(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Fifteen[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "App", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Fifteen[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Fifteen[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Fifteen[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Fifteen[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_Fifteen[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Fifteen[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "App", 0);

			objAddStore.clickAddAnotherRow(driver);

			Object arrayNewStore_Nor_SCBDetails_Fifteen_[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "App", 1);

			Object arrayNewStore_Others_Details_Fifteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Fifteen[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Fifteen[0]);

			objAddStore.clickSearch(driver);

			reportStep(logger,  "About to retrieve the store id..", "INFO");
			String strStoreID = objAddStore.getStoreID(driver);

			reportStep(logger,  "About to retrieve the store type..", "INFO");
			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Fifteen[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);

			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Fifteen[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Fifteen, "Increased Rate", "App", strStoreID);

			String arrayNewVoucher_With_Code_Fifteen[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Fifteen, "Increased Rate", "COUPON CODE", "App", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Fifteen[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Fifteen[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Fifteen[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);

			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Fifteen[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Fifteen_Details = new String[] {arrayNewStoreDetails_Fifteen[0], arrayNewStoreDetails_Fifteen[1], arrayNewStoreDetails_Fifteen[2], arrayNewStoreDetails_Fifteen[3], arrayNewStoreDetails_Fifteen[4],
					arrayNewStoreDetails_Fifteen[5], arrayNewStoreDetails_Fifteen[7], arrayNewStoreDetails_Fifteen[10], arrayNewStoreDetails_Fifteen[11], arrayNewStore_Nor_PCBDetails_Fifteen[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Fifteen[4].toString(), arrayNewStore_Nor_PCBDetails_Fifteen[5].toString(), arrayNewStore_Nor_SCBDetails_Fifteen[1].toString(), arrayNewStore_Nor_SCBDetails_Fifteen[2].toString(), 
					arrayNewStore_Nor_SCBDetails_Fifteen[3].toString(), arrayNewVoucher_Without_Code_Fifteen[1], arrayNewVoucher_Without_Code_Fifteen[2], arrayNewVoucher_Without_Code_Fifteen[5], arrayNewVoucher_Without_Code_Fifteen[6], 
					arrayNewVoucher_Without_Code_Fifteen[7], arrayNewVoucher_With_Code_Fifteen[1], arrayNewVoucher_With_Code_Fifteen[2], arrayNewVoucher_With_Code_Fifteen[5], arrayNewVoucher_With_Code_Fifteen[6], 
					arrayNewVoucher_With_Code_Fifteen[7], arrayNewVoucher_With_Code_Fifteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Fifteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Fifteen[7], arrayNewVoucher_With_Code_Fifteen[9], arrayNewVoucher_Without_Code_Fifteen[8], arrayNewVoucher_With_Code_Fifteen[10], arrayNewVoucher_Without_Code_Fifteen[9], 
					arrayNewVoucher_Without_Code_Fifteen[10], arrayNewVoucher_With_Code_Fifteen[11], arrayNewVoucher_With_Code_Fifteen[12], arrayNewVoucher_With_Code_Fifteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Fifteen[0]).toString(), arrayNewVoucher_With_Code_Fifteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Fifteen[3], 
					arrayNewVoucher_Without_Code_Fifteen[11], arrayNewVoucher_Without_Code_Fifteen[12], arrayNewVoucher_With_Code_Fifteen[12], arrayNewVoucher_With_Code_Fifteen[13], arrayNewStoreDetails_Fifteen[13],
					arrayNewStoreDetails_Fifteen[14], arrayNewStoreDetails_Fifteen[15], (arrayNewStore_Others_Details_Fifteen[1]).toString(), arrayNewVoucher_Without_Code_Fifteen[13], arrayNewVoucher_With_Code_Fifteen[14],
					arrayNewStore_Nor_SCBDetails_Fifteen_[1].toString(), arrayNewStore_Nor_SCBDetails_Fifteen_[2].toString(), arrayNewStore_Nor_SCBDetails_Fifteen_[3].toString(), 
					arrayNewStore_Nor_PCBDetails_Fifteen[6].toString(), arrayNewStore_Nor_PCBDetails_Fifteen[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Fifteen("CB", array_New_CashBack_Store_Fifteen_Details,"CB_Store_Fifteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_Fifteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Mob Cash back Store four - Creation and Loading the Corresponding Dynamic Values into Json File					   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void mob_Cashback_Store_Four_Creation(Method method) throws InterruptedException, AWTException{

		try {

			/**************************************************************** STORE CREATION STARTED ***************************************************************************/
			/******************************************************************** OBJECT CREATION ******************************************************************************/

			objAdminCoreFunction = new AdminCoreFunction(driver, logger);
			objLogin = new Login(driver, logger); 
			objDashboard = new Dashboard(driver, logger);
			objAddStore = new Stores(driver, logger);
			objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);
			objVouchers = new Vouchers(driver, logger);
			objStoreCCL = new StoresCCL(driver, logger);

			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuStores(driver);

			objAddStore.clickSubMenuStores(driver);

			objAddStore.clickAddNewStore(driver);

			objAddStore.clickStoresTab(driver);

			String arrayNewStoreDetails_Four[] = objAddStore.enterCashbackStoreDetails(driver, "In-Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			objAddStore.enterNormalShortDescription(driver);

			objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Four[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_CashBack_Store_Four_Details = new String[] {arrayNewStoreDetails_Four[0], strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Four("MOB_CB", array_New_CashBack_Store_Four_Details,"MOB_CB_Store_Four");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("MOB_CB", "MOB_CB_Store_Four");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 																	 Solar Refresh																				   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test (priority = 1) 
	public void store_Solr_Refresh(Method method) throws InterruptedException, AWTException{


		/****************************************************************** SOLR REFRESH STARTED ***************************************************************************/
		/******************************************************************** OBJECT CREATION ******************************************************************************/

		 
		objLogin = new Login(driver, logger); 
		objDashboard = new Dashboard(driver, logger);
		objProductBrowserEditMode = new ProductBrowserEditMode(driver, logger);


		/*********************************************************************** LOGIN PAGE*********************************************************************************/
		
		objLogin.navigateAdminLoginPage(driver);
		
		objLogin.enterAdminLoginCredentials(driver);

		/*********************************************************************** LOGIN PAGE*********************************************************************************/
		objDashboard.clickMainMenuProductFeeds(driver);
		
		objProductBrowserEditMode.clickSubMenuProductBrowserEditMode(driver);

		objProductBrowserEditMode.clickPrimaryCashbackSolrRefresh(driver);
		
		objProductBrowserEditMode.clickSecondaryCashbackSolrRefresh(driver);
		
		objProductBrowserEditMode.clickVoucherSolrRefresh(driver);
		
		/**************************************************************** SOLR REFRESH COMPLETED ***************************************************************************/


	}

}