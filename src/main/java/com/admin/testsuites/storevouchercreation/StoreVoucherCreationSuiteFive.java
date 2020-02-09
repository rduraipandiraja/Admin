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


public class StoreVoucherCreationSuiteFive extends WrapperMethods {
	
	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store Sixteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_Sixteen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Sixteen[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Sixteen[0]);
			
			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Sixteen[0]);
			
			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Sixteen[0]);
			
			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Sixteen[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_Sixteen[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Sixteen[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "Desktop", 0);

			objAddStore.clickAddAnotherRow(driver);

			Object arrayNewStore_Nor_SCBDetails_Sixteen_[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "Desktop", 1);

			Object arrayNewStore_Others_Details_Sixteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Sixteen[0]);
		
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Sixteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Sixteen[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);
			
			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Sixteen[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Sixteen, "Increased Rate", "Desktop", strStoreID);

			String arrayNewVoucher_With_Code_Sixteen[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Sixteen, "Increased Rate", "COUPON CODE", "Desktop", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Sixteen[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Sixteen[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Sixteen[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);
			
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Sixteen[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Rewards_Store_Sixteen_Details = new String[] {arrayNewStoreDetails_Sixteen[0], arrayNewStoreDetails_Sixteen[1], arrayNewStoreDetails_Sixteen[2], arrayNewStoreDetails_Sixteen[3], arrayNewStoreDetails_Sixteen[4],
					arrayNewStoreDetails_Sixteen[5], arrayNewStoreDetails_Sixteen[7], arrayNewStoreDetails_Sixteen[10], arrayNewStoreDetails_Sixteen[11], arrayNewStore_Nor_PCBDetails_Sixteen[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Sixteen[4].toString(), arrayNewStore_Nor_PCBDetails_Sixteen[5].toString(), arrayNewStore_Nor_SCBDetails_Sixteen[1].toString(), arrayNewStore_Nor_SCBDetails_Sixteen[2].toString(), 
					arrayNewStore_Nor_SCBDetails_Sixteen[3].toString(), arrayNewVoucher_Without_Code_Sixteen[1], arrayNewVoucher_Without_Code_Sixteen[2], arrayNewVoucher_Without_Code_Sixteen[5], arrayNewVoucher_Without_Code_Sixteen[6], 
					arrayNewVoucher_Without_Code_Sixteen[7], arrayNewVoucher_With_Code_Sixteen[1], arrayNewVoucher_With_Code_Sixteen[2], arrayNewVoucher_With_Code_Sixteen[5], arrayNewVoucher_With_Code_Sixteen[6], 
					arrayNewVoucher_With_Code_Sixteen[7], arrayNewVoucher_With_Code_Sixteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Sixteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Sixteen[7], arrayNewVoucher_With_Code_Sixteen[9], arrayNewVoucher_Without_Code_Sixteen[8], arrayNewVoucher_With_Code_Sixteen[10], arrayNewVoucher_Without_Code_Sixteen[9], 
					arrayNewVoucher_Without_Code_Sixteen[10], arrayNewVoucher_With_Code_Sixteen[11], arrayNewVoucher_With_Code_Sixteen[12], arrayNewVoucher_With_Code_Sixteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Sixteen[0]).toString(), arrayNewVoucher_With_Code_Sixteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Sixteen[3], 
					arrayNewVoucher_Without_Code_Sixteen[11], arrayNewVoucher_Without_Code_Sixteen[12], arrayNewVoucher_With_Code_Sixteen[12], arrayNewVoucher_With_Code_Sixteen[13], arrayNewStoreDetails_Sixteen[13],
					arrayNewStoreDetails_Sixteen[14], arrayNewStoreDetails_Sixteen[15], (arrayNewStore_Others_Details_Sixteen[1]).toString(), arrayNewVoucher_Without_Code_Sixteen[13], arrayNewVoucher_With_Code_Sixteen[14], 
					arrayNewStore_Nor_SCBDetails_Sixteen_[1].toString(), arrayNewStore_Nor_SCBDetails_Sixteen_[2].toString(), arrayNewStore_Nor_SCBDetails_Sixteen_[3].toString() ,
					arrayNewStore_Nor_PCBDetails_Sixteen[6].toString(), arrayNewStore_Nor_PCBDetails_Sixteen[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Sixteen("RW", array_New_Rewards_Store_Sixteen_Details,"RW_Store_Sixteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_Sixteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store Seventeen - Creation and Loading the Corresponding Dynamic Values into Json File						   			   		**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_Seventeen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Seventeen[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Seventeen[0]);
			
			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Seventeen[0]);
			
			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Seventeen[0]);
			
			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Seventeen[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_Seventeen[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Seventeen[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "Mobile", 0);

			Object arrayNewStore_Others_Details_Seventeen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Seventeen[0]);
			
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Seventeen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Seventeen[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);
			
			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Seventeen[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Seventeen, "Increased Rate", "Mobile", strStoreID);

			String arrayNewVoucher_With_Code_Seventeen[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Seventeen, "Increased Rate", "COUPON CODE", "Mobile", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Seventeen[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Seventeen[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Seventeen[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);
			
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Seventeen[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Rewards_Store_Seventeen_Details = new String[] {arrayNewStoreDetails_Seventeen[0], arrayNewStoreDetails_Seventeen[1], arrayNewStoreDetails_Seventeen[2], arrayNewStoreDetails_Seventeen[3], arrayNewStoreDetails_Seventeen[4],
					arrayNewStoreDetails_Seventeen[5], arrayNewStoreDetails_Seventeen[7], arrayNewStoreDetails_Seventeen[10], arrayNewStoreDetails_Seventeen[11], arrayNewStore_Nor_PCBDetails_Seventeen[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Seventeen[4].toString(), arrayNewStore_Nor_PCBDetails_Seventeen[5].toString(), arrayNewStore_Nor_SCBDetails_Seventeen[1].toString(), arrayNewStore_Nor_SCBDetails_Seventeen[2].toString(), 
					arrayNewStore_Nor_SCBDetails_Seventeen[3].toString(), arrayNewVoucher_Without_Code_Seventeen[1], arrayNewVoucher_Without_Code_Seventeen[2], arrayNewVoucher_Without_Code_Seventeen[5], arrayNewVoucher_Without_Code_Seventeen[6], 
					arrayNewVoucher_Without_Code_Seventeen[7], arrayNewVoucher_With_Code_Seventeen[1], arrayNewVoucher_With_Code_Seventeen[2], arrayNewVoucher_With_Code_Seventeen[5], arrayNewVoucher_With_Code_Seventeen[6], 
					arrayNewVoucher_With_Code_Seventeen[7], arrayNewVoucher_With_Code_Seventeen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Seventeen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Seventeen[7], arrayNewVoucher_With_Code_Seventeen[9], arrayNewVoucher_Without_Code_Seventeen[8], arrayNewVoucher_With_Code_Seventeen[10], arrayNewVoucher_Without_Code_Seventeen[9], 
					arrayNewVoucher_Without_Code_Seventeen[10], arrayNewVoucher_With_Code_Seventeen[11], arrayNewVoucher_With_Code_Seventeen[12], arrayNewVoucher_With_Code_Seventeen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Seventeen[0]).toString(), arrayNewVoucher_With_Code_Seventeen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Seventeen[3], 
					arrayNewVoucher_Without_Code_Seventeen[11], arrayNewVoucher_Without_Code_Seventeen[12], arrayNewVoucher_With_Code_Seventeen[12], arrayNewVoucher_With_Code_Seventeen[13], arrayNewStoreDetails_Seventeen[13],
					arrayNewStoreDetails_Seventeen[14], arrayNewStoreDetails_Seventeen[15], (arrayNewStore_Others_Details_Seventeen[1]).toString(), arrayNewVoucher_Without_Code_Seventeen[13], 
					arrayNewVoucher_With_Code_Seventeen[14], arrayNewStore_Nor_PCBDetails_Seventeen[6].toString(), arrayNewStore_Nor_PCBDetails_Seventeen[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Seventeen("RW", array_New_Rewards_Store_Seventeen_Details,"RW_Store_Seventeen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_Seventeen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store Eighteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			    	**/
	/*************************************************************************************************************************************************************************************/

	@Test
	public void rewards_Store_Eighteen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Eighteen[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Eighteen[0]);
			
			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Eighteen[0]);
			
			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Eighteen[0]);
			
			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Eighteen[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_Eighteen[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Eighteen[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "Tablet", 0);

			Object arrayNewStore_Others_Details_Eighteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Eighteen[0]);

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Eighteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Eighteen[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);
			
			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Eighteen[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Eighteen, "Increased Rate", "Tablet", strStoreID);

			String arrayNewVoucher_With_Code_Eighteen[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Eighteen, "Increased Rate", "COUPON CODE", "Tablet", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Eighteen[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Eighteen[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Eighteen[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);
			
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Eighteen[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Rewards_Store_Eighteen_Details = new String[] {arrayNewStoreDetails_Eighteen[0], arrayNewStoreDetails_Eighteen[1], arrayNewStoreDetails_Eighteen[2], arrayNewStoreDetails_Eighteen[3], arrayNewStoreDetails_Eighteen[4],
					arrayNewStoreDetails_Eighteen[5], arrayNewStoreDetails_Eighteen[7], arrayNewStoreDetails_Eighteen[10], arrayNewStoreDetails_Eighteen[11], arrayNewStore_Nor_PCBDetails_Eighteen[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Eighteen[4].toString(), arrayNewStore_Nor_PCBDetails_Eighteen[5].toString(), arrayNewStore_Nor_SCBDetails_Eighteen[1].toString(), arrayNewStore_Nor_SCBDetails_Eighteen[2].toString(), 
					arrayNewStore_Nor_SCBDetails_Eighteen[3].toString(), arrayNewVoucher_Without_Code_Eighteen[1], arrayNewVoucher_Without_Code_Eighteen[2], arrayNewVoucher_Without_Code_Eighteen[5], arrayNewVoucher_Without_Code_Eighteen[6], 
					arrayNewVoucher_Without_Code_Eighteen[7], arrayNewVoucher_With_Code_Eighteen[1], arrayNewVoucher_With_Code_Eighteen[2], arrayNewVoucher_With_Code_Eighteen[5], arrayNewVoucher_With_Code_Eighteen[6], 
					arrayNewVoucher_With_Code_Eighteen[7], arrayNewVoucher_With_Code_Eighteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Eighteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Eighteen[7], arrayNewVoucher_With_Code_Eighteen[9], arrayNewVoucher_Without_Code_Eighteen[8], arrayNewVoucher_With_Code_Eighteen[10], arrayNewVoucher_Without_Code_Eighteen[9], 
					arrayNewVoucher_Without_Code_Eighteen[10], arrayNewVoucher_With_Code_Eighteen[11], arrayNewVoucher_With_Code_Eighteen[12], arrayNewVoucher_With_Code_Eighteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Eighteen[0]).toString(), arrayNewVoucher_With_Code_Eighteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Eighteen[3], 
					arrayNewVoucher_Without_Code_Eighteen[11], arrayNewVoucher_Without_Code_Eighteen[12], arrayNewVoucher_With_Code_Eighteen[12], arrayNewVoucher_With_Code_Eighteen[13], arrayNewStoreDetails_Eighteen[13],
					arrayNewStoreDetails_Eighteen[14], arrayNewStoreDetails_Eighteen[15], (arrayNewStore_Others_Details_Eighteen[1]).toString(), arrayNewVoucher_Without_Code_Eighteen[13], 
					arrayNewVoucher_With_Code_Eighteen[14], arrayNewStore_Nor_PCBDetails_Eighteen[6].toString(), arrayNewStore_Nor_PCBDetails_Eighteen[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Eighteen("RW", array_New_Rewards_Store_Eighteen_Details,"RW_Store_Eighteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_Eighteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store Eighteen - Creation and Loading the Corresponding Dynamic Values into Json File						   			    	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_Nineteen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Nineteen[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Nineteen[0]);
			
			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Nineteen[0]);
			
			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Nineteen[0]);
			
			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Nineteen[0]+" social message");

			Object arrayNewStore_Nor_PCBDetails_Nineteen[] = objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Nor_SCBDetails_Nineteen[] = objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "App", 0);

			Object arrayNewStore_Others_Details_Nineteen[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Nineteen[0]);
		
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Nineteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Nineteen[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);
			
			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Nineteen[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Nineteen, "Increased Rate", "App", strStoreID);

			String arrayNewVoucher_With_Code_Nineteen[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Nineteen, "Increased Rate", "COUPON CODE", "App", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Nineteen[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Nineteen[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Nineteen[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);
			
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	
			
			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Nineteen[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Rewards_Store_Nineteen_Details = new String[] {arrayNewStoreDetails_Nineteen[0], arrayNewStoreDetails_Nineteen[1], arrayNewStoreDetails_Nineteen[2], arrayNewStoreDetails_Nineteen[3], arrayNewStoreDetails_Nineteen[4],
					arrayNewStoreDetails_Nineteen[5], arrayNewStoreDetails_Nineteen[7], arrayNewStoreDetails_Nineteen[10], arrayNewStoreDetails_Nineteen[11], arrayNewStore_Nor_PCBDetails_Nineteen[0].toString(), 
					arrayNewStore_Nor_PCBDetails_Nineteen[4].toString(), arrayNewStore_Nor_PCBDetails_Nineteen[5].toString(), arrayNewStore_Nor_SCBDetails_Nineteen[1].toString(), arrayNewStore_Nor_SCBDetails_Nineteen[2].toString(), 
					arrayNewStore_Nor_SCBDetails_Nineteen[3].toString(), arrayNewVoucher_Without_Code_Nineteen[1], arrayNewVoucher_Without_Code_Nineteen[2], arrayNewVoucher_Without_Code_Nineteen[5], arrayNewVoucher_Without_Code_Nineteen[6], 
					arrayNewVoucher_Without_Code_Nineteen[7], arrayNewVoucher_With_Code_Nineteen[1], arrayNewVoucher_With_Code_Nineteen[2], arrayNewVoucher_With_Code_Nineteen[5], arrayNewVoucher_With_Code_Nineteen[6], 
					arrayNewVoucher_With_Code_Nineteen[7], arrayNewVoucher_With_Code_Nineteen[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Nineteen[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Nineteen[7], arrayNewVoucher_With_Code_Nineteen[9], arrayNewVoucher_Without_Code_Nineteen[8], arrayNewVoucher_With_Code_Nineteen[10], arrayNewVoucher_Without_Code_Nineteen[9], 
					arrayNewVoucher_Without_Code_Nineteen[10], arrayNewVoucher_With_Code_Nineteen[11], arrayNewVoucher_With_Code_Nineteen[12], arrayNewVoucher_With_Code_Nineteen[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Nineteen[0]).toString(), arrayNewVoucher_With_Code_Nineteen[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Nineteen[3], 
					arrayNewVoucher_Without_Code_Nineteen[11], arrayNewVoucher_Without_Code_Nineteen[12], arrayNewVoucher_With_Code_Nineteen[12], arrayNewVoucher_With_Code_Nineteen[13], arrayNewStoreDetails_Nineteen[13],
					arrayNewStoreDetails_Nineteen[14], arrayNewStoreDetails_Nineteen[15], (arrayNewStore_Others_Details_Nineteen[1]).toString(), arrayNewVoucher_Without_Code_Nineteen[13], 
					arrayNewVoucher_With_Code_Nineteen[14], arrayNewStore_Nor_PCBDetails_Nineteen[6].toString(), arrayNewStore_Nor_PCBDetails_Nineteen[7].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Nineteen("RW", array_New_Rewards_Store_Nineteen_Details,"RW_Store_Nineteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_Nineteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store Twenty - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_Twenty_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Twenty[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);
			
			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_Twenty[0]);
			
			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_Twenty[0]);
			
			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_Twenty[0]);
			
			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_Twenty[0]+" social message");

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_Twenty[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "Increased Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "Desktop",0);

			Object arrayNewStore_Cal_SCBDetails_Twenty[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "Desktop",0);

			Object arrayNewStore_Others_Details_Twenty[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_Twenty[0]);
		
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Twenty[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_Twenty[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);
			
			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_Twenty[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_Twenty, "Increased Rate", "Desktop", strStoreID);

			String arrayNewVoucher_With_Code_Twenty[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_Twenty, "Increased Rate", "COUPON CODE", "Desktop", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_Twenty[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_Twenty[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_Twenty[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);
			
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_Twenty[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Rewards_Store_Twenty_Details = new String[] {arrayNewStoreDetails_Twenty[0], arrayNewStoreDetails_Twenty[1], arrayNewStoreDetails_Twenty[2], arrayNewStoreDetails_Twenty[3], arrayNewStoreDetails_Twenty[4],
					arrayNewStoreDetails_Twenty[5], arrayNewStoreDetails_Twenty[7], arrayNewStoreDetails_Twenty[10], arrayNewStoreDetails_Twenty[11], arrayNewStore_Cal_PCBDetails_Twenty[0].toString(), 
					arrayNewStore_Cal_PCBDetails_Twenty[6].toString(), arrayNewStore_Cal_PCBDetails_Twenty[5].toString(), arrayNewStore_Cal_SCBDetails_Twenty[1].toString(), arrayNewStore_Cal_SCBDetails_Twenty[2].toString(), 
					arrayNewStore_Cal_SCBDetails_Twenty[3].toString(), arrayNewVoucher_Without_Code_Twenty[1], arrayNewVoucher_Without_Code_Twenty[2], arrayNewVoucher_Without_Code_Twenty[5], arrayNewVoucher_Without_Code_Twenty[6], 
					arrayNewVoucher_Without_Code_Twenty[7], arrayNewVoucher_With_Code_Twenty[1], arrayNewVoucher_With_Code_Twenty[2], arrayNewVoucher_With_Code_Twenty[5], arrayNewVoucher_With_Code_Twenty[6], 
					arrayNewVoucher_With_Code_Twenty[7], arrayNewVoucher_With_Code_Twenty[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_Twenty[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_Twenty[7], arrayNewVoucher_With_Code_Twenty[9], arrayNewVoucher_Without_Code_Twenty[8], arrayNewVoucher_With_Code_Twenty[10], arrayNewVoucher_Without_Code_Twenty[9], 
					arrayNewVoucher_Without_Code_Twenty[10], arrayNewVoucher_With_Code_Twenty[11], arrayNewVoucher_With_Code_Twenty[12], arrayNewVoucher_With_Code_Twenty[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_Twenty[0]).toString(), arrayNewVoucher_With_Code_Twenty[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_Twenty[3], 
					arrayNewVoucher_Without_Code_Twenty[11], arrayNewVoucher_Without_Code_Twenty[12], arrayNewVoucher_With_Code_Twenty[12], arrayNewVoucher_With_Code_Twenty[13], arrayNewStoreDetails_Twenty[13],
					arrayNewStoreDetails_Twenty[14], arrayNewStoreDetails_Twenty[15], (arrayNewStore_Others_Details_Twenty[1]).toString(), arrayNewVoucher_Without_Code_Twenty[13], 
					arrayNewVoucher_With_Code_Twenty[14], arrayNewStore_Cal_PCBDetails_Twenty[11].toString(), arrayNewStore_Cal_PCBDetails_Twenty[12].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Twenty("RW", array_New_Rewards_Store_Twenty_Details,"RW_Store_Twenty");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_Twenty");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store TwentyOne - Creation and Loading the Corresponding Dynamic Values into Json File						   			    	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_TwentyOne_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_TwentyOne[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_TwentyOne[0]);
			
			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_TwentyOne[0]);
			
			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_TwentyOne[0]);
			
			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_TwentyOne[0]+" social message");

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_TwentyOne[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "Increased Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "Mobile",0);

			Object arrayNewStore_Cal_SCBDetails_TwentyOne[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "Mobile",0);

			Object arrayNewStore_Others_Details_TwentyOne[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_TwentyOne[0]);
			
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_TwentyOne[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_TwentyOne[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);
			
			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_TwentyOne[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_TwentyOne, "Increased Rate", "Mobile", strStoreID);

			String arrayNewVoucher_With_Code_TwentyOne[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_TwentyOne, "Increased Rate", "COUPON CODE", "Mobile", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_TwentyOne[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_TwentyOne[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_TwentyOne[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);
			
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_TwentyOne[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";
			
			String[] array_New_Rewards_Store_TwentyOne_Details = new String[] {arrayNewStoreDetails_TwentyOne[0], arrayNewStoreDetails_TwentyOne[1], arrayNewStoreDetails_TwentyOne[2], arrayNewStoreDetails_TwentyOne[3], arrayNewStoreDetails_TwentyOne[4],
					arrayNewStoreDetails_TwentyOne[5], arrayNewStoreDetails_TwentyOne[7], arrayNewStoreDetails_TwentyOne[10], arrayNewStoreDetails_TwentyOne[11], arrayNewStore_Cal_PCBDetails_TwentyOne[0].toString(), 
					arrayNewStore_Cal_PCBDetails_TwentyOne[6].toString(), arrayNewStore_Cal_PCBDetails_TwentyOne[5].toString(), arrayNewStore_Cal_SCBDetails_TwentyOne[1].toString(), arrayNewStore_Cal_SCBDetails_TwentyOne[2].toString(), 
					arrayNewStore_Cal_SCBDetails_TwentyOne[3].toString(), arrayNewVoucher_Without_Code_TwentyOne[1], arrayNewVoucher_Without_Code_TwentyOne[2], arrayNewVoucher_Without_Code_TwentyOne[5], arrayNewVoucher_Without_Code_TwentyOne[6], 
					arrayNewVoucher_Without_Code_TwentyOne[7], arrayNewVoucher_With_Code_TwentyOne[1], arrayNewVoucher_With_Code_TwentyOne[2], arrayNewVoucher_With_Code_TwentyOne[5], arrayNewVoucher_With_Code_TwentyOne[6], 
					arrayNewVoucher_With_Code_TwentyOne[7], arrayNewVoucher_With_Code_TwentyOne[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_TwentyOne[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_TwentyOne[7], arrayNewVoucher_With_Code_TwentyOne[9], arrayNewVoucher_Without_Code_TwentyOne[8], arrayNewVoucher_With_Code_TwentyOne[10], arrayNewVoucher_Without_Code_TwentyOne[9], 
					arrayNewVoucher_Without_Code_TwentyOne[10], arrayNewVoucher_With_Code_TwentyOne[11], arrayNewVoucher_With_Code_TwentyOne[12], arrayNewVoucher_With_Code_TwentyOne[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_TwentyOne[0]).toString(), arrayNewVoucher_With_Code_TwentyOne[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_TwentyOne[3], 
					arrayNewVoucher_Without_Code_TwentyOne[11], arrayNewVoucher_Without_Code_TwentyOne[12], arrayNewVoucher_With_Code_TwentyOne[12], arrayNewVoucher_With_Code_TwentyOne[13], arrayNewStoreDetails_TwentyOne[13],
					arrayNewStoreDetails_TwentyOne[14], arrayNewStoreDetails_TwentyOne[15], (arrayNewStore_Others_Details_TwentyOne[1]).toString(), arrayNewVoucher_Without_Code_TwentyOne[13], 
					arrayNewVoucher_With_Code_TwentyOne[14], arrayNewStore_Cal_PCBDetails_TwentyOne[11].toString(), arrayNewStore_Cal_PCBDetails_TwentyOne[12].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_TwentyOne("RW", array_New_Rewards_Store_TwentyOne_Details,"RW_Store_TwentyOne");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_TwentyOne");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store TwentyTwo - Creation and Loading the Corresponding Dynamic Values into Json File						   			    	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_TwentyTwo_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_TwentyTwo[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_TwentyTwo[0]);
			
			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_TwentyTwo[0]);
			
			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_TwentyTwo[0]);
			
			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_TwentyTwo[0]+" social message");

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_TwentyTwo[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "Increased Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "Tablet",0);

			Object arrayNewStore_Cal_SCBDetails_TwentyTwo[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "Tablet",0);

			Object arrayNewStore_Others_Details_TwentyTwo[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_TwentyTwo[0]);
		
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_TwentyTwo[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_TwentyTwo[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);
			
			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_TwentyTwo[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_TwentyTwo, "Increased Rate", "Tablet", strStoreID);

			String arrayNewVoucher_With_Code_TwentyTwo[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_TwentyTwo, "Increased Rate", "COUPON CODE", "Tablet", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_TwentyTwo[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_TwentyTwo[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_TwentyTwo[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);
			
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);	

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_TwentyTwo[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Rewards_Store_TwentyTwo_Details = new String[] {arrayNewStoreDetails_TwentyTwo[0], arrayNewStoreDetails_TwentyTwo[1], arrayNewStoreDetails_TwentyTwo[2], arrayNewStoreDetails_TwentyTwo[3], arrayNewStoreDetails_TwentyTwo[4],
					arrayNewStoreDetails_TwentyTwo[5], arrayNewStoreDetails_TwentyTwo[7], arrayNewStoreDetails_TwentyTwo[10], arrayNewStoreDetails_TwentyTwo[11], arrayNewStore_Cal_PCBDetails_TwentyTwo[0].toString(), 
					arrayNewStore_Cal_PCBDetails_TwentyTwo[6].toString(), arrayNewStore_Cal_PCBDetails_TwentyTwo[5].toString(), arrayNewStore_Cal_SCBDetails_TwentyTwo[1].toString(), arrayNewStore_Cal_SCBDetails_TwentyTwo[2].toString(), 
					arrayNewStore_Cal_SCBDetails_TwentyTwo[3].toString(), arrayNewVoucher_Without_Code_TwentyTwo[1], arrayNewVoucher_Without_Code_TwentyTwo[2], arrayNewVoucher_Without_Code_TwentyTwo[5], arrayNewVoucher_Without_Code_TwentyTwo[6], 
					arrayNewVoucher_Without_Code_TwentyTwo[7], arrayNewVoucher_With_Code_TwentyTwo[1], arrayNewVoucher_With_Code_TwentyTwo[2], arrayNewVoucher_With_Code_TwentyTwo[5], arrayNewVoucher_With_Code_TwentyTwo[6], 
					arrayNewVoucher_With_Code_TwentyTwo[7], arrayNewVoucher_With_Code_TwentyTwo[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_TwentyTwo[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_TwentyTwo[7], arrayNewVoucher_With_Code_TwentyTwo[9], arrayNewVoucher_Without_Code_TwentyTwo[8], arrayNewVoucher_With_Code_TwentyTwo[10], arrayNewVoucher_Without_Code_TwentyTwo[9], 
					arrayNewVoucher_Without_Code_TwentyTwo[10], arrayNewVoucher_With_Code_TwentyTwo[11], arrayNewVoucher_With_Code_TwentyTwo[12], arrayNewVoucher_With_Code_TwentyTwo[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_TwentyTwo[0]).toString(), arrayNewVoucher_With_Code_TwentyTwo[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_TwentyTwo[3], 
					arrayNewVoucher_Without_Code_TwentyTwo[11], arrayNewVoucher_Without_Code_TwentyTwo[12], arrayNewVoucher_With_Code_TwentyTwo[12], arrayNewVoucher_With_Code_TwentyTwo[13], arrayNewStoreDetails_TwentyTwo[13],
					arrayNewStoreDetails_TwentyTwo[14], arrayNewStoreDetails_TwentyTwo[15], (arrayNewStore_Others_Details_TwentyTwo[1]).toString(), arrayNewVoucher_Without_Code_TwentyTwo[13], 
					arrayNewVoucher_With_Code_TwentyTwo[14], arrayNewStore_Cal_PCBDetails_TwentyTwo[11].toString(), arrayNewStore_Cal_PCBDetails_TwentyTwo[12].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_TwentyTwo("RW", array_New_Rewards_Store_TwentyTwo_Details,"RW_Store_TwentyTwo");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_TwentyTwo");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store TwentyTwo - Creation and Loading the Corresponding Dynamic Values into Json File						   			    **/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_TwentyThree_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_TwentyThree[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			String array_CategoryValues 	= "";

			objAddStore.clickSEOTab(driver);

			String strTextToEnter_Keywords_Details = objAddStore.enterKeywordsDetails(driver, arrayNewStoreDetails_TwentyThree[0]);
			
			String newStore_Input_Meta_Tags_Details = objAddStore.enterMetaTags(driver, arrayNewStoreDetails_TwentyThree[0]);
			
			String newStore_Input_Product_Meta_Tags_Details = objAddStore.enterProductMetaTags(driver, arrayNewStoreDetails_TwentyThree[0]);
			
			String newStore_Input_Social_Media_Message_Details = objAddStore.enterSocialMediaMessageDetails(driver, "This is "+arrayNewStoreDetails_TwentyThree[0]+" social message");

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_TwentyThree[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Percentage", "INR", 1500, 75, "Increased Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering Normal Secondary cashback", "App",0);

			Object arrayNewStore_Cal_SCBDetails_TwentyThree[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Percentage", 1250, "This Is Test User Entering calender Secondary cashback", "Increased Rate", "App",0);

			Object arrayNewStore_Others_Details_TwentyThree[] = objAddStore.enterOthers(driver, "Terms and conditions");

			String arrayNewStore_StoreContent_Details_One = objAddStore.StoreContent_Creation(driver, arrayNewStoreDetails_TwentyThree[0]);
		
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_TwentyThree[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			String strStoreType = objAddStore.getStoreType(driver, arrayNewStoreDetails_TwentyThree[0].trim());

			objAddStore.clickEdit(driver);

			objAddStore.clickSecondaryCashbackTab(driver);
			
			String strSecondaryCashbackId = objAddStore.getSecondaryCashbackID(driver, 1);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			String arrayNewVoucher_Without_Code_TwentyThree[] = objVouchers.enterVoucherWithoutCodeDetails_APITesting(driver, arrayNewStoreDetails_TwentyThree, "Increased Rate", "App", strStoreID);

			String arrayNewVoucher_With_Code_TwentyThree[] = objVouchers.enterVoucherWithCodeDetails_APITesting(driver, arrayNewStoreDetails_TwentyThree, "Increased Rate", "COUPON CODE", "App", strStoreID);

			/********************************************************************** VOUCHER PAGE *******************************************************************************/

			//click_Clear_Until_Default_Dropdown_Value_SelectDateRange_By_JavaScriptExecutor(driver, "btn_Clear");

			objVouchers.enterSearchCriteria(driver);

			objVouchers.enterStoreName(driver, arrayNewStoreDetails_TwentyThree[0]);

			objVouchers.clickSearch(driver);

			String strVoucherCount = objVouchers.getVoucherCount(driver);

			String strVoucherID_One = objVouchers.getVoucherID(driver, 1);

			String strVoucherID_Two = objVouchers.getVoucherID(driver, 2);

			String strVoucherType_One = objVouchers.getVoucherType(driver, arrayNewVoucher_Without_Code_TwentyThree[1].trim(), 1);

			String strVoucherType_Two = objVouchers.getVoucherType(driver, arrayNewVoucher_With_Code_TwentyThree[1].trim(), 1);

			/******************************************************************* AFFILIATE NW PAGE *****************************************************************************/

			objDashboard.clickMainMenuSettings(driver);
			
			objAffillateNetwork.clickSubMenuAffiliateNetwork(driver);			

			objAffillateNetwork.clickAffiliateNetworkEditIcon(driver, arrayNewStoreDetails_TwentyThree[3].trim());

			String str_Affiliate_Network_Id = objAffillateNetwork.getAffiliateNetworkID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Rewards_Store_TwentyThree_Details = new String[] {arrayNewStoreDetails_TwentyThree[0], arrayNewStoreDetails_TwentyThree[1], arrayNewStoreDetails_TwentyThree[2], arrayNewStoreDetails_TwentyThree[3], arrayNewStoreDetails_TwentyThree[4],
					arrayNewStoreDetails_TwentyThree[5], arrayNewStoreDetails_TwentyThree[7], arrayNewStoreDetails_TwentyThree[10], arrayNewStoreDetails_TwentyThree[11], arrayNewStore_Cal_PCBDetails_TwentyThree[0].toString(), 
					arrayNewStore_Cal_PCBDetails_TwentyThree[6].toString(), arrayNewStore_Cal_PCBDetails_TwentyThree[5].toString(), arrayNewStore_Cal_SCBDetails_TwentyThree[1].toString(), arrayNewStore_Cal_SCBDetails_TwentyThree[2].toString(), 
					arrayNewStore_Cal_SCBDetails_TwentyThree[3].toString(), arrayNewVoucher_Without_Code_TwentyThree[1], arrayNewVoucher_Without_Code_TwentyThree[2], arrayNewVoucher_Without_Code_TwentyThree[5], arrayNewVoucher_Without_Code_TwentyThree[6], 
					arrayNewVoucher_Without_Code_TwentyThree[7], arrayNewVoucher_With_Code_TwentyThree[1], arrayNewVoucher_With_Code_TwentyThree[2], arrayNewVoucher_With_Code_TwentyThree[5], arrayNewVoucher_With_Code_TwentyThree[6], 
					arrayNewVoucher_With_Code_TwentyThree[7], arrayNewVoucher_With_Code_TwentyThree[8], strStoreID, strVoucherID_One, strVoucherID_Two, strVoucherCount, arrayNewStoreDetails_TwentyThree[12], array_CategoryValues , 
					arrayNewVoucher_Without_Code_TwentyThree[7], arrayNewVoucher_With_Code_TwentyThree[9], arrayNewVoucher_Without_Code_TwentyThree[8], arrayNewVoucher_With_Code_TwentyThree[10], arrayNewVoucher_Without_Code_TwentyThree[9], 
					arrayNewVoucher_Without_Code_TwentyThree[10], arrayNewVoucher_With_Code_TwentyThree[11], arrayNewVoucher_With_Code_TwentyThree[12], arrayNewVoucher_With_Code_TwentyThree[11], str_Affiliate_Network_Id, strStoreType, 
					strVoucherType_One, strVoucherType_Two, arrayNewStore_StoreContent_Details_One, strTextToEnter_Keywords_Details, newStore_Input_Meta_Tags_Details, newStore_Input_Product_Meta_Tags_Details, 
					newStore_Input_Social_Media_Message_Details, (arrayNewStore_Others_Details_TwentyThree[0]).toString(), arrayNewVoucher_With_Code_TwentyThree[3], strSecondaryCashbackId, arrayNewVoucher_With_Code_TwentyThree[3], 
					arrayNewVoucher_Without_Code_TwentyThree[11], arrayNewVoucher_Without_Code_TwentyThree[12], arrayNewVoucher_With_Code_TwentyThree[12], arrayNewVoucher_With_Code_TwentyThree[13], arrayNewStoreDetails_TwentyThree[13],
					arrayNewStoreDetails_TwentyThree[14], arrayNewStoreDetails_TwentyThree[15], (arrayNewStore_Others_Details_TwentyThree[1]).toString(), arrayNewVoucher_Without_Code_TwentyThree[13], 
					arrayNewVoucher_With_Code_TwentyThree[14], arrayNewStore_Cal_PCBDetails_TwentyThree[11].toString(), arrayNewStore_Cal_PCBDetails_TwentyThree[12].toString(), strExecution_BooleanStatus};		

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_TwentyThree("RW", array_New_Rewards_Store_TwentyThree_Details,"RW_Store_TwentyThree");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_TwentyThree");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Cash back Store four - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void cashback_Store_TwentyFour_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_TwentyFour[] = objAddStore.enterCashbackStoreDetails(driver, "In-Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);
			
			objAddStore.enterNormalShortDescription(driver);
			
			objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.enterOthers(driver, "Terms and conditions");
			
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_TwentyFour[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";
			
			String[] array_New_CashBack_Store_TwentyFour_Details = new String[] {arrayNewStoreDetails_TwentyFour[0], strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Four("CB", array_New_CashBack_Store_TwentyFour_Details,"CB_Store_Four");

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
	public void cashback_Store_TwentyFive_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_TwentyFive[] = objAddStore.enterCashbackStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_TwentyFive[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "Exclusive Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Cal_SCBDetails_TwentyFive[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Exclusive Rate", "All", 0);

			objAddStore.clickAddAnotherRow(driver);

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 1);

			Object arrayNewStore_Cal_SCBDetails_TwentyFive_[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Exclusive Rate", "All", 1);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_TwentyFive[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			objVouchers.enterVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_TwentyFive, "Exclusive Rate", "All", strStoreID);

			objVouchers.enterVoucherWithCodeDetails(driver, arrayNewStoreDetails_TwentyFive, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_CashBack_Store_TwentyFive_Details = new String[] {arrayNewStoreDetails_TwentyFive[0], arrayNewStore_Cal_PCBDetails_TwentyFive[6].toString(),  
					arrayNewStore_Cal_PCBDetails_TwentyFive[0].toString(),  arrayNewStore_Cal_PCBDetails_TwentyFive[5].toString(),  arrayNewStore_Cal_PCBDetails_TwentyFive[4].toString(), 
					arrayNewStore_Cal_SCBDetails_TwentyFive[2].toString(),  arrayNewStore_Cal_SCBDetails_TwentyFive[1].toString(),  arrayNewStore_Cal_SCBDetails_TwentyFive[3].toString(),  
					arrayNewStore_Cal_SCBDetails_TwentyFive[4].toString(), arrayNewStore_Cal_SCBDetails_TwentyFive_[2].toString(),  arrayNewStore_Cal_SCBDetails_TwentyFive_[1].toString(),  
					arrayNewStore_Cal_SCBDetails_TwentyFive_[3].toString(),  arrayNewStore_Cal_SCBDetails_TwentyFive_[4].toString(), strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Five("CB", array_New_CashBack_Store_TwentyFive_Details,"CB_Store_TwentyFive");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("CB", "CB_Store_TwentyFive");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store four - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_TwentyFour_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_TwentyFour[] = objAddStore.enterRewardStoreDetails(driver, "In-Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);
			
			objAddStore.enterNormalShortDescription(driver);
			
			objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.enterOthers(driver, "Terms and conditions");
			
			objAddStore.click_Button_AddStore(driver);
			
			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_TwentyFour[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";
			
			String[] array_New_Rewards_Store_TwentyFour_Details = new String[] {arrayNewStoreDetails_TwentyFour[0], strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Four("RW", array_New_Rewards_Store_TwentyFour_Details,"RW_Store_TwentyFour");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_TwentyFour");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Rewards Store five - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void rewards_Store_TwentyFive_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_TwentyFive[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.enterNormalPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "This Is Test User Entering normal Primary cashback");

			Object arrayNewStore_Cal_PCBDetails_TwentyFive[] = objAddStore.enterCalendarPrimaryCashbackDetails(driver, "Currency", "INR", 1500, 75, "Exclusive Rate", "This Is Test User Entering calender Primary cashback");

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 0);

			Object arrayNewStore_Cal_SCBDetails_TwentyFive[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 0, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Exclusive Rate", "All", 0);

			objAddStore.clickAddAnotherRow(driver);

			objAddStore.enterNormalSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering Normal Secondary cashback", "All", 1);

			Object arrayNewStore_Cal_SCBDetails_TwentyFive_[] = objAddStore.enterCalendarSecondaryCashbackDetails(driver, 1, "Currency", 1250, "This Is Test User Entering calender Secondary cashback", "Exclusive Rate", "All", 1);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_TwentyFive[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			objVouchers.enterVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_TwentyFive, "Exclusive Rate", "All", strStoreID);

			objVouchers.enterVoucherWithCodeDetails(driver, arrayNewStoreDetails_TwentyFive, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Rewards_Store_TwentyFive_Details = new String[] {arrayNewStoreDetails_TwentyFive[0], arrayNewStore_Cal_PCBDetails_TwentyFive[6].toString(),  
					arrayNewStore_Cal_PCBDetails_TwentyFive[0].toString(),  arrayNewStore_Cal_PCBDetails_TwentyFive[5].toString(),  arrayNewStore_Cal_PCBDetails_TwentyFive[4].toString(), 
					arrayNewStore_Cal_SCBDetails_TwentyFive[2].toString(),  arrayNewStore_Cal_SCBDetails_TwentyFive[1].toString(),  arrayNewStore_Cal_SCBDetails_TwentyFive[3].toString(),  
					arrayNewStore_Cal_SCBDetails_TwentyFive[4].toString(), arrayNewStore_Cal_SCBDetails_TwentyFive_[2].toString(),  arrayNewStore_Cal_SCBDetails_TwentyFive_[1].toString(),  
					arrayNewStore_Cal_SCBDetails_TwentyFive_[3].toString(),  arrayNewStore_Cal_SCBDetails_TwentyFive_[4].toString(), strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Five("RW", array_New_Rewards_Store_TwentyFive_Details,"RW_Store_TwentyFive");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("RW", "RW_Store_TwentyFive");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store four - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Sixteen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Sixteen[] = objAddStore.enterNetwork18StoreDetails(driver, "In-Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);
			
			objAddStore.enterNormalShortDescription(driver);
			
			objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.enterOthers(driver, "Terms and conditions");
			
			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Sixteen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";
			
			String[] array_New_Network18_Store_Sixteen_Details = new String[] {arrayNewStoreDetails_Sixteen[0], strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Four("N18", array_New_Network18_Store_Sixteen_Details,"N18_Store_Sixteen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Sixteen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Network 18 Store five - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void network18_Store_Seventeen_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Seventeen[] = objAddStore.enterNetwork18StoreDetails(driver, "Active", "Vouchers and Offers", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

			objAddStore.clickCategoryCheckbox(driver);

			objAddStore.clickPrimaryCashbackTab(driver);
			
			objAddStore.enterNormalShortDescription(driver);
			
			objAddStore.enterNormalAppShortDescription(driver);

			objAddStore.enterOthers(driver, "Terms and conditions");

			objAddStore.click_Button_AddStore(driver);

			/********************************************************************** STORE PAGE *********************************************************************************/

			objAddStore.enterStoreName(driver, arrayNewStoreDetails_Seventeen[0]);

			objAddStore.clickSearch(driver);

			String strStoreID = objAddStore.getStoreID(driver);

			/******************************************************************* ALL VOUCHER PAGE ******************************************************************************/

			objVouchers.clickSubMenuVoucher(driver);

			objVouchers.enterVoucherWithoutCodeDetails(driver, arrayNewStoreDetails_Seventeen, "Exclusive Rate", "All", strStoreID);

			objVouchers.enterVoucherWithCodeDetails(driver, arrayNewStoreDetails_Seventeen, "Exclusive Rate", "COUPON CODE", "All", strStoreID);

			/**************************************************************** LOADING VALUE TO ARRAY ***************************************************************************/

			String strExecution_BooleanStatus = "Passed";

			
			String[] array_New_Network18_Store_Seventeen_Details = new String[] {arrayNewStoreDetails_Seventeen[0], "1",  
					"1",  "1",  "1", 
					"1",  "1",  "1",  
					"1", "1",  "1",  
					"1",  "1", strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Five("N18", array_New_Network18_Store_Seventeen_Details,"N18_Store_Seventeen");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("N18", "N18_Store_Seventeen");
			reportStep(logger, "Error message: "+e.getMessage()+"", "FAIL");
			reportStep(logger, "Store Creation has not been done properly", "FAIL");

		}

	}

	/*************************************************************************************************************************************************************************************/
	/** 										 Mob Rewards Store five - Creation and Loading the Corresponding Dynamic Values into Json File						   			     	**/
	/*************************************************************************************************************************************************************************************/

	@Test	
	public void mob_Rewards_Store_Five_Creation(Method method) throws InterruptedException, AWTException{

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

			String arrayNewStoreDetails_Five[] = objAddStore.enterRewardStoreDetails(driver, "Active", "Adda52", "", "https://www.myntra.com/", "https://www.myntra.com/", "", "Terms and conditions", "All", "999041");

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

			String[] array_New_Rewards_Store_Five_Details = new String[] {arrayNewStoreDetails_Five[0], arrayNewStore_Cal_PCBDetails_Five[6].toString(),  
					arrayNewStore_Cal_PCBDetails_Five[0].toString(),  arrayNewStore_Cal_PCBDetails_Five[5].toString(),  arrayNewStore_Cal_PCBDetails_Five[4].toString(), 
					arrayNewStore_Cal_SCBDetails_Five[2].toString(),  arrayNewStore_Cal_SCBDetails_Five[1].toString(),  arrayNewStore_Cal_SCBDetails_Five[3].toString(),  
					arrayNewStore_Cal_SCBDetails_Five[4].toString(), arrayNewStore_Cal_SCBDetails_Five_[2].toString(),  arrayNewStore_Cal_SCBDetails_Five_[1].toString(),  
					arrayNewStore_Cal_SCBDetails_Five_[3].toString(),  arrayNewStore_Cal_SCBDetails_Five_[4].toString(), strStoreID, strExecution_BooleanStatus};

			/**************************************************************** LOADING VALUE TO JSON ****************************************************************************/

			Boolean value = objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Store_Five("MOB_RW", array_New_Rewards_Store_Five_Details,"MOB_RW_Store_Five");

			basedOnBooleanValuePrintsReport(value);

			/*************************************************************** STORE CREATION COMPLETED **************************************************************************/

		}catch (Exception e) {

			e.printStackTrace();

			objStoreCCL.loading_Dynamic_TestData_Into_JsonFile_Failed("MOB_RW", "MOB_RW_Store_Five");
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