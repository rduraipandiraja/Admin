package com.admin.base;

import com.admin.utilities.Utils;

public class ConfigurationSetup {

	/************************************************ Variable Creation started ******************************************************/

	// Variable declaration
	public static String partner				= Utils.getConfigurationURLs(0, "partner");
	public static String environment			= Utils.getConfigurationURLs(0, "environment");

	public static String frontEndURL			= null;
	public static String AdminURL				= null;
	public static String PartnerName			= null;
	public static String dropdown				= null;
	public static String userName				= null;
	public static String password				= null;
	public static String fileName				= null;

	/************************************************ Methods Creation started *******************************************************/

	/* partnerConfigurationSetup */
	public static void partnerConfigurationSetup() {

		System.out.println("******* About to do ConfigurationSetup for "+partner+"_"+environment+"*******");
		
		frontEndURL 		= Utils.getConfigurationURLs(0, "frontend_url");
		System.out.println("frontEndURL: "+frontEndURL);
		
		AdminURL 			= Utils.getConfigurationURLs(0, "admin_url");
		System.out.println("AdminURL: "+AdminURL);
		
		PartnerName 		= Utils.getConfigurationURLs(0, "partner");
		System.out.println("PartnerName: "+PartnerName);
		
		dropdown 		= Utils.getConfigurationURLs(0, "dropdown");
		System.out.println("dropdown: "+dropdown);
		
		userName 		= Utils.getConfigurationURLs(0, "username");
		System.out.println("userName: "+userName);
		
		password 		= Utils.getConfigurationURLs(0, "password");
		System.out.println("password: "+password);
		
		fileName 		= Utils.getConfigurationURLs(0, "file_name");
		System.out.println("fileName: "+fileName);

		System.out.println("******* Successfully done ConfigurationSetup for "+partner+"_"+environment+"*******");

	}

}