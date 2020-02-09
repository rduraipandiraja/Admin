package com.admin.testsuites.devarea;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.admin.base.ConfigurationSetup;
import com.admin.base.StoresCCL;
import com.admin.base.WrapperMethods;
import com.admin.pages.AdminCoreFunction;
import com.admin.pages.AffillateNetwork;
import com.admin.pages.BonusApprovalConfiguration;
import com.admin.pages.CashbackApprovalConfiguration;
import com.admin.pages.Dashboard;
import com.admin.pages.Login;
import com.admin.pages.ProductBrowserEditMode;
import com.admin.pages.Stores;
import com.admin.pages.Vouchers;

public class MyDevArea extends WrapperMethods {

	@Test	
	public void cashback_Store_One_Creation(Method method) throws InterruptedException, AWTException{


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
			BonusApprovalConfiguration objBonusApprovalConfiguration = new BonusApprovalConfiguration(driver, logger);
			CashbackApprovalConfiguration objCashbackApprovalConfiguration = new CashbackApprovalConfiguration(driver, logger);
			
			/*********************************************************************** LOGIN PAGE*********************************************************************************/

			objLogin.navigateAdminLoginPage(driver);

			objLogin.enterAdminLoginCredentials(driver);

			/********************************************************************* ALL STORE PAGE ******************************************************************************/

			objDashboard.clickMainMenuCashback(driver);
			
			objBonusApprovalConfiguration.clickBonusApprovalConfigurationSubMenu(driver);
			
			objBonusApprovalConfiguration.enterMinimumAmount("1000");
			
			objBonusApprovalConfiguration.clickSubmit(driver);

	}

	
}