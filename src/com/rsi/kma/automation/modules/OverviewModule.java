package com.rsi.kma.automation.modules;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rsi.kma.automation.pageObjects.AwardsPage;
import com.rsi.kma.automation.pageObjects.BatteryPage;
import com.rsi.kma.automation.pageObjects.ChargingStationsPage;
import com.rsi.kma.automation.pageObjects.ClimateControlPage;
import com.rsi.kma.automation.pageObjects.ConnectPage;
import com.rsi.kma.automation.pageObjects.DrivingActivityPage;
import com.rsi.kma.automation.pageObjects.FindMyCarPage;
import com.rsi.kma.automation.pageObjects.LockUnlockPage;
import com.rsi.kma.automation.pageObjects.MaintenancePage;
import com.rsi.kma.automation.pageObjects.MyPOIsPage;
import com.rsi.kma.automation.pageObjects.RemotePage;
import com.rsi.kma.automation.pageObjects.Common.HeaderPage;
import com.rsi.kma.automation.pageObjects.Common.MyCarLeftMenu;
import com.rsi.kma.automation.pageObjects.Common.MyVehiclesPage;
import com.rsi.kma.automation.pageObjects.Common.OverviewPage;
import com.rsi.kma.automation.utility.FindWebElement;
import com.rsi.kma.automation.utility.Utils;

public class OverviewModule {
	private static Logger    Log = Logger.getLogger(OverviewModule.class.getName());
	
	static String drivingscore;
	static String milesNextService;
	static String drivingScoreToBematch;
	static String mileageToBematch;
	static String milesToBeMatch;
	static String mileage;
	static String lockUnlock,issue;
	static String issueToBeMatch;
	static String url=null;


	public static void NavigateToOverviewPage(WebDriver driver)
	{
		LoginModule.login(driver);	
		Utils.sleep(driver, 2000);
		if(!Utils.getPlatform().equalsIgnoreCase("EV 1.0"))
			ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "Vehicle page");

		else
			ActionModule.click(driver,MyCarLeftMenu.connect_Link(driver), "connect link", "Vehicle page");

