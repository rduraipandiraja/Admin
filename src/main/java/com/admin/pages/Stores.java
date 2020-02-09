package com.admin.pages;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
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

public class Stores extends WrapperMethods {
	
	/************************************************** this is default constructor which initializes driver and will create all web element  ***************************/

	public Stores(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	private static Random objRandNum = new Random();
	
	/*************************************************************************** Declarations  **************************************************************************/
	
	private ThreadLocal ThreadLocal_CurrentDate  	= new ThreadLocal();
	
	public String strCurrentDate,threadLocalValue_CurrentDate,strNewCBStore_Name,strNewN18Store_Name ,strNewRWStore_Name,strNewstore_URLKey,strnewStore_FullDescription,strnewStore_LinkUrl, 
	strNewStore_StoreType,strNewStore_AffiliateNetwork,strnewStore_DeepLink,strnewStore_UTMParameter,strnewStore_TC_IntermediatePage,strnewStore_ImageURl,strNewStore_StoreStatus,
	strNewStore_CBType,strNewStore_Currency,strnewStore_Cb_Details,strNewStore_CBType_SCB,strNewStore_CBOfferType ;
	
	public int intRandNumber,strnewStore_CB_Percentage,strnewStore_NTW_Commission,strnewStore_Cb_Value ,intSCB_Cal_CB_Value_Commission;
	
	public String normalShortDescription, normalAppShortDescription, calendarShortDescription, calendarAppShortDescription;
	

	/***************************************************************** Page Object Creation started *********************************************************************/
	
	// Common
	private String button_Add_Store								="btn_Submit";
	private String submenu_Stores								="SubMenu_Stores";
	private String button_AddNewStores							="anc_AddNew";
	private String message_Successfully_NewStore_Created		="adminMessageSuccess";

	// Add New Store Main Tabs
	private String tab_Stores									="tab_Store";
	private String tab_Category									="tab_Category";
	private String tab_SEO										="tab_SEO";
	private String tab_PrimaryCB								="tab_PrimaryCashback";
	private String tab_SecondaryCB								="tab_SecondaryCashback";
	private String tab_CashbackRules							="tab_CashbackRules";
	private String tab_Others									="tab_Others";
	private String tab_StoreContent								="tab_StoreContent";
	
	//store tab
	private String input_Name									="name";
	private String select_Status								="status";
	private String select_Affiliate_Network						="networkid";
	private String textaretab_Full_Description					="full_desc";
	private String textaretab_App_Full_Description				="app_full_desc";
	private String input_Deep_Link								="deep_link";
	private String input_T_C_at_Intermediate_page				="finalTc";
	private String input_App_T_C_at_Intermediate_page			="finalTcApp";
	private String input_URL_Key								="url_key";
	private String input_Image_URL								="imageurl";
	private String input_Link_URL								="linkurl";
	private String label_UTM_Parameter							="utmParm";
	private String select_Store_Type							="store_type";
	private String input_StoreName								="sstring";
	private String btn_Search									="btn_Submit";
	private String icon_Edit									="//a[@class='fa fa-edit']";
	private String checkbox_Desktop								="device_type_desktop";
	private String checkbox_Mobile								="device_type_mobile";
	private String checkbox_Tablet								="device_type_tablet";
	private String checkbox_App									="device_type_app";
	private String checkbox_PickOfWeek							="//label[contains(.,'Hot Weeekly Offer')]";
	private String checkbox_PickOfDay							="//label[contains(.,'Pick of the Day')]";
	private String button_Update								="//button[contains(.,'Update')]";
	
	// Category 
	private String checkBox_tree								="//a[@class='jstree-anchor']";
	
	//SEO tab
	private String textarea_Keywords							="keywords";
	private String textarea_Meta_Tags							="meta_tags";
	private String textarea_Product_Meta_Tags					="product_meta_tags";
	private String textarea_Social_Media_Message				="social_media_message";
	
	//primary cashback tab
	private String select_Cashback_Type							="cashback_type";
	private String input_Cashback_Network_Commission			="network_commission";	
	private String input_Calendar_Cashback_Network_Commission	="calendar_network_commission";
	private String input_Calendar_Cashback_Cashback_Percentage	="calendar_cashback_percentage";
	private String input_Calendar_Cashback_Value				="calendar_cashback";	
	private String textaretab_Calendar_Cashback_Details			="calendar_short_desc";
	private String input_Cashback								="cashback";
	private String textaretab_Cashback_Details					="cashback_details";
	private String select_Cashback_Offer_Type					="cashback_offer_type";
	private String input_Cashback_Percentage					="cashback_percentage";
	
	//secondary cashback
	private String select_Calendar_cashback_percentage			="csh_type0";
	private String button_Add_another_row						="//a[@class='btn blue']|//a[@class='btn m-btn--air btn-primary m-btn m-btn--custom']";
	
	//cashback rules tab
	private String tab_CBR_Primary_Cashback						="//a[@href='#tab_2_1']";
		
	//below xpath are common for all the elements available in primary and calendar cashback tab
	private String input_Mobile_Normal_Cashback					="//input[@id='mobile_cashback']";
	private String input_Mobile_Calender_Cashback				="//input[@id='calendar_mobile_cashback']";	
	private String input_App_Calender_Cashback					="//input[@id='calendar_app_cashback']";
	private String input_App_Normal_Cashback					="//input[@id='calendar_app_cashback']";	
	private String select_Normal_Cashback_Rules_Type			="//select[@id='cashback_rules_type']";
	private String select_Calender_Cashback_Rules_Type			="//select[@id='calendar_cashback_rules_type']";	
	private String input_DSK_Normal_Min_Transaction_Amount		="//input[@id='desktop_minimum_transaction_amount']";
	private String input_DSK_Normal_Max_Cap_Value				="//input[@id='desktop_maximum_cap_value']";
	private String input_DSK_Calender_Min_Transaction_Amount	="//input[@id='calendar_desktop_minimum_transaction_amount']";
	private String input_DSK_Calender_Max_Cap_Value				="//input[@id='calendar_desktop_maximum_cap_value']";	
	private String input_MOB_Normal_Min_Transaction_Amount		="//input[@id='mobile_minimum_transaction_amount']";
	private String input_MOB_Normal_Max_Cap_Value				="//input[@id='mobile_maximum_cap_value']";
	private String input_MOB_Calender_Min_Transaction_Amount	="//input[@id='calendar_mobile_minimum_transaction_amount']";
	private String input_MOB_Calender_Max_Cap_Value				="//input[@id='calendar_mobile_maximum_cap_value']";	
	private String input_APP_Calender_Minimum_Trans_Amount		="//input[@id='calendar_desktop_minimum_transaction_amount']";
	private String input_APP_Calender_Maximum_Cap_Value			="//input[@id='calendar_app_maximum_cap_value']";
	private String input_APP_Normal_Min_Trans_Amount			="//input[@id='app_minimum_transaction_amount']";
	private String input_APP_Normal_Max_Cap_Value				="//input[@id='app_maximum_cap_value']";

	// GC  - Grid Commission 
	private String button_PCB_Add_NewRow_GC_DSK					="//a[@id='Primary-Grid-Based-Desktop-AddRow']";
	private String button_PCB_Add_NewRow_GC_MOB					="//a[@id='Primary-Grid-Based-Mobile-AddRow']";
	private String button_PCB_Add_NewRow_GC_APP					="//a[@id='Primary-Grid-Based-App-AddRow']";
		
	//others tab
	private String textarea_What_You_Should_Know				="cashback_tc";
	private String textarea_App_What_You_Should_Know			="app_cashback_tc";
	private String textarea_Manage_Contacts						="manage_cnt";
	private String textarea_Admin_Notes							="admin_notes";
	private String list_Of_Stores								="gview_all_list";
	private String str_Timer									="Timer";
	private String str_Expiry_Time_Pcb							="calendar_expirytime";
	private String str_Expiry_Time_Scb							="calendar_expirytime_Cashback_0";	
	private String text_StoreContent							="//label[text()='Store Content ']";
	private String text_Editstore								="//h3[text()='Edit Store']";
	private String text_ID										="//td[@aria-describedby='all_list_storeid']";
	private String textArea_ExitClick							="exitclicks";
	private String categoryPopularToday							="//a[@id='storeCat_popular-today_anchor']/parent::li/i";

	private String categoryOne									="storeCat_pps-atm-cashback-category_anchor";
	private String categoryTwo									="storeCat_pps-atm-rewards-category_anchor";
	private String categoryThree								="storeCat_pps-atm-network-18-category_anchor";
	
	/************************************************** New Variable Creation started ****************************************************************/
	
	private String shortDescription_TextField					="short_desc";
	private String appShortDescription_TextField				="app_short_desc";
	private String calendarShortDescription_TextField			="calendar_web_short_desc";
	private String calendarAppShortDescription_TextField		="calendar_app_short_desc";		
	private String missingCashbackTime_TextField				="missing_cashback_time";		
	private String cashbackExpectedConfirmationDays_TextField	="expected_confirmation_days";		
	private String trackingSpeed_TextField						="tracking_speed";		
	private String orderIDFormat_TextField						="orderid_format";	
	private String buttonText_TextField							="button_text";
	private String issueDate									="calendar_issuedate";
	private String issueTime									="calendar_issuetime";
	private String expiryDate									="calendar_expirydate";
	private String expiryTime									="calendar_expirytime";	
	private String includeInSearch_CheckBox						="include_in_search";		
	private String includeInSitemap_CheckBox					="include_in_sitemap";		
	private String showorderID_CheckBox							="show_orderid_in_earnings";		
	private String acceptMissingTicket_CheckBox					="accepts_missing_ticket";	
	private String clear_Button									="btn_Clear";	
	
	private String button_View									="mceu_22-open";
	private String button_SourceCode							="mceu_41-text";
	private String text_SourceCode								="mceu_50";
	private String button_Ok									="mceu_52-button";
	
	private String sourceCode									="<script type=\"text/javascript\">  $(document).ready(function(){$('.str_uml_slide').slick({dots:!1,infinite:!0,slidesToShow:5,slidesToScroll:5,responsive:[{breakpoint:9999,settings:'unslick'},{breakpoint:1024,settings:{slidesToShow:3,slidesToScroll:3,arrows:!1,swipe:!0}},{breakpoint:599,settings:{slidesToShow:2,slidesToScroll:1,arrows:!1,swipe:!0}}]}),$('.popular_str_slide, .top_cat_str_slide').slick({dots:!1,infinite:!0,slidesToShow:5,slidesToScroll:5,responsive:[{breakpoint:1024,settings:{slidesToShow:3,slidesToScroll:3,arrows:!1,swipe:!0}},{breakpoint:599,settings:{slidesToShow:2,slidesToScroll:1,arrows:!1,swipe:!0}}]}),$('.str_rct_blogs_slide, .top_sel_str_prts_slide').slick({dots:!1,slidesToShow:4,slidesToScroll:4,responsive:[{breakpoint:1024,settings:{slidesToShow:3,slidesToScroll:3,arrows:!1,swipe:!0}},{breakpoint:599,settings:{slidesToShow:2,slidesToScroll:1,arrows:!1,swipe:!0}}]})});</script>\r\n" + 
			"<style type=\"text/css\">  .seo_str_info .divider_inner{width:100%!important}.seo_str_info .rm_pad{padding:0!important}.seo_str_info .hd_2{font-size:20px;font-weight:700;margin-bottom:20px;margin-top:15px}.seo_str_info p{font-size:16px;line-height:22px;margin-bottom:15px;color:#333}.seo_str_info a{font-weight:700;color:#f07431;font-size:16px;line-height:22px}.seo_str_info ol li,.seo_str_info ul li{font-size:16px;line-height:32px;color:#333}.seo_str_info .hd_3{font-size:16px;font-weight:700;line-height:22px;margin-bottom:3px;margin-top:0}.seo_str_info .slick-prev{left:-10px}.seo_str_info .slick-next{right:-10px}.seo_str_info .slick-next,.seo_str_info .slick-prev{top:calc(50% - 17px)}@media (max-width:1024px){.seo_str_info .divider{width:100%;padding:0 15px}}@media (max-width:768px){.seo_str_info .slick-list{overflow:visible;width:100%;height:100%}.seo_str_info .slick-slider{padding:0 15px}.seo_str_info .slick-list:after{content:' ';clear:both;display:block}.seo_str_info .divider{padding:0;overflow:hidden}}@media (max-width:599px){.seo_str_info .hd_2{font-size:15px;margin-bottom:10px;margin-top:5px}.seo_str_info p{font-size:13px;line-height:18px;margin-bottom:10px}.seo_str_info a{font-size:12px;line-height:16px}.seo_str_info ol li,.seo_str_info ul li{font-size:13px;line-height:24px}.seo_str_info .hd_3{font-size:13px;line-height:18px}}.str_uml_slide{padding-bottom:0}.str_uml_slide .slick-list{margin:0 -10px}.seo_str_info .str_uml_slide .slick-next,.seo_str_info .str_uml_slide .slick-prev{top:38px}.str_uml_slide .str_uml_slide_dd{padding:10px;outline:0}.str_uml_slide .str_uml_slide_dd_img{background:#fff;padding:11px 20px;height:90px;overflow:hidden}.str_uml_slide .str_uml_slide_dd img{max-width:136px;max-height:68px;display:block;margin:0 auto;width:100%}.str_uml_slide .str_uml_slide_dd a{height:65px;padding-top:10px;text-align:center;display:flex;justify-content:center;line-height:18px;max-width:176px}.str_rct_blogs_slide{padding-bottom:0}.str_rct_blogs_slide .slick-list{margin:0 -10px}.seo_str_info .str_rct_blogs_slide .slick-next,.seo_str_info .str_rct_blogs_slide .slick-prev{top:108px}.str_rct_blogs .str_rct_blogs_slide_dt{padding:10px}.str_rct_blogs .str_rct_blogs_slide_dt img{max-width:230px;max-height:230px;display:block;margin:0 auto;width:100%}.str_rct_blogs .str_rct_blogs_slide_dt a{padding-top:20px;display:block;font-weight:400}.seo_str_desc .hd_2{padding-bottom:15px}.seo_str_desc .table_responsives{margin-bottom:30px}.seo_str_desc table{border-collapse:collapse;border-spacing:unset;width:100%;margin-bottom:30px}.seo_str_desc table tr td,.seo_str_desc table tr th{height:55px;font-size:16px;line-height:22px;color:#333;border:1px solid #dfdfdf;padding:15px;text-align:left;vertical-align:middle;width:33.33%}.seo_str_desc table tr th{background:#f6f6f6}.seo_str_hitlts ul{list-style:disc;padding-left:20px;padding-bottom:20px}.seo_str_hitlts ol{list-style-position:inside;padding-bottom:20px}.popular_str_slide{padding-bottom:0}.popular_str_slide .slick-list{margin:0 -10px}.seo_str_info .popular_str_slide .slick-next,.seo_str_info .popular_str_slide .slick-prev{top:38px}.popular_str_slide .popular_str_slide_dt{padding:10px}.popular_str_slide .popular_str_slide_dt_img{background:#fff;padding:11px 20px;height:90px;overflow:hidden}.popular_str_slide .popular_str_slide_dt img{max-width:136px;max-height:68px;display:block;margin:0 auto;width:100%}.popular_str_slide .popular_str_slide_dt a{height:65px;padding-top:10px;text-align:center;display:flex;justify-content:center;line-height:18px}.top_cat_str_slide{padding-bottom:0}.top_cat_str_slide .slick-list{margin:0 -10px}.top_cat_str_slide_dt a{display:flex;justify-content:center;align-items:center;height:91px;background:#fff;color:#333;padding:12px;text-align:center}.top_cat_str_slide .top_cat_str_slide_dt{padding:10px}.top_sel_str_prts_slide{padding-bottom:0}.top_sel_str_prts_slide .slick-list{margin:0 -10px}.seo_str_info .top_sel_str_prts_slide .slick-next,.seo_str_info .top_sel_str_prts_slide .slick-prev{top:108px}.top_sel_str_prts_slide .top_sel_str_prts_slide_dt{padding:10px}.top_sel_str_prts_slide .top_sel_str_prts_slide_dt img{max-width:230px;max-height:230px;display:block;margin:0 auto;width:100%}.top_sel_str_prts_slide .top_sel_str_prts_slide_dt a{padding-top:20px;display:block;font-weight:400}.str_faq_dtls_list_left{width:50%;padding-right:25px}.str_faq_dtls_list_right{width:50%;padding-left:25px}.str_faq_dtls_list_data{border-top:1px solid #333;padding-bottom:5px;padding-top:20px}.str_faq_dtls_list .str_faq_dtls_list_data:first-child{border-top:none}@media (max-width:768px){.popular_str .hd_2,.str_faq_dtls .hd_2,.str_rct_blogs .hd_2,.str_u_may_like .hd_2,.top_cat_str .hd_2,.top_sel_str_prts .hd_2{padding:0 10px}.seo_str_desc,.seo_str_hitlts{padding:0 10px}.str_uml_slide .str_uml_slide_dd a{height:auto;max-width:none}.popular_str_slide .popular_str_slide_dt a{height:auto}.str_faq_dtls_list .str_faq_dtls_list_left,.str_faq_dtls_list .str_faq_dtls_list_right{width:100%;padding:0}.str_faq_dtls_list{padding-left:10px;padding-right:10px}.str_faq_dtls_list .str_faq_dtls_list_data:first-child{border-top:1px solid #333}}@media (max-width:599px){.str_uml_slide .str_uml_slide_dd{padding:5px}.str_uml_slide .str_uml_slide_dd_img{height:auto}.str_rct_blogs .str_rct_blogs_slide_dt a{padding-top:10px}.popular_str_slide .popular_str_slide_dt{padding:5px}.popular_str_slide .popular_str_slide_dt_img{height:auto}.top_cat_str_slide .top_cat_str_slide_dt{padding:5px}.top_cat_str_slide .top_cat_str_slide_dt_img{height:auto}.top_sel_str_prts_slide .top_sel_str_prts_slide_dt{padding:5px}.top_sel_str_prts_slide .top_sel_str_prts_slide_dt_img{height:auto}.top_cat_str_slide_dt a{height:70px;padding:8px}.str_rct_blogs .str_rct_blogs_slide_dt{padding:5px}.seo_str_desc table tr td,.seo_str_desc table tr th{font-size:13px;line-height:18px;padding:10px;height:50px}.str_faq_dtls_list .str_faq_dtls_list_left,.str_faq_dtls_list .str_faq_dtls_list_right{width:100%;padding:0}.str_faq_dtls_list{padding-top:10px}.user-view {font-style: italic;color: #757575;font-size: 13px;margin-bottom: 10px;display: block;}.str_faq_dtls_list_data{padding-top:15px;padding-bottom:0}}</style>\r\n" + 
			"<div class=\"fl fw seo_str_info\">\r\n" + 
			"<div class=\"pt pb grey_divider fl fw\">\r\n" + 
			"<div class=\"divider\">\r\n" + 
			"<section class=\"fl fw str_u_may_like\">\r\n" + 
			"<h2 class=\"fl fw hd_2\">You May Also Like</h2>\r\n" + 
			"<div class=\"str_uml_slide fl fw\">\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/10kya-coupons.png\" alt=\"10kya\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/10kya-coupons?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">10Kya Coupons</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/alibaba-coupons.png\" alt=\"alibaba wholesale\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/alibaba-coupons?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Alibaba Wholesale Coupons</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/amazon-business-1551867305.jpg\" alt=\"amazon business\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/amazon-business?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Amazon Business Coupon</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/amazon-great-indian-festival-sale.png\" alt=\"amazon great indian sale\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/amazon-great-indian-festival-sale?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Amazon Great Indian Sale Coupon</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/banggood-coupons-1562581663.png\" alt=\"banggood\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/banggood-coupons?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Banggood Coupon</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/big-bazaar-offers.png\" alt=\"big bazaar\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/big-bazaar-offers?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Big Bazaar Coupon</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/discount-kitna-milega-offers.png\" alt=\"discount kitna milega\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/discount-kitna-milega-offers?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Discount Kitna Milega Coupons</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/homeshop18-coupons.png\" alt=\"homeshop18\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/homeshop18-coupons?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Homeshop18 Coupon</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/infibeam.png\" alt=\"infibeam\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/infibeam?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Infibeam Coupon</a></div>\r\n" + 
			"<div class=\"str_uml_slide_dd fl\">\r\n" + 
			"<div class=\"str_uml_slide_dd_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/star-cj.png\" alt=\"shop cj\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/star-cj?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Shop Cj Coupons Today</a></div>\r\n" + 
			"</div>\r\n" + 
			"</section>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<section class=\"fl fw pt pb white_divider\">\r\n" + 
			"<div class=\"divider\">\r\n" + 
			"<div class=\"seo_str_hitlts fl fw\"><img class=\"seo-img\" src=\"/resources/image/staticpage_images/AmazonPromo-CodeCoupon3.jpg\" alt=\"Amazon Coupon Code India\" title=\"How to Save on Amazon India\" style=\"display: block; margin-left: auto; margin-right: auto;\" />\r\n" + 
			"<h2 class=\"hd_2\">Why Should You Shop On Amazon Via CashKaro?</h2>\r\n" + 
			"<p>Amazon is the largest e-commerce platform in the world which now operates in 17+ countries around the world. It sells products from a wide assortment of categories like Mobiles, Fashion, Electronics, Health, Home Furnishings and more. Stocked with over 6 crore products to meet your shopping fantasy and provide you the best deals, the famous Aur Dikhao ad of Amazon grabbed incredible attention among shoppers in India. From the Great Indian Festival Sale to monthly Amazon sales, the e-commerce giant has never stopped making its users happy.</p>\r\n" + 
			"<p>CashKaro is a one-stop destination for lightning Amazon deals and discounts. If you are looking to save money every time you shop, then we are sure you are on the right page. Find awesome Amazon Coupon Codes, Amazon Pay Back Balance Offers, Amazon Pay offers, Bank offers and a lot more. We present you an assortment of the most amazing Amazon Offers and Amazon coupons that are bound to make your shopping super economical. Well, that is not it! On top of these awesome Amazon offers, CashKaro provides you CashKaro rewards up to 5.5% which can later be transferred to your bank account. So, what are you waiting for? Save while you shop now!</p>\r\n" + 
			"<h2 class=\"hd_2\"><strong>How To Earn CashKaro Rewards Using Amazon Promotional Codes India 2019?</strong></h2>\r\n" + 
			"<ul>\r\n" + 
			"<li>Sign in to CashKaro.com</li>\r\n" + 
			"<li>Type Amazon India in the search bar</li>\r\n" + 
			"<li>Browse through Amazon promo codes &amp; offers on the store page</li>\r\n" + 
			"<li>Click the orange button and copy a Amazon India promo code if applicable</li>\r\n" + 
			"<li>Click on Visit Retailer tab</li>\r\n" + 
			"<li>Shop normally at the retailer site and do not forget to paste Amazon india promo coupon code</li>\r\n" + 
			"<li>Cashback will be tracked into your CashKaro Account within 72 Hours</li>\r\n" + 
			"</ul>\r\n" + 
			"<h2 class=\"hd_2\">Amazon Promotional Codes Across Categories</h2>\r\n" + 
			"<p>If you are looking for some exclusive Amazon coupons across various categories, then we are sure you are on the right page. Find awesome Amazon discount codes for shopping that helps you save big every time. Also, if you wish to make a payment via credit card, you can also use Amazon voucher code for bank/debit/ credit card payments. Check out some of the most awesome Amazon offers across categories:</p>\r\n" + 
			"<h3 class=\"hd_3\">Amazon Coupons for Mobiles and Tablets</h3>\r\n" + 
			"<p>Amazon is the largest online store for mobiles &amp; tablets. You can find all top selling mobile brands in India on Amazon including One Plus, Samsung, Xiaomi, Coolpad, Sony, LG, Lenovo, Micromax, Apple, Motorola Mobiles and others. You can use Amazon Promo Code for New Users via CashKaro.com to avail the best mobile deals online.</p>\r\n" + 
			"<h3 class=\"hd_3\">Amazon Offers on Electronics</h3>\r\n" + 
			"<p>Find laptops, televisions, cameras, refrigerators, washing machines, small appliances, and more on Amazon. You can also find the best electronics brands like BPL, Kenstar, and Volta on Amazon sale. Use Amazon India offers to purchase electronics at super economical prices.</p>\r\n" + 
			"<h3 class=\"hd_3\">Clothing Sale on Amazon India</h3>\r\n" + 
			"<p>Explore a fabulous collection of your favourite brand and apparels. Step out in style and make your Amazon India shopping experience the best one. Grab our Amazon India promotional code today on all fashion apparels.</p>\r\n" + 
			"<h3 class=\"hd_3\">Books Offer Codes on Amazon</h3>\r\n" + 
			"<p>You can find all genre books on Amazon at super discounted prices. From Indian writing books, to classic literature and fiction, you can find</p>\r\n" + 
			"<h3 class=\"hd_3\">Amazon Offers On Watches</h3>\r\n" + 
			"<p>Check out the extensive range of watches for men, women and kids. From premium brands of watches to the most economical ones, you can find all types and brands of watches on Amazon. So, grab your favourite Amazon deal on watches now.</p>\r\n" + 
			"<h3 class=\"hd_3\">Amazon Coupons For Bags</h3>\r\n" + 
			"<p>Buy bags and luggage for travel and daily usage from the Amazon accessories store. During the Great Indian Sale, you can find the best Amazon offers on bags for men, women and kids.</p>\r\n" + 
			"<h2 class=\"hd_2\">Amazon Great Indian Festival Sale 2019 - Now Budget Won't Hold Back (Up To 90% Off)</h2>\r\n" + 
			"<p>With Diwali around the corner comes the thrill of the amazing Amazon Great Indian Sale. Every year, the e-commerce giant hosts an Amazon Diwali Sale aka. Great Indian Sale 2019. The Amazon Great Indian Sale is soon going to be back with a bang on the official website of Amazon India. With numerous deals and amazing discounts available across categories, this Amazon Great Indian Sale will take place around 1st October'19 &ndash; 4th October'19.</p>\r\n" + 
			"<p>Amazon Great Indian Sale Dates:&nbsp;1st October &ndash; 4th October 2019</p>\r\n" + 
			"<div class=\"seo_str_desc fl fw\">\r\n" + 
			"<h3 class=\"hd_3\">Amazon Great Indian Sale - Up to 90% Off Across Categories</h3>\r\n" + 
			"<div class=\"table_responsives\">\r\n" + 
			"<p>The Amazon Great Indian Sale will bring in new Amazon offers for all. Unlike before, this Amazon Great Indian Festival Sale is expected to offer up to 80% discount across different categories.</p>\r\n" + 
			"<table>\r\n" + 
			"<thead>\r\n" + 
			"<tr>\r\n" + 
			"<th>Amazon Great Indian Sale Categories</th>\r\n" + 
			"<th>Amazon Great Indian Sale Discounts</th>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>Electronics</td>\r\n" + 
			"<td>Upto 50% Off + Exchange Offers</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>Mobiles</td>\r\n" + 
			"<td>Up to 40% off + Exchange Offer + No Cost EMI</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>Fashion</td>\r\n" + 
			"<td>Upto 80% off on branded products</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>TV &amp; Appliances</td>\r\n" + 
			"<td>Upto 60% off + No Cost EMI</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>Home and Kitchen</td>\r\n" + 
			"<td>30-75% off</td>\r\n" + 
			"</tr>\r\n" + 
			"</thead>\r\n" + 
			"</table>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<div class=\"seo_str_desc fl fw\">\r\n" + 
			"<h3 class=\"hd_3\">Amazon Great Indian Sale Deals - Up to 40% Off On Mobiles &amp; Electronics</h3>\r\n" + 
			"<p>Shop for smartphones, large appliances, electronics, clothing and many more at the lowest prices only at the Amazon Great Indian Sale. Shop from Amazon Great Indian Sale Offers and avail amazing deals at this Amazon Sale Discount Sale.<br /><br /></p>\r\n" + 
			"<div class=\"table_responsives\">\r\n" + 
			"<table>\r\n" + 
			"<thead>\r\n" + 
			"<tr>\r\n" + 
			"<th>Amazon Great Indian Sale Offers</th>\r\n" + 
			"<th>Amazon Great Indian Sale Discounts</th>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>OnePlus</td>\r\n" + 
			"<td>Up to Rs.5000 off + Exchange Offers + No Cost EMI</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>Samsung Mobiles</td>\r\n" + 
			"<td>Up to Rs.6700 off + Exchange Offers + No Cost EMI</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>PC Accessories</td>\r\n" + 
			"<td>Up to 60% off</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>Storage Devices</td>\r\n" + 
			"<td>Up to 20% off</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>Sony</td>\r\n" + 
			"<td>Up to 25% off</td>\r\n" + 
			"</tr>\r\n" + 
			"<tr>\r\n" + 
			"<td>Panasonic</td>\r\n" + 
			"<td>Up to 25% off</td>\r\n" + 
			"</tr>\r\n" + 
			"</thead>\r\n" + 
			"</table>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<h3 class=\"hd_3\"><strong>What Else Do You Get on the Amazon Great Indian Sale?</strong></h3>\r\n" + 
			"<p>Apart from these amazing Amazon Great Indian Sale offers, you will also get 5% CashKaro Amazon Rewards that can be redeemed as Amazon Vouchers. Shop for your favorite products using these Independence Day offers on Amazon via CashKaro.Com and experience the true festival of shopping. With numerous amazing Amazon Great Indian Sale offers right on your screen, we&rsquo;re sure you won&rsquo;t be able to stop at just one.</p>\r\n" + 
			"<p>Disclaimer: <em>The prices and discounts mentioned subject to change without prior notice.</em></p>\r\n" + 
			"<h2 class=\"hd_2\">Amazon Promotional Codes 2019: Up To 90% Off</h2>\r\n" + 
			"<p>The sales on Amazon are the most awaited throughout the year. From Prime members to regular users, all Amazon users can get the best of both worlds on all Amazon sales. Let&rsquo;s check out some of the most awaited sales on Amazon:</p>\r\n" + 
			"<h3 class=\"hd_3\">Amazon Prime Day Sale - (Upto 80% Off Across Categories)</h3>\r\n" + 
			"<p>Amazon Prime Day Sale always creates a stir among the netizens. And we are always excited about all mind-blowing Amazon Prime Day Deals, Amazon cashback offers and a lot more. The Prime Day Sale is valid across various categories like electronics, mobile &amp; accessories, TV &amp; Appliances, Home &amp; Outdoor products and a lot more. The best Amazon Prime Day Sale is a day of festivity for the Prime members. This year Prime Day Sale was big as the Prime users enjoyed up to 80% off across various categories. Whether it is Amazon Prime Day Laptop deals or Prime Day smartphone deals, this Amazon Prime Day Sale is about to get bigger. Shop for the latest mobile phones, appliances, fashion and more using the best Amazon Prime Deals.</p>\r\n" + 
			"<h3 class=\"hd_3\">Amazon Great Indian Sale (Upto 90% Off Across Categories)</h3>\r\n" + 
			"<p>Amazon Great Indian Sale brings in a new joy all Amazon users. From hefty discounts on smartphones to awesome Amazon offers on clothing, accessories, electronics and more, Amazon Great Indian Sale is a day of raining discounts. The Great Indian Sale comes with various exciting bank offers and Amazon Pay offers that make your shopping super economical. We are sure this year Great Indian Sale is going to be bigger than before, so, get ready to fill your carts with the most amazing products.</p>\r\n" + 
			"<h2 class=\"hd_2\">Things To Know About Amazon India</h2>\r\n" + 
			"<p>While finding the best deals on Amazon India, you may want to know about certain other details. Hence, you may want to contact its customer care to clarify the details about your order. Check out some important information about Amazon India below:</p>\r\n" + 
			"<h3 class=\"hd_3\">Amazon India Customer Care</h3>\r\n" + 
			"<p>At times we do have concerns and queries relating to our orders on Amazon India. Hence we require Amazon's customer care number. Read below to know about Amazon Customer Care Number:</p>\r\n" + 
			"<strong>Amazon India Customer Care Number -</strong> 1800 3000 9009<br /><strong>Amazon India Email</strong> - cs_reply@amazon.com\r\n" + 
			"<h3 class=\"hd_3\"><br />Amazon India Shipping Details</h3>\r\n" + 
			"<p>The shipping policy at Amazon India favors Prime subscribers over non-prime members. Shoppers who have subscribed to the Prime membership can enjoy free one-day and two-day deliveries to hundreds of pin codes in India. The standard shipping policy applies to non-prime subscribers. These members will have to make a minimum purchase of Rs 500 to be eligible for free shipping with a standard delivery time frame.</p>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</section>\r\n" + 
			"</div>\r\n" + 
			"<div class=\"pt pb fl fw grey_divider\">\r\n" + 
			"<div class=\"divider\">\r\n" + 
			"<section class=\"fl fw pt popular_str\">\r\n" + 
			"<h2 class=\"fl fw hd_2\">Popular Stores</h2>\r\n" + 
			"<div class=\"popular_str_slide fl fw\">\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/kashmirbox.png\" alt=\"kashmir box\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/kashmirbox?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Kashmir Box Coupon</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/planeteves-coupons.png\" alt=\"planeteves\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/planeteves-coupons?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Planeteves Coupon</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/shop-cj-tamil-offers.png\" alt=\"shop cj tamil\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/shop-cj-tamil-offers?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Shop Cj Tamil Offers</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/shop-cj-telugu-offers.png\" alt=\"shop cj telugu\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/shop-cj-telugu-offers?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Shop Cj Telugu Offers</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/shopclues-sunday-flea-market.png\" alt=\"shopclues sunday flea market\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/shopclues-sunday-flea-market?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Shopclues Sunday Flea Market Offer</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/shopdrill.png\" alt=\"shopdrill\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/shopdrill?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Shopdrill Coupons</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/spicestyle-coupons.png\" alt=\"spicestyle\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/spicestyle-coupons?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Spicestyle Coupon</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/wydr-coupons.png\" alt=\"wydr\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/wydr-coupons?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Wydr Coupons</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/tatacliq-fashion-1559802673.png\" alt=\"tata cliq fashion\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/tatacliq-fashion?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Tata Cliq Fashion Coupons</a></div>\r\n" + 
			"<div class=\"popular_str_slide_dt fl\">\r\n" + 
			"<div class=\"popular_str_slide_dt_img\"><img src=\"https://asset20.ckassets.com/resources/image/stores/spoyl-coupons-1551787368.jpg\" alt=\"spoyl\" /></div>\r\n" + 
			"<a href=\"https://cashkaro.com/stores/spoyl-coupons?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Spoyl Coupons</a></div>\r\n" + 
			"</div>\r\n" + 
			"</section>\r\n" + 
			"<section class=\"fl fw pt top_cat_str\">\r\n" + 
			"<h2 class=\"fl fw hd_2\">Top Categories</h2>\r\n" + 
			"<div class=\"top_cat_str_slide fl fw\">\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/electronics?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Electronics</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/clothing?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Clothing</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/shoes?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Shoes</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/accessories-bags?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Accessories &amp; Bags</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/health-beauty-products?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Health &amp; Beauty</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/home-and-kitchen?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Home &amp; Kitchen</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/babies-toys?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Babies &amp; Toys</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/eyewear?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Eyewear</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/books-and-media?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">Books &amp; Media</a></div>\r\n" + 
			"<div class=\"top_cat_str_slide_dt fl\"><a href=\"https://cashkaro.com/product/more-categories?utm_source=Amazon_India&amp;utm_medium=store&amp;utm_campaign=SEO_Footer\">More Categories</a></div>\r\n" + 
			"</div>\r\n" + 
			"<h2 class=\"fl fw hd_2\">Amazon Recent News</h2>\r\n" + 
			"<ul>\r\n" + 
			"<li><a href=\"https://economictimes.indiatimes.com/small-biz/startups/newsbuzz/amazon-flipkart-sales-generate-rs-19000-crore-in-6-days/articleshow/71491146.cms\" rel=\"Nofollow\">Amazon, Flipkart generate Rs 19,000 cr in festive sales, Flipkart takes lead</a>\r\n" + 
			"<p>Walmart-owned Flipkart surpassed the Amazon&rsquo;s GMV share this year holding a 60-62% standalone GMV.</p>\r\n" + 
			"</li>\r\n" + 
			"<li><a href=\"https://www.foxbusiness.com/technology/amazon-primed-to-become-biggest-national-security-player\" rel=\"Nofollow\">Amazon may become biggest national security player</a>\r\n" + 
			"<p>Amazon could soon receive the Pentagon&rsquo;s lucrative $10 billion cloud computing development contract.</p>\r\n" + 
			"</li>\r\n" + 
			"<li><a href=\"https://www.reuters.com/article/us-amazon-singapore/amazon-launches-bigger-local-online-store-in-singapore-idUSKBN1WN05N\" rel=\"Nofollow\">Amazon launches bigger local online store in Singapore</a>\r\n" + 
			"<p>Amazon.com Inc has launched a bigger local store and marketplace in Singapore.</p>\r\n" + 
			"</li>\r\n" + 
			"</ul>\r\n" + 
			"<h2 class=\"fl fw hd_2\">Amazon Recent Blogs</h2>\r\n" + 
			"<ul>\r\n" + 
			"<li><a href=\"https://cashkaro.com/blog/affordable-cameras-on-amazon-that-you-must-buy/113488\">Affordable Cameras on Amazon That You Must Buy</a>\r\n" + 
			"<p>We have listed down the best Affordable Camera that you can buy using latest Amazon India coupons.</p>\r\n" + 
			"</li>\r\n" + 
			"<li><a href=\"https://cashkaro.com/blog/all-about-the-oneplus-tv/113500\">All About The OnePlus TV</a>\r\n" + 
			"<p>Use Amazon India promotional codes to buy this premium TV and get cashback.</p>\r\n" + 
			"</li>\r\n" + 
			"</ul>\r\n" + 
			"</section>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<section itemscope=\"\" itemtype=\"https://schema.org/FAQPage\" class=\"fl fw pt pb white_divider\">\r\n" + 
			"<div class=\"divider\">\r\n" + 
			"<div class=\"str_faq_dtls fl fw\">\r\n" + 
			"<h2 class=\"hd_2\">Frequently Asked Questions</h2>\r\n" + 
			"<div class=\"str_faq_dtls_list fl fw\">\r\n" + 
			"<div class=\"str_faq_dtls_list_left fl\"></div>\r\n" + 
			"<div class=\"str_faq_dtls_list_right fl\">\r\n" + 
			"<div itemscope=\"\" itemprop=\"mainEntity\" itemtype=\"https://schema.org/Question\" class=\"fl fw str_faq_dtls_list_data\">\r\n" + 
			"<h3 itemprop=\"name\" class=\"hd_3\">Q. How can I find best Amazon promotional code?</h3>\r\n" + 
			"<p itemscope=\"\" itemprop=\"acceptedAnswer\" itemtype=\"https://schema.org/Answer\"><span itemprop=\"text\">A. It is super easy to find the best Amazon promotional codes. All you need to do is scroll up and go through all the amazing Amazon coupons, offers, voucher codes and deals. </span></p>\r\n" + 
			"</div>\r\n" + 
			"<div itemscope=\"\" itemprop=\"mainEntity\" itemtype=\"https://schema.org/Question\" class=\"fl fw str_faq_dtls_list_data\">\r\n" + 
			"<h3 itemprop=\"name\" class=\"hd_3\">Q. Are there any cashback offers om Amazon Great Indian sale 2019?</h3>\r\n" + 
			"<p itemscope=\"\" itemprop=\"acceptedAnswer\" itemtype=\"https://schema.org/Answer\"><span itemprop=\"text\">A. Yes, you can find cashback offers on Amazon Pay during the Amazon Great Indian Sale 2019. The best part is that if you shop on Amazon via CashKaro you will get CashKaro rewards on top of the cashback offers on Amazon.</span></p>\r\n" + 
			"</div>\r\n" + 
			"<div itemscope=\"\" itemprop=\"mainEntity\" itemtype=\"https://schema.org/Question\" class=\"fl fw str_faq_dtls_list_data\">\r\n" + 
			"<h3 itemprop=\"name\" class=\"hd_3\">Q. How can I avail Amazon promo code 2019?</h3>\r\n" + 
			"<p itemscope=\"\" itemprop=\"acceptedAnswer\" itemtype=\"https://schema.org/Answer\"><span itemprop=\"text\">A. Simply shop per usual on Amazon and at the time of check out paste the Amazon Promo Code in the required area. </span></p>\r\n" + 
			"</div>\r\n" + 
			"<div itemscope=\"\" itemprop=\"mainEntity\" itemtype=\"https://schema.org/Question\" class=\"fl fw str_faq_dtls_list_data\">\r\n" + 
			"<h3 itemprop=\"name\" class=\"hd_3\">Q. Is there any Amazon India Sale offer today?</h3>\r\n" + 
			"<p itemscope=\"\" itemprop=\"acceptedAnswer\" itemtype=\"https://schema.org/Answer\"><span itemprop=\"text\">A. Yes, as the Amazon Great India Sale is approaching you can find all sale offers on CashKaro's Amazon page. Simply scroll up and find the best Amazon Sale offers.</span></p>\r\n" + 
			"</div>\r\n" + 
			"<div itemscope=\"\" itemprop=\"mainEntity\" itemtype=\"https://schema.org/Question\" class=\"fl fw str_faq_dtls_list_data\">\r\n" + 
			"<h3 itemprop=\"name\" class=\"hd_3\">Q. Which is the best discount offers on Amazon India shopping?</h3>\r\n" + 
			"<p itemscope=\"\" itemprop=\"acceptedAnswer\" itemtype=\"https://schema.org/Answer\"><span itemprop=\"text\">A. The best discount offers on Amazon India are up to 90% off on Fashion, 10% SBI bank offer and awesome CashKaro rewards. </span></p>\r\n" + 
			"</div>\r\n" + 
			"<div itemscope=\"\" itemprop=\"mainEntity\" itemtype=\"https://schema.org/Question\" class=\"fl fw str_faq_dtls_list_data\">\r\n" + 
			"<h3 itemprop=\"name\" class=\"hd_3\">Q. Is there any Amazon India Sale today?</h3>\r\n" + 
			"<p itemscope=\"\" itemprop=\"acceptedAnswer\" itemtype=\"https://schema.org/Answer\"><span itemprop=\"text\">A. The Amazon Great Indian Sale is going on in full swing, so get ready to shop for the bestsellers at awesome discounts and dont forget to avail CashKaro rewards. </span></p>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</section>";

	/******************************************************** Methods Creation started ****************************************************************/

	//******************************************************* Click Sub Menu Stores *******************************************************************/
	
	/* Click Stores */
	public void clickSubMenuStores(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click submenuStores", "INFO");

		if(jsClickUsingID(driver, submenu_Stores)) {

			reportStep(logger, "Successfully clicked submenuStores", "PASS");
		}else {

			reportStep(logger, "Not able to click submenuStores", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, button_AddNewStores)){

			reportStep(logger, "button_AddNewStores is  visible after clicking submenuStores", "PASS");

		}else {

			reportStep(logger, "button_AddNewStores not  visible after clicking submenuStores", "FAIL");

		}

	}
	
	//********************************************************** Click Add New Stores******************************************************************/
	
	/* Click AddNewStore */
	public void clickAddNewStore(WebDriver driver) {

		reportStep(logger, "About to click AddNewStore", "INFO");

		if(jsClickByID(driver, button_AddNewStores)) {

			reportStep(logger, "Successfully clicked AddNewStore", "PASS");
		}else {

			reportStep(logger, "Not able to click AddNewStore", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, input_Name)){

			reportStep(logger, "input_Name is  visible after clicking tab_Stores", "PASS");

		}else {

			reportStep(logger, "input_Name not  visible after clicking tab_Stores", "FAIL");

		}

	}

	/* Search Store Name */
	public String searchCashbackStoreName(WebDriver driver, String str_Store_Name) throws InterruptedException {
		
		reportStep(logger, "About to enter store name: "+str_Store_Name, "INFO");		
		
		if(enterTextByID(driver, input_Name, str_Store_Name)) {

			reportStep(logger, "Successfully entered store name: "+str_Store_Name, "PASS");
		}else {

			reportStep(logger, "Not able to enter store name: "+str_Store_Name, "FAIL");
		}
		
		return str_Store_Name ;
	}

	/* Click Search */
	public void clickSearch(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click search button", "INFO");

		if(clickByID(driver, btn_Search)) {

			reportStep(logger, "Successfully clicked search button", "PASS");
		}else {

			reportStep(logger, "Not able to click search button", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, list_Of_Stores)){

			reportStep(logger, "list_Of_Stores is  visible after clicking search button", "PASS");

		}else {

			reportStep(logger, "list_Of_Stores not  visible after clicking search button", "FAIL");

		}
	}

	/* Click Edit */
	public void clickEdit(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click edit button", "INFO");

		if(jsClickByXpath(driver, icon_Edit)) {

			reportStep(logger, "Successfully clicked edit button", "PASS");
		}else {

			reportStep(logger, "Not able to click edit button", "FAIL");
		}

		if(isElementLocatedByXpathPresent(driver, text_Editstore)){

			reportStep(logger, "text_Editstore is  visible after clicking edit button", "PASS");

		}else {

			reportStep(logger, "text_Editstore not  visible after clicking edit button", "FAIL");

		}
	}

	/* Click clear */
	public void clickClear(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to Clear edit button", "INFO");

		if(clickByID(driver, clear_Button)) {

			reportStep(logger, "Successfully clicked Clear button", "PASS");
		}else {

			reportStep(logger, "Not able to click Clear button", "FAIL");
		}
		
		Thread.sleep(2000);

		if(isElementLocatedByIDPresent(driver, input_StoreName)){

			reportStep(logger, "input_StoreName is  visible after clicking edit button", "PASS");

		}else {

			reportStep(logger, "input_StoreName not  visible after clicking edit button", "FAIL");

		}
	}

	/* Get Store ID */
	public String getStoreID(WebDriver driver) throws InterruptedException {

		reportStep(logger,"About to retrieve store id", "INFO");
		
		String storeId = getTextByXpath(driver, text_ID);
		
		reportStep(logger,"Successfully retrieved store id: "+storeId, "PASS");
		
		return storeId;
	}

	//************************************************************** Click Required Tabs ***************************************************************
	
	/* Click Store Tab */
	public void clickStoresTab(WebDriver driver) {

		reportStep(logger, "About to click tab_Stores", "INFO");

		if(jsClickUsingID(driver, tab_Stores)) {

			reportStep(logger, "Successfully clicked tab_Stores", "PASS");
		}else {

			reportStep(logger, "Not able to click tab_Stores", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, input_Name)){

			reportStep(logger, "input_Name is  visible after clicking tab_Stores", "PASS");

		}else {

			reportStep(logger, "input_Name not  visible after clicking tab_Stores", "FAIL");

		}

	}

	/* Click Category Tab */
	public void clickCategoryTab(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click tab_Category", "INFO");

		if(jsClickUsingID(driver, tab_Category)) {

			reportStep(logger, "Successfully clicked tab_Category", "PASS");
		}else {

			reportStep(logger, "Not able to click tab_Category", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, checkBox_tree)){

			reportStep(logger, "checkBox_tree is  visible after clicking tab_Category", "PASS");

		}else {

			reportStep(logger, "checkBox_tree not  visible after clicking tab_Category", "FAIL");

		}

	}

	/* Click SEO Tab */
	public void clickSEOTab(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click tab_Category", "INFO");

		if(jsClickUsingID(driver, tab_SEO)) {

			reportStep(logger, "Successfully clicked tab_SEO", "PASS");
		}else {

			reportStep(logger, "Not able to click tab_SEO", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, textarea_Keywords)){

			reportStep(logger, "textarea_Keywords is  visible after clicking tab_SEO", "PASS");

		}else {

			reportStep(logger, "textarea_Keywords not  visible after clicking tab_SEO", "FAIL");

		}

	}

	/* Click Primary Cashback Tab */
	public void clickPrimaryCashbackTab(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click tab_PrimaryCB", "INFO");

		if(jsClickUsingID(driver, tab_PrimaryCB)) {

			reportStep(logger, "Successfully clicked tab_PrimaryCB", "PASS");
		}else {

			reportStep(logger, "Not able to click tab_PrimaryCB", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, select_Cashback_Type)){

			reportStep(logger, "select_Cashback_Type is  visible after clicking tab_PrimaryCB", "PASS");

		}else {

			reportStep(logger, "select_Cashback_Type not  visible after clicking tab_PrimaryCB", "FAIL");

		}

	}

	/* Click Secondary Cashback Tab */
	public void clickSecondaryCashbackTab(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click tab_SecondaryCB", "INFO");

		if(jsClickUsingID(driver, tab_SecondaryCB)) {

			reportStep(logger, "Successfully clicked tab_SecondaryCB", "PASS");
		}else {

			reportStep(logger, "Not able to click tab_SecondaryCB", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, select_Calendar_cashback_percentage)){

			reportStep(logger, "select_Calendar_cashback_percentage is  visible after clicking tab_SecondaryCB", "PASS");

		}else {

			reportStep(logger, "select_Calendar_cashback_percentage not  visible after clicking tab_SecondaryCB", "FAIL");

		}

	}

	/* Click Cashback Rules Tab */
	public void clickCashbackRulesTab(WebDriver driver) throws InterruptedException {	

		reportStep(logger, "About to click tab_CashbackRules", "INFO");

		if(jsClickUsingID(driver, tab_CashbackRules)) {

			reportStep(logger, "Successfully clicked tab_CashbackRules", "PASS");
		}else {

			reportStep(logger, "Not able to click tab_CashbackRules", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, tab_CBR_Primary_Cashback)){

			reportStep(logger, "tab_CBR_Primary_Cashback is  visible after clicking tab_CashbackRules", "PASS");

		}else {

			reportStep(logger, "tab_CBR_Primary_Cashback not  visible after clicking tab_CashbackRules", "FAIL");

		}

	}

	/* Click Others Tab */
	public void clickOthersTab(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click tab_Others", "INFO");

		if(jsClickUsingID(driver, tab_Others)) {

			reportStep(logger, "Successfully clicked tab_Others", "PASS");
		}else {

			reportStep(logger, "Not able to click tab_Others", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, textarea_What_You_Should_Know)){

			reportStep(logger, "textarea_What_You_Should_Know is  visible after clicking tab_Others", "PASS");

		}else {

			reportStep(logger, "textarea_What_You_Should_Know not  visible after clicking tab_Others", "FAIL");

		}

	}

	/* Click Store Content Tab */
	public void clickStoreContentTab(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click tab_StoreContent", "INFO");

		if(jsClickUsingID(driver, tab_StoreContent)) {

			reportStep(logger, "Successfully clicked tab_StoreContent", "PASS");
		}else {

			reportStep(logger, "Not able to click tab_StoreContent", "FAIL");
		}

		if(isElementLocatedByXpathPresent(driver, text_StoreContent)){

			reportStep(logger, "text_StoreContent is  visible after clicking tab_StoreContent", "PASS");

		}else {

			reportStep(logger, "text_StoreContent not  visible after clicking tab_StoreContent", "FAIL");

		}

	}

	//****************************************************************** Store Tab ***********************************************************************
		
	/* Enter Store Name */
	public String enterCashbackStoreName(WebDriver driver) throws InterruptedException {
		
		intRandNumber = objRandNum.nextInt(50) + 1;
		
    	strCurrentDate = Utils.datestamp()+ intRandNumber;
    	ThreadLocal_CurrentDate.set(strCurrentDate);
    	threadLocalValue_CurrentDate = (String) ThreadLocal_CurrentDate.get();
    	strNewCBStore_Name = ("Cashback Store :"+threadLocalValue_CurrentDate );
		
		reportStep(logger, "About to enter store name: "+strNewCBStore_Name, "INFO");		
		
		if(enterTextByID(driver, input_Name, strNewCBStore_Name)) {

			reportStep(logger, "Successfully entered store name: "+strNewCBStore_Name, "PASS");
		}else {

			reportStep(logger, "Not able to enter store name: "+strNewCBStore_Name, "FAIL");
		}
		
		return strNewCBStore_Name ;
	}
		
	/* Enter Store Name */
	public String enterRewardStoreName(WebDriver driver) throws InterruptedException {
		
    	
		intRandNumber = objRandNum.nextInt(50) + 1;
		
    	strCurrentDate = Utils.datestamp()+ intRandNumber;
    	ThreadLocal_CurrentDate.set(strCurrentDate);
    	threadLocalValue_CurrentDate = (String) ThreadLocal_CurrentDate.get();
    	strNewRWStore_Name = ("Reward Store :"+threadLocalValue_CurrentDate );
		
		reportStep(logger, "About to enter store name: "+strNewRWStore_Name, "INFO");		
		
		if(enterTextByID(driver, input_Name, strNewRWStore_Name)) {

			reportStep(logger, "Successfully entered store name: "+strNewRWStore_Name, "PASS");
		}else {

			reportStep(logger, "Not able to enter store name: "+strNewRWStore_Name, "FAIL");
		}
		
		return strNewRWStore_Name ;
	}
	
	/* Enter Store Name */
	public String enterNetwork18StoreName(WebDriver driver) throws InterruptedException {
		
		intRandNumber = objRandNum.nextInt(50) + 1;
		
    	strCurrentDate = Utils.datestamp()+ intRandNumber;
    	ThreadLocal_CurrentDate.set(strCurrentDate);
    	threadLocalValue_CurrentDate = (String) ThreadLocal_CurrentDate.get();
    	strNewN18Store_Name = ("Network18 Store :"+threadLocalValue_CurrentDate );
		
		reportStep(logger, "About to enter store name: "+strNewN18Store_Name, "INFO");		
		
		if(enterTextByID(driver, input_Name, strNewN18Store_Name)) {

			reportStep(logger, "Successfully entered store name: "+strNewN18Store_Name, "PASS");
		}else {

			reportStep(logger, "Not able to enter store name: "+strNewN18Store_Name, "FAIL");
		}
		
		return strNewN18Store_Name;
	}
	
	/* Enter URL Key */
	public String enterURLKey(WebDriver driver) throws InterruptedException {
		
		strNewstore_URLKey = ("urlkey"+threadLocalValue_CurrentDate);
		
		reportStep(logger, "About to enter store urlKey: "+strNewstore_URLKey, "INFO");		
		
		if(enterTextByID(driver, input_URL_Key, strNewstore_URLKey)) {

			reportStep(logger, "Successfully entered store urlKey: "+strNewstore_URLKey, "PASS");
		}else {

			reportStep(logger, "Not able to enter store urlKey: "+strNewstore_URLKey, "FAIL");
		}
	
		return strNewstore_URLKey ;
	}
	
	/* Select Status */
	public String selectStatus(WebDriver driver, String strNewStore_StoreStatus) throws InterruptedException {
		
		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, select_Status, strNewStore_StoreStatus)) {

			reportStep(logger, "Successfully selected value "+strNewStore_StoreStatus+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strNewStore_StoreStatus+" from dropdown", "FAIL");
		}

