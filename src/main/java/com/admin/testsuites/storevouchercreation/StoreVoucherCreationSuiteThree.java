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


public class StoreVoucherCreationSuiteThree extends WrapperMethods {

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store one - Creation and Loading the Corresponding Dynamic Values into Json File							   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_One_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_One[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "GRAB DEAL", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription = objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription = objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_One[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_One[0]+" social message");

			Object arrayNewStore_Others_Details_One[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_One[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_One[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_One[0].trim());

			objAddStore.clickEdit(driver);

			//objAddStore.clickSecondaryCashbackTab(driver);

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

			String[] array_New_Network18_Store_One_Details = new String[] {arrayNewStoreDetails_One[0], arrayNewStoreDetails_One[1], arrayNewStoreDetails_One[2], arrayNewStoreDetails_One[3], arrayNewStoreDetails_One[4],
					arrayNewStoreDetails_One[5], arrayNewStoreDetails_One[7], arrayNewStoreDetails_One[10], arrayNewStoreDetails_One[11], "Currency", "", "", "Currency", "", 
					"", arrayNewVoucher_Without_Code_One[1], arrayNewVoucher_Without_Code_One[2], arrayNewVoucher_Without_Code_One[5], arrayNewVoucher_Without_Code_One[6], 
					arrayNewVoucher_Without_Code_One[7], arrayNewVoucher_With_Code_One[1], arrayNewVoucher_With_Code_One[2], arrayNewVoucher_With_Code_One[5], arrayNewVoucher_With_Code_One[6], 
					arrayNewVoucher_With_Code_One[7], arrayNewVoucher_With_Code_One[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_One[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_One[7], arrayNewVoucher_With_Code_One[9], arrayNewVoucher_Without_Code_One[8], arrayNewVoucher_With_Code_One[10], arrayNewVoucher_Without_Code_One[9], 
					arrayNewVoucher_Without_Code_One[10], arrayNewVoucher_With_Code_One[11], arrayNewVoucher_With_Code_One[12], arrayNewVoucher_With_Code_One[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_One[0]).toString(), arrayNewVoucher_With_Code_One[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_One[3], 
					arrayNewVoucher_Without_Code_One[11], arrayNewVoucher_Without_Code_One[12], arrayNewVoucher_With_Code_One[12], arrayNewVoucher_With_Code_One[13], arrayNewStoreDetails_One[13],
					arrayNewStoreDetails_One[14], arrayNewStoreDetails_One[15], (arrayNewStore_Others_Details_One[1]).toString(), arrayNewVoucher_Without_Code_One[13], arrayNewVoucher_With_Code_One[14],
					arrayNewStoreDetails_One[16], arrayNewStoreDetails_One[17], arrayNewStoreDetails_One[18], arrayNewStoreDetails_One[19], arrayNewStoreDetails_One[20], arrayNewStoreDetails_One[21], arrayNewStoreDetails_One[22],
					arrayNewStoreDetails_One[23], arrayNewStoreDetails_One[24], normalShortDescription, normalAppShortDescription, strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_One("N18", array_New_Network18_Store_One_Details,"N18_Store_One");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_One");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store two - Creation and Loading the Corresponding Dynamic Values into Json File							   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Two_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Two[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "GRAB DEAL", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription = objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription = objAddStore.enterNormalAppShortDescription(driver);

			Object arrayNewStore_Others_Details_Two[] = objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Two[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_With_Code_Two[] = objVouchers.enterVoucherWithCodeDetails(driver, arrayNewStoreDetails_Two, "Increased Rate", "COUPON CODE", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_Network18_Store_Two_Details = new String[] {arrayNewStoreDetails_Two[0], arrayNewStoreDetails_Two[1], arrayNewStoreDetails_Two[2], arrayNewStoreDetails_Two[3], arrayNewStoreDetails_Two[4],
					arrayNewStoreDetails_Two[5], arrayNewStoreDetails_Two[7], arrayNewStoreDetails_Two[10], arrayNewStoreDetails_Two[11], "Currency", "", "", "Currency", "", 
					"", "", "", "", "", 
					"", arrayNewVoucher_With_Code_Two[1], arrayNewVoucher_With_Code_Two[2], arrayNewVoucher_With_Code_Two[5], arrayNewVoucher_With_Code_Two[6], 
					arrayNewVoucher_With_Code_Two[7], arrayNewVoucher_With_Code_Two[8], strStoreID, "", "", "", arrayNewStoreDetails_Two[12], "", 
					"", arrayNewVoucher_With_Code_Two[9], "", arrayNewVoucher_With_Code_Two[10], "", 
					"", arrayNewVoucher_With_Code_Two[11], arrayNewVoucher_With_Code_Two[12], arrayNewVoucher_With_Code_Two[11], "", "", 
					"", "", "", "", "", "", 
					"", (arrayNewStore_Others_Details_Two[0]).toString(), arrayNewVoucher_With_Code_Two[3], "", arrayNewVoucher_With_Code_Two[3], 
					"", "", arrayNewVoucher_With_Code_Two[12], arrayNewVoucher_With_Code_Two[13], arrayNewStoreDetails_Two[13],
					arrayNewStoreDetails_Two[14], arrayNewStoreDetails_Two[15], (arrayNewStore_Others_Details_Two[1]).toString(), "", arrayNewVoucher_With_Code_Two[14], normalShortDescription, normalAppShortDescription,
					arrayNewStoreDetails_Two[16], arrayNewStoreDetails_Two[17], arrayNewStoreDetails_Two[18], arrayNewStoreDetails_Two[19], arrayNewStoreDetails_Two[20], arrayNewStoreDetails_Two[21], arrayNewStoreDetails_Two[22],
					arrayNewStoreDetails_Two[23], arrayNewStoreDetails_Two[24], strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Two("N18", array_New_Network18_Store_Two_Details,"N18_Store_Two");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Two");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store three - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Three_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Three[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "GRAB DEAL", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			objAddStore.enterNormalShortDescription(driver);

			objAddStore.enterNormalAppShortDescription(driver);

			Object arrayNewStore_Others_Details_Three[] = objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Three[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Three[] = objVouchers.enterVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Three, "Increased Rate", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";


			String[] array_New_Network18_Store_Three_Details = new String[] {arrayNewStoreDetails_Three[0], arrayNewVoucher_Without_Code_Three[1], arrayNewStore_Others_Details_Three[0].toString(), 
					arrayNewStoreDetails_Three[7], "1", "1", "1", "1", "1", "1", "1", "1", "1".toString(),
					arrayNewStoreDetails_Three[16], arrayNewStoreDetails_Three[17], arrayNewStoreDetails_Three[18], arrayNewStoreDetails_Three[19], arrayNewStoreDetails_Three[20], arrayNewStoreDetails_Three[21], arrayNewStoreDetails_Three[22],
					arrayNewStoreDetails_Three[23], arrayNewStoreDetails_Three[24], strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Three("N18", array_New_Network18_Store_Three_Details,"N18_Store_Three");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Three");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store four - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Four_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Four[] = objAddStore.enterNetwork18StoreDetails(driver, "In-Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

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

			String[] array_New_Network18_Store_Four_Details = new String[] {arrayNewStoreDetails_Four[0], strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Four("N18", array_New_Network18_Store_Four_Details,"N18_Store_Four");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Four");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store five - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Five_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Five[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			objAddStore.enterNormalShortDescription(driver);

			objAddStore.enterNormalAppShortDescription(driver);

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


			String[] array_New_Network18_Store_Five_Details = new String[] {arrayNewStoreDetails_Five[0], "1",  
					"1",  "1",  "1", 
					"1",  "1",  "1",  
					"1", "1",  "1",  
					"1",  "1", strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Five("N18", array_New_Network18_Store_Five_Details,"N18_Store_Five");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Five");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store six - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Six_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Six[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			objAddStore.enterNormalShortDescription(driver);

			objAddStore.enterNormalAppShortDescription(driver);

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

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			String[] array_New_Network18_Store_Six_Details = new String[] {arrayNewStoreDetails_Six[0], "1",  
					"1",  "1",  "1", 
					"1",  "1",  "1",  
					"1", arrayNewStoreDetails_Six[1], strStoreID, strVoucherID_One, strVoucherID_Two, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Six("N18", array_New_Network18_Store_Six_Details,"N18_Store_Six");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Six");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store seven - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Seven_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Seven[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			objAddStore.enterNormalShortDescription(driver);

			objAddStore.enterNormalAppShortDescription(driver);

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

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";


			String[] array_New_Network18_Store_Seven_Details = new String[] {arrayNewStoreDetails_Seven[0], "1",  
					"1",  "1",  "1", 
					"1",  "1", "1",  
					"1", arrayNewStoreDetails_Seven[1], strStoreID, strVoucherID_One, strVoucherID_Two, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Seven("N18", array_New_Network18_Store_Seven_Details,"N18_Store_Seven");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Seven");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store eight - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Eight_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Eight[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "GRAB DEAL", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription = objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription = objAddStore.enterNormalAppShortDescription(driver);

			Object arrayNewStore_Others_Details_Eight[] = objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Eight[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Eight[] = objVouchers.enterVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Eight, "Exclusive Rate", "All", strStoreID);

			String arrayNewVoucher_With_Code_Eight[] = objVouchers.enterVoucherWithCodeDetails(driver, arrayNewStoreDetails_Eight, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";


			String[] array_New_Network18_Store_Eight_Details = new String[] {arrayNewStoreDetails_Eight[0], arrayNewStoreDetails_Eight[1], arrayNewStoreDetails_Eight[2], arrayNewStoreDetails_Eight[3], arrayNewStoreDetails_Eight[4],
					arrayNewStoreDetails_Eight[5], arrayNewStoreDetails_Eight[7], arrayNewStoreDetails_Eight[10], arrayNewStoreDetails_Eight[11], "Currency", "", "", "Currency", "", 
					"", arrayNewVoucher_Without_Code_Eight[1], arrayNewVoucher_Without_Code_Eight[2], arrayNewVoucher_Without_Code_Eight[5], arrayNewVoucher_Without_Code_Eight[6], 
					arrayNewVoucher_Without_Code_Eight[7], arrayNewVoucher_With_Code_Eight[1], arrayNewVoucher_With_Code_Eight[2], arrayNewVoucher_With_Code_Eight[5], arrayNewVoucher_With_Code_Eight[6], 
					arrayNewVoucher_With_Code_Eight[7], arrayNewVoucher_With_Code_Eight[8], strStoreID, "", "", "", arrayNewStoreDetails_Eight[12], "", 
					arrayNewVoucher_Without_Code_Eight[7], arrayNewVoucher_With_Code_Eight[9], arrayNewVoucher_Without_Code_Eight[8], arrayNewVoucher_With_Code_Eight[10], arrayNewVoucher_Without_Code_Eight[9], 
					arrayNewVoucher_Without_Code_Eight[10], arrayNewVoucher_With_Code_Eight[11], arrayNewVoucher_With_Code_Eight[12], arrayNewVoucher_With_Code_Eight[11], "", "", 
					"", "", "", "", "", "", 
					"", (arrayNewStore_Others_Details_Eight[0]).toString(), arrayNewVoucher_With_Code_Eight[3], "", arrayNewVoucher_With_Code_Eight[3], 
					arrayNewVoucher_Without_Code_Eight[11], arrayNewVoucher_Without_Code_Eight[12], arrayNewVoucher_With_Code_Eight[12], arrayNewVoucher_With_Code_Eight[13], arrayNewStoreDetails_Eight[13],
					arrayNewStoreDetails_Eight[14], arrayNewStoreDetails_Eight[15], (arrayNewStore_Others_Details_Eight[1]).toString(), arrayNewVoucher_Without_Code_Eight[13], arrayNewVoucher_With_Code_Eight[14],
					arrayNewStoreDetails_Eight[16], arrayNewStoreDetails_Eight[17], arrayNewStoreDetails_Eight[18], arrayNewStoreDetails_Eight[19], arrayNewStoreDetails_Eight[20], arrayNewStoreDetails_Eight[21], arrayNewStoreDetails_Eight[22],
					arrayNewStoreDetails_Eight[23], arrayNewStoreDetails_Eight[24], normalShortDescription, normalAppShortDescription, strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Eight("N18", array_New_Network18_Store_Eight_Details,"N18_Store_Eight");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Eight");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store nine - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test
	public void network18_Store_Nine_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Nine[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "GRAB DEAL", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription= objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription = objAddStore.enterNormalAppShortDescription(driver);

			Object arrayNewStore_Others_Details_Nine[] = objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Nine[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_With_Code_Nine[] = objVouchers.enterVoucherWithCodeDetails(driver, arrayNewStoreDetails_Nine, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";


			String[] array_New_Network18_Store_Nine_Details = new String[] {arrayNewStoreDetails_Nine[0], arrayNewStoreDetails_Nine[1], arrayNewStoreDetails_Nine[2], arrayNewStoreDetails_Nine[3], arrayNewStoreDetails_Nine[4],
					arrayNewStoreDetails_Nine[5], arrayNewStoreDetails_Nine[7], arrayNewStoreDetails_Nine[10], arrayNewStoreDetails_Nine[11], "Currency", "", "", "Currency", "", 
					"".toString(), "", "", "", "", 
					"", arrayNewVoucher_With_Code_Nine[1], arrayNewVoucher_With_Code_Nine[2], arrayNewVoucher_With_Code_Nine[5], arrayNewVoucher_With_Code_Nine[6], 
					arrayNewVoucher_With_Code_Nine[7], arrayNewVoucher_With_Code_Nine[8], strStoreID, "", "", "", arrayNewStoreDetails_Nine[12], "", 
					"", arrayNewVoucher_With_Code_Nine[9], "", arrayNewVoucher_With_Code_Nine[10], "", 
					"", arrayNewVoucher_With_Code_Nine[11], arrayNewVoucher_With_Code_Nine[12], arrayNewVoucher_With_Code_Nine[11], "", "", 
					"", "", "", "", "", "", 
					"", (arrayNewStore_Others_Details_Nine[0]).toString(), arrayNewVoucher_With_Code_Nine[3], "", arrayNewVoucher_With_Code_Nine[3], 
					"", "", arrayNewVoucher_With_Code_Nine[12], arrayNewVoucher_With_Code_Nine[13], arrayNewStoreDetails_Nine[13],
					arrayNewStoreDetails_Nine[14], arrayNewStoreDetails_Nine[15], (arrayNewStore_Others_Details_Nine[1]).toString(), "", arrayNewVoucher_With_Code_Nine[14],
					"","","percentage","","","",
					arrayNewStoreDetails_Nine[16], arrayNewStoreDetails_Nine[17], arrayNewStoreDetails_Nine[18], arrayNewStoreDetails_Nine[19], arrayNewStoreDetails_Nine[20], arrayNewStoreDetails_Nine[21], arrayNewStoreDetails_Nine[22],
					arrayNewStoreDetails_Nine[23], arrayNewStoreDetails_Nine[24], normalShortDescription, normalAppShortDescription, strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Nine("N18", array_New_Network18_Store_Nine_Details,"N18_Store_Nine");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Nine");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store ten - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Ten_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Ten[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041", "72", "GRAB DEAL", "90", "orderID", "Within 4 Days of Shipment", "check", "check", "check", "check");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			objAddStore.enterNormalShortDescription(driver);

			objAddStore.enterNormalAppShortDescription(driver);

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

			String[] array_New_Network18_Store_Ten_Details = new String[] {arrayNewStoreDetails_Ten[0], arrayNewVoucher_Without_Code_Ten[1], arrayNewStore_Others_Details_Ten[0].toString(), 
					arrayNewStoreDetails_Ten[7], arrayNewStoreDetails_Ten[16], arrayNewStoreDetails_Ten[17], arrayNewStoreDetails_Ten[18], arrayNewStoreDetails_Ten[19], arrayNewStoreDetails_Ten[20], arrayNewStoreDetails_Ten[21], arrayNewStoreDetails_Ten[22],
					arrayNewStoreDetails_Ten[23], arrayNewStoreDetails_Ten[24], arrayNewVoucher_With_Code_Ten[1], arrayNewVoucher_Without_Code_Ten_One[1], strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Ten("N18", array_New_Network18_Store_Ten_Details,"N18_Store_Ten");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Ten");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store eleven - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Eleven_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Eleven[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription = objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription = objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.clickSEOTab(driver);

			objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Eleven[0]);

			objAddStore.enterMetaTags(driver, "This Is Test automation meta tag");

			objAddStore.enterProductMetaTags(driver, "This Is Test automation product meta tag");

			objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Eleven[0]+" social message");

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

			String[] array_New_Network18_Store_Eleven_Details = new String[] {arrayNewStoreDetails_Eleven[0], arrayNewStoreDetails_Eleven[1], arrayNewStoreDetails_Eleven[4], 
					arrayNewStoreDetails_Eleven[5], arrayNewVoucher_Without_Code_Eleven_One[1], arrayNewVoucher_Without_Code_Eleven_One[2], arrayNewVoucher_With_Code_Eleven_Two[0], 
					arrayNewVoucher_With_Code_Eleven_Two[1], arrayNewVoucher_With_Code_Eleven_Two[2], arrayNewVoucher_With_Code_Eleven_Two[8], arrayNewVoucher_Without_Code_Eleven_Three[0], 
					arrayNewVoucher_Without_Code_Eleven_Three[1], arrayNewVoucher_Without_Code_Eleven_Three[2], arrayNewVoucher_With_Code_Eleven_Four[0], 
					arrayNewVoucher_With_Code_Eleven_Four[1], arrayNewVoucher_With_Code_Eleven_Four[2], arrayNewVoucher_With_Code_Eleven_Four[8], 
					arrayNewVoucher_Without_Code_Eleven_Five[0], arrayNewVoucher_Without_Code_Eleven_Five[1], arrayNewVoucher_Without_Code_Eleven_Five[2], 
					arrayNewVoucher_With_Code_Eleven_Six[0], arrayNewVoucher_With_Code_Eleven_Six[1], arrayNewVoucher_With_Code_Eleven_Six[2], 
					arrayNewVoucher_With_Code_Eleven_Six[8], arrayNewVoucher_Without_Code_Eleven_Seven[0], arrayNewVoucher_Without_Code_Eleven_Seven[1], 
					arrayNewVoucher_Without_Code_Eleven_Seven[2], "1",  "1", "1",  "1", "1", "1",  "1",  "1", "1",  "1",  "1", "1", arrayNewStoreDetails_Eleven[0], 
					arrayNewVoucher_Without_Code_Eleven_One[7], arrayNewVoucher_With_Code_Eleven_Two[7], arrayNewVoucher_Without_Code_Eleven_Three[7], arrayNewVoucher_With_Code_Eleven_Four[7], 
					arrayNewVoucher_Without_Code_Eleven_Five[7], arrayNewVoucher_With_Code_Eleven_Six[7], arrayNewVoucher_Without_Code_Eleven_Seven[6], arrayNewStoreDetails_Eleven[7], 
					arrayNewStoreDetails_Eleven[10], 
					arrayNewStoreDetails_Eleven[13], arrayNewStoreDetails_Eleven[14], arrayNewStoreDetails_Eleven[15], arrayNewVoucher_Without_Code_Eleven_One[13], arrayNewVoucher_With_Code_Eleven_Two[14], 
					arrayNewVoucher_Without_Code_Eleven_Three[8], arrayNewVoucher_With_Code_Eleven_Four[9], arrayNewVoucher_Without_Code_Eleven_Five[8], arrayNewVoucher_With_Code_Eleven_Six[9],
					arrayNewVoucher_Without_Code_Eleven_Seven[13],arrayNewVoucher_Without_Code_Eleven_One[14], arrayNewVoucher_With_Code_Eleven_Two[15], arrayNewVoucher_Without_Code_Eleven_Three[9], arrayNewVoucher_With_Code_Eleven_Four[10], 
					arrayNewVoucher_Without_Code_Eleven_Five[9], arrayNewVoucher_With_Code_Eleven_Six[10], arrayNewVoucher_Without_Code_Eleven_Seven[14], normalShortDescription, normalAppShortDescription, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Eleven("N18", array_New_Network18_Store_Eleven_Details,"N18_Store_Eleven");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Eleven");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store twelve - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Twelve_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Twelve[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "Desktop", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription= objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription= objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Twelve[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Twelve[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Twelve[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Twelve[0]+" social message");

			Object arrayNewStore_Others_Details_Twelve[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Twelve[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Twelve[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Twelve[0].trim());

			objAddStore.clickEdit(driver);

			//objAddStore.clickSecondaryCashbackTab(driver);

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

			String[] array_New_Network18_Store_Twelve_Details = new String[] {arrayNewStoreDetails_Twelve[0], arrayNewStoreDetails_Twelve[1], arrayNewStoreDetails_Twelve[2], arrayNewStoreDetails_Twelve[3], arrayNewStoreDetails_Twelve[4],
					arrayNewStoreDetails_Twelve[5], arrayNewStoreDetails_Twelve[7], arrayNewStoreDetails_Twelve[10], arrayNewStoreDetails_Twelve[11], "Currency", "", "", "Currency", "", 
					"", arrayNewVoucher_Without_Code_Twelve[1], arrayNewVoucher_Without_Code_Twelve[2], arrayNewVoucher_Without_Code_Twelve[5], arrayNewVoucher_Without_Code_Twelve[6], 
					arrayNewVoucher_Without_Code_Twelve[7], arrayNewVoucher_With_Code_Twelve[1], arrayNewVoucher_With_Code_Twelve[2], arrayNewVoucher_With_Code_Twelve[5], arrayNewVoucher_With_Code_Twelve[6], 
					arrayNewVoucher_With_Code_Twelve[7], arrayNewVoucher_With_Code_Twelve[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Twelve[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Twelve[7], arrayNewVoucher_With_Code_Twelve[9], arrayNewVoucher_Without_Code_Twelve[8], arrayNewVoucher_With_Code_Twelve[10], arrayNewVoucher_Without_Code_Twelve[9], 
					arrayNewVoucher_Without_Code_Twelve[10], arrayNewVoucher_With_Code_Twelve[11], arrayNewVoucher_With_Code_Twelve[12], arrayNewVoucher_With_Code_Twelve[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Twelve[0]).toString(), arrayNewVoucher_With_Code_Twelve[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Twelve[3], 
					arrayNewVoucher_Without_Code_Twelve[11], arrayNewVoucher_Without_Code_Twelve[12], arrayNewVoucher_With_Code_Twelve[12], arrayNewVoucher_With_Code_Twelve[13], arrayNewStoreDetails_Twelve[13],
					arrayNewStoreDetails_Twelve[14], arrayNewStoreDetails_Twelve[15], (arrayNewStore_Others_Details_Twelve[1]).toString(), arrayNewVoucher_Without_Code_Twelve[13], arrayNewVoucher_With_Code_Twelve[14], 
					"","","",normalShortDescription, normalAppShortDescription, strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Twelve("N18", array_New_Network18_Store_Twelve_Details,"N18_Store_Twelve");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Twelve");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store thirteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Thirteen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Thirteen[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "Mobile", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription= objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription= objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Thirteen[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Thirteen[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Thirteen[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Thirteen[0]+" social message");

			Object arrayNewStore_Others_Details_Thirteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Thirteen[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Thirteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Thirteen[0].trim());

			objAddStore.clickEdit(driver);

			//objAddStore.clickSecondaryCashbackTab(driver);

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

			String[] array_New_Network18_Store_Thirteen_Details = new String[] {arrayNewStoreDetails_Thirteen[0], arrayNewStoreDetails_Thirteen[1], arrayNewStoreDetails_Thirteen[2], arrayNewStoreDetails_Thirteen[3], arrayNewStoreDetails_Thirteen[4],
					arrayNewStoreDetails_Thirteen[5], arrayNewStoreDetails_Thirteen[7], arrayNewStoreDetails_Thirteen[10], arrayNewStoreDetails_Thirteen[11], "Currency", "", "", "Currency", "", 
					"", arrayNewVoucher_Without_Code_Thirteen[1], arrayNewVoucher_Without_Code_Thirteen[2], arrayNewVoucher_Without_Code_Thirteen[5], arrayNewVoucher_Without_Code_Thirteen[6], 
					arrayNewVoucher_Without_Code_Thirteen[7], arrayNewVoucher_With_Code_Thirteen[1], arrayNewVoucher_With_Code_Thirteen[2], arrayNewVoucher_With_Code_Thirteen[5], arrayNewVoucher_With_Code_Thirteen[6], 
					arrayNewVoucher_With_Code_Thirteen[7], arrayNewVoucher_With_Code_Thirteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Thirteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Thirteen[7], arrayNewVoucher_With_Code_Thirteen[9], arrayNewVoucher_Without_Code_Thirteen[8], arrayNewVoucher_With_Code_Thirteen[10], arrayNewVoucher_Without_Code_Thirteen[9], 
					arrayNewVoucher_Without_Code_Thirteen[10], arrayNewVoucher_With_Code_Thirteen[11], arrayNewVoucher_With_Code_Thirteen[12], arrayNewVoucher_With_Code_Thirteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Thirteen[0]).toString(), arrayNewVoucher_With_Code_Thirteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Thirteen[3], 
					arrayNewVoucher_Without_Code_Thirteen[11], arrayNewVoucher_Without_Code_Thirteen[12], arrayNewVoucher_With_Code_Thirteen[12], arrayNewVoucher_With_Code_Thirteen[13], arrayNewStoreDetails_Thirteen[13],
					arrayNewStoreDetails_Thirteen[14], arrayNewStoreDetails_Thirteen[15], (arrayNewStore_Others_Details_Thirteen[1]).toString(), arrayNewVoucher_Without_Code_Thirteen[13], arrayNewVoucher_With_Code_Thirteen[14], normalShortDescription, normalAppShortDescription, strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Thirteen("N18", array_New_Network18_Store_Thirteen_Details,"N18_Store_Thirteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Thirteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store fourteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Fourteen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Fourteen[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "Tablet", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription= objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription= objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Fourteen[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Fourteen[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Fourteen[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Fourteen[0]+" social message");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Fourteen[0]);

			Object arrayNewStore_Others_Details_Fourteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Fourteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Fourteen[0].trim());

			objAddStore.clickEdit(driver);

			//objAddStore.clickSecondaryCashbackTab(driver);

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

			objDashboard.clickMainMenuSettings(driver);

			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Fourteen[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";


			String[] array_New_Network18_Store_Fourteen_Details = new String[] {arrayNewStoreDetails_Fourteen[0], arrayNewStoreDetails_Fourteen[1], arrayNewStoreDetails_Fourteen[2], arrayNewStoreDetails_Fourteen[3], arrayNewStoreDetails_Fourteen[4],
					arrayNewStoreDetails_Fourteen[5], arrayNewStoreDetails_Fourteen[7], arrayNewStoreDetails_Fourteen[10], arrayNewStoreDetails_Fourteen[11], "Currency", "", "", "Currency", "", 
					"", arrayNewVoucher_Without_Code_Fourteen[1], arrayNewVoucher_Without_Code_Fourteen[2], arrayNewVoucher_Without_Code_Fourteen[5], arrayNewVoucher_Without_Code_Fourteen[6], 
					arrayNewVoucher_Without_Code_Fourteen[7], arrayNewVoucher_With_Code_Fourteen[1], arrayNewVoucher_With_Code_Fourteen[2], arrayNewVoucher_With_Code_Fourteen[5], arrayNewVoucher_With_Code_Fourteen[6], 
					arrayNewVoucher_With_Code_Fourteen[7], arrayNewVoucher_With_Code_Fourteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Fourteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Fourteen[7], arrayNewVoucher_With_Code_Fourteen[9], arrayNewVoucher_Without_Code_Fourteen[8], arrayNewVoucher_With_Code_Fourteen[10], arrayNewVoucher_Without_Code_Fourteen[9], 
					arrayNewVoucher_Without_Code_Fourteen[10], arrayNewVoucher_With_Code_Fourteen[11], arrayNewVoucher_With_Code_Fourteen[12], arrayNewVoucher_With_Code_Fourteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Fourteen[0]).toString(), arrayNewVoucher_With_Code_Fourteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Fourteen[3], 
					arrayNewVoucher_Without_Code_Fourteen[11], arrayNewVoucher_Without_Code_Fourteen[12], arrayNewVoucher_With_Code_Fourteen[12], arrayNewVoucher_With_Code_Fourteen[13], arrayNewStoreDetails_Fourteen[13],
					arrayNewStoreDetails_Fourteen[14], arrayNewStoreDetails_Fourteen[15], (arrayNewStore_Others_Details_Fourteen[1]).toString(), arrayNewVoucher_Without_Code_Fourteen[13], 
					arrayNewVoucher_With_Code_Fourteen[14], normalShortDescription, normalAppShortDescription, strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Fourteen("N18", array_New_Network18_Store_Fourteen_Details,"N18_Store_Fourteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Fourteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store fifteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Fifteen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Fifteen[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "App", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickPrimaryCashbackTab(driver);

			String normalShortDescription= objAddStore.enterNormalShortDescription(driver);

			String normalAppShortDescription= objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Fifteen[0]);

			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Fifteen[0]);

			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Fifteen[0]);

			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Fifteen[0]+" social message");

			Object arrayNewStore_Others_Details_Fifteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Fifteen[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Fifteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Fifteen[0].trim());

			objAddStore.clickEdit(driver);

			//objAddStore.clickSecondaryCashbackTab(driver);

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

			String[] array_New_Network18_Store_Fifteen_Details = new String[] {arrayNewStoreDetails_Fifteen[0], arrayNewStoreDetails_Fifteen[1], arrayNewStoreDetails_Fifteen[2], arrayNewStoreDetails_Fifteen[3], arrayNewStoreDetails_Fifteen[4],
					arrayNewStoreDetails_Fifteen[5], arrayNewStoreDetails_Fifteen[7], arrayNewStoreDetails_Fifteen[10], arrayNewStoreDetails_Fifteen[11], "Currency", "", "", "Currency", "", 
					"", arrayNewVoucher_Without_Code_Fifteen[1], arrayNewVoucher_Without_Code_Fifteen[2], arrayNewVoucher_Without_Code_Fifteen[5], arrayNewVoucher_Without_Code_Fifteen[6], 
					arrayNewVoucher_Without_Code_Fifteen[7], arrayNewVoucher_With_Code_Fifteen[1], arrayNewVoucher_With_Code_Fifteen[2], arrayNewVoucher_With_Code_Fifteen[5], arrayNewVoucher_With_Code_Fifteen[6], 
					arrayNewVoucher_With_Code_Fifteen[7], arrayNewVoucher_With_Code_Fifteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Fifteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Fifteen[7], arrayNewVoucher_With_Code_Fifteen[9], arrayNewVoucher_Without_Code_Fifteen[8], arrayNewVoucher_With_Code_Fifteen[10], arrayNewVoucher_Without_Code_Fifteen[9], 
					arrayNewVoucher_Without_Code_Fifteen[10], arrayNewVoucher_With_Code_Fifteen[11], arrayNewVoucher_With_Code_Fifteen[12], arrayNewVoucher_With_Code_Fifteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Fifteen[0]).toString(), arrayNewVoucher_With_Code_Fifteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Fifteen[3], 
					arrayNewVoucher_Without_Code_Fifteen[11], arrayNewVoucher_Without_Code_Fifteen[12], arrayNewVoucher_With_Code_Fifteen[12], arrayNewVoucher_With_Code_Fifteen[13], arrayNewStoreDetails_Fifteen[13],
					arrayNewStoreDetails_Fifteen[14], arrayNewStoreDetails_Fifteen[15], (arrayNewStore_Others_Details_Fifteen[1]).toString(), arrayNewVoucher_Without_Code_Fifteen[13], 
					arrayNewVoucher_With_Code_Fifteen[14],"","","",normalShortDescription, normalAppShortDescription,strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Fifteen("N18", array_New_Network18_Store_Fifteen_Details,"N18_Store_Fifteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Fifteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Mob Rewards Store four - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void mob_Rewards_Store_Four_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Four[] = objAddStore.enterRewardStoreDetails(driver, "In-Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

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

			String[] array_New_Rewards_Store_Four_Details = new String[] {arrayNewStoreDetails_Four[0], strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Four("MOB_RW", array_New_Rewards_Store_Four_Details,"MOB_RW_Store_Four");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("MOB_RW", "MOB_RW_Store_Four");
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