		Log.info("navigate_To_OverviewPage has successfully executed");

	}

	public static void OverviewConnected(WebDriver driver)
	{
		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.timestamp(driver, Utils.getCarName()));

		Utils.waitForElementToBeVisible(driver, OverviewPage.DrivingActivity.drivingScore(driver));

		Utils.waitForProgressbarInvisible(driver);

		//capturing values on Overview page
		drivingscore=ActionModule.getText(driver, OverviewPage.DrivingActivity.drivingScore(driver), "drivingscore", "OverviewPage");
		Log.info("Driving Score :"+" "+ drivingscore);

		issue=ActionModule.getText(driver, OverviewPage.Diagnostic.diagnosticIssueText(driver), "diagnosticIssueText", "OverviewPage");
		Log.info("Issue  :"+" "+ issue);

		mileage=ActionModule.getText(driver, OverviewPage.DrivingActivity.mileage(driver), "mileage", "OverviewPage");
		Log.info("Mileage is: "+" "+ mileage);

		milesNextService=ActionModule.getText(driver,OverviewPage.Maintenance.milesNextService(driver), "miles", "OverviewPage");
		Log.info("Miles next service are  :"+ milesNextService);

		ActionModule.click(driver, OverviewPage.DrivingActivity.drivingActivityLink(driver), "", "OverviewPage");

		//capturing values on Driving Activity page 
		Utils.sleep(driver, 2000);
		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeVisible(driver, DrivingActivityPage.DrivingActivityElements.hoursDrivenValue(driver));

		drivingScoreToBematch=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.drivingScoreValue(driver)," drivingScoreValue", "OverviewPage");
		Log.info("drivingScoreToBematch is : "+drivingScoreToBematch);

		Utils.sleep(driver, 3000);

		mileageToBematch=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.mileageValue(driver)," mileageValue", "OverviewPage");
		Log.info("mileageToBematch is : "+mileageToBematch);

		//Comparing values 
		if(drivingScoreToBematch.equalsIgnoreCase(drivingscore) && mileageToBematch.equalsIgnoreCase(mileage))
		{
			Log.info("driving score and mileage matched ");
		}
		else
		{
			Log.error("driving score and mileage not matched ");
			Assert.fail("driving score and mileage not matched");
		}

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "overViewLink", "OverviewPage");

		Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.maintenanceLink(driver));

		ActionModule.click(driver,MyCarLeftMenu.maintenanceLink(driver), "maintenanceLink", "OverviewPage");
		Utils.waitForProgressbarInvisible(driver);

		Utils.sleep(driver, 4000);
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.currentMileage(driver));

		Utils.sleep(driver, 2000);

		milesToBeMatch=ActionModule.getText(driver, MaintenancePage.ServiceSchedule.milesUntilNextService(driver)," drivingScoreValue", "OverviewPage");
		Log.info("milesToBeMatch is :"+ milesToBeMatch);

		if(milesToBeMatch.equalsIgnoreCase(milesNextService))
		{
			Log.info(" milesToBeMatch matched");
		}
		else
		{
			Log.error("miles not matched ");
			Assert.fail("miles not mathed");
		}

		mileageToBematch=ActionModule.getText(driver, MaintenancePage.ServiceSchedule.currentMileage(driver)," mileageValue", "OverviewPage");
		Log.info("mileageToBematch is :"+ mileageToBematch);

		if(mileageToBematch.equalsIgnoreCase(mileage))
		{
			Log.info(" mileage matched ");
		}

		else
		{
			Log.error(" mileage not matched");
			Assert.fail(" mileage not matched");
		}

		issueToBeMatch=ActionModule.getText(driver, MaintenancePage.DiagnosticIssues.numberOfIssues(driver)," mileageValue", "OverviewPage");
		Log.info("issueToBeMatch is :"+ issueToBeMatch);

		if(issue.toLowerCase().contains(issueToBeMatch.toLowerCase()))
		{
			Log.info(" Issues matched ");
		}

		else
		{
			Log.error("issue not matched ");
			Assert.fail(" Issues not matched");
		}



	}


	public static void checkLinksConnected(WebDriver driver )
	{
		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "overViewLink", "OverviewPage");
		Utils.waitForElementToBeVisible(driver, OverviewPage.Diagnostic.diagnosticLink(driver));

		//verifying diagnostic Link
		ActionModule.click(driver,OverviewPage.Diagnostic.diagnosticLink(driver), "diagnosticLink", "OverviewPage");
		Utils.waitForElementToBeVisible(driver, MaintenancePage.ServiceSchedule.currentMileage(driver));
		ActionModule.isDisplayed(driver, MaintenancePage.ServiceSchedule.currentMileage(driver), "mileage", "Maintance");

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.image(driver));

		//verifying POIs Link  
		ActionModule.click(driver,OverviewPage.MyPOIs.myPoiLinkConnected(driver), "myPoiLink", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, MyPOIsPage.addPOI(driver));
		ActionModule.isDisplayed(driver,MyPOIsPage.addPOI(driver), "add poi", "Pois page");

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.image(driver));
		Utils.waitForProgressbarInvisible(driver);

		//verifying Awards Links 
		ActionModule.click(driver,OverviewPage.Awards.awardsLinkConnected(driver), "awardsLink", "OverviewPage");
		ActionModule.isDisplayed(driver,AwardsPage.awardsText(driver), "awardsText", "OverviewPage");
		ActionModule.click(driver,AwardsPage.backButtton(driver), "awardsText", "OverviewPage");

	}


	public static void OverviewEV2(WebDriver driver)
	{

		ActionModule.click(driver,HeaderPage.myVehiclesLink(driver) , "Refresh Icon", "Overview page");

		Utils.waitForElementToBeClickable(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()));

		ActionModule.click(driver,MyVehiclesPage.refreshButton(driver, Utils.getCarName()) , "refreshButton", "Overview page");

		Utils.waitForElementToBeInvisible(driver, MyVehiclesPage.requestingvehicleStatus(driver));

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.timestamp(driver, Utils.getCarName()));

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.batteryStatus(driver, Utils.getCarName()));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));
		
		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));
		
		
		Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//div[contains(@class,'message ng-scope')]"));
		String myVehicleBatteryStatus = ActionModule.getText(driver, MyVehiclesPage.batteryStatusMyVehicle(driver), "My vehicle battery status", "My Vehicle page");
		
		Log.info("batteryStatus is : "+ myVehicleBatteryStatus);
		
		//Fetching month and time from the timestamp on My vehicles page
		String timestamp=ActionModule.getText(driver, MyVehiclesPage.timestamp(driver, Utils.getCarName()), "timestamp", "My Vehicle page");
		String month=timestamp.substring(8,11);
		timestamp=timestamp.substring(timestamp.length()-17,timestamp.length());

		
		//fetching driving range on My Vehicles Page
		String drivingRange=ActionModule.getText(driver, MyVehiclesPage.batteryRange(driver, Utils.getCarName()), "batteryRange", "My Vehicle page").substring(14, 17);
		Log.info(drivingRange);

		ActionModule.click(driver,MyVehiclesPage.nickname(driver, Utils.getCarName()) , "nickname", "Overview page");

		Utils.waitForElementToBeClickable(driver,OverviewPage.VehicleSelector.image(driver));

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "overview link", "Vehicle page");
		Utils.waitForElementToBeVisible(driver, OverviewPage.ECO.State_of_Vehicle.drivingRangeEV2(driver));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));

		//fetching month and time from timestamp on Overview Page
		String timestampToBematch=ActionModule.getText(driver,OverviewPage.VehicleSelector.updatedTimestamp(driver),"updated timestamp","overview page");
		String monthToBematch =timestampToBematch.substring(19, 22);
		timestampToBematch=timestampToBematch.substring(timestampToBematch.length()-17, timestampToBematch.length());

		Log.info("timestampToBematch is : "+timestamp);
		Log.info("monthToBematch is: "+monthToBematch);

		String drivingScore=ActionModule.getText(driver,OverviewPage.DrivingActivity.drivingScore(driver),"drivingScore","overview page");
		Log.info("drivingScoreToBematch is : "+drivingScore);

		
		
		String batteryStatus=ActionModule.getText(driver,OverviewPage.ECO.State_of_Vehicle.batteryPlugIn_Status(driver),"batteryPlugIn_Status","overview page").toLowerCase();
		Log.info("batteryStatus is : "+batteryStatus);
		
		if(batteryStatus.toLowerCase().contains(myVehicleBatteryStatus.toLowerCase()))	
		{
			Log.info(" Overview page battery Status value matches successfully with the status on my vehicle page");
		}
