package com.admin.base;

import java.util.Hashtable;
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.lang.reflect.Method;

import com.admin.pages.AdminCoreFunction;
import com.admin.pages.AffillateNetwork;
import com.admin.pages.Dashboard;
import com.admin.pages.Login;
import com.admin.pages.ProductBrowserEditMode;
import com.admin.pages.Stores;
import com.admin.pages.Vouchers;
import com.admin.utilities.Utils;
import com.admin.utilities.XMLReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	/********************************************* Variable Creation started ******************************************************/

	/* variable declaration */
	public String testName = null;
	public WebDriver driver = null;
	protected static ExtentReports report = null;
	protected ExtentTest logger = null;

	/********************************************* Variable Creation started *******************************************************/
	
	/* XMLReader declaration */
	public static final XMLReader objAdminTestdata		= new com.admin.utilities.XMLReader(System.getProperty("user.dir") + "/input/adminTestdata.xml");
	public static final List<Hashtable<String, String>> adminTestdata = null;
	
	/* XMLReader declaration */
	public static final XMLReader objconfigurationSetup = new com.admin.utilities.XMLReader(System.getProperty("user.dir") + "/input/configurationURLs.xml");
	public static final List<Hashtable<String, String>> configurationURLs = null;

	public static JSONObject objStore					= null;
	public static JSONObject objStoreValueCashback 		= null;
	public static JSONObject objStoreValueRewards 		= null;
	public static JSONObject objStoreValueNetwork18 	= null;
	
	public AdminCoreFunction objAdminCoreFunction			= null;
	public Login objLogin									= null; 
	public Dashboard objDashboard							= null;
	public Stores objAddStore								= null;
	public ProductBrowserEditMode objProductBrowserEditMode	= null;
	public Vouchers objVouchers								= null;
	public AffillateNetwork objAffillateNetwork				= null;
	public StoresCCL objStoreCCL							= null;
	public WrapperMethods objWrapperMethods					= null;

	/********************************************* Methods Creation started ********************************************************/
	
	/* partner configuration setup */
	@BeforeSuite
	public void beforeSuite() throws IOException, InterruptedException {

		objStore 					= new JSONObject();
		objStoreValueCashback 		= new JSONObject();
		objStoreValueRewards 		= new JSONObject();
		objStoreValueNetwork18 		= new JSONObject();
		objWrapperMethods			= new WrapperMethods();
		
		ConfigurationSetup.partnerConfigurationSetup();
		objWrapperMethods.entering_Root_Content_Json_File();

	}

	/* initialize reports */
	@BeforeTest(alwaysRun = true)
	public void beforeTest() throws Exception {
		try {

			Date objNewDateFolder = new Date();

			SimpleDateFormat dateFormat_Folder = new SimpleDateFormat("yyyy_MM_dd");
			File file = new File(System.getProperty("user.dir") + "/results/" + dateFormat_Folder.format(objNewDateFolder));
			boolean status = file.mkdir();

			if (status) {

				System.out.println("New directory is present");
			} else {
				
				System.out.println("New directory not present");

			}

			String strDatenow = dateFormat_Folder.format(objNewDateFolder);

			Date objNewTimeFile = new Date();
			SimpleDateFormat dateFormat_File = new SimpleDateFormat("yyyy_MM_dd @ HH_mm_SS");

			report = new ExtentReports(System.getProperty("user.dir") + "/results/" + strDatenow + "/" + dateFormat_File.format(objNewTimeFile) + ".html");
			report.loadConfig(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "extentreport.xml"));
			System.out.println("i am done");

		} catch (Exception e) {

			throw e;

		}
	}

	/* launch browser */
	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {

		String operatingSystem, browser;

		try {
			System.out.println("TestName: "+"test");
			testName = method.getName();
			logger = report.startTest(testName);
			System.out.println("TestName: "+testName);

			operatingSystem = System.getProperty("os.name");
			browser = "Chrome";

			if (operatingSystem.startsWith("Windows") && browser.equals("Chrome")) {

				System.out.println("operatingSystem: " + operatingSystem + " and browser: " + browser + " is present");

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars", "--no-sandbox");
				driver = new ChromeDriver(options);

			} else {

				System.out.println("operatingSystem: " + operatingSystem + " and browser: " + browser + " is not present");

			}

		} catch (Exception e) {
			
			System.out.println("Error message: "+e.getMessage());

			throw e;
			
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	/* quit browser */
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {

		String base64Screenshot = "";

		if (result.getStatus() == ITestResult.SUCCESS) {

			// Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			// Extentreports log and screenshot operations for failed tests.
			logger.log(LogStatus.PASS, "Testcase : Passed  ", logger.addBase64ScreenShot(base64Screenshot));

		} else if (result.getStatus() == ITestResult.FAILURE) {
			// Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			// Extentreports log and screenshot operations for failed tests.
			logger.log(LogStatus.FAIL, "Testcase : Failed , Please find the below screenshot ..! ", logger.addBase64ScreenShot(base64Screenshot));

		} else if (result.getStatus() == ITestResult.SKIP) {
			// Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			// Extentreports log and screenshot operations for failed tests.
			logger.log(LogStatus.FAIL, "Testcase : Failed , Please find the below screenshot ..! ", logger.addBase64ScreenShot(base64Screenshot));
		}

		driver.quit();
	}

	/* create reports */
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		report.flush();
	}

	/* Pushing created store & voucher data to JSON file */
	@AfterSuite
	public void afterSuite() throws IOException, InterruptedException, AWTException {

		objWrapperMethods.push_StoreValue_JSON();
		objWrapperMethods.store_Json_Dynamic_Test_Data_Transfer_With_POST_Request();

	}

	/* log report */
	public void reportStep(String desc, String status, boolean bSnap) {

		if (status.trim().equalsIgnoreCase("PASS")) {
			logger.log(LogStatus.PASS, desc);
		} else if (status.trim().equalsIgnoreCase("FAIL")) {
			logger.log(LogStatus.FAIL, desc);
			throw new RuntimeException();
		} else if (status.trim().equalsIgnoreCase("SKIP")) {
			logger.log(LogStatus.SKIP, desc);
		} else if (status.trim().equalsIgnoreCase("INFO")) {
			logger.log(LogStatus.INFO, desc);
		} else if (status.trim().equalsIgnoreCase("ERROR")) {
			logger.log(LogStatus.FAIL, desc);
		}
	}

	/* log report */
	public void reportStep(String desc, String status) {

		if (status.equalsIgnoreCase("FAIL")) {

			reportStep(desc, status, true);

		} else {
			reportStep(desc, status, false);
		}
	}

}