package com.admin.utilities;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import com.admin.base.WrapperMethods;


public class Utils extends WrapperMethods {
	
	
	public static void createNewFolderForEveryNewDay() {

		// Set HTML reporting file location
		Date objNewDateFolder = new Date();
		SimpleDateFormat dateFormat_Folder = new SimpleDateFormat("yyyy_MM_dd");
		File file = new File(
				System.getProperty("user.dir") + "/results/" + dateFormat_Folder.format(objNewDateFolder));
		boolean value = file.mkdir();
		
		if(value) {
			System.out.println("New file has been created for the report");
		}

	}
	
	public  static String today_dd_MMM_YYYY() {

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMM-YYYY");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("IST"));
		Calendar objCalender  		= Calendar.getInstance();
		Date currentDate			= objCalender.getTime();
		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate);
		System.out.println(strNumber_Days_To_BackDated_Exit_Clicks);
		
		return strNumber_Days_To_BackDated_Exit_Clicks.trim(); 

	}
	
	public  static String today_dd_MMM_YYYY_ISTZone() {

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMM-YYYY");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("IST"));
		Calendar objCalender  		= Calendar.getInstance();
		Date currentDate			= objCalender.getTime();
		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate);
		System.out.println(strNumber_Days_To_BackDated_Exit_Clicks);
		
		return strNumber_Days_To_BackDated_Exit_Clicks.trim(); 

	}

	public  static String today_dd_MMMM_YYYY_ISTZone() {

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMMM-YYYY");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("IST"));
		Calendar objCalender  		= Calendar.getInstance();
		Date currentDate			= objCalender.getTime();
		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate);
		System.out.println(strNumber_Days_To_BackDated_Exit_Clicks);
		
		return strNumber_Days_To_BackDated_Exit_Clicks.trim(); 

	}

	public  static String today_dd_MMMM_YYYY() {

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMMM-YYYY");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));
		Calendar objCalender  		= Calendar.getInstance();
		Date currentDate			= objCalender.getTime();
		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate);
		System.out.println(strNumber_Days_To_BackDated_Exit_Clicks);
		
		return strNumber_Days_To_BackDated_Exit_Clicks.trim(); 

	}
	
	public  static String today_dd_MMMM_YYYY_IST() {

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMMM-YYYY");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("IST"));
		Calendar objCalender  		= Calendar.getInstance();
		Date currentDate			= objCalender.getTime();
		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate);
		System.out.println(strNumber_Days_To_BackDated_Exit_Clicks);
		
		return strNumber_Days_To_BackDated_Exit_Clicks.trim(); 

	}
	
	public  static String customBackDate_dd_MMMM_YYYY(int numberOfDaysToBeBackDated) {

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMMM-YYYY");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("IST"));

		Calendar objCalender  = Calendar.getInstance();

		objCalender.add(Calendar.DATE, - numberOfDaysToBeBackDated);
		Date currentDate = objCalender.getTime();

		String backDatedDate  = dateFormatGmt.format(currentDate);

		System.out.println(backDatedDate);
		
		return backDatedDate;

	}
	
	public  static String customBackDate_dd_MM_YYYY(int numberOfDaysToBeBackDated) {

		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MM-YYYY");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("IST"));

		Calendar objCalender  = Calendar.getInstance();

		objCalender.add(Calendar.DATE, - numberOfDaysToBeBackDated);
		Date currentDate = objCalender.getTime();

		String backDatedDate  = dateFormatGmt.format(currentDate);

		System.out.println(backDatedDate);
		
		return backDatedDate;

	}
	
	public static String datestamp() {

		//Created Current date :
		Date objCurrentDate = new Date();
		SimpleDateFormat objDateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.MM.SSSS");
		String strDatenow = objDateFormat.format(objCurrentDate);
//		System.out.println(strDatenow);
		Random objRandNum = new Random();
		
		return strDatenow;

	}
	
	public static String datestamp(String storeType) {

		// // created Current date
		Date objCurrentDate = new Date();
		SimpleDateFormat objDateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.MM.SSSS");
		String strDatenow = objDateFormat.format(objCurrentDate);
		
		Random objRandNum = new Random();
		int intRandNumber = objRandNum.nextInt(50) + 1;

		String strCurrentDate = strDatenow + intRandNumber;
		
		String storeName = storeType + strCurrentDate;
		
		return storeName;

	}
	
	public static String generateEmailWithTimeStamp() {

		
		Random objRandNum = new Random();
		int intRandNumber = objRandNum.nextInt(999);

		String strCurrentDate = Utils.datestamp() + intRandNumber;
		
		String email = strCurrentDate +"@appiumtest.com";
		return email;

	}
	
	public static String generateRandomNumber(int lengthOfTheRequiredNumber) {
		
		lengthOfTheRequiredNumber = lengthOfTheRequiredNumber-1;

		Random random = new Random();
		String randomNum = "";

		String numbers = "6789";
		
		StringBuffer buffer = new StringBuffer();
		
		char[] c =null;

			c = new char[1];
			for (int i = 0; i < 1; i++) {
				c[i] = numbers.charAt(random.nextInt(numbers.length()));
				
				buffer.append(c[i]);
				
				 randomNum = buffer.toString();
			}

		String characters = "0123456789";
		String randomNumber = "";
		StringBuffer buffer2 = new StringBuffer();
		char[] text = new char[lengthOfTheRequiredNumber];
		for (int i = 0; i < lengthOfTheRequiredNumber; i++) {
			text[i] = characters.charAt(random.nextInt(characters.length()));
			buffer2.append(text[i]);
			randomNumber = buffer2.toString();

		}
		
		return randomNum+randomNumber;

	}

	
	public static String currentDate_DD_MMM_YYYY() {

		Calendar objCalender		= Calendar.getInstance();
		Date currentDate 			= objCalender.getTime();
		SimpleDateFormat objDateFormating = new SimpleDateFormat("dd-MMM-yyyy");
		String strCurrentDate 		= objDateFormating.format(currentDate);

		System.out.println(strCurrentDate);

		return strCurrentDate;


	}

	public static String extractOnlyDigitFromString(String str){

		String digits= str.replaceAll("[^0-9]", "");

		System.out.println("String : "+ str +" digits from the string as : "+ digits);
		return digits;

	}

	public static String setOneDayBeforeCurrentDate() {

		//Set oneday_BeforeDateValue 
		Calendar objCalender		= Calendar.getInstance();
		objCalender.add(Calendar.DATE, -1);

		Date currentDate 			= objCalender.getTime();

		DateFormat objDateFormating = new SimpleDateFormat("yyyy-MM-dd"); 
		objDateFormating.setTimeZone(TimeZone.getTimeZone("UTC"));

		String setBefore1dayDate 		= objDateFormating.format(currentDate);

		return setBefore1dayDate;

	}

	public static String setFourDaysAfterCurrentDate() {

		//Set fourdays_AfterDateValue 
		SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));

		Calendar objCalender		= Calendar.getInstance();
		objCalender.add(Calendar.DATE, +4);

		Date currentDate 			= objCalender.getTime();

		String setAfter4daysDate 	= dateFormatUTC.format(currentDate);

		return setAfter4daysDate;

	}

	public static String setCurrentDate() {

		Calendar objCalender		= Calendar.getInstance();
		objCalender.add(Calendar.DATE, 0);

		Date currentDate 			= objCalender.getTime();

		DateFormat objDateFormating = new SimpleDateFormat("yyyy-MM-dd"); 
		objDateFormating.setTimeZone(TimeZone.getTimeZone("UTC"));

		String currentdaysDates 		= objDateFormating.format(currentDate);

		return currentdaysDates;

	}

	public static int showRandomInteger(int aStart, int aEnd, Random aRandom){
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		//get the range, casting to long to avoid overflow problems
		long range = (long)aEnd - (long)aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long)(range * aRandom.nextDouble());
		int randomNumber =  (int)(fraction + aStart); 
		return randomNumber;
	}

	public static int randomNumbers_for_2digits() {

		Random random = new Random();
		int int2Digits_RandomNumber = showRandomInteger(15,99,random);
		return int2Digits_RandomNumber;
	}

	public static String strNumber_Days_To_BackDated_Exit_Clicks(int numberOfDaysToBackDate) {
		
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("YYYY-MM-dd");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));

		Calendar objCalender  = Calendar.getInstance();
		
		objCalender.add(Calendar.DATE, - numberOfDaysToBackDate);
		Date currentDate = objCalender.getTime();

		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate);
		
		//System.out.println(strNumber_Days_To_BackDated_Exit_Clicks);
		
		return strNumber_Days_To_BackDated_Exit_Clicks;
		
	}
	
	public static String generic_AheadDate_dd_MMM_yyyy(int intAheadDays) {

		Calendar objCalender		= Calendar.getInstance();
		objCalender.add(Calendar.DATE, +intAheadDays);
		Date currentDate 			= objCalender.getTime();
		DateFormat objDateFormating = new SimpleDateFormat("dd-MMM-yyyy");
		objDateFormating.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strCurrentDate 		= objDateFormating.format(currentDate);

		return strCurrentDate;
	}

	public static String currentMonthYear() {
		
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };

		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];
		int yr = cal.getInstance().get(cal.YEAR);
		String year = Integer.toString(yr);
		
		String monthYear = month +" "+ year;

		return monthYear;


	}
	
	public static String previousMonthCurrentYear(int index) {
		
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };
		
		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH) - index];
		int yr = cal.getInstance().get(cal.YEAR);
		String year = Integer.toString(yr);
		
		String monthYear = month +" "+ year;

		return monthYear;


	}

	public static int getTheNumberOfCharPresenceInString(String setOfcharacters,String requiredChar) {
		
		int counter = 0;
		
		String str = setOfcharacters;
		
		for(int i = 0; i<str.length();i++) {
			
			
			if(String.valueOf(str.charAt(i)).contains(requiredChar)) {
				
				counter ++;
			}
			
		}
		
		System.out.println(counter); 
		return counter;

		}

	
	public static String previousDate() {
		
		Calendar objCalender		= Calendar.getInstance();
		objCalender.add(Calendar.DATE, -1);
		
		Date currentDate 			= objCalender.getTime();
		
		DateFormat objDateFormating = new SimpleDateFormat("yyyy-MM-dd"); 
		objDateFormating.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		String currentdaysDates 		= objDateFormating.format(currentDate);
		
		return currentdaysDates;
	}

	public static String currentDateAfter4days() {
		
		SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Calendar objCalender		= Calendar.getInstance();
		objCalender.add(Calendar.DATE, +4);
		
		Date currentDate 			= objCalender.getTime();
		
		String strAfter4daysDate 		= dateFormatUTC.format(currentDate);
		
		return strAfter4daysDate;
	}

	
	
	
}