//		else
//		{
//			Log.error(" Overview page battery Status value matches successfully with the status on my vehicle page");
//			Assert.fail(" Overview page battery Status value matches successfully with the status on my vehicle page");
//		}
		
		Utils.sleep(driver, 8000);
		String chargingTimes=ActionModule.getText(driver,OverviewPage.ECO.State_of_Vehicle.chargingTimes(driver),"chargingTimes","overview page");
		

		List<WebElement> webElements= null;
		webElements=FindWebElement.findElementListByXpath(driver,"//*[@id='ev-temperature']/div/div[1]", "Range", "Overview");

		String drivingRangeEV2=ActionModule.getText(driver, webElements.get(1),"batteryRange", "My Vehicle page");
		String drivingRangeToBeMatch=drivingRangeEV2.substring(0,drivingRangeEV2.length()-3);

		
		ActionModule.click(driver,  webElements.get(1), "driving activity link", "Left menu");
		Utils.sleep(driver, 5000);
		Utils.waitForElementToBeClickable(driver,HeaderPage.refresh_Button(driver));

		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));
		

		String batteryStatusToBeMatch=ActionModule.getText(driver,BatteryPage.batteryStatus(driver),"batteryPlugIn_Status","overview page");
		Log.info("batteryStatus To Be match is : "+batteryStatusToBeMatch);
		batteryStatusToBeMatch=batteryStatusToBeMatch.substring(batteryStatusToBeMatch.indexOf("is")+2).trim();
		Log.info("test: "+batteryStatusToBeMatch);
		Log.info(batteryStatus.toLowerCase());
		if(batteryStatus.contains(batteryStatusToBeMatch))	
		{
			Log.info(" batteryStatusToBeMatch Match sccessfully");
		}
		
		
		
		else{
			Log.error("batteryStatusToBeMatch Not Matched");
			Assert.fail("batteryStatusToBeMatch Not matched");
		}
		
		if(Utils.waitForElementToBeVisible(driver, BatteryPage.chargingTime(driver))) {
			
		
			
			String chargingTimesToBeMatch=ActionModule.getText(driver,BatteryPage.chargingTime(driver),"chargingTimes","overview page");
			Log.info("chargingTimes is : "+chargingTimesToBeMatch);

			if(chargingTimesToBeMatch.contains(chargingTimes))	
			{
				Log.info(" chargingTimes Match successfully");
			}
			else
			{
				Log.error("chargingTimes Not Matched");
				Assert.fail("chargingTimes Not matched");
			}
		}
		else if(Utils.waitForElementToBeVisible(driver, BatteryPage.estimatedChargingTime(driver))) {
			
			String chargingTimesToBeMatch= ActionModule.getText(driver,BatteryPage.estimatedChargingTime(driver),"estimated chargingTimes","overview page");
			Log.info("chargingTimes is : "+chargingTimesToBeMatch);
			if(chargingTimesToBeMatch.contains(chargingTimes))	
			{
				Log.info(" chargingTimes Match successfully");
			}
			else
			{
				Log.error("chargingTimes Not Matched");
				Assert.fail("chargingTimes Not matched");
			}
			
		}
		
