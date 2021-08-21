package com.rsi.kma.automation.modules;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;

import com.rsi.kma.automation.pageObjects.TripInformationPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class TripInfoModule {


	private static Logger    Log = Logger.getLogger(DrivingActivityModule.class.getName());
	static List <WebElement> webelements=null;
	static List <WebElement> radioButtonselect=null;
	static String FirstTripdate=null;
	static double firstTripTime=0;
	static double firstMiles=0;
	 static int firstDuration=0;
	 static int secondDuration=0;
 
	static String SecondTripdate=null;
	static double secondTripTime=0;
	static int firstTripTags=0;
	static int secondTripTags=0;
	static int mergedTripTags=0;

	static int firstspeed=0;
	static int secondspeed=0;
	static int mergedspeed=0;

	static int totalAlertSecondTrip=0;
	static int totalAlertFirstTrip=0;

	static double secondMiles=0;

	public static void navigateToTripInfoPage(WebDriver driver)
	{

		OverviewModule.NavigateToOverviewPage(driver);

		ActionModule.click(driver,MyCarLeftMenu.tripInformationLink(driver), "tripInformationLink", "Vehicle page");

		Log.info("Succesfully navigated to Trip info Page");


	}

	public static void tripConnected(WebDriver driver)
	{

		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));
		Utils.waitForElementToBeClickableByLocator(driver,By.xpath("//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]") );
		
		if(Utils.waitForElementToBeVisible(driver, TripInformationPage.noTripFound(driver)))
		{
			Log.info("No trip found ");
			throw new SkipException("No trip found ");
		}

		String totalTrips=ActionModule.getText(driver, TripInformationPage.totalTripsText(driver), "totalTrips", "TripInformationPage");
		Log.info("Total trips:"+totalTrips);

		String totalTripsDisplayed=ActionModule.getText(driver, TripInformationPage.totalTrips_DispalyedText(driver), "totalTrips_Dispalyed", "TripInformationPage");
		Log.info("Total trips:"+totalTripsDisplayed);

		Utils.sleep(driver, 3000);
		webelements=FindWebElement.findElementListByXpath(driver, "//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]", "trip dispayed", "trip info");
		int TotalContainers=webelements.size();

		String DisplayedTrips=Integer.toString(TotalContainers);
		Log.info("to be match is :"+DisplayedTrips );
		if(DisplayedTrips.equals(totalTripsDisplayed))
		{
			Log.info("trips matched ");
		}

		if(TotalContainers > 0)
		{
			WebElement firstTrip=webelements.get(0);
			ActionModule.click(driver, firstTrip, "first trip", "trip info");

			Utils.waitForElementToBeVisible(driver, TripInformationPage.FirstTrip.time(driver));

			String date=ActionModule.getText(driver, TripInformationPage.FirstTrip.date(driver), "date", "TripInformationPage");
			Log.info("Trip date is : "+ date);
			String month=ActionModule.getText(driver, TripInformationPage.FirstTrip.month(driver), " month", "TripInformationPage");
			Log.info("month of trip is : "+ month);


			String tripTime=ActionModule.getText(driver, TripInformationPage.FirstTrip.tripTime(driver), "trip time", "TripInformationPage");
			Log.info("Trip time is : "+ tripTime);
			String time=ActionModule.getText(driver, TripInformationPage.FirstTrip.time(driver), " time", "TripInformationPage");
			Log.info("time of trip is : "+ time);

			String miles=ActionModule.getText(driver, TripInformationPage.FirstTrip.miles(driver), "miles", "TripInformationPage");
			Log.info("miles of trip is : "+ miles);
			
			String speed=ActionModule.getText(driver, TripInformationPage.FirstTrip.aveargeSpeed(driver) ,"speed", "TripInformationPage");
			Log.info("speed of trip is : " +speed);


		}
		else
		{
			Log.info("No trip are displayed");

		}


	}

	public static void tripEmbedded(WebDriver driver) {


		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));


		Utils.waitForElementToBeClickableByLocator(driver,By.xpath("//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]") );
		Utils.sleep(driver, 2000);
		
		if(Utils.waitForElementToBeVisible(driver, TripInformationPage.noTripFound(driver)))
		{
			Log.info("No trip found ");
			throw new SkipException("No trip found ");
		}
		
		
		int totalTrips=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.totalTripsText(driver), "totalTrips", "TripInformationPage"));
		Log.info("Total trips:"+totalTrips);

		int totalTripsDisplayed=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.totalTrips_DispalyedText(driver), "totalTrips_Dispalyed", "TripInformationPage"));
		Log.info("Total trips:"+totalTripsDisplayed);

		webelements=FindWebElement.findElementListByXpath(driver, "//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]", "trip dispayed", "trip info");
		int TotalContainers=webelements.size();


		if(totalTrips>totalTripsDisplayed && TotalContainers== totalTripsDisplayed)
		{


			Log.info("Diaplayed trips are more than total trip. ");

			ActionModule.click(driver, TripInformationPage.selectPresetDropDown(driver), "selectPresetDropDown", "TripInformationPage");

			ActionModule.click(driver, TripInformationPage.Last3MonthsDropDown(driver), "Last3MonthsDropDown", "TripInformationPage");

			Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));

			int updatedTotalTripsDisplayed=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.totalTrips_DispalyedText(driver), "totalTrips_Dispalyed", "TripInformationPage"));
			Log.info("Total trips:"+updatedTotalTripsDisplayed);

			if(updatedTotalTripsDisplayed!= totalTripsDisplayed)
			{
				Log.info("No of trips changed");
			}

			else
			{

			}
			Utils.sleep(driver, 2000);
			webelements=FindWebElement.findElementListByXpath(driver, "//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]", "trip dispayed", "trip info");
			WebElement firstTrip=webelements.get(0);
			ActionModule.click(driver, firstTrip, "first trip", "trip info");

			String tripCategory=ActionModule.getText(driver, TripInformationPage.FirstTrip.tripcategory(driver) ,"tripcategory", "TripInformationPage");
			Log.info("tripcategory  is : " +tripCategory);

			Utils.sleep(driver, 2000);
			if(tripCategory.contains("Personal"))
			{
				ActionModule.click(driver, TripInformationPage.FirstTrip.businessToggle(driver), "businessToggle", "TripInformationPage");
				Utils.sleep(driver, 2000);
				tripCategory=ActionModule.getText(driver, TripInformationPage.FirstTrip.tripcategory(driver) ,"tripcategory", "TripInformationPage");
				if(tripCategory.contains("Business"))
				{
					Log.info(" trip category Changed");
				}
				else
				{
					Log.error("trip category could not be Changed");
					Assert.fail("trip category could not be Changed");
				}
			}

			else
			{
				ActionModule.click(driver, TripInformationPage.FirstTrip.personalToggle(driver), "Personal Toggle", "TripInformationPage");
				Utils.sleep(driver, 2000);
				tripCategory=ActionModule.getText(driver, TripInformationPage.FirstTrip.tripcategory(driver) ,"tripcategory", "TripInformationPage");
				if(tripCategory.contains("Personal"))
				{
					Log.info(" trip category Changed");
				}
				else
				{
					Log.error("trip category could not be Changed");
					Assert.fail("trip category could not be Changed");
				}
			}


			ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");
			Utils.waitForElementToBeVisible(driver, TripInformationPage.FirstTrip.tagInputText(driver));

			List <WebElement> deleteTag=FindWebElement.findElementListByXpath(driver,"//a[contains(@ng-click,'deleteTag')]", "deleteTag", "trip info");
			if(deleteTag!=null)
			{
				for(int i=0; i<deleteTag.size(); i++)
				{

					ActionModule.click(driver, deleteTag.get(i), "delete tag", "Trip Information page");

				}
				ActionModule.click(driver, TripInformationPage.FirstTrip.DoneButton(driver), "DoneButton", "TripInformationPage");
				Utils.waitForElementToBeClickable(driver, TripInformationPage.FirstTrip.addTag(driver));

			}
			else
			{
				Log.info("No tags found");
			}

			ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");
			ActionModule.sendKeys(driver, TripInformationPage.FirstTrip.tagInputText(driver), "A1B!", "tagInputText", "");

			Utils.scrolDownForElement(driver,TripInformationPage.FirstTrip.tripTagError(driver) );
			ActionModule.isDisplayed(driver, TripInformationPage.FirstTrip.tripTagError(driver), "tripTagError", "TripInformationPage");

			ActionModule.sendKeys(driver, TripInformationPage.FirstTrip.tagInputText(driver), "A1B7", "tagInputText", "");
			ActionModule.click(driver, TripInformationPage.FirstTrip.DoneButton(driver), "DoneButton", "TripInformationPage");
			ActionModule.isDisplayed(driver, TripInformationPage.FirstTrip.addedTag(driver, "A1B7"), "addedTag", "TripInformationPage");

			//Adding tags
			for(int i=0; i<4; i++)
			{

				String tagname="A1B"+i;
				ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");
				ActionModule.sendKeys(driver, TripInformationPage.FirstTrip.tagInputText(driver), tagname, "tagInputText", "");
				ActionModule.click(driver, TripInformationPage.FirstTrip.DoneButton(driver), "DoneButton", "TripInformationPage");
				Utils.waitForElementToBeVisible(driver,TripInformationPage.FirstTrip.addedTag(driver, tagname));
				ActionModule.isDisplayed(driver, TripInformationPage.FirstTrip.addedTag(driver, tagname), "tripTagError", "TripInformationPage");

			}

			ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");

			//checking status after adding 5 tags 
			String addtagProperty=TripInformationPage.FirstTrip.tagInputText(driver).getAttribute("class");
			if(addtagProperty.contains("disable"))
			{
				Log.info("5 tags are already addedadd tag is now disable.");
			}


			//deleting tags 

			deleteTag=FindWebElement.findElementListByXpath(driver,"//a[contains(@ng-click,'deleteTag')]", "deleteTag", "trip info");
			for(int i=0; i<deleteTag.size(); i++)
			{

				ActionModule.click(driver, deleteTag.get(i), "delete tag", "Trip Information page");

			}

			ActionModule.click(driver, TripInformationPage.FirstTrip.DoneButton(driver), "DoneButton", "TripInformationPage");

			Utils.waitForElementToBeVisible(driver, TripInformationPage.FirstTrip.noTripasignedText(driver));
			Utils.sleep(driver, 2000);
			ActionModule.isDisplayed(driver, TripInformationPage.FirstTrip.noTripasignedText(driver), "DoneButton", "TripInformationPage");

		}



	}

	public static void mergeUnmergeTrips(WebDriver driver) {


		Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));


		Utils.waitForElementToBeClickableByLocator(driver,By.xpath("//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]") );
		Utils.sleep(driver, 5000);
		
		if(Utils.waitForElementToBeVisible(driver, TripInformationPage.noTripFound(driver)))
		{
			Log.info("No trip found ");
			throw new SkipException("No trip found ");
		}
		int totalTripsDisplayed=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.totalTrips_DispalyedText(driver), "totalTrips_Dispalyed", "TripInformationPage"));
		Log.info("Total trips:"+totalTripsDisplayed);
		
		if(totalTripsDisplayed<1)
		{
			Log.info("Not enough trips to merge.");
			throw new SkipException("Not enough trips to merge.");
		}
		

		
		ActionModule.click(driver, TripInformationPage.selectPresetDropDown(driver), "selectPresetDropDown", "TripInformationPage");
		ActionModule.click(driver, TripInformationPage.Last12MonthsDropDown(driver), "Last12MonthsDropDown", "TripInformationPage");

		Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));
		Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]"));
		

		 totalTripsDisplayed=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.totalTrips_DispalyedText(driver), "totalTrips_Dispalyed", "TripInformationPage"));
		Log.info("Total trips:"+totalTripsDisplayed);


		
		
		if(totalTripsDisplayed>1)
		{


			captureFirstTrip(driver);

			captureSecondTrip(driver);

			mergeTrip(driver);

			checkmergeTripDetails(driver);

			UnmergeTrip(driver);

			checkUnmergeTripDetailsI(driver);

			checkUnmergeTripDetailsII(driver);

		}
		else
		{
			throw new SkipException("Not enough trips to merge.");
		}


	}

	public static void  captureFirstTrip(WebDriver driver ) {

		webelements=FindWebElement.findElementListByXpath(driver, "//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]", "trip dispayed", "trip info");

		WebElement firstTrip=webelements.get(0);

		ActionModule.click(driver, firstTrip, "first trip", "trip info");

		FirstTripdate=ActionModule.getText(driver, TripInformationPage.FirstTrip.date(driver), "date", "TripInformationPage");
		Log.info("FirstTripdate is : "+ FirstTripdate);

		String FirstTripmonth=ActionModule.getText(driver, TripInformationPage.FirstTrip.month(driver), " month", "TripInformationPage");
		Log.info("month of Firsttrip is : "+ FirstTripmonth);


		String  FirsttripTime=ActionModule.getText(driver, TripInformationPage.FirstTrip.tripTime(driver), "trip time", "TripInformationPage");
		firstTripTime=tripTime(driver,FirsttripTime);
		Log.info("FirstTrip duration  is : "+ firstTripTime);


		String FirstTripduration=ActionModule.getText(driver, TripInformationPage.FirstTrip.time(driver), " time", "TripInformationPage").trim();
	 
		Log.info("FirstTrip time  is : "+ FirstTripduration);

		Utils.sleep(driver, 4000);

		String FirstTripmiles=ActionModule.getText(driver, TripInformationPage.FirstTrip.miles(driver), "miles", "TripInformationPage");
		firstMiles=TripMiles(driver,FirstTripmiles);
		Log.info("FirstTrip miles  is : "+ firstMiles);

		if(firstMiles >= 1 )
		{
			Utils.sleep(driver, 2000);
			firstspeed=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.FirstTrip.aveargeSpeed(driver) ,"speed", "TripInformationPage").substring(0, 4).replaceAll("[a-zA-Z]", " ").trim());
			Log.info("speed of trip is : " +firstspeed);

		}
		else
		{
			firstspeed=0;
			Log.info("speed could not be captured as miles are less than 1 miles");
		}


		int geofenceAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.geofenceAlertCount(driver) ,"geofenceAlertCount", "TripInformationPage"));
		int speedAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.speedAlertCount(driver) ,"speedAlertCount", "TripInformationPage"));
		int curfewAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.curfewAlertCount(driver) ,"curfewAlertCount", "TripInformationPage"));
		int valetAlert=0;
		if(Utils.getCarName().contains("DE PHEV"))
		{
			 valetAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.curfewAlertCount(driver) ,"curfewAlertCount", "TripInformationPage"));
			
		}
		else
		{
			 valetAlert=0;
		}
		totalAlertFirstTrip=geofenceAlert+speedAlert+curfewAlert+valetAlert;

		Log.info("Total alerts for first trip are : "+totalAlertFirstTrip);

		ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");
		Utils.waitForElementToBeVisible(driver, TripInformationPage.FirstTrip.tagInputText(driver));

		List <WebElement> deleteTag=FindWebElement.findElementListByXpath(driver,"//a[contains(@ng-click,'deleteTag')]", "deleteTag", "trip info");
		if(deleteTag!=null)
		{
			firstTripTags=deleteTag.size();

		}
		else
		{
			firstTripTags=0;
		}



		ActionModule.click(driver, firstTrip, "first trip", "trip info");

	}

	public static void  captureSecondTrip(WebDriver driver ) {

		webelements=FindWebElement.findElementListByXpath(driver, "//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]", "trip dispayed", "trip info");
		
		WebElement secondTrip=webelements.get(1);

		ActionModule.click(driver, secondTrip, "second trip", "trip info");



		SecondTripdate=ActionModule.getText(driver, TripInformationPage.SecondTrip.date(driver), "date", "TripInformationPage");
		Log.info("SecondTripdate is : "+ SecondTripdate);

		String SecondTripmonth=ActionModule.getText(driver, TripInformationPage.SecondTrip.month(driver), " month", "TripInformationPage");
		Log.info("SecondTripmonth is : "+ SecondTripmonth);


		String SecondTripTime=ActionModule.getText(driver, TripInformationPage.SecondTrip.tripTime(driver), "trip time", "TripInformationPage");
		secondTripTime=tripTime(driver,SecondTripTime);
		Log.info("FirstTrip duration  is : "+ secondTripTime);

		String SecondTripduration=ActionModule.getText(driver, TripInformationPage.SecondTrip.time(driver), " time", "TripInformationPage");
		Log.info("SecondTripduration is : "+ SecondTripduration);

		Utils.sleep(driver, 4000);
		String SecondTripmiles=ActionModule.getText(driver, TripInformationPage.SecondTrip.miles(driver), "miles", "TripInformationPage");

		secondMiles=TripMiles(driver,SecondTripmiles);
		Log.info("second trip miles  is : "+ secondMiles);

		if(secondMiles >= 1 )
		{
			Utils.sleep(driver, 2000);
			
			secondspeed=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.SecondTrip.aveargeSpeed(driver) ,"speed", "TripInformationPage").replaceAll("[a-zA-Z]", " ").trim());
			Log.info("speed of trip is : " +secondspeed);
			
		}
		else
		{	
			secondspeed=0;
			Log.info("speed could not be captured as miles are less than 1 miles");
		}



		int geofenceAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.geofenceAlertCount(driver) ,"geofenceAlertCount", "TripInformationPage"));
		int speedAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.speedAlertCount(driver) ,"speedAlertCount", "TripInformationPage"));
		int curfewAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.curfewAlertCount(driver) ,"curfewAlertCount", "TripInformationPage"));
		
		int valetAlert=0;
		if(Utils.getCarName().contains("DE PHEV"))
		{
			 valetAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.curfewAlertCount(driver) ,"curfewAlertCount", "TripInformationPage"));
			
		}
		else
		{
			 valetAlert=0;
		}
		totalAlertSecondTrip=geofenceAlert+speedAlert+curfewAlert+valetAlert;
	

		Log.info("Total alerts for second trip are : "+totalAlertSecondTrip);

		ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");
		Utils.waitForElementToBeVisible(driver, TripInformationPage.FirstTrip.tagInputText(driver));

		List <WebElement> deleteTag=FindWebElement.findElementListByXpath(driver,"//a[contains(@ng-click,'deleteTag')]", "deleteTag", "trip info");
		if(deleteTag!=null)
		{
			secondTripTags=deleteTag.size();

		}
		else
		{
			secondTripTags=0;
		}

		ActionModule.click(driver, secondTrip, "second trip", "trip info");
	}




	public static void  mergeTrip(WebDriver driver ) {

		ActionModule.click(driver, TripInformationPage.ManageButton(driver), "", "");

		radioButtonselect=FindWebElement.findElementListByXpath(driver,"//*[@class='option merge']//*[contains(@ng-click,'selectMerge')]", "trip dispayed", "trip info");
		WebElement FirstRadioButton=radioButtonselect.get(0);


		ActionModule.click(driver, FirstRadioButton, "FirstRadioButton", "trip info");
		Utils.sleep(driver, 2000);

		radioButtonselect=FindWebElement.findElementListByXpath(driver,"//*[@class='option merge']//*[contains(@ng-click,'selectMerge')]", "trip dispayed", "trip info");

		WebElement secondRadioButton=radioButtonselect.get(1);
		ActionModule.click(driver, secondRadioButton, "secondRadioButton", "trip info");

		ActionModule.click(driver, TripInformationPage.MergeTrip(driver), "MergeTrip", "");
		Random randomObj = new Random();

		int randomNum = randomObj.nextInt((2 - 1)) + 1;

		if(Utils.waitForElementToBeClickable(driver, TripInformationPage.mergeTripPopUpPersonal(driver)))
		{
			if(randomNum==1)
				ActionModule.click(driver, TripInformationPage.mergeTripPopUpPersonal(driver), "mergeTripPopUp", "");
			else

				ActionModule.click(driver, TripInformationPage.mergeTripPopUpBusiness(driver), "mergeTripPopUp", "");

		}


		Utils.sleep(driver, 5000);
		Utils.waitForElementToBeClickable(driver, TripInformationPage.ManageButton(driver));

		Utils.waitForElementToBeClickable(driver,TripInformationPage.selectPresetDropDown(driver));
		int totalTripsDisplayedAfter=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.totalTrips_DispalyedText(driver), "totalTrips_Dispalyed", "TripInformationPage"));
		Log.info("Total trips:"+totalTripsDisplayedAfter);


	}



	/**
	 * verifying merged trip data 
	 */

	public static void  checkmergeTripDetails(WebDriver driver ) {

		webelements=FindWebElement.findElementListByXpath(driver, "//*[contains(@class,'tripinfo-container')]//div[contains(@class,'alerts')]/div[contains(@class,'trip')]", "trip dispayed", "trip info");
		WebElement mergedTrip=webelements.get(0);

		String firstTripstatus=mergedTrip.getAttribute("Class");
		Log.info("staus :   "+firstTripstatus);

		if(firstTripstatus.contains("merged"))
		{
			Log.info("Trip has been merged successfully");
		}
		else
		{
			Log.error("Trips could not be merged");
		}

		webelements=FindWebElement.findElementListByXpath(driver, "//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]", "trip dispayed", "trip info");

		mergedTrip=webelements.get(0);

		ActionModule.click(driver, mergedTrip, "merged Trip", "");


		if(SecondTripdate.contains(FirstTripdate))
		{
			String mergedTripdate=ActionModule.getText(driver, TripInformationPage.FirstTrip.date(driver), "date", "TripInformationPage");
			Log.info("Merged Tripdate is : "+ mergedTripdate);
		}
		else
		{

			List <WebElement> mergeStartDate=FindWebElement.findElementListByXpath(driver,"//*[contains(@class,'indicator')]/div[1]/strong", "merge trip date", "trip info");
			WebElement startDate=mergeStartDate.get(0);

			WebElement endDate=null;
			String end=null;
			List <WebElement> mergeEndDate=FindWebElement.findElementListByXpath(driver,"//*[contains(@class,'indicator')]/div[3]/strong", "merge trip date", "trip info");
			if(mergeEndDate!=null && mergeEndDate.size()>0)
			{
			  endDate = mergeEndDate.get(0);
			   end =ActionModule.getText(driver, endDate, "date", "TripInformationPage");
				Log.info("end date is: "+end);
			}

			String start=ActionModule.getText(driver,startDate , "date", "TripInformationPage");
			Log.info("start date is: "+start);

			

			if((start.equals(FirstTripdate) && end.equals(SecondTripdate)) || (start.equals(SecondTripdate) && end.equals(FirstTripdate)))
			{
				Log.info("Start date matched for merged trip");
			}


			else
			{
				Log.error("Start date could not be matched for Merged trip");
				Assert.fail("Start date could not be matched for Merged trip");
			}


		}
		String mergedTripdate=ActionModule.getText(driver, TripInformationPage.FirstTrip.date(driver), "date", "TripInformationPage");
		Log.info("Merged Tripdate is : "+ mergedTripdate);

		String mergedTripmonth=ActionModule.getText(driver, TripInformationPage.FirstTrip.month(driver), " month", "TripInformationPage");
		Log.info("month of Merged  is : "+ mergedTripmonth);


		String mergedTripTime=ActionModule.getText(driver, TripInformationPage.FirstTrip.tripTime(driver), "trip time", "TripInformationPage");
		int mergedTime=tripTime(driver,mergedTripTime);
		Log.info("Merged trip  duration  is : "+ mergedTime);

		String mergedTripduration=ActionModule.getText(driver, TripInformationPage.FirstTrip.time(driver), " time", "TripInformationPage");
		Log.info("Merged trip  duration  is : "+ mergedTripduration);

		Utils.sleep(driver, 2000);
		String mergedTripmiles=ActionModule.getText(driver, TripInformationPage.FirstTrip.miles(driver), "miles", "TripInformationPage");
		
		double mergedMiles=TripMiles(driver,mergedTripmiles);
		Log.info("mergedMiles : "+ mergedMiles);

		
		double totalMiles=precisionConversion(driver,(firstMiles+secondMiles));
		
		Log.info("total miles:"+totalMiles);
		
		double totalTime=firstTripTime+secondTripTime;
		
	
		
		if(mergedMiles==totalMiles || mergedMiles==precisionConversion(driver,(totalMiles+0.1)) || mergedMiles==precisionConversion(driver,(totalMiles-0.1)) || mergedMiles==precisionConversion(driver,(totalMiles+1.0)) || mergedMiles==precisionConversion(driver,(totalMiles-1.0)) )
		{
			Log.info("Miles matched for merged Trip");
		}

		else
		{
			Log.error("Miles could not be matched for merged Trip");
			Assert.fail("Miles could not be matched for merged Trip");
		}

		if(mergedTime==totalTime || mergedTime==(totalTime-1) || mergedTime==totalTime+1)
		{
			Log.info("Merged time matche successfully.");
		}

		else
		{
			Log.error("Merged time could not be matched ");
			Assert.fail("Merged time could not be matched ");

		}

		Log.info("merged speed is : "+ActionModule.getText(driver, TripInformationPage.FirstTrip.aveargeSpeed(driver) ,"speed", "TripInformationPage"));
		mergedspeed = Integer.parseInt(ActionModule.getText(driver, TripInformationPage.FirstTrip.aveargeSpeed(driver) ,"speed", "TripInformationPage").substring(0, 2).trim());
		
		if(firstMiles > 1 && secondMiles > 1) 
		{
			
			
		
			double weight1=(firstTripTime)/(secondTripTime+firstTripTime);
			double weight2=secondTripTime/(secondTripTime+firstTripTime);
			double avrgSpeed1=weight1*firstspeed;
			double avrgSpeed2=weight2*secondspeed;
			
			double totalSpeed=avrgSpeed1+avrgSpeed2;
			int speedToBematched=(int)totalSpeed;
			Log.info("speed to be verified:"+ speedToBematched);
			Log.info("merged speed:"+ mergedspeed);
			if(speedToBematched==mergedspeed ||  mergedspeed==speedToBematched-1 ||  mergedspeed==speedToBematched+1)
			{
				Log.info("Merged Speed matched");
			}
			else
			{
				Log.error("Merged Speed could not be matched");
				Assert.fail("Merged Speed could not be matched");

			}
		}
		else
		{
			Log.info("Average speed could not be verified as trip miles are less than 1");
		}

		int geofenceAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.geofenceAlertCount(driver) ,"geofenceAlertCount", "TripInformationPage"));
		int speedAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.speedAlertCount(driver) ,"speedAlertCount", "TripInformationPage"));
		int curfewAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.curfewAlertCount(driver) ,"curfewAlertCount", "TripInformationPage"));
		
		int valetAlert=0;
		if(Utils.getCarName().contains("DE PHEV"))
		{
			 valetAlert=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.curfewAlertCount(driver) ,"curfewAlertCount", "TripInformationPage"));
			
		}
		else
		{
			 valetAlert=0;
		}
		
		int totalAlertmergedTrip=geofenceAlert+speedAlert+curfewAlert+valetAlert;
		Log.info("Total alerts for merged trip are : "+totalAlertmergedTrip);
		
		int totaladdedTrip=totalAlertFirstTrip+totalAlertSecondTrip;
		Log.info("Total added alerts : "+totaladdedTrip);

		if(totalAlertmergedTrip==totalAlertFirstTrip+totalAlertSecondTrip)
		{
			Log.info("Alerts matched for merged trip");
		}
		else
		{
			Log.error("Alerts could not be matched for merged trip");
			Assert.fail("Alerts could not be matched for merged trip");
		}


		ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");
		Utils.waitForElementToBeVisible(driver, TripInformationPage.FirstTrip.tagInputText(driver));

		List <WebElement> deleteTag=FindWebElement.findElementListByXpath(driver,"//a[contains(@ng-click,'deleteTag')]", "deleteTag", "trip info");
		if(deleteTag!=null)
		{
			mergedTripTags=deleteTag.size();

			if(mergedTripTags==(firstTripTags + secondTripTags) && firstTripTags < 5 &&  secondTripTags < 5 && mergedTripTags<= 5 )
			{
				Log.info("Tags matched");
			}
		}
		else
		{
			mergedTripTags=0;
		}

		ActionModule.click(driver, mergedTrip, "first trip", "trip info");
	}


	public static void UnmergeTrip(WebDriver driver ) {

		Utils.waitForElementToBeClickable(driver, TripInformationPage.ManageButton(driver));

		ActionModule.click(driver, TripInformationPage.ManageButton(driver), "", "");

		/**
		 * UnMerging Trips
		 */

		radioButtonselect=FindWebElement.findElementListByXpath(driver,"//*[@class='option merge']//*[contains(@ng-click,'selectMerge')]", "trip dispayed", "trip info");
		WebElement MergedTrip=radioButtonselect.get(0);
		ActionModule.click(driver, MergedTrip, "MergerTrip radio button", "trip info");
		ActionModule.click(driver, TripInformationPage.UnmergeTrip(driver), "MergerTrip radio button", "trip info");
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, TripInformationPage.ManageButton(driver));

		Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));
	}

	public static void checkUnmergeTripDetailsI(WebDriver driver ) {

		webelements=FindWebElement.findElementListByXpath(driver, "//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]", "trip dispayed", "trip info");

		WebElement firstTrip=webelements.get(0);

		ActionModule.click(driver, firstTrip, "first trip", "trip info");

		String UnmergeTripdate=ActionModule.getText(driver, TripInformationPage.FirstTrip.date(driver), "date", "TripInformationPage");
		Log.info("Unmerged trip date  is: "+ UnmergeTripdate);
		if(FirstTripdate.equals(UnmergeTripdate))
		{
			Log.info("Trip date verified after unmerge");
		}

		String UnmergeTripmonth=ActionModule.getText(driver, TripInformationPage.FirstTrip.month(driver), " month", "TripInformationPage");
		Log.info("Unmerged trip month is : "+ UnmergeTripmonth);


		String  FirsttripTime=ActionModule.getText(driver, TripInformationPage.FirstTrip.tripTime(driver), "trip time", "TripInformationPage");
		int unmergeTripTime=tripTime(driver,FirsttripTime);

		Log.info("unmerged duration  is : "+ unmergeTripTime);
		if(unmergeTripTime==firstTripTime)
		{
			Log.info("Trip time verified after unmerge");
		}

		String mergeTripduration=ActionModule.getText(driver, TripInformationPage.FirstTrip.time(driver), " time", "TripInformationPage");
		Log.info("unmerge trip time  is : "+ mergeTripduration);


		Utils.sleep(driver, 2000);
		String FirstTripmiles=ActionModule.getText(driver, TripInformationPage.FirstTrip.miles(driver), "miles", "TripInformationPage");
		double unmergeMiles=TripMiles(driver,FirstTripmiles);
		Log.info("Unmerge trip miles  is : "+ firstMiles);

		if(firstMiles==unmergeMiles)
		{
			Log.info("Miles verified after unmerge");
		}


		ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");
		Utils.waitForElementToBeVisible(driver, TripInformationPage.FirstTrip.tagInputText(driver));

		List <WebElement> deleteTag=FindWebElement.findElementListByXpath(driver,"//a[contains(@ng-click,'deleteTag')]", "deleteTag", "trip info");
		if(deleteTag!=null)
		{
			int unmergeTripTags=deleteTag.size();
			if(unmergeTripTags==firstTripTags || unmergeTripTags==(firstTripTags+secondTripTags) || unmergeTripTags==5 )
			{
				Log.info("Tags verified for unmerge trip");
			}

		}
		else
		{

			Log.info("No tags found");
		}



	}


	public static void checkUnmergeTripDetailsII(WebDriver driver ) {

		webelements=FindWebElement.findElementListByXpath(driver, "//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]", "trip dispayed", "trip info");

		WebElement secondTrip=webelements.get(1);

		ActionModule.click(driver, secondTrip, "second Trip", "trip info");

		String UnmergeTripdate=ActionModule.getText(driver, TripInformationPage.SecondTrip.date(driver), "date", "TripInformationPage");
		Log.info("Unmerge trip date  is : "+ UnmergeTripdate);
		if(SecondTripdate.equals(UnmergeTripdate))
		{
			Log.info("Trip date verified after unmerge");
		}

		String UnmergeTripmonth=ActionModule.getText(driver, TripInformationPage.SecondTrip.month(driver), " month", "TripInformationPage");
		Log.info("month of Firsttrip is : "+ UnmergeTripmonth);


		String  FirsttripTime=ActionModule.getText(driver, TripInformationPage.SecondTrip.tripTime(driver), "trip time", "TripInformationPage");
		int unmergeTripTime=tripTime(driver,FirsttripTime);
		Log.info("FirstTrip duration  is : "+ unmergeTripTime);
		if(unmergeTripTime==secondTripTime)
		{
			Log.info("Trip time verified after unmerge");
		}

		String mergeTripduration=ActionModule.getText(driver, TripInformationPage.SecondTrip.time(driver), " time", "TripInformationPage");
		Log.info("unmerge trip time  is : "+ mergeTripduration);


		Utils.sleep(driver, 2000);
		String FirstTripmiles=ActionModule.getText(driver, TripInformationPage.SecondTrip.miles(driver), "miles", "TripInformationPage");
		double unmergeMiles=TripMiles(driver,FirstTripmiles);
		Log.info("FirstTrip miles  is : "+ firstMiles);

		if(secondMiles==unmergeMiles)
		{
			Log.info("Miles verified after unmerge");
		}


		ActionModule.click(driver, TripInformationPage.FirstTrip.addTag(driver), "addTag", "TripInformationPage");
		Utils.waitForElementToBeVisible(driver, TripInformationPage.FirstTrip.tagInputText(driver));

		List <WebElement> deleteTag=FindWebElement.findElementListByXpath(driver,"//a[contains(@ng-click,'deleteTag')]", "deleteTag", "trip info");
		if(deleteTag!=null)
		{
			int unmergeTripTags=deleteTag.size();
			if(unmergeTripTags==secondTripTags || unmergeTripTags==(firstTripTags+secondTripTags) || unmergeTripTags==5 )
			{
				Log.info("Tags verified for unmerge trip");
			}

		}
		else
		{

			Log.info("No tags found");
		}

	}



	public static int tripTime(WebDriver driver, String TripTime ) {


		String[] parts = TripTime.split(",");
		String part1 = null;
		String part2=null;

		if ("hours".equalsIgnoreCase(parts[0].substring(parts[0].indexOf(0x68)))) {
			part1 = parts[0].replace("hours", " ").trim();
		} else {
			part1 = parts[0].replace("hour", " ").trim();
		}

		if(parts[1].endsWith("s"))
		{
			part2 = parts[1].replace(" minutes", " ").trim();
		}else{
			part2 = parts[1].replace(" minute", " ").trim(); 
		}

		/* Convert minutes and hours into string type */

		int hours = Integer.parseInt(part1);

		int minutes = Integer.parseInt(part2);

		int totalminutes = (hours * 60) + minutes;
		return totalminutes;

	}



	public static double TripMiles(WebDriver driver, String miles) {



		String firtTripMiles = miles.replace("mi", "").trim();

		Log.info("Trip miles " + firtTripMiles + " is sucessfully captured");

		/* Convert string type into integer */

		double totalmilles = Double.parseDouble(firtTripMiles);

		return totalmilles;

	}
	
	
	public static double precisionConversion(WebDriver driver, double miles) 
		{
	double totalMiles;
	DecimalFormat df = new DecimalFormat("#.#");
	String result=df.format(miles);
	totalMiles=Double.parseDouble(result);
	
	return totalMiles;
		}

	public static void deleteTrip(WebDriver driver) {


		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));


		Utils.waitForElementToBeClickableByLocator(driver,By.xpath("//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]") );
		Utils.sleep(driver, 2000);
		
		if(Utils.waitForElementToBeVisible(driver, TripInformationPage.noTripFound(driver)))
		{
			Log.info("No trip found ");
			throw new SkipException("No trip found ");
		}
		
		ActionModule.click(driver, TripInformationPage.selectPresetDropDown(driver), "selectPresetDropDown", "TripInformationPage");

		ActionModule.click(driver, TripInformationPage.Last12MonthsDropDown(driver), "Last12MonthsDropDown", "TripInformationPage");

		Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));
		Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]"));
		
		int totalTripsDisplayed=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.totalTrips_DispalyedText(driver), "totalTrips_Dispalyed", "TripInformationPage"));
		Log.info("Total trips:"+totalTripsDisplayed);
		
		
		if(totalTripsDisplayed>5)
		{
		Utils.waitForElementToBeClickable(driver, TripInformationPage.ManageButton(driver));

		ActionModule.click(driver, TripInformationPage.ManageButton(driver), "ManageButton", "TripInformationPage");
		
		radioButtonselect=FindWebElement.findElementListByXpath(driver,"//*[@class='option merge']//*[contains(@ng-click,'selectMerge')]", "trip dispayed", "trip info");
		WebElement lastRadioButton=radioButtonselect.get(radioButtonselect.size()-1);
	
		Utils.scrolDownForElement(driver,lastRadioButton );
		
		ActionModule.click(driver, lastRadioButton, "last trip", "TripInformationPage");
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		
		ActionModule.click(driver, TripInformationPage.deleteTrip(driver), "deleteTrip", "TripInformationPage");
		
		ActionModule.click(driver, TripInformationPage.confirmDeleteTrip(driver), "confirmDeleteTrip", "TripInformationPage");
		
		Utils.waitForElementToBeClickable(driver, TripInformationPage.ManageButton(driver));
		
		Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]"));
	
		

		ActionModule.click(driver, TripInformationPage.selectPresetDropDown(driver), "selectPresetDropDown", "TripInformationPage");

		ActionModule.click(driver, TripInformationPage.Last12MonthsDropDown(driver), "Last12MonthsDropDown", "TripInformationPage");

		Utils.waitForElementToBeClickable(driver, TripInformationPage.totalTripContainerText(driver));
		Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[@class='tags']//*[contains(@ng-click,'toggleTripDetail')]"));

		int totalTripsAfterDelete=Integer.parseInt(ActionModule.getText(driver, TripInformationPage.totalTrips_DispalyedText(driver), "totalTrips_Dispalyed", "TripInformationPage"));
		Log.info("Total trips:"+totalTripsAfterDelete);
		
		if(totalTripsAfterDelete==totalTripsDisplayed-1)
		{
			Log.info("Trip successfully deleted");
		}
		else
		{
			Log.error("Trip could not be deleted successfully");
			Assert.fail("Trip could not be deleted successfully");
		}
		
		
	
	}
	else
	{
		Log.info("Not Enough trips to delete ");
		throw new SkipException("Not Enough trips to delete ");
	}

	}
}