		return strNewStore_StoreStatus;
	}

	/* Click Required Device Type */
	public String clickDeviceTypeDesktop(WebDriver driver) throws InterruptedException {
		
		String deviceType = "Desktop";

		reportStep(logger, "About to click checkbox_Desktop", "INFO");

		if(jsClickUsingID(driver, checkbox_Desktop)) {

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

		if(jsClickUsingID(driver, checkbox_Mobile)) {

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

		if(jsClickUsingID(driver, checkbox_Tablet)) {

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

		if(jsClickUsingID(driver, checkbox_App)) {

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

	/* Enter Exit Click */
	public String enterExitClick(WebDriver driver, String strExitClickCount) throws InterruptedException {
		
		String exitClick = strExitClickCount;
		
		reportStep(logger, "About to enter store exitClick: "+exitClick, "INFO");		
		
		if(enterTextByID(driver, textArea_ExitClick, exitClick)) {

			reportStep(logger, "Successfully entered store exitClick: "+exitClick, "PASS");
		}else {

			reportStep(logger, "Not able to enter store exitClick: "+exitClick, "FAIL");
		}
		
		return exitClick;
	}

	/* Enter Full Description */
	public String enterFullDescription(WebDriver driver) throws InterruptedException {
		
		strnewStore_FullDescription = ("This Is Test User Entering Full description:"+threadLocalValue_CurrentDate);
		
		reportStep(logger, "About to enter store fullDesc: "+strnewStore_FullDescription, "INFO");		
		
		if(enterTextByID(driver, textaretab_Full_Description, strnewStore_FullDescription)) {

			reportStep(logger, "Successfully entered store fullDesc: "+strnewStore_FullDescription, "PASS");
		}else {

			reportStep(logger, "Not able to enter store fullDesc: "+strnewStore_FullDescription, "FAIL");
		}

		return strnewStore_FullDescription ;
	}

	/* Enter App Full Description */
	public String enterAppFullDescription(WebDriver driver) throws InterruptedException {
		
		strnewStore_FullDescription = ("This Is Test User Entering App Full description:"+threadLocalValue_CurrentDate);
		
		reportStep(logger, "About to enter store app Full description: "+strnewStore_FullDescription, "INFO");		
		
		if(enterTextByID(driver, textaretab_App_Full_Description, strnewStore_FullDescription)) {

			reportStep(logger, "Successfully entered store app Full description: "+strnewStore_FullDescription, "PASS");
		}else {

			reportStep(logger, "Not able to enter store app Full description: "+strnewStore_FullDescription, "FAIL");
		}

		return strnewStore_FullDescription ;
	}

	/* Select Network */
	public String selectAffiliateNetwork(WebDriver driver, String strNewStore_AffiliateNetwork) throws InterruptedException {
		
		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, select_Affiliate_Network, strNewStore_AffiliateNetwork)) {

			reportStep(logger, "Successfully selected value "+strNewStore_AffiliateNetwork+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strNewStore_AffiliateNetwork+" from dropdown", "FAIL");
		}
		
		return strNewStore_AffiliateNetwork;
	}
		
	/* Enter Image URL */
	public String enterImageURL(WebDriver driver , String strnewStore_ImageURl) throws InterruptedException {
		
		reportStep(logger, "About to enter store image url: "+strnewStore_ImageURl, "INFO");		
		
		if(enterTextByID(driver, input_Image_URL, strnewStore_ImageURl)) {

			reportStep(logger, "Successfully entered store image url: "+strnewStore_ImageURl, "PASS");
		}else {

			reportStep(logger, "Not able to enter store image url: "+strnewStore_ImageURl, "FAIL");
		}
		
		return strnewStore_ImageURl ;

	}
	
	/* Enter Link URL */
	public String enterLinkURL(WebDriver driver, String strnewStore_LinkUrl) throws InterruptedException {
		
		reportStep(logger, "About to enter store linkURL: "+strnewStore_LinkUrl, "INFO");		
		
		if(enterTextByID(driver, input_Link_URL, strnewStore_LinkUrl)) {

			reportStep(logger, "Successfully entered store linkURL: "+strnewStore_LinkUrl, "PASS");
		}else {

			reportStep(logger, "Not able to enter store linkURL: "+strnewStore_LinkUrl, "FAIL");
		}
		
		return strnewStore_LinkUrl ;

	}
	
	/* Enter Deep Link */
	public String enterDeepLink(WebDriver driver,String strnewStore_DeepLink) throws InterruptedException {
		
		reportStep(logger, "About to enter store deepLink: "+strnewStore_DeepLink, "INFO");		
		
		if(enterTextByID(driver, input_Deep_Link, strnewStore_DeepLink)) {

			reportStep(logger, "Successfully entered store deepLink: "+strnewStore_DeepLink, "PASS");
		}else {

			reportStep(logger, "Not able to enter store deepLink: "+strnewStore_DeepLink, "FAIL");
		}
		
		return strnewStore_DeepLink;
	}
	
	/* Enter UTM Parameter */
	public String enterUTMParameter(WebDriver driver , String strnewStore_UTMParameter) throws InterruptedException {
		
		reportStep(logger, "About to enter store utmParam: "+strnewStore_UTMParameter, "INFO");		
		
		if(enterTextByID(driver, label_UTM_Parameter, strnewStore_UTMParameter)) {

			reportStep(logger, "Successfully entered store utmParam: "+strnewStore_UTMParameter, "PASS");
		}else {

			reportStep(logger, "Not able to enter store utmParam: "+strnewStore_UTMParameter, "FAIL");
		}
		
		return strnewStore_UTMParameter ;
	}
	
	/* Enter TC Intermediate Page */
	public String enterTCIntermediatePage(WebDriver driver , String strnewStore_TC_IntermediatePage) throws InterruptedException {
		
		reportStep(logger, "About To Enter Store Terms & Conditons For Store: "+strnewStore_TC_IntermediatePage, "INFO");		
		
		if(enterTextByID(driver, input_T_C_at_Intermediate_page, strnewStore_TC_IntermediatePage)) {

			reportStep(logger, "Successfully entered store t&c: "+strnewStore_TC_IntermediatePage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store t&c: "+strnewStore_TC_IntermediatePage, "FAIL");
		}
		
		return strnewStore_TC_IntermediatePage ;
	}

	/* Enter App TC Intermediate Page */
	public String enterTCAppIntermediatePage(WebDriver driver , String strnewStore_TC_IntermediatePage) throws InterruptedException {
		
		reportStep(logger, "About To Enter App Store Terms & Conditons For Store: "+strnewStore_TC_IntermediatePage, "INFO");		
		
		if(enterTextByID(driver, input_App_T_C_at_Intermediate_page, strnewStore_TC_IntermediatePage)) {

			reportStep(logger, "Successfully entered store app t&c: "+strnewStore_TC_IntermediatePage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store app t&c: "+strnewStore_TC_IntermediatePage, "FAIL");
		}
		
		return strnewStore_TC_IntermediatePage ;
	}

	/* Select Store Type */
	public String selectStoreTypeCashback(WebDriver driver) throws InterruptedException {
		
		strNewStore_StoreType ="Cashback";

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, select_Store_Type, strNewStore_StoreType)) {

			reportStep(logger, "Successfully selected value "+strNewStore_StoreType+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strNewStore_StoreType+" from dropdown", "FAIL");
		}
		
		return strNewStore_StoreType;
	}
	
	/* Select Store Type */
	public String selectStoreTypeRewards(WebDriver driver) throws InterruptedException {
		
		strNewStore_StoreType ="Rewards";

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, select_Store_Type, strNewStore_StoreType)) {

			reportStep(logger, "Successfully selected value "+strNewStore_StoreType+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strNewStore_StoreType+" from dropdown", "FAIL");
		}
		
		return strNewStore_StoreType;
	}
	
	/* Enter Store Name */
	public String enterStoreName(WebDriver driver, String str_StoreName) throws InterruptedException {
		
		reportStep(logger, "About to enter store name: "+str_StoreName, "INFO");		
		
		if(enterTextByID(driver, input_StoreName, str_StoreName)) {

			reportStep(logger, "Successfully entered store name: "+str_StoreName, "PASS");
		}else {

			reportStep(logger, "Not able to enter store name: "+str_StoreName, "FAIL");
		}
		
		return str_StoreName;
	}
		
	/* Enter MCB Time */
	public String enterMissingCashbackTime(WebDriver driver, String missingCashbackTime) throws InterruptedException {
			
		reportStep(logger, "About to enter store missingCashbackTime: "+missingCashbackTime, "INFO");		
		
		if(enterTextByID(driver, missingCashbackTime_TextField, missingCashbackTime)) {

			reportStep(logger, "Successfully entered store missingCashbackTime: "+missingCashbackTime, "PASS");
		}else {

			reportStep(logger, "Not able to enter store missingCashbackTime: "+missingCashbackTime, "FAIL");
		}
		
		return missingCashbackTime ;
	}

	/* Enter CashbackExpectedConfirmationDays Time */
	public String enterCashbackExpectedConfirmationDays(WebDriver driver, String cashbackExpectedConfirmationDays) throws InterruptedException {
			
		reportStep(logger, "About to enter store CashbackExpectedConfirmationDays: "+cashbackExpectedConfirmationDays, "INFO");		
		
		if(enterTextByID(driver, cashbackExpectedConfirmationDays_TextField, cashbackExpectedConfirmationDays)) {

			reportStep(logger, "Successfully entered store CashbackExpectedConfirmationDays: "+cashbackExpectedConfirmationDays, "PASS");
		}else {

			reportStep(logger, "Not able to enter store CashbackExpectedConfirmationDays: "+cashbackExpectedConfirmationDays, "FAIL");
		}
		
		return cashbackExpectedConfirmationDays ;
	}

	/* Enter orderIDFormat Time */
	public String enterorderIDFormat(WebDriver driver, String orderIDFormat) throws InterruptedException {
			
		reportStep(logger, "About to enter store orderIDFormat: "+orderIDFormat, "INFO");		
		
		if(enterTextByID(driver, orderIDFormat_TextField, orderIDFormat)) {

			reportStep(logger, "Successfully entered store orderIDFormat: "+orderIDFormat, "PASS");
		}else {

			reportStep(logger, "Not able to enter store orderIDFormat: "+orderIDFormat, "FAIL");
		}
		
		return orderIDFormat ;
	}

	/* Enter trackingSpeed Time */
	public String entertrackingSpeed(WebDriver driver, String trackingSpeed) throws InterruptedException {
			
		reportStep(logger, "About to enter store trackingSpeed: "+trackingSpeed, "INFO");		
		
		if(enterTextByID(driver, trackingSpeed_TextField, trackingSpeed)) {

			reportStep(logger, "Successfully entered store trackingSpeed: "+trackingSpeed, "PASS");
		}else {

			reportStep(logger, "Not able to enter store trackingSpeed: "+trackingSpeed, "FAIL");
		}
		
		return trackingSpeed;
	}

	/* Click IncludeInSearch Time */
	public String clickIncludeInSearch(WebDriver driver, String value) throws InterruptedException {

		reportStep(logger, "About to click include in search", "INFO");

		switch (value) {
		case "check":

			reportStep(logger, "Didn't click include in search", "PASS");
			
			break;
			
		case "uncheck":

			if (jsClickUsingID(driver, includeInSearch_CheckBox)) {

				reportStep(logger, "Successfully clicked include in search", "PASS");

			} else {

				reportStep(logger, "Not able to click include in search", "FAIL");

			}
			
			return "false";
		}
		return "true";

	}

	/* Click IncludeInSitemap Time */
	public String clickIncludeInSitemap(WebDriver driver, String value) throws InterruptedException {
					
		reportStep(logger, "About to click include in Sitemap", "INFO");

		switch (value) {
		case "check":

			reportStep(logger, "Didn't click include in Sitemap", "PASS");
			
			break;
			
		case "uncheck":

			if (jsClickUsingID(driver, includeInSitemap_CheckBox)) {

				reportStep(logger, "Successfully clicked include in Sitemap", "PASS");

			} else {

				reportStep(logger, "Not able to click include in Sitemap", "FAIL");

			}

			return "false";
		}
		return "true";
		
	}

	/* Click ShoworderID Time */
	public String clickShoworderID(WebDriver driver, String value) throws InterruptedException {
					
		reportStep(logger, "About to click show order id", "INFO");

		switch (value) {
		case "check":

			reportStep(logger, "Didn't click show order id", "PASS");
			
			break;

		case "uncheck":

			if (jsClickUsingID(driver, showorderID_CheckBox)) {

				reportStep(logger, "Successfully clicked show order id", "PASS");

			} else {

				reportStep(logger, "Not able to click show order id", "FAIL");

			}

			return "false";
		}
		return "true";
		
	}

	/* Click AcceptMissingTicket Time */
	public String clickAcceptMissingTicket(WebDriver driver, String value) throws InterruptedException {
					
		reportStep(logger, "About to click accept missing ticket", "INFO");

		switch (value) {
		case "check":

			reportStep(logger, "Didn't click accept missing ticket", "PASS");
			
			break;

		case "uncheck":

			if (jsClickUsingID(driver, acceptMissingTicket_CheckBox)) {

				reportStep(logger, "Successfully clicked accept missing ticket", "PASS");

			} else {

				reportStep(logger, "Not able to click accept missing ticket", "FAIL");

			}

			return "false";
		}
		return "true";
		
	}

	/* Change Store Status */
	public String changeStoreStatus(WebDriver driver, String strNewStore_StoreStatus) throws InterruptedException {
		
		reportStep(logger, "About to change the status active or in-active", "INFO");
		
		this.selectStatus(driver, strNewStore_StoreStatus);
		
		reportStep(logger, "Successfully status has been changed active or inactive", "PASS");
		
		return strNewStore_StoreStatus ;
	
	}

	/* Enter Button Text */
	public String enterButonText(WebDriver driver, String buttonText) throws InterruptedException {
	
		reportStep(logger, "About to enter store buttonText: "+buttonText, "INFO");		
		
		if(enterTextByID(driver, buttonText_TextField, buttonText)) {

			reportStep(logger, "Successfully entered store buttonText: "+buttonText, "PASS");
		}else {

			reportStep(logger, "Not able to enter store buttonText: "+buttonText, "FAIL");
		}
		
		return buttonText ;
	}

	//****************************************************************** Store Creation  *****************************************************************

	/* Cashback Store Creation */
	public String[] enterCashbackStoreDetails(WebDriver driver,String strNewStore_StoreStatus,String strNewStore_AffNetwork,String strnewStore_ImageURl,String strnewStore_LinkUrl,String strnewStore_DeepLink,
			String strnewStore_UTMParameter,String strnewStore_TC_InterePage, String str_DeviceName, String strExitClickCount) throws InterruptedException {
		
		reportStep(logger, "About to create CashbackStore", "INFO");

		String storeName 						=  this.enterCashbackStoreName(driver);
		String storeURLKey  					=  this.enterURLKey(driver);
		String storeStatus  					=  this.selectStatus(driver, strNewStore_StoreStatus);			
		String storeAffiliateNetwork  			=  this.selectAffiliateNetwork(driver, strNewStore_AffNetwork);
		String storeFullDescription 			=  this.enterFullDescription(driver);
		String storeAppFullDescription 			=  this.enterAppFullDescription(driver);
		String storeImageURL 					=  this.enterImageURL(driver, strnewStore_ImageURl);
		String storeLinkURL  					=  this.enterLinkURL(driver, strnewStore_LinkUrl);
		String storeDeepLinkURL 				=  this.enterDeepLink(driver, strnewStore_DeepLink);
		String storeUTMParameter 				=  this.enterUTMParameter(driver, strnewStore_UTMParameter);
		String storeType  						=  this.selectStoreTypeCashback(driver);
		String storeExitClick					=  this.enterExitClick(driver, strExitClickCount);
		String storeTCIntermediatePage 			=  this.enterTCIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeAppTCIntermediatePage 		=  this.enterTCAppIntermediatePage(driver, strnewStore_TC_InterePage);
		this.enterMissingCashbackTime(driver, "72");
		this.enterButonText(driver, "ACTIVATE CASHBACK");
		this.selectDeviceType(driver, str_DeviceName);
		
		reportStep(logger,"Assigning the newly created store values into an array", "PASS");
		
		String[] arrayCB_NewStoreDetails = new String[] {storeName, storeURLKey, storeStatus, storeAffiliateNetwork , "", 
				storeFullDescription,storeImageURL,storeLinkURL,storeDeepLinkURL,storeUTMParameter,storeTCIntermediatePage,
				storeType, storeExitClick, "", storeAppFullDescription, storeAppTCIntermediatePage};
		
		reportStep(logger,"Successfully created CashbackStore", "PASS");
		
		return arrayCB_NewStoreDetails ;
	
	}

	/* Reward Store Creation */
	public String[] enterRewardStoreDetails(WebDriver driver,String strNewStore_StoreStatus,String strNewStore_AffNetwork,String strnewStore_ImageURl,String strnewStore_LinkUrl,String strnewStore_DeepLink,
			String strnewStore_UTMParameter,String strnewStore_TC_InterePage, String str_DeviceName, String strExitClickCount) throws InterruptedException {
		
		reportStep(logger, "About to create RewardStore", "INFO");

		String storeName 					=  this.enterRewardStoreName(driver);
		String storeURLKey  				=  this.enterURLKey(driver);
		String storeStatus  				=  this.selectStatus(driver, strNewStore_StoreStatus);
		String storeAffiliateNetwork  		=  this.selectAffiliateNetwork(driver, strNewStore_AffNetwork);	
		String storeFullDescription 		=  this.enterFullDescription(driver);
		String storeImageURL 				=  this.enterImageURL(driver, strnewStore_ImageURl);
		String storeLinkURL  				=  this.enterLinkURL(driver, strnewStore_LinkUrl);
		String storeDeepLinkURL 			=  this.enterDeepLink(driver, strnewStore_DeepLink);
		String storeUTMParameter 			=  this.enterUTMParameter(driver, strnewStore_UTMParameter);
		String storeTCIntermediatePage 		=  this.enterTCIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeType  					=  this.selectStoreTypeRewards(driver);
		String storeExitClick				=  this.enterExitClick(driver, strExitClickCount);
		String storeAppFullDescription 		=  this.enterAppFullDescription(driver);
		String storeAppTCIntermediatePage	=  this.enterTCAppIntermediatePage(driver, strnewStore_TC_InterePage);
		this.enterMissingCashbackTime(driver, "72");
		this.enterButonText(driver, "ACTIVATE REWARDS");
		this.selectDeviceType(driver, str_DeviceName);
		
		reportStep(logger,"Assigning the newly created store values into an array", "PASS");
		
		String[] arrayRW_NewStoreDetails = new String[] {storeName, storeURLKey, storeStatus, storeAffiliateNetwork , "" ,
				storeFullDescription,storeImageURL,storeLinkURL,storeDeepLinkURL,storeUTMParameter,storeTCIntermediatePage,
				storeType, storeExitClick, "", storeAppFullDescription, storeAppTCIntermediatePage};
		
		reportStep(logger,"Successfully created RewardStore", "PASS");
		
		return arrayRW_NewStoreDetails ;
	
	}

	/* Network18 Store Creation */
	public String[] enterNetwork18StoreDetails(WebDriver driver,String strNewStore_StoreStatus,String strNewStore_AffNetwork,String strnewStore_ImageURl,String strnewStore_LinkUrl,String strnewStore_DeepLink,
			String strnewStore_UTMParameter,String strnewStore_TC_InterePage, String str_DeviceName, String strExitClickCount) throws InterruptedException {
		
		reportStep(logger, "About to create N18Store", "INFO");

		String storeName 					=  this.enterNetwork18StoreName(driver);
		String storeURLKey  				=  this.enterURLKey(driver);
		String storeStatus  				=  this.selectStatus(driver, strNewStore_StoreStatus);	
		String storeAffiliateNetwork  		=  this.selectAffiliateNetwork(driver, strNewStore_AffNetwork);
		String storeFullDescription 		=  this.enterFullDescription(driver);
		String storeImageURL 				=  this.enterImageURL(driver, strnewStore_ImageURl);
		String storeLinkURL  				=  this.enterLinkURL(driver, strnewStore_LinkUrl);
		String storeDeepLinkURL 			=  this.enterDeepLink(driver, strnewStore_DeepLink);
		String storeUTMParameter 			=  this.enterUTMParameter(driver, strnewStore_UTMParameter);
		String storeTCIntermediatePage 		=  this.enterTCIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeType  					=  this.selectStoreTypeCashback(driver);
		String storeExitClick				=  this.enterExitClick(driver, strExitClickCount);
		String storeAppFullDescription 		=  this.enterAppFullDescription(driver);
		String storeAppTCIntermediatePage	=  this.enterTCAppIntermediatePage(driver, strnewStore_TC_InterePage);
		this.enterMissingCashbackTime(driver, "72");
		this.enterButonText(driver, "GRAB DEAL");
		this.selectDeviceType(driver, str_DeviceName);
		
		reportStep(logger,"Assigning the newly created store values into an array", "PASS");
		
		String[] arrayN18_NewStoreDetails = new String[] {storeName, storeURLKey, storeStatus, storeAffiliateNetwork, "" ,
				storeFullDescription,storeImageURL,storeLinkURL,storeDeepLinkURL,storeUTMParameter,storeTCIntermediatePage,
				storeType, storeExitClick, "", storeAppFullDescription, storeAppTCIntermediatePage};
		
		reportStep(logger,"Successfully created N18Store", "PASS");
	
		return arrayN18_NewStoreDetails ;
	
	}

	/* Cashback Store Creation */
	public String[] enterCashbackStoreDetails(WebDriver driver,String strNewStore_StoreStatus,String strNewStore_AffNetwork,String strnewStore_ImageURl,String strnewStore_LinkUrl,String strnewStore_DeepLink,
			String strnewStore_UTMParameter,String strnewStore_TC_InterePage, String str_DeviceName, String strExitClickCount, String missingCashbackTime, String buttonText,
			String confirmationDate, String orderID, String trackingSpeed, String includeInSearch, String includeInSitemap, String showOrderID, String acceptMissingTicket) throws InterruptedException {
		
		reportStep(logger, "About to create CashbackStore", "INFO");

		String storeName 						=  this.enterCashbackStoreName(driver);
		String storeURLKey  					=  this.enterURLKey(driver);
		String storeStatus  					=  this.selectStatus(driver, strNewStore_StoreStatus);			
		String storeAffiliateNetwork  			=  this.selectAffiliateNetwork(driver, strNewStore_AffNetwork);
		String storeFullDescription 			=  this.enterFullDescription(driver);
		String storeAppFullDescription 			=  this.enterAppFullDescription(driver);
		String storeImageURL 					=  this.enterImageURL(driver, strnewStore_ImageURl);
		String storeLinkURL  					=  this.enterLinkURL(driver, strnewStore_LinkUrl);
		String storeDeepLinkURL 				=  this.enterDeepLink(driver, strnewStore_DeepLink);
		String storeUTMParameter 				=  this.enterUTMParameter(driver, strnewStore_UTMParameter);
		String storeType  						=  this.selectStoreTypeCashback(driver);
		String storeExitClick					=  this.enterExitClick(driver, strExitClickCount);
		String storeTCIntermediatePage 			=  this.enterTCIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeAppTCIntermediatePage 		=  this.enterTCAppIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeMissingCashbackTime			=  this.enterMissingCashbackTime(driver, missingCashbackTime);
		String storeconfirmationDate			=  this.enterCashbackExpectedConfirmationDays(driver, confirmationDate);
		String storeorderID						=  this.enterorderIDFormat(driver, orderID);
		String storetrackingSpeed				=  this.entertrackingSpeed(driver, trackingSpeed);
		String storeButtonText					=  this.enterButonText(driver, buttonText);
		String storeIncludeInSearch 			=  this.clickIncludeInSearch(driver, includeInSearch);
		String storeIncludeInSitemap			=  this.clickIncludeInSitemap(driver, includeInSitemap);
		String storeShowOrderID					=  this.clickShoworderID(driver, showOrderID);
		String storeAcceptMissingTicket			=  this.clickAcceptMissingTicket(driver, acceptMissingTicket);
		this.selectDeviceType(driver, str_DeviceName);
		
		reportStep(logger,"Assigning the newly created store values into an array", "PASS");
		
		String[] arrayCB_NewStoreDetails = new String[] {storeName, storeURLKey, storeStatus, storeAffiliateNetwork , "", 
				storeFullDescription,storeImageURL,storeLinkURL,storeDeepLinkURL,storeUTMParameter,storeTCIntermediatePage,
				storeType, storeExitClick, "", storeAppFullDescription, storeAppTCIntermediatePage, storeMissingCashbackTime,
				storeconfirmationDate, storeorderID, storetrackingSpeed, storeButtonText, storeIncludeInSearch, storeIncludeInSitemap,
				storeShowOrderID, storeAcceptMissingTicket};
		
		reportStep(logger,"Successfully created CashbackStore", "PASS");
		
		return arrayCB_NewStoreDetails ;
	
	}

	/* Reward Store Creation */
	public String[] enterRewardStoreDetails(WebDriver driver,String strNewStore_StoreStatus,String strNewStore_AffNetwork,String strnewStore_ImageURl,String strnewStore_LinkUrl,String strnewStore_DeepLink,
			String strnewStore_UTMParameter,String strnewStore_TC_InterePage, String str_DeviceName, String strExitClickCount, String missingCashbackTime, String buttonText,
			String confirmationDate, String orderID, String trackingSpeed, String includeInSearch, String includeInSitemap, String showOrderID, String acceptMissingTicket) throws InterruptedException {
		
		reportStep(logger, "About to create RewardStore", "INFO");

		String storeName 					=  this.enterRewardStoreName(driver);
		String storeURLKey  				=  this.enterURLKey(driver);
		String storeStatus  				=  this.selectStatus(driver, strNewStore_StoreStatus);
		String storeAffiliateNetwork  		=  this.selectAffiliateNetwork(driver, strNewStore_AffNetwork);	
		String storeFullDescription 		=  this.enterFullDescription(driver);
		String storeImageURL 				=  this.enterImageURL(driver, strnewStore_ImageURl);
		String storeLinkURL  				=  this.enterLinkURL(driver, strnewStore_LinkUrl);
		String storeDeepLinkURL 			=  this.enterDeepLink(driver, strnewStore_DeepLink);
		String storeUTMParameter 			=  this.enterUTMParameter(driver, strnewStore_UTMParameter);
		String storeTCIntermediatePage 		=  this.enterTCIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeType  					=  this.selectStoreTypeRewards(driver);
		String storeExitClick				=  this.enterExitClick(driver, strExitClickCount);
		String storeAppFullDescription 		=  this.enterAppFullDescription(driver);
		String storeAppTCIntermediatePage	=  this.enterTCAppIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeMissingCashbackTime		=  this.enterMissingCashbackTime(driver, missingCashbackTime);
		String storeconfirmationDate		=  this.enterCashbackExpectedConfirmationDays(driver, confirmationDate);
		String storeorderID					=  this.enterorderIDFormat(driver, orderID);
		String storetrackingSpeed			=  this.entertrackingSpeed(driver, trackingSpeed);
		String storeButtonText				=  this.enterButonText(driver, buttonText);
		String storeIncludeInSearch 		=  this.clickIncludeInSearch(driver, includeInSearch);
		String storeIncludeInSitemap		=  this.clickIncludeInSitemap(driver, includeInSitemap);
		String storeShowOrderID				=  this.clickShoworderID(driver, showOrderID);
		String storeAcceptMissingTicket		=  this.clickAcceptMissingTicket(driver, acceptMissingTicket);
		this.selectDeviceType(driver, str_DeviceName);
		
		reportStep(logger,"Assigning the newly created store values into an array", "PASS");
		
		String[] arrayRW_NewStoreDetails = new String[] {storeName, storeURLKey, storeStatus, storeAffiliateNetwork , "" ,
				storeFullDescription,storeImageURL,storeLinkURL,storeDeepLinkURL,storeUTMParameter,storeTCIntermediatePage,
				storeType, storeExitClick, "", storeAppFullDescription, storeAppTCIntermediatePage, storeMissingCashbackTime,
				storeconfirmationDate, storeorderID, storetrackingSpeed, storeButtonText, storeIncludeInSearch, storeIncludeInSitemap,
				storeShowOrderID, storeAcceptMissingTicket};
		
		reportStep(logger,"Successfully created RewardStore", "PASS");
		
		return arrayRW_NewStoreDetails ;
	
	}

	/* Network18 Store Creation */
	public String[] enterNetwork18StoreDetails(WebDriver driver,String strNewStore_StoreStatus,String strNewStore_AffNetwork,String strnewStore_ImageURl,String strnewStore_LinkUrl,String strnewStore_DeepLink,
			String strnewStore_UTMParameter,String strnewStore_TC_InterePage, String str_DeviceName, String strExitClickCount, String missingCashbackTime, String buttonText,
			String confirmationDate, String orderID, String trackingSpeed, String includeInSearch, String includeInSitemap, String showOrderID, String acceptMissingTicket) throws InterruptedException {
		
		reportStep(logger, "About to create N18Store", "INFO");

		String storeName 					=  this.enterNetwork18StoreName(driver);
		String storeURLKey  				=  this.enterURLKey(driver);
		String storeStatus  				=  this.selectStatus(driver, strNewStore_StoreStatus);	
		String storeAffiliateNetwork  		=  this.selectAffiliateNetwork(driver, strNewStore_AffNetwork);
		String storeFullDescription 		=  this.enterFullDescription(driver);
		String storeImageURL 				=  this.enterImageURL(driver, strnewStore_ImageURl);
		String storeLinkURL  				=  this.enterLinkURL(driver, strnewStore_LinkUrl);
		String storeDeepLinkURL 			=  this.enterDeepLink(driver, strnewStore_DeepLink);
		String storeUTMParameter 			=  this.enterUTMParameter(driver, strnewStore_UTMParameter);
		String storeTCIntermediatePage 		=  this.enterTCIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeType  					=  this.selectStoreTypeCashback(driver);
		String storeExitClick				=  this.enterExitClick(driver, strExitClickCount);
		String storeAppFullDescription 		=  this.enterAppFullDescription(driver);
		String storeAppTCIntermediatePage	=  this.enterTCAppIntermediatePage(driver, strnewStore_TC_InterePage);
		String storeMissingCashbackTime		=  this.enterMissingCashbackTime(driver, missingCashbackTime);
		String storeconfirmationDate		=  this.enterCashbackExpectedConfirmationDays(driver, confirmationDate);
		String storeorderID					=  this.enterorderIDFormat(driver, orderID);
		String storetrackingSpeed			=  this.entertrackingSpeed(driver, trackingSpeed);
		String storeButtonText				=  this.enterButonText(driver, buttonText);
		String storeIncludeInSearch 		=  this.clickIncludeInSearch(driver, includeInSearch);
		String storeIncludeInSitemap		=  this.clickIncludeInSitemap(driver, includeInSitemap);
		String storeShowOrderID				=  this.clickShoworderID(driver, showOrderID);
		String storeAcceptMissingTicket		=  this.clickAcceptMissingTicket(driver, acceptMissingTicket);
		this.selectDeviceType(driver, str_DeviceName);
		
		reportStep(logger,"Assigning the newly created store values into an array", "PASS");
		
		String[] arrayN18_NewStoreDetails = new String[] {storeName, storeURLKey, storeStatus, storeAffiliateNetwork, "" ,
				storeFullDescription,storeImageURL,storeLinkURL,storeDeepLinkURL,storeUTMParameter,storeTCIntermediatePage,
				storeType, storeExitClick, "", storeAppFullDescription, storeAppTCIntermediatePage, storeMissingCashbackTime,
				storeconfirmationDate, storeorderID, storetrackingSpeed, storeButtonText, storeIncludeInSearch, storeIncludeInSitemap,
				storeShowOrderID, storeAcceptMissingTicket};
		
		reportStep(logger,"Successfully created N18Store", "PASS");
	
		return arrayN18_NewStoreDetails ;
	
	}

	
	//******************************************************************** Catergory Tab  *****************************************************************
		
	/* Select Category */
	public void clickCategoryCheckbox(WebDriver driver) throws InterruptedException, AWTException {

		reportStep(logger, "About to click category", "INFO");

		if(jsClickByXpath(driver, categoryPopularToday)) {

			reportStep(logger, "Successfully clicked category", "PASS");
		}else {

			reportStep(logger, "Not able to click category", "FAIL");
		}

		if(jsClickUsingID(driver, categoryOne)) {

			reportStep(logger, "Successfully clicked categoryOne", "PASS");
		}else {

			reportStep(logger, "Not able to click categoryOne", "FAIL");
		}
		


		if(jsClickUsingID(driver, categoryTwo)) {

			reportStep(logger, "Successfully clicked categoryTwo", "PASS");
		}else {

			reportStep(logger, "Not able to click categoryTwo", "FAIL");
		}
		


		if(jsClickUsingID(driver, categoryThree)) {

			reportStep(logger, "Successfully clicked categoryThree", "PASS");
		}else {

			reportStep(logger, "Not able to click categoryThree", "FAIL");
		}
	}
			
	//******************************************************************* SEO Tab *************************************************************************
	
	/* Enter Keyword */
	public String enterKeywordsDetails(WebDriver driver, String strTextToEnter_Keywords_Details) throws InterruptedException {
		
		reportStep(logger, "About to enter store keyword: "+strTextToEnter_Keywords_Details, "INFO");		
		
		if(enterTextByID(driver, textarea_Keywords, strTextToEnter_Keywords_Details)) {

			reportStep(logger, "Successfully entered store keyword: "+strTextToEnter_Keywords_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store keyword: "+strTextToEnter_Keywords_Details, "FAIL");
		}
		
		return strTextToEnter_Keywords_Details ;
		
	}
	
	/* Enter Meta tags */
	public String enterMetaTags(WebDriver driver, String strTextToEnter_Meta_Tags_Details) throws InterruptedException {

		reportStep(logger, "About to enter store metaTags: "+strTextToEnter_Meta_Tags_Details, "INFO");		
		
		if(enterTextByID(driver, textarea_Meta_Tags, "<title>"+strTextToEnter_Meta_Tags_Details+"</title>")) {

			reportStep(logger, "Successfully entered store metaTags: "+strTextToEnter_Meta_Tags_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store metaTags: "+strTextToEnter_Meta_Tags_Details, "FAIL");
		}
		
		return strTextToEnter_Meta_Tags_Details ;
		
	}
	
	/* Enter Product Meta Tags */
	public String enterProductMetaTags(WebDriver driver, String strTextToEnter_newStore_Input_Product_Meta_Tags_Details) throws InterruptedException {

		reportStep(logger, "About to enter store productMetaTags: "+strTextToEnter_newStore_Input_Product_Meta_Tags_Details, "INFO");		
		
		if(enterTextByID(driver, textarea_Product_Meta_Tags, "<title>"+strTextToEnter_newStore_Input_Product_Meta_Tags_Details+"</title>")) {

			reportStep(logger, "Successfully entered store productMetaTags: "+strTextToEnter_newStore_Input_Product_Meta_Tags_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store productMetaTags: "+strTextToEnter_newStore_Input_Product_Meta_Tags_Details, "FAIL");
		}
		
		return strTextToEnter_newStore_Input_Product_Meta_Tags_Details ;
		
	}
	
	/* Enter Social Media Message */
	public String enterSocialMediaMessageDetails(WebDriver driver, String strTextToEnter_Social_Media_Message_Details) throws InterruptedException {

		reportStep(logger, "About to enter store socialMediaMessage: "+strTextToEnter_Social_Media_Message_Details, "INFO");		
		
		if(enterTextByID(driver, textarea_Social_Media_Message, strTextToEnter_Social_Media_Message_Details)) {

			reportStep(logger, "Successfully entered store socialMediaMessage: "+strTextToEnter_Social_Media_Message_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store socialMediaMessage: "+strTextToEnter_Social_Media_Message_Details, "FAIL");
		}
		
		return strTextToEnter_Social_Media_Message_Details ;
		
	}
		
	//**************************************************************** Primary CB Tab *********************************************************************

	/* Select Cashback Type */
	public String selectCashbackType(WebDriver driver, String strSelect_PCB_Cashback_Type) throws InterruptedException {

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, select_Cashback_Type, strSelect_PCB_Cashback_Type)) {

			reportStep(logger, "Successfully selected value "+strSelect_PCB_Cashback_Type+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strSelect_PCB_Cashback_Type+" from dropdown", "FAIL");
		}
		
		return strSelect_PCB_Cashback_Type;
	}
	
	/* Enter Normal Network Commision */
	public int enterNormalNetworkCommission(WebDriver driver,int intPCB_Nor_NTW_Commission) throws InterruptedException {

		reportStep(logger, "About to enter store normal primary cashback network commision: "+intPCB_Nor_NTW_Commission, "INFO");		
		
		if(enterTextByID(driver, input_Cashback_Network_Commission, intPCB_Nor_NTW_Commission)) {

			reportStep(logger, "Successfully entered store normal primary cashback network commision: "+intPCB_Nor_NTW_Commission, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal primary cashback network commision: "+intPCB_Nor_NTW_Commission, "FAIL");
		}
		
		return intPCB_Nor_NTW_Commission ;
		
	}
	
	/* Enter Normal Cashback Percentage */
	public int enterNormalCashbackPercentage(WebDriver driver,int intPCB_Nor_CB_Percentage) throws InterruptedException {

		reportStep(logger, "About to enter store normal primary cashback percentage: "+intPCB_Nor_CB_Percentage, "INFO");		
		
		if(enterTextByID(driver, input_Cashback_Percentage, intPCB_Nor_CB_Percentage)) {

			reportStep(logger, "Successfully entered store normal primary cashback percentage: "+intPCB_Nor_CB_Percentage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal primary cashback percentage: "+intPCB_Nor_CB_Percentage, "FAIL");
		}
		
		return intPCB_Nor_CB_Percentage ;
		
	}
	
	/* Get Normal Cashback */
	public int getNormalCashback(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to get normal primary cashback populated", "INFO");		

		String normalCashbackText = getAttributeByID(driver, input_Cashback);
		int normalCashbackValue = Integer.valueOf(normalCashbackText);
		
		reportStep(logger,"Successfully got normal primary cashback populated: "+normalCashbackValue, "PASS");
		
		return normalCashbackValue;
	}
	
	/* Enter Normal Cashback Detail */
	public String enterNormalCashbackDetails(WebDriver driver ,String strPCB_Nor_Details) throws InterruptedException {
		
		reportStep(logger, "About to enter store normal primary cashback details: "+strPCB_Nor_Details, "INFO");		
		
		if(enterTextByID(driver, textaretab_Cashback_Details, strPCB_Nor_Details)) {

			reportStep(logger, "Successfully entered store normal primary cashback details: "+strPCB_Nor_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal primary cashback details: "+strPCB_Nor_Details, "FAIL");
		}
		
		return strPCB_Nor_Details ;
		
	}

	/* Enter Normal Short Description */
	public String enterNormalShortDescription(WebDriver driver) throws InterruptedException {
		
		String normalShortDescription = ("This Is Test User Entering Normal Short Description:"+threadLocalValue_CurrentDate );
				
		reportStep(logger, "About to enter store normal short description: "+normalShortDescription, "INFO");		
		
		if(enterTextByID(driver, shortDescription_TextField, normalShortDescription)) {

			reportStep(logger, "Successfully entered store normal short description: "+normalShortDescription, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal short description: "+normalShortDescription, "FAIL");
		}
		
		return normalShortDescription ;
	}
	
	/* Enter Normal App Short Description */
	public String enterNormalAppShortDescription(WebDriver driver) throws InterruptedException {
		
		String normalAppShortDescription = ("This Is Test User Entering Normal App Short Description: "+threadLocalValue_CurrentDate );
				
		reportStep(logger, "About to enter store normal app short description: "+normalAppShortDescription, "INFO");		
		
		if(enterTextByID(driver, appShortDescription_TextField, normalAppShortDescription)) {

			reportStep(logger, "Successfully entered store app normal short description: "+normalAppShortDescription, "PASS");
		}else {

			reportStep(logger, "Not able to enter store app normal short description: "+normalAppShortDescription, "FAIL");
		}
		
		return normalAppShortDescription ;
	}

	/* Enter Calendar Cashback Network Commision */
	public int enterCalendarNetworkCommission(WebDriver driver, int strPCB_Cal_NTW_Commission ) throws InterruptedException {

		reportStep(logger, "About to enter store calendar primary cashback network commision: "+strPCB_Cal_NTW_Commission, "INFO");		
		
		if(enterTextByID(driver, input_Calendar_Cashback_Network_Commission, strPCB_Cal_NTW_Commission)) {

			reportStep(logger, "Successfully entered store calendar primary cashback network commision: "+strPCB_Cal_NTW_Commission, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar primary cashback network commision: "+strPCB_Cal_NTW_Commission, "FAIL");
		}
		
		return strPCB_Cal_NTW_Commission ;
		
	}
		
	/* Enter Calendar Cashback Percentage */
	public int enterCalendarCashbackPercentage(WebDriver driver,int strPCB_Cal_CB_Percentage) throws InterruptedException {

		reportStep(logger, "About to enter store calendar primary cashback percentage: "+strPCB_Cal_CB_Percentage, "INFO");		
		
		if(enterTextByID(driver, input_Calendar_Cashback_Cashback_Percentage, strPCB_Cal_CB_Percentage)) {

			reportStep(logger, "Successfully entered store calendar primary cashback percentage: "+strPCB_Cal_CB_Percentage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar primary cashback percentage: "+strPCB_Cal_CB_Percentage, "FAIL");
		}
		
		return strPCB_Cal_CB_Percentage;
		
	}
	
	/* Enter Calendar Cashback */
	public int getCalendarCashback(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to get calendar primary cashback populated", "INFO");		

		String calendarCashbackText = getAttributeByID(driver, input_Calendar_Cashback_Value);
		int calendarCashbackValue = Integer.valueOf(calendarCashbackText);
		
		reportStep(logger,"Successfully got calendar primary cashback populated: "+calendarCashbackValue, "PASS");
		
		return calendarCashbackValue ;
		
	}
	
	/* Enter Calendar Cashback Detail */
	public String enterCalendarCashbackDetails(WebDriver driver,String strPCB_Cal_details) throws InterruptedException {
		
		reportStep(logger, "About to enter store calendar primary cashback details: "+strPCB_Cal_details, "INFO");		
		
		if(enterTextByID(driver, textaretab_Calendar_Cashback_Details, strPCB_Cal_details)) {

			reportStep(logger, "Successfully entered store calendar primary cashback details: "+strPCB_Cal_details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar primary cashback details: "+strPCB_Cal_details, "FAIL");
		}
		
		return strPCB_Cal_details ;
		
	}

	/* Enter Calendar Short Description */
	public String enterCalendarShortDescription(WebDriver driver) throws InterruptedException {
		
		String calendarShortDescription = ("This Is Test User Entering Calendar Short Description:"+threadLocalValue_CurrentDate );
				
		reportStep(logger, "About to enter store calendar short description: "+calendarShortDescription, "INFO");		
		
		if(enterTextByID(driver, calendarShortDescription_TextField, calendarShortDescription)) {

			reportStep(logger, "Successfully entered store calendar short description: "+calendarShortDescription, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar short description: "+calendarShortDescription, "FAIL");
		}
		
		return calendarShortDescription ;
	}
	
	/* Enter Calendar App Short Description */
	public String enterCalendarAppShortDescription(WebDriver driver) throws InterruptedException {
		
		String calendarAppShortDescription = ("This Is Test User Entering Calendar App Short Description:"+threadLocalValue_CurrentDate );
				
		reportStep(logger, "About to enter store calendar app short description: "+calendarAppShortDescription, "INFO");		
		
		if(enterTextByID(driver, calendarAppShortDescription_TextField, calendarAppShortDescription)) {

			reportStep(logger, "Successfully entered store calendar app short description: "+calendarAppShortDescription, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar app short description: "+calendarAppShortDescription, "FAIL");
		}
		
		return calendarAppShortDescription ;
	}

	/* Select Offer Type */
	public String selectOfferType(WebDriver driver ,String strCB_Offer_Type) throws InterruptedException {

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, select_Cashback_Offer_Type, strCB_Offer_Type)) {

			reportStep(logger, "Successfully selected value "+strCB_Offer_Type+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strCB_Offer_Type+" from dropdown", "FAIL");
		}
		
		return strCB_Offer_Type;
	}
	
	/* Set Issue Date */
	public void setIssueDate_PreviousDayFromCurrentDate(WebDriver driver) throws InterruptedException {

		String id = "calendar_issuedate";
		String date = Utils.previousDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Set Expiry Date */
	public void setExpiryDate_FourDaysFromCurrentDate(WebDriver driver) throws InterruptedException {

		String id = "calendar_expirydate";
		String date = Utils.currentDateAfter4days();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}

	/* Set Issue Date */
	public void setIssueDate_CurrentDate(WebDriver driver) throws InterruptedException {

		String id = "calendar_issuedate";
		String date = Utils.setCurrentDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Set Expiry Date */
	public void setExpireDate_CurrentDate(WebDriver driver) throws InterruptedException {
		
		String id = "calendar_expirydate";
		String date = Utils.setCurrentDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Get Issue Date */
	public String getIssueDate(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to get calendar primary cashback issue date", "INFO");		

		String calendarIssueDate = getAttributeByID(driver, issueDate);
		
		reportStep(logger,"Successfully got calendar primary cashback issue date: "+calendarIssueDate, "PASS");
		
		return calendarIssueDate;
	}
	
	/* Get Issue Time */
	public String getIssueTime(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to get calendar primary cashback issue time", "INFO");		

		String calendarIssueTime = getAttributeByID(driver, issueTime);
		
		reportStep(logger,"Successfully got calendar primary cashback issue time: "+calendarIssueTime, "PASS");
		
		return calendarIssueTime;
	}
	
	/* Get Expiry Date */
	public String getExpiryDate(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to get calendar primary cashback expiry date", "INFO");		

		String calendarExpiryDate = getAttributeByID(driver, expiryDate);
		
		reportStep(logger,"Successfully got calendar primary cashback expiry date: "+calendarExpiryDate, "PASS");
		
		return calendarExpiryDate;
	}
	
	/* Get Expiry Time */
	public String getExpiryTime(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to get calendar primary cashback expiry time", "INFO");		

		String calendarExpiryTime = getAttributeByID(driver, expiryTime);
		
		reportStep(logger,"Successfully got calendar primary cashback expiry time: "+calendarExpiryTime, "PASS");
		
		return calendarExpiryTime;
	}

	public void setExpiryTimeMinutesSecondsPrimaryCashback(WebDriver driver) throws InterruptedException{

		reportStep(logger, "About to set the expiry time", "INFO");

		String timerValue = getTextByXpath(driver, str_Timer);
		StringUtils.substringBefore(timerValue, "(BST)").trim();
		
		Date objDate = new Date();
		DateFormat objDateFormat = new SimpleDateFormat("HH");
		objDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime = objDateFormat.format(objDate); 
		int int_Hour = Integer.parseInt(txnDateTime)-1;		
		String string_Hours =String.valueOf(int_Hour);  

		reportStep(logger, "Hours ::: "+string_Hours, "PASS");
		
		Date objDate1 = new Date();
		DateFormat objDateFormat1 = new SimpleDateFormat("mm");
		objDateFormat1.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime1 = objDateFormat1.format(objDate1); 
		int int_Minutes = Integer.parseInt(txnDateTime1)+12;		
		String string_Minutes =String.valueOf(int_Minutes);  

		reportStep(logger, "Minutes ::: "+string_Minutes, "PASS");
		
		set_Expiry_Time(driver, str_Expiry_Time_Pcb, string_Hours, string_Minutes);

		reportStep(logger, "Sucessfully set the expiry time", "PASS");

	}

	public void setExpiryTimeHoursMinutesPrimaryCashback(WebDriver driver) throws InterruptedException{

		reportStep(logger, "About to set the expiry time", "INFO");

		String timerValue = getTextByXpath(driver, str_Timer);
		StringUtils.substringBefore(timerValue, "(BST)").trim();
		
		Date objDate = new Date();
		DateFormat objDateFormat = new SimpleDateFormat("HH");
		objDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime = objDateFormat.format(objDate); 
		int int_Hour = Integer.parseInt(txnDateTime)+5;		
		String string_Hours =String.valueOf(int_Hour);  

		reportStep(logger, "Hours ::: "+string_Hours, "PASS");

		Date objDate1 = new Date();
		DateFormat objDateFormat1 = new SimpleDateFormat("mm");
		objDateFormat1.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime1 = objDateFormat1.format(objDate1); 
		int int_Minutes = Integer.parseInt(txnDateTime1);		
		String string_Minutes =String.valueOf(int_Minutes);  

		reportStep(logger, "Minutes ::: "+string_Minutes, "PASS");
		
		set_Expiry_Time(driver, str_Expiry_Time_Pcb, string_Hours, string_Minutes);

		reportStep(logger, "Sucessfully set the expiry time", "PASS");

	}

	//*************************************************** Primary CB Creation ****************************************************************
	
	/* Enter Normal Primary Cashback */
	public Object[] enterNormalPrimaryCashbackDetails(WebDriver driver, String strSelect_PCB_Cashback_Type,String strPCB_Currency_Type,int intPCB_Nor_NTW_Commission,int intPCB_Nor_CB_Percentage,String strPCB_Nor_Details) throws InterruptedException {
		
		reportStep(logger,"About to create normal primary cashback details", "INFO");
		
		this.clickPrimaryCashbackTab(driver);
		this.selectCashbackType(driver,strSelect_PCB_Cashback_Type);		
		this.enterNormalNetworkCommission(driver,intPCB_Nor_NTW_Commission);
		this.enterNormalCashbackPercentage(driver,intPCB_Nor_CB_Percentage);
		this.enterNormalCashbackDetails(driver,strPCB_Nor_Details);
		int intPCB_Nor_CB	= this.getNormalCashback(driver);
		String normalShortDescription = this.enterNormalShortDescription(driver);
		String normalAppShortDescription = this.enterNormalAppShortDescription(driver);
		
		reportStep(logger,"Assigning the newly created store normal PCB values into an array", "PASS");
		
		Object[] arrayNewStore_Nor_PCBDetails = new Object[] {strSelect_PCB_Cashback_Type,strPCB_Currency_Type, intPCB_Nor_NTW_Commission,intPCB_Nor_CB_Percentage,
				strPCB_Nor_Details,intPCB_Nor_CB,normalShortDescription,normalAppShortDescription};
		
		reportStep(logger, "Successfully created Normal primary cashback details", "PASS");
		
		return arrayNewStore_Nor_PCBDetails ;
	}
	
	/* Enter Calendar Primary Cashback */
	public Object[] enterCalendarPrimaryCashbackDetails(WebDriver driver ,String strSelect_PCB_Cashback_Type,String strPCB_Currency_Type ,int strPCB_Cal_NTW_Commission,int strPCB_Cal_CB_Percentage,String strCB_Offer_Type ,String strPCB_Cal_details) throws InterruptedException {
	
		reportStep(logger,"About to create calendar primary cashback details", "INFO");
		
		this.clickPrimaryCashbackTab(driver);
		this.selectCashbackType(driver,strSelect_PCB_Cashback_Type);		
		this.enterCalendarNetworkCommission(driver,strPCB_Cal_NTW_Commission);
		this.enterCalendarCashbackPercentage(driver,strPCB_Cal_CB_Percentage);
		this.selectOfferType(driver,strCB_Offer_Type);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);		
		this.setExpiryDate_FourDaysFromCurrentDate(driver);
		this.enterCalendarCashbackDetails(driver,strPCB_Cal_details);	
		int strPCB_Cal_CB = this.getCalendarCashback(driver);
		String normalShortDescription = this.enterNormalShortDescription(driver);
		String normalAppShortDescription = this.enterNormalAppShortDescription(driver);
		String calendarShortDescription = this.enterCalendarShortDescription(driver);
		String calendarAppShortDescription = this.enterCalendarAppShortDescription(driver);
				
		String strNewStore_Iss_DateTime = this.getIssueDate(driver).trim()+"T"+getIssueTime(driver).trim()+"Z";
		String strNewStore_Exp_DateTime = this.getExpiryDate(driver).trim()+"T"+getExpiryTime(driver).trim()+"Z";
		
		reportStep(logger,"Assigning the newly created store normal PCB values into an array", "PASS");
		Object[] arrayNewStore_Cal_PCBDetails = new Object[] {strSelect_PCB_Cashback_Type,strPCB_Currency_Type, strPCB_Cal_NTW_Commission,strPCB_Cal_CB_Percentage,
				strCB_Offer_Type,strPCB_Cal_details,strPCB_Cal_CB, strNewStore_Iss_DateTime, strNewStore_Exp_DateTime, 
				normalShortDescription, normalAppShortDescription, calendarShortDescription, calendarAppShortDescription};
		
		reportStep(logger, "Successfully created calendar primary cashback details", "PASS");
	
		return arrayNewStore_Cal_PCBDetails;
	}
	
	/* Enter Calendar Primary Cashback */
	public Object[] enterCalendarPrimaryCashbackDetails_ExpiryDateCurrentDate(WebDriver driver ,String strSelect_PCB_Cashback_Type,String strPCB_Currency_Type ,int strPCB_Cal_NTW_Commission,int strPCB_Cal_CB_Percentage,String strCB_Offer_Type ,String strPCB_Cal_details) throws InterruptedException {
		
		reportStep(logger,"About to create calendar primary cashback details", "INFO");
		
		this.clickPrimaryCashbackTab(driver);
		this.selectCashbackType(driver,strSelect_PCB_Cashback_Type);	
		this.enterCalendarNetworkCommission(driver,strPCB_Cal_NTW_Commission);
		this.enterCalendarCashbackPercentage(driver,strPCB_Cal_CB_Percentage);
		this.selectOfferType(driver,strCB_Offer_Type);
		this.setIssueDate_PreviousDayFromCurrentDate(driver);	
		this.setExpireDate_CurrentDate(driver);
		this.enterCalendarCashbackDetails(driver,strPCB_Cal_details);	
		float strPCB_Cal_CB = this.getCalendarCashback(driver);
		String normalShortDescription = this.enterNormalShortDescription(driver);
		String normalAppShortDescription = this.enterNormalAppShortDescription(driver);
		String calendarShortDescription = this.enterCalendarShortDescription(driver);
		String calendarAppShortDescription = this.enterCalendarAppShortDescription(driver);
		
		String strNewStore_Iss_DateTime = this.getIssueDate(driver).trim()+"T"+getIssueTime(driver).trim()+"Z";
		String strNewStore_Exp_DateTime = this.getExpiryDate(driver).trim()+"T"+getExpiryTime(driver).trim()+"Z";
		
		reportStep(logger,"Assigning the newly created store normal PCB values into an array", "PASS");
		Object[] arrayNewStore_Cal_PCBDetails = new Object[] {strSelect_PCB_Cashback_Type,strPCB_Currency_Type, strPCB_Cal_NTW_Commission,strPCB_Cal_CB_Percentage,strCB_Offer_Type,
				strPCB_Cal_details,strPCB_Cal_CB, strNewStore_Iss_DateTime, strNewStore_Exp_DateTime, 
				normalShortDescription, normalAppShortDescription, calendarShortDescription, calendarAppShortDescription};
		
		reportStep(logger, "Successfully created calendar primary cashback details", "PASS");
		
		return arrayNewStore_Cal_PCBDetails;
	}
		
	//****************************************************** Secondary CB Tab ******************************************************************
	
	/* Select Cashback Type */
	public String selectCashbackType(WebDriver driver, int intSCB_GUI_Index, String strSCB_CBType) throws InterruptedException {
		
		String normalCashbackType = "csh_type"+intSCB_GUI_Index+"";

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, normalCashbackType, strSCB_CBType)) {

			reportStep(logger, "Successfully selected value "+strSCB_CBType+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strSCB_CBType+" from dropdown", "FAIL");
		}
		
		return strSCB_CBType;
		
	}
		
	/* Enter Normal Secondary Cashback */
	public int enterNormalSecondaryCashback(WebDriver driver, int intSCB_GUI_Index, int strSCB_CB) throws InterruptedException {

		String normalCashbackType = "csh_cashback_"+intSCB_GUI_Index+"";
		
		reportStep(logger, "About to enter store normal secondary cashback: "+strSCB_CB, "INFO");		
		
		if(enterTextByID(driver, normalCashbackType, strSCB_CB)) {

			reportStep(logger, "Successfully entered store normal secondary cashback: "+strSCB_CB, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal secondary cashback: "+strSCB_CB, "FAIL");
		}
		
		return strSCB_CB ;
		
	}
	
	/* Enter Normal Secondary Cashback Details */
	public String enterNormalSecondaryCashbackDetails(WebDriver driver, int intSCB_GUI_Index, String strSCB_Details) throws InterruptedException {

		String normalCashbackDetails = "csh_detail_"+intSCB_GUI_Index+"";
		
		reportStep(logger, "About to enter store normal secondary cashback details: "+strSCB_Details, "INFO");		
		
		if(enterTextByID(driver, normalCashbackDetails, strSCB_Details)) {

			reportStep(logger, "Successfully entered store normal secondary cashback details: "+strSCB_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal secondary cashback details: "+strSCB_Details, "FAIL");
		}
		
		return strSCB_Details ;
		
	}
	
	/* Select Normal Secondary Cashback Type */
	public String selectCalendarCashbackType(WebDriver driver, int intSCB_GUI_Index , String strSCB_CBType) throws InterruptedException {
		
		String calendarCashbackType = "calendar_csh_type"+intSCB_GUI_Index+"";

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, calendarCashbackType, strSCB_CBType)) {

			reportStep(logger, "Successfully selected value "+strSCB_CBType+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strSCB_CBType+" from dropdown", "FAIL");
		}
		
		return strSCB_CBType;
		
	}
	
	/* Enter Calendar Secondary Cashback */
	public int enterCalenderSecondaryCashback(WebDriver driver,int intSCB_GUI_Index , int strSCB_Cal_CB) throws InterruptedException {

		String calendarSecondaryCashback = "calendar_csh_cashback_"+intSCB_GUI_Index+"";
		
		reportStep(logger, "About to enter store normal secondary cashback: "+strSCB_Cal_CB, "INFO");		
		
		if(enterTextByID(driver, calendarSecondaryCashback, strSCB_Cal_CB)) {

			reportStep(logger, "Successfully entered store normal secondary cashback: "+strSCB_Cal_CB, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal secondary cashback: "+strSCB_Cal_CB, "FAIL");
		}
		
		return strSCB_Cal_CB ;
		
	}
	
	/* Enter Calendar Secondary Cashback Details */
	public String enterCalendarSecondaryCashbackDetails(WebDriver driver ,int intSCB_GUI_Index, String strSCB_Cal_Details) throws InterruptedException {

		String calendarCashbackDetails = "calendar_csh_detail_"+intSCB_GUI_Index+"";
		
		reportStep(logger, "About to enter store normal secondary cashback details: "+strSCB_Cal_Details, "INFO");		
		
		if(enterTextByID(driver, calendarCashbackDetails, strSCB_Cal_Details)) {

			reportStep(logger, "Successfully entered store normal secondary cashback details: "+strSCB_Cal_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal secondary cashback details: "+strSCB_Cal_Details, "FAIL");
		}
		
		return strSCB_Cal_Details ;
		
	}
	
	/* Enter Calendar Secondary Cashback Offer Type */
	public String selectCashbackOfferType(WebDriver driver,int intSCB_GUI_Index,String strCB_Offer_Type) throws InterruptedException {

		String calendarCashbackType = "cashback_offer_type_"+intSCB_GUI_Index+"";

		reportStep(logger, "About to select value from dropdown", "INFO");

		if(selectValuesFromDropdownUsingID(driver, calendarCashbackType, strCB_Offer_Type)) {

			reportStep(logger, "Successfully selected value "+strCB_Offer_Type+" from dropdown", "PASS");
		}else {

			reportStep(logger, "Not able to select value "+strCB_Offer_Type+" from dropdown", "FAIL");
		}
		
		return strCB_Offer_Type;
	}
	
	/* Set IssueDate */
	public void setIssueDate_SecondaryCashback_PreviousDayFromCurrentDate(WebDriver driver,int intSCB_GUI_Index) throws InterruptedException {

		String id = "calendar_issuedate_Cashback_0";
		String date = Utils.previousDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Set ExpiryDate */
	public void setExpiryDate_SecondaryCashback_FourDaysFromCurrentDate(WebDriver driver,int intSCB_GUI_Index) throws InterruptedException {

		String id = "calendar_expirydate_Cashback_"+intSCB_GUI_Index+"";
		String date = Utils.currentDateAfter4days();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}

	/* Set IssueDate */
	public void setIssueDate_SecondaryCashback_CurrentDate(WebDriver driver,int intSCB_GUI_Index) throws InterruptedException {

		String id = "calendar_issuedate_Cashback_"+intSCB_GUI_Index+"";
		String date = Utils.setCurrentDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Set ExpiryDate */
	public void setExpireDate_SecondaryCashback_CurrentDate(WebDriver driver,int intSCB_GUI_Index) throws InterruptedException {
		
		String id = "calendar_expirydate_Cashback_"+intSCB_GUI_Index+"";
		String date = Utils.setCurrentDate();
		
		reportStep(logger, "About to set date value: "+date+" using id: "+id, "INFO");

		jsSetValue(driver, id, date);

		reportStep(logger, "Successfully set date value: "+date+" using id: "+id, "PASS");

	}
	
	/* Click Add Another Row */
	public void clickAddAnotherRow(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click add another row button", "INFO");

		if(jsClickByXpath(driver, button_Add_another_row)) {

			reportStep(logger, "Successfully clicked add another row button", "PASS");
		}else {

			reportStep(logger, "Not able to click add another row button", "FAIL");
		}

	}

	/* get Store Type */
	public String getStoreType(WebDriver driver, String str_StoreName) throws InterruptedException {
		
		String xpath = "//td[@title='"+str_StoreName+"']/following::td[5]";
		
		String storeType = getTextByXpath(driver, xpath);
		
		return storeType;

	}

	/* Click Device Type */
	public String clickSecondaryCashbackDeviceTypeDesktop(WebDriver driver, int index) throws InterruptedException {	

		String deviceType = "Desktop";
		
		String id = "device_type_desktop_"+index+"";

		reportStep(logger, "About to click device type for secondary cashback", "INFO");

		if(jsClickUsingID(driver, id)) {

			reportStep(logger, "Successfully clicked device type for secondary cashback", "PASS");
		}else {

			reportStep(logger, "Not able to click device type for secondary cashback", "FAIL");
		}
		
		return deviceType;
	}
	
	/* Click Device Type */
	public String clickSecondaryCashbackDeviceTypeMobile(WebDriver driver, int index) throws InterruptedException {

		String deviceType = "Mobile";
		
		String id = "device_type_mobile_"+index+"";

		reportStep(logger, "About to click device type for secondary cashback", "INFO");

		if(jsClickUsingID(driver, id)) {

			reportStep(logger, "Successfully clicked device type for secondary cashback", "PASS");
		}else {

			reportStep(logger, "Not able to click device type for secondary cashback", "FAIL");
		}
		
		return deviceType;
	}
	
	/* Click Device Type */
	public String clickSecondaryCashbackDeviceTypeTablet(WebDriver driver, int index) throws InterruptedException {

		String deviceType = "Tablet";
		
		String id = "device_type_tablet_"+index+"";

		reportStep(logger, "About to click device type for secondary cashback", "INFO");

		if(jsClickUsingID(driver, id)) {

			reportStep(logger, "Successfully clicked device type for secondary cashback", "PASS");
		}else {

			reportStep(logger, "Not able to click device type for secondary cashback", "FAIL");
		}
		
		return deviceType;
	}
	
	/* Click Device Type */
	public String clickSecondaryCashbackDeviceTypeApp(WebDriver driver, int index) throws InterruptedException {

		String deviceType = "App";
		
		String id = "device_type_app_"+index+"";

		reportStep(logger, "About to click device type for secondary cashback", "INFO");

		if(jsClickUsingID(driver, id)) {

			reportStep(logger, "Successfully clicked device type for secondary cashback", "PASS");
		}else {

			reportStep(logger, "Not able to click device type for secondary cashback", "FAIL");
		}
		
		return deviceType;
	}

	/* Click Device Type */
	public void clickSecondaryCashbackDeviceType(WebDriver driver, String str_DeviceName, int index) throws InterruptedException{

		reportStep(logger,"About to select device type: "+str_DeviceName, "INFO");

		String string_DeviceName = str_DeviceName;

		switch (string_DeviceName) {

		case "All": {

			this.clickSecondaryCashbackDeviceTypeApp(driver, index);
			this.clickSecondaryCashbackDeviceTypeDesktop(driver, index);
			this.clickSecondaryCashbackDeviceTypeMobile(driver, index);
			this.clickSecondaryCashbackDeviceTypeTablet(driver, index);


		}
		break;

		case "Desktop": {

			this.clickSecondaryCashbackDeviceTypeDesktop(driver, index);

		}
		break;

		case "Mobile": {

			this.clickSecondaryCashbackDeviceTypeMobile(driver, index);

		}
		break;

		case "Tablet": {

			this.clickSecondaryCashbackDeviceTypeTablet(driver, index);
		}
		break;

		case "App": {

			this.clickSecondaryCashbackDeviceTypeApp(driver, index);
		}
		break;
		}

		reportStep(logger,"Sucessfully selected device type: "+str_DeviceName, "PASS");

	}

	/* Click Home Icon */
	public void clickHomeIcon(WebDriver driver, String str_StoreName){
		
		String homeIcon = "//td[@title='"+str_StoreName+"']/following::td[10]/following::td/a";

		reportStep(logger, "About to click homeIcon button", "INFO");

		if(jsClickByXpath(driver, homeIcon)) {

			reportStep(logger, "Successfully clicked homeIcon button", "PASS");
		}else {

			reportStep(logger, "Not able to click homeIcon button", "FAIL");
		}
	}

	/* Click Pick Of The Day */
	public void clickPickOfTheDay(WebDriver driver){

		reportStep(logger, "About to click pickOfTheDay button", "INFO");

		if(jsClickByXpath(driver, checkbox_PickOfDay)) {

			reportStep(logger, "Successfully clicked pickOfTheDay button", "PASS");
		}else {

			reportStep(logger, "Not able to click pickOfTheDay button", "FAIL");
		}
	}

	/* Click Pick Of The Week */
	public void clickPickOfTheWeek(WebDriver driver){

		reportStep(logger, "About to click pickOfTheDay button", "INFO");

		if(jsClickByXpath(driver, checkbox_PickOfWeek)) {

			reportStep(logger, "Successfully clicked pickOfTheDay button", "PASS");
		}else {

			reportStep(logger, "Not able to click pickOfTheDay button", "FAIL");
		}
	}

	/* Click Update */
	public void clickUpdate(WebDriver driver){

		reportStep(logger, "About to click update button", "INFO");

		if(jsClickByXpath(driver, button_Update)) {

			reportStep(logger, "Successfully clicked update button", "PASS");
		}else {

			reportStep(logger, "Not able to click update button", "FAIL");
		}
	}

	/* Click Pick Of The Day & Week */
	public void clickPickOfTheDayPickOfTheWeek_SpecificStore(WebDriver driver, String str_StoreName){

		reportStep(logger,"About to select pick of day and pick of week...", "INFO");
		
		this.clickHomeIcon(driver, str_StoreName);
		this.clickPickOfTheDay(driver);
		this.clickPickOfTheWeek(driver);
		this.clickUpdate(driver);
		
		reportStep(logger,"Successfully selected pick of day and pick of week...", "PASS");
	}

	/* Get Secondary Cashback ID */
	public String getSecondaryCashbackID(WebDriver driver, int intIndex){

		reportStep(logger,"About to get secondary cashback id...", "INFO");
		
		isElementLocatedByXpathPresent(driver, "(//a[@class='btn btn-danger icn-only'])["+intIndex+"]");
		String strSecondaryCashback_Id = driver.findElement(By.xpath("(//a[@class='btn btn-danger icn-only'])["+intIndex+"]")).getAttribute("onclick");
		String strSecondaryCashbackId = StringUtils.substringBetween(strSecondaryCashback_Id, "return deleteRow('trid0',", ");");
		
		reportStep(logger,"Successfully retrieved secondary cashback id", "PASS");
		
		return strSecondaryCashbackId;
		
	}

	/* Get Issue Date */
	public String getIssueDate_SecondaryCashback(WebDriver driver) throws InterruptedException {

		String issueDate = "//input[@id='calendar_issuedate_Cashback_0'][@name='calendar_issuedate_Cashback_0']";

		reportStep(logger, "About to get calendar secondary cashback issue date", "INFO");		

		String calendarSecondaryIssueDate = getAttributeByXpath(driver, issueDate);
		
		reportStep(logger,"Successfully got calendar secondary cashback issue date: "+calendarSecondaryIssueDate, "PASS");
		
		return calendarSecondaryIssueDate;
	}
	
	/* Get Issue Time */
	public String getIssueTime_SecondaryCashback(WebDriver driver) throws InterruptedException {

		String issueTime = "//input[@id='calendar_issuetime_Cashback_0'][@name='calendar_issuetime_Cashback_0']";

		reportStep(logger, "About to get calendar secondary cashback issue time", "INFO");		

		String calendarSecondaryIssueTime = getAttributeByXpath(driver, issueTime);
		
		reportStep(logger,"Successfully got calendar secondary cashback issue time: "+calendarSecondaryIssueTime, "PASS");
		
		return calendarSecondaryIssueTime;
	}
	
	/* Get Expiry Date */
	public String getExpiryDate_SecondaryCashback(WebDriver driver) throws InterruptedException {

		String expiryDate = "//input[@id='calendar_expirydate_Cashback_0'][@name='calendar_expirydate_Cashback_0']";

		reportStep(logger, "About to get calendar secondary cashback expiry date", "INFO");		

		String calendarSecondaryExpiryDate = getAttributeByXpath(driver, expiryDate);
		
		reportStep(logger,"Successfully got calendar secondary cashback expiry date: "+calendarSecondaryExpiryDate, "PASS");
		
		return calendarSecondaryExpiryDate;
	}
	
	/* Get Expiry Time */
	public String getExpiryTime_SecondaryCashback(WebDriver driver) throws InterruptedException {

		String expiryTime = "//input[@id='calendar_expirytime_Cashback_0'][@name='calendar_expirytime_Cashback_0']";

		reportStep(logger, "About to get calendar secondary cashback expiry time", "INFO");		

		String calendarSecondaryExpiryTime = getAttributeByXpath(driver, expiryTime);
		
		reportStep(logger,"Successfully got calendar secondary cashback expiry time: "+calendarSecondaryExpiryTime, "PASS");
		
		return calendarSecondaryExpiryTime;
	
	}

	/* Set Expiry Time */
	public void setExpiryTimeHoursMinutesSecondarCashback(WebDriver driver) throws InterruptedException{

		reportStep(logger, "About to set the expiry time", "INFO");

		String timerValue = getTextByXpath(driver, str_Timer);
		StringUtils.substringBefore(timerValue, "(BST)").trim();
		
		Date objDate = new Date();
		DateFormat objDateFormat = new SimpleDateFormat("HH");
		objDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime = objDateFormat.format(objDate); 
		int int_Hour = Integer.parseInt(txnDateTime)+5;		
		String string_Hours =String.valueOf(int_Hour);  

		reportStep(logger, "Hour ::: "+string_Hours, "PASS");

		Date objDate1 = new Date();
		DateFormat objDateFormat1 = new SimpleDateFormat("mm");
		objDateFormat1.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime1 = objDateFormat1.format(objDate1); 
		int int_Minutes = Integer.parseInt(txnDateTime1);		
		String string_Minutes =String.valueOf(int_Minutes);  

		reportStep(logger, "Minutes ::: "+string_Minutes, "PASS");
		
		set_Expiry_Time(driver, str_Expiry_Time_Scb, string_Hours, string_Minutes);

		reportStep(logger, "Sucessfully set the expiry time", "PASS");
	}

	/* Set Expiry Time */
	public void setExpiryTimeMinutesSecondsSecondaryCashback(WebDriver driver) throws InterruptedException{

		reportStep(logger, "About to set the expiry time", "INFO");

		String timerValue = getTextByXpath(driver, str_Timer);
		StringUtils.substringBefore(timerValue, "(BST)").trim();
		
		Date objDate = new Date();
		DateFormat objDateFormat = new SimpleDateFormat("HH");
		objDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime = objDateFormat.format(objDate); 
		int int_Hour = Integer.parseInt(txnDateTime)-1;		
		String string_Hours =String.valueOf(int_Hour);  

		reportStep(logger, "Hour ::: "+string_Hours, "PASS");

		Date objDate1 = new Date();
		DateFormat objDateFormat1 = new SimpleDateFormat("mm");
		objDateFormat1.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String txnDateTime1 = objDateFormat1.format(objDate1); 
		int int_Minutes = Integer.parseInt(txnDateTime1)+12;		
		String string_Minutes =String.valueOf(int_Minutes);  

		reportStep(logger, "Minutes ::: "+string_Minutes, "PASS");
		
		set_Expiry_Time(driver, str_Expiry_Time_Scb, string_Hours, string_Minutes);

		reportStep(logger, "Sucessfully set the expiry time", "PASS");

	}

	//*************************************************** Secondary CB Creation *******************************************************************************************
	
	/* Enter Normal Secondary Cashback */
	public Object[] enterNormalSecondaryCashbackDetails(WebDriver driver,int intSCB_GUI_Index, String strSCB_CBType ,int strSCB_CB ,String strSCB_Details, String str_DeviceName, int index) throws InterruptedException {
		
		reportStep(logger, "About to enter Normal Secondary Cashback", "INFO");
		
		this.clickSecondaryCashbackTab(driver);
		this.selectCashbackType(driver,intSCB_GUI_Index,strSCB_CBType);
		this.enterNormalSecondaryCashback(driver,intSCB_GUI_Index,strSCB_CB);
		this.enterNormalSecondaryCashbackDetails(driver,intSCB_GUI_Index,strSCB_Details);	
		this.clickSecondaryCashbackDeviceType(driver, str_DeviceName, index);
		
		reportStep(logger,"Assigning the newly created store normal PCB values into an array", "PASS");
		
		Object[] arrayNewStore_Nor_SCBDetails = new Object[] {intSCB_GUI_Index,strSCB_CBType,strSCB_CB,strSCB_Details};
		
		reportStep(logger, "Successfully entered Normal Secondary Cashback", "PASS");
		
		return arrayNewStore_Nor_SCBDetails;
	}
	
	/* Enter Calendar Secondary Cashback */
	public Object[] enterCalendarSecondaryCashbackDetails(WebDriver driver,int intSCB_GUI_Index,String strSCB_CBType,int strSCB_Cal_CB,String strSCB_Cal_Details,String strCB_Offer_Type, String str_DeviceName, int index) throws InterruptedException {
	
		reportStep(logger, "About to enter Calendar Secondary Cashback", "INFO");
		
		this.selectCalendarCashbackType(driver,intSCB_GUI_Index,strSCB_CBType);
		this.enterCalenderSecondaryCashback(driver,intSCB_GUI_Index,strSCB_Cal_CB);
		this.enterCalendarSecondaryCashbackDetails(driver,intSCB_GUI_Index,strSCB_Cal_Details);
		this.selectCashbackOfferType(driver,intSCB_GUI_Index,strCB_Offer_Type);
		this.setIssueDate_SecondaryCashback_PreviousDayFromCurrentDate(driver,intSCB_GUI_Index);		
		this.setExpiryDate_SecondaryCashback_FourDaysFromCurrentDate(driver,intSCB_GUI_Index);		
		String strNewStore_Iss_DateTime = this.getIssueDate_SecondaryCashback(driver).trim()+"T"+getIssueTime_SecondaryCashback(driver).trim()+"Z";
		String strNewStore_Exp_DateTime = this.getExpiryDate_SecondaryCashback(driver).trim()+"T"+getExpiryTime_SecondaryCashback(driver).trim()+"Z";
		
		reportStep(logger,"Assigning the newly created store normal PCB values into an array", "PASS");
		
		Object[] arrayNewStore_Cal_SCBDetails = new Object[] {intSCB_GUI_Index,strSCB_CBType,strSCB_Cal_CB,strSCB_Cal_Details,strCB_Offer_Type, strNewStore_Iss_DateTime, strNewStore_Exp_DateTime};
		
		reportStep(logger, "Successfully entered Calendar Secondary Cashback", "PASS");
	
		return arrayNewStore_Cal_SCBDetails;
	}
	
	/* Enter Calendar Secondary Cashback */
	public Object[] enterMultipleCalendarSecondaryCashbackDetails(WebDriver driver,int intSCB_GUI_Index,String strSCB_CBType,String strCB_Offer_Type,int strSCB_CB ,int strSCB_Cal_CB,String strSCB_Details, String strSCB_Cal_Details ) throws InterruptedException {
		
		reportStep(logger, "About to enter Calendar Secondary Cashback", "INFO");
		
		this.clickAddAnotherRow(driver);
		this.selectCashbackType(driver,intSCB_GUI_Index,strSCB_CBType);
		this.enterNormalSecondaryCashback(driver,intSCB_GUI_Index,strSCB_CB);
		this.enterNormalSecondaryCashbackDetails(driver,intSCB_GUI_Index,strSCB_Details);
		this.selectCalendarCashbackType(driver,intSCB_GUI_Index,strSCB_CBType);
		this.enterCalenderSecondaryCashback(driver,intSCB_GUI_Index,strSCB_Cal_CB);
		this.enterCalendarSecondaryCashbackDetails(driver,intSCB_GUI_Index,strSCB_Cal_Details);
		this.selectCashbackOfferType(driver,intSCB_GUI_Index,strCB_Offer_Type);
		this.setIssueDate_SecondaryCashback_PreviousDayFromCurrentDate(driver,intSCB_GUI_Index);
		this.setExpiryDate_SecondaryCashback_FourDaysFromCurrentDate(driver,intSCB_GUI_Index);
		
		reportStep(logger,"Assigning the newly created store Calendar Secondary cb values into an array", "PASS");
		
		Object[] arrayNewStore_Mul_Cal_PCBDetails = new Object[] {intSCB_GUI_Index,strSCB_CBType,strSCB_CB,strSCB_Details,strSCB_CBType,strSCB_Cal_CB,strSCB_Cal_Details,strCB_Offer_Type};
		
		reportStep(logger, "Successfully entered Calendar Secondary Cashback", "PASS");
	
		return arrayNewStore_Mul_Cal_PCBDetails;
	}
	
	/* Enter Calendar Secondary Cashback */
	public Object[] enterCalendarSecondaryCashbackDetails_Enhanced(WebDriver driver,int intSCB_GUI_Index,String strSCB_CBType,int strSCB_Cal_CB,String strSCB_Cal_Details,String strCB_Offer_Type, String str_DeviceName, int index) throws InterruptedException {
		
		reportStep(logger, "About to enter Calendar Secondary Cashback", "INFO");
		
		this.selectCalendarCashbackType(driver,intSCB_GUI_Index,strSCB_CBType);
		this.enterCalenderSecondaryCashback(driver,intSCB_GUI_Index,strSCB_Cal_CB);
		this.enterCalendarSecondaryCashbackDetails(driver,intSCB_GUI_Index,strSCB_Cal_Details);
		this.selectCashbackOfferType(driver,intSCB_GUI_Index,strCB_Offer_Type);
		this.setIssueDate_SecondaryCashback_PreviousDayFromCurrentDate(driver,intSCB_GUI_Index);		
		this.setExpireDate_SecondaryCashback_CurrentDate(driver,intSCB_GUI_Index);		
		String strNewStore_Iss_DateTime = this.getIssueDate_SecondaryCashback(driver).trim()+"T"+getIssueTime_SecondaryCashback(driver).trim()+"Z";
		String strNewStore_Exp_DateTime = this.getExpiryDate_SecondaryCashback(driver).trim()+"T"+getExpiryTime_SecondaryCashback(driver).trim()+"Z";
		
		reportStep(logger,"Assigning the newly created store Calendar Secondary cb into an array", "PASS");
		
		Object[] arrayNewStore_Cal_SCBDetails = new Object[] {intSCB_GUI_Index,strSCB_CBType,strSCB_Cal_CB,strSCB_Cal_Details,strCB_Offer_Type, strNewStore_Iss_DateTime, strNewStore_Exp_DateTime};
		
		reportStep(logger, "Successfully entered Calendar Secondary Cashback", "PASS");
	
		return arrayNewStore_Cal_SCBDetails;
	
	}
	
	//*************************************************************************** Cashback Rules Tab ************************************************************************
	
	/* Enter Normal Mobile Cashback Amount / Percentage */
	public int enterNormalMobileCashbackAmountPercentage(WebDriver driver,int intPCB_Mobile_Normal_Cashback) throws InterruptedException {
		
		reportStep(logger, "About to enter store mobile cashback amount/ percent: "+intPCB_Mobile_Normal_Cashback, "INFO");		
		
		if(enterTextByXpath(driver, input_Mobile_Normal_Cashback, intPCB_Mobile_Normal_Cashback)) {

			reportStep(logger, "Successfully entered store mobile cashback amount/ percent: "+intPCB_Mobile_Normal_Cashback, "PASS");
		}else {

			reportStep(logger, "Not able to enter store mobile cashback amount/ percent: "+intPCB_Mobile_Normal_Cashback, "FAIL");
		}
		
		return intPCB_Mobile_Normal_Cashback ;
		
	}
	
	/* Enter Normal App Cashback Amount / Percentage */
	public int enterNormalAppCashbackAmountPercentage(WebDriver driver,int intPCB_App_Normal_Cashback) throws InterruptedException {
		
		reportStep(logger, "About to enter store app cashback amount/ percent: "+intPCB_App_Normal_Cashback, "INFO");		
		
		if(enterTextByXpath(driver, input_App_Normal_Cashback, intPCB_App_Normal_Cashback)) {

			reportStep(logger, "Successfully entered store app cashback amount/ percent: "+intPCB_App_Normal_Cashback, "PASS");
		}else {

			reportStep(logger, "Not able to enter store app cashback amount/ percent: "+intPCB_App_Normal_Cashback, "FAIL");
		}
		
		return intPCB_App_Normal_Cashback ;
		
	}
	
	/* Select Normal Cashback Rule Type */
	public String selectNormalCashbackRuleType(WebDriver driver ,String strPCB_Rules_Type) throws InterruptedException {
		
		reportStep(logger, "About to select dropdown value: "+strPCB_Rules_Type, "INFO");		
		
		if(selectValuesFromDropdown(driver, select_Normal_Cashback_Rules_Type, strPCB_Rules_Type)) {

			reportStep(logger, "Successfully selected dropdown value: "+strPCB_Rules_Type, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value: "+strPCB_Rules_Type, "FAIL");
		}
		
		return strPCB_Rules_Type;
	}
	
	/* Enter Normal Mobile Cashback Amount / Percentage */
	public int enterCalendarMobileCashbackAmountPercentage(WebDriver driver,int intMobile_Calender_Cashback) throws InterruptedException {
		
		reportStep(logger, "About to enter store calendar mobile cashback amount/ percent: "+intMobile_Calender_Cashback, "INFO");		
		
		if(enterTextByXpath(driver, input_Mobile_Calender_Cashback, intMobile_Calender_Cashback)) {

			reportStep(logger, "Successfully entered store calendar mobile cashback amount/ percent: "+intMobile_Calender_Cashback, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar mobile cashback amount/ percent: "+intMobile_Calender_Cashback, "FAIL");
		}
		
		return intMobile_Calender_Cashback ;
		
	}
	
	/* Enter Normal App Cashback Amount / Percentage */
	public int enterCalendarAppCashbackAmountPercentage(WebDriver driver,int intApp_Calender_Cashback) throws InterruptedException {
		
		reportStep(logger, "About to enter store calendar app cashback amount/ percent: "+intApp_Calender_Cashback, "INFO");		
		
		if(enterTextByXpath(driver, input_App_Calender_Cashback, intApp_Calender_Cashback)) {

			reportStep(logger, "Successfully entered store calendar app cashback amount/ percent: "+intApp_Calender_Cashback, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar app cashback amount/ percent: "+intApp_Calender_Cashback, "FAIL");
		}
		
		return intApp_Calender_Cashback ;
		
	}
	
	/* Select Calendar Cashback Rule Type */
	public String selectCalendarCashbackRuleType(WebDriver driver ,String strCalenderCB_Rules_Type) throws InterruptedException {
		
		reportStep(logger, "About to select dropdown value: "+strCalenderCB_Rules_Type, "INFO");		
		
		if(selectValuesFromDropdown(driver, select_Calender_Cashback_Rules_Type, strCalenderCB_Rules_Type)) {

			reportStep(logger, "Successfully selected dropdown value: "+strCalenderCB_Rules_Type, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value: "+strCalenderCB_Rules_Type, "FAIL");
		}
		
		return strCalenderCB_Rules_Type;
	}
	
	//********************************************************************* Minimum Transaction Amount *********************************************************************

	/* Enter Normal Desktop Minimum Transaction Amount */
	public int enterNormalDesktopMinimumTransactionAmount(WebDriver driver,int intPCB_DSK_Min_Transaction_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store normal desktop minimum transaction amount: "+intPCB_DSK_Min_Transaction_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_DSK_Normal_Min_Transaction_Amount, intPCB_DSK_Min_Transaction_Amount)) {

			reportStep(logger, "Successfully entered store normal desktop minimum transaction amount: "+intPCB_DSK_Min_Transaction_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal desktop minimum transaction amount: "+intPCB_DSK_Min_Transaction_Amount, "FAIL");
		}
		
		return intPCB_DSK_Min_Transaction_Amount ;
		
	}
	
	/* Enter Calendar Desktop Minimum Transaction Amount */
	public int enterCalendarDesktopMinimumTransactionAmount(WebDriver driver,int intCalenderCB_DSK_Min_Transaction_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store calendar desktop minimum transaction amount: "+intCalenderCB_DSK_Min_Transaction_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_DSK_Calender_Min_Transaction_Amount, intCalenderCB_DSK_Min_Transaction_Amount)) {

			reportStep(logger, "Successfully entered store calendar desktop minimum transaction amount: "+intCalenderCB_DSK_Min_Transaction_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar desktop minimum transaction amount: "+intCalenderCB_DSK_Min_Transaction_Amount, "FAIL");
		}
		
		return intCalenderCB_DSK_Min_Transaction_Amount ;
		
	}
	
	/* Enter Normal Mobile Tablet Minimum Transaction Amount */
	public int enterNormalMobileTabletMinimumTransactionAmount(WebDriver driver,int intPCB_MOB_Min_Transaction_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store normal mobile/tablet minimum transaction amount: "+intPCB_MOB_Min_Transaction_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_MOB_Normal_Min_Transaction_Amount, intPCB_MOB_Min_Transaction_Amount)) {

			reportStep(logger, "Successfully entered store normal mobile/tablet minimum transaction amount: "+intPCB_MOB_Min_Transaction_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal mobile/tablet minimum transaction amount: "+intPCB_MOB_Min_Transaction_Amount, "FAIL");
		}
		
		return intPCB_MOB_Min_Transaction_Amount ;
		
	}
	
	/* Enter Calendar Mobile Tablet Minimum Transaction Amount */
	public int enterCalenderMobileTabletMinimumTransactionAmount(WebDriver driver,int intCalenderCB_MOB_Min_Transaction_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store calender mobile/tablet minimum transaction amount: "+intCalenderCB_MOB_Min_Transaction_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_MOB_Calender_Min_Transaction_Amount, intCalenderCB_MOB_Min_Transaction_Amount)) {

			reportStep(logger, "Successfully entered store calender mobile/tablet minimum transaction amount: "+intCalenderCB_MOB_Min_Transaction_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calender mobile/tablet minimum transaction amount: "+intCalenderCB_MOB_Min_Transaction_Amount, "FAIL");
		}
		
		return intCalenderCB_MOB_Min_Transaction_Amount ;
		
	}
	
	/* Enter Normal App Minimum Transaction Amount */
	public int enterNormalAppMinimumTransactionAmount(WebDriver driver,int intPCB_APP_Min_Transaction_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store normal app minimum transaction amount: "+intPCB_APP_Min_Transaction_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_APP_Normal_Min_Trans_Amount, intPCB_APP_Min_Transaction_Amount)) {

			reportStep(logger, "Successfully entered store normal app minimum transaction amount: "+intPCB_APP_Min_Transaction_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal app minimum transaction amount: "+intPCB_APP_Min_Transaction_Amount, "FAIL");
		}
		
		return intPCB_APP_Min_Transaction_Amount ;
		
	}
	
	/* Enter Calendar App Minimum Transaction Amount */
	public int enterCalenderAppMinimumTransactionAmount(WebDriver driver,int intCalenderCB_APP_Min_Transaction_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store calender app minimum transaction amount: "+intCalenderCB_APP_Min_Transaction_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_APP_Calender_Minimum_Trans_Amount, intCalenderCB_APP_Min_Transaction_Amount)) {

			reportStep(logger, "Successfully entered store calender app minimum transaction amount: "+intCalenderCB_APP_Min_Transaction_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calender app minimum transaction amount: "+intCalenderCB_APP_Min_Transaction_Amount, "FAIL");
		}
		
		return intCalenderCB_APP_Min_Transaction_Amount ;
		
	}
			
	//********************************************************************* Maximum Cap Amount ****************************************************************************

	/* Enter Normal Desktop Maximum Cap Amount */
	public int enterNormalDesktopMaximumCapAmount(WebDriver driver,int intPCB_DSK_Max_Cap_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store normal desktop maximum cap amount: "+intPCB_DSK_Max_Cap_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_DSK_Normal_Max_Cap_Value, intPCB_DSK_Max_Cap_Amount)) {

			reportStep(logger, "Successfully entered store normal desktop maximum cap amount: "+intPCB_DSK_Max_Cap_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal desktop maximum cap amount: "+intPCB_DSK_Max_Cap_Amount, "FAIL");
		}
		
		return intPCB_DSK_Max_Cap_Amount ;
		
	}
	
	/* Enter Calendar Desktop Maximum Cap Amount */
	public int enterCalendarDesktopMaximumCapAmount(WebDriver driver,int intCalenderCB_DSK_Max_Cap_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store calendar desktop maximum cap amount: "+intCalenderCB_DSK_Max_Cap_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_DSK_Calender_Max_Cap_Value, intCalenderCB_DSK_Max_Cap_Amount)) {

			reportStep(logger, "Successfully entered store calendar desktop maximum cap amount: "+intCalenderCB_DSK_Max_Cap_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar desktop maximum cap amount: "+intCalenderCB_DSK_Max_Cap_Amount, "FAIL");
		}
		
		return intCalenderCB_DSK_Max_Cap_Amount ;
		
	}
	
	/* Enter Normal Mobile Tablet Maximum Cap Amount */
	public int enterNormalMobileTabletMaximumCapAmount(WebDriver driver,int intPCB_MOB_Max_Cap_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store normal mobile/tablet maximum cap amount: "+intPCB_MOB_Max_Cap_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_MOB_Normal_Max_Cap_Value, intPCB_MOB_Max_Cap_Amount)) {

			reportStep(logger, "Successfully entered store normal mobile/tablet maximum cap amount: "+intPCB_MOB_Max_Cap_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal mobile/tablet maximum cap amount: "+intPCB_MOB_Max_Cap_Amount, "FAIL");
		}
		
		return intPCB_MOB_Max_Cap_Amount ;
		
	}
	
	/* Enter Calendar Mobile Tablet Maximum Cap Amount */
	public int enterCalendarMobileTabletMaximumCapAmount(WebDriver driver,int intCalenderCB_MOB_Max_Cap_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store calendar mobile/tablet maximum cap amount: "+intCalenderCB_MOB_Max_Cap_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_MOB_Calender_Max_Cap_Value, intCalenderCB_MOB_Max_Cap_Amount)) {

			reportStep(logger, "Successfully entered store calendar mobile/tablet maximum cap amount: "+intCalenderCB_MOB_Max_Cap_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calendar mobile/tablet maximum cap amount: "+intCalenderCB_MOB_Max_Cap_Amount, "FAIL");
		}
		
		return intCalenderCB_MOB_Max_Cap_Amount ;
		
	}
	
	/* Enter Normal App Maximum Cap Amount */
	public int enterNormalAppMaximumCapAmount(WebDriver driver,int intPCB_APP_Max_Cap_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store normal app maximum cap amount: "+intPCB_APP_Max_Cap_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_APP_Normal_Max_Cap_Value, intPCB_APP_Max_Cap_Amount)) {

			reportStep(logger, "Successfully entered store normal app maximum cap amount: "+intPCB_APP_Max_Cap_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store normal app maximum cap amount: "+intPCB_APP_Max_Cap_Amount, "FAIL");
		}
		
		return intPCB_APP_Max_Cap_Amount ;
		
	}
	
	/* Enter Calendar App Maximum Cap Amount */
	public int enterCalendarAppMaximumCapAmount(WebDriver driver,int intCalenderCB_APP_Max_Cap_Amount) throws InterruptedException {
		
		reportStep(logger, "About to enter store calender app maximum cap amount: "+intCalenderCB_APP_Max_Cap_Amount, "INFO");		
		
		if(enterTextByXpath(driver, input_APP_Calender_Maximum_Cap_Value, intCalenderCB_APP_Max_Cap_Amount)) {

			reportStep(logger, "Successfully entered store calender app maximum cap amount: "+intCalenderCB_APP_Max_Cap_Amount, "PASS");
		}else {

			reportStep(logger, "Not able to enter store calender app maximum cap amount: "+intCalenderCB_APP_Max_Cap_Amount, "FAIL");
		}
		
		return intCalenderCB_APP_Max_Cap_Amount ;
		
	}
		
	//********************************************************************* Grid Commission ******************************************************************************

	/* Click Add/ Remove */
	public void clickDesktopAddRemove(WebDriver driver) throws InterruptedException {
		
		reportStep(logger, "About to click add/ remove button", "INFO");		
		
		if(jsClickByXpath(driver, button_PCB_Add_NewRow_GC_DSK)) {

			reportStep(logger, "Successfully clicked add/ remove button", "PASS");
		}else {

			reportStep(logger, "Not able to click add/ remove button", "FAIL");
		}
		
	}

	/* Enter Start Range */
	public void enterDesktopStartingRange(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range) throws InterruptedException {
		
		String xpath = "//input[@name='desktop_grid_commission["+intPCB_Grid_Com_Index+"][StartRange]']";
		
		reportStep(logger, "About to enter store start range: "+intPCB_Starting_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Starting_Range)) {

			reportStep(logger, "Successfully entered store start range: "+intPCB_Starting_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store start range: "+intPCB_Starting_Range, "FAIL");
		}
		
	}
	
	/* Enter End Range */
	public void enterDesktopEndingRange(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Ending_Range) throws InterruptedException {
		
		String xpath = "//input[@name='desktop_grid_commission["+intPCB_Grid_Com_Index+"][EndRange]']";
		
		reportStep(logger, "About to enter store end range: "+intPCB_Ending_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Ending_Range)) {

			reportStep(logger, "Successfully entered store end range: "+intPCB_Ending_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store end range: "+intPCB_Ending_Range, "FAIL");
		}
	}
	
	/* Enter Cashback Amount/ Percentage */
	public void enterDesktopCashbackAmountPercentage(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Amount_Percentage) throws InterruptedException {
		
		String xpath = "//input[@name='desktop_grid_commission["+intPCB_Grid_Com_Index+"][Cashback]']";
		
		reportStep(logger, "About to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Amount_Percentage)) {

			reportStep(logger, "Successfully entered store cashback amount/ percentage: "+intPCB_Amount_Percentage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "FAIL");
		}
	}
	
	/* Select Cashback Type */
	public void enterDesktopCashbackType(WebDriver driver, int intPCB_Grid_Com_Index, String strPCB_CBType) throws InterruptedException {
		
		String xpath = "//select[@name='desktop_grid_commission["+intPCB_Grid_Com_Index+"][CashbackType]']";
		
		reportStep(logger, "About to select dropdown value: "+strPCB_CBType, "INFO");		
		
		if(selectValuesFromDropdown(driver, xpath, strPCB_CBType)) {

			reportStep(logger, "Successfully selected dropdown value: "+strPCB_CBType, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value: "+strPCB_CBType, "FAIL");
		}
		
	}
	
	/* Enter Start Range */
	public void enterDesktopCalendarStartingRange(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_desktop_grid_commission["+intPCB_Grid_Com_Index+"][StartRange]']";
		
		reportStep(logger, "About to enter store start range: "+intPCB_Starting_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Starting_Range)) {

			reportStep(logger, "Successfully entered store start range: "+intPCB_Starting_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store start range: "+intPCB_Starting_Range, "FAIL");
		}
		
	}
	
	/* Enter End Range */
	public void enterDesktopCalendarEndingRange(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Ending_Range) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_desktop_grid_commission["+intPCB_Grid_Com_Index+"][EndRange]']";
		
		reportStep(logger, "About to enter store end range: "+intPCB_Ending_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Ending_Range)) {

			reportStep(logger, "Successfully entered store end range: "+intPCB_Ending_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store end range: "+intPCB_Ending_Range, "FAIL");
		}
	}
	
	/* Enter Cashback Amount/ Percentage */
	public void enterDesktopCalendarCashbackAmountPercentage(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Amount_Percentage) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_desktop_grid_commission["+intPCB_Grid_Com_Index+"][Cashback]']";
		
		reportStep(logger, "About to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Amount_Percentage)) {

			reportStep(logger, "Successfully entered store cashback amount/ percentage: "+intPCB_Amount_Percentage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "FAIL");
		}
	}
	
	/* Select Cashback Type */
	public void enterDesktopCalendarCashbackType(WebDriver driver, int intPCB_Grid_Com_Index, String strPCB_CBType) throws InterruptedException {
		
		String xpath = "//select[@name='calendar_desktop_grid_commission["+intPCB_Grid_Com_Index+"][CashbackType]']";
		
		reportStep(logger, "About to select dropdown value: "+strPCB_CBType, "INFO");		
		
		if(selectValuesFromDropdown(driver, xpath, strPCB_CBType)) {

			reportStep(logger, "Successfully selected dropdown value: "+strPCB_CBType, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value: "+strPCB_CBType, "FAIL");
		}
		
	}
	
	/* Click Add/ Remove */
	public void clickMobileTabletAddRemove(WebDriver driver) throws InterruptedException {
		
		reportStep(logger, "About to click add/ remove button", "INFO");		
		
		if(jsClickByXpath(driver, button_PCB_Add_NewRow_GC_MOB)) {

			reportStep(logger, "Successfully clicked add/ remove button", "PASS");
		}else {

			reportStep(logger, "Not able to click add/ remove button", "FAIL");
		}
		
	}

	/* Enter Start Range */
	public void enterMobileTabletStartingRange(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range) throws InterruptedException {
		
		String xpath = "//input[@name='mobile_grid_commission["+intPCB_Grid_Com_Index+"][StartRange]']";
		
		reportStep(logger, "About to enter store start range: "+intPCB_Starting_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Starting_Range)) {

			reportStep(logger, "Successfully entered store start range: "+intPCB_Starting_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store start range: "+intPCB_Starting_Range, "FAIL");
		}
		
	}
	
	/* Enter End Range */
	public void enterMobileTabletEndingRange(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Ending_Range) throws InterruptedException {
		
		String xpath = "//input[@name='mobile_grid_commission["+intPCB_Grid_Com_Index+"][EndRange]']";
		
		reportStep(logger, "About to enter store end range: "+intPCB_Ending_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Ending_Range)) {

			reportStep(logger, "Successfully entered store end range: "+intPCB_Ending_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store end range: "+intPCB_Ending_Range, "FAIL");
		}
	}
	
	/* Enter Cashback Amount/ Percentage */
	public void enterMobileTabletCashbackAmountPercentage(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Amount_Percentage) throws InterruptedException {
		
		String xpath = "//input[@name='mobile_grid_commission["+intPCB_Grid_Com_Index+"][Cashback]']";
		
		reportStep(logger, "About to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Amount_Percentage)) {

			reportStep(logger, "Successfully entered store cashback amount/ percentage: "+intPCB_Amount_Percentage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "FAIL");
		}
	}
	
	/* Select Cashback Type */
	public void enterMobileTabletCashbackType(WebDriver driver, int intPCB_Grid_Com_Index, String strPCB_CBType) throws InterruptedException {
		
		String xpath = "//select[@name='mobile_grid_commission["+intPCB_Grid_Com_Index+"][CashbackType]']";
		
		reportStep(logger, "About to select dropdown value: "+strPCB_CBType, "INFO");		
		
		if(selectValuesFromDropdown(driver, xpath, strPCB_CBType)) {

			reportStep(logger, "Successfully selected dropdown value: "+strPCB_CBType, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value: "+strPCB_CBType, "FAIL");
		}
		
	}
	
	/* Enter Start Range */
	public void enterMobileTabletCalendarStartingRange(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_mobile_grid_commission["+intPCB_Grid_Com_Index+"][StartRange]']";
		
		reportStep(logger, "About to enter store start range: "+intPCB_Starting_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Starting_Range)) {

			reportStep(logger, "Successfully entered store start range: "+intPCB_Starting_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store start range: "+intPCB_Starting_Range, "FAIL");
		}
		
	}
	
	/* Enter End Range */
	public void enterMobileTabletCalendarEndingRange(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Ending_Range) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_mobile_grid_commission["+intPCB_Grid_Com_Index+"][EndRange]']";
		
		reportStep(logger, "About to enter store end range: "+intPCB_Ending_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Ending_Range)) {

			reportStep(logger, "Successfully entered store end range: "+intPCB_Ending_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store end range: "+intPCB_Ending_Range, "FAIL");
		}
	}
	
	/* Enter Cashback Amount/ Percentage */
	public void enterMobileTabletCalendarCashbackAmountPercentage(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Amount_Percentage) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_mobile_grid_commission["+intPCB_Grid_Com_Index+"][Cashback]']";
		
		reportStep(logger, "About to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Amount_Percentage)) {

			reportStep(logger, "Successfully entered store cashback amount/ percentage: "+intPCB_Amount_Percentage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "FAIL");
		}
	}
	
	/* Select Cashback Type */
	public void enterMobileTabletCalendarCashbackType(WebDriver driver, int intPCB_Grid_Com_Index, String strPCB_CBType) throws InterruptedException {
		
		String xpath = "//select[@name='calendar_mobile_grid_commission["+intPCB_Grid_Com_Index+"][CashbackType]']";
		
		reportStep(logger, "About to select dropdown value: "+strPCB_CBType, "INFO");		
		
		if(selectValuesFromDropdown(driver, xpath, strPCB_CBType)) {

			reportStep(logger, "Successfully selected dropdown value: "+strPCB_CBType, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value: "+strPCB_CBType, "FAIL");
		}
		
	}

	/* Click Add/ Remove */
	public void clickAppAddRemove(WebDriver driver) throws InterruptedException {
		
		reportStep(logger, "About to click add/ remove button", "INFO");		
		
		if(jsClickByXpath(driver, button_PCB_Add_NewRow_GC_APP)) {

			reportStep(logger, "Successfully clicked add/ remove button", "PASS");
		}else {

			reportStep(logger, "Not able to click add/ remove button", "FAIL");
		}
		
	}

	/* Enter Start Range */
	public void enterAppStartingRange(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range) throws InterruptedException {
		
		String xpath = "//input[@name='app_grid_commission["+intPCB_Grid_Com_Index+"][StartRange]']";
		
		reportStep(logger, "About to enter store start range: "+intPCB_Starting_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Starting_Range)) {

			reportStep(logger, "Successfully entered store start range: "+intPCB_Starting_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store start range: "+intPCB_Starting_Range, "FAIL");
		}
		
	}
	
	/* Enter End Range */
	public void enterAppEndingRange(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Ending_Range) throws InterruptedException {
		
		String xpath = "//input[@name='app_grid_commission["+intPCB_Grid_Com_Index+"][EndRange]']";
		
		reportStep(logger, "About to enter store end range: "+intPCB_Ending_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Ending_Range)) {

			reportStep(logger, "Successfully entered store end range: "+intPCB_Ending_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store end range: "+intPCB_Ending_Range, "FAIL");
		}
	}
	
	/* Enter Cashback Amount/ Percentage */
	public void enterAppCashbackAmountPercentage(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Amount_Percentage) throws InterruptedException {
		
		String xpath = "//input[@name='app_grid_commission["+intPCB_Grid_Com_Index+"][Cashback]']";
		
		reportStep(logger, "About to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Amount_Percentage)) {

			reportStep(logger, "Successfully entered store cashback amount/ percentage: "+intPCB_Amount_Percentage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "FAIL");
		}
	}
	
	/* Select Cashback Type */
	public void enterAppCashbackType(WebDriver driver, int intPCB_Grid_Com_Index, String strPCB_CBType) throws InterruptedException {
		
		String xpath = "//select[@name='app_grid_commission["+intPCB_Grid_Com_Index+"][CashbackType]']";
		
		reportStep(logger, "About to select dropdown value: "+strPCB_CBType, "INFO");		
		
		if(selectValuesFromDropdown(driver, xpath, strPCB_CBType)) {

			reportStep(logger, "Successfully selected dropdown value: "+strPCB_CBType, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value: "+strPCB_CBType, "FAIL");
		}
		
	}
	
	/* Enter Start Range */
	public void enterAppCalendarStartingRange(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_app_grid_commission["+intPCB_Grid_Com_Index+"][StartRange]']";
		
		reportStep(logger, "About to enter store start range: "+intPCB_Starting_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Starting_Range)) {

			reportStep(logger, "Successfully entered store start range: "+intPCB_Starting_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store start range: "+intPCB_Starting_Range, "FAIL");
		}
		
	}
	
	/* Enter End Range */
	public void enterAppCalendarEndingRange(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Ending_Range) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_app_grid_commission["+intPCB_Grid_Com_Index+"][EndRange]']";
		
		reportStep(logger, "About to enter store end range: "+intPCB_Ending_Range, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Ending_Range)) {

			reportStep(logger, "Successfully entered store end range: "+intPCB_Ending_Range, "PASS");
		}else {

			reportStep(logger, "Not able to enter store end range: "+intPCB_Ending_Range, "FAIL");
		}
	}
	
	/* Enter Cashback Amount/ Percentage */
	public void enterAppCalendarCashbackAmountPercentage(WebDriver driver, int intPCB_Grid_Com_Index, int intPCB_Amount_Percentage) throws InterruptedException {
		
		String xpath = "//input[@name='calendar_app_grid_commission["+intPCB_Grid_Com_Index+"][Cashback]']";
		
		reportStep(logger, "About to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "INFO");		
		
		if(enterTextByXpath(driver, xpath, intPCB_Amount_Percentage)) {

			reportStep(logger, "Successfully entered store cashback amount/ percentage: "+intPCB_Amount_Percentage, "PASS");
		}else {

			reportStep(logger, "Not able to enter store cashback amount/ percentage: "+intPCB_Amount_Percentage, "FAIL");
		}
	}
	
	/* Select Cashback Type */
	public void enterAppCalendarCashbackType(WebDriver driver, int intPCB_Grid_Com_Index, String strPCB_CBType) throws InterruptedException {
		
		String xpath = "//select[@name='calendar_app_grid_commission["+intPCB_Grid_Com_Index+"][CashbackType]']";
		
		reportStep(logger, "About to select dropdown value: "+strPCB_CBType, "INFO");		
		
		if(selectValuesFromDropdown(driver, xpath, strPCB_CBType)) {

			reportStep(logger, "Successfully selected dropdown value: "+strPCB_CBType, "PASS");
		}else {

			reportStep(logger, "Not able to select dropdown value: "+strPCB_CBType, "FAIL");
		}
		
	}

	//******************************************************** Normal Desktop Grid Commission *****************************************************************************

	/* Enter Normal Desktop Grid Commision */
	public Object[] enterNormalDesktopGridCommision(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range, int intPCB_Ending_Range , int intPCB_Amount_Percentage , String strPCB_CBType) throws InterruptedException {

		this.enterDesktopStartingRange(driver, intPCB_Grid_Com_Index, intPCB_Starting_Range);
		this.enterDesktopEndingRange(driver, intPCB_Grid_Com_Index, intPCB_Ending_Range);
		this.enterDesktopCashbackAmountPercentage(driver, intPCB_Grid_Com_Index, intPCB_Amount_Percentage);
		this.enterDesktopCashbackType(driver, intPCB_Grid_Com_Index, strPCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into PCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_PCB_DSK_GridCommission = new Object[] {intPCB_Grid_Com_Index,intPCB_Starting_Range,intPCB_Ending_Range,intPCB_Amount_Percentage,strPCB_CBType};
		
		return arrayNewStore_PCB_DSK_GridCommission;
		
	}

	//******************************************************** Calendar Desktop Grid Commission ****************************************************************************

	/* Enter Calendar Desktop Grid Commision */
	public Object[] enterCalendarDesktopGridCommision(WebDriver driver, int intCalenderCB_Grid_Com_Index , int intCalenderCB_Starting_Range, int intCalenderCB_Ending_Range , int intCalenderCB_Amount_Percentage , String strCalenderCB_CBType) throws InterruptedException {

		this.enterDesktopCalendarStartingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Starting_Range);
		this.enterDesktopCalendarEndingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Ending_Range);
		this.enterDesktopCalendarCashbackAmountPercentage(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Amount_Percentage);
		this.enterDesktopCalendarCashbackType(driver, intCalenderCB_Grid_Com_Index, strCalenderCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into CalenderCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_CalenderCB_DSK_GridCommission = new Object[] {intCalenderCB_Grid_Com_Index,intCalenderCB_Starting_Range,intCalenderCB_Ending_Range,intCalenderCB_Amount_Percentage,strCalenderCB_CBType};
		
		return arrayNewStore_CalenderCB_DSK_GridCommission;
		
	}

	//******************************************************** Normal Desktop Grid Commission *****************************************************************************

	/* Enter Multiple Normal Desktop Grid Commision */
	public Object[] enterMultipleNormalDesktopGridCommision(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range, int intPCB_Ending_Range , int intPCB_Amount_Percentage , String strPCB_CBType) throws InterruptedException {
	
		this.clickDesktopAddRemove(driver);
		this.enterDesktopStartingRange(driver, intPCB_Grid_Com_Index, intPCB_Starting_Range);
		this.enterDesktopEndingRange(driver, intPCB_Grid_Com_Index, intPCB_Ending_Range);
		this.enterDesktopCashbackAmountPercentage(driver, intPCB_Grid_Com_Index, intPCB_Amount_Percentage);
		this.enterDesktopCashbackType(driver, intPCB_Grid_Com_Index, strPCB_CBType);

		reportStep(logger,"Successfully set all the respective values into PCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_PCB_DSK_GridCommission_Mul = new Object[] {intPCB_Grid_Com_Index,intPCB_Starting_Range,intPCB_Ending_Range,intPCB_Amount_Percentage,strPCB_CBType};
		
		return arrayNewStore_PCB_DSK_GridCommission_Mul;
		
	}

	//******************************************************** Calendar Desktop Grid Commission ****************************************************************************

	/* Enter Multiple Calendar Desktop Grid Commision */
	public Object[] enterMultipleCalendarDesktopGridCommision(WebDriver driver, int intCalenderCB_Grid_Com_Index , int intCalenderCB_Starting_Range, int intCalenderCB_Ending_Range , int intCalenderCB_Amount_Percentage , String strCalenderCB_CBType) throws InterruptedException {

		this.clickDesktopAddRemove(driver);
		this.enterDesktopCalendarStartingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Starting_Range);
		this.enterDesktopCalendarEndingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Ending_Range);
		this.enterDesktopCalendarCashbackAmountPercentage(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Amount_Percentage);
		this.enterDesktopCalendarCashbackType(driver, intCalenderCB_Grid_Com_Index, strCalenderCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into CalenderCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_CalenderCB_DSK_GridCommission_Mul = new Object[] {intCalenderCB_Grid_Com_Index,intCalenderCB_Starting_Range,intCalenderCB_Ending_Range,intCalenderCB_Amount_Percentage,strCalenderCB_CBType};
		
		return arrayNewStore_CalenderCB_DSK_GridCommission_Mul;
		
	}

	//******************************************************** Normal MobileTablet Grid Commission *****************************************************************************

	/* Enter Normal MobileTablet Grid Commision */
	public Object[] enterNormalMobileTabletGridCommision(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range, int intPCB_Ending_Range , int intPCB_Amount_Percentage , String strPCB_CBType) throws InterruptedException {

		this.enterMobileTabletStartingRange(driver, intPCB_Grid_Com_Index, intPCB_Starting_Range);
		this.enterMobileTabletEndingRange(driver, intPCB_Grid_Com_Index, intPCB_Ending_Range);
		this.enterMobileTabletCashbackAmountPercentage(driver, intPCB_Grid_Com_Index, intPCB_Amount_Percentage);
		this.enterMobileTabletCashbackType(driver, intPCB_Grid_Com_Index, strPCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into PCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_PCB_DSK_GridCommission = new Object[] {intPCB_Grid_Com_Index,intPCB_Starting_Range,intPCB_Ending_Range,intPCB_Amount_Percentage,strPCB_CBType};
		
		return arrayNewStore_PCB_DSK_GridCommission;
		
	}

	//******************************************************** Calendar MobileTablet Grid Commission ****************************************************************************

	/* Enter Calendar MobileTablet Grid Commision */
	public Object[] enterCalendarMobileTabletGridCommision(WebDriver driver, int intCalenderCB_Grid_Com_Index , int intCalenderCB_Starting_Range, int intCalenderCB_Ending_Range , int intCalenderCB_Amount_Percentage , String strCalenderCB_CBType) throws InterruptedException {

		this.enterMobileTabletCalendarStartingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Starting_Range);
		this.enterMobileTabletCalendarEndingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Ending_Range);
		this.enterMobileTabletCalendarCashbackAmountPercentage(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Amount_Percentage);
		this.enterMobileTabletCalendarCashbackType(driver, intCalenderCB_Grid_Com_Index, strCalenderCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into CalenderCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_CalenderCB_DSK_GridCommission = new Object[] {intCalenderCB_Grid_Com_Index,intCalenderCB_Starting_Range,intCalenderCB_Ending_Range,intCalenderCB_Amount_Percentage,strCalenderCB_CBType};
		
		return arrayNewStore_CalenderCB_DSK_GridCommission;
		
	}

	//******************************************************** Normal MobileTablet Grid Commission *****************************************************************************

	/* Enter Multiple Normal MobileTablet Grid Commision */
	public Object[] enterMultipleNormalMobileTabletGridCommision(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range, int intPCB_Ending_Range , int intPCB_Amount_Percentage , String strPCB_CBType) throws InterruptedException {
	
		this.clickMobileTabletAddRemove(driver);
		this.enterMobileTabletStartingRange(driver, intPCB_Grid_Com_Index, intPCB_Starting_Range);
		this.enterMobileTabletEndingRange(driver, intPCB_Grid_Com_Index, intPCB_Ending_Range);
		this.enterMobileTabletCashbackAmountPercentage(driver, intPCB_Grid_Com_Index, intPCB_Amount_Percentage);
		this.enterMobileTabletCashbackType(driver, intPCB_Grid_Com_Index, strPCB_CBType);

		reportStep(logger,"Successfully set all the respective values into PCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_PCB_DSK_GridCommission_Mul = new Object[] {intPCB_Grid_Com_Index,intPCB_Starting_Range,intPCB_Ending_Range,intPCB_Amount_Percentage,strPCB_CBType};
		
		return arrayNewStore_PCB_DSK_GridCommission_Mul;
		
	}

	//******************************************************** Calendar MobileTablet Grid Commission ****************************************************************************

	/* Enter Multiple Calendar MobileTablet Grid Commision */
	public Object[] enterMultipleCalendarMobileTabletGridCommision(WebDriver driver, int intCalenderCB_Grid_Com_Index , int intCalenderCB_Starting_Range, int intCalenderCB_Ending_Range , int intCalenderCB_Amount_Percentage , String strCalenderCB_CBType) throws InterruptedException {

		this.clickMobileTabletAddRemove(driver);
		this.enterMobileTabletCalendarStartingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Starting_Range);
		this.enterMobileTabletCalendarEndingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Ending_Range);
		this.enterMobileTabletCalendarCashbackAmountPercentage(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Amount_Percentage);
		this.enterMobileTabletCalendarCashbackType(driver, intCalenderCB_Grid_Com_Index, strCalenderCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into CalenderCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_CalenderCB_DSK_GridCommission_Mul = new Object[] {intCalenderCB_Grid_Com_Index,intCalenderCB_Starting_Range,intCalenderCB_Ending_Range,intCalenderCB_Amount_Percentage,strCalenderCB_CBType};
		
		return arrayNewStore_CalenderCB_DSK_GridCommission_Mul;
		
	}
	
	//******************************************************** Normal App Grid Commission *****************************************************************************

	/* Enter Normal App Grid Commision */
	public Object[] enterNormalAppGridCommision(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range, int intPCB_Ending_Range , int intPCB_Amount_Percentage , String strPCB_CBType) throws InterruptedException {

		this.enterAppStartingRange(driver, intPCB_Grid_Com_Index, intPCB_Starting_Range);
		this.enterAppEndingRange(driver, intPCB_Grid_Com_Index, intPCB_Ending_Range);
		this.enterAppCashbackAmountPercentage(driver, intPCB_Grid_Com_Index, intPCB_Amount_Percentage);
		this.enterAppCashbackType(driver, intPCB_Grid_Com_Index, strPCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into PCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_PCB_DSK_GridCommission = new Object[] {intPCB_Grid_Com_Index,intPCB_Starting_Range,intPCB_Ending_Range,intPCB_Amount_Percentage,strPCB_CBType};
		
		return arrayNewStore_PCB_DSK_GridCommission;
		
	}

	//******************************************************** Calendar App Grid Commission ****************************************************************************

	/* Enter Calendar App Grid Commision */
	public Object[] enterCalendarAppGridCommision(WebDriver driver, int intCalenderCB_Grid_Com_Index , int intCalenderCB_Starting_Range, int intCalenderCB_Ending_Range , int intCalenderCB_Amount_Percentage , String strCalenderCB_CBType) throws InterruptedException {

		this.enterAppCalendarStartingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Starting_Range);
		this.enterAppCalendarEndingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Ending_Range);
		this.enterAppCalendarCashbackAmountPercentage(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Amount_Percentage);
		this.enterAppCalendarCashbackType(driver, intCalenderCB_Grid_Com_Index, strCalenderCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into CalenderCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_CalenderCB_DSK_GridCommission = new Object[] {intCalenderCB_Grid_Com_Index,intCalenderCB_Starting_Range,intCalenderCB_Ending_Range,intCalenderCB_Amount_Percentage,strCalenderCB_CBType};
		
		return arrayNewStore_CalenderCB_DSK_GridCommission;
		
	}

	//******************************************************** Normal App Grid Commission *****************************************************************************

	/* Enter Multiple Normal App Grid Commision */
	public Object[] enterMultipleNormalAppGridCommision(WebDriver driver, int intPCB_Grid_Com_Index , int intPCB_Starting_Range, int intPCB_Ending_Range , int intPCB_Amount_Percentage , String strPCB_CBType) throws InterruptedException {
	
		this.clickAppAddRemove(driver);
		this.enterAppStartingRange(driver, intPCB_Grid_Com_Index, intPCB_Starting_Range);
		this.enterAppEndingRange(driver, intPCB_Grid_Com_Index, intPCB_Ending_Range);
		this.enterAppCashbackAmountPercentage(driver, intPCB_Grid_Com_Index, intPCB_Amount_Percentage);
		this.enterAppCashbackType(driver, intPCB_Grid_Com_Index, strPCB_CBType);

		reportStep(logger,"Successfully set all the respective values into PCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_PCB_DSK_GridCommission_Mul = new Object[] {intPCB_Grid_Com_Index,intPCB_Starting_Range,intPCB_Ending_Range,intPCB_Amount_Percentage,strPCB_CBType};
		
		return arrayNewStore_PCB_DSK_GridCommission_Mul;
		
	}

	//******************************************************** Calendar App Grid Commission ****************************************************************************

	/* Enter Multiple Calendar App Grid Commision */
	public Object[] enterMultipleCalendarAppGridCommision(WebDriver driver, int intCalenderCB_Grid_Com_Index , int intCalenderCB_Starting_Range, int intCalenderCB_Ending_Range , int intCalenderCB_Amount_Percentage , String strCalenderCB_CBType) throws InterruptedException {

		this.clickAppAddRemove(driver);
		this.enterAppCalendarStartingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Starting_Range);
		this.enterAppCalendarEndingRange(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Ending_Range);
		this.enterAppCalendarCashbackAmountPercentage(driver, intCalenderCB_Grid_Com_Index, intCalenderCB_Amount_Percentage);
		this.enterAppCalendarCashbackType(driver, intCalenderCB_Grid_Com_Index, strCalenderCB_CBType);
		
		reportStep(logger,"Successfully set all the respective values into CalenderCB_DSK_Tab @ Cashback rules tab in AddNewStore", "PASS");
		
		Object[] arrayNewStore_CalenderCB_DSK_GridCommission_Mul = new Object[] {intCalenderCB_Grid_Com_Index,intCalenderCB_Starting_Range,intCalenderCB_Ending_Range,intCalenderCB_Amount_Percentage,strCalenderCB_CBType};
		
		return arrayNewStore_CalenderCB_DSK_GridCommission_Mul;
		
	}
	
	//*************************************************************************** Others Tab **************************************************************************

	/* Enter What You Should Know */
	public String enterWhatYouShouldKnowDetails(WebDriver driver, String strTextToEnter_what_YouShould_Know) throws InterruptedException {
		
		reportStep(logger, "About to enter store What You Should Know: "+strTextToEnter_what_YouShould_Know, "INFO");		
		
		if(enterTextByID(driver, textarea_What_You_Should_Know, strTextToEnter_what_YouShould_Know)) {

			reportStep(logger, "Successfully entered store What You Should Know: "+strTextToEnter_what_YouShould_Know, "PASS");
		}else {

			reportStep(logger, "Not able to enter store What You Should Know: "+strTextToEnter_what_YouShould_Know, "FAIL");
		}
		
		return strTextToEnter_what_YouShould_Know ;
		
	}
		
	/* Enter Manage Contacts */
	public String enterManageContacts(WebDriver driver, String strTextToEnter_Manage_Contacts) throws InterruptedException {
		
		reportStep(logger, "About to enter store Manage Contacts: "+strTextToEnter_Manage_Contacts, "INFO");		
		
		if(enterTextByID(driver, textarea_Manage_Contacts, strTextToEnter_Manage_Contacts)) {

			reportStep(logger, "Successfully entered store Manage Contacts: "+strTextToEnter_Manage_Contacts, "PASS");
		}else {

			reportStep(logger, "Not able to enter store Manage Contacts: "+strTextToEnter_Manage_Contacts, "FAIL");
		}
		
		return strTextToEnter_Manage_Contacts ;
		
	}
	
	/* Enter Admin Notes */
	public String enterAdminNotesDetails(WebDriver driver, String strTextToEnter_Input_Admin_Notes_Details) throws InterruptedException {
		
		reportStep(logger, "About to enter Admin Notes: "+strTextToEnter_Input_Admin_Notes_Details, "INFO");		
		
		if(enterTextByID(driver, textarea_Admin_Notes, strTextToEnter_Input_Admin_Notes_Details)) {

			reportStep(logger, "Successfully entered store Admin Notes: "+strTextToEnter_Input_Admin_Notes_Details, "PASS");
		}else {

			reportStep(logger, "Not able to enter store Admin Notes: "+strTextToEnter_Input_Admin_Notes_Details, "FAIL");
		}
		
		return strTextToEnter_Input_Admin_Notes_Details ;
		
	}

	/* Enter App What You Should Know */
	public String enterAppWhatYouShouldKnowDetails(WebDriver driver, String strTextToEnter_what_YouShould_Know) throws InterruptedException {
		
		reportStep(logger, "About to enter App What You Should Know: "+strTextToEnter_what_YouShould_Know, "INFO");		
		
		if(enterTextByID(driver, textarea_App_What_You_Should_Know, strTextToEnter_what_YouShould_Know)) {

			reportStep(logger, "Successfully entered store App What You Should Know: "+strTextToEnter_what_YouShould_Know, "PASS");
		}else {

			reportStep(logger, "Not able to enter store App What You Should Know: "+strTextToEnter_what_YouShould_Know, "FAIL");
		}
		
		return strTextToEnter_what_YouShould_Know ;
		
	}

	/* Others main method */
	public Object[] enterOthers(WebDriver driver, String strTextToEnter_what_YouShould_Know) throws InterruptedException{
		
		reportStep(logger, "About to create others", "INFO");
		
		this.clickOthersTab(driver);
		String str_newStore_Input_what_YouShould_Know_Details = this.enterWhatYouShouldKnowDetails(driver, strTextToEnter_what_YouShould_Know);
		String str_newStore_Input_App_what_YouShould_Know_Details = this.enterAppWhatYouShouldKnowDetails(driver, strTextToEnter_what_YouShould_Know);
		
		reportStep(logger,"Assigning the newly created store others values into an array", "PASS");
		
		Object[] arrayNewStore_Others_Details = new Object[] {str_newStore_Input_what_YouShould_Know_Details, str_newStore_Input_App_what_YouShould_Know_Details};
		
		reportStep(logger, "Successfully created others", "PASS");
		
		return arrayNewStore_Others_Details;
		
	}
	
	//*************************************************************************** Store Content Tab **************************************************************************

	/* Store content main method */
	public void StoreContent_Creation(WebDriver driver) throws InterruptedException{
		
		reportStep(logger, "About to add store content", "INFO");
		
		this.clickStoreContentTab(driver);

		if(jsClickUsingID(driver, button_View)) {

			reportStep(logger, "Successfully clicked button_View", "PASS");
		}else {

			reportStep(logger, "Not able to click button_View", "FAIL");
		}

		if(jsClickUsingID(driver, button_SourceCode)) {

			reportStep(logger, "Successfully clicked button_SourceCode", "PASS");
		}else {

			reportStep(logger, "Not able to click button_SourceCode", "FAIL");
		}

		if(enterTextByID(driver, text_SourceCode, sourceCode)) {

			reportStep(logger, "Successfully entered store content sourceCode: "+sourceCode, "PASS");
		}else {

			reportStep(logger, "Not able to enter store content sourceCode: "+sourceCode, "FAIL");
		}
		
		if(jsClickUsingID(driver, button_Ok)) {

			reportStep(logger, "Successfully clicked button_Ok", "PASS");
		}else {

			reportStep(logger, "Not able to click button_Ok", "FAIL");
		}
		
	}

	/* Store content main method */
	public String StoreContent_Creation(WebDriver driver, String strTextToEnter_StoreContent) throws InterruptedException{
		
		reportStep(logger, "About to create store content", "INFO");
		
		this.clickStoreContentTab(driver);
		String str_StoreContent = this.newStore_StoreContent_Into_TinyMCE(driver, "This is store content for "+strTextToEnter_StoreContent);
		
		reportStep(logger, "Successfully created store content", "PASS");
		
		return str_StoreContent;
		
	}
	
	/* Enter Store Content */
	public String newStore_StoreContent_Into_TinyMCE(WebDriver driver , String strTextToEnter_StoreContent_Into_TinyMCE) throws InterruptedException {

		enteringText_To_TinyMCE(driver, strTextToEnter_StoreContent_Into_TinyMCE);

		return strTextToEnter_StoreContent_Into_TinyMCE ;
		
	}

	//*************************************************************************************************************************************************************************
	
	public void click_Button_AddStore(WebDriver driver) throws InterruptedException {

		reportStep(logger, "About to click add store button", "INFO");

		if(clickByID(driver, button_Add_Store)) {

			reportStep(logger, "Successfully clicked add store button", "PASS");
		}else {

			reportStep(logger, "Not able to click add store button", "FAIL");
		}

		if(isElementLocatedByIDPresent(driver, message_Successfully_NewStore_Created)) {

			reportStep(logger, "Successfully clicked add store button", "PASS");
		}else {

			reportStep(logger, "Not able to click add store button", "FAIL");
		}
		
		Thread.sleep(2000);

	}

	//*************************************************************************************************************************************************************************
		
}