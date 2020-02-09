package com.admin.base;

import java.awt.AWTException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WrapperMethods extends Base {
	
//******************************** Wrapper Methods **************************************************//

	public void sleep(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean clickByID(WebDriver driver, String id) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
			driver.findElement(By.id(id)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean clickByXpath(WebDriver driver, String Xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
			driver.findElement(By.xpath(Xpath)).click(); //Appium
			//driver.findElement(By.xpath(Xpath)).click(); //selenium = Check this
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean enterTextByID(WebDriver driver, String id, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean enterTextByXpath(WebDriver driver, String Xpath, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
			driver.findElement(By.xpath(Xpath)).clear();
			driver.findElement(By.xpath(Xpath)).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean enterTextByXpath_UsingSetValue(WebDriver driver, String xpath, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean jsClickUsingID(WebDriver driver, String elementID) {

		try {

			System.out.println("About to verify the presence of the "+elementID);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementID)));

		}catch (Exception e) {

			System.out.println("Not able to verify the presence of the "+elementID);

		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('"+elementID+"').click();");
		return true;
	}

	public boolean enterTextInChrome(WebElement element, String value) {


		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}


	}
	
	public boolean selectValuesFromDropdown(WebElement element, String dropDownValue) {

		reportStep(logger, "About to select value "+dropDownValue+" from drop down", "INFO");

		try {

			System.out.println("In try block about to select the value from the dropdown");
			reportStep(logger, "In try block about to select the value from the dropdown", "INFO");
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
				
		} catch (Exception e) {

			System.out.println("In Catch - Waited for 30 sec to get loaded the page");
			reportStep(logger, "In Catch - Waited for 30 seconds to get loaded the page", "INFO");
		}
		
		Select select_Dropdown = new Select(element);			
		select_Dropdown.selectByVisibleText(dropDownValue);
		
		reportStep(logger, "Successfully selected value "+dropDownValue+" from dropdown", "PASS");
		
		return true;
	}

	public boolean clickAfterWait(WebDriver driver, WebElement ele) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();

		} catch (Exception e) {
			e.printStackTrace();
			reportStep( logger, e.getMessage(), "INFO");

			return false;
		}
		return true;

	}
	
	public boolean enterTextAfterClick(WebDriver driver, WebElement element, String value) {


		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			//element.click();
			element.sendKeys(value);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			reportStep( logger, e.getMessage(), "INFO");
			return false;
		}


	}

	public boolean jsClickUsingXpath(WebDriver driver, WebElement element) {

		try {

			System.out.println("About to verify the presence of the "+element+"");

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));

		}catch (Exception e) {

			e.printStackTrace();
			System.out.println("Not able to verify the presence of the "+element+"");

		}

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		return true;
	}
	
	public boolean isElementLocatedByXpathPresent(String xpath) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			reportStep(logger , "The Element Located By Xpath Is Present - xpath as : " +  xpath, "INFO");
			return true;

		}catch (Exception e) {
			String error = e.getMessage();
			System.out.println("Error "+ error);
			reportStep(logger, "TIME OUT EXCEPTION  : Failed  To Locate The Element Using Xpath Value as : " +  xpath, "INFO"); // Dont change the INFO status for Fail or Pass here
			return false;
		}

	}

	public boolean click(WebDriver driver, WebElement webElement) {
		
		try {
		
			webElement.click();

		} catch (Exception e) {
			e.printStackTrace();
			reportStep( logger, e.getMessage(), "INFO");

			return false;
		}
		return true;

	}

	public boolean waitTillElementPresence(WebDriver driver, WebElement ele) {
		
		try {
			reportStep(logger, "About to wait till the element appears ", "INFO");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public boolean validateTheElementPresence(WebDriver driver, WebElement element) {

		try {

			reportStep(logger, "Validating the element Presence :  " +  element, "INFO");

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));

			reportStep(logger, "The element "+element+"is present on the visible portion", "PASS");

		} catch (Exception e) {
			
			reportStep(logger, "Exception got is : " + e.getMessage(), "INFO");

			reportStep(logger, "The element "+element+"  is not present on the visible portion", "FAIL");

			return false;

		}

		return true;
	}	
	
	public String getText(WebDriver driver, WebElement ele) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele));
			reportStep(logger  , "Successfully got the text value for the element "+ ele + " as : "+ ele.getText().trim(), "PASS");
			return ele.getText().trim();

		}catch (Exception e) {

			reportStep(logger , "Not able to get the text for the element - "+ ele, "FAIL");
			reportStep( logger, e.getMessage(), "INFO");
			return null;
		}
	}

	public String getAttribute(WebDriver driver, WebElement ele) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele));
			reportStep(logger  , "Successfully got the text value for the element "+ ele + " as : "+ ele.getText().trim(), "PASS");
			return ele.getAttribute("value");

		}catch (Exception e) {

			reportStep(logger , "Not able to get the text for the element - "+ ele, "FAIL");
			reportStep( logger, e.getMessage(), "INFO");
			return null;
		}
	}
	
	public boolean enterTextUsingSendKeys(WebElement element, String value) {

		try {
	
			element.clear();
			element.sendKeys(value);
			
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			reportStep( logger, e.getMessage(), "INFO");
			return false;
		}

	}
	
	public boolean click_WaitFor80Sec(WebDriver driver, WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public  boolean select_Dropdown(WebDriver driver, String dropdownXpath,String dropdownValue) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 15);

			wait.until(ExpectedConditions.elementToBeSelected(By.xpath(dropdownXpath)));

			reportStep(logger , "Successfully waited till the drop down is visible : dropdown value is  "+ dropdownValue, "INFO");


		}catch (Exception e) {

			reportStep(logger , "Failed to find the dropdown element : the dropdown value is  - "+ dropdownValue, "INFO");
		}

		try {

			Select select_Dropdown = new Select(driver.findElement(By.xpath(dropdownXpath)));

			select_Dropdown.selectByVisibleText(dropdownValue);
			reportStep(logger, "Successfully selected the value : " +dropdownValue  +" from the drop down ", "INFO");
			
			return true;

		}catch (Exception e) {

			reportStep(logger, "Failed to  select the value : " +dropdownValue  +" from the drop down ", "FAIL");
			
			return false;
		}
	}
	
	public void reportStep(ExtentTest logger,String desc, String status)  {

		if(status.trim().equalsIgnoreCase("PASS")) {
			logger.log(LogStatus.PASS, desc);		
		}else if (status.trim().equalsIgnoreCase("FAIL")) {
			logger.log(LogStatus.FAIL, desc);	
			throw new RuntimeException();
		}else if (status.trim().equalsIgnoreCase("SKIP")) {
			logger.log(LogStatus.SKIP, desc);	
		}else if (status.trim().equalsIgnoreCase("INFO")) {
			logger.log(LogStatus.INFO, desc);	
		}							
	}

	public static String getConfigurationURLs(int index, String key) {

		return configurationURLs.get(index).get(key).trim();

	}
	
	public static String adminTestdata(int index, String key) {

		return adminTestdata.get(index).get(key).trim();

	}
	
	public boolean isElementLocatedByXpathPresent(WebDriver driver, String xPath) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
			return true;

		}catch (Exception e) {

			return false;
		}

	}
	
	public boolean isElementLocatedByXpathPresent_WaitRequiredSeconds(WebDriver driver, String xPath, int seconds) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));

			return true;

		}catch (Exception e) {

			return false;
		}

	}

	public boolean isElementLocatedByIDPresent(WebDriver driver, String id) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));

			return true;

		}catch (Exception e) {

			return false;
		}

	}

	public boolean isElementVisibleByIDPresent(WebDriver driver, String id) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

			return true;

		}catch (Exception e) {

			return false;
		}

	}

	public boolean isElementVisibleByXpathPresent(WebDriver driver, String xpath) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

			return true;

		}catch (Exception e) {

			return false;
		}

	}

	
	public boolean enterTextByXpath(WebDriver driver, String Xpath, int value) {

		String text = Integer.toString(value);
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
			driver.findElement(By.xpath(Xpath)).clear();
			driver.findElement(By.xpath(Xpath)).sendKeys(text);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean enterTextByID(WebDriver driver, String id, int value) {
		
		String text = Integer.toString(value);

		try {
			
			WebElement ele = returnWebElementHasID(driver, id);
			ele.clear();
			ele.sendKeys(text);

			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
	
	public boolean enterTextByIDAfterVisibility(WebDriver driver, String id, String text) {

		try {


			visiblityOfElementLocatedByIDPresent(driver, id);
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(text);

			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public String getTextByXpath(WebDriver driver, String xPath) {
		
		String text = "";

		try {

			isElementLocatedByXpathPresent(driver, xPath);
			text = driver.findElement(By.xpath(xPath)).getText();

			return text;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public String getTextByID(WebDriver driver, String id) {
		
		String text = "";

		try {

			isElementLocatedByIDPresent(driver, id);
			text = driver.findElement(By.id(id)).getText();

			return text;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public String getAttributeByXpath(WebDriver driver, String xPath) {
		
		String text = "";

		try {

			isElementLocatedByXpathPresent(driver, xPath);
			text = driver.findElement(By.xpath(xPath)).getAttribute("value");

			return text;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public String getAttributeByID(WebDriver driver, String id) {
		
		String text = "";

		try {


			isElementLocatedByIDPresent(driver, id);
			text = driver.findElement(By.id(id)).getAttribute("value");

			return text;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public WebElement returnWebElementHasXpath(WebDriver driver, String xPath) {

		if(isElementLocatedByXpathPresent(driver, xPath)) {

			return driver.findElement(By.xpath(xPath));

		}else {

			return null;
		}

	}

	public WebElement returnWebElementHasXpathAfterVisbility(WebDriver driver, String xPath) {

		if(visiblityOfElementLocatedByXpathPresent(driver, xPath)) {

			return driver.findElement(By.xpath(xPath));

		}else {

			return null;
		}

	}
	
	public WebElement returnWebElementHasID(WebDriver driver, String id) {

		if(isElementLocatedByIDPresent(driver, id)) {

			return driver.findElement(By.id(id));

		}else {

			return null;
		}

	}

	public boolean jsClickByXpath(WebDriver driver, String xPath) {

		try {


			WebElement element = returnWebElementHasXpath(driver, xPath);

			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);


		}catch (Exception e) {

			e.printStackTrace();

		}
		return true;
	}

	public boolean jsClickByXpathAfterVisbility(WebDriver driver, String xPath) {

		try {

			WebElement element = returnWebElementHasXpathAfterVisbility(driver, xPath);

			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);


		}catch (Exception e) {

			e.printStackTrace();

		}
		return true;
	}

	public boolean jsClickByID(WebDriver driver, String id) {

		try {

			isElementLocatedByIDPresent(driver, id);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById('"+id+"').click();");


		}catch (Exception e) {

			e.printStackTrace();

		}

		return true;
	}

	public boolean jsClickByXpath_AfterWaitRequireSeconds(WebDriver driver, String xPath, int seconds) {

		try {


			isElementLocatedByXpathPresent_WaitRequiredSeconds(driver, xPath, seconds);

			JavascriptExecutor executor = (JavascriptExecutor)driver;
			
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xPath)));


		}catch (Exception e) {

			e.printStackTrace();

		}
		return true;
	}

	public boolean visiblityOfElementLocatedByIDPresent(WebDriver driver, String id) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

			return true;

		}catch (Exception e) {

			return false;
		}

	}
	
	public boolean visiblityOfElementLocatedByXpathPresent(WebDriver driver, String xpath) {

		try {


			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

			return true;

		}catch (Exception e) {

			return false;
		}

	}

	public boolean selectValuesFromDropdown(WebDriver driver, String xPath, String dropDownValue) {

		try {

			Select dropdown = new Select(returnWebElementHasXpath(driver, xPath));			
			dropdown.selectByVisibleText(dropDownValue);

		} catch (Exception e) {
			
		}

		return true;
	}

	public boolean selectValuesFromDropdownUsingID(WebDriver driver, String id, String dropDownValue) {

		try {

			isElementLocatedByIDPresent(driver, id);

			Select dropdown = new Select(returnWebElementHasID(driver, id));			
			dropdown.selectByVisibleText(dropDownValue);


		} catch (Exception e) {

			return false;

		}

		return true;
	}

	public boolean jsSetValue(WebDriver driver, String id, String date) {

		try {

			isElementLocatedByIDPresent(driver, id);
			
			((JavascriptExecutor)driver).executeScript("document.getElementById('"+id+"').setAttribute('value', '"+date+"')");

		}catch (Exception e) {

			e.printStackTrace();

		}

		return true;
	}

	public void set_Expiry_Time(WebDriver driver, String str_Expiry_Time, String str_Hour, String str_Min){

		//isElementLocatedByXpathPresent(driver, str_Expiry_Time);
		driver.findElement(By.id(str_Expiry_Time)).click();

		isElementLocatedByXpathPresent(driver, "//input[@class='bootstrap-timepicker-hour']");
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour']")).click();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour']")).clear();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour']")).sendKeys(str_Hour);

		isElementLocatedByXpathPresent(driver, "//input[@class='bootstrap-timepicker-minute']");
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute']")).click();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute']")).clear();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute']")).sendKeys(str_Min);

		isElementLocatedByXpathPresent(driver, "//input[@class='bootstrap-timepicker-second']");
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-second']")).click();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-second']")).clear();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-second']")).sendKeys("30");

	}
	
	public void enteringText_To_TinyMCE(WebDriver driver, String strTextToEnter) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("tinyMCE.activeEditor.setContent('" + strTextToEnter + "')");

	}

	public boolean scrollUpToElement(WebDriver driver, String xPath) {
		try {

			isElementLocatedByXpathPresent(driver, xPath);
			driver.findElement(By.xpath(xPath)).sendKeys(Keys.PAGE_UP);

			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean scrollUpToElementUsingID(WebDriver driver, String id) {
		try {

			isElementLocatedByIDPresent(driver, id);
			driver.findElement(By.id(id)).sendKeys(Keys.PAGE_UP);

			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public void loadURL(WebDriver driver, String url) {

		reportStep(logger, "About to enter URL: "+url, "INFO");

		driver.get(url);

		reportStep(logger, "Sucessfully entered URL: "+url, "PASS");
	}

	public void maximizeWindow(WebDriver driver) {

		reportStep(logger, "About to maximize window", "INFO");

		driver.manage().window().maximize();			

		reportStep(logger, "Sucessfully maximized window", "PASS");
	}

	public void deleteCookiesAndRefresh(WebDriver driver) {

		reportStep(logger, "About to delete cookies and refresh", "INFO");

		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

		reportStep(logger, "Sucessfully deleted cookies and refreshed", "PASS");

	}

	public void writeStoreDataToFile(String strContent,String FileName ) throws IOException{

		System.out.println("About to write the root structure in the file ..!");
		FileWriter objFilewriter = new FileWriter(System.getProperty("user.dir") + adminTestdata(0, "directory_name") + FileName.trim(), true);
		objFilewriter.write(strContent);
		objFilewriter.close();
		System.out.println("Successfully written the root structure in the file ..!");

	}

	public void formateFile() throws IOException{
		
		FileWriter objFileWriter   = new FileWriter(System.getProperty("user.dir") + "/dynamic_json_test_data/Ck_Store_Creation_Json_Dynamic_Data.json", false); 
		PrintWriter objPrintWriter = new PrintWriter(objFileWriter, false);
		objPrintWriter.flush();
		objPrintWriter.close();
		objFileWriter.close();
	}

	public void selectValuesFromDropdownUsingValues(WebDriver driver, String select_Dropdown_Element, String strOption_Value) {
		
		isElementLocatedByXpathPresent(driver, select_Dropdown_Element);
		Select select_Dropdown = new Select(driver.findElement(By.xpath(select_Dropdown_Element)));
		select_Dropdown.selectByValue(strOption_Value);
	}

	public void entering_Root_Content_Json_File() throws IOException, InterruptedException{

		objStoreCCL = new StoresCCL(driver, logger);
		
		//reportStep(logger,"About to write Json Dynamic Values", "INFO");

		objStoreCCL.store_File_Creations(ConfigurationSetup.fileName);
		
		writeStoreDataToFile(adminTestdata(0, "fileRoot"), objStoreCCL.partnersJsonFileName());
		
		//reportStep(logger,"Sucessfully entered root Json File value", "PASS");

		
	}

	public void push_StoreValue_JSON() throws InterruptedException, AWTException, IOException{

		objStoreCCL = new StoresCCL(driver, logger);

		/****************************************************************** Pushing Loaded Value To Json ***************************************************************************/
		
		objStoreCCL.pushing_Loaded_Dynamic_TestData_Into_JsonFile();
		
		/*********************************************************************** Loaded Json Value *********************************************************************************/


	}

	public void store_Json_Dynamic_Test_Data_Transfer_With_POST_Request() throws InterruptedException, AWTException, IOException{

		objStoreCCL = new StoresCCL(driver, logger);
		
		//reportStep(logger,"Stores Json Dynamic test data Transfer to Server Via POST Request..!", "INFO");

		objStoreCCL.post_Request_Stores_Dynamic_TestData();

		//reportStep(logger, "Sucessfully posted Stores Json Dynamic test data to Server Via POST Request..", "PASS");


	}
	
	public void basedOnBooleanValuePrintsReport(Boolean value){

		if (value == true) {
			reportStep(logger,"Successfully Created the Store", "PASS");

		} else {
			reportStep(logger,"Not Created the Store", "FAIL");

		}
	}

}