//		Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//*[contains(text(),'ESTIMATED CHARGE TIME')]/preceding-sibling::span"));
//		String chargingTimesToBeMatch=ActionModule.getText(driver,BatteryPage.chargingTime(driver),"chargingTimes","overview page");
//		Log.info("chargingTimes is : "+chargingTimesToBeMatch);
//		
//		
//		if(chargingTimesToBeMatch.contains(chargingTimes))	
//		{
//			Log.info(" chargingTimes Match sccessfully");
//		}
//		else
//		{
//			Log.error("chargingTimes Not Matched");
//			Assert.fail("chargingTimes Not matched");
//		}
//		
		
		//Comparing values from overview and MyVehicles page
		if(drivingRange.contains(drivingRangeToBeMatch))	
		{
			Log.info(" drivingRange Match sccessfully");
		}
		else
		{
			Log.error("drivingRange Not Matched");
			Assert.fail("drivingRange Not matched");
		}

		if(timestamp.equalsIgnoreCase(timestampToBematch) && month.equalsIgnoreCase(monthToBematch))	
		{
			Log.info("timestamp Match successfully");
		}
		else
		{
			Log.error("timestamp Not Matched");
			Assert.fail(" timestamp Not matched");
		}

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "overview link", "Vehicle page");
		Utils.waitForElementToBeVisible(driver, OverviewPage.ECO.State_of_Vehicle.drivingRangeEV2(driver));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.ECO.DrivingActivity.mileage(driver));

		
		
		
		String mileage=ActionModule.getText(driver, OverviewPage.ECO.DrivingActivity.mileage(driver), "mileage", "OverviewPage");

		String lockunlockStatus = ActionModule.getText(driver,OverviewPage.ECO.State_of_Vehicle.lockunlockstatus(driver),"lock unlock", "My Vehicle page");
		Log.info("vehicle is : "+lockunlockStatus);


		ActionModule.click(driver, MyCarLeftMenu.Remote_Link(driver), "Remote_Link", "Left menu");

		Utils.sleep(driver, 2000);
		Utils.waitForElementToBeClickable(driver, HeaderPage.refresh_Button(driver));
		Utils.waitForElementToBeClickable(driver, RemotePage.Lock_Unlock.lock_Unlock_Tab(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));

		ActionModule.click(driver, RemotePage.Lock_Unlock.lock_Unlock_Tab(driver), "lock unlock", "Left menu");
		Utils.sleep(driver, 2000);

		Utils.waitForElementToBeVisible(driver, RemotePage.Lock_Unlock.lock_Unlock_Status(driver));
		Utils.sleep(driver, 3000);

		String lockUnlock=ActionModule.getText(driver, RemotePage.Lock_Unlock.lock_Unlock_Status(driver), "lock_Unlock_Status", "RemotePage").substring(16);
		Log.info("lockUnlock is : "+lockUnlock);

		//Comparing lockUnlock status
		if(lockUnlock.equalsIgnoreCase(lockunlockStatus))	
		{
			Log.info(" lockUnlock status Match sccessfully");
		}
		else
		{
			Log.error("lockUnlock status not matched ");
			Assert.fail("lockUnlock status not matched ");
		}

		ActionModule.click(driver, MyCarLeftMenu.overViewLink(driver), "overViewLink", "Left menu");

		Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.drivingActivityLink(driver));
		ActionModule.click(driver, MyCarLeftMenu.drivingActivityLink(driver), "drivingActivityLink", "Left menu");

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver,DrivingActivityPage.DrivingActivityElements.mileageValue(driver));

		Utils.sleep(driver, 3000);
		String mileageToBeMatch=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.mileageValue(driver), "mileageValue", "");
		Log.info("mileageToBeMatch is : "+mileageToBeMatch);

		if(mileageToBeMatch.equalsIgnoreCase(mileage))
		{
			Log.info("mileageToBeMatch match successfully");
		}
		else
		{
			Log.error("mileageToBeMatch not match ");
			Assert.fail("mileageToBeMatch not match ");
		}


		String drivingScoreToBeMatch=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.drivingScoreValue(driver), "drivingScoreValue", "drivingScoreValue");
		Log.info("drivingScoreToBeMatch is : "+drivingScoreToBeMatch);


		if(drivingScoreToBeMatch.equalsIgnoreCase(drivingScore))
		{
			Log.info("drivingScoreToBeMatch match successfully");
		}
		else
		{
			Log.error("drivingScoreToBeMatch not match ");
			Assert.fail("drivingScoreToBeMatch not match ");
		}


	}

	public static void checkLinksEV2(WebDriver driver)
	{
		ActionModule.click(driver, MyCarLeftMenu.overViewLink(driver), "overViewLink", "Left menu");

		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeClickable(driver, HeaderPage.refresh_Button(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.ECO.ChargingStations.chargingStationsLink(driver));

		ActionModule.click(driver, OverviewPage.ECO.ChargingStations.chargingStationsLink(driver), "Charging station link", "Overview ");
		Utils.waitForElementToBeClickable(driver, ChargingStationsPage.search_Button(driver));

		ActionModule.isDisplayed(driver, ChargingStationsPage.search_Button(driver), "search_Button", "Overview");


		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.image(driver));

		ActionModule.click(driver,OverviewPage.MyPOIs.myPoiLink(driver), "myPoiLink", "OverviewPage");
		ActionModule.isDisplayed(driver,MyPOIsPage.addPOI(driver), "add poi", "OverviewPage");

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.Awards.awardsLink(driver));

		ActionModule.click(driver,OverviewPage.Awards.awardsLink(driver), "awardsLink", "OverviewPage");

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, AwardsPage.backButtton(driver));

		ActionModule.isDisplayed(driver,AwardsPage.awardsText(driver), "awardsText", "OverviewPage");
		ActionModule.click(driver,AwardsPage.backButtton(driver), "awardsText", "OverviewPage");

		String URL=driver.getCurrentUrl();
		driver.get(URL);
	}


	public static void OverviewEV1(WebDriver driver)
	{

		ActionModule.click(driver,HeaderPage.myVehiclesLink(driver) , "Refresh Icon", "Overview page");

		Utils.waitForElementToBeClickable(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()));

		ActionModule.click(driver,MyVehiclesPage.refreshButton(driver, Utils.getCarName()) , "refreshButton", "Overview page");

		Utils.waitForElementToBeInvisible(driver, MyVehiclesPage.requestingvehicleStatus(driver));

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.timestamp(driver, Utils.getCarName()));

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.batteryStatus(driver, Utils.getCarName()));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));

		//fetching month and time from timestamp on MyVehicle Page
		String timestamp=ActionModule.getText(driver, MyVehiclesPage.timestamp(driver, Utils.getCarName()), "timestamp", "My Vehicle page");
		String month=timestamp.substring(8,11);
		timestamp=timestamp.substring(timestamp.length()-17,timestamp.length());

		String batteryRange=ActionModule.getText(driver, MyVehiclesPage.batteryRange(driver, Utils.getCarName()), "batteryRange", "My Vehicle page");
		Log.info("batteryRange is: "+batteryRange);
		ActionModule.click(driver,MyVehiclesPage.nickname(driver, Utils.getCarName()) , "nickname", "Overview page");

		Utils.waitForElementToBeClickable(driver,OverviewPage.VehicleSelector.image(driver));

		ActionModule.click(driver,MyCarLeftMenu.connect_Link(driver), "connect link", "Vehicle page");
		Utils.waitForElementToBeVisible(driver, OverviewPage.ECO.State_of_Vehicle.batteryRange(driver));


		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));


		//fetching month and time from timestamp on Overview Page
		String timestampToBematch=ActionModule.getText(driver,OverviewPage.VehicleSelector.updatedTimestamp(driver),"updated timestamp","overview page");
		String monthToBematch =timestampToBematch.substring(19, 22);
		timestampToBematch=timestampToBematch.substring(timestampToBematch.length()-17, timestampToBematch.length());

		String batteryrangeTobematched=OverviewPage.ECO.State_of_Vehicle.batteryRange(driver).getAttribute("value");
		Log.info("battery range is "+ batteryrangeTobematched);


		String batteryPercentage=OverviewPage.ECO.State_of_Vehicle.batteryRange(driver).getAttribute("status");
		Log.info("batteryPercentage is "+ batteryPercentage);

		//comparing values from Overview page and other pages
		if(batteryRange.contains(batteryrangeTobematched))	
		{
			Log.info(" batteryRange Match sccessfully");
		}
		else
		{
			Log.error("batteryRange not match ");
			Assert.fail("batteryRange not match ");
		}

		if(timestamp.equalsIgnoreCase(timestampToBematch) && month.equalsIgnoreCase(monthToBematch))	
		{
			Log.info("timestamp Match successfully");
		}
		else
		{
			Log.error("timestamp Not Matched");
			Assert.fail(" timestamp Not matched");
		}
		Utils.sleep(driver, 3000);

		Log.info("Outside Temp : "+ OverviewPage.ECO.State_of_Vehicle.outsideTemperature(driver).getText());

		String lockunlockStatus = OverviewPage.ECO.State_of_Vehicle.lockunlockstatus(driver).getText();
		Log.info("vehicle is :"+lockunlockStatus);


		ActionModule.click(driver, MyCarLeftMenu.battery_Link(driver), "battery", "Left menu");

		Utils.sleep(driver, 5000);
		
		Utils.waitForElementToBeVisible(driver, ConnectPage.batteryRange_In_Miles(driver));

		String batteryPercentageToBeMatched=ConnectPage.batteryRange_In_Miles(driver).getAttribute("status");
		Log.info("batteryPercentageToBeMatched is : "+batteryPercentageToBeMatched);

		String batteryRangeToBeMatch=ConnectPage.batteryRange_In_Miles(driver).getAttribute("value");
		Log.info("batteryRangeToBeMatch is : "+batteryRangeToBeMatch);

		if(batteryRange.contains(batteryRangeToBeMatch))	
		{
			Log.info("batteryRange Match sccessfully");
		}
		else
		{
			Log.error("batteryRange not match ");
			Assert.fail("batteryRange not match ");
		}

		//Fetching and comparing lock unlock status 
		Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.lockUnlock_Link(driver));
		ActionModule.click(driver, MyCarLeftMenu.lockUnlock_Link(driver), "lockUnlock", "Left menu");

		Utils.waitForElementToBeVisible(driver, LockUnlockPage.statusLockUnlock(driver));
		Utils.sleep(driver, 6000);
		String lockstatus=LockUnlockPage.statusLockUnlock(driver).getText();
		Log.info("lockstatus is :"+lockstatus);
		if(lockstatus.equals(lockunlockStatus))
		{
			Log.info("lockstatus matched");
		}
		else
		{
			Log.error("lockstatus not match ");
			Assert.fail("lockstatus not match ");
		}

	}

	public static void checkLinksEV1(WebDriver driver)
	{
		ActionModule.click(driver, MyCarLeftMenu.connect_Link(driver), "connect", "Left menu");
		Utils.sleep(driver, 3000);

		Utils.waitForElementToBeClickable(driver, OverviewPage.DrivingActivity.mileage(driver));
		Utils.waitForElementToBeClickable(driver, OverviewPage.ECO.State_of_Vehicle.outsideTemperature(driver));

		//Verifying find My Car Link
		ActionModule.click(driver, OverviewPage.ECO.State_of_Vehicle.find_My_CarEV1(driver), "find_My_Car", "Overview");
		Utils.waitForElementToBeClickable(driver, FindMyCarPage.updateLocationAndMore(driver));
		Utils.sleep(driver, 10000);
		ActionModule.isDisplayed(driver, FindMyCarPage.updateLocationAndMore(driver), "updateLocationAndMore", "Overview");


		ActionModule.click(driver, MyCarLeftMenu.connect_Link(driver), "connect", "Left menu");
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, OverviewPage.DrivingActivity.mileage(driver));

		//Verifying Charging Stations Link
		ActionModule.click(driver, OverviewPage.ECO.ChargingStations.chargingStationsLinkEV1(driver), "Charging station link", "Overview");
		Utils.sleep(driver, 2000);
		Utils.waitForElementToBeClickable(driver, ChargingStationsPage.search_Button(driver));
		ActionModule.isDisplayed(driver, ChargingStationsPage.search_Button(driver), "search_Button", "Overview");


		ActionModule.click(driver, MyCarLeftMenu.connect_Link(driver), "connect", "Left menu");
		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeClickable(driver, OverviewPage.DrivingActivity.mileage(driver));

		//Verifying Climate Link
		ActionModule.click(driver, OverviewPage.ECO.State_of_Vehicle.climate(driver), "climate", "Overview");
		Utils.waitForElementToBeClickable(driver, ClimateControlPage.TemperatureGauge.outsideTempText(driver));
		ActionModule.isDisplayed(driver,ClimateControlPage.TemperatureGauge.outsideTempText(driver), "outsideTempText", "Overview");

		Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver));
		ActionModule.click(driver, HeaderPage.logOutLink(driver), "logOutLink", "OverviewPage");
	}



	public static void OverviewK900(WebDriver driver)
	{
		Utils.waitForElementToBeVisible(driver, OverviewPage.K900_Overview.Driving_Activity.driving_Score(driver));

		Utils.waitForElementToBeClickable(driver, OverviewPage.K900_Overview.State_of_Vehicle.climate(driver));
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[@id='outside-temp'] | //*[@id='inside-temp']"));

		Utils.sleep(driver, 10000);
		Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//*[contains(@class,'driving-activity')]//*[contains(@class,'value')]"));
		Utils.waitForElementToBeVisible(driver, OverviewPage.K900_Overview.Driving_Activity.driving_Score(driver));

		//Fetching values from Overview Link
		drivingscore=ActionModule.getText(driver, OverviewPage.K900_Overview.Driving_Activity.driving_Score(driver), "drivingscore", "OverviewPage");
		Log.info("Driving Score :"+" "+ drivingscore);

		mileage=ActionModule.getText(driver, OverviewPage.K900_Overview.Driving_Activity.current_Mileage(driver), "mileage", "OverviewPage");
		Log.info("mileage  :"+" "+ mileage);

		milesNextService=ActionModule.getText(driver,OverviewPage.K900_Overview.Maintenance.miles_Until_Next_Service(driver), "miles", "OverviewPage");
		Log.info("milesNextService  :"+" "+ milesNextService);

		lockUnlock=ActionModule.getText(driver,OverviewPage.K900_Overview.State_of_Vehicle.currentCarStatus(driver), "lockUnlock", "OverviewPage");
		Log.info("Car is currently : "+lockUnlock);


		ActionModule.click(driver, MyCarLeftMenu.Remote_Link(driver), "Remote_Link", "Left menu");

		Utils.sleep(driver, 2000);
		Utils.waitForElementToBeClickable(driver, HeaderPage.refresh_Button(driver));
		Utils.waitForElementToBeClickable(driver, RemotePage.Lock_Unlock.lock_Unlock_Tab(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));

		ActionModule.click(driver, RemotePage.Lock_Unlock.lock_Unlock_Tab(driver), "lock unlock", "Left menu");
		Utils.sleep(driver, 2000);
		Utils.waitForElementToBeVisible(driver, RemotePage.Lock_Unlock.lock_Unlock_Status(driver));
		Utils.sleep(driver, 3000);

		String lockUnlockStatus=ActionModule.getText(driver, RemotePage.Lock_Unlock.lock_Unlock_Status(driver), "lock_Unlock_Status", "RemotePage").substring(16);
		Log.info("lockUnlock is : "+lockUnlock);

		//Comparing values on pages 
		if(lockUnlock.equalsIgnoreCase(lockUnlockStatus))	
		{
			Log.info(" lockUnlock status Match sccessfully");
		}
		else
		{
			Log.error("lockUnlock status not matched ");
			Assert.fail("lockUnlock status not matched ");
		}


		ActionModule.click(driver, MyCarLeftMenu.overViewLink(driver), "overViewLink", "OverviewPage");
		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeClickable(driver, OverviewPage.K900_Overview.Diagnostics.diagonsticLink(driver));


		Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.drivingActivityLink(driver));
		ActionModule.click(driver, MyCarLeftMenu.drivingActivityLink(driver), "drivingActivityLink", "Left menu");

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver,DrivingActivityPage.DrivingActivityElements.mileageValue(driver));

		Utils.sleep(driver, 3000);
		String mileageToBeMatch=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.mileageValue(driver), "mileageValue", "");
		Log.info("mileageToBeMatch is : "+mileageToBeMatch);

		if(mileageToBeMatch.equalsIgnoreCase(mileage))
		{
			Log.info("mileageToBeMatch match successfully");
		}
		else
		{
			Log.error("mileageToBeMatch not match ");
			Assert.fail("mileageToBeMatch not match ");
		}


		String drivingScoreToBeMatch=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.drivingScoreValue(driver), "drivingScoreValue", "drivingScoreValue");
		Log.info("drivingScoreToBeMatch is : "+drivingScoreToBeMatch);


		if(drivingScoreToBeMatch.equalsIgnoreCase(drivingscore))
		{
			Log.info("drivingScoreToBeMatch match successfully");
		}
		else
		{
			Log.error("drivingScoreToBeMatch not match ");
			Assert.fail("drivingScoreToBeMatch not match ");
		}

		ActionModule.click(driver, MyCarLeftMenu.overViewLink(driver), "overViewLink", "Left menu");

		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeClickable(driver, HeaderPage.refresh_Button(driver));

		ActionModule.click(driver, OverviewPage.K900_Overview.State_of_Vehicle.find_My_Car(driver), "Charging station link", "Overview ");
		String url=driver.getCurrentUrl();

		if(url.contains("findMyCar"))
		{
			Log.info("successsfully navigated to find my car page");
		}

	}

	public static void checkLinkK900(WebDriver driver)
	{
		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.image(driver));

		ActionModule.click(driver,OverviewPage.K900_Overview.Diagnostics.diagonsticLink(driver), "myPoiLink", "OverviewPage");
		Utils.waitForElementToBeVisible(driver, MaintenancePage.ServiceSchedule.currentMileage(driver));
		ActionModule.isDisplayed(driver,MaintenancePage.ServiceSchedule.currentMileage(driver), "currentMileage", "MaintenancePage");

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.K900_Overview.Awards.awards_link(driver));

		ActionModule.click(driver,OverviewPage.Awards.awardsLink(driver), "awardsLink", "OverviewPage");
		Utils.sleep(driver, 4000);
		ActionModule.isDisplayed(driver,AwardsPage.awardsText(driver), "awardsText", "AwardsPage");
		Utils.waitForElementToBeClickable(driver, AwardsPage.backButtton(driver));
		ActionModule.click(driver,AwardsPage.backButtton(driver), "backButtton", "AwardsPage");


		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.K900_Overview.State_of_Vehicle.climate(driver));

		ActionModule.click(driver, OverviewPage.K900_Overview.State_of_Vehicle.climate(driver), "climate", "OverviewPage");
		Utils.waitForElementToBeClickable(driver,  RemotePage.Lock_Unlock.lock_Unlock_Tab(driver));
		ActionModule.isDisplayed(driver,RemotePage.Lock_Unlock.lock_Unlock_Tab(driver), "lock_Unlock_Tab", "RemotePage");

		Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver));
		ActionModule.click(driver, MyCarLeftMenu.overViewLink(driver), "overViewLink", "Left menu");

		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeClickable(driver, HeaderPage.refresh_Button(driver));

		ActionModule.click(driver, OverviewPage.K900_Overview.State_of_Vehicle.find_My_Car(driver), "Charging station link", "Overview ");
		String url=driver.getCurrentUrl();

		if(url.contains("findMyCar"))
		{
			Log.info("successsfully navigated to find my car page");
		}
		
		
		ActionModule.click(driver, HeaderPage.logOutLink(driver), "logOutLink", "OverviewPage");

		String URL=driver.getCurrentUrl();
		driver.get(URL);
		
		
		
		
	}

	public static void OverviewDEJF(WebDriver driver)
	{

		ActionModule.click(driver,HeaderPage.myVehiclesLink(driver) , "Refresh Icon", "Overview page");

		Utils.waitForElementToBeClickable(driver, MyVehiclesPage.nickname(driver, Utils.getCarName()));

		ActionModule.click(driver,MyVehiclesPage.refreshButton(driver, Utils.getCarName()) , "refreshButton", "Overview page");

		Utils.waitForElementToBeInvisible(driver, MyVehiclesPage.requestingvehicleStatus(driver));

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.timestamp(driver, Utils.getCarName()));

		Utils.waitForElementToBeVisible(driver, MyVehiclesPage.batteryStatus(driver, Utils.getCarName()));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));
		
		
		//fetching month and time from timestamp on MyVehicles Page
		String timestamp=ActionModule.getText(driver, MyVehiclesPage.timestamp(driver, Utils.getCarName()), "timestamp", "My Vehicle page");
		String month=timestamp.substring(0,3);
		timestamp=timestamp.substring(4, timestamp.length());

		Log.info("timestamp is: "+timestamp);
		Log.info("month is: "+month);

		ActionModule.click(driver,MyVehiclesPage.nickname(driver, Utils.getCarName()) , "nickname", "Overview page");

		Utils.waitForElementToBeClickable(driver,OverviewPage.VehicleSelector.image(driver));

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "overview link", "Vehicle page");
		Utils.waitForElementToBeVisible(driver, OverviewPage.ECO.State_of_Vehicle.drivingRangeEV2(driver));

		Utils.waitForElementToBeInvisible(driver, BatteryPage.requestingVehicleStatus(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));

		//fetching month and time from timestamp on Overview Page
		String timestampToBematch=ActionModule.getText(driver,OverviewPage.VehicleSelector.updatedTimestamp(driver),"updated timestamp","overview page");
		String monthToBematch =timestampToBematch.substring(19, 22);
		timestampToBematch=timestampToBematch.substring(timestampToBematch.length()-17, timestampToBematch.length());

		Log.info("timestampToBematch is : "+timestampToBematch);
		Log.info("monthToBematch is: "+monthToBematch);

		Utils.waitForElementToBeVisibleByLocator(driver, By.cssSelector(".overview-diagram-wrapper>div:nth-child(3) div > span[class='spantxt ng-binding']"));
		String batteryStatus=ActionModule.getText(driver,OverviewPage.ECO.State_of_Vehicle.batteryPlugIn_StatusDE(driver),"batteryPlugIn_Status","overview page");
		Log.info("batteryStatus is : "+batteryStatus);
		
		
		Utils.sleep(driver, 8000);
		String chargingTimes=ActionModule.getText(driver,OverviewPage.ECO.State_of_Vehicle.chargingTimes(driver),"chargingTimes","overview page");
		Log.info("chargingTimes is : "+chargingTimes);

		
		String drivingScore=ActionModule.getText(driver,OverviewPage.DrivingActivity.drivingScore(driver),"updated timestamp","overview page");
		Log.info("drivingScore is : "+drivingScore);

		if(timestamp.equalsIgnoreCase(timestampToBematch) && month.equalsIgnoreCase(monthToBematch))	
		{
			Log.info("timestamp Match successfully");
		}
		else
		{
			Log.error("timestamp Not Matched");
			Assert.fail(" timestamp Not matched");
		}

		Utils.waitForElementToBeVisibleByLocator(driver, By.cssSelector(".overview-diagram-wrapper>div:nth-child(3) div[class='combined'] > span:nth-child(2)"));
		String drivingRange = ActionModule.getText(driver,OverviewPage.ECO.State_of_Vehicle.drivingRangeDE(driver),"drivingRangeDE","overview page");
		Log.info("drivingRange is : "+drivingRange);

		
		ActionModule.click(driver, OverviewPage.ECO.State_of_Vehicle.drivingRangeDE(driver), "drivingRangeDE", "OverviewPage");
		Utils.sleep(driver, 5000);
		Utils.waitForElementToBeClickable(driver,HeaderPage.refresh_Button(driver));

		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));
		
		Utils.waitForElementToBeVisibleByLocator(driver, By.xpath("//span[contains(text(),'MAX COMBINED RANGE')]/preceding-sibling::span"));
		String drivingRangeToBeMatch = ActionModule.getText(driver,BatteryPage.drivingRange(driver),"drivingRange","battery page");
		Log.info("Updated driving Range: " + drivingRangeToBeMatch);
		drivingRangeToBeMatch = drivingRangeToBeMatch.replaceAll("\\s+","");
		assertTrue(drivingRangeToBeMatch.contains(drivingRange), "Driving range on battery page is different from overview page");
		String batteryStatusToBeMatch=ActionModule.getText(driver,BatteryPage.batteryStatus(driver),"batteryPlugIn_Status","overview page");
		Log.info("batteryStatus To Be match is : "+batteryStatusToBeMatch);
		if(batteryStatusToBeMatch.toUpperCase().contains("CHARGING")) {
			assertTrue(batteryStatus.toUpperCase().contains("CHARGING"));
		}
		else {
			if(batteryStatusToBeMatch.toUpperCase().contains(batteryStatus))	
			{
				Log.info(" batteryStatusToBeMatch Match successfully");
			}
			/*else
			{
				Log.error("batteryStatusToBeMatch Not Matched");
				Assert.fail("batteryStatusToBeMatch Not matched");
		}*/
		}
		
		if(Utils.waitForElementToBeVisible(driver, BatteryPage.chargingTime(driver))) {
			
		
			
			String chargingTimesToBeMatch=ActionModule.getText(driver,BatteryPage.chargingTime(driver),"chargingTimes","overview page");
			Log.info("chargingTimes is : "+chargingTimesToBeMatch);

			if(chargingTimesToBeMatch.contains(chargingTimes))	
			{
				Log.info(" chargingTimes Match successfully");
			}
			else
			{
				Log.error("chargingTimes Not Matched");
				Assert.fail("chargingTimes Not matched");
			}
		}
		else if(Utils.waitForElementToBeVisible(driver, BatteryPage.estimatedChargingTime(driver))) {
			
			String chargingTimesToBeMatch=ActionModule.getText(driver,BatteryPage.estimatedChargingTime(driver),"estimated chargingTimes","overview page");
			Log.info("chargingTimes is : "+chargingTimesToBeMatch);
			if(chargingTimesToBeMatch.contains(chargingTimes))	
			{
				Log.info(" chargingTimes Match successfully");
			}
			else
			{
				Log.error("chargingTimes Not Matched");
				Assert.fail("chargingTimes Not matched");
			}
			
		}
		
		
		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "Vehicle page");
		
		
		Utils.waitForElementToBeVisibleByLocator(driver, By.id("currMileage"));
		String mileage=ActionModule.getText(driver, OverviewPage.ECO.DrivingActivity.mileage(driver), "mileage", "OverviewPage");

		String lockunlockStatus = ActionModule.getText(driver,OverviewPage.ECO.State_of_Vehicle.lockunlockstatus(driver),"lock unlock", "My Vehicle page");
		Log.info("vehicle is : "+lockunlockStatus);


		ActionModule.click(driver, MyCarLeftMenu.Remote_Link(driver), "Remote_Link", "Left menu");

		Utils.sleep(driver, 2000);
		Utils.waitForElementToBeClickable(driver, HeaderPage.refresh_Button(driver));

		Utils.waitForElementToBeClickable(driver, RemotePage.Lock_Unlock.lock_Unlock_Tab(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.VehicleSelector.updatedTimestamp(driver));

		ActionModule.click(driver, RemotePage.Lock_Unlock.lock_Unlock_Tab(driver), "lock unlock", "Left menu");
		Utils.sleep(driver, 2000);

		Utils.waitForElementToBeVisible(driver, RemotePage.Lock_Unlock.lock_Unlock_Status(driver));
		Utils.sleep(driver, 3000);

		String lockUnlock=ActionModule.getText(driver, RemotePage.Lock_Unlock.lock_Unlock_Status(driver), "lock_Unlock_Status", "RemotePage").substring(16);
		Log.info("lockUnlock is : "+lockUnlock);

		//Comparing values from different pages
		if(lockUnlock.equalsIgnoreCase(lockunlockStatus))	
		{
			Log.info(" lockUnlock status Match sccessfully");
		}
		else
		{
			Log.error("lockUnlock status not matched ");
			Assert.fail("lockUnlock status not matched ");
		}

		ActionModule.click(driver, MyCarLeftMenu.overViewLink(driver), "overViewLink", "Left menu");

		Utils.waitForElementToBeClickable(driver, MyCarLeftMenu.drivingActivityLink(driver));
		ActionModule.click(driver, MyCarLeftMenu.drivingActivityLink(driver), "drivingActivityLink", "Left menu");

		Utils.sleep(driver, 3000);
		Utils.waitForElementToBeVisible(driver,DrivingActivityPage.DrivingActivityElements.mileageValue(driver));

		Utils.sleep(driver, 3000);
		String mileageToBeMatch=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.mileageValue(driver), "mileageValue", "");
		Log.info("mileageToBeMatch is : "+mileageToBeMatch);

		if(mileageToBeMatch.equalsIgnoreCase(mileage))
		{
			Log.info("mileageToBeMatch match successfully");
		}
		else
		{
			Log.error("mileageToBeMatch not match ");
			Assert.fail("mileageToBeMatch not match ");
		}

		String drivingScoreToBeMatch=ActionModule.getText(driver, DrivingActivityPage.DrivingActivityElements.drivingScoreValue(driver), "drivingScoreValue", "drivingScoreValue");
		Log.info("drivingScoreToBeMatch is : "+drivingScoreToBeMatch);


		if(drivingScore.equalsIgnoreCase(drivingScoreToBeMatch))
		{
			Log.info("drivingScoreToBeMatch match successfully");
		}
		else
		{
			Log.error("drivingScoreToBeMatch not match ");
			Assert.fail("drivingScoreToBeMatch not match ");
		}

	}

	public static void checkLinksDEJF(WebDriver driver)
	{
		ActionModule.click(driver, MyCarLeftMenu.overViewLink(driver), "overViewLink", "Left menu");

		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeClickable(driver, HeaderPage.refresh_Button(driver));
		Utils.waitForElementToBeVisible(driver, OverviewPage.ECO.ChargingStations.chargingStationsLinkDE(driver));


		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.Awards.awardsLink(driver));

		//Verifying Awards Link
		ActionModule.click(driver,OverviewPage.Awards.awardsLink(driver), "awardsLink", "OverviewPage");
		Utils.sleep(driver, 4000);
		ActionModule.isDisplayed(driver,AwardsPage.awardsText(driver), "awardsText", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, AwardsPage.backButtton(driver));
		ActionModule.click(driver,AwardsPage.backButtton(driver), "backButtton", "OverviewPage");

		//Verifying Charging Station Link
		ActionModule.click(driver, OverviewPage.ECO.ChargingStations.chargingStationsLinkDE(driver), "Charging station link", "Overview ");
		Utils.waitForElementToBeClickable(driver, ChargingStationsPage.search_Button(driver));
		ActionModule.isDisplayed(driver, ChargingStationsPage.search_Button(driver), "search_Button", "Overview");


		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.image(driver));

		//Verifying Pois Link
		ActionModule.click(driver,OverviewPage.MyPOIs.myPoiLinkDE(driver), "myPoiLink", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, MyPOIsPage.addPOI(driver));
		ActionModule.isDisplayed(driver,MyPOIsPage.addPOI(driver), "add poi", "OverviewPage");

		Utils.waitForElementToBeClickable(driver, HeaderPage.logOutLink(driver));
		

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.image(driver));


		//Verifying remote Link
		ActionModule.click(driver,OverviewPage.ECO.State_of_Vehicle.find_My_Car(driver), "find_My_Car", "OverviewPage");
		String url=driver.getCurrentUrl();

		if(url.contains("findMyCar"))
		{
			Log.info("successsfully navigated to find my car page");
		}

		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.image(driver));
		
		
		//Verifying climate Link
		Utils.waitForElementToBeClickable(driver,OverviewPage.ECO.State_of_Vehicle.outsideTemperatureDE(driver));
		ActionModule.click(driver,OverviewPage.ECO.State_of_Vehicle.outsideTemperatureDE(driver), "outsideTemperature", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, RemotePage.Lock_Unlock.lock_Unlock_Tab(driver));
		ActionModule.isDisplayed(driver, RemotePage.Lock_Unlock.lock_Unlock_Tab(driver), "lock_Unlock_Tab", "remotePage");

		
		ActionModule.click(driver,MyCarLeftMenu.overViewLink(driver), "Overview link", "OverviewPage");
		Utils.waitForElementToBeClickable(driver, OverviewPage.VehicleSelector.image(driver));
		
		Utils.waitForElementToBeClickable(driver,OverviewPage.K900_Overview.Diagnostics.diagonsticLink(driver));
		ActionModule.click(driver,OverviewPage.K900_Overview.Diagnostics.diagonsticLink(driver), "diagnosticLink", "OverviewPage");
		Utils.waitForProgressbarInvisible(driver);
		Utils.waitForElementToBeClickableByLocator(driver, By.xpath("//*[starts-with(@class,'mileage')]/strong"));
		Utils.waitForElementToBeClickable(driver, MaintenancePage.ServiceSchedule.currentMileage(driver));
		ActionModule.isDisplayed(driver, MaintenancePage.ServiceSchedule.currentMileage(driver), "currentMileage", "remotePage");
		
		
		
	}

}
