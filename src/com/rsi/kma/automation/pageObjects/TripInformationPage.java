package com.rsi.kma.automation.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.utility.FindWebElement;


public class TripInformationPage {


	private static WebElement webElement = null;



	public static WebElement totalTripsText(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='alert-msj']/strong[position()=1]","totalTrips","TripInformationPage");

		return webElement;
	}


	public static WebElement totalTripContainerText(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'tripinfo-container')]//div[contains(@class,'alerts')]","totalTrips box","TripInformationPage");

		return webElement;
	}
	
	public static WebElement noTripFound(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(text(),'No Trip info found')]","totalTrips box","noTripFound");

		return webElement;
	}
	
	
	
	

	public static WebElement totalTrips_DispalyedText(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='alert-msj']/strong[position()=2]","totalTrips_Dispalyed","TripInformationPage");

		return webElement;
	}

	
	public static WebElement mergeRadioButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'selectMerge')]","mergeRadioButton","TripInformationPage");

		return webElement;
	}
	
	public static WebElement deleteTrip(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//span[contains(@ng-click,'openConfirmDelete') and text()='DELETE ']","deleteTrip","TripInformationPage");

		return webElement;
	}
	
	
	public static WebElement confirmDeleteTrip(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'confirm')]","confirmDeleteTrip","TripInformationPage");

		return webElement;
	}
	
	
	public static WebElement ManageButton(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//span[contains(@ng-click,'toggleButtons') and @class='button']","ManageButton","TripInformationPage");

		return webElement;
	}
	
	public static WebElement MergeTrip(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'merge-buttons actions')]//*[contains(@ng-click,'mergeTrips')]","MergeTrip","TripInformationPage");

		return webElement;
	}
	
	public static WebElement mergeTripPopUpPersonal(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='confirm-buttons']//*[text()='PERSONAL']","mergeTripPopUpPersonal","TripInformationPage");

		return webElement;
	}
	public static WebElement mergeTripPopUpBusiness(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//*[@class='confirm-buttons']//*[text()='BUSINESS']","mergeTripPopUpBusiness","TripInformationPage");

		return webElement;
	}
	
	public static WebElement UnmergeTrip(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'merge-buttons actions')]//*[contains(@ng-click,'unMergeTrips')]","UnmergeTrip","TripInformationPage");

		return webElement;
	}
	public static WebElement doneMergeUnmerge(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'merge-buttons actions')]//*[contains(@ng-click,'toggleButtons')]","doneMergeUnmerge","TripInformationPage");

		return webElement;
	}
	
	
	public static WebElement geofenceAlertCount(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-mouseleave,'showGeofenceLink')]/p","geofenceAlertCount","TripInformationPage");

		return webElement;
	}
	
	public static WebElement speedAlertCount(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver," //div[contains(@ng-mouseleave,'showSpeedLink')]/p","speedAlertCount","TripInformationPage");

		return webElement;
	}
	
	public static WebElement curfewAlertCount(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-mouseleave,'showCurfewLink')]/p","curfewAlertCount","TripInformationPage");

		return webElement;
	}
	
	public static WebElement valetAlertCount(WebDriver driver) {

		webElement = FindWebElement.byXpath(driver,"//div[contains(@ng-mouseleave,'showValetLink ')]/p","valetAlertCount","TripInformationPage");

		return webElement;
	}
	
	
	
	public static class FirstTrip {
		
		public static WebElement time(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'displaySelectedMonthAndYear')][1]//div[contains(@class,'trip-time')] | //div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][1]//div[contains(@class,'trip-time')]","time","TripInformationPage");

			return webElement;
		}
		
		
		public static WebElement tripTime(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'displaySelectedMonthAndYear')][1]//div[contains(@class,'trip-time')]/span | //div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][1]//div[contains(@class,'trip-time')]/span","tripTime","TripInformationPage");

			return webElement;
		}
		
		public static WebElement month(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'displaySelectedMonthAndYear')][1]//div[contains(@class,'indicator')]//sub | //div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][1]//*[@class='indicator']//*[contains(@class,'month')]","month","TripInformationPage");

			return webElement;
		}
		
		public static WebElement date(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'displaySelectedMonthAndYear')][1]//div[contains(@class,'indicator')]//strong | //div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][1]//*[@class='indicator']//*[contains(@class,'day')]","date","TripInformationPage");

			return webElement;
		}
		
		public static WebElement miles(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[text()='MILES']/following-sibling::div","miles","TripInformationPage");

			return webElement;
		}
		
		public static WebElement aveargeSpeed(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[text()='AVERAGE SPEED']/following-sibling::div","speed","TripInformationPage");

			return webElement;
		}
		public static WebElement addTag(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'edit-btn') and text()='ADD TAG']","addTag","TripInformationPage");

			return webElement;
		}
		public static WebElement tripcategory(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][1]//div[@class='tags']/span","trip Category","TripInformationPage");

			return webElement;
		}
		public static WebElement personalToggle(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'updateTripCategory') and text()='PERSONAL']","personalToggle","TripInformationPage");

			return webElement;
		}
		public static WebElement businessToggle(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'updateTripCategory') and text()='BUSINESS']","Business Toggle","TripInformationPage");

			return webElement;
		}
		
		public static WebElement tagInputText(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-show,'showAddTag ')]//input","tagInputText","TripInformationPage");

			return webElement;
		}
		public static WebElement DoneButton(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-show,'showAddTag ')]//span[text()='DONE']","DoneButton","TripInformationPage");

			return webElement;
		}
		public static WebElement tripTagError(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[@class='trip-tag-error']/span","tripTagError","TripInformationPage");

			return webElement;
		}//Tag must be alphanumeric and not
		
		public static WebElement addedTag(WebDriver driver,String tagname) {


			webElement = FindWebElement.byXpath(driver,
					"//div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][1]//div[@class='tags']/ul/li[text()='"+tagname+"']","addedTag","TripInformationPage");

			return webElement;
		}
		public static WebElement deleteTag(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,
					"//a[contains(@ng-click,'deleteTag')]","deleteTag","TripInformationPage");

			return webElement;
		}
		
		public static WebElement noTripasignedText(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,
					"//div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][1]//span[text()='No tags assigned.' and contains(@ng-if,'tripInfoDetail.tags')]                ","deleteTag","TripInformationPage");

			return webElement;
		}
		
		
	}

	
	public static WebElement selectPresetDropDown(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//*[@class='dropdown preset-search']/button[contains(@ng-click,'datepickerTo') and contains(text(),'Select Preset')] | //div[@class='dropdown preset-search']/button | //*[contains(@class,'btn btn-default dropdown-toggle desktop-search-button calendar-box-border ')]","selectPresetDropDown","TripInformationPage");

		return webElement;
	}
	public static WebElement Last3MonthsDropDown(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//ul[@class='desktop-search-button dropdown-menu']//*[contains(@ng-click,'searchPreset') and text()='LAST 3 MONTHS']","Last 3 MonthsDropDown","TripInformationPage");

		return webElement;
	}
	
	public static WebElement Last12MonthsDropDown(WebDriver driver) {


		webElement = FindWebElement.byXpath(driver,"//ul[@class='desktop-search-button dropdown-menu']//*[contains(@ng-click,'searchPreset') and text()='LAST 12 MONTHS']","Last12MonthsDropDown","TripInformationPage");

		return webElement;
	}
	
	
	public static class SecondTrip {
		
		
		public static WebElement time(WebDriver driver) {

			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'displaySelectedMonthAndYear')][2]//div[contains(@class,'trip-time')] | //div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][2]//div[contains(@class,'trip-time')]","time","TripInformationPage");

			return webElement;
		}
		
		
		public static WebElement tripTime(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'displaySelectedMonthAndYear')][2]//div[contains(@class,'trip-time')]/span | //div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][2]//div[contains(@class,'trip-time')]/span","tripTime","TripInformationPage");

			return webElement;
		}
		
		public static WebElement month(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'displaySelectedMonthAndYear')][2]//div[contains(@class,'indicator')]//sub | //div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][2]//*[@class='indicator']//*[contains(@class,'month')]","month","TripInformationPage");

			return webElement;
		}
		
		public static WebElement date(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-if,'displaySelectedMonthAndYear')][2]//div[contains(@class,'indicator')]//strong | //div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][2]//*[@class='indicator']//*[contains(@class,'day')]","date","TripInformationPage");

			return webElement;
		}
		
		public static WebElement miles(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[text()='MILES']/following-sibling::div","miles","TripInformationPage");

			return webElement;
		}
		
		public static WebElement aveargeSpeed(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[text()='AVERAGE SPEED']/following-sibling::div","speed","TripInformationPage");

			return webElement;
		}
		public static WebElement addTag(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@class,'edit-btn') and text()='ADD TAG']","addTag","TripInformationPage");

			return webElement;
		}
		public static WebElement tripcategory(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][1]//div[@class='tags']/span","trip Category","TripInformationPage");

			return webElement;
		}
		public static WebElement personalToggle(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'updateTripCategory') and text()='PERSONAL']","personalToggle","TripInformationPage");

			return webElement;
		}
		public static WebElement businessToggle(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-click,'updateTripCategory') and text()='BUSINESS']","Business Toggle","TripInformationPage");

			return webElement;
		}
		
		public static WebElement tagInputText(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-show,'showAddTag ')]//input","tagInputText","TripInformationPage");

			return webElement;
		}
		public static WebElement DoneButton(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[contains(@ng-show,'showAddTag ')]//span[text()='DONE']","DoneButton","TripInformationPage");

			return webElement;
		}
		public static WebElement tripTagError(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,"//*[@class='trip-tag-error']/span","tripTagError","TripInformationPage");

			return webElement;
		}//Tag must be alphanumeric and not
		
		public static WebElement addedTag(WebDriver driver,String tagname) {


			webElement = FindWebElement.byXpath(driver,
					"//div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][2]//div[@class='tags']/ul/li[text()='"+tagname+"']","addedTag","TripInformationPage");

			return webElement;
		}
		public static WebElement deleteTag(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,
					"//a[contains(@ng-click,'deleteTag')]","deleteTag","TripInformationPage");

			return webElement;
		}
		
		public static WebElement noTripasignedText(WebDriver driver) {


			webElement = FindWebElement.byXpath(driver,
					"//div[contains(@class,'trip-item') and contains(@ng-class,'tripInfoDetail')][2]//span[text()='No tags assigned.' and contains(@ng-if,'tripInfoDetail.tags')]                ","deleteTag","TripInformationPage");

			return webElement;
		}
		
		
	
		}
	
	public static class POIDetails {
		public static WebElement miles(WebDriver driver,int position) {


			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'item trip-item') and not(contains(@class,'hide'))][position()=" + position
					+ "]//*[@class='title' and text()='MILES']//following-sibling::div","miles","TripInformationPage");


			return webElement;
		}

		public static WebElement averageSpeed(WebDriver driver,String speed) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'item trip-item') and not(contains(@class,'hide'))]//*[starts-with(@class,'value ng-binding') and contains(text(),'"+speed+"')]","averageSpeed","TripInformationPage");

			return webElement;
		}

		public static WebElement tripTime(WebDriver driver,String time) {

			webElement = FindWebElement.byXpath(driver,"//*[starts-with(@class,'item trip-item') and not(contains(@class,'hide'))]//*[starts-with(@class,'value ng-binding') and contains(text(),'"+time+"')]","tripTime","TripInformationPage");

			return webElement;
		}
	}

	
}
