package com.admin.base;

import static io.restassured.RestAssured.given;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ServiceLoader;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.utils.Writer;

import groovyjarjarasm.asm.commons.Method;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;

public class StoresCCL extends WrapperMethods {
	
	/****************************************************** This is default constructor which initializes driver and will create all web element ************************/

	public StoresCCL(WebDriver driver, ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
		
	public String partnersJsonFileName() {

		//reportStep(logger, "About to store json data to file: "+ConfigurationSetup.fileName, "INFO");

		String jsonPath = ConfigurationSetup.fileName;

		//reportStep(logger, "JsonPath: "+jsonPath, "PASS");

		return jsonPath;
	}

	//*************************************************************************************************************************************************************************************//
	//** 											    	  		Loading values to JSON file	From admin Store Creation 				   			     							 	 **//
	//*************************************************************************************************************************************************************************************//

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_One(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){


		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue 	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				// Loading values into Json object from array
				// Store_One - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_One - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[73]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[74]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_One - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_One - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_One - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_One - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_One - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 1 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 1 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "MissingCashbackTime",arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "ConfirmationDate",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "OrderID",arrStore_Dynamic_Values[66]);
				objStoreValue.put(strStoreNode_Name + "_" + "TrackingSpeed",arrStore_Dynamic_Values[67]);
				objStoreValue.put(strStoreNode_Name + "_" + "ButtonText",arrStore_Dynamic_Values[68]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSearch",arrStore_Dynamic_Values[69]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSitemap",arrStore_Dynamic_Values[70]);
				objStoreValue.put(strStoreNode_Name + "_" + "ShowOrderID",arrStore_Dynamic_Values[71]);
				objStoreValue.put(strStoreNode_Name + "_" + "AcceptMissingTicket",arrStore_Dynamic_Values[72]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Two(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue 	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Two - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Two - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[73]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[74]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Two - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Two - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[11]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[10]);

				// Store_Two - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Two - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Two - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 1 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 1 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "MissingCashbackTime",arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "ConfirmationDate",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "OrderID",arrStore_Dynamic_Values[66]);
				objStoreValue.put(strStoreNode_Name + "_" + "TrackingSpeed",arrStore_Dynamic_Values[67]);
				objStoreValue.put(strStoreNode_Name + "_" + "ButtonText",arrStore_Dynamic_Values[68]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSearch",arrStore_Dynamic_Values[69]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSitemap",arrStore_Dynamic_Values[70]);
				objStoreValue.put(strStoreNode_Name + "_" + "ShowOrderID",arrStore_Dynamic_Values[71]);
				objStoreValue.put(strStoreNode_Name + "_" + "AcceptMissingTicket",arrStore_Dynamic_Values[72]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Three(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue 	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Three - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition", arrStore_Dynamic_Values[2]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value", arrStore_Dynamic_Values[4]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value", arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details", arrStore_Dynamic_Values[9]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Value", arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Type",arrStore_Dynamic_Values[11]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Details", arrStore_Dynamic_Values[12]);
				objStoreValue.put(strStoreNode_Name + "_" + "MissingCashbackTime",arrStore_Dynamic_Values[13]);
				objStoreValue.put(strStoreNode_Name + "_" + "ConfirmationDate",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "OrderID",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "TrackingSpeed",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "ButtonText",arrStore_Dynamic_Values[17]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSearch",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSitemap",arrStore_Dynamic_Values[19]);
				objStoreValue.put(strStoreNode_Name + "_" + "ShowOrderID",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "AcceptMissingTicket",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Four(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue 	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Four - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[1]);

				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				case "MOB_CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "MOB_RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "MOB_N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				case "TAB_CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "TAB_RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "TAB_N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				case "MOB_CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "MOB_RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "MOB_N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				case "TAB_CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "TAB_RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "TAB_N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Five(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue 	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Five - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type", arrStore_Dynamic_Values[2]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details", arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Offer_Type", arrStore_Dynamic_Values[4]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details", arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Offer_Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Value", arrStore_Dynamic_Values[9]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Type", arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Details",arrStore_Dynamic_Values[11]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Offer_Type", arrStore_Dynamic_Values[12]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[13]);

				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				case "MOB_CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "MOB_RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "MOB_N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				case "TAB_CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "TAB_RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "TAB_N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				case "MOB_CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "MOB_RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "MOB_N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				case "TAB_CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "TAB_RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "TAB_N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}
				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Six(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Six - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type", arrStore_Dynamic_Values[2]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details", arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Offer_Type", arrStore_Dynamic_Values[4]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details", arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Offer_Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 5]);


				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 4]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 2]);

				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Seven(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Seven - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type", arrStore_Dynamic_Values[2]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details", arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Offer_Type", arrStore_Dynamic_Values[4]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details", arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Offer_Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 5]);


				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 4]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 2]);

				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Eight(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Eight - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Eight - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[73]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[74]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Eight - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Eight - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Eight - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Eight - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Eight - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 8 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 8 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "MissingCashbackTime",arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "ConfirmationDate",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "OrderID",arrStore_Dynamic_Values[66]);
				objStoreValue.put(strStoreNode_Name + "_" + "TrackingSpeed",arrStore_Dynamic_Values[67]);
				objStoreValue.put(strStoreNode_Name + "_" + "ButtonText",arrStore_Dynamic_Values[68]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSearch",arrStore_Dynamic_Values[69]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSitemap",arrStore_Dynamic_Values[70]);
				objStoreValue.put(strStoreNode_Name + "_" + "ShowOrderID",arrStore_Dynamic_Values[71]);
				objStoreValue.put(strStoreNode_Name + "_" + "AcceptMissingTicket",arrStore_Dynamic_Values[72]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Nine(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Nine - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Nine - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[79]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[80]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Nine - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Nine - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[11]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Expiry_Date",arrStore_Dynamic_Values[65]);

				// Store_Nine - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Expiry_Date",arrStore_Dynamic_Values[64]);

				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Type", arrStore_Dynamic_Values[66].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Details", arrStore_Dynamic_Values[67]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Value",arrStore_Dynamic_Values[68]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Expiry_Date",arrStore_Dynamic_Values[69]);

				// Store_Nine - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Nine - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 9 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 9 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "MissingCashbackTime",arrStore_Dynamic_Values[70]);
				objStoreValue.put(strStoreNode_Name + "_" + "ConfirmationDate",arrStore_Dynamic_Values[71]);
				objStoreValue.put(strStoreNode_Name + "_" + "OrderID",arrStore_Dynamic_Values[72]);
				objStoreValue.put(strStoreNode_Name + "_" + "TrackingSpeed",arrStore_Dynamic_Values[73]);
				objStoreValue.put(strStoreNode_Name + "_" + "ButtonText",arrStore_Dynamic_Values[74]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSearch",arrStore_Dynamic_Values[75]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSitemap",arrStore_Dynamic_Values[76]);
				objStoreValue.put(strStoreNode_Name + "_" + "ShowOrderID",arrStore_Dynamic_Values[77]);
				objStoreValue.put(strStoreNode_Name + "_" + "AcceptMissingTicket",arrStore_Dynamic_Values[78]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Ten(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Ten - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition", arrStore_Dynamic_Values[2]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "MissingCashbackTime",arrStore_Dynamic_Values[4]);
				objStoreValue.put(strStoreNode_Name + "_" + "ConfirmationDate",arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "OrderID",arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TrackingSpeed",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "ButtonText",arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSearch",arrStore_Dynamic_Values[9]);
				objStoreValue.put(strStoreNode_Name + "_" + "IncludeInSitemap",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "ShowOrderID",arrStore_Dynamic_Values[11]);
				objStoreValue.put(strStoreNode_Name + "_" + "AcceptMissingTicket",arrStore_Dynamic_Values[12]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name", arrStore_Dynamic_Values[13]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Three_Name", arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Eleven(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Eleven - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[66]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[3]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name", arrStore_Dynamic_Values[4]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[5]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Store_Name", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name", arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE", arrStore_Dynamic_Values[9]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Three_Store_Name", arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Three_Name",arrStore_Dynamic_Values[11]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Three_Desc", arrStore_Dynamic_Values[12]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Four_Store_Name", arrStore_Dynamic_Values[13]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Four_Name", arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Four_Desc", arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Four_CODE", arrStore_Dynamic_Values[16]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Five_Store_Name",arrStore_Dynamic_Values[17]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Five_Name", arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Five_Desc", arrStore_Dynamic_Values[19]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Six_Store_Name", arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Six_Name", arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Six_Desc", arrStore_Dynamic_Values[22]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Six_CODE",arrStore_Dynamic_Values[23]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Seven_Store_Name", arrStore_Dynamic_Values[24]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Seven_Name", arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Seven_Desc", arrStore_Dynamic_Values[26]);

				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value", arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type", arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Offer_Type", arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value", arrStore_Dynamic_Values[31]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type", arrStore_Dynamic_Values[32]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details", arrStore_Dynamic_Values[33]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Offer_Type", arrStore_Dynamic_Values[34]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Value",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Type", arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Details", arrStore_Dynamic_Values[37]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Offer_Type", arrStore_Dynamic_Values[38]);

				objStoreValue.put(strStoreNode_Name + "_" + "Store_content", arrStore_Dynamic_Values[39]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Offer_Type", arrStore_Dynamic_Values[40]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Offer_Type", arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Three_Offer_Type", arrStore_Dynamic_Values[42]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Four_Offer_Type", arrStore_Dynamic_Values[43]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Five_Offer_Type", arrStore_Dynamic_Values[44]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Six_Offer_Type",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Seven_Offer_Type", arrStore_Dynamic_Values[46]);

				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[47]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition", arrStore_Dynamic_Values[48]);

				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_For_App", arrStore_Dynamic_Values[67]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_For_App", arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_For_App", arrStore_Dynamic_Values[51]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_For_App",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_For_App", arrStore_Dynamic_Values[53]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Three_Desc_For_App", arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Four_Desc_For_App", arrStore_Dynamic_Values[55]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Five_Desc_For_App", arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Six_Desc_For_App", arrStore_Dynamic_Values[57]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Seven_Desc_For_App", arrStore_Dynamic_Values[58]);

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_App_Title",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_App_Title", arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Three_App_Title", arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Four_App_Title", arrStore_Dynamic_Values[62]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Five_App_Title", arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Six_App_Title", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Seven_App_Title", arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Twelve(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Twelve - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Twelve - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[67]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[68]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Twelve - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Twelve - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Twelve - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Twelve - Multiple Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Type",arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Value",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Details",arrStore_Dynamic_Values[66]);

				// Store_Twelve - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Twelve - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 2 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 2 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Thirteen(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Thirteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Thirteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Thirteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Thirteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Thirteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Thirteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Thirteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 13 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 13 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Fourteen(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Fourteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Fourteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Fourteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Fourteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Fourteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Fourteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Fourteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 14 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 14 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Fifteen(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Fifteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Fifteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[66]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[67]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Fifteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Fifteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Fifteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Fifteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Fifteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 15 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 15 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				// Store_Twelve - Multiple Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Type",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 4]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Value",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Details",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 2]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Sixteen(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Twelve - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Twelve - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[67]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[68]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Twelve - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Twelve - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Twelve - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Twelve - Multiple Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Type",arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Value",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Multiple_Secondary_Cashback_Details",arrStore_Dynamic_Values[66]);

				// Store_Twelve - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Twelve - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 2 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 2 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Seventeen(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Thirteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Thirteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Thirteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Thirteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Thirteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Thirteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Thirteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 13 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 13 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Eighteen(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Fourteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Fourteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Fourteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Fourteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Fourteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Fourteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Fourteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 14 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 14 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Nineteen(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Fifteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Fifteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Fifteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Fifteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Fifteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Fifteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Fifteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 15 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 15 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_Twenty(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Twelve - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Twelve - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Twelve - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Twelve - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Twelve - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Twelve - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Twelve - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 2 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 2 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_TwentyOne(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Thirteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Thirteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Thirteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Thirteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Thirteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Thirteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Thirteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 13 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 13 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_TwentyTwo(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Fourteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Fourteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Fourteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Fourteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Fourteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Fourteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Fourteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 14 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 14 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public boolean loading_Dynamic_TestData_Into_JsonFile_Store_TwentyThree(String strPrefix, String[] arrStore_Dynamic_Values, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser 		= new JSONParser();
				JSONObject objStoreValue 	= new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				//reportStep(logger, "Started loading the Data in Json Array", "INFO");

				// Loading values into Json object from array
				// Store_Fifteen - Core details
				objStoreValue.put(strStoreNode_Name + "_" + "Name", arrStore_Dynamic_Values[0]);
				objStoreValue.put(strStoreNode_Name + "_" + "URLKey", arrStore_Dynamic_Values[1]);
				objStoreValue.put(strStoreNode_Name + "_" + "ID", arrStore_Dynamic_Values[26]);
				objStoreValue.put(strStoreNode_Name + "_" + "Type", arrStore_Dynamic_Values[8]);
				objStoreValue.put(strStoreNode_Name + "_" + "Status", arrStore_Dynamic_Values[2]);

				// Store_Fifteen - Basic details
				objStoreValue.put(strStoreNode_Name + "_" + "Affiliate_Network",arrStore_Dynamic_Values[3]);
				objStoreValue.put(strStoreNode_Name + "_" + "Affilliate_Network_Id",arrStore_Dynamic_Values[41]);
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc", arrStore_Dynamic_Values[64]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc", arrStore_Dynamic_Values[5]);
				objStoreValue.put(strStoreNode_Name + "_" + "linkURL", arrStore_Dynamic_Values[6]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition",arrStore_Dynamic_Values[7]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition",arrStore_Dynamic_Values[50]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_Boolean", "true");
				objStoreValue.put(strStoreNode_Name + "_" + "image_url","https://asset1.iamsavings.co.uk/resources/image/stores/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Short_Desc_App",arrStore_Dynamic_Values[65]);
				objStoreValue.put(strStoreNode_Name + "_" + "Full_Desc_App",arrStore_Dynamic_Values[59]);
				objStoreValue.put(strStoreNode_Name + "_" + "TermsCondition_App",arrStore_Dynamic_Values[60]);
				objStoreValue.put(strStoreNode_Name + "_" + "Final_Terms_condition_App",arrStore_Dynamic_Values[61]);
				objStoreValue.put(strStoreNode_Name + "_" + "Social_message",arrStore_Dynamic_Values[49]);

				// Store_Fifteen - Meta details
				objStoreValue.put(strStoreNode_Name + "_" + "Store_content",arrStore_Dynamic_Values[45]);
				objStoreValue.put(strStoreNode_Name + "_" + "Keywords", arrStore_Dynamic_Values[46]);
				objStoreValue.put(strStoreNode_Name + "_" + "SEO_Tags", arrStore_Dynamic_Values[47]);

				// Store_Fifteen - Normal Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Type",arrStore_Dynamic_Values[9].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Details",arrStore_Dynamic_Values[10]);
				objStoreValue.put(strStoreNode_Name + "_" + "Primary_Cashback_Value",arrStore_Dynamic_Values[11]);

				// Store_Fifteen - Secondary Primary Cash back with Percentage details
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Id",arrStore_Dynamic_Values[52]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Type",arrStore_Dynamic_Values[12].substring(0, 7).toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Details",arrStore_Dynamic_Values[14]);
				objStoreValue.put(strStoreNode_Name + "_" + "Secondary_Cashback_Value",arrStore_Dynamic_Values[13]);

				// Store_Fifteen - Voucher
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Count",arrStore_Dynamic_Values[29]);
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_With_Code_Count", "1");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Newuser_Boolean_Value", "true");

				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Count_App", "3");
				objStoreValue.put(strStoreNode_Name + "_" + "Vouchers_Category_Unique_Count", "2");

				// Store_Fifteen - Other
				objStoreValue.put(strStoreNode_Name + "_" + "ExitClick_Count",arrStore_Dynamic_Values[30]);
				objStoreValue.put(strStoreNode_Name + "_" + "Offer_Type", "Cashback + Coupons");

				// Store 15 -> Voucher -1
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Name",arrStore_Dynamic_Values[15]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc",arrStore_Dynamic_Values[16]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Type",arrStore_Dynamic_Values[43].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Details",arrStore_Dynamic_Values[18]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_OfferType",StringUtils.substringBeforeLast(arrStore_Dynamic_Values[19], "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_CODE", "");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ID",arrStore_Dynamic_Values[28]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExitClick_Count",arrStore_Dynamic_Values[36]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_IssueDateTime",arrStore_Dynamic_Values[54]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ExpiryDateTime",arrStore_Dynamic_Values[55]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_ImageURL","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Vouchers_Exclusive_Text","Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_One_Desc_APP",arrStore_Dynamic_Values[62]);

				// Store 15 -> Voucher -2
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Name",arrStore_Dynamic_Values[20]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc",arrStore_Dynamic_Values[21]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Type",arrStore_Dynamic_Values[44].toLowerCase());
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Details",arrStore_Dynamic_Values[23]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_OfferType",StringUtils.substringBeforeLast((arrStore_Dynamic_Values[24]), "Rate").trim());

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_CODE",arrStore_Dynamic_Values[25]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ID",arrStore_Dynamic_Values[27]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExitClick_Count",arrStore_Dynamic_Values[35]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_IssueDateTime",arrStore_Dynamic_Values[56]);
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ExpiryDateTime",arrStore_Dynamic_Values[57]);

				objStoreValue.put(strStoreNode_Name + "_" + "One_MenuCategoryValue ", "Popular Today");
				objStoreValue.put(strStoreNode_Name + "_" + "1stCategoryValue","PPS ATM CASHBACK CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "2ndCategoryValue","PPS ATM REWARDS CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "3rdCategoryValue","PPS ATM NETWORK 18 CATEGORY");
				objStoreValue.put(strStoreNode_Name + "_" + "Overall_CategoryValue ", "3");

				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_ImageURL ","https://asset1.iamsavings.co.uk/resources/image/vouchers/no-image.jpg");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Vouchers_Exclusive_Text",	"Expires in 4 days");
				objStoreValue.put(strStoreNode_Name + "_" + "Voucher_Two_Desc_APP",arrStore_Dynamic_Values[63]);
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status",arrStore_Dynamic_Values[arrStore_Dynamic_Values.length - 1]);

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				return false;
			}
		}

		return true;

	}

	public void loading_Dynamic_TestData_Into_JsonFile_Failed(String strPrefix, String strStoreNode_Name){

		File objFile = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName());

		if (!objFile.exists()) {

			System.out.println("Required Dynamic Json Text File is not Existing So Not Able to load the Data ...");
			//reportStep(logger, "Required Dynamic Json Text File is not Existing So Not Able to load the Data ...", "INFO");

		} else {

			try {

				JSONParser objParser = new JSONParser();
				JSONObject objStoreValue = new JSONObject();
				objStoreValue	= (JSONObject) objParser.parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()),"UTF-8"));

				// Loading values into Json object
				JSONObject objLoading_Jsonobject = new JSONObject();

				// Loading values into Json object from array
				// Store Execution Status
				objStoreValue.put(strStoreNode_Name + "_" + "Boolean_Execution_Status","Failed");

				switch (strPrefix) {
				case "CB":

					objStoreValueCashback.put(strStoreNode_Name, objStoreValue);
					break;
				case "RW":

					objStoreValueRewards.put(strStoreNode_Name, objStoreValue);
					break;
				case "N18":

					objStoreValueNetwork18.put(strStoreNode_Name, objStoreValue);
					break;
				}

				switch (strPrefix) {
				case "CB":

					objStore.put("CB_Store", objStoreValueCashback);
					break;
				case "RW":

					objStore.put("RW_Store", objStoreValueRewards);
					break;
				case "N18":

					objStore.put("N18_Store", objStoreValueNetwork18);
					break;
				}

				//reportStep(logger, "Loaded Json Data", "PASS");

			} catch (Exception e) {

				e.printStackTrace();

				// reportStep(logger, "Failed to load Json Data" + e.getMessage(), "FAIL");
			}
		}


	}
	
	public String post_Request_Stores_Dynamic_TestData() throws IOException {

		String strJson_Dynamic_data = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + adminTestdata(0, "directory_name")+partnersJsonFileName()))); 

		Response jsonFile_Post_response = given().formParam("mode", "atm_store_json").formParam("partner", ConfigurationSetup.PartnerName).formParam("json_data", strJson_Dynamic_data.trim()).when().post(ConfigurationSetup.frontEndURL+"/getcode.php");

		System.out.println("response"+jsonFile_Post_response.asString().trim());
		
		return jsonFile_Post_response.asString().trim();
	}

	public String get_Request_Stores_Dynamic_TestData(String strFile_Name_To_GET, String strPost_Env_URL , String strGet_Mid_URL , String strGet_Mid_1_URL  , String strGet_End_URL , String strURL_End 
			, String strPartner_Name , String str_Static_Mode) throws IOException {

		Response jsonFile_Get_response = given().when().get(strPost_Env_URL.trim()+strURL_End.trim()+strGet_Mid_URL.trim()+str_Static_Mode.trim()+"&" + strGet_Mid_1_URL.trim()+strPartner_Name.trim() + "&" +
				strGet_End_URL.trim()+strFile_Name_To_GET).then().extract().response();

		return jsonFile_Get_response.asString().trim();

	} 

	public void store_File_Creations(String strFile_Name) throws IOException, InterruptedException {

		File directory = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name").trim());

		if (! directory.exists()){

			// Creating Required Directory 
			directory.mkdir();
			System.out.println("directory : /dynamic_json_test_data/ - not Existed , so successfully created it" );
			//reportStep(logger,  "directory : /dynamic_json_test_data/ - not Existed , so successfully created it", "INFO");

		}		

		//Creating Required Json file 
		try {

			File file = new File(System.getProperty("user.dir") + adminTestdata(0, "directory_name").trim() + strFile_Name.trim());

			if (file.exists()) {

				FileWriter objFileWriter   = new FileWriter(System.getProperty("user.dir") + adminTestdata(0, "directory_name").trim()+ strFile_Name.trim(), false); 
				PrintWriter objPrintWriter = new PrintWriter(objFileWriter, false);
				objPrintWriter.flush();
				objPrintWriter.close();
				objFileWriter.close();       
				System.out.println("Json file Existed , successfully file Cleaned & named as  : " + strFile_Name.trim());
				//reportStep(logger,  "Json file Existed , successfully file Cleaned & named as  : " + strFile_Name.trim(), "PASS");

			} else if(! file.exists()) {

				file.createNewFile();
				System.out.println("Json file not Existed , successfully file created as  : " + strFile_Name.trim());
				//reportStep(logger,  "Json file not Existed , successfully file created as  : " + strFile_Name.trim(), "PASS");

			} else { 

				System.out.println ("Alert : Not able to Create the Json file for unknown reason , aborting the further suite executions..!");
				//reportStep(logger,  ("Alert : Not able to Create the Json file for unknown reason , aborting the further suite executions..!"), "PASS");
				System.exit(-1);

			}

		} catch(IOException ioe) {
			ioe.printStackTrace();
			System.exit(-1);
		}

	} 

	public void pushing_Loaded_Dynamic_TestData_Into_JsonFile() throws IOException{

		OutputStreamWriter objFileWriter = new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir")+ adminTestdata(0, "directory_name")+partnersJsonFileName()), "UTF-8");

		try {
			objFileWriter.write(objStore.toJSONString());
			//reportStep(logger, "Loaded Data in Json Array successfully", "PASS");
		} catch (IOException e) {
			e.printStackTrace();
			//reportStep(logger, "Failed to load the Json Data", "FAIL");
		}

		objFileWriter.flush();
		objFileWriter.close();

	}	